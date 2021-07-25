package Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */

public class AuthenticationFilter implements Filter {

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
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest)request;

		String path = req.getRequestURI();
		if (path.endsWith("/login.jsp") || path.endsWith("/login")) {
		    chain.doFilter(request, response);// Just continue chain
		}
		else
		{
			HttpSession session = req.getSession();
			if(session.getAttribute("password")== null)
			{
				req.setAttribute("errorMessage", "Login required!");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(req, response);
				System.out.println("Filter used");
			}
		
		
			// pass the request along the filter chain
			else 
			{
				System.out.println("Filter used");
				chain.doFilter(request, response);
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
