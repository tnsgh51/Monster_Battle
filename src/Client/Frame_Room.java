package Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
import javax.swing.event.AncestorListener;

public class Frame_Room extends JFrame implements ActionListener {
	JLabel titleLb, listLb, infoLb;
	JPanel wp, cp, sp;
	JButton sendBtn, logout;

	JMenuItem vs, impo;
	JList userList;
	JTextArea userInfo;
	JTextField msgbar;
	DefaultListModel<String> lm = new DefaultListModel<String>();
	JPopupMenu popup;
	Frame_admin fa = null;
	Frame_Room fr;

	public void friendAdd(String msg) {
		lm.addElement(msg);
	}

	public void friendDelete(String k) {
		lm.removeElement(k);
	}
	Frame_Room(Frame_admin frame_admin) {
		super("Monster_Battle_ver0.1");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.fa = frame_admin;
		this.fr = this;
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
		JPanel jjp = new JPanel(new FlowLayout(FlowLayout.LEFT));
		listLb = new JLabel("친구들");
		infoLb = new JLabel("   대화내용                           ");
		logout = new JButton("logout");
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/room logout /");
				fa.showLogin();
				fr.dispose();
			}
		});
		logout.setBorderPainted(false);
		logout.setContentAreaFilled(false);
		logout.setFocusPainted(false);

		jjp.setBackground(Color.LIGHT_GRAY);
		jjp.add(listLb);
		jjp.add(infoLb);
		jjp.add(logout);

		cp.setBackground(Color.LIGHT_GRAY);
		cp.add(jjp, "North");
		this.add(cp, "North");

	}

	private void createW() {
		wp = new JPanel();
		wp.setLayout(new BorderLayout());

		userInfo = new JTextArea(10, 4);
		
		userInfo.setBackground(Color.LIGHT_GRAY);
		wp.add(userInfo, "Center");
		
		
		wp.setBackground(Color.LIGHT_GRAY);
		userList = new JList(lm);
		
		popup = new JPopupMenu();
		impo = new JMenuItem("정보보기");
		impo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fa.sendMsg("/room impo " + (String) userList.getSelectedValue());
			}
		});
		popup.add(impo);
		vs = new JMenuItem("대전신청");

		vs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fa.sendMsg("/room battle " + (String) userList.getSelectedValue());
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

		wp.add(userList, "West");

		this.add(wp, "Center");

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
		int i = JOptionPane.showOptionDialog(this, k + "님의 베틀신청!", "Battle Apply", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, "예");
		if (i == 0) {
			fa.sendMsg("/room accept /");
		} else if (i == 1) {
			fa.sendMsg("/room reject /");
		}
	}


}
