package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertService implements Service {
	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {
		//insert 로직 (Dao생성 - request.getP~파라미터 받아 dto 객체생성, -dao.insert 호출)
		int result = 1 ; 
		request.setAttribute("insertResult", result);
	}
}
