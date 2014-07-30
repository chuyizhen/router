package cn.voicet.router.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import cn.voicet.router.util.DotSession;

public class LoginedCheckFilter implements Filter {

	private static Logger log = Logger.getLogger(LoginedCheckFilter.class);
	private List<String> loginList = new ArrayList<String>();

	public void init(FilterConfig config) throws ServletException {
		loginList.add("/index.action");
		loginList.add("/ajaxlogin.action");
		loginList.add("/error.jsp");
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String path = request.getServletPath();
		log.info("access path: " + path);
		if (loginList!=null && loginList.contains(path)) {
			chain.doFilter(request, response);
			log.info("Allow access for loginList not null...");
			return;
		}
		DotSession ds = (DotSession)request.getSession().getAttribute("vts");
		log.info("vts:"+ds);
		if (ds != null) {
			chain.doFilter(request, response);
			log.info("Allow access for vts not null...");
			return;
		}
		log.info("Does not allow access...");
		response.sendRedirect(request.getContextPath() + "/error.jsp");
	}

	public void destroy() {
		loginList.clear();
	}
}
