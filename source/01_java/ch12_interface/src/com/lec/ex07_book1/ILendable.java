package com.lec.ex07_book1;
//Book�� �۾�����
public interface ILendable {
	public byte STATE_BORROWED = 1;  //������
	public byte STATE_NORMAL = 0 ;   //������� ���� ���� "���Ⱑ��"�� �ǹ�
	public void checkOut(String borrower, String checkOutDate);  //����� �����ΰ� ������ �̿�  
	public void checkIn();  //�ݳ�
	public void printState(); //���������� ���� ���� ��� 
}
