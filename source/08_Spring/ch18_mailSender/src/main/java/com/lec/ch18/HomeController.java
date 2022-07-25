package com.lec.ch18;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	@Autowired
	private JavaMailSender mailSender;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "join";
	}
	@RequestMapping(value="textMail", method=RequestMethod.GET)
	public String textMail(String name, String email, Model model) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("max9236@gmail.com"); //관리자 메일 주소(보내는 사람 메일)
		message.setTo(email); //받는 사람 메일
		message.setSubject("[TEXT 가입인사]"+name+"님 회원가입 감사합니다"); //메일 제목
		String content = name+"님 회원가입 감사합니다.\n";
		message.setText(content); //메일 본문 내용 
		
		mailSender.send(message); //메일 보내기
		model.addAttribute("mailSendResult", "TEXT메일이 발송되었습니다.");
		return "sendResult";
	}
	@RequestMapping(value="htmlMail", method=RequestMethod.GET)
	public String htmlMail(final String name, final String email, Model model) {
		// name에게 email 주소로 html 내용 보내기 
		MimeMessagePreparator message = new MimeMessagePreparator() {
			// 메일 내용(html)
			String content="<div style=\"width:500px; margin:0 auto;\">\n" + 
					"		<h1 style=\"color:blue;\">"+name+"님 회원가입 감사합니다</h1>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p>아무개 사이트에서만 쓰실 수 있는 감사쿠폰을 드립니다</p>\n" + 
					"		<p><img src=\"http://localhost:8090/ch18/resources/coupon.jpg\"></p>\n" + 
					"	</div>\n" + 
					"	<div>\n" + 
					"		<p style=\"color:red;\">빨간 글씨 부분</p>\n" + 
					"		<p style=\"color:blue;\">파란글씨 부분</p>\n" + 
					"		<img src=\"https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png\">\n" + 
					"	</div>\n" + 
					"	<p>서울</p>"; 
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				//보내는 메일, 받는 메일, 메일 제목, utf-8
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(email)); //받는 메일
				mimeMessage.setFrom(new InternetAddress("max9236@gmail.com")); //보내는 메세지
				mimeMessage.setSubject("[HTML가입인사]"+name+"님 회원가입 감사합니다.");
				mimeMessage.setText(content,"utf-8","html");
			}
		}; 
		mailSender.send(message);
		model.addAttribute("mailSendResult","HTML 메일이 발송되었습니다");
		return "sendResult";
	}
}
