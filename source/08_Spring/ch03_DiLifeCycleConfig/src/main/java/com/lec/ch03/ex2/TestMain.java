package com.lec.ch03.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		// IOC 컨테이너 생성 (환경설정)
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		//파싱
		ctx.load("classpath:META-INF/ex2/applicationCTX.xml");
		ctx.refresh(); //빈 생성
		System.out.println("----------------------------------");
		Person person = ctx.getBean("person",Person.class); //객체 타입 써도 됨
		System.out.println(person);
		OtherPerson otherperson = (OtherPerson) ctx.getBean("otherPerson"); //형변환
		System.out.println(otherperson);
		System.out.println("-------------------------------------");
		ctx.close();
		System.out.println("빈 소멸");
	}

}
