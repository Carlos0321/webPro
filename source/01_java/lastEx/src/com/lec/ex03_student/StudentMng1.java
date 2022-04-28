package com.lec.ex03_student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
public class StudentMng1 extends JFrame implements ActionListener{
   
   // DB관련
   private StudentDao dao = StudentDao.getInstance();
   
   // 화면구현 
   private Container contenPane; //껍데기
   private JPanel    jpup, jpbtn; //작은껍데기
   
   private JTextField txtSNo, txtSName, txtScore; //텍스트박스
   
   //첫번째 합판/버튼
   private JButton btnSNoSearch, btnSNameSearch, btnMNameSearch;

   //두번째 합판 버튼 
   private JButton btnInput, btnUpdate;
   private JButton btnStudentOut, btnExpelOut, btnExpel, btnExit;
   
   //출력칸
   private JTextArea txtPool;
   private JScrollPane scrollPane;
   
   
   // 콤보박스 알맹이 (콤보박스에 들어갈 전공리스트를 담을 vector(배열))
   private Vector<String> mNames; 
   // 콤보박스 껍데기
   private JComboBox<String> comMname;
   
   
   // 생성자 함수 만들기(필요한 것들을 이 안에)
   public StudentMng1(String title) {
      super(title);
      
      // x버튼 누르면 꺼지는거
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      
      // FlowLayout = 위에서 아래 순서대로 생기는거
      // GridLayout = 행렬 느낌
      // BorderLayout = 동서남북 정렬
      
      // 컨테이너 기본형 = 보더
      // 패널 기본형 = 플로우
      
      // 가장 큰 껍데기 박스 불러오기
      contenPane = getContentPane();
      contenPane.setLayout(new FlowLayout());
      
      jpup = new JPanel(new GridLayout(4, 3));
      jpbtn = new JPanel(new FlowLayout());
      
      // 필요한 값들 채워주기ㄴ
      txtSNo = new JTextField(10);
      txtSName = new JTextField(10);
      mNames = dao.getMNamelist(); //리스트 불러오기
      comMname = new JComboBox<String>(mNames); //콤보박스에 넣기
      txtScore = new JTextField(10);
      
      // 버튼이름 입력
      btnSNoSearch = new JButton("학번검색");
      btnSNameSearch = new JButton("이름검색");
      btnMNameSearch = new JButton("전공검색");
      btnInput       = new JButton("학생입력");
      btnUpdate      = new JButton("학생수정");
      btnStudentOut  = new JButton("학생출력");
      btnExpelOut  = new JButton("제적자출력");
      btnExpel     = new JButton("제적처리");
      btnExit      = new JButton("종료");
      
      // 아래공간부분
      txtPool      = new JTextArea(10, 50);
      scrollPane   = new JScrollPane(txtPool);
      
      
      jpup.add(new JLabel("학번", (int) CENTER_ALIGNMENT));
      jpup.add(txtSNo);
      jpup.add(btnSNoSearch);
      jpup.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
      jpup.add(txtSName);
      jpup.add(btnSNameSearch);
      jpup.add(new JLabel("전공", (int) CENTER_ALIGNMENT));
      jpup.add(comMname);
      jpup.add(btnMNameSearch);
      jpup.add(new JLabel("점수", (int) CENTER_ALIGNMENT));
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
      if(e.getSource()==btnSNoSearch) { // 학번검색
         // txtSNo.getText() 를 받아 학번 검색하여 txtSName, comMname, txtScore에 넣어준다
         String sNo = txtSNo.getText().trim();
         if(sNo.length()==0) { // 학번을 입력하지 않은 경우
            txtPool.setText("학번을 입력 후 학번 검색하세요");
            txtSName.setText("");
            txtScore.setText("");
            comMname.setSelectedIndex(0);
            //comMname.setSelectedItem("");
            return;
         }
         StudentDto dto = dao.sNogetStudent(sNo); // 학번으로 검색한 결과 받기
         if(dto!=null) { // 해당 학번이 DB에 있는 경우
            txtSName.setText(dto.getsName());
            comMname.setSelectedItem(dto.getmName());
            //txtScore.setText(""+dto.getScore()); // ""+100 => "100"
            //setText() 괄호안에 String값만 들어가기 때문에 애매한 변수인
            //Score를 형 변환해주기
            txtScore.setText(String.valueOf(dto.getScore()));
            txtPool.setText(sNo + "번 검색 완료");
         }else { // 해당 학번이 DB에 없는 경우 
            txtPool.setText(sNo + "번 학번은 유효하지 않습니다");
            txtSName.setText("");
            txtScore.setText("");
            comMname.setSelectedIndex(0);
         }         
      }else if(e.getSource()==btnSNameSearch) { // 이름검색
         // txtSName.getText() 를 받아 이름 검색
         // arraylist size확인하여, 검색한 결과가 없는 경우, 한명인 경우, 두명이상 인경우 결과가 다르다 
         String sName = txtSName.getText().trim();
         if(sName.length()==0) { // 이름을 입력하지 않은 경우
            txtPool.setText("이름을 입력 후 이름 검색하세요");
            txtSName.setText("");
            txtScore.setText("");
            comMname.setSelectedIndex(0);
            //comMname.setSelectedItem("");
            return;
         }
         ArrayList<StudentDto> students = dao.sNamegetStudent(sName);
      }else if(e.getSource()==btnMNameSearch) { // 전공검색
         // comMname 콤보박스에 선택된 전공이름으로 검색하여 출력
      }else if(e.getSource()==btnInput) { // 학생입력
         // txtSName, comMname, txtScore값을 받아 학생입력 (txtScore에 유효한 점수를 입력하지 않을 경우 떼끼)
      }else if(e.getSource()==btnUpdate) { // 학생수정
         // txtSNo, txtSName, comMname, txtScore값을 받아 학생 수정
      }else if(e.getSource()==btnStudentOut) { // 학생출력
         // 제적되지 않는 학생들 pdf와 같이 출력
      }else if(e.getSource()==btnExpelOut) { // 제적자출력
         // 제적된 학생들 pdf와 같이 출력
      }else if(e.getSource()==btnExpel) { // 제적처리
         // txtSNo에 입력된 학생 제적처리
      }else if(e.getSource()==btnExit) { // 종료
         setVisible(false);
         dispose();
         System.exit(0);
      }
   }
   public static void main(String[] args) {
      new StudentMng("학사관리");
   }
}