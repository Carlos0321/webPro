package com.lec.ex07.friend;
// this. : �� ��ü��
// this() : �� Ŭ������ ������ �Լ� 
// super
public class Friend {
	private String name ;
	private String tell ; //"010-9999-9999" Friend f = new Friend("ȫ�浿")
	public Friend() {
		System.out.println("�Ű����� ���� ������ �Լ�");
	}
	public Friend(String name) {
		this();
		this.name = name;
		System.out.println("�Ű����� �ϳ�¥�� ������ �Լ� ");
	}
	public Friend (String name, String tell) {
		this(name) ; //Friend(name) ȣ�� 
		this.tell = tell;
		System.out.println("�Ű����� �ΰ�¥�� �������Լ�");
	}
	public String infoString() {
		return "[�̸�]" + name + "[��ȭ]" + tell;
	}
}
