package com.lec.ex03_phone;

public class TestMain {

	public static void main(String[] args) {
		AModel a = new AModel();
		BModel b = new BModel();
		CModel c = new CModel();
//		a.dmbReceive();
//		a.lte();
//		a.tvRemotoeControl();
		IAcorporation[] phone = {a,b,c};
		for(IAcorporation p : phone) {
			System.out.println(p.getClass().getName()+"Model"); //com.lec.ex03_phone.AModel
			p.dmbReceive(); 
			p.lte();
			p.tvRemotoeControl();
		}
	}

}
