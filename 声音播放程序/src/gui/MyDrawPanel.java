package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyDrawPanel extends JPanel {
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color color = new Color(red, green, blue);
		g.setColor(color);
		g.fillOval(100, 100, 100, 100);
	}

}
