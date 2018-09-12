package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author sawyer 2015-1-14 字符过滤器(只针对post请求)
 */
@WebFilter(urlPatterns = { "/*" }, asyncSupported = true, initParams = @WebInitParam(name = "encoding", value = "UTF-8"))
public class EncodingFilter implements Filter {

	private String encoding = null;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encoding = config.getInitParameter("encoding");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.encoding);
		response.setCharacterEncoding(this.encoding);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		this.encoding = null;
	}

}