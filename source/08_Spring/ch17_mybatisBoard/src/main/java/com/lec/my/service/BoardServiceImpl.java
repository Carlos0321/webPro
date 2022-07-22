package com.lec.my.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.my.dao.BoardDao;
import com.lec.my.dto.Board;
import com.lec.my.util.Paging;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardDao boardDao;

	@Override
	public List<Board> boardList(String pageNum) {
		Paging paging = new Paging(boardDao.totCnt(), pageNum, 10, 5);
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardDao.boardList(board);
	}

	@Override
	public int totCnt() {
		return boardDao.totCnt();
	}

	@Override
	public Board content(int bid) {
		return boardDao.content(bid);
	}

	@Override
	public int write(Board board ,HttpServletRequest requset) {
		return boardDao.write(board);
	}

	@Override
	public int modify(Board board,HttpServletRequest requset) {
		return boardDao.modify(board);
	}

	@Override
	public int delete(int bid) {
		return boardDao.delete(bid);
	}

	@Override
	public Board reply(Board board,HttpServletRequest requset) {
		return boardDao.reply(board);
	}

	@Override
	public void dummyDataInsert50() {
		Board board = new Board();
		for (int i = 150; i < 200; i++) {
			board.setBname("홍길동" + i);
			board.setBtitle("제목" + i);
			board.setBcontent("본문");
			board.setBip("127.12.10" + i);
			board.setBdate(Date.valueOf("2022-07-21"));
			int result = boardDao.write(board);
			System.out.println(i + "번쨰 : " + (result == 1 ? "성공" : "실패"));
		}
	}

	@Override
	public Board replyView(int bid) {
		return boardDao.replyView(bid);
	}

	@Override
	public Board modifyView(int bid) {
		return boardDao.modifyView(bid);
	}
}
