package com.lec.student;

public class Student {
	public static int num = 0;

	private String name;
	private int no;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int tot;

	public Student() {} //����Ʈ ������ 
	//no = ++num;  ���� �ȵȴ� ������ ��������  
	public Student(String name, int kor, int eng, int math) {

		no = ++num;
		tot = (kor + eng + math);
		avg = tot / 3.0;

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;

	}
//	public void infoPrint() {
//		System.out.println("no = " + no + "\t ��ȣ �̸� num = " + num);   //�� �κ� ���� 
//	}
	// s.print( -> ���켺 90 90 90 270 90.0 sysout
	public void print() {
		System.out.printf("%d\t %s \t %d \t %d \t %d \t %d  \t %.1f\n",no, name, kor, eng, math, tot, avg);
	}

	// Sysout (s.infoString)
	public String infoString() { //�� �κ� ���� 
		return String.format("\t%d %s  %d  %d   %d  %d  %.1f", no,name, kor, eng, math, tot, avg);
	}

	public String getName() {
		return name;
	}

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return math;
	}

	public int getTot() {
		return tot;
	}
	public double getAvg() {
		return avg;
	}
}
