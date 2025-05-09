package web;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.StaticString;

public class SampleServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType(StaticString.TEXT_PLAIN);
		response.getWriter().println("Hello, Servlet!");
		response.getWriter().println("web.xml Test");
		
	}

}
