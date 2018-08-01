package com.g2t.footline.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.g2t.footline.util.Biblioteca;

public class FrmCampeao extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5714054118105634144L;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblRodada;
	private JButton btnFechar;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblNomeSelecaoCampea;

	/**
	 * Create the dialog.
	 */
	public FrmCampeao() {
		getContentPane().setBackground(Color.BLACK);
		setUndecorated(true);
		setBounds(100, 100, 473, 460);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 38, 473, 366);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(26, 39, 223, 351);
			lblNewLabel.setIcon(new ImageIcon(FrmCampeao.class.getResource("/imagens/trofeu.png")));
		}
		contentPanel.setLayout(null);
		contentPanel.add(lblNewLabel);
		{
			lblNomeSelecaoCampea = new JLabel(" . . .");
			lblNomeSelecaoCampea.setHorizontalAlignment(SwingConstants.CENTER);
			lblNomeSelecaoCampea.setForeground(Color.WHITE);
			lblNomeSelecaoCampea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
			lblNomeSelecaoCampea.setBounds(259, 198, 213, 33);
			contentPanel.add(lblNomeSelecaoCampea);
		}
		{
			lblRodada = new JLabel("2018 FIFA World Cup champion");
			lblRodada.setHorizontalAlignment(SwingConstants.CENTER);
			lblRodada.setBounds(0, 11, 473, 33);
			getContentPane().add(lblRodada);
			lblRodada.setForeground(Color.WHITE);
			lblRodada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		}
		{
			label = new JLabel("");
			label.setBounds(269, 49, 165, 138);
			
			label.setIcon(new ImageIcon(
					FrmPrincipal.class.getResource("/imagens/bandeiras/"
						+ Biblioteca.removerAcentosEspacos(
								FrmPrincipal.selecaoCampea.getNome() ) 
						+".jpg")));	
			lblNomeSelecaoCampea.setText( FrmPrincipal.selecaoCampea.getNome()  );
		}		
		contentPanel.add(label);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 409, 473, 51);
			buttonPane.setBackground(Color.BLACK);
			getContentPane().add(buttonPane);
			{
				btnFechar = new JButton("Fechar");
				btnFechar.setBounds(379, 11, 71, 23);
				btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				buttonPane.setLayout(null);
				btnFechar.setFont(new Font("Tahoma", Font.BOLD, 11));
				buttonPane.add(btnFechar);
			}
		}
	}

}
