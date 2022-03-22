package com.lec.ex14_account;

//CheckingAccount a2 = new CheckingAccount(11-11,홍길동,2000원,1111-2222-3333-4444
public class CheckingAccount extends Account {

	private String cardNo;

	public CheckingAccount(String accountNo, String ownerName, String cardNo) { // 잔액은 0
		super(accountNo, ownerName);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)님 계좌 개설 감사합니다. 돈은 왜 안 갖고 오셨어요\n", ownerName, accountNo);
	}

	public CheckingAccount(String accountNo, String ownerName, long balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		System.out.printf("%s(%s)님 %d원 입금 계좌 개설 감사합니다\n", ownerName, accountNo, balance);
	}

//a2.pay("카드번호",금액);
	public void pay(String cardNum, int amount) {
		if (this.cardNo.equals(cardNum)) { // 올바른 카드 번호인지 확인
			if (getBalance() >= amount) { // 지불 가능한지 getBalance는 함수므로 ()써야함 매개변수 없어도!
				setBalance(getBalance() - amount); // balance = balance -amount;
				System.out.printf("%s(%s)님 %d원 지불하여 %d원 남았습니다\n", getOwnerName(), getAccountNo(), getBalance(), amount);
			} else {
				System.out.printf("%s(%s)님 잔액 %d원으로 %d원 지불 불가능합니다", getOwnerName(), getAccountNo(), getBalance(),
						amount);
			}
		} else {
			System.out.println("올바른 카드번호를 입력하세요");
		} // if
	}// pay

	public String getCardNo() {
		return cardNo;
	}

}// class