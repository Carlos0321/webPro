package com.lec.method;
// Arithmetic.sum /.�� ~�ȿ� ����ִٴ� �ǹ� (sum/evenOdd)static�޼ҵ� vs abs(�Ϲݸ޼ҵ�)
public class Ex03 {
//static�� class�� ������ ����� �� �ִ� . 
	public static void main(String[] args) {
		int tot = Arithmetic.sum(10); // Arithmetic ��Ű�� �ȿ� �ִ°��� ����ҋ� 
		System.out.println("1~10���� ���� "+ tot);
		System.out.println(Arithmetic.evenOdd(tot));
		Arithmetic ar = new Arithmetic() ; //instance (stack�޸𸮷� ������)
		System.out.println(ar.abs(-8));
	}

}
