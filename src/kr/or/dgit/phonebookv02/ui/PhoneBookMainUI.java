package kr.or.dgit.phonebookv02.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.or.dgit.phonebookv02.ctrl.PhoneControl;

public class PhoneBookMainUI extends JFrame {
	public static final String[] COL_NAMES={"번호", "이름", "주소", "연락처"};
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private PhoneControl phoneControl;

	public PhoneBookMainUI() {
		phoneControl=new PhoneControl();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pPhone = new JPanel();
		contentPane.add(pPhone, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		pPhone.add(lblNewLabel);
		
		textField = new JTextField();
		pPhone.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("New label");
		pPhone.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		pPhone.add(textField_1);
		
		JLabel label_1 = new JLabel("New label");
		pPhone.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		pPhone.add(textField_2);
		
		JButton btnNewButton = new JButton("New button");
		pPhone.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		DefaultTableModel model=new DefaultTableModel(getDatas(), PhoneBookMainUI.COL_NAMES);
		table = new JTable(model);
		
		
		scrollPane.setViewportView(table);
	}

	private Object[][] getDatas() {
		
		return phoneControl.showPhones();
	}

}
