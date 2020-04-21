package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame_Room extends JFrame implements ActionListener {
	JLabel titleLb, listLb, infoLb;
	JPanel wp, cp, sp;
	JButton sendBtn;
	
	JMenuItem vs,impo;
	JList userList;
	JTextArea userInfo;
	JTextField msgbar;
	DefaultListModel<String> lm = new DefaultListModel<String>();
	JPopupMenu popup;
	Frame_admin fa = null;

	public void friendAdd(String msg) {
		lm.addElement(msg);
	}

	Frame_Room(Frame_admin frame_admin) {
		super("Monster_Battle_ver0.1");
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.fa = frame_admin;
		this.setBounds(150, 200, 300, 400);
		createW();
		createC();
		createS();
		this.setVisible(true);

	}

	private void createS() {
		sp = new JPanel();
		msgbar = new JTextField(10);
		sendBtn = new JButton("Send");
		sp.add(msgbar);
		sp.add(sendBtn);
		this.add(sp, "South");
		sp.setBackground(Color.LIGHT_GRAY);
		msgbar.addActionListener(this);
		sendBtn.addActionListener(this);

	}

	private void createC() {
		cp = new JPanel();
		cp.setLayout(new BorderLayout());
		infoLb = new JLabel("   대화내용");
		userInfo = new JTextArea(10, 4);
		userInfo.setBackground(Color.LIGHT_GRAY);
		cp.setBackground(Color.LIGHT_GRAY);
		cp.add(infoLb, "North");
		cp.add(userInfo, "Center");
		this.add(cp, "Center");
	}

	private void createW() {
		wp = new JPanel();
		wp.setLayout(new BorderLayout());
		listLb = new JLabel("친구들");
		wp.add(listLb, "North");
		wp.setBackground(Color.LIGHT_GRAY);
		userList = new JList(lm);

		popup = new JPopupMenu();
		impo = new JMenuItem("정보보기");
		impo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fa.sendMsg("/room impo "+(String)userList.getSelectedValue());
			}
		});
		popup.add(impo);		
		vs = new JMenuItem("대전신청");

		vs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fa.sendMsg("/room battle "+(String)userList.getSelectedValue());
			}
		});
		popup.add(vs);
		userList.add(popup);
		userList.setBackground(Color.LIGHT_GRAY);

		userList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1) {

				}
				if (e.getClickCount() == 2) {
				}
				if (e.getButton() == 3) {
					userList.setSelectedIndex(userList.locationToIndex(new Point(e.getX(), e.getY())));
					popup.show(userList, e.getX(), e.getY());
				}
			}
		});

		wp.add(userList, "Center");

		this.add(wp, "West");

	}

	public void addMsg(String msg) {
		userInfo.append(msg + "\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object nowCom = e.getSource();
		if (nowCom.equals(sendBtn) || nowCom.equals(msgbar)) {
			String msg = msgbar.getText();
			msgbar.setText("");
			fa.sendMsg("/room msg " + msg);
		}
	}


	public void ba(String k) {
		int i=JOptionPane.showOptionDialog(this, k + "님의 베틀신청!", "Battle Apply", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, "예");		
		if(i==0) {
			fa.sendMsg("/room accept /");
		}else if(i==1) {
			fa.sendMsg("/room reject /");
		}
	}
	

}
