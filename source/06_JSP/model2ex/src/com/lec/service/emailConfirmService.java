package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class emailConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mEmail = request.getParameter("mEmail");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.mEmailConfirm(mEmail);
		if (result == MemberDao.EXISTENT) {
			request.setAttribute("emailConfirmResult", "중복된 EMAIL입니다");
		} else {
			request.setAttribute("emailConfirmResult", "사용가능한 EMAIL입니다");
		}
	}
}
