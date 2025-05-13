package tjoeunJSP.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpFilter;
import tjoeunJSP.Common;

import java.io.IOException;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(/*urlPatterns = { "/*" } , */   // 모든 경로 매핑
		urlPatterns = { "/TestFilter" } , 
		initParams = { @WebInitParam(name = "encoding", value = "UTF-8", description = "인코딩설정값") })
public class EncodingFilter extends HttpFilter implements Filter {

	private FilterConfig filterConfig = null;
	private String encoding;

	/**
	 * 생성자
	 */
	public EncodingFilter() {
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("인코딩 필터 : " + encoding);
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		response.setContentType(Common.TEXT_PLAIN);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

}
