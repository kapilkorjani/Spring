package com.pizzaorderingsystem.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		  
		String uri = req.getRequestURI();
		
		if((uri.endsWith("login.jsp"))||(uri.endsWith("LoginUser"))||uri.endsWith("registerUser")||uri.endsWith("register.jsp")||uri.endsWith(".css")||uri.endsWith(".js")||uri.endsWith(".scss")) {
			chain.doFilter(request, response);
		}
		else {
			HttpSession session = req.getSession();
			String username=(String)session.getAttribute("username");
			if(username != null) {
				chain.doFilter(request, response);
			}
			else
				res.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
