package com.lec.ch19.service;

import javax.servlet.http.HttpSession;

import com.lec.ch19.dto.Member;

public interface MemberService {
	public int idConfirm(String mid); //id 받아서 그대로 sql문 실행하니까 dao랑 같음
	public int joinMember(Member member, HttpSession httpSession); //DB에 저장되고 메일도 보내야함, session 필요, 컨트롤러에서 request객체 받아오는거 질문 
	public String loginCheck(String mid, String mpw, HttpSession httpSession);
	public Member getDetailMember(String mid);
	public int modifyMember(Member member); //DB에 업데이트 되고  session도 받아야하므로 session도 설정 컨트롤러에서 설정가능 
}
