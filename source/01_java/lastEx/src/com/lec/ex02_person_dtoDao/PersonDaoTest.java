package com.lec.ex02_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance(); //싱글톤패턴 private를 이용하기위해
		PersonDto dto = new PersonDto("홍길동", "배우", 92, 100, 90);
		int result = dao.insertPerson(dto); //입력 test
		System.out.println(result==PersonDao.SUCCESS? "입력성공" : "입력실패");
		System.out.println("--------------------2번 test------------------");
		ArrayList<PersonDto> dtos = dao.selectJname("배우"); //직업별 조회 test
		if(dtos.isEmpty()) {
			System.out.println("해당 직업의 사람이 등록되지 않았습니다.");
		}else {
			
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
			System.out.println("-----------------3번 test-----------------");
			dtos = dao.selectAll(); // 3. 전체 조회 test
			if(dtos.size()!=0) {
				for(PersonDto d : dtos) {
					System.out.println(d);
				}//for
			}else {
				System.out.println("등록된 사람이 없습니다");
			}
			Vector<String> jnames=dao.jnamelist(); //직업명 리스트test
			System.out.println(jnames);
		}
	}
}
