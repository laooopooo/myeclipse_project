package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SimpleGui2 implements ActionListener {
	JButton button;

	public static void main(String[] args) {
		SimpleGui2 gui = new SimpleGui2();
		gui.go();
	}

	public void go() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();
		button = new JButton("click me");

		button.addActionListener(this);

		frame.getContentPane().add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		button.setText("I've been clicked");
	}
}
