package com.g2t.componentes.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPainel extends JPanel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1715238560086362585L;
	
	private Image img;

	public JPainel(String img) {
		this(new ImageIcon(img).getImage());
	}
	
	public JPainel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

}