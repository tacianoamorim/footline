package com.g2t.footline.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;

public class FrmProcessarRodada extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5714054118105634144L;
	
	private final JPanel contentPanel = new JPanel();
	private JTextArea textArea;
	private JLabel lblRodada;
	private JButton btnFechar;

	/**
	 * Create the dialog.
	 */
	public FrmProcessarRodada(Integer numero, FrmPrincipal frmPrincipal) {
		setModal(true);
		setUndecorated(true);
		setBounds(100, 100, 473, 460);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				lblRodada = new JLabel(" Rodada ");
				lblRodada.setForeground(Color.WHITE);
				lblRodada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				panel.add(lblRodada);
			}
		}
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			textArea = new JTextArea();
			contentPanel.add(textArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnFechar = new JButton("Fechar");
				btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnFechar.setFont(new Font("Tahoma", Font.BOLD, 11));
				buttonPane.add(btnFechar);
			}
		}
		
		// Inicialia o processamento da rodada
		processarRodada( numero, frmPrincipal );
	}
	
	private void processarRodada(Integer numero, FrmPrincipal frmPrincipal) {
		try {
			Fachada.getInstance().processarRodada(numero, frmPrincipal);
			
			// procesa se nao existir um campeao
			if ( FrmPrincipal.selecaoCampea == null ) {
				Rodada rodada= Fachada.getInstance().buscarRodada(numero);
				String textoAreao= "RESULTADOS  \n\n";
				
				lblRodada.setText( " Rodada " + rodada.getNumero() +" - " + rodada.getDescricao() );
				
				textArea.setText( textoAreao );
				
				for (Partida partida : rodada.getPartidas()) {
					textoAreao= textoAreao.concat(
						"  - Partida: "+ partida.getMandante().getSelecao().getNome()
						+" ("+ partida.getGolsMandante().size() 
						+") X ("+ partida.getGolsVisitante().size() +") "
						+ partida.getVisitante().getSelecao().getNome() 
						+"\n");
					textArea.setText( textoAreao );		
				}
				
				frmPrincipal.processarCarregamentoApp();
			}
			
		} catch (RegistroNaoEncontradoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
