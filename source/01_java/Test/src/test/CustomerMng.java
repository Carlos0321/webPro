package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener{
	private CustomerDao dao = CustomerDao.getInstance();
	
	private Container contenpane;
	private JPanel jpup, jpdown;
	private JTextField txtPhone,txtName,txtPoint;
	private JButton btnJoin, btnSearch, btnOutput, btnExit;
	private JTextArea jta;
	private JScrollPane scrollpane;
	
	public CustomerMng(String title) {
		super(title);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	contenpane = getContentPane();
	contenpane.setLayout(new FlowLayout());
	
	jpup = new JPanel(new GridLayout(3,2));
	jpdown = new JPanel();
	txtPhone = new JTextField(15);
	txtName = new JTextField(15);
	txtPoint =new JTextField(15);
	btnJoin = new JButton("가입");
	btnSearch= new JButton("폰조회");
	btnOutput = new JButton("출력");
	btnExit =new JButton("종료");
	jta = new JTextArea(15,30);
	scrollpane = new JScrollPane(jta);
	
	jpup.add(new JLabel("폰번호", (int)CENTER_ALIGNMENT));
	jpup.add(txtPhone);
	jpup.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
	jpup.add(txtName);
	jpup.add(new JLabel("포인트", (int)CENTER_ALIGNMENT));
	jpup.add(txtPoint);
	jpdown.add(btnJoin);
	jpdown.add(btnSearch);
	jpdown.add(btnOutput);
	jpdown.add(btnExit);
	
	contenpane.add(jpup);
	contenpane.add(jpdown);
	contenpane.add(scrollpane);
	setSize(new Dimension(400, 450));
	setLocation(200,100);
	setVisible(true);
	
	btnJoin.addActionListener(this);
	btnSearch.addActionListener(this);
	btnOutput.addActionListener(this);
	btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//회원 가입
		if(e.getSource()==btnJoin) {
			
			txtPoint.setText("1000");
			String phone =txtPhone.getText().trim();
			String name = txtName.getText().trim();
			if(phone.length()<8||name.length()<2) {
				jta.setText("폰번호와 이름을 확인해주세요" );
				return;
			}
			int result= dao.insertCustomer(phone,name);
			if(result == CustomerDao.SUCCESS) {
				jta.setText("회원가입 thank u 포인트 1000점을 가입선물로 드립니다\n");
			}
		//폰번호 조회
		}else if(e.getSource()==btnSearch) {
			txtName.setText("");
			String phone = txtPhone.getText().trim();
			if(phone.length()<4) {
				jta.setText("뒷번호 4자리 이상 입력하셔야합니다.");
				return;
			}
			ArrayList<CustomerDto> dto = dao.phoneCustomer(phone);
			if(dto.size() ==0) { //아무도 없을 때
				jta.setText("해당 번호의 회원이 존재하지 않습니다. 회원가입을 진행해주세요");
			}else if(dto.size()==1){ //한명일때 
				txtPhone.setText(dto.get(0).getPhone());
				txtName.setText(dto.get(0).getName());
				jta.setText("");
			}else if(dto.size()>=1) {
				jta.setText("고객번호\t전화번호\t이름\t포인트\n");
				for(CustomerDto customer : dto) {
					jta.append(customer.toString() + "\n");
				}
			}else {
				jta.setText("등록된 회원이 없습니다.");
			}
		//출력	
		}else if(e.getSource()==btnOutput) {
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
			ArrayList<CustomerDto> dto = dao.getCustomers();
			if(dto.size()!=0) { //출력
				jta.setText("고객번호\t전화번호\t이름\t포인트\n");
				for(CustomerDto customer : dto) {
					jta.append(customer.toString() + "\n");
				}
			}else {
				jta.setText("등록된 고객이 검색되지 않습니다.");
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMng("회원관리");
	}
}
