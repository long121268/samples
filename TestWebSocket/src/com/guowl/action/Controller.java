package com.guowl.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 访问示例：<br>
 * Controller?url=ajax
 */
public class Controller extends HttpServlet {
	private static final long	serialVersionUID	= -7148845432448768008L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getParameter("url");
		String target = getTarget(url);
		request.getServletContext().getRequestDispatcher(target).forward(request, response);
	}

	private String getTarget(String url) {
		if (url.equalsIgnoreCase("ajax")) {
			return "/ajax/ajax.jsp";
		} else if (url.equalsIgnoreCase("websocket")) {
			return "/websocket/websocket.jsp";
		}
		return "";
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
