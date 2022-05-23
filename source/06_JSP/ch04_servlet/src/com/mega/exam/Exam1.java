package com.mega.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

@WebServlet("/exam1")
public class Exam1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] su = request.getParameterValues("su");
		response.setContentType("text/html; charset=utf-8"); //response 출력의 한글 처리
		PrintWriter out = response.getWriter();
		for(int i=0; i < su.length; i++) {
			int su2 = Integer.parseInt(su[i]);
			out.println("<h2>"+su2+"단</h2>"+"<br>");
			
			 for(int j=1; j<=9; j++) {
				 out.println(su2+"*"+j+" = "+su2*j+"<br>");
			 
			 } 
		}
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
