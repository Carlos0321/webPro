package com.lec.ex3_set;

import java.util.HashSet;

public class Ex03_StudentHashSet {

	public static void main(String[] args) {
		HashSet<Student> students = new HashSet<Student>() ;
		Student s = new Student(6,  "이순신");
		students.add(s);
		students.add(s);
		System.out.println(students);
		students.add(new Student(3,"홍길동"));
		students.add(new Student(3,"홍길동")); //데이터는 같지만 다른곳에 저장되어서 별개의 객체가 된것이다.  
		students.add(new Student(6,"이순신"));
		System.out.println(students);
	}

}
