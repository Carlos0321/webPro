package com.lec.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * int currentPage; ArrayList<Dto> dtos = dao.list(startRow, endRow); int
		 * pageCnt, startPage, endPage
		 */
		request.setAttribute("list", "list 결과");
	}

}
