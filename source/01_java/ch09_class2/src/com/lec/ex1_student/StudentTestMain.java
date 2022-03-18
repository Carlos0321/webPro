package com.lec.ex1_student;

public class StudentTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student("���켺", 90, 90, 90);
		Student s2 = new Student("���ϴ�", 81, 90, 90);
		Student s3 = new Student("Ȳ����", 91, 90, 90);
		Student s4 = new Student("������", 80, 90, 90);
		Student s5 = new Student("������", 70, 90, 90);
		Student[] student = {s1, s2, s3, s4, s5};
		String[] title = {"�̸�","����","����","����","����","���"};
		int [] tot = new int[5]; //tot[0] �����, tot[1]�����...tot[4]��մ���
		double[] avg = new double[5] ; // avg[0] ���� ��� ... 
		
		printLine();
		System.out.println("\t\t\t����ǥ");
		printLine('-',50);
		for(String t : title) {
			System.out.print('\t'+t);
		}
		System.out.println();
		printLine('-',50);
		for(Student s : student) {
			s.print();  //��� �� ����
			tot[0] += s.getKor(); // tot[0] = tot[0]+ s.getKor();
			tot[1] += s.getEng();
			tot[2] += s.getMat();
			tot[3] += s.getTot();
			tot[4] += s.getAvg();
		}
		for(int idx= 0 ; idx < avg.length; idx ++) { //����� ��� ��� avg[0] = tot[0]/5
			
			avg[idx] = (double)tot[idx]/student.length;
		}
		printLine();
		System.out.print("����\t");
		for (int idx = 0; idx < tot.length; idx++) {
			
		}
		printLine();
		System.out.print("����\t");
		for(int t : tot) {
			System.out.print(t + " ");
		}
		System.out.println("\t���\t");
		for(double a : avg) {
			System.out.print(a + "t");
		}
	}
	private static void printLine() {
		for(int i=0 ; i<65 ; i++) {
			System.out.print('��');
		}
		System.out.println();
	}
	private static void printLine(char ch, int cnt) {
		System.out.print("\t");
		for(int i=0 ; i<cnt ; i++) { // ���ٿ� cnt�� ch�� ���
			System.out.print(ch);
		}
		System.out.println(); // ����
	}
}