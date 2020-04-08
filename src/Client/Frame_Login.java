package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Frame_Login extends JFrame{



	private JLabel idLabel, pwLabel;
	private JTextField idField, pwdField;
	private JButton loginBtn, join;
	private Frame_Login my = null;
	private C_TC c_TC = null;
	Frame_Login(C_TC c_TC) {
		super("Monster_Battle_ver0.1");
		my = this;
		this.c_TC = c_TC;
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
				if(!idField.getText().equals("")&&!pwdField.getText().equals("")) {
					c_TC.send("/login "+idField.getText()+" " + pwdField.getText());
				}else {
					JOptionPane.showMessageDialog(null, "id와 비밀번호를 입력하세요");
				}
			}
		});
		
		this.add(loginBtn);
		join = new JButton("Join");
		join.setBounds(130,120, 70, 20);
		
		join.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Frame_Join(my);
				my.setVisible(false);
			}
		});
		this.add(join);
	}
	public void loginfalse() {
		JOptionPane.showMessageDialog(null, "id와 비밀번호를 체크해주세요");
	}
}


