package com.lec.ex4_object;
// �� ��  �� �� ��翡 1-13 ���� 
public class Card {
	private char kind; // �� ��  �� ��
	private int num;  //1~13
	public Card(char kind, int num) {
		this.kind = kind;
		this.num = num;
	}
	@Override
	public String toString() {
		return "ī���" + kind + "," + num ;
	}
	//c1.equals(c2) => c1�� kind�� c2�� kind, c1�� num�� c2�� num�� �� 
	@Override
	public boolean equals(Object obj) {
		//c1.equals(c2) => c1�� �� ��ü, c2�� obj.
		if(obj !=null && obj instanceof Card) { //�� ��ü�� kind�� obj.kind��, �� ��ü�� num�� obj.num�� ��
			boolean kindCheck = kind == ((Card)obj).kind;
			boolean numCheck = num ==((Card)obj).num;
			return kindCheck && numCheck;
		}
		return false;
	}
}