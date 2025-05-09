package file;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/img")
public class ImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 다운로드 할 파일명 준비
		String fileName = request.getParameter("fileName");

		// 파일명 유효성 검사
		if (fileName == null || fileName.isEmpty()) {
			// response.getWriter().println("파일명이 올바르지 않습니다.");
			// return;
			System.out.println("파일명이 올바르지 않습니다.");
			fileName = "img1.jpg";
		}

		String downloadDir = "C:\\sunflower\\fileUpload";
		String imgFilePath = downloadDir + File.separator + fileName;

		// 파일명으로부터 이미지 확장자 추출
		// fileName : / path/to/XXX.jpg
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

		// 화장자에 대응하는 Content-Type 지정
		String contentType = "";
		switch (ext) {
		case "jpg":
		case "jpeg":
			contentType = "image/jpeg";
			break;
		case "png":
			contentType = "image/png";
			break;
		case "gif":
			contentType = "image/gif";
			break;
		case "webp":
			contentType = "image/webp";
			break;
		default:
			response.getWriter().println("이미지 형식이 아닙니다.");
			contentType = "image/jpeg";
			System.out.println("이미지 형식이 아닙니다.");
			// return; 
		}
		// 응답 헤더 설정
		response.setContentType(contentType);
		// 파일 존재 여부 확인
		File file = new File(imgFilePath);
		if (!file.exists()) {
			// response.getWriter().println("파일이 존재하지 않습니다.");
			// return ;
			// 응답 헤더 설정
			response.setContentType("image/jpeg");
			fileName = "img1.jpg";
			imgFilePath = downloadDir + File.separator + fileName;
			file = new File(imgFilePath);
			System.out.println("파일이 존재하지 않습니다.");
		}

		// 썸네일 이미지 출력
		// 이미지 파일을 서버의 파일시스템에서 : FileInputStream;
		// 입력한 이미지 파일을 클라이언트로 출력 : ServletOutputStream;
		try (FileInputStream fis = new FileInputStream(file); ServletOutputStream sos = response.getOutputStream();) {
			byte[] buffer = new byte[4096];
			int data = -1;
			while ((data = fis.read(buffer)) != -1) {
				sos.write(buffer, 0, data);
			}

		} catch (Exception e) {
		}
	}
}
