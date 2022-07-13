package com.lec.ch04.ex4;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.ch04.ex3.ServerInfo;

public class Main {

	public static void main(String[] args) {
		String config = null; //초기화
		Scanner sc = new Scanner(System.in);
		System.out.println("dev ? or run ?");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("dev")) {
			config = "dev";
		}else if(answer.equalsIgnoreCase("run")) {
			config = "run";
		}else {
			System.out.println("제대로 된 환경이 입력되지 않았습니다.");
			System.out.println(0);
		}
		sc.close();
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
		
		ctx.load("classpath:META-INF/ex4/dev.xml","META-INF/ex4/run.xml");
		ctx.refresh();
		ServerInfo2 info = ctx.getBean("envInfo", ServerInfo2.class);
		System.out.println("IP : " + info.getIpNum());
		System.out.println("port : " + info.getPortNum());
		System.out.println("ID : " + info.getUserId());
		System.out.println("PW : " + info.getUserPw());
	}

}
