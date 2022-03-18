package com.lec.ex3_account;

public class AccountTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account hong = new Account("100-1", "홍길동", 2200000000L);
		Account shin = new Account("100-1", "신길동");
		Account acc = new Account();
		
		acc.setAccountNo("101-2");
		acc.setOwnerName("유길동");
		System.out.println(hong.infoPrint());
		System.out.println(shin.infoPrint());
		System.out.println(acc.infoPrint());
		
		shin.deposit(2000);
		shin.withdraw(3000);
		hong.withdraw(20000);
		acc.withdraw(10);
		System.out.println(hong.infoPrint());
		System.out.println(shin.infoPrint());
		System.out.println(acc.infoPrint());
	}

}
