package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);
		if(pObj1. equals(pObj2)) {
			System.out.println("�� ��ü�� ����");
		}else {
			System.out.println("�� ��ü�� �ٸ���");
		}
		ChildClass cObj = new ChildClass(2);
		if(cObj.equals(pObj2)) {
			System.out.println("������ true");
		}
		pObj1.method1();
		pObj1.method2();
		System.out.println("------------");
		cObj.method1(); //ChildClass�� method1
		cObj.method2(); //PaentClass�� method2
		cObj.method3(); //ChildClass�� method3
		ParentClass cObj1 = new ParentClass(2);
		cObj.method1(); // ChildClass�� method1
		cObj1.method2(); //ParentClass�� method2
//		if(ParentClass�� cObj1������ ChildClass������ ��ȯ �����ϴ�?) {
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();
		}else {
			System.out.println("����ȯ �� ��");
		}
		
	}

}