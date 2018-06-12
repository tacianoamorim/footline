package com.g2t.footline.view.componentes;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
 
/**
 * Custom renderer to display a Calendario's
 *
 * @author wwww.codejava.net
 */
public class CalendarioRenderer extends JLabel 
	implements ListCellRenderer<String> {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1309015135929131236L;
	
	private int idx= 0;
    
	public CalendarioRenderer() {
        setOpaque(true);
    }
 
	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
			boolean isSelected, boolean cellHasFocus) {
 
        if ( (idx % 2) == 0 ) {
            setBackground( Color.CYAN );
            setForeground( Color.black );
        } else {
            setBackground( Color.black );
            setForeground( Color.white );
        }
        idx++;
        return this;
    }
}
