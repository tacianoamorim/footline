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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class FrmEstadio extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5577059619343394507L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the frame.
	 */
	public FrmEstadio() {
		setUndecorated(true);
		setTitle("Calendário");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 720, 447);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 720, 369);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 154, 359);
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel);
		
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
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(169, 5, 539, 353);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrmEstadio.class.getResource("/imagens/estadios/estadioecaterimburgo.png")));
		lblNewLabel.setBounds(10, 0, 529, 394);
		panel_1.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 403, 720, 33);
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setForeground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton cancelButton = new JButton("Fechar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}
}
