package com.lec.my.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lec.my.dto.Board;

@Mapper
public interface BoardDao {
	public List<Board> boardList(Board board);
	public int totCnt();
	public Board content(int bid);
	public int write(Board board);
	public int modify(Board board);
	public int delete(int bid);
	public Board reply(Board board);
	public Board replyView(int bid);
	public Board modifyView(int bid);
}
