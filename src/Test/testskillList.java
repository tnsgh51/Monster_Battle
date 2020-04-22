package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class testskillList extends JFrame {

	private JPanel contentPane;
	private JLabel skill[] = new JLabel[4];
	JButton b[] = new JButton[4];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testskillList frame = new testskillList();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testskillList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		skill[0] = new JLabel("스킬명이다 성공확률 : 100%");
		skill[0].setBounds(12, 10, 163, 30);
		contentPane.add(skill[0]);
		
		b[0] = new JButton("선택");
		b[0].setBounds(181, 10, 64, 30);
		contentPane.add(b[0]);
		
		skill[1] = new JLabel("스킬명이다 성공확률 : 100%");
		skill[1].setBounds(12, 50, 163, 30);
		contentPane.add(skill[1]);
		
		b[1] = new JButton("선택");
		b[1].setBounds(181, 50, 64, 30);
		contentPane.add(b[1]);
		setVisible(true);
	}
}
