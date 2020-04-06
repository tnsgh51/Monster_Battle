package Test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FrameEX2 extends JFrame implements ActionListener{
	JLabel titleLb, listLb, infoLb;
	JPanel wp, cp, sp;
	JButton sendBtn, clrBtn;

	JList userList;
	JTextArea userInfo;
	JTextField msgbar;
	DefaultListModel<String> lm = new DefaultListModel<String>();
	public static void main(String[] args) {
		new FrameEX2();
	}

	
	FrameEX2(){
		this.setBounds(150, 200, 300, 400);
//		createN();
		createW();
		createC();
		createS();
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
	private void createS() {
		sp = new JPanel();
		sp.setBackground(Color.red);
		msgbar = new JTextField(10);
		sendBtn = new JButton("Send");
		clrBtn = new JButton("Clear");
		sp.add(msgbar);
		sp.add(sendBtn);
		sp.add(clrBtn);
		this.add(sp,"South");
		
		msgbar.addActionListener(this);
		sendBtn.addActionListener(this);
		clrBtn.addActionListener(this);
		
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
//	private void createN() {
//		titleLb = new JLabel(" 채팅프로그램 ver 1.0");
//		this.add(titleLb,"North");
//	}
	
	public void setMe(String id) {
		titleLb.setText("현재 사용자 : "+id);
		setMsg("["+id+"] 로그인 합니다.");
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
		}else if(nowCom.equals(clrBtn)) {
			msgbar.setText("");
		}
		
	}
	
	
}
