package com.lec.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.dao.BoardDao;
import com.lec.dto.BoardDto;

public class BoardContentService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int fId = Integer.parseInt(request.getParameter("fId"));
		BoardDao boardDao = BoardDao.getInstance();
		BoardDto dto = boardDao.contentView(fId);
		request.setAttribute("content", dto);
	}

}
