package com.lec.student;

public class StudentMainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printLine('■', 50);
		System.out.println("\t\t\t성적표");
		printLine(50);
		System.out.println("번호 \t 이름 \t국어 \t영어 \t수학 \t총점 \t평균");
		printLine(50);

		Student s1 = new Student("정우성", 90, 80, 95);
		Student s2 = new Student("김하늘", 100, 80, 95);
		Student s3 = new Student("황정민", 95, 80, 90);
		Student s4 = new Student("강동원", 95, 90, 99);
		Student s5 = new Student("유아인", 90, 90, 90);
		Student[] student = { s1, s2, s3, s4, s5 };

		String[] title = { "이름", "국어", "영어", "수학", "총점", "평균" };
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
			avg[idx] = tot[idx] / student.length; // 버림
//			avg[idx] = (int)tot[idx]/(double)student.length+0.5; //반올림
//			avg[idx] = (int)Math.round(tot[idx](double)student.length);
		}
		printLine('-', 50);
		System.out.print("\t 총점");
		for (int t : tot) {
			System.out.print("\t" +t);
		}
		System.out.print("\n\t평균");
		for (double a : avg) {
			System.out.print("\t" + a);
		}
		System.out.println();
		printLine('■', 50);
	}

	private static void printLine(char c, int num) {
		for (int i = 0; i < num; i++) {
			System.out.print(c);
		}
		System.out.println(); // 개행 
	}

	private static void printLine(int cnt) {
		for (int i = 0; i < cnt; i++) {
			System.out.print('-');
		}
		System.out.println(); // 개행
	}
}