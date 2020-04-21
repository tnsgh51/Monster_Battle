package Client;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Send.DTO_BattleList;
import Send.TC_People;

public class Frame_Impo extends JFrame {
	private JPanel contentPane;
	private JLabel ID;
	private JLabel winlose;
	private JTextArea textArea;

	public void setAll(TC_People p) {
		ID.setText(p.getId() + "(" + p.getNickname() + ")");
		winlose.setText(p.getScore());
		String s = "";
		boolean t = true;
		for (DTO_BattleList l : p.getMybattleList()) {
			s=s+l.getId()+" vs "+l.getOpponent();
			t = false;
			if(l.getResult().equals("1")) {
				s=s+" (패)\n";
			}else {
				s=s+" (승)\n";
			}
		}
		if(t) {
			s= "전적이 없습니다.";
		}
		textArea.setText(s);
	}

	public Frame_Impo(TC_People p) {
		setBounds(100, 100, 237, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ID = new JLabel("New label");
		ID.setBounds(12, 10, 197, 36);
		contentPane.add(ID);

		winlose = new JLabel("New label");
		winlose.setBounds(86, 56, 123, 30);
		contentPane.add(winlose);
		
		JLabel label = new JLabel("통합전적 : ");
		label.setBounds(12, 56, 69, 30);
		contentPane.add(label);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 96, 197, 206);
		contentPane.add(textArea);
		setAll(p);
		this.setVisible(true);

	}

}
