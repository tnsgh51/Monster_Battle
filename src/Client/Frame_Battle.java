package Client;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Send.TC_Object;

public class Frame_Battle extends JFrame {
	private JPanel contentPane;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JButton skillButton;
	private JLabel lblNewLabel_2;
	private JLabel label_1;
	private JButton attackButton;
	private JLabel label_2;
	private JButton changeButton;
	private JLabel label_3;
	private JButton surrenButton;
	private JTextField situation;
	private Image i = null;
	private Image j = null;
	private JLabel oMonster, myMonster;
	private JPanel panel_3;
	private JPanel myHpLine;
	private JPanel panel_2;
	private JPanel oHpLine;
	private JLabel myName;
	private JLabel myLv;
	private JLabel oLv;
	private JLabel oName;
	private JLabel oHp2;
	private JLabel myHp2;
	private JLabel oHp;
	private JLabel myHp;
	private String id;
	private static Frame_admin fa = Frame_admin.getInstance();

	public void setId(String id) {
		this.id = id;
	}

	public void setField(TC_Object k) {
		if (k.getId1().equals(id)) {
			System.out.println("1번실행");
			myimg(k.getId1_Monster_img((k.getId1_now_monster())));
			mymonster(k.getId1_Monster_origin(k.getId1_now_monster()),
					k.getId1_Monster_nickname(k.getId1_now_monster()), k.getId1_Monster_Lv(k.getId1_now_monster()));
			myhp(k.getId1_Monster_hp(k.getId1_now_monster()), k.getId1_Monster_hp_now(k.getId1_now_monster()));

			youimg(k.getId2_Monster_img((k.getId2_now_monster())));
			youmonster(k.getId2_Monster_origin(k.getId2_now_monster()),
					k.getId2_Monster_nickname(k.getId2_now_monster()), k.getId2_Monster_Lv(k.getId2_now_monster()));
			youhp(k.getId2_Monster_hp(k.getId2_now_monster()), k.getId2_Monster_hp_now(k.getId2_now_monster()));
		} else {
			System.out.println("2번실행");
			youimg(k.getId1_Monster_img((k.getId1_now_monster())));
			youmonster(k.getId1_Monster_origin(k.getId1_now_monster()),
					k.getId1_Monster_nickname(k.getId1_now_monster()), k.getId1_Monster_Lv(k.getId1_now_monster()));
			youhp(k.getId1_Monster_hp(k.getId1_now_monster()), k.getId1_Monster_hp_now(k.getId1_now_monster()));

			myimg(k.getId2_Monster_img((k.getId2_now_monster())));
			mymonster(k.getId2_Monster_origin(k.getId2_now_monster()),
					k.getId2_Monster_nickname(k.getId2_now_monster()), k.getId2_Monster_Lv(k.getId2_now_monster()));
			myhp(k.getId2_Monster_hp(k.getId2_now_monster()), k.getId2_Monster_hp_now(k.getId2_now_monster()));

		}
		if (id.equals(k.getNow_turn())) {
			turn(true);
		} else {
			turn(false);
		}
		System.out.println("???");

	}

	private void turn(boolean b) {
		surrenButton.setEnabled(b);
		attackButton.setEnabled(b);
		skillButton.setEnabled(b);
		changeButton.setEnabled(b);
		if (b) {
			situation.setText("나의턴!");
		} else {
			situation.setText("대기중");
		}

	}

	private void youhp(int hp, int hp_now) {
		oHp2.setText("/ " + hp);
		oHp.setText("" + hp_now);
		float f = hp_now/hp;
		oHpLine.setBounds(0, 0, (int) (f * 250), 30);
		System.out.println(hp_now);
		System.out.println(hp);
		System.out.println(f);
		System.out.println(f*250);
		System.out.println((int) (f * 250));

	}

	private void youmonster(String o, String n, float f) {
		oName.setText(o + " / " + n);
		oLv.setText("Lv " + (int) f);

	}

