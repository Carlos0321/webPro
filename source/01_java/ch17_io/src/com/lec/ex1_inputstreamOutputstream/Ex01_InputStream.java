package com.lec.ex1_inputstreamOutputstream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
// (1) 파일은 연다(입력용 스트림객체생성) (2)데이터를 읽는다(read()) (3)파일을 닫는다
public class Ex01_InputStream {
	public static void main(String[] args) {
		InputStream is = null; 
		try {
			is = new FileInputStream("txtFile/inTest.txt"); // 1. 파일을 연다
			while(true) { // 2. 데이터를 읽는다
				int i = is.read(); // 1byte씩 읽기
				if(i==-1) break;   // 파일의 끝이면 반복문 break
				System.out.print((char)i + "(" + i +")");
			}
			System.out.println("\n끝");
		} catch (FileNotFoundException e) {
			System.out.println("파일을 못 찾은 경우 예외 : "+e.getMessage());
		} catch (IOException e) {
			System.out.println("파일을 못 읽는 경우 예외 : " +e.getMessage());
		} finally {
			try {// 3. 파일을 닫는다
				if(is!=null) is.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}





