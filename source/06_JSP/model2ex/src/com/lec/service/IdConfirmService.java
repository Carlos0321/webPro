package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.MemberDao;

public class IdConfirmService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String mId = request.getParameter("mId");
		MemberDao mDao = MemberDao.getInstance();
		int result = mDao.mIdConfirm(mId);
		if(result == MemberDao.EXISTENT) {
			request.setAttribute("idConfirmResult", "중복된 ID입니다");
		}else {
			request.setAttribute("idConfirmResult", "사용가능 ID입니다");
		}
	}

}