	private void youimg(String img) {
		try {
			i = ImageIO.read(new File(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image t = i.getScaledInstance(250, 172, Image.SCALE_AREA_AVERAGING);
		oMonster.setIcon(new ImageIcon(t));

	}

	private void myhp(int hp, int hp_now) {
		myHp2.setText("/ " + hp);
		myHp.setText("" + hp_now);		
		float f = hp_now/hp;
		
		myHpLine.setBounds(0, 0, (int) (f * 250), 30);

		System.out.println((int) ((hp_now / hp) * 250));
	}

	private void mymonster(String o, String n, float f) {
		myName.setText(o + " / " + n);
		myLv.setText("Lv " + (int) f);
	}

	private void myimg(String img) {
		try {
			j = ImageIO.read(new File(img));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image k = j.getScaledInstance(250, 172, Image.SCALE_AREA_AVERAGING);
		myMonster.setIcon(new ImageIcon(k));
	}

	Frame_Battle() {
		super("Monster_Battle_ver0.1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 615);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		oMonster = new JLabel("New label");
		try {
			i = ImageIO.read(new File("3번.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image t = i.getScaledInstance(250, 172, Image.SCALE_AREA_AVERAGING);
		oMonster.setIcon(new ImageIcon(t));
		oMonster.setBounds(288, 10, 250, 172);
		contentPane.add(oMonster);

		myMonster = new JLabel("New label");
		try {
			j = ImageIO.read(new File("3번.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image k = j.getScaledInstance(250, 172, Image.SCALE_AREA_AVERAGING);
		myMonster.setIcon(new ImageIcon(k));
		myMonster.setBounds(12, 192, 250, 172);
		contentPane.add(myMonster);

//		this.setComponentZOrder(textField_3, 3);

		lblNewLabel_1 = new JLabel("─────────────────────────────────────────");
		lblNewLabel_1.setBounds(12, 374, 538, 15);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBounds(275, 399, 263, 168);
		contentPane.add(panel);
		panel.setLayout(null);

		skillButton = new JButton("스  킬");
		skillButton.setBounds(154, 46, 97, 23);
		panel.add(skillButton);

		lblNewLabel_2 = new JLabel("▶");
		lblNewLabel_2.setBounds(136, 46, 28, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		label_1 = new JLabel("▶");
		label_1.setBounds(12, 46, 28, 23);
		panel.add(label_1);
		label_1.setVisible(false);
		attackButton = new JButton("공  격");
		attackButton.setBounds(30, 46, 97, 23);
		panel.add(attackButton);

		label_2 = new JLabel("▶");
		label_2.setBounds(12, 99, 28, 23);
		panel.add(label_2);
		label_2.setVisible(false);

		changeButton = new JButton("교  체");
		changeButton.setBounds(30, 99, 97, 23);
		panel.add(changeButton);

		label_3 = new JLabel("▶");
		label_3.setBounds(136, 99, 28, 23);
		panel.add(label_3);
		label_3.setVisible(false);

		surrenButton = new JButton("기  권");
		surrenButton.setBounds(154, 99, 97, 23);

		panel.add(surrenButton);
		panel_1 = new JPanel();
		panel_1.setBounds(12, 399, 263, 168);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		situation = new JTextField();
		situation.setEnabled(false);

		situation.setBounds(12, 56, 239, 59);
		panel_1.add(situation);
		situation.setColumns(10);

		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(288, 283, 250, 30);
		panel_3.setBackground(Color.RED);

		myHpLine = new JPanel();
		myHpLine.setBackground(Color.GREEN);
		myHpLine.setBounds(0, 0, 250, 30);
		panel_3.add(myHpLine);

		contentPane.add(panel_3);
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(12, 86, 250, 30);

		oHpLine = new JPanel();
		oHpLine.setBackground(Color.GREEN);
		oHpLine.setBounds(0, 0, 250, 30);
		panel_2.add(oHpLine);

		contentPane.add(panel_2);
		myName = new JLabel("몬스터 / 몬스터명");
		myName.setBounds(286, 243, 154, 30);
		contentPane.add(myName);

		myLv = new JLabel("Lv. 1");
		myLv.setBounds(488, 243, 50, 30);
		contentPane.add(myLv);

		oLv = new JLabel("Lv. 1");
		oLv.setBounds(212, 46, 50, 30);
		contentPane.add(oLv);

		oName = new JLabel("몬스터 / 몬스터명");
		oName.setBounds(12, 46, 154, 30);
		contentPane.add(oName);

		oHp2 = new JLabel("/ 100");
		oHp2.setBounds(228, 126, 34, 15);
		contentPane.add(oHp2);

		myHp2 = new JLabel("/ 100");
		myHp2.setBounds(504, 323, 34, 15);
		contentPane.add(myHp2);

		oHp = new JLabel("90");
		oHp.setBounds(194, 126, 22, 15);
		contentPane.add(oHp);

		myHp = new JLabel("90");
		myHp.setBounds(470, 323, 22, 15);
		contentPane.add(myHp);

		attactAction();
		skillAction();
		changeAction();
		surrenAction();

		this.setVisible(true);
	}

	private void skillAction() {
		skillButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void surrenAction() {
		surrenButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_3.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_3.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void changeAction() {
		changeButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				fa.sendMsg("/battle change 1 /");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_2.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_2.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private void attactAction() {
		attackButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				fa.sendMsg("/battle attack / / /");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				label_1.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				label_1.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

}
