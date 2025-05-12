package tjoeunJSP.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.module.ResolutionException;
import java.util.Collection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import tjoeunJSP.Common;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/fileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding(Common.UTF_8);
		response.setContentType(Common.TEXT_HTML);
		
		PrintWriter out = response.getWriter();

		String uploadPath = "C:/sunflower/fileUpload/";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdirs();
		}

		for (Part part : request.getParts()) {
			String name = part.getName();
			String value = request.getParameter(part.getName());
			out.println(name + ":" + value);
		}

		// 텍스트 파라미터 (name, tilte)
		out.print("<h3>텍스트 파라미터</h3>");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		out.print("<h5>" + name + "</h5>");
		out.print("<h5>" + title + "</h5>");
		out.print("<hr>");

		// 파일 파라미터 (file1, file2)
		// - 파라미터 이름으로 단일 파일 파라미터 가져오기
		Part file1 = request.getPart("file1");
		Part file2 = request.getPart("file2");

		// -모든 파일 파라미터 가져오기
		Collection<Part> parts = request.getParts();
		out.print("파라미터 개수 : " + parts.size() + "<br>");

		int count = 0 ;
		
		for (Part part : parts) {
			String fieldName = part.getName();
			String fileName = part.getSubmittedFileName();

			// 파일 파라미터 확인
			if (null != fileName && !fileName.isEmpty()) {
				out.print("=============================<br>");
				out.print("fieldName : " + fieldName + "<br>");
				out.print("fileName : " + fileName + "<br>");
				count++; 
				
				// 업로드 파일명 지정 (밀리초시간_파일명)
				String uploadedName = System.currentTimeMillis() + "_" + fileName;
				File file = new File(uploadPath, uploadedName);
				// 파일 데이터 입력 + 출력 (파일 저장)
				try (InputStream is = part.getInputStream(); 
						FileOutputStream fos = new FileOutputStream(file);) {
					is.transferTo(fos);
				} catch (Exception e) {
					out.print("파일 저장 시, 에러 발생");
				}

				// 파일 정보
				out.print("-----------------------------<br>");
				out.println("필드 이름 : " + fieldName + "<br>");
				out.println("원본 파일명 : " + fileName + "<br>");
				out.println("저장 파일명 : " + uploadedName + "<br>");
				out.println("타입 : " + part.getContentType() + "<br>");
				out.println("경로 : " + file.getAbsolutePath() + "<br>");
				out.println("크기 : " + file.length() + "<br>");
			}
		}
		
		out.print("파일 개수 : " + count + "<br>");
	}
}
