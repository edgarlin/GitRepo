package com.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ServletContext context = this.getServletContext();
		ServletConfig config = this.getServletConfig();

		PrintWriter out=response.getWriter();
		out.append("Servlet2:");
		out.append("<br>");
		
		out.append("context-param-name1:");
		out.append((String) context.getInitParameter("context-param-name1"));
		out.append("<br>");
		
		out.append("session-attribute1:");
		out.append((String) session.getAttribute("session-attribute1"));
		out.append("<br>");
		
		out.append("context-attribute1:");
		out.append((String) context.getAttribute("context-attribute1"));
		out.append("<br>");
		
		
		out.append("filter1-attr-name1:");
		out.append((String) request.getAttribute("filter1-attr-name1"));
		out.append("<br>");
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie = new Cookie("cookieName", "cookieValue");
		response.addCookie(cookie);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
