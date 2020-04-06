package Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestList extends JFrame implements ActionListener{
	private JLabel titleLb, listLb, infoLb;
	private JPanel wp, cp, sp;
	private JButton sendBtn;
	private JList userList;
	private JTextArea userInfo;
	private JTextField msgbar;
	private DefaultListModel<String> lm = new DefaultListModel<String>();
	
	TestList(){
		super("Monster_Battle_ver0.1");
		this.setLayout(null);
		this.setBounds(150, 100, 300, 400);
		createW();
		createC();
		createS();
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	private void createS() {
		sp = new JPanel();
		msgbar = new JTextField(10);
		sendBtn = new JButton("Send");
		sp.add(msgbar);
		sp.add(sendBtn);
		this.add(sp,"South");
		
		msgbar.addActionListener(this);
		sendBtn.addActionListener(this);
		
	}
	private void createC() {
		cp= new JPanel();
		cp.setLayout(new BorderLayout());
		infoLb = new JLabel("   대화내용");
		userInfo = new JTextArea(10,4);
		userInfo.setBackground(Color.LIGHT_GRAY);
		cp.add(infoLb,"North");
		cp.add(userInfo,"Center");
		this.add(cp,"Center");
	}
	private void createW() {
		wp= new JPanel();
		wp.setLayout(new BorderLayout());
		listLb = new JLabel("친구들");
		wp.add(listLb,"North");
		userList = new JList(lm);
		userList.setBackground(Color.yellow);
		wp.add(userList,"Center");
		this.add(wp,"West");
		
	}
	
	public void setList(String id) {
		lm.addElement(id);
	}
	
	public void setMsg(String msg) {
		userInfo.append(msg+"\n");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object nowCom = e.getSource();
		if(nowCom.equals(sendBtn)||nowCom.equals(msgbar)) {
			String msg = msgbar.getText();
			msgbar.setText("");
			setMsg(msg);
		}
		
	}
	
	public void setMe(String id) {
		titleLb.setText("현재 사용자 : "+id);
		setMsg("["+id+"] 로그인 합니다.");
	}
	
}
