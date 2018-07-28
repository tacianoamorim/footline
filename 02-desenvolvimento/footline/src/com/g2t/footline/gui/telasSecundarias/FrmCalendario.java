package com.g2t.footline.gui.telasSecundarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;

public class FrmCalendario extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5577059619343394507L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the frame.
	 */
	public FrmCalendario() {
		setUndecorated(true);
		setTitle("Calendário");
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 434, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		
		JPanel pnlLista = new JPanel();
		pnlLista.setBackground(Color.WHITE);
		contentPanel.add(pnlLista);
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JList<String> listJogos =  new JList<String>(modelo);
		listJogos.setVisibleRowCount(10);
		
		JScrollPane scrollPane = new JScrollPane(listJogos);
		
		// Carregar a lista
		List<Rodada> rodadas= Fachada.getInstance().listarRodadas();
		for (Rodada rodada : rodadas) {
			String textoRodada= "";
			if ( rodada.getNumero() < 10 )
				textoRodada= " RODADA: 0"+ rodada.getNumero() +" - "+
						rodada.getDescricao();
			else
				textoRodada= " RODADA: "+ rodada.getNumero() +" - "+
						rodada.getDescricao();
			
			modelo.addElement( textoRodada );
			
			for ( Partida partida : rodada.getPartidas() ) {
				String textoPartida= "   GRUPO " + partida.getGrupo() + " ";
				
				if ( partida.getMandante() != null ) { 
					textoPartida= textoPartida + "   - " + partida.getMandante().getSelecao().getNome();
					if ( partida.getPublico() == 0 ) {
						textoPartida= textoPartida + "  X  " + partida.getVisitante().getSelecao().getNome();
						
					} else {
						textoPartida= textoPartida + " "+ partida.getGolsMandante() +" X "+ 	
									partida.getGolsVisitante() +" "+ partida.getVisitante().getSelecao().getNome();
					}
					modelo.addElement( textoPartida );
				}
			}
		}
		pnlLista.setLayout(new BorderLayout(0, 0));
		
		pnlLista.add(scrollPane);
		{
			JPanel pnlBotao = new JPanel();
			pnlBotao.setBackground(Color.BLACK);
			pnlBotao.setForeground(new Color(0, 128, 128));
			pnlBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlBotao, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Fechar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				pnlBotao.add(btnCancelar);
			}
		}
		
	}

}
