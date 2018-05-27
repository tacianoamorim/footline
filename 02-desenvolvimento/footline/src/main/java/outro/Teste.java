package outro;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.g2t.componentes.view.JPainel;

public class Teste {

	public static void main(String[] args) {
		
		ImageIcon img=  new ImageIcon(Teste.class.getResource("arruda.gif"));
		System.out.println( System.getProperty("user.dir") );
		
        System.out.println(Teste.class.getClass().getResource(""));
		
	   JPainel panel = new JPainel(
	          img.getImage());

	   //     JFrame frame = new JFrame();
	   //     frame.getContentPane().add(panel);
	   //     frame.pack();
	   //     frame.setVisible(true);

	}

}
