package com.lec.ex03_phone;
//c ��ǰ : DMB�ۼ��� �Ұ�, lte, TV������ ž�� 
public class CModel implements IAcorporation {
	private String modelName = "C��" ;
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName +"�� DMB �ۼ��� �Ұ��ɰ���");
	}

	@Override
	public void lte() {
		System.out.println(modelName +"�� LTE");
	}

	@Override
	public void tvRemotoeControl() {
		System.out.println(modelName +"�� TV������ ��ž��");
	}

}
