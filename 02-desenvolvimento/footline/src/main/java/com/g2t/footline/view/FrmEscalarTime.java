package com.g2t.footline.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.g2t.footline.entity.Footline;
import com.g2t.footline.entity.Jogador;
import com.g2t.footline.entity.Posicao;

public class FrmEscalarTime extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1415086182881940352L;
	private final JPanel contentPanel = new JPanel();
	private static FrmEscalarTime frmEscalarTime;

	/**
	 * Create the dialog.
	 */
	public FrmEscalarTime(Footline footline) {
		frmEscalarTime= this;
		setUndecorated(true);
		setTitle("Escalar time");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 446, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton cancelButton = new JButton("Cancelar");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			cancelButton.setBounds(327, 108, 96, 51);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand(" Cancel ");
		}
		{
			JButton okButton = new JButton(" Jogar >> ");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FrmProcessarRodada frmProcessarRodada= 
							new FrmProcessarRodada(footline, frmEscalarTime);
					frmProcessarRodada.setVisible( false );
				}
			});
			okButton.setBounds(327, 35, 96, 51);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		
		JLabel lblSelecioneOs = new JLabel("Selecione os 11 titulares");
		lblSelecioneOs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelecioneOs.setForeground(Color.WHITE);
		lblSelecioneOs.setBounds(10, 11, 198, 14);
		contentPanel.add(lblSelecioneOs);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 34, 295, 314);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JList<String> listJogadores =  new JList<String>(modelo);
		listJogadores.setBackground(new Color(255, 255, 255));
		
		JScrollPane scrollPane = new JScrollPane(listJogadores);
		panel.add(scrollPane);
		
		// Adiciona os goleiros
		for (Jogador jogador : footline.getClubeGerenciado().getJogadores()) {
			if ( jogador.getPosicao().compareTo(Posicao.G) == 0 )
				modelo.addElement( " G "+ jogador.getNome() );
		}
		// Adiciona a defesa
		for (Jogador jogador : footline.getClubeGerenciado().getJogadores()) {
			if ( jogador.getPosicao().compareTo(Posicao.D) == 0 )
				modelo.addElement( " D "+ jogador.getNome() );
		}		
		// Adiciona o meioCampo
		for (Jogador jogador : footline.getClubeGerenciado().getJogadores()) {
			if ( jogador.getPosicao().compareTo(Posicao.M) == 0 )
				modelo.addElement( " M "+ jogador.getNome() );
		}
		// Adiciona o ataque
		for (Jogador jogador : footline.getClubeGerenciado().getJogadores()) {
			if ( jogador.getPosicao().compareTo(Posicao.A) == 0 )
				modelo.addElement( " A "+ jogador.getNome() );
		}		

	    ListSelectionListener listSelectionListener = new ListSelectionListener() {
	        @SuppressWarnings("deprecation")
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
	          System.out.print("First index: " + listSelectionEvent.getFirstIndex());
	          System.out.print(", Last index: " + listSelectionEvent.getLastIndex());
	          boolean adjust = listSelectionEvent.getValueIsAdjusting();
	          System.out.println(", Adjusting? " + adjust);
	          if (!adjust) {
	            @SuppressWarnings("rawtypes")
				JList list = (JList) listSelectionEvent.getSource();
	            int selections[] = list.getSelectedIndices();
	            Object selectionValues[] = list.getSelectedValues();
	            for (int i = 0, n = selections.length; i < n; i++) {
	              if (i == 0) {
	                System.out.print("  Selections: ");
	              }
	              System.out.print(selections[i] + "/" + selectionValues[i] + " ");
	            }
	            System.out.println();
	          }
	        }
	      };
	      listJogadores.addListSelectionListener(listSelectionListener);		
	}
	
}
