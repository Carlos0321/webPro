package com.lec.ex3_quiz;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MyFrame extends JFrame implements ActionListener {
	// 컴포넌트 객체 변수 선언(, ArrayList변수, file io를 위한 stream, db 접속관련 변수)
	private Container contenPane; // 컨테이너를 받아올 변수
	private JPanel    jpUp, jpDown;      
	private JTextField txtName, txtTel, txtAge;
	private JButton btnJoin, btnFileOut;
	private ArrayList<Person> person;
	//private OutputStream os; 
	public MyFrame(String title) {
		super(title);
		person = new ArrayList<Person>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contenPane = getContentPane();
		jpUp = new JPanel(new GridLayout(3, 2));
		jpDown = new JPanel(new FlowLayout());
		txtName = new JTextField();
		txtTel  = new JTextField();
		txtAge  = new JTextField();
		ImageIcon iconJoin = new ImageIcon("icon/join.png");
		btnJoin = new JButton("가입",iconJoin);
		ImageIcon iconFileOut = new ImageIcon("icon/output.png");
		btnFileOut = new JButton("출력",iconFileOut);
		jpUp.add(new JLabel("이름", (int) CENTER_ALIGNMENT));
		jpUp.add(txtName);
		jpUp.add(new JLabel("전화", (int) CENTER_ALIGNMENT));
		jpUp.add(txtTel);
		jpUp.add(new JLabel("나이", (int) CENTER_ALIGNMENT));
		jpUp.add(txtAge);
		jpDown.add(btnJoin); 
		jpDown.add(btnFileOut);
		contenPane.add(jpUp, BorderLayout.CENTER);
		contenPane.add(jpDown, BorderLayout.SOUTH);
		setBounds(2000, 100, 300, 200);
		setVisible(true);
		// 이벤트 추가
		btnJoin.addActionListener(this);
		btnFileOut.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnJoin) {
			String name, tel; int age;
			name = txtName.getText().trim();
			tel  = txtTel.getText().trim();
			try {
				age = Integer.parseInt(txtAge.getText());
			} catch (Exception e2) {
				age = -1;
			}
			if(!name.equals("") && !tel.equals("") && age !=-1) {
				person.add(new Person(name, tel, age));
				txtName.setText("");
				txtTel.setText("");
				txtAge.setText("");
			}else {
				System.out.println("유효하지 않는 값입니다");
			}
		}else if(e.getSource()==btnFileOut) {
			// 1byte씩 출력하는 OutputStream이용
			OutputStream os = null;
			try {
				os = new FileOutputStream("src/com/lec/ex3_quiz/person1byte.txt", true);
				for(Person p : person) {
					System.out.println(p);
					os.write((p.toString()+"\n").getBytes());
				}
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(os!=null) os.close();
				}catch (Exception e1) { }
			}// try-catch
			//2byte씩 출력하는 Writer이용
			Writer writer=null;
			try {
				writer = new FileWriter("src/com/lec/ex3_quiz/person2byte.txt",true);
				for(Person p : person) {
					writer.write(p.toString()+"\n");
				}
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(writer!=null) writer.close();
				}catch (Exception e1) { }
			}// try-catch
			// 3. printWriter이용하는 방법
			writer =null;
			PrintWriter printWriter = null;
			try {
				writer = new FileWriter("src/com/lec/ex3_quiz/personPrintWriter.txt",true);
				printWriter = new PrintWriter(writer);
				for(Person p : person) {
					printWriter.println(p.toString());
				}
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}finally {
				try {
					if(printWriter!=null) printWriter.close();
					if(writer!=null) writer.close();
				}catch (Exception e1) { }
			}// try-catch
		}
	}//actionPerformed
	public static void main(String[] args) {
		new MyFrame("GUI EX");
	}//main
}//class
