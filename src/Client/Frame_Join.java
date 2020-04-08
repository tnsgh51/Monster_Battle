package Client;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame_Join extends JFrame {
	private JLabel idLabel, pwLabel, checkLabel;
	private JComboBox m1,m2,m3;
	private JPanel  qqq;
	private JTextField idField, pwdField;
	private JTextField m1_name, m2_name,m3_name;
	private JButton idcheck, join;
	private Frame_Join my = null;
	
	private static Frame_admin fa = null;
	String [] monsterL = {"a","b","c","d","e"};
	
	Frame_Join(Frame_Login k) {
		super("Monster_Battle_ver0.1");
		fa = Frame_admin.getInstance();
		fa.setFJ(this);
		my = this;
		this.setLayout(null);
		this.setBounds(150, 100, 315, 300);
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);

		btnSet();
		labelSet();
		fieldSet();
		comboSet();
		panelSet();
	}


	private void panelSet() {
		qqq = new JPanel();
		
		m1_name = new JTextField();
		m1_name.setPreferredSize(new Dimension(50,26));
		m2_name= new JTextField();
		m2_name.setPreferredSize(new Dimension(50,26));
		m3_name= new JTextField();
		m3_name.setPreferredSize(new Dimension(50,26));
		
		qqq.add(m1);
		qqq.add(m1_name);
		qqq.add(m2);
		qqq.add(m2_name);
		qqq.add(m3);
		qqq.add(m3_name);
		
		qqq.setBounds(0, 150, 300, 40);
		this.add(qqq);
	}


	private void comboSet() {
		m1 = new JComboBox(monsterL);
		m2 = new JComboBox(monsterL);
		m3 = new JComboBox(monsterL);
	}

	private void fieldSet() {
		idField = new JTextField(15);
		this.add(idField);
		idField.setBounds(100, 30, 100, 25);

		pwdField = new JTextField(15);
		pwdField.setBounds(100, 100, 100, 25);
		this.add(pwdField);
	}

	private void labelSet() {
		idLabel = new JLabel("I            D     :");
		idLabel.setBounds(30, 30, 80, 20);
		this.add(idLabel);

		pwLabel = new JLabel("Password :");
		pwLabel.setBounds(30, 100, 80, 20);
		this.add(pwLabel);

		checkLabel = new JLabel();
		checkLabel.setBounds(30, 60, 100, 25);
		this.add(checkLabel);
	}

	private void btnSet() {
		idcheck = new JButton("중복확인");
		idcheck.setBounds(205, 30, 87, 25);
		

		this.add(idcheck);
		join = new JButton("회원가입");
		join.setEnabled(false);
		join.setBounds(180, 220, 87, 25);

		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				my.dispose();
			}
		});
		
		this.add(join);
	}
	
	public void idcheckSet(String msg) {		
		idcheck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				checkLabel.setText(msg);
				if(msg.equals("사용가능합니다.")) {
					join.setEnabled(true);
					idField.setEnabled(false);
				}
			}
		});
	}
}

