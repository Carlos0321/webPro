package com.lec.ex04_customer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {
	// DB����
	private CustomerDao dao = CustomerDao.getInstance();

	// ȭ�鱸��
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField txtCid, txtCtel, txtCname, txtCpoint, txtCamount;
	private Vector<String> levelnames;
	private JComboBox<String> comLevelName;

	// ù��° ����/��ư
	private JButton btnCidSearch, btnCtelSearch, btnCnameSearch,btnBuywithpoint;
	// �ι�° ���� ��ư
	private JButton btnBuy, btnLevelNameOutput, btnAllOutput, btnInsert, btnCtelupdate, btnDelete, btnExit;
	// ���ĭ
	private JTextArea txtPool;
	private JScrollPane ScrollPane;

	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// ������Ʈ ��ü ����
		container = getContentPane(); // �����̳ʴ� �⺻�� BorderLayout
		container.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(6, 3)); // �г��� �⺻�� FlowLayout
		jpbtn 		= new JPanel();
		txtCid 		= new JTextField(20);
		txtCtel 	= new JTextField(20);
		txtCname 	= new JTextField(20);
		txtCpoint 	= new JTextField(20);
		txtCamount 	= new JTextField(20);
		levelnames 	= dao.getLevelNames();
		comLevelName 	= new JComboBox<String>(levelnames);
		btnCidSearch 	= new JButton("���̵�˻�");
		btnCtelSearch 	= new JButton("��4�ڸ�(FULL)�˻�");
		btnCnameSearch 	= new JButton("���̸��˻�");
		btnBuywithpoint = new JButton("����Ʈ�θ�����");
		btnBuy 			= new JButton("��ǰ����");
		btnLevelNameOutput = new JButton("��޺����");
		btnAllOutput 		= new JButton("��ü���");
		btnInsert 			= new JButton("ȸ������");
		btnCtelupdate		= new JButton("��ȣ����");
		btnDelete  			= new JButton("ȸ��Ż��");
		btnExit 			= new JButton("������");
		txtPool 			= new JTextArea(6,70);
		ScrollPane			=new JScrollPane(txtPool);
		// �����̳� ������Ʈ ��ġ
		jpup.add(new JLabel("��  ��  ��", (int)CENTER_ALIGNMENT));
		jpup.add(txtCid);
		jpup.add(btnCidSearch);
		jpup.add(new JLabel("����ȭ", (int)CENTER_ALIGNMENT));
		jpup.add(txtCtel);
		jpup.add(btnCtelSearch);
		jpup.add(new JLabel("���̸�", (int)CENTER_ALIGNMENT));
		jpup.add(txtCname);
		jpup.add(btnCnameSearch);
		jpup.add(new JLabel("��  ��  Ʈ", (int)CENTER_ALIGNMENT));
		jpup.add(txtCpoint);
		jpup.add(btnBuywithpoint);
		jpup.add(new JLabel("���űݾ�", (int)CENTER_ALIGNMENT));
		jpup.add(txtCamount);
		jpup.add(new JLabel()); // 5�� 3���� �� �� �߰�
		jpup.add(new JLabel("�����", (int)CENTER_ALIGNMENT));
		jpup.add(comLevelName);
		jpbtn.add(btnBuy);
		jpbtn.add(btnLevelNameOutput);
		jpbtn.add(btnAllOutput);
		jpbtn.add(btnInsert);
		jpbtn.add(btnCtelupdate);
		jpbtn.add(btnDelete);
		jpbtn.add(btnExit);
		container.add(jpup);
		container.add(jpbtn);
		container.add(ScrollPane);
		setVisible(true);
		setSize(new Dimension(800,400));
		setLocation(200,200);
		txtPool.setText("\t�ڡڡڰ� �˻� �� �����ϼ���");
		
		// �̺�Ʈ �߰�
		btnCidSearch.addActionListener(this);
		btnCtelSearch.addActionListener(this);
		btnCnameSearch.addActionListener(this);
		btnBuywithpoint.addActionListener(this);
		btnBuy.addActionListener(this);
		btnLevelNameOutput.addActionListener(this);
		btnAllOutput.addActionListener(this);
		btnInsert.addActionListener(this);
		btnCtelupdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//1. ���̵� �˻� 
		if(e.getSource()==btnCidSearch) { 
			int cid ;
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� ID�� �Է��Ͻ� �� �˻��ϼ���");
				return;
			}//try-catch
			//���� �Է� o
			CustomerDto customer = dao.cIdGetCustomer(cid);
			if(customer!=null) {
				//txtCid.setText(String.valueOf(customer.getCid()));
				txtCtel.setText(customer.getCtel());
				txtCname.setText(customer.getCname());
				txtCpoint.setText(String.valueOf(customer.getCpoint()));
				comLevelName.setSelectedItem(customer.getLevelname());
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---------------------------------------------------------\n");
				txtPool.append(customer.toString());
			}else {
				txtPool.setText("�˻����� ���� ID�Դϴ�");
				return;
			}
		// 2. �� 4�ڸ� �Է�	
		}else if (e.getSource()==btnCtelSearch) { 
			//ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if(ctel.length()<4) {
				txtPool.setText("��� �� 4�ڸ� �̻��� �Է��ϼž� �մϴ�");
				return;
			}//if
			ArrayList<CustomerDto> customers = dao.cTelGetCustomers(ctel);
			if(customers.size()!=0) { //���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---------------------------------------------------------\n");
				for(CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); //��ǰ ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(customer.getLevelname());
					txtPool.append(customer.toString()+"\n");
				}
			}else {
				txtPool.setText("�ش� ��ȣ�� ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���");
			}
		// 3. �̸� �˻�	
		}else if(e.getSource()==btnCnameSearch) { 
			//cname �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String cname = txtCname.getText().trim();
			if(cname.length()<2) {
				txtPool.setText("�� ���� �̻��� �̸��� �Է��ϼ���");
				return;
			}//if
			ArrayList<CustomerDto> customers = dao.cNameGetCustomers(cname);
			if(customers.size()!=0) { //���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---------------------------------------------------------\n");
				for(CustomerDto customer : customers) {
					txtCid.setText(String.valueOf(customer.getCid()));
					txtCname.setText(customer.getCname());
					txtCtel.setText(customer.getCtel());
					txtCpoint.setText(String.valueOf(customer.getCpoint()));
					txtCamount.setText(""); //��ǰ ������ �ݾ��� �־��� ������ textField
					comLevelName.setSelectedItem(customer.getLevelname());
					txtPool.append(customer.toString()+"\n");
				}
			}else {
				txtPool.setText("�ش� �̸��� ���� �˻����� �ʽ��ϴ�. ȸ������ ���ּ���");
			}
		// 4. ����Ʈ ���� 	
		}else if(e.getSource()==btnBuywithpoint) {// ����Ʈ ����
			//1�ܰ�
			int cid, cpoint,camount;
			try {
				 cid = Integer.parseInt(txtCid.getText().trim());
				 cpoint = Integer.parseInt(txtCpoint.getText().trim());
				 camount=Integer.parseInt(txtCamount.getText().trim());
				 if(cpoint < camount) {
					txtPool.setText("����Ʈ�� �����Ͽ� ����Ʈ�� ���Ű� �Ұ��մϴ�"); 
					return;
				 }
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��ID�� point�� ���űݾ��� �Է��Ͻ� �� �����ϼ���");
				return;
			}
			int result =dao.buyWithPoint(camount, cid);
			if(result ==CustomerDao.SUCCESS) {
				txtPool.setText("����Ʈ ���ż���");
				txtCpoint.setText(String.valueOf(cpoint-camount)); //������ ����Ʈ�� �ؽ�Ʈ�ʵ� ���� 
				txtCamount.setText("");
			}else {
				txtPool.setText("�� ���̵� ��ȿ���� �ʽ��ϴ�. ���̵� �˻� �� �������ּ���");
			}
			
		// 5. ��ǰ ����	
		}else if(e.getSource()==btnBuy) { // ��ǰ����
			int cid,camount,cpoint;
			try {
				cid=Integer.parseInt(txtCid.getText().trim());
				cpoint=Integer.parseInt(txtCpoint.getText().trim());
				camount=Integer.parseInt(txtCamount.getText().trim());
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� ��ID�� �˻� ��, ���űݾ��� �Է��Ͻð� �����ϼ���");
				return;
			}
			int result =dao.buy(camount, cid);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("��ǰ ���� �Ϸ�");
				txtCpoint.setText(String.valueOf(cpoint+(int)(camount*0.05)));
				txtCamount.setText("");
			}else {
				txtPool.setText("�� ID�� ��ȿ���� �ʽ��ϴ�. �˻� �� �����ϼ���");
			}
		// 6. ��޺� ���	
		}else if(e.getSource()==btnLevelNameOutput) { //��޺� ���
			//levelName �Է� �޺��ڽ� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			//comLevelName.setSelectedItem(""); ���� ����
			String levelname = comLevelName.getSelectedItem().toString();
			if(levelname.length()==0) {
				txtPool.setText("���ϴ� ����� �����Ͻð� �˻��ϼ��� ");
				return;
			}//if
			ArrayList<CustomerDto> customers = dao.levelNameGetCustomers(levelname);
			if(customers.size()!=0) { //���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---------------------------------------------------------\n");
				for(CustomerDto customer : customers) {
					txtPool.append(customer.toString()+"\n");
				}
				txtPool.append("��"+customers.size()+"��");
			}else {
				txtPool.setText("�ش� ����� ���� �˻����� �ʽ��ϴ�.");
			}
		// 7. ��ü ���	
		}else if(e.getSource()==btnAllOutput) {//��ü���
			//��� �Է� ������Ʈ�� ������� ���� ���� 
			txtCid.setText("");
			txtCtel.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedIndex(0); 

			ArrayList<CustomerDto> customers = dao.getCustomers();
			if(customers.size()!=0) { //���
				txtPool.setText("ID\t��ȭ\t\t�̸�\t����Ʈ\t���Ŵ�����\t������\t�������������߰����ž�\n");
				txtPool.append("---------------------------------------------------------\n");
				for(CustomerDto customer : customers) {
					txtPool.append(customer.toString()+"\n");
				}
				txtPool.append("��"+customers.size()+"��");
			}else {
				txtPool.setText("��ϵ� ���� �˻����� �ʽ��ϴ�.");
			}
		// 8. ȸ������	
		}else if(e.getSource()==btnInsert) {
			//ctel, cname �Է¶��� �����ϰ� ��Ʈ�� �� �ʱⰪ���� ����
			txtCid.setText("");
			txtCpoint.setText("1000");
			txtCamount.setText("");
			comLevelName.setSelectedItem("NORMAL");
			String ctel = txtCtel.getText().trim();
			String cname = txtCname.getText().trim();
			if(ctel.length()<8||cname.length()<2) {
				txtPool.setText("��ȭ��ȣ�� �̸��� Ȯ�����ּ���.");
				return;
			}
			int result = dao.insertCustomer(ctel, cname);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("ȸ������ �����մϴ�. ����Ʈ 1000���� ���Լ����� �帳�ϴ�.");
			}
		// 9. ��ȣ����	
		}else if(e.getSource()==btnInsert) { 
			int cid; String ctel;
			try {
				cid = Integer.parseInt(txtCid.getText().trim());
				ctel =txtCtel.getText().trim();
				if(ctel.length()<8) {
					txtPool.setText("������ ��ȭ��ȣ�� Ȯ�����ּ���");
					return;
				}
			} catch (Exception e2) {
				txtPool.setText("��ȿ�� �� ID�� �˻��� �����ϼ���");
				return;
			}
			int result = dao.updateCustomer(ctel, cid);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("��ȭ��ȣ�� �����Ǿ����ϴ�.");
			}else {
				txtPool.setText("��ȿ�� �� ID�� �˻��� �����ϼ���");
			}
		// 10. ȸ��Ż��	
		}else if(e.getSource()==btnDelete) { 
			//ctel �Է¶� �ܿ��� �⺻���� ������� ���� ����
			txtCid.setText("");
			txtCname.setText("");
			txtCpoint.setText("");
			txtCamount.setText("");
			comLevelName.setSelectedItem("");
			String ctel = txtCtel.getText().trim();
			if(ctel.equals("")) {
				txtPool.setText("��ȭ��ȣ�� �Է� �� ȸ��Ż�����ּ���");
				return;
			}
			int result = dao.deleteCustomer(ctel);
			if(result==CustomerDao.SUCCESS) {
				txtPool.setText("ȸ��Ż�� �Ϸ�");
				txtCtel.setText("");
			}else {
				txtPool.setText("��ϵ� ��ȭ��ȣ�� �ƴϿ��� ȸ��Ż�� ���� �Ұ��մϴ�");
			}
		// 11. ������	
		}else if(e.getSource()==btnExit) { 
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		new CustomerMng("���۸��� ����");
	}
}

