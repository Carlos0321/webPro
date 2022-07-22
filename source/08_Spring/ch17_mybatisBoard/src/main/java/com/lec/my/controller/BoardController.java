package com.lec.my.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.my.dto.Board;
import com.lec.my.service.BoardService;
import com.lec.my.util.Paging;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="list", method= {RequestMethod.GET, RequestMethod.POST})
	public String List(String pageNum, Model model) {
		model.addAttribute("boardList", boardService.boardList(pageNum));
		model.addAttribute("paging", new Paging(boardService.totCnt(), pageNum));
		return "list";
	}
	
	@RequestMapping(value="writeView", method = RequestMethod.GET)
	public String writeView() {
		return "write";
	}
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String write(Board board,HttpServletRequest request,Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("writeResult",boardService.write(board ,request));
		return "forward:list.do";
	}
	@RequestMapping(value="content", method= {RequestMethod.GET,RequestMethod.POST})
	public String content(int bid, Model model) {
		model.addAttribute("board",boardService.content(bid));
		return "content";
	}
	@RequestMapping(value="modify" ,method= RequestMethod.GET)
		public String modifyView(int bid,Model model) {
		model.addAttribute("board",boardService.modifyView(bid));
		return "modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(Board board,HttpServletRequest request ,Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("modifyResult",boardService.modify(board, request));
		return "forward:list.do";
	}
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(int bid,Model model) {
		model.addAttribute("deleteResult", boardService.delete(bid));
		return "forward:list.do";
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
	public String replyView(int bid, Model model) {
		model.addAttribute("board", boardService.content(bid));
		return "reply";
	}
	@RequestMapping(value="reply", method= {RequestMethod.GET,RequestMethod.POST})
	public String reply(Board board,HttpServletRequest request ,Model model) {
		board.setBip(request.getRemoteAddr());
		model.addAttribute("board", boardService.reply(board,request));
		return "forward:list.do";
}
}
