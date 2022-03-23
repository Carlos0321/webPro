package com.lec.ex04_actor;

public class TestMain {

	public static void main(String[] args) {
		Actor park = new Actor("�ں���");
		park.canCatchCriminal();
		park.canSearch();
		park.outFire();
		park.saveMan();
		park.makePizza();
		System.out.println("-----------------------");
		IChef chefPark = new Actor("�ڼ���");
//		chefPark.canCatchCriminal()�Ұ�  �ٸ� �������̽��� ���Ұ� 
		chefPark.makePizza();
		chefPark.makeSpaghetti();
		System.out.println("-----------------------");
		IFireFighter firePark = new Actor("��");
		firePark.outFire();
		firePark.saveMan();
		System.out.println("-----------------------");
		IPoliceMan policePark = new Actor("�ڰ��");
		policePark.canCatchCriminal();
		policePark.canSearch();
	}

}
