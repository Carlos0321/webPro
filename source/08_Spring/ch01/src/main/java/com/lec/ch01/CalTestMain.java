package com.lec.ch01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CalTestMain {

	public static void main(String[] args) {
		/*
		 * Calculation cal = new Calculation(); cal.setNum1(50); cal.setNum2(10);
		 */
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCtx.xml");
		// 파싱 : 해석하는 것 스프링 컨테이너에 파싱된 빈이 만들어져 있는 것 
		//xml을 파싱해서 빈 을 만든것이 ioc 컨테이너
		Calculation cal = ctx.getBean("calculation",Calculation.class);
		cal.add();
		cal.sub();
		cal.mul();
		cal.div();
		System.out.println(cal);
		ctx.close();
	}

}
