package com.g2t.footline.gui.telasSecundarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;

public class FrmCalendario extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5577059619343394507L;

	/**
	 * Create the frame.
	 */
	public FrmCalendario() {
		setUndecorated(true);
		setTitle("Calendário");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(new Color(0, 128, 128));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 472, 410);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 472, 33);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Calendário");
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);
		
		JPanel pnlLista = new JPanel();
		pnlLista.setBounds(10, 44, 452, 313);
		getContentPane().add(pnlLista);
		pnlLista.setBackground(Color.WHITE);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JList<String> listJogos =  new JList<String>(modelo);
		
		JScrollPane scrollPane = new JScrollPane(listJogos);
		pnlLista.setLayout(new BorderLayout(0, 0));
		pnlLista.add(scrollPane);
		listJogos.setVisibleRowCount(10);
		{
			JPanel pnlBotao = new JPanel();
			pnlBotao.setBounds(10, 368, 452, 33);
			getContentPane().add(pnlBotao);
			pnlBotao.setBackground(Color.BLACK);
			pnlBotao.setForeground(new Color(0, 128, 128));
			pnlBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
				String textoPartida= "";
				if ( partida.getGrupo() != null ) {
					textoPartida= "   GRUPO " + partida.getGrupo() + " ";
				} 
				
				if ( partida.getMandante() != null ) { 
					textoPartida= textoPartida + "   - " + partida.getMandante().getSelecao().getNome();
					if ( partida.getPublico() == 0 ) {
						textoPartida= textoPartida + "  X  " 
								+ partida.getVisitante().getSelecao().getNome()
								+ " ("+ partida.getEstadio().getNome() +") ";
						
					} else {
						textoPartida= textoPartida + " "+ partida.getGolsMandante().size() 
								+" X "+	partida.getGolsVisitante().size() 
								+" "+ partida.getVisitante().getSelecao().getNome()
								+ " ("+ partida.getEstadio().getNome() +") ";
					}
					modelo.addElement( textoPartida );
				}
			}
			modelo.addElement( " " );
		}
	}
}
