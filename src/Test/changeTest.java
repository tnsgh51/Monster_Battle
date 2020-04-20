package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class changeTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeTest frame = new changeTest();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public changeTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel monster_0 = new JLabel("닉네임0");
		monster_0.setBounds(12, 10, 66, 25);
		contentPane.add(monster_0);
		
		JPanel monster_0_hp = new JPanel();
		monster_0_hp.setBackground(Color.RED);
		monster_0_hp.setForeground(Color.WHITE);
		monster_0_hp.setBounds(76, 10, 150, 25);
		contentPane.add(monster_0_hp);
		monster_0_hp.setLayout(null);
		
		JPanel monster_0_hp_now = new JPanel();
		monster_0_hp_now.setBounds(0, 0, 150, 25);
		monster_0_hp_now.setBackground(Color.GREEN);
		monster_0_hp.add(monster_0_hp_now);
		
		JButton mon_0 = new JButton("선택");
		mon_0.setFont(new Font("굴림", Font.PLAIN, 11));
		mon_0.setBounds(238, 10, 62, 25);
		contentPane.add(mon_0);
		
		JLabel monster_1 = new JLabel("닉네임0");
		monster_1.setBounds(12, 45, 66, 25);
		contentPane.add(monster_1);
		
		JPanel monster_1_hp = new JPanel();
		monster_1_hp.setLayout(null);
		monster_1_hp.setForeground(Color.WHITE);
		monster_1_hp.setBackground(Color.RED);
		monster_1_hp.setBounds(76, 45, 150, 25);
		contentPane.add(monster_1_hp);
		
		JPanel monster_1_hp_now = new JPanel();
		monster_1_hp_now.setBackground(Color.GREEN);
		monster_1_hp_now.setBounds(0, 0, 150, 25);
		monster_1_hp.add(monster_1_hp_now);
		
		JButton mon_1 = new JButton("선택");
		mon_1.setFont(new Font("굴림", Font.PLAIN, 11));
		mon_1.setBounds(238, 45, 62, 25);
		contentPane.add(mon_1);
		
		JLabel monster_2 = new JLabel("닉네임0");
		monster_2.setBounds(12, 80, 66, 25);
		contentPane.add(monster_2);
		
		JPanel monster_2_hp = new JPanel();
		monster_2_hp.setLayout(null);
		monster_2_hp.setForeground(Color.WHITE);
		monster_2_hp.setBackground(Color.RED);
		monster_2_hp.setBounds(76, 80, 150, 25);
		contentPane.add(monster_2_hp);
		
		JPanel monster_2_hp_now = new JPanel();
		monster_2_hp_now.setBackground(Color.GREEN);
		monster_2_hp_now.setBounds(0, 0, 150, 25);
		monster_2_hp.add(monster_2_hp_now);
		
		JButton mon_2 = new JButton("선택");
		mon_2.setFont(new Font("굴림", Font.PLAIN, 11));
		mon_2.setBounds(238, 80, 62, 25);
		contentPane.add(mon_2);
		this.setVisible(true);
	}
}
