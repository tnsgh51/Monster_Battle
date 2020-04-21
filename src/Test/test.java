package Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 237, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ID = new JLabel("New label");
		ID.setBounds(12, 10, 197, 36);
		contentPane.add(ID);
		
		JLabel winlose = new JLabel("New label");
		winlose.setBounds(86, 56, 123, 30);
		contentPane.add(winlose);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 96, 197, 206);
		contentPane.add(textArea);
		
		JLabel label = new JLabel("통합전적 : ");
		label.setBounds(12, 56, 69, 30);
		contentPane.add(label);
	}
}
