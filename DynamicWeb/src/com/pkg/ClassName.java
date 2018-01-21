package com.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;
import java.util.Enumeration;

@WebServlet("/ClassName")
public class ClassName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassName() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] stringsA = request.getParameterValues("arrayString");
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
			String paramName = e.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName);
			System.out.println(paramValue);
			//map.put(paramName, paramValue);
		}

		Map<String, String[]> m = request.getParameterMap();
		for (String k : m.keySet()) {
			//System.out.printf(" k=%s %n", k);
			for (String v : m.get(k)) {
				//System.out.printf(" v=%s %n", v);
			}
		}
		String[] strings = { "A", "B", "C", "D", "E" };
		request.setAttribute("title", request.getParameter("name_text"));
		request.setAttribute("strings", strings);
		getServletContext().getRequestDispatcher("/jsp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
