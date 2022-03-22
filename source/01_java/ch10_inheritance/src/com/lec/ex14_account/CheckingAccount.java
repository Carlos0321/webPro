package com.lec.ex14_account;

//CheckingAccount a2 = new CheckingAccount(11-11,ȫ�浿,2000��,1111-2222-3333-4444
public class CheckingAccount extends Account {

	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) { // �ܾ��� 0
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)�� ���� ���� �����մϴ�. ���� �� �� ���� ���̾��\n", ownerName, accountNo);
	}

	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)�� %d�� �Ա� ���� ���� �����մϴ�\n", ownerName, accountNo, balance);
	}

//a2.pay("ī���ȣ",�ݾ�);
	public void pay(String cardNum, int amount) {
		if (this.cardNo.equals(cardNum)) { // �ùٸ� ī�� ��ȣ���� Ȯ��
			if (getBalance() >= amount) { // ���� �������� getBalance�� �Լ��Ƿ� ()����� �Ű����� ���!
				setBalance(getBalance() - amount); // balance = balance -amount;
				System.out.printf("%s(%s)�� %d�� �����Ͽ� %d�� ���ҽ��ϴ�\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			} else {
				System.out.printf("%s(%s)�� �ܾ� %d������ %d�� ���� �Ұ����մϴ�", getOwnerName(), getAccountNo(), getBalance(),
						amount);
			}
		} else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���");
		} // if
	}// pay

	public String getCardNo() {
		return cardNo;
	}

}// class