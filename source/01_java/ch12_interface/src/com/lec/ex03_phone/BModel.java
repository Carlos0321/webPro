package com.lec.ex03_phone;
//b ��ǰ : DMB�ۼ��ű��, lte, TV������ ž�� 
public class BModel implements IAcorporation {
	private String modelName = "B��" ;
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName +"�� DMB �ۼ��Ű���");
	}

	@Override
	public void lte() {
		System.out.println(modelName +"�� LTE");
	}

	@Override
	public void tvRemotoeControl() {
		System.out.println(modelName +"�� TV������ ž��");
	}

}
