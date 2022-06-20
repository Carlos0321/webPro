package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.MAllviewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;
import com.lec.service.Service;

@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //파일첨부 ,비밀번호 - post방식 
		actionDo(request,response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length()); //들어온 요청
		
		String viewPage = null; //forward 페이지
		Service service = null; // DB연동 인터페이스  - 모델  // 모든 모델은 서비스로부터 implement받는다
		
		if(com.equals("/joinView.do")) { // 회원가입 화면
			viewPage = "member/join.jsp";
		}else if(com.equals("/join.do")) { // 회원가입 DB 처리
			service = new MJoinService(); // execute메소드 : mId중복체크 후 회원가입
			service.execute(request, response);
			viewPage = "loginView.do";
		}else if(com.equals("/loginView.do")) { // 로그인 화면
			viewPage = "member/login.jsp";
		}else if(com.equals("/login.do")) { // 로그인 DB 및 세션 처리
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/logout.do")) {//로그아웃 - 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		}else if(com.equals("/modifyView.do")) { // 정보 수정 화면
			//service = new MGetMemberService();// DB에서 회원정보를 가져와도 되고 session에서 가져와도 됨
			//service.execute(request, response);// 세션에 dto를 넣었으면 이 두줄은 필요없음
			viewPage = "member/modify.jsp";
		}else if(com.equals("/modify.do")) { // DB에 정보 수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "member/main.jsp";
		
		
		}else if(com.equals("/allview.do")) { // 회원목록가져오기
			service = new MAllviewService();
			service.execute(request, response);
			viewPage = "member/mAllview.jsp";
		
		}else if(com.equals("/main.do")) { // 메인 페이지
			viewPage = "member/main.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}