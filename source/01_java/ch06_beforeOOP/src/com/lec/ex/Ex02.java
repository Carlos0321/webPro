package com.lec.ex;

// 1~10���� ������ ���� ����ϰ� �� ���� ¦������ Ȧ������ ��� 
public class Ex02 {

	public static void main(String[] args) {
		int tot = sum(10);  // �ڹ� ����ӽ��� ȣ���ؾ߽���� 
		System.out.println("1~10���� ��������" + tot);
		System.out.println(evenOdd(tot));
		//from ~ to ���� �����ϴ� ���� 
		//¦ Ȧ�� �Ǻ� ���� �ҷ� sysout
		tot = sum(10, 100);
		System.out.println("10~100���� ��������"+ tot);
		System.out.println(evenOdd(tot));
		//¦ Ȧ�� �Ǻ� ���� �ҷ� sysout
	} 
	private static int sum(int to) {  //�Լ��� �����ε�
		int result = 0 ;//from ~to���� ������ ��� return
		for(int i=1 ; i <= to ; i++) {
			 result +=i;   //result = result + i ;
		}
		return result;
	}
	private static int sum(int from, int to) { //��������  �ٸ����Ͽ��� �����Ҷ� private ���
		int result = 0 ;//from ~to���� ������ ��� return
		for(int i=from ; i <= to ; i++) {
			 result +=i;   //result = result + i ;
		}
		return result; // ������ ��� 
	}
	private static String evenOdd(int value) {
		return value%2 == 0 ? "¦���Դϴ�" : "Ȧ���Դϴ�" ;
//		String result = null;
//		if(value%2==0) {
//			result = "¦���Դϴ�" ;
//		}else {
//			result = "Ȧ���Դϴ�" ;
//	}
//		//return result;
	}
}
