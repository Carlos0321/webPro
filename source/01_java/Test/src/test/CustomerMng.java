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
	btnJoin = new JButton("����");
	btnSearch= new JButton("����ȸ");
	btnOutput = new JButton("���");
	btnExit =new JButton("����");
	jta = new JTextArea(15,30);
	scrollpane = new JScrollPane(jta);
	
	jpup.add(new JLabel("����ȣ", (int)CENTER_ALIGNMENT));
	jpup.add(txtPhone);
	jpup.add(new JLabel("�̸�", (int)CENTER_ALIGNMENT));
	jpup.add(txtName);
	jpup.add(new JLabel("����Ʈ", (int)CENTER_ALIGNMENT));
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
		//ȸ�� ����
		if(e.getSource()==btnJoin) {
			
			txtPoint.setText("1000");
			String phone =txtPhone.getText().trim();
			String name = txtName.getText().trim();
			if(phone.length()<8||name.length()<2) {
				jta.setText("����ȣ�� �̸��� Ȯ�����ּ���" );
				return;
			}
			int result= dao.insertCustomer(phone,name);
			if(result == CustomerDao.SUCCESS) {
				jta.setText("ȸ������ thank u ����Ʈ 1000���� ���Լ����� �帳�ϴ�\n");
			}
		//����ȣ ��ȸ
		}else if(e.getSource()==btnSearch) {
			txtName.setText("");
			String phone = txtPhone.getText().trim();
			if(phone.length()<4) {
				jta.setText("�޹�ȣ 4�ڸ� �̻� �Է��ϼž��մϴ�.");
				return;
			}
			ArrayList<CustomerDto> dto = dao.phoneCustomer(phone);
			if(dto.size() ==0) { //�ƹ��� ���� ��
				jta.setText("�ش� ��ȣ�� ȸ���� �������� �ʽ��ϴ�. ȸ�������� �������ּ���");
			}else if(dto.size()==1){ //�Ѹ��϶� 
				txtPhone.setText(dto.get(0).getPhone());
				txtName.setText(dto.get(0).getName());
				jta.setText("");
			}else if(dto.size()>=1) {
				jta.setText("����ȣ\t��ȭ��ȣ\t�̸�\t����Ʈ\n");
				for(CustomerDto customer : dto) {
					jta.append(customer.toString() + "\n");
				}
			}else {
				jta.setText("��ϵ� ȸ���� �����ϴ�.");
			}
		//���	
		}else if(e.getSource()==btnOutput) {
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText("");
			ArrayList<CustomerDto> dto = dao.getCustomers();
			if(dto.size()!=0) { //���
				jta.setText("����ȣ\t��ȭ��ȣ\t�̸�\t����Ʈ\n");
				for(CustomerDto customer : dto) {
					jta.append(customer.toString() + "\n");
				}
			}else {
				jta.setText("��ϵ� ���� �˻����� �ʽ��ϴ�.");
			}
		}else if(e.getSource()==btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new CustomerMng("ȸ������");
	}
}
