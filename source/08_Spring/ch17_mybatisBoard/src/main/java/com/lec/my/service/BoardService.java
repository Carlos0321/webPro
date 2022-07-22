package com.lec.my.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lec.my.dto.Board;

public interface BoardService {
	public List<Board> boardList(String pageNum);
	public int totCnt();
	public Board content(int bid);
	public int write(Board board, HttpServletRequest request);
	public int delete(int bid);
	public Board reply(Board board, HttpServletRequest request);
	public int modify(Board board, HttpServletRequest request);
	public Board modifyView(int bid);
	public Board replyView(int bid);
	public void dummyDataInsert50();
}
