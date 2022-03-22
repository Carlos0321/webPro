package com.lec.ex14_account;
//������(�Ӽ�, ������� , �ν��Ͻ�����) : ���¹�ȣ(accountNo:String), 
//������(ownerName:String), 
//�ܾ�(balance:long)
//���(�޼ҵ�) : �����ϴ�(void deposit(int)). 
//�����ϴ�(int withdraw(int)), 
//�ܾ���ȸ(long infoPrint())
// Account a = new Account("100-1", "ȫ�浿"); /Account("100-2","�ű浿",2200000000)
public class Account {
	private String accountNo;
	private String ownerName;
	private long balance;
	
	public Account( ) {} // ����Ʈ ������  (�Ű����� ����) �� ����Ʈ�� ����������?
	public Account(String accountNo, String ownerName) { //������ ���� : ������ �ʱ�ȭ 
		this.accountNo =accountNo;
		this.ownerName =ownerName;
		System.out.printf("%s(%s)�� ���� ���� �����մϴ�. ���� �� �� ���� ���̾��\n", ownerName, accountNo);
	}
	public Account(String accountNo, String ownerName, long balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance ;
		System.out.printf("%s(%s)�� %d�� �Ա� ���� ���� �����մϴ�\n", ownerName, accountNo, balance);
	}
	//�޼ҵ忹���ϴ�(void deposit(int)),�����ϴ�(int withdraw(int)), �ܾ���ȸ(long getBalance())
	public void deposit(int money) { //������ ������ ��� money�� ������ ����ó�� 
		if(money >=0) {
			balance += money;
			System.out.printf("%s(%s)�� %d�� �Ա� �Ϸ��߽��ϴ�. ���� �ܾ� %d��\n" ,
							ownerName, accountNo, money, balance);
		}else {
			System.out.println("���̳ʽ� �Դϴ�");
		}
	}
	public void withdraw(int money) {
		if(money <=balance) {
			balance -= money; 
			System.out.printf("%s(%s)�� %d�� ���� �Ϸ��߽��ϴ�. ���� �ܾ� %d��\n" ,
					ownerName, accountNo, money, balance);
		}else {
			System.out.println(ownerName+"�� �ܾ��� �����Ͽ� ������ �Ұ����մϴ� ");
		}
	}
	public String infoPrint() { // ȫ�浿(100-456-67899)�� �ܾ� : 1000��
		return String.format("%s(%s)�� �ܾ� : %d��\n", ownerName, accountNo, balance); //format�� printf ���¹���� �Ȱ���
//		return ownerName+"("+accountNo+") " + "�� �ܾ� : "+ balance + "��";
	}
	// setter & getter 
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
	
}