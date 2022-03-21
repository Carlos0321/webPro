package com.lec.ex06_override;

public class TestMain {

	public static void main(String[] args) {
		ParentClass pObj1 = new ParentClass();
		ParentClass pObj2 = new ParentClass(1);
		if(pObj1. equals(pObj2)) {
			System.out.println("두 객체는 같다");
		}else {
			System.out.println("두 객체는 다르다");
		}
		ChildClass cObj = new ChildClass(2);
		if(cObj.equals(pObj2)) {
			System.out.println("무조건 true");
		}
		pObj1.method1();
		pObj1.method2();
		System.out.println("------------");
		cObj.method1(); //ChildClass의 method1
		cObj.method2(); //PaentClass의 method2
		cObj.method3(); //ChildClass의 method3
		ParentClass cObj1 = new ParentClass(2);
		cObj.method1(); // ChildClass의 method1
		cObj1.method2(); //ParentClass의 method2
//		if(ParentClass형 cObj1변수를 ChildClass형으로 변환 가능하니?) {
		if(cObj1 instanceof ChildClass) {
			((ChildClass)cObj1).method3();
		}else {
			System.out.println("형변환 안 됨");
		}
		
	}

}
