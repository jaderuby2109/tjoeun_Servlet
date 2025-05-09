package contentType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

import dto.XmlMapper;
import dto.MapWrapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

@WebServlet("/XmlServlet")
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// curl -X GET http://localhost:8080/Servlet/XmlServlet
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 응답
		response.setContentType("application/xml; charset=UTF-8");
		String resultStr = "<Board><title>제목</title><writer>작성자</writer><content>내용</content></Board>";

		PrintWriter writer = response.getWriter();
		writer.println(resultStr);
	}

	// curl -X POST http://localhost:8080/Servlet/XmlServlet ^
	// -H "Content-Type: application/xml" ^
	// -d "<Users><name>김조은</name><age>20</age></Users>"
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청
		// xml -> Map
		BufferedReader reader = request.getReader();
		StringBuilder builder = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			builder.append(line);
		}
		String xml = builder.toString();
		Map<String, Object> map = XmlMapper.toMap(xml);
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Object value = map.get(key);
			System.out.println(key + " : " + value);
		}

		// Map -> xml
		JAXBContext context = null;
		try {
			// Map을 MapWrapper 로 포함
			MapWrapper wrapper = new MapWrapper(map);
			
			// JAXBContext 객체 생성
			context = JAXBContext.newInstance(MapWrapper.class);
			// 마샬링		: 객체 -> XML
			// 언마샬링	: XML -> 객체
			// 객체를 XML로 변환해주는 객체, 마샬러 생성
			Marshaller marshaller = context.createMarshaller();
			// XML 태그를 포맷팅 하는 옵션 지정 (들여쓰기 등)JAXB_FORMATTED_OUTPUT : 들여쓰기 포맷
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			StringWriter strWirter = new StringWriter();
			// 객체를 -> XML로 변환
			// 매개변수 : 변환할 클래스, StringWriter 객체
			marshaller.marshal(wrapper, strWirter);
			xml = strWirter.toString();

		} catch (JAXBException e) {
			System.out.println("map -> XML 변환시 에러");
		}
		
		System.out.println("map -> xml : ");
		System.out.println(xml);
		PrintWriter writer = response.getWriter();
		writer.println(xml);
	}
}
