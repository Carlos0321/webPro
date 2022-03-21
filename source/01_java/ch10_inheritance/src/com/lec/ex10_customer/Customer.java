package com.lec.ex10_customer;
// name, tel, address, sum, point, date, vip
// Customer c = new Customer("ȫ" "010" "��" "1995-12-12")
public class Customer extends Person{
	private String address ;
	private int sum;     //���Ŵ����ݾ�
	private int point ;   
	private String date;  //�����(DateŸ�Ե� ����)
	private boolean vip; // true�� vip false�� �Ϲݰ� 
	public Customer(String name, String tel, String address, String date) {
		super(name, tel);  //ù��° ���ο� �;��� 
		this.address = address;
		this.date = date;
		point = 1000; //�� ������ 1000����Ʈ �ڵ��ο� 
		System.out.println(name + "�� ���簨��. ����Ʈ 1000���� ������");

	}
	public void buy(int price) {// c.buy(1000)
		sum += price;
		int temPoint = (int)(price*0.05);
		point += temPoint ;
		System.out.println(getName()+ "�� ����. �̹� ���ŷ� ����Ʈ" + temPoint +"�� �߰��Ǿ� �� ����Ʈ : " + point);
		if(sum >= 1000000 && vip==false) {
			vip = true ; //���Ŵ����ݾ��� 100���� �̻�� vip ������ 
			System.out.println(getName() + "�� VIP������ ���׷��̵� �Ǽ̽��ϴ�");
			
		}//if
	}//buy
	//c.print() vs sysout(c.infoString()) vs sysout(c)  / super.infoString() "[�̸�]ȫ [��ȭ]010-9999-9999
	//@: ������̼�
	@Override
	public String infoString() {
		return super.infoString() + "[�ּ�]"+ address+"[����Ʈ}"+point+"[�����ݾ�]"+sum;
	}
}
