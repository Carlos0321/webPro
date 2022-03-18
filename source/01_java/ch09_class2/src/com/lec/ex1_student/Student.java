package com.lec.ex1_student;

public class Student {

	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private double avg;
	private int tot;

	public Student() {
	}

	public Student(String name, int kor, int eng, int math) {

		tot = (kor + eng + math);
		avg = tot / 3.0;

		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		

	}

	public void print() {
		System.out.printf("\t%s \t%d \t%d \t%d \t%d %.1f", name, kor, eng, math, tot, avg);
	}

	public String infoString() {
		return String.format("\t%s  %d  %d   %d  %d   %.1f", name, kor, eng, math, tot, avg);
	}
	public String getName() {return name;}
	public int getKor() {return kor;}
	public int getEng() {return eng;}
	public int getMat() {return math;}
	public int getTot() {return sum;}
	public double getAvg() {return avg;}
}