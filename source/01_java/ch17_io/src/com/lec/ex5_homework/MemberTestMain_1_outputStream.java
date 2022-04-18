package com.lec.ex5_homework;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.StringTokenizer;
public class MemberTestMain_1_outputStream {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String answer, name, phone, birth, address;
		int year,month, day;
		Date birthday;
		ArrayList<Member> members = new ArrayList<Member>();
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		String today = sdf.format(now); // "04-06"
		do {
			System.out.print("회원가입 하실래요(단, 원하지 않으면 N)? ");
			answer = scanner.next();
			if(answer.equalsIgnoreCase("n")) break;
			System.out.print("회원이름 ? ");
			name = scanner.next();
			System.out.print("전화번호 ? ");
			phone = scanner.next();
			System.out.print("생일(yyyy-MM-dd) ? ");
			birth = scanner.next();
			StringTokenizer token = new StringTokenizer(birth, "-");
			if(token.countTokens()==3) {
				year  = Integer.parseInt(token.nextToken());
				month = Integer.parseInt(token.nextToken());
				day   = Integer.parseInt(token.nextToken());
				//birthday = new Date(year-1900, month-1, day);
				birthday = new Date(new GregorianCalendar(year, month-1, day).getTimeInMillis());
			}else {
				System.out.println("생일 정보가 올바르지 않습니다. 확인해 주세요");
				continue;
			}
			if(today.equals(birth.substring(birth.indexOf("-")+1))) {
				System.out.println(name+"님 생일이시군요. 생일축하합니다");
			}
			System.out.print("주소 ? ");
			scanner.nextLine();
			address = scanner.nextLine();
			members.add(new Member(name, phone, birthday, address));
		}while(true);
		scanner.close();
		// 2. ArrayList 정보와 몇명 가입했는지 파일 출력과 콘솔 출력한다.
		OutputStream os = null;
		try {
			os = new FileOutputStream("src/com/lec/ex5_homework/member.txt");
			for(Member member : members) {
				System.out.print(member);
				os.write(member.toString().getBytes());
			}
			String msg = String.format("\t\t\t...이하 %d명 가입\n\n", members.size());
			System.out.println(msg);
			os.write(msg.getBytes());
		} catch (FileNotFoundException e) {
			System.out.println("파일 못 찾음"+e.getMessage());
		} catch (IOException e) {
			System.out.println("쓰기 예외"+e.getMessage());
		}finally {
			try {
				if(os!=null) os.close();
			} catch (Exception ignore) { 
				System.out.println(ignore.getMessage());
			}
		}//try-catch-finally
	}
}
