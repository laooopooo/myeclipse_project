package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DongHua {
	private JFrame frame;
	private int x = 0;
	private int y = 0;

	public static void main(String[] args) {
		new DongHua().go();
	}

	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyDrawPanel panel = new MyDrawPanel();
		frame.getContentPane().add(panel);

		frame.setSize(700, 700);
		frame.setVisible(true);

		while (x < 650) {
			frame.repaint();
			x += 1;
			// y += 1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class MyDrawPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			// int red = (int) (Math.random() * 255);
			// int green = (int) (Math.random() * 255);
			// int blue = (int) (Math.random() * 255);
			Color color = Color.red;
			g.setColor(color);
			g.fillOval(x, y, 100, 100);
		}
	}
}
