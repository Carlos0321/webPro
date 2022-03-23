package com.lec.ex03_phone;
//c 제품 : DMB송수신 불가, lte, TV리모콘 탑재 
public class CModel implements IAcorporation {
	private String modelName = "C모델" ;
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName +"은 DMB 송수신 불가능가능");
	}

	@Override
	public void lte() {
		System.out.println(modelName +"은 LTE");
	}

	@Override
	public void tvRemotoeControl() {
		System.out.println(modelName +"은 TV리모콘 미탑재");
	}

}
