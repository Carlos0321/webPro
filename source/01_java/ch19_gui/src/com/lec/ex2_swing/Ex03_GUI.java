package com.lec.ex2_swing;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Ex03_GUI extends JFrame implements ActionListener {
	// 컴포넌트 객체 변수 선언(, ArrayList변수, file io를 위한 stream, db 접속관련 변수)
	private Container  contenPane; // 컨테이너 얻어올 변수
	private JPanel     jp; // 이름,전화,나이 받을 6개 컴포넌트를 gridLayout으로 add
	private JTextField txtName, txtTel, txtAge;
	private ImageIcon  icon;
	private JButton    btnOut;
	private JTextArea  jta;
	private JScrollPane scroolbar;
	private int        cnt; // 몇명 입력했는지 저장
	// 생성자 : 컨테이너 얻어와서 -> layoutSetting -> 컴포넌트 객체 생성 해서 add -> 이벤트 추가
	public Ex03_GUI(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		// contenPane.setLayout(new BorderLayout()); 기본 레이아웃 그대로 사용해서 생략
		jp         = new JPanel(new GridLayout(3,2));
		//jp       = new JPanel();
		//jp.setLayout(new GridLayout(3,2)); // 패널의 기본 레이아웃은 FlowLayout()
		txtName    = new JTextField();
		txtTel     = new JTextField();
		txtAge     = new JTextField();
		icon       = new ImageIcon("icon/output.png");
		btnOut     = new JButton("출력", icon);
		jta        = new JTextArea(5, 30); // 5행 30열 textArea
		scroolbar  = new JScrollPane(jta);
		jp.add(new JLabel("이   름", (int) CENTER_ALIGNMENT));
		jp.add(txtName);
		jp.add(new JLabel("전   화", (int) CENTER_ALIGNMENT));
		jp.add(txtTel);
		jp.add(new JLabel("나   이", (int) CENTER_ALIGNMENT));
		jp.add(txtAge);
		contenPane.add(jp, BorderLayout.NORTH);
		contenPane.add(btnOut, BorderLayout.CENTER);
		contenPane.add(scroolbar, BorderLayout.SOUTH);
		setVisible(true);
//		setSize(new Dimension(400, 280));
//		setLocation(2000, 100);
		setBounds(2000, 100, 400, 280);
		// 이벤트 추가
		btnOut.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {// 이벤트 로직
		if(e.getSource() == btnOut) {
			// txtName, txtTel, txtAge 에 입력된 값을 jta에 출력
			String name = txtName.getText().trim();
			String tel  = txtTel.getText().trim();
			if(name.equals("") || tel.equals("")) {
				System.out.println("이름과 전화번호는 필수 입력 사항입니다");
				return;
			}                                              // 031-789-7897
			if(tel.indexOf("-") == tel.lastIndexOf("-") || // 02-789-7897  02-1234-5689 010-9999-9999 011-325-8989
					tel.indexOf("-")<2 ||
					tel.lastIndexOf("-")>10) { // 000-12345(X)  123456789(X)   02-123-4567(X)    010-912345999-9999
				System.out.println("전화번호 형식을 확인해 주세요");
				return;
			}
			// 나이 체크
			int age=0;
			try {
				age = Integer.parseInt(txtAge.getText());
				if(age < 0 || age>150) {
					System.out.println("유효하지 않는 나이를 입력할 경우 0살로");
					age = 0;
				}
			}catch(Exception e1) {
				System.out.println("유효하지 않는 나이를 입력할 경우 0살로");
			}
			System.out.println(++cnt + "명 입력됨");
			if(cnt==1) {
				jta.setText("이름\t전화\t\t나이\n");
			}
			jta.append(name + "\t"+ tel+"\t\t"+ age+"\n"); // 한명 add한 것을 jta출력
			txtName.setText("");
			txtTel.setText("");
			txtAge.setText("");
		}
	}
	public static void main(String[] args) {
		new Ex03_GUI("last EX");
	}
}
















