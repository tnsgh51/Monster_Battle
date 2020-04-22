package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame_Join extends JFrame {
	private JLabel idLabel, pwLabel, checkLabel, nnLabel;
	private JComboBox m1, m2, m3;
	private JTextField idField, nnField;
	private JPasswordField pwdField;
	private JTextField m1_name, m2_name, m3_name;
	private JButton idcheck, join;
	private Frame_Join my = null;
	private static Frame_admin fa = null;
	String[] monsterL = { "불몬스터", "물몬스터", "바람몬스터", "땅몬스터","닥트리오" };
	private int uu = 0;
	private int tt = 0;

	Frame_Join() {
		super("Monster_Battle_ver0.1");
		fa = Frame_admin.getInstance();
		my = this;
		this.setLayout(null);
		this.setBounds(150, 100, 315, 420);
		this.setVisible(true);
		btnSet();
		labelSet();
		fieldSet();
		comboSet();
		panelSet();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void panelSet() {

		m1_name = new JTextField();
		m1_name.setBounds(120, 220, 120, 25);
		this.add(m1_name);

		m2_name = new JTextField();
		m2_name.setBounds(120, 260, 120, 25);
		this.add(m2_name);
		m3_name = new JTextField();
		m3_name.setBounds(120, 300, 120, 25);
		this.add(m3_name);

	}

	private void comboSet() {
		m1 = new JComboBox(monsterL);
		m1.setBounds(30, 220, 80, 25);
		this.add(m1);
		m2 = new JComboBox(monsterL);
		m2.setBounds(30, 260, 80, 25);
		this.add(m2);
		m3 = new JComboBox(monsterL);
		m3.setBounds(30, 300, 80, 25);
		this.add(m3);
	}

	private void fieldSet() {
		idField = new JTextField(15);
		this.add(idField);
		idField.setBounds(100, 30, 100, 25);

		pwdField = new JPasswordField(15);
		pwdField.setBounds(100, 100, 100, 25);
		pwdField.setEchoChar('*');
		pwdField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				if (((JTextField) ke.getSource()).getText().length() >= 4) {
					ke.consume();
				}
			}
		});
		this.add(pwdField);
		nnField = new JTextField(15);
		nnField.setBounds(100, 170, 100, 25);
		this.add(nnField);
	}

	private void labelSet() {
		idLabel = new JLabel("I            D     :");
		idLabel.setBounds(30, 30, 80, 20);
		this.add(idLabel);

		pwLabel = new JLabel("Password :");
		pwLabel.setBounds(30, 100, 80, 20);
		this.add(pwLabel);
		nnLabel = new JLabel("Nickname :");
		nnLabel.setBounds(30, 170, 80, 20);
		this.add(nnLabel);

		checkLabel = new JLabel();
		checkLabel.setBounds(30, 60, 200, 25);
		checkLabel.setText("6~10글자 , 특수문자X");
		this.add(checkLabel);

	}

	private void btnSet() {
		idcheck = new JButton("중복확인");
		idcheck.setBounds(205, 30, 87, 25);
		idcheckSet();
		this.add(idcheck);

		join = new JButton("회원가입");
		join.setEnabled(false);
		join.setBounds(180, 340, 87, 25);

		join.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char[] secret_pw = pwdField.getPassword();
				String k = "";
				for (char cha : secret_pw) {
					k = k + cha;
				}
				if (k.length() == 4) {

					if (m1_name.getText().equals("")) {
						m1_name.setText(m1.getSelectedItem().toString());
					}
					if (m2_name.getText().equals("")) {
						m2_name.setText(m2.getSelectedItem().toString());
					}
					if (m3_name.getText().equals("")) {
						m3_name.setText(m3.getSelectedItem().toString());
					}
					String tt = m1_name.getText() + " " + m1.getSelectedItem().toString() + " " + m2_name.getText()
							+ " " + m2.getSelectedItem().toString() + " " + m3_name.getText() + " "
							+ m3.getSelectedItem().toString();
					fa.sendMsg(
							"/join apply " + idField.getText() + " " + k + " " + nnField.getText() + " " + tt + " /");
				} else {
					pwdfail();
				}
			}
		});

		this.add(join);
	}

	public void pwdfail() {
		JOptionPane.showMessageDialog(null, "PW는 4글자만 가능합니다.");
	}

	public void idcheckSet() {
		idcheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/join idcheck " + idField.getText());
			}
		});

	}

	public void successCheck() {
		checkLabel.setText("사용할 수 있습니다.");
		int i = JOptionPane.showOptionDialog(null, "사용하시겠습니까?", "확인메세지", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, "예");
		if (i == 0) {
			join.setEnabled(true);
			idField.setEnabled(false);
			idcheck.setEnabled(false);
		}
	}

	public void failCheck(String k) {
		checkLabel.setText(k);
	}

	public void applySuccess() {
		JOptionPane.showMessageDialog(null, "정상가입되었습니다.");
		
		this.dispose();
		fa.showLogin();
	}

}
