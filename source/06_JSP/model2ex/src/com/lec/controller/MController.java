package com.lec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.service.BoardContentService;
import com.lec.service.BoardListService;
import com.lec.service.BoardWriteService;
import com.lec.service.IdConfirmService;
import com.lec.service.MAllViewService;
import com.lec.service.MJoinService;
import com.lec.service.MLoginService;
import com.lec.service.MLogoutService;
import com.lec.service.MModifyService;
import com.lec.service.MWithdrawalService;
import com.lec.service.Service;
import com.lec.service.emailConfirmService;

@WebServlet("*.do")
public class MController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		String viewPage = null;
		Service service = null;

		if (com.equals("/main.do")) { //첫 화면
			viewPage = "main/main.jsp";	
			
		} else if (com.equals("/joinView.do")) { // 회원가입 화면
			viewPage = "member/join.jsp";

		} else if (com.equals("/join.do")) { //회원가입 DB처리 
			service = new MJoinService(); //excute메소드 : mID중복체크 후 회원가입
			service.execute(request, response);
			viewPage = "loginView.do";

		} else if (com.equals("/loginView.do")) { //로그인 화면
			viewPage = "member/login.jsp";
			
		}else if(com.equals("/login.do")) { // 로그인 DB 및 세션 처리
			service = new MLoginService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		} else if (com.equals("/idConfirm.do")) { //ID중복체크 메세지 결과
			service = new IdConfirmService();
			service.execute(request, response);
			viewPage = "member/idConfirm.jsp";

		} else if (com.equals("/emailConfirm.do")) { //email중복체크 메세지 결과
			service = new emailConfirmService();
			service.execute(request, response);
			viewPage = "member/emailConfirm.jsp";
		}else if(com.equals("/logout.do")) { //로그아웃 세션 날리기
			service = new MLogoutService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/modifyView.do")) { //정보 수정 화면
			viewPage = "member/modify.jsp";
		}else if(com.equals("/modify.do")) { //DB에 정보 수정
			service = new MModifyService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
		}else if(com.equals("/allView.do")) { // 회원목록가져오기
			service = new MAllViewService();
			service.execute(request, response);
			viewPage = "member/mAllView.jsp";
		}else if(com.equals("/withdrawal.do")) { // 회원탈퇴
			service = new MWithdrawalService();
			service.execute(request, response);
			viewPage = "main/main.jsp";
			
		}else if (com.equals("/boardList.do")) { //게시판리스트 
			service = new BoardListService();
			service.execute(request, response);
			viewPage = "freeBoard/boardList.jsp";
			
		}else if(com.equals("/boardWriteView.do")) {//글쓰기 화면
			viewPage = "freeBoard/boardWrite.jsp";
			
		}else if(com.equals("/boardWrite.do")) { //DB에 글쓰기 저장 
			service = new BoardWriteService();
			service.execute(request, response);
			viewPage = "boardList.do";
			
		}else if(com.equals("/boardContent.do")) { //상세보기
			service = new BoardContentService();
			service.execute(request, response);
			viewPage = "freeBoard/boardContent.jsp";
			
		}else if(com.equals("/boardModifyView.do")) {//글 수정
			viewPage = "";
		}else if(com.equals("/boardModify.do")) {
			viewPage = "";
		}else if(com.equals("/boardDelete.do")) {
			viewPage = "";
		}else if(com.equals("/boardReplyView.do")) {
			viewPage = "";
		}else if(com.equals("/boardReply.do")) {
			viewPage = "";
		
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}