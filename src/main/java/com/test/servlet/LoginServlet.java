/**
 *
 */
package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author aubrey
 * @date  上午10:37:51
 * 
 */
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		PrintWriter print = resp.getWriter();
		print.write("{\"result\":\"success\"}");
	}
	
	
	
	
	
	
	
	
	
}
