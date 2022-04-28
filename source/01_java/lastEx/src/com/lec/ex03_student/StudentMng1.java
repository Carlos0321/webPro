package com.lec.ex03_student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
public class StudentMng1 extends JFrame implements ActionListener{
   
   // DB����
   private StudentDao dao = StudentDao.getInstance();
   
   // ȭ�鱸�� 
   private Container contenPane; //������
   private JPanel    jpup, jpbtn; //����������
   
   private JTextField txtSNo, txtSName, txtScore; //�ؽ�Ʈ�ڽ�
   
   //ù��° ����/��ư
   private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;

   //�ι�° ���� ��ư 
   private JButton btnInput, btnUpdate;
   private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
   
   //���ĭ
   private JTextArea txtPool;
   private JScrollPane scrollPane;
   
   
   // �޺��ڽ� �˸��� (�޺��ڽ��� �� ��������Ʈ�� ���� vector(�迭))
   private Vector<String> mNames; 
   // �޺��ڽ� ������
   private JComboBox<String> comMname;
   
   
   // ������ �Լ� �����(�ʿ��� �͵��� �� �ȿ�)
   public StudentMng1(String title) {
      super(title);
      
      // x��ư ������ �����°�
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      
      // FlowLayout = ������ �Ʒ� ������� ����°�
      // GridLayout = ��� ����
      // BorderLayout = �������� ����
      
      // �����̳� �⺻�� = ����
      // �г� �⺻�� = �÷ο�
      
      // ���� ū ������ �ڽ� �ҷ�����
      contenPane = getContentPane();
      contenPane.setLayout(new FlowLayout());
      
      jpup = new JPanel(new GridLayout(4, 3));
      jpbtn = new JPanel(new FlowLayout());
      
      // �ʿ��� ���� ä���ֱ⤤
      txtSNo = new JTextField(10);
      txtSName = new JTextField(10);
      mNames = dao.getMNamelist(); //����Ʈ �ҷ�����
      comMname = new JComboBox<String>(mNames); //�޺��ڽ��� �ֱ�
      txtScore = new JTextField(10);
      
      // ��ư�̸� �Է�
      btnSNoSearch = new JButton("�й��˻�");
      btnSNameSearch = new JButton("�̸��˻�");
      btnMNameSearch = new JButton("�����˻�");
      btnInput       = new JButton("�л��Է�");
      btnUpdate      = new JButton("�л�����");
      btnStudentOut  = new JButton("�л����");
      btnExpelOut  = new JButton("���������");
      btnExpel     = new JButton("����ó��");
      btnExit      = new JButton("����");
      
      // �Ʒ������κ�
      txtPool      = new JTextArea(10, 50);
      scrollPane   = new JScrollPane(txtPool);
      
      
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
      setLocation(200,150);
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
      if(e.getSource()==btnSNoSearch) { // �й��˻�
         // txtSNo.getText() �� �޾� �й� �˻��Ͽ� txtSName, comMname, txtScore�� �־��ش�
         String sNo = txtSNo.getText().trim();
         if(sNo.length()==0) { // �й��� �Է����� ���� ���
            txtPool.setText("�й��� �Է� �� �й� �˻��ϼ���");
            txtSName.setText("");
            txtScore.setText("");
            comMname.setSelectedIndex(0);
            //comMname.setSelectedItem("");
            return;
         }
         StudentDto dto = dao.sNogetStudent(sNo); // �й����� �˻��� ��� �ޱ�
         if(dto!=null) { // �ش� �й��� DB�� �ִ� ���
            txtSName.setText(dto.getsName());
            comMname.setSelectedItem(dto.getmName());
            //txtScore.setText(""+dto.getScore()); // ""+100 => "100"
            //setText() ��ȣ�ȿ� String���� ���� ������ �ָ��� ������
            //Score�� �� ��ȯ���ֱ�
            txtScore.setText(String.valueOf(dto.getScore()));
            txtPool.setText(sNo + "�� �˻� �Ϸ�");
         }else { // �ش� �й��� DB�� ���� ��� 
            txtPool.setText(sNo + "�� �й��� ��ȿ���� �ʽ��ϴ�");
            txtSName.setText("");
            txtScore.setText("");
            comMname.setSelectedIndex(0);
         }         
      }else if(e.getSource()==btnSNameSearch) { // �̸��˻�
         // txtSName.getText() �� �޾� �̸� �˻�
         // arraylist sizeȮ���Ͽ�, �˻��� ����� ���� ���, �Ѹ��� ���, �θ��̻� �ΰ�� ����� �ٸ��� 
         String sName = txtSName.getText().trim();
         if(sName.length()==0) { // �̸��� �Է����� ���� ���
            txtPool.setText("�̸��� �Է� �� �̸� �˻��ϼ���");
            txtSName.setText("");
            txtScore.setText("");
            comMname.setSelectedIndex(0);
            //comMname.setSelectedItem("");
            return;
         }
         ArrayList<StudentDto> students = dao.sNamegetStudent(sName);
      }else if(e.getSource()==btnMNameSearch) { // �����˻�
         // comMname �޺��ڽ��� ���õ� �����̸����� �˻��Ͽ� ���
      }else if(e.getSource()==btnInput) { // �л��Է�
         // txtSName, comMname, txtScore���� �޾� �л��Է� (txtScore�� ��ȿ�� ������ �Է����� ���� ��� ����)
      }else if(e.getSource()==btnUpdate) { // �л�����
         // txtSNo, txtSName, comMname, txtScore���� �޾� �л� ����
      }else if(e.getSource()==btnStudentOut) { // �л����
         // �������� �ʴ� �л��� pdf�� ���� ���
      }else if(e.getSource()==btnExpelOut) { // ���������
         // ������ �л��� pdf�� ���� ���
      }else if(e.getSource()==btnExpel) { // ����ó��
         // txtSNo�� �Էµ� �л� ����ó��
      }else if(e.getSource()==btnExit) { // ����
         setVisible(false);
         dispose();
         System.exit(0);
      }
   }
   public static void main(String[] args) {
      new StudentMng("�л����");
   }
}