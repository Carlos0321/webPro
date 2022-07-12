package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyInfoTestMain {

	public static void main(String[] args) {
		String resourceLocation = "applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		//MyInfo myinfo = (MyInfo)ctx.getBean("myInfo");
		Myinfo myInfo = ctx.getBean("myInfo",Myinfo.class);
		myInfo.getInfo();
		ctx.close();
	}

}
