package contentType;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import test.StaticString;

@WebServlet("/upload")
//파일 업로드 처리를 위한 어노테이션 설정
@MultipartConfig(fileSizeThreshold = 1 * 1024 * 1024 	// 파일 초과 시 임시 메모리
		, maxFileSize = 10 * 1024 * 1024 				// 10MB 파일당 최대 크기
		, maxRequestSize = 50 * 1024 * 1024) 			// 50MB 요청당 최대 크기
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 업로드 경로
		String uploadPath = "C:\\sunflower\\fileUpload";

		// 업로드 폴더가 없으면 폴더 생성
		File uploaddir = new File(uploadPath);
		if (!uploaddir.exists()) {
			uploaddir.mkdir();
		}

		// 제목
		request.setCharacterEncoding(StaticString.UTF_8);
		String title = request.getParameter("title");
		System.out.println("title : " + title);

		// 클라이언트에서 전송한 파일 가져오기
		Part filePart = request.getPart("file");

		// 파일 이름
		Path path = Paths.get(filePart.getSubmittedFileName());
		String fileName = path.getFileName().toString();

		// 업로드할 파일 경로 : C:/fileupload/vkdlf
		String filePath = uploadPath + File.separator // "\\"
				+ UUID.randomUUID().toString() // 랜덤으로 이름 지정(파일명 중복 방지)
				+ "_" + fileName;

		// 파일 저장
		try {
			InputStream is = filePart.getInputStream();
			// Files.copy(입력, 출력)
			long result = Files.copy(is, Paths.get(filePath));
			System.out.println("파일 복사 결과 : " + result);

		} catch (Exception e) {
			// TODO: handle exception
		}

		response.setContentType(StaticString.TEXT_HTML);
		response.setCharacterEncoding(StaticString.UTF_8);
		PrintWriter writer = response.getWriter();
		writer.println("파일 업로드 <br>");
		writer.println("파일 : " + filePath);

	}
}
