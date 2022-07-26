package com.lec.ch19.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lec.ch19.dto.Member;
import com.lec.ch19.service.MemberService;

@Controller
@RequestMapping(value = "member")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(params = "method=joinForm", method = RequestMethod.GET)
	public String joinForm() {
		return "member/joinForm";
	}

	@RequestMapping(params = "method=idConfirm", method = RequestMethod.GET)
	public String idConfirm(String mid, Model model) {
		model.addAttribute("result", memberService.idConfirm(mid));
		return "member/idConfirm";
	}

	@RequestMapping(params = "method=join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mDto") Member member, HttpSession httpSession, Model model) {
		//dto 하나로 받는데,  @ModelAttribute("mDto") member 이름으로 model에 attribute하지말라고 다시 지정해주는거임
		//뷰단 입장에서는 member만 받아온걸로 
	    //회원가입만 했는데 member가 model에 attribute되서 로그아웃창이 뜨는걸 방지하기 위해서
		model.addAttribute("joinResult", memberService.joinMember(member, httpSession));
		return "forward:member.do?method=loginForm";
	}
	@RequestMapping(params="method=loginForm", method= {RequestMethod.POST,RequestMethod.GET})
	public String loginForm() {
		return "member/loginForm";
	}
	@RequestMapping(params="method=login",method=RequestMethod.POST)
	public String login(String mid, String mpw, HttpSession httpSession, Model model) {
		String result = memberService.loginCheck(mid, mpw, httpSession);
		if(result.equals("로그인 성공")) {
			return "redirect:main.do";
		}else {
			model.addAttribute("mid",mid);
			model.addAttribute("mpw",mpw);
			model.addAttribute("result",result);
			return "forward:member.do?method=loginForm";
		}
	}
	@RequestMapping(params="method=modifyForm",method= {RequestMethod.GET,RequestMethod.POST})
	public String modifyForm() {
		return "member/modifyForm";
	}
	@RequestMapping(params="method=modify", method=RequestMethod.POST)
	public String modify(@ModelAttribute("mDto")Member member, HttpSession httpSession, Model model) {
		model.addAttribute("modifyResult",memberService.modifyMember(member)); //
		httpSession.setAttribute("member", member);
		return "forward:main.do";
	}
	@RequestMapping(params="method=logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:main.do";
	}
}
