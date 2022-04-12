package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Member> array = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("회원 가입 정보를 입력하세요(Y/N) :");
			if (sc.next().equalsIgnoreCase("n")) {
				break;

			} else {
				System.out.print("이름을 입력하세요 : ");
				String name = sc.next();
				System.out.print("전화번호를 입력하세요 :");
				String tel = sc.next();
				System.out.println("주소를 입력하세요 : ");
				String address = sc.nextLine();
				array.add(new Member(name,tel,address));

			}
		} while (true);
		{
			if (array.size() == 0) {
				System.out.println("등록된 회원 정보가 없습니다.");
			} else {
				System.out.println(array);
			}
		}
	}
}
