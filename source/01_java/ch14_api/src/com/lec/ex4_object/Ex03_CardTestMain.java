package com.lec.ex4_object;

import java.util.Random;

// comCard는 랜덤카드 선택하여 배열방 0~끝방까지 일치하는지 불일치 하는지 구현해보기 
public class Ex03_CardTestMain {

	public static void main(String[] args) {
		Card[] cards = {new Card ('◆',1),new Card ('◆',2),
						new Card ('◆',3),new Card ('◆',4)};
		for(Card card : cards) {
			System.out.println(card);
		}
		Random random = new Random();
		char[] kinds = {'♠', '◆',  '♣', '♥'};
		Card comCard = new Card(kinds[random.nextInt(4)],random.nextInt(13)+1);
		System.out.println("컴퓨터가 랜덤하게 선택한 카드 : " + comCard);
		for(int idx=0; idx<cards.length; idx++) {
			if(cards[idx].equals(comCard)) {
				System.out.println(idx+"번째 카드와 일치★");
			}else {
				System.out.println(idx+"번째 카드와 불일치");
			}
		}
//		if(cards[3].equals(comCard)) {
//			System.out.println("두 카드는 일치합니다");
//		}else {
//			System.out.println("두 카드는 불일치합니다");
//		}
	}

}
