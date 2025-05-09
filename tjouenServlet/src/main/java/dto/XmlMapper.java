package dto;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlMapper {

	public static Map<String, Object> toMap(String xml) {

		Map<String, Object> map = new HashMap<String, Object>();
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			StringReader reader = new StringReader(xml);
			Document doc = builder.parse(new InputSource(reader)); // 문자열 XML -> 문서 객체로 변환

			Element root = doc.getDocumentElement(); // 루트 요소
			NodeList nodeList = root.getChildNodes(); // 자식 요소 리스트

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i); // i번째 요소 : <name>, <age>
				if (node instanceof Element) {
					map.put(node.getNodeName(), node.getTextContent());
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return map;
	}

}
