package com.lec.ex3_readerwriter;
import java.io.*;
public class Ex03_BufferReader {
	public static void main(String[] args) {
		Reader     reader = null;
		BufferedReader br = null;
		try {
			reader = new FileReader("txtFile/inTest.txt"); // 1. 기본스트림 생성
			br     = new BufferedReader(reader); // 보조스트림 생성
			int cnt = 0;
			while(true) {
				String linedata = br.readLine(); // 2. 한줄씩 데이터 읽기
				if(linedata==null) break;  // 파일의 끝인 경우 break
				System.out.println(++cnt +  linedata);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try { // 3. 파일 닫기
				if(br    != null) br.close();
				if(reader!= null) reader.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
