package quiz;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain1 {

	public static void main(String[] args) {
		ArrayList<Member> array = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("ȸ�� ���� ������ �Է��ϼ���(Y/N) :");
			if (sc.next().equalsIgnoreCase("n")) {
				break;

			} else {
				System.out.print("�̸��� �Է��ϼ��� : ");
				String name = sc.next();
				System.out.print("��ȭ��ȣ�� �Է��ϼ��� :");
				String tel = sc.next();
				System.out.println("�ּҸ� �Է��ϼ��� : ");
				String address = sc.nextLine();
				array.add(new Member(name,tel,address));

			}
		} while (true);
		{
			if (array.size() == 0) {
				System.out.println("��ϵ� ȸ�� ������ �����ϴ�.");
			} else {
				System.out.println(array);
			}
		}
	}
}
