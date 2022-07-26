package com.lec.ch19.service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lec.ch19.dao.MemberDao;
import com.lec.ch19.dto.Member;
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Override
	public int idConfirm(String mid) {
		return memberDao.idConfirm(mid);
	}

	@Override
	public int joinMember(final Member member, HttpSession httpSession) {
		//member.getmname()에게 메일 보내기, member insert, session에 mid attribute추가 순서상관없음
		MimeMessagePreparator message = new MimeMessagePreparator() {
			String content="<div style=\"width:500px; margin:0 auto;\">\n" + 
					"		<h1 style=\"color:blue;\">"+member.getMname()+"님 회원가입 감사합니다</h1>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
					"		<p><img src=\"http://localhost:8090/ch19/img/coupon.jpg\"></p>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue;\">파란글씨 부분</p>\n" + 
					"		<img src=\"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png\">\n" + 
					"	</div>\n" + 
					"	<p>서울</p>"; 
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(member.getMmail())); //받는 메일
				mimeMessage.setFrom(new InternetAddress("max9236@gmail.com")); //보내는 메일
				mimeMessage.setSubject(member.getMname()+"님 회원가입 감사합니다(쿠폰드림)");
				mimeMessage.setText(content,"utf-8","html");
			}
		};
		mailSender.send(message); //메일 발송
		httpSession.setAttribute("mid", member.getMid()); //세션에 mid 속성 추가
		System.out.println("가입할 회원정보 : "+member);
		return memberDao.joinMember(member); //member insert
	}

	@Override
	public String loginCheck(String mid, String mpw, HttpSession httpSession) {
		String result = "로그인 성공";
		Member member = memberDao.getDetailMember(mid);
		if(member == null) {
			result="유효하지 않은 아이디입니다";
		}else if(! mpw.equals(member.getMpw())){
			result = "비밀번호가 맞지 않습니다";
		}else {
			//로그인 성공 - 세션에 추가
			httpSession.setAttribute("member", member);
			httpSession.setAttribute("mid", mid);
		}
		return result;
	}

	@Override
	public Member getDetailMember(String mid) {
		return memberDao.getDetailMember(mid);
	}

	@Override
	public int modifyMember(Member member) {
		return memberDao.modifyMember(member);
	}

}
