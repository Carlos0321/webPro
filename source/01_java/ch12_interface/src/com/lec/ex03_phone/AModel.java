package com.lec.ex03_phone;
//a ��ǰ : DMB�ۼ��ű��, 5G, TV������ ž�� 
public class AModel implements IAcorporation {
	private String modelName;
	public AModel() {
		modelName = "A��";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �۽� ����");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "�� 5G");
	}

	@Override
	public void tvRemotoeControl() {
		System.out.println(modelName + "�� TV������ž��");
	}

}
