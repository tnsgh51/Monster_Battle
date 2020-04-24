package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame_Login extends JFrame {
	private JLabel idLabel, pwLabel;
	private JTextField idField;
	private JPasswordField pwdField;
	private JButton loginBtn, join;
	private Frame_Login my = null;
	private C_TC c_TC = null;
	private Frame_admin fa = null;

	Frame_Login(C_TC c_TC) {

		super("Monster_Battle_ver0.1");
		my = this;
		fa = Frame_admin.getInstance();
		this.c_TC = c_TC;
		this.setLayout(null);
		this.setBounds(250, 300, 250, 200);
		btnSet();
		labelSet();
		fieldSet();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void fieldSet() {
		idField = new JTextField(15);
		this.add(idField);
		idField.setBounds(100, 30, 100, 25);
		idField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text();
			}
		});
		pwdField = new JPasswordField(15);
		pwdField.setBounds(100, 70, 100, 25);
		pwdField.setEchoChar('*');
		pwdField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text();
			}
		});
		pwdField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() >= 4) {
					ke.consume();
				}
			}
		});
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
				text();
			}
		});

		this.add(loginBtn);
		join = new JButton("Join");
		join.setBounds(130, 120, 70, 20);

		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Frame_Join fj = new Frame_Join();
				fa.setFJ(fj);
				my.setVisible(false);
			}
		});
		this.add(join);
	}

	public void loginfalse(String k) {
		JOptionPane.showMessageDialog(null, k);
	}

	private void text() {
		char[] secret_pw = pwdField.getPassword();
		String k = "";
		for (char cha : secret_pw) {
			k = k + cha;
		}
		if (!idField.getText().equals("") && !k.equals("")) {
			c_TC.send("/login " + idField.getText() + " " + k);
		} else {
			JOptionPane.showMessageDialog(null, "id와 비밀번호를 입력하세요");
		}
		idField.setText("");
		pwdField.setText("");
		
		
	}
}
