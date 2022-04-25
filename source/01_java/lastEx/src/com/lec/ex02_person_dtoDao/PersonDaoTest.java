package com.lec.ex02_person_dtoDao;

import java.util.ArrayList;
import java.util.Vector;

public class PersonDaoTest {
	public static void main(String[] args) {
		PersonDao dao = PersonDao.getInstance(); //�̱������� private�� �̿��ϱ�����
		PersonDto dto = new PersonDto("ȫ�浿", "���", 92, 100, 90);
		int result = dao.insertPerson(dto); //�Է� test
		System.out.println(result==PersonDao.SUCCESS? "�Է¼���" : "�Է½���");
		System.out.println("--------------------2�� test------------------");
		ArrayList<PersonDto> dtos = dao.selectJname("���"); //������ ��ȸ test
		if(dtos.isEmpty()) {
			System.out.println("�ش� ������ ����� ��ϵ��� �ʾҽ��ϴ�.");
		}else {
			
			for(PersonDto d : dtos) {
				System.out.println(d);
			}
			System.out.println("-----------------3�� test-----------------");
			dtos = dao.selectAll(); // 3. ��ü ��ȸ test
			if(dtos.size()!=0) {
				for(PersonDto d : dtos) {
					System.out.println(d);
				}//for
			}else {
				System.out.println("��ϵ� ����� �����ϴ�");
			}
			Vector<String> jnames=dao.jnamelist(); //������ ����Ʈtest
			System.out.println(jnames);
		}
	}
}
