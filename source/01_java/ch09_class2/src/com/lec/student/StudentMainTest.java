package com.lec.student;

public class StudentMainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printLine('��', 50);
		System.out.println("\t\t\t����ǥ");
		printLine(50);
		System.out.println("��ȣ \t �̸� \t���� \t���� \t���� \t���� \t���");
		printLine(50);

		Student s1 = new Student("���켺", 90, 80, 95);
		Student s2 = new Student("���ϴ�", 100, 80, 95);
		Student s3 = new Student("Ȳ����", 95, 80, 90);
		Student s4 = new Student("������", 95, 90, 99);
		Student s5 = new Student("������", 90, 90, 90);
		Student[] student = { s1, s2, s3, s4, s5 };

		String[] title = { "�̸�", "����", "����", "����", "����", "���" };
		int[] tot = new int[5];
		double[] avg = new double[5];


		for (Student s : student) {
			s.print();  
//			System.out.println(s.infoString());
			tot[0] += s.getKor();  
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();

		}
		for (int idx = 0; idx < avg.length; idx++) {
			avg[idx] = tot[idx] / student.length; // ����
//			avg[idx] = (int)tot[idx]/(double)student.length+0.5; //�ݿø�
//			avg[idx] = (int)Math.round(tot[idx](double)student.length);
		}
		printLine('-', 50);
		System.out.print("\t ����");
		for (int t : tot) {
			System.out.print("\t" +t);
		}
		System.out.print("\n\t���");
		for (double a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
		printLine('��', 50);
	}

	private static void printLine(char c, int num) {
		for (int i = 0; i < num; i++) {
			System.out.print(c);
		}
		System.out.println(); // ���� 
	}

	private static void printLine(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print('-');
		}
		System.out.println(); // ����
	}
}