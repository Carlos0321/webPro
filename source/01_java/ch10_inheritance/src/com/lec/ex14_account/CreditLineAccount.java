package com.lec.ex14_account;

//CreditLineAccount c2 = new CreditLineAccount("11-11","ȫ","1111-2222-3333-4444",10000)
//CreditLineAccount c2 = new CreditLineAccount("11-11","ȫ",1000,"1111-2222-3333-4444",10000)
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // ī�� �ѵ�

	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}

	public CreditLineAccount(String accountNo, String ownerName, long balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
	}

	@Override
	public void pay(String cardNum, int amount) {
		if (getCardNo().equals(cardNum)) { // �ùٸ� ī�� ��ȣ���� Ȯ��
			if (creditLine >= amount) { //���� �������� (�ѵ��� ������ �ݾ� �̻�)
				creditLine =creditLine - amount;
				System.out.printf("%s(%s)�� %d�� �����Ͽ� �ѵ� %d�� ���ҽ��ϴ�\n", getOwnerName(), getAccountNo(), amount, creditLine );
			} else {
				System.out.printf("%s(%s)�� �ѵ� %d������ %d�� ���� �Ұ����մϴ�", getOwnerName(), getAccountNo(), creditLine,amount);
			}
		} else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���");
		} // if
	}//pay

}