package com.lec.ex02_store;

public class TestMain {

	public static void main(String[] args) {
		HeadQuarterStore[] store = {new Store1("===1호점==="),
		                            new Store2("===2호점==="),
	                                new Store3("===3호점===")};
		
		for(int idx= 0 ; idx<store.length ; idx++) {
			System.out.println(store[idx].getStr()); //출력 질문 
			store[idx].kimchi();
			store[idx].bude();
			store[idx].bibib();
			store[idx].sunde();
			store[idx].gonggibab();
		}
		for(HeadQuarterStore st : store) {
			System.out.println(st.getStr());  //이 부분 질문하기 
			st.kimchi();
			st.bude();
			st.bibib();
			st.sunde();
			st.gonggibab();
			
		}
	}

}
