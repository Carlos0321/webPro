package com.lec.ex14_account;

public class TestMain {

	public static void main(String[] args) {
		Account a1 = new Account("111-11111", "È«±æµ¿");
		a1.deposit(3000);
		a1.deposit(6000);
		a1.withdraw(1000);
		System.out.println("---------------------");
		CheckingAccount a2 = new CheckingAccount("222-2222","½Å±æµ¿",1000,"1111-2222-3333-4444");
		a2.deposit(9000);
		a2.withdraw(20000);
		a2.pay("1111-2222-3333-1111", 20000);
		a2.pay("1111-2222-3333-4444", 20000);
		a2.pay("1111-2222-3333-4444", 10000);
		System.out.println("-----------------------");
		CreditLineAccount a3 = new CreditLineAccount("33-333", "È«±æ¼ø", 10000, "1111-1111",10000);
		a3.deposit(10000);
		a3.pay("1111-1111",15000);
	}

}
