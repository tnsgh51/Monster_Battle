package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame_Skill extends JFrame{
	private JPanel contentPane;
	private JLabel skill[] = new JLabel[4];
	private JLabel skillp[] = new JLabel[4];
	JButton b[] = new JButton[4];
	private Frame_Skill fs;
	
	public Frame_Skill(String[][] strings,Frame_admin fa) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fs = this;
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for(int i = 0 ; i<4;i++) {
			skill[i] = new JLabel(strings[i][0]);
			skill[i].setBounds(12, 10+(i*40), 80, 30);
			
			contentPane.add(skill[i]);
			skillp[i] = new JLabel("성공확률 : "+Integer.parseInt(strings[i][2])+"%");
			skillp[i].setBounds(105, 10+(i*40), 108, 30);
			
			contentPane.add(skillp[i]);

			
			b[i] = new JButton("선택");
			b[i].setBounds(208, 10+(i*40), 64, 30);
			contentPane.add(b[i]);
		}
		b[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/battle skill "+0+" / / /");	
				fs.dispose();
			}
		});
		b[1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/battle skill "+1+" / / /");					
				fs.dispose();
			}
		});
		b[2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/battle skill "+2+" / / /");					
				fs.dispose();
			}
		});
		b[3].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fa.sendMsg("/battle skill "+3+" / / /");					
				fs.dispose();
			}
		});
		setVisible(true);
	}
}
