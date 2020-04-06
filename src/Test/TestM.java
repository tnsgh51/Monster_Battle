package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestM extends JFrame{
	private JLabel idLabel, pwLabel;
	private JTextField idField, pwdField;
	private JButton loginBtn, join;
	private TestM my = null;
	
	public static void main(String[] args) {
		new TestM();
	}

	TestM() {
		super("Monster_Battle_ver0.1");
		my = this;
		
		this.setLayout(null);
		this.setBounds(150, 100, 250, 200);
		btnSet();
		labelSet();
		fieldSet();
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private void fieldSet() {
		idField = new JTextField(15);
		this.add(idField);
		idField.setBounds(100, 30, 100, 25);
		
		pwdField = new JTextField(15);
		pwdField.setBounds(100, 70, 100, 25);
		this.add(pwdField);
	}

	private void labelSet() {
		idLabel = new JLabel("I            D     :");
		idLabel.setBounds(30, 30, 80, 20);
		this.add(idLabel);
		
		pwLabel = new JLabel("Password :");
		pwLabel.setBounds(30, 70, 80, 20);
		this.add(pwLabel);
	}

	private void btnSet() {
		loginBtn = new JButton("Login");
		loginBtn.setBounds(50, 120, 70, 20);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TestList();
				my.dispose();
			}
		});
		
		this.add(loginBtn);
		join = new JButton("Join");
		join.setBounds(130,120, 70, 20);
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TestJoin(my);
				my.setVisible(false);
			}
		});
		this.add(join);
	}

}
