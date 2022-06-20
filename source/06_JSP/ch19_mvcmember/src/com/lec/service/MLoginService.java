package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.dao.MemberDao;
import com.lec.dto.MemberDto;

public class MLoginService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		String mPw = request.getParameter("mPw");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.loginCheck(mId, mPw);
		if (result == MemberDao.SUCCESS) {
			MemberDto member = mDao.getMember(mId);
			HttpSession session = request.getSession();
			session.setAttribute("member",member);
		} else if (result == MemberDao.FAIL) {
			request.setAttribute("loginError", "로그인실패");
		}
	}
}
