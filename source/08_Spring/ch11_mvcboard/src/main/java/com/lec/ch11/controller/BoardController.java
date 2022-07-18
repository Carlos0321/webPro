package com.lec.ch11.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch11.bservice.BListService;
import com.lec.ch11.bservice.BWriteService;
import com.lec.ch11.bservice.BcontentService;
import com.lec.ch11.bservice.Service;
import com.lec.ch11.dto.BoardDto;
import com.lec.ch11.service.BDeleteService;
import com.lec.ch11.service.BModifyReplyViewService;
import com.lec.ch11.service.BModifyService;
import com.lec.ch11.service.BReplyService;
import com.lec.ch11.service.BcontentReplyService;

@Controller
@RequestMapping("mvcboard") // 공통요청경로
public class BoardController {
	private Service bservice;
	@RequestMapping(value="list", method = RequestMethod.GET)
	public String list(String pageNum, Model model) {
		//mvcboard/list.do?pageNum=2
		model.addAttribute("pageNum",pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value="list", method = RequestMethod.POST)
	public String list_post(String pageNum, Model model) {
		//mvcboard/list.do?pageNum=2
		model.addAttribute("pageNum",pageNum);
		bservice = new BListService();
		bservice.execute(model);
		return "mvcboard/list";
	}
	@RequestMapping(value="writeView", method = RequestMethod.GET)
	public String writeView() {
		return "mvcboard/write";
	}
	@RequestMapping(value="write",method=RequestMethod.POST)
	public String write(@ModelAttribute("bDto") BoardDto boardDto,HttpServletRequest request,Model model) {
		model.addAttribute("request",request); //서비스단에서 ip 추출(request.getRemoteAddr())
		bservice = new BWriteService();
		bservice.execute(model);
		return "forward:list.do";
	}
	@RequestMapping(value="content", method= RequestMethod.GET)
	public String content(int bid,Model model) {
		model.addAttribute("bid", bid);
		bservice = new BcontentService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	@RequestMapping(value="content", method= RequestMethod.POST)
	public String content_post(int bid,Model model) {
		model.addAttribute("bid", bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/content";
	}
	@RequestMapping(value="modify" ,method=RequestMethod.GET)
	public String modifyView(int bid, Model model) {
		model.addAttribute("bid",bid);
		bservice = new BModifyReplyViewService();
		bservice.execute(model);
		return "mvcboard/modify";
	}
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public String modify(BoardDto boardDto, Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		bservice = new BModifyService();
		bservice.execute(model);
		return "forward:content.do";
	}
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(int bid, Model model) {
		model.addAttribute("bid",bid);
		bservice = new BDeleteService();
		bservice.execute(model);
		return "forward:list.do";
	}
	@RequestMapping(value="reply", method=RequestMethod.GET)
		public String replyView(int bid, Model model) {
			model.addAttribute("bid", bid);
			bservice = new BModifyReplyViewService(); //bid로 dto 가져오기 (조회수 올리지 않고)
			bservice.execute(model);
			return "mvcboard/reply";
		}
	@RequestMapping(value="reply", method=RequestMethod.POST)
		public String reply(BoardDto boardDto, Model model ,HttpServletRequest request) {
		model.addAttribute("request",request);
		bservice = new BReplyService();
		bservice.execute(model);
		return "forward:list.do";
	}
}

