package com.lec.ex1_string;

public class Ex02_stringAPImethod {

	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "         ja   va        ";
		System.out.println("1." +str1.concat(str2)); //abcXabc
		System.out.println("2."+str1.substring(3)); // Xabc
		System.out.println("3." + str1.substring(3,5)); //3¹øÂ°ºÎÅÍ 5¹øÂ° ¾Õ ±îÁö!!! Xa
		System.out.println("4." + str1.length()); //±ÛÀÚ±æÀÌ 7
		System.out.println("5." + str1.toUpperCase());// ´ë¹®ÀÚ·ÎABCXABC
		System.out.println("6." + str1.toLowerCase());// ¼Ò¹®ÀÚ·Îabcxabc
		System.out.println("7." + str1.charAt(3)); //3¹øÂ° ¹®ÀÚ 'X'
		System.out.println("8." + str1.indexOf('b')); //Ã¹¹øÂ° 'b'°¡ ³ª¿À´Â ÀÎµ¦½º 1
		System.out.println("9." + str1.indexOf('b', 3)); // 3¹øÂ° ºÎÅÍ °Ë»öÇØ¼­ Ã¹¹øÂ° 'b' À§Ä¡
		System.out.println("10." + str1.indexOf("abc")); //Ã¹¹øÂ° "abc"³ª¿À´Â À§Ä¡
		System.out.println("11." + str1.indexOf("abc",3)); //3¹øÂ° ºÎÅÍ °Ë»öÇØ¼­  "abc"³ª¿À´Â À§Ä¡ 4
		System.out.println("12." + str1.indexOf('z')); // ¾øÀ¸¸é -1 
		System.out.println("13." + str1.lastIndexOf('b')); //¸¶Áö¸· 'b' À§Ä¡ 5
		System.out.println("14." + str1.lastIndexOf('b',3));  //3¹øÂ°ºÎÅÍ ¸Ç ¸¶Áö¸· b 1
		System.out.println("15."+ str1.equals(str2)); // str1°ú str2°¡ °°Àº ¹®ÀÚ¿­ÀÎÁö false
		System.out.println("16."+ str1.equalsIgnoreCase(str2)); // ´ë¼Ò¹®ÀÚ ±¸ºĞ¾øÀÌ ºñ±³ true
		System.out.println("17."+ str3.trim()); //¾Õ µÚ °ø¹é Á¦°Å 
		System.out.println("18."+ str1.replace('a', '9')); // 'a'¸¦ 9·Î ¼öÁ¤
		System.out.println("19."+ str1.replace("abc", "¡Ú")); 
		System.out.println("str3ÀÇ space¾ø¾Ö±â"+str3.replace(" ", ""));
		System.out.println("20."+str1.replaceAll("abc", "Z"));
		System.out.println("20."+str1.replace("abc", "Z"));
		// Á¤±ÔÇ¥Çö½Ä https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D
		String str = "¾È³çHello";  //¿µ¹®ÀÚ ´Ù ¹Ù²ã 
		System.out.println(str.replaceAll("[a-zA-Z]", "")); //¾ËÆÄºªÀ» ""·Î ¼öÁ¤
		System.out.println(str.replaceAll("[°¡-ÆR]","")); //ÇÑ±Û¹®ÀÚ¸¦ ""·Î ¼öÁ¤ 
		//¹®ÀÚ¿­ ¸Ş¼Òµå´Â ¹®ÀÚ¿­À» ¼öÁ¤¾ÈÇÔ 
		System.out.println("str1 = "+str1);
		System.out.println("str2 = "+ str2);
		System.out.println("str3 = "+ str3);
	}

}
