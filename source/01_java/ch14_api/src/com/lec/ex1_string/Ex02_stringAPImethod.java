package com.lec.ex1_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "         ja   va        ";
		System.out.println("1." +str1.concat(str2)); //abcXabc
		System.out.println("2."+str1.substring(3)); // Xabc
		System.out.println("3." + str1.substring(3,5)); //3번째부터 5번째 앞 까지!!! Xa
		System.out.println("4." + str1.length()); //글자길이 7
		System.out.println("5." + str1.toUpperCase());// 대문자로ABCXABC
		System.out.println("6." + str1.toLowerCase());// 소문자로abcxabc
		System.out.println("7." + str1.charAt(3)); //3번째 문자 'X'
		System.out.println("8." + str1.indexOf('b')); //첫번째 'b'가 나오는 인덱스 1
		System.out.println("9." + str1.indexOf('b', 3)); // 3번째 부터 검색해서 첫번째 'b' 위치
		System.out.println("10." + str1.indexOf("abc")); //첫번째 "abc"나오는 위치
		System.out.println("11." + str1.indexOf("abc",3)); //3번째 부터 검색해서  "abc"나오는 위치 4
		System.out.println("12." + str1.indexOf('z')); // 없으면 -1 
		System.out.println("13." + str1.lastIndexOf('b')); //마지막 'b' 위치 5
		System.out.println("14." + str1.lastIndexOf('b',3));  //3번째부터 맨 마지막 b 1
		System.out.println("15."+ str1.equals(str2)); // str1과 str2가 같은 문자열인지 false
		System.out.println("16."+ str1.equalsIgnoreCase(str2)); // 대소문자 구분없이 비교 true
		System.out.println("17."+ str3.trim()); //앞 뒤 공백 제거 
		System.out.println("18."+ str1.replace('a', '9')); // 'a'를 9로 수정
		System.out.println("19."+ str1.replace("abc", "★")); 
		System.out.println("str3의 space없애기"+str3.replace(" ", ""));
		System.out.println("20."+str1.replaceAll("abc", "Z"));
		System.out.println("20."+str1.replace("abc", "Z"));
		// 정규표현식 https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D
		String str = "안녕Hello";  //영문자 다 바꿔 
		System.out.println(str.replaceAll("[a-zA-Z]", "")); //알파벳을 ""로 수정
		System.out.println(str.replaceAll("[가-힣]","")); //한글문자를 ""로 수정 
		//문자열 메소드는 문자열을 수정안함 
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+ str2);
		System.out.println("str3 = "+ str3);
	}

}
