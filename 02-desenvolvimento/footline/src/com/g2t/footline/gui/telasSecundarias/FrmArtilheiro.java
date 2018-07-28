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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Jogador;
import javax.swing.JLabel;
import java.awt.Font;

public class FrmArtilheiro extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 760532274470239244L;
	
	private final JPanel contentPanel = new JPanel();
	
	private Logger logger = Logger.getLogger( FrmArtilheiro.class );

	/**
	 * Create the frame.
	 */
	public FrmArtilheiro() {
		setUndecorated(true);
		setTitle("Calendário");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 434, 430);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 38, 434, 355);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		
		JPanel pnlLista = new JPanel();
		pnlLista.setBackground(Color.WHITE);
		contentPanel.add(pnlLista);
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JList<String> listJogos =  new JList<String>(modelo);
		listJogos.setVisibleRowCount(10);
		
		JScrollPane scrollPane = new JScrollPane(listJogos);
		pnlLista.setLayout(new BorderLayout(0, 0));
		
		pnlLista.add(scrollPane);
		{
			JPanel pnlBotao = new JPanel();
			pnlBotao.setBounds(0, 391, 424, 33);
			pnlBotao.setBackground(Color.BLACK);
			pnlBotao.setForeground(new Color(0, 128, 128));
			pnlBotao.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(pnlBotao);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 434, 33);
		getContentPane().add(panel);
		
		JLabel lblArtilheiros = new JLabel("Artilheiros");
		lblArtilheiros.setForeground(Color.WHITE);
		lblArtilheiros.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblArtilheiros);
		
		// Carregar a lista
		List<Jogador> Jogadores;
		try {
			Jogadores = Fachada.getInstance().listarArtilheiros();
			for (Jogador jogador : Jogadores) {
				String texto= " -" + jogador.getNome();
				if ( jogador.getQuantidadeGols() < 10 ) {
					texto= texto+ " ( 0"+ jogador.getQuantidadeGols() +" ) -> ";
				} else {
					texto= texto+ " ( "+ jogador.getQuantidadeGols() +" ) -> "; 
				}
				texto= texto+ "  "+ jogador.getSelecao().getNome();
				modelo.addElement( texto );
			}		
			
		} catch (RegistroNaoEncontradoException e) {
			logger.error("Error ", e);
			JOptionPane.showMessageDialog(null, e.getMensagem());
		}
		
	}

}
