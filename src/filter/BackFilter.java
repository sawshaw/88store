package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;

/**
 * @author sawyer 2015-1-14 后台过滤器
 */
@WebFilter(urlPatterns = { "/back/*" })
public class BackFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Admin admin = (Admin) session.getAttribute("admin");
		if (null == admin) {
			res.sendRedirect("../adminLogin.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}

}