package com.lec.condition;

public class Ex01_if {

	public static void main(String[] args) {

		int seoulLunchPrice = 5000;
		if (seoulLunchPrice >= 8000) {
			System.out.println("서울 점심값 비싸네요");
		} else if (seoulLunchPrice >= 6000) {
			System.out.println("서울 밥값 인정. 그러네요");
		} else if (seoulLunchPrice >= 5000) {
			System.out.println("개꿀");
		} else {
			System.out.println("식당 주인 망할까봐 걱정되네");
		}
	}
}
