package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame_Change extends JFrame {
	private JPanel contentPane;
	JLabel monster[] = new JLabel[3];
	JPanel monster_hp[] = new JPanel[3];
	JPanel monster_hp_now[] = new JPanel[3];
	JButton mon_0, mon_1, mon_2;
	JFrame k;
	Frame_admin fa;

	Frame_Change(Frame_admin fa, String[] strings, int[] is, int[] is2) {
		k = this;
		this.fa = fa;
		setBounds(100, 100, 328, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		monster[0] = new JLabel("닉네임0");
		monster[0].setBounds(12, 10, 66, 25);
		contentPane.add(monster[0]);

		monster_hp[0] = new JPanel();
		monster_hp[0].setBackground(Color.RED);
		monster_hp[0].setForeground(Color.WHITE);
		monster_hp[0].setBounds(76, 10, 150, 25);
		contentPane.add(monster_hp[0]);
		monster_hp[0].setLayout(null);

		monster_hp_now[0] = new JPanel();
		monster_hp_now[0].setBounds(0, 0, 150, 25);
		monster_hp_now[0].setBackground(Color.GREEN);
		monster_hp[0].add(monster_hp_now[0]);

		mon_0 = new JButton("선택");
		mon_0.setFont(new Font("굴림", Font.PLAIN, 11));
		mon_0.setBounds(238, 10, 62, 25);
		contentPane.add(mon_0);

		monster[1] = new JLabel("닉네임0");
		monster[1].setBounds(12, 45, 66, 25);
		contentPane.add(monster[1]);

		monster_hp[1] = new JPanel();
		monster_hp[1].setLayout(null);
		monster_hp[1].setForeground(Color.WHITE);
		monster_hp[1].setBackground(Color.RED);
		monster_hp[1].setBounds(76, 45, 150, 25);
		contentPane.add(monster_hp[1]);

		monster_hp_now[1] = new JPanel();
		monster_hp_now[1].setBackground(Color.GREEN);
		monster_hp_now[1].setBounds(0, 0, 150, 25);
		monster_hp[1].add(monster_hp_now[1]);

		mon_1 = new JButton("선택");
		mon_1.setFont(new Font("굴림", Font.PLAIN, 11));
		mon_1.setBounds(238, 45, 62, 25);
		contentPane.add(mon_1);

		monster[2] = new JLabel("닉네임0");
		monster[2].setBounds(12, 80, 66, 25);
		contentPane.add(monster[2]);

		monster_hp[2] = new JPanel();
		monster_hp[2].setLayout(null);
		monster_hp[2].setForeground(Color.WHITE);
		monster_hp[2].setBackground(Color.RED);
		monster_hp[2].setBounds(76, 80, 150, 25);
		contentPane.add(monster_hp[2]);

		monster_hp_now[2] = new JPanel();
		monster_hp_now[2].setBackground(Color.GREEN);
		monster_hp_now[2].setBounds(0, 0, 150, 25);
		monster_hp[2].add(monster_hp_now[2]);

		mon_2 = new JButton("선택");
		mon_2.setFont(new Font("굴림", Font.PLAIN, 11));
		mon_2.setBounds(238, 80, 62, 25);
		contentPane.add(mon_2);
		
		setButton();
		setAll(strings, is, is2);
		this.setVisible(true);
	}

	private void setAll(String[] strings, int[] is, int[] is2) {
		for (int i = 0; i < 3; i++) {
			monster[i].setText(strings[i]);
			float f = (is2[i] * 150) / is[i];
			monster_hp_now[i].setBounds(0, 0, (int) f, 30);
			
			if(is2[i]<=0) {
				switch(i) {
				case 0:
					mon_0.setEnabled(false);
					break;
				case 1:
					mon_1.setEnabled(false);					
					break;
				case 2:
					mon_2.setEnabled(false);
					break;	
				}
			}
		}
	}

	private void setButton() {
		
		mon_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/battle change 0 / /");
				k.dispose();

			}
		});

		mon_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/battle change 1 / /");
				k.dispose();

			}
		});
		mon_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/battle change 2 / /");
				k.dispose();

			}
		});
	}
}
