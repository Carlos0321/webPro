package com.lec.ex14_account;

//CreditLineAccount c2 = new CreditLineAccount("11-11","홍","1111-2222-3333-4444",10000)
//CreditLineAccount c2 = new CreditLineAccount("11-11","홍",1000,"1111-2222-3333-4444",10000)
public class CreditLineAccount extends CheckingAccount {
	private int creditLine; // 카드 한도

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
		if (getCardNo().equals(cardNum)) { // 올바른 카드 번호인지 확인
			if (creditLine >= amount) { //지불 가능한지 (한도가 지불할 금액 이상)
				creditLine =creditLine - amount;
				System.out.printf("%s(%s)님 %d원 지불하여 한도 %d원 남았습니다\n", getOwnerName(), getAccountNo(), amount, creditLine );
			} else {
				System.out.printf("%s(%s)님 한도 %d원으로 %d원 지불 불가능합니다", getOwnerName(), getAccountNo(), creditLine,amount);
			}
		} else {
			System.out.println("올바른 카드번호를 입력하세요");
		} // if
	}//pay

}