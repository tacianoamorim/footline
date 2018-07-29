package com.g2t.footline.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

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

	/**
	 * Create the dialog.
	 */
	public FrmProcessarRodada(Integer numero, FrmPrincipal frmPrincipal) {
		setBounds(100, 100, 473, 460);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JLabel lblRodada = new JLabel("Rodada");
				lblRodada.setForeground(Color.WHITE);
				lblRodada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
				panel.add(lblRodada);
			}
		}
		contentPanel.setBackground(Color.LIGHT_GRAY);
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
		}
		
		// Inicialia o processamento da rodada
		processarRodada( numero, frmPrincipal );
	}
	
	private void processarRodada(Integer numero, FrmPrincipal frmPrincipal) {
		try {
			Fachada.getInstance().processarRodada(numero, frmPrincipal);
			
			Rodada rodada= Fachada.getInstance().buscarRodada(numero);
			String textoAreao= "RODADA "+ rodada.getNumero() +" - " + rodada.getDescricao() +" ["+
					rodada.isFinalizada() +"] \n";
			textArea.setText( textoAreao );
			
			for (Partida partida : rodada.getPartidas()) {
				textoAreao= textoAreao.concat(
					"  - Partida: "+ partida.getMandante().getSelecao().getNome()
					+" ("+ partida.getGolsMandante() 
					+") X ("+ partida.getGolsVisitante() +") "
					+ partida.getVisitante().getSelecao().getNome() 
					+"\n");
				textArea.setText( textoAreao );		
			}
			
			frmPrincipal.processarCarregamentoApp();
			
		} catch (RegistroNaoEncontradoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
