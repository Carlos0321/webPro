package com.lec.emp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EmpList
 */
@WebServlet("/empList")
public class EmpList extends HttpServlet {
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

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmpDao eDao = new EmpDao();
		ArrayList<EmpDto> emps = eDao.listEmp();
		request.setAttribute("emps", emps);
		RequestDispatcher dispatcher = request.getRequestDispatcher("3_EMP/empList.jsp");
		dispatcher.forward(request, response);
		
		//jsp에서 ${sessionScope.customer}
		/*
		 * HttpSession session =request.getSession();
		 * session.setAttribute("customer",* value); 
		 * 뷰단과 세션을 받는거와 객체명 다르게 해야한다, 중복될 수 있음 
		 */
	}
}
