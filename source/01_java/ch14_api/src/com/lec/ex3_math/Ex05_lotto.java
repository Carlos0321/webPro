package com.lec.ex3_math;

import java.util.Random;

// �ζǹ�ȣ 6�� �̱� 
public class Ex05_lotto {
	public static void main(String[] args) {
		int[] lotto = new int[6];
		Random random = new Random();
		for (int idx = 0; idx < lotto.length; idx++) {
			//lotto[idx] = random.nextInt(45) + 1;  �ߺ��� �� �ִ� 
			int temp = random.nextInt(45) + 1; // ���� ������ �ӽ� ������ �����ϰ� 0~idx��°�� temp�� �ִ��� Ȯ�� 
			boolean ok = true ;  //���� ������ �ߺ��� �ƴ� ��� true/ �ߺ��� ��� false
			for(int i=0 ; i <idx ; i++) {
				if(temp == lotto[i]) { // ���� ������ �ߺ��̴� �ٽ� �̾� 
					idx --;
					ok = false;
					break;
				}
			} // for : �߻��� ������ ���� �չ濡 ����Ǿ����� Ȯ��(�ߺ��� �������� Ȯ��) 
			if(ok) {
				lotto[idx] =temp;
			}
			// System.out.println("�ζ� ��ȣ �̱� : " + (random.nextInt(45)+1) );
		} // for
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] > lotto[j]) { // i��° ���� j���� ������ ũ�� �ٲ�
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		} // ���� ���� ����
		for (int l : lotto) {
			System.out.println(l + "");
		}

	}// main
}// class
