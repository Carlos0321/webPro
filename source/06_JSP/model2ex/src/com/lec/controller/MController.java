package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.IdConfirmService;
import com.lec.service.MJoinService;
import com.lec.service.Service;
import com.lec.service.emailConfirmService;


@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request,response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;
		
	      if(com.equals("/joinView.do")) { //회원가입 화면 
	         viewPage = "member/join.jsp";
	      
	      }else if(com.equals("/join.do")) {
	         service = new MJoinService();
	         service.execute(request, response);
	         viewPage = "loginView.do";
	      
	      }else if(com.equals("/loginView.do")) {
	         viewPage = "member/login.jsp";
	      
	      }else if(com.equals("/idConfirm.do")){
	         service = new IdConfirmService();
	         service.execute(request, response); 
	         viewPage = "member/idConfirm.jsp";
	      
	      }else if(com.equals("/emailConfirm.do")){
	         service = new emailConfirmService();
	         service.execute(request, response); 
	         viewPage = "member/emailConfirm.jsp";
	      }
	      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	      dispatcher.forward(request, response);
	}
}