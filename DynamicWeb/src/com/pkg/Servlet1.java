package com.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = this.getServletContext();
		ServletConfig config = this.getServletConfig();
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Servlet2");
				
		session.setAttribute("session-attribute1", "session-value1");
		context.setAttribute("context-attribute1", "context-value1");
		
		PrintWriter out=response.getWriter();
		out.append("<html><head></head><body>");
		out.append("Servlet1:");
		out.append("<br>");

		out.append("init-param-name1:");
		out.append(config.getInitParameter("init-param-name1"));
		out.append("<br>");

		requestDispatcher.include(request, response);

		out.append("Servlet1:");
		out.append("<br>");
		
		out.append("Served at: ");
		out.append(request.getContextPath());
		out.append("<br>");

		out.append("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
