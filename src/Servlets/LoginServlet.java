package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")

public class LoginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String password = request.getParameter("password");
		
		ServletContext context = getServletContext();
		String databasePassword = context.getInitParameter("databasePassword");
		
		if(password.equals(databasePassword))
		{
			HttpSession session = request.getSession();
			session.setAttribute("password", password);
					
			response.sendRedirect("search.jsp");
		}
		else
		{
			request.setAttribute("errorMessage", "Wrong password!");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);		}
	}
}
