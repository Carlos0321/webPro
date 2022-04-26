package com.lec.ex03_student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class StudentMng extends JFrame implements ActionListener {
	// DB����
	private StudentDao dao = StudentDao.getInstance();
	private ArrayList<StudentDto> student;
	// ȭ�鱸��
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtSNo, txtSName, txtScore;
	private Vector<String> mNames; // �޺��ڽ��� �� ��������Ʈ�� ���� vector
	private JComboBox<String> comMname;
	private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch, btnInput, btnUpdate, btnStudentOut, btnExpelOut,
			btnExpel, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;

	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane(); // ȭ�鱸��
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(10);
		txtSName = new JTextField(10);
		mNames = dao.getMNamelist();
		comMname = new JComboBox<String>(mNames);
		txtScore = new JTextField(10);
		btnSNoSearch = new JButton("�й��˻�");
		btnSNameSearch = new JButton("�̸��˻�");
		btnMNameSearch = new JButton("�����˻�");
		btnInput = new JButton("�л��Է�");
		btnUpdate = new JButton("�л�����");
		btnStudentOut = new JButton("�л����");
		btnExpelOut = new JButton("���������");
		btnExpel = new JButton("����ó��");
		btnExit = new JButton("����");
		txtPool = new JTextArea(10, 50);
		scrollPane = new JScrollPane(txtPool);
		jpup.add(new JLabel("�й�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtScore);
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExit);
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(600, 400));
		setLocation(200, 150);
		setVisible(true);
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. �й��˻�
		if (e.getSource() == btnSNoSearch) {
			// �й� �Է¶��� �����ϰ� �⺻���� ���� .
			txtSName.setText("");
			txtScore.setText("");
			comMname.setSelectedIndex(0);
			// txtSNo.getText() �� �޾� �й� �˻��Ͽ� txtSName, comMname, txtScore�� �־��ش�
			String sNo = txtSNo.getText().trim();
			if (sNo.length() == 0) {
				txtPool.setText("�й��� �Է� �� �й� �˻��ϼ���");
				txtSName.setText("");
				txtScore.setText("");
				comMname.setSelectedIndex(0);
				// comMname.setSelectedItem("");
				return;
			}
			StudentDto dto = dao.sNogetStudent(Integer.parseInt(sNo)); // �й����� �˻��� ��� �ޱ�
			if (dto != null) { // �й��� DB�� �ִ� ���
				txtSName.setText(dto.getsName());
				comMname.setSelectedItem(dto.getmName());
				// txtScore.setText(""+dto.getScore()); // ""+100 => "100"
				txtScore.setText(String.valueOf(dto.getScore()));
				txtPool.setText(sNo + "�� �˻� �Ϸ�");
			} else { // �й��� DB�� ���°��
				txtPool.setText(sNo + "�� �й��� ��ȿ���� �ʽ��ϴ�");
			}
			// 2. �̸��˻�
		} else if (e.getSource() == btnSNameSearch) {
			// �̸��Է¶��� �����ϰ� �⺻���� ����
			txtSNo.setText("");
			txtScore.setText("");
			comMname.setSelectedIndex(0); // ?
			// txtSName.getText() �� �޾� �̸� �˻�
			String sName = txtSName.getText().trim();
			// arraylist sizeȮ���Ͽ�, �˻��� ����� ���� ���, �Ѹ��� ���, �θ��̻��� ��� ����� �ٸ���
			if (sName.length() == 0) { // �̸��� �Է����� �ʴ� ���
				txtPool.setText("�̸��� �Է� �� �˻��ϼ���");
				return;
			}
			ArrayList<StudentDto> student = dao.sNamegetStudent(sName);
			if (student.size() == 0) {
				txtPool.setText("�ش� �̸��� �л��� ���������ʽ��ϴ�");
			} else if (student.size() == 1) {
				txtSNo.setText(String.valueOf(student.get(0).getsNo()));
				txtScore.setText(String.valueOf(student.get(0).getScore()));
				comMname.setSelectedItem(student.get(0).getmName());
				txtPool.setText(sName + "�� ���� �մϴ� ");
			} else {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t--------------\n");
				for (StudentDto students : student) {
					txtPool.append("\t" + students.toString() + "\n");
				}
			}
			// 3. �����˻�
		} else if (e.getSource() == btnMNameSearch) { // �����˻�
			// �������ö��� �����ϰ� �⺻���� ����
			txtSNo.setText("");
			txtScore.setText("");
			txtSName.setText("");
			// comMname �޺��ڽ��� ���õ� �����̸����� �˻��Ͽ� ���
			String mName = comMname.getSelectedItem().toString();
			ArrayList<StudentDto> student = dao.mNametudent(mName);
			if (!student.isEmpty()) {
				txtPool.setText("\t���\t�̸�\t�а���\t����\n");
				txtPool.append("\t--------------\n");
				for (StudentDto students : student) {
					txtPool.append("\t" + students.toString() + "\n");
				}
			} else {
				txtPool.setText("�ش� �а��� �л��� �����ϴ�.");
			}
			// 4.�л��Է�
		} else if (e.getSource() == btnInput) {
			// �й��Է¶��� �����(�л��Է½� �й��� ����ڰ� �Է����� �ʰ� �������� �̿�)
			txtSNo.setText("");
			// txtSName, comMname, txtScore���� �޾� �л��Է� (txtScore�� ��ȿ�� ������ �Է����� ���� ��� ����)
			String sName = txtSName.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			String scoreStr = txtScore.getText().toString();
			if (sName.equals("") || mName.equals("") || scoreStr.equals("")) {
				txtPool.setText("�л��Է½� �̸�, ����, ��ȿ�� ����(0~100��)�� ��� �Է��ϼž� �մϴ�");
				return;
			}
			int score;
			try {
				score = Integer.parseInt(scoreStr);
				if (score < 0 || score > 100) {
					txtPool.setText("�л��Է½� �̸�, ����, ��ȿ�� ����(0~100��)�� ��� �Է��ϼž� �մϴ�");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("�л��Է½� �̸�, ����, ��ȿ�� ����(0~100��)�� ��� �Է��ϼž� �մϴ�");
				return;
			}
			StudentDto newStudent = new StudentDto(0, sName,mName,score);
			int result = dao.insertStudent(newStudent);
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sName+"�л� �Է� ����");
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
			}
		// 5. �л� ���� 	
		} else if (e.getSource() == btnUpdate) { // �л�����
			// txtSNo, txtSName, comMname, txtScore���� �޾� �л� ����
			String sNo = txtSNo.getText().trim();
			String sName = txtSName.getText().trim();
			String mName = comMname.getSelectedItem().toString();
			String scoreStr = txtScore.getText().toString();
			if (sNo.equals("")||sName.equals("") || mName.equals("") || scoreStr.equals("")) {
				txtPool.setText("�л������� �й�,�̸�, ����, ��ȿ�� ����(0~100��)�� ��� �Է��ϼž� �մϴ�");
				return;
			}
			int score;
			try {
				score= Integer.parseInt(scoreStr);
				if (score < 0 || score > 100) {
					txtPool.setText("�л������� �й�,�̸�, ����, ��ȿ�� ����(0~100��)�� ��� �Է��ϼž� �մϴ�");
					return;
			}
			}catch (Exception e2) {
				txtPool.setText("�л������� �й�,�̸�, ����, ��ȿ�� ����(0~100��)�� ��� �Է��ϼž� �մϴ�");
				return;
			}
		//6. �л����	
		} else if (e.getSource() == btnStudentOut) { 
			txtSNo.setText("");
			txtScore.setText("");
			txtSName.setText("");
			comMname.setSelectedItem("");
			// �������� �ʴ� �л��� pdf�� ���� ���
			ArrayList<StudentDto> student = dao.getStudentExpel();
			if(student.size()!=0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t������������������������������������������������������������������\n");
				for(StudentDto students : student) {
					txtPool.append("\t"+students.toString()+"\n");
				}//for
			}else {
				txtPool.setText("��ϵ� �л��� �����ϴ�.");
			}
		//7. ����ó��	
		} else if (e.getSource() == btnExpelOut) { // ���������
			// ������ �л��� pdf�� ���� ���
			txtSNo.setText("");
			txtScore.setText("");
			txtSName.setText("");
			comMname.setSelectedItem("");
			ArrayList<StudentDto> student = dao.getStudentExpel();
			if(student.size()!=0) {
				txtPool.setText("\t�й�\t�̸�\t�а���\t����\n");
				txtPool.append("\t������������������������������������������������������������������\n");
				for(StudentDto students : student) {
					txtPool.append("\t"+students.toString()+"\n");
				}//for
			}else {
				txtPool.setText("��ϵ� �л��� �����ϴ�");
			}
		//8.����ó�� 	
		} else if (e.getSource() == btnExpel) { // ����ó��
			// txtSNo�� �Էµ� �л� ����ó��
			String sNo = txtSNo.getText().trim();
			if(sNo.length()==0) {
				txtPool.setText("�й��� �Է��ϼž� ����ó���� �����մϴ�");
				return;
			}
			int result = dao.sNoExpel(Integer.parseInt(sNo));
			if(result == StudentDao.SUCCESS) {
				txtPool.setText(sNo+" �л� ���� ó�� �Ϸ�");
			}else {
				txtPool.setText(sNo+"���� ��ȿ�� �й��� �ƴ϶� ����ó���� �Ұ��մϴ�");
			}
		} else if (e.getSource() == btnExit) { // ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new StudentMng("�л����");
	}
}