package com.lec.ex02_person_dtoDao;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class PersonMngGUI extends JFrame implements ActionListener {
	// ȭ�鿡 �� �޺���Ʈ
	private Container contenPane;
	private JPanel jpup, jpbtn;
	private JTextField txtName, txtKor, txtEng, txtMat;
	private Vector<String> jnames;
	private JComboBox<String> comJob;
	private JButton btnInput, btnSearch, btnOutput, btnExit;
	private JTextArea txtPool;
	private JScrollPane scrollPane;
	// DB����
	private PersonDao dao = PersonDao.getInstance();
	private ArrayList<PersonDto> person;

	public PersonMngGUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE); // XŬ���� ����
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout()); // contenPane�� �⺻ ���̾ƿ��� BorderLayout
		jpup = new JPanel(new GridLayout(5, 2)); // Panel�� �⺻ ���̾ƿ��� FlowLayout
		jpbtn = new JPanel();
		txtName = new JTextField(20);
		jnames = dao.jnamelist();
		comJob = new JComboBox<String>(jnames); // ������ ����� �޺��ڽ���
		txtKor = new JTextField(20);
		txtEng = new JTextField(20);
		txtMat = new JTextField(20);
		ImageIcon icon1 = new ImageIcon("icon/join.png");
		btnInput = new JButton("�Է�", icon1);
		ImageIcon icon2 = new ImageIcon("icon/search.png");
		btnSearch = new JButton("������ȸ ", icon2);
		ImageIcon icon3 = new ImageIcon("icon/output.png");
		btnOutput = new JButton("��ü���", icon3);
		ImageIcon icon4 = new ImageIcon("icon/exit.png");
		btnExit = new JButton("����", icon4);
		btnInput.setPreferredSize(new Dimension(150, 50));
		btnSearch.setPreferredSize(new Dimension(150, 50));
		btnOutput.setPreferredSize(new Dimension(150, 50));
		btnExit.setPreferredSize(new Dimension(150, 50));
		txtPool = new JTextArea(10, 60);
		scrollPane = new JScrollPane(txtPool);
		// ������ ������Ʈ �߰�
		jpup.add(new JLabel("�̸�", (int) CENTER_ALIGNMENT));// jpup : GridLayout
		jpup.add(txtName);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(comJob);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtKor);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtEng);
		jpup.add(new JLabel("����", (int) CENTER_ALIGNMENT));
		jpup.add(txtMat);

		jpbtn.add(btnInput); // jpbtn : FlowLayout
		jpbtn.add(btnSearch);
		jpbtn.add(btnOutput);
		jpbtn.add(btnExit);
		contenPane.add(jpup); // contenPane : FlowLayout
		contenPane.add(jpbtn);
		contenPane.add(scrollPane);
		setSize(new Dimension(700, 450));
		setLocation(200, 150);
		setVisible(true);
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // �̺�Ʈ ���� �߰�
		if (e.getSource() == btnInput) {// txtName, comJob, txtKor,txtEng, txtMat�� ���� DB��
			String pname = txtName.getText().trim();
			String jname = comJob.getSelectedItem().toString().trim(); // ?�����ϱ�
			String korStr = txtKor.getText().trim();
			String engStr = txtEng.getText().trim();
			String matStr = txtMat.getText().trim();
			if (pname.equals("") || jname.equals("") || korStr.equals("") || engStr.equals("") || matStr.equals("")) {
				txtPool.setText("�̸�,����,��,��,�� ��� �Է��ϼž� �Է� ����");
				return;
			}
			int kor = Integer.parseInt(korStr);
			int eng = Integer.parseInt(engStr);
			int mat = Integer.parseInt(matStr);
			PersonDto newPerson = new PersonDto(pname, jname, kor, eng, mat);
			int result = dao.insertPerson(newPerson);
			if (result == PersonDao.SUCCESS) { // �Է¼���
				txtPool.setText(pname + "�� �Է¼���");
				txtName.setText("");
				comJob.setSelectedIndex(0); // �޺��ڽ��� 0��° ����
				comJob.setSelectedItem(""); // �޺��ڽ��� ""�� �ִ� ������ ����
				txtKor.setText("");
				txtEng.setText("");
				txtMat.setText("");
			}
		} else if (e.getSource() == btnSearch) {// comJob�� ���õ� ������ȸ ����� txtPool
			String jname = comJob.getSelectedItem().toString();
			if (jname.equals("")) {
				txtPool.setText("���� ������ ������ȸ�ϼ���");
				return;
			}
			person = dao.selectJname(jname);
			if (person.size() != 0) {
				txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
				for (PersonDto dto : person) {
					txtPool.append(dto.toString() + "\n");
				} // for
			} else {
				txtPool.setText("�ش� �������� �ο��� �����ϴ�.");
			}
			;
		} else if (e.getSource() == btnOutput) {// ��ü ��ȸ ����� txtPool��
			person = dao.selectAll();
			if (person.size() != 0) {
				txtPool.setText("���\t�̸�\t����\t����\t����\t����\t����\n");
				for (PersonDto dto : person) {
					txtPool.append(dto.toString() + "\n");
				}
			} else {
				txtPool.setText("��ϵ� �ο��� �����ϴ�.");
			}
		} else if (e.getSource() == btnExit) {// ����
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new PersonMngGUI("��������");
	}
}