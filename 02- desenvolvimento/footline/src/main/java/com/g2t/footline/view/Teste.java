package com.g2t.footline.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.g2t.componentes.view.JPainel;

public class Teste {

	public static void main(String[] args) {
		
		ImageIcon img=  new ImageIcon(Teste.class.getResource("arruda.gif"));
		
	    JPainel panel = new JPainel(
	           img.getImage());

	        JFrame frame = new JFrame();
	        frame.getContentPane().add(panel);
	        frame.pack();
	        frame.setVisible(true);

	}

}
