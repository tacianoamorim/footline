package com.g2t.footline.gui;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.g2t.footline.negocio.entidades.Escalacao;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Tatica;

import javax.swing.JComboBox;

public class FrmEscalarSelecao extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1415086182881940352L;
	private final JPanel contentPanel = new JPanel();
	private JComboBox<String> cbxTatica;

	/**
	 * Create the dialog.
	 */
	public FrmEscalarSelecao( Integer numero, FrmPrincipal frmPrincipal ) {
		setTitle("Escalar time");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 677, 506);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnCancelar.setBounds(391, 407, 106, 42);
			contentPanel.add(btnCancelar);
			btnCancelar.setActionCommand(" Cancel ");
		}
		{
			JButton btnJogar = new JButton(" Jogar >> ");
			btnJogar.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnJogar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// Valida as escalacao selecioanada
					
					Escalacao escalacao= new Escalacao();
					escalacao.setSelecao( FrmPrincipal.selecaoGerenciada );
					//escalacao.setTatica( Tatica.valueOf("442") );
					escalacao.setTitulares(null);
					escalacao.setReservas(null);
					
					
					
					
					
					
					
					setVisible(false);
					FrmProcessarRodada frmProcessarRodada= 
							new FrmProcessarRodada( numero, frmPrincipal );
					frmProcessarRodada.setVisible( true );
				}
			});
			btnJogar.setBounds(520, 407, 106, 42);
			contentPanel.add(btnJogar);
			btnJogar.setActionCommand("OK");
			getRootPane().setDefaultButton(btnJogar);
		}
		
		
		/*
		 * Lista de jogadores
		 */
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		
		JLabel lblSelecioneOs = new JLabel("Selecione os 11 titulares");
		lblSelecioneOs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelecioneOs.setForeground(Color.WHITE);
		lblSelecioneOs.setBounds(10, 9, 198, 14);
		contentPanel.add(lblSelecioneOs);
		
		JPanel pnlJogadores = new JPanel();
		pnlJogadores.setBounds(10, 34, 258, 343);
		contentPanel.add(pnlJogadores);
		pnlJogadores.setLayout(new BorderLayout(0, 0));
		JList<String> jltJogadores =  new JList<String>(modelo);
		jltJogadores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jltJogadores.setBackground(new Color(255, 255, 255));
		
		JScrollPane spnJogadores = new JScrollPane(jltJogadores);
		pnlJogadores.add(spnJogadores);
		
		
		/*
		 * Painel Goleiro
		 */
		DefaultListModel<String> modeloGoleiro = new DefaultListModel<String>();
		JPanel pnlGoleiro = new JPanel();
		pnlGoleiro.setBounds(391, 34, 235, 57);
		contentPanel.add(pnlGoleiro);
		
		JList<String> jltGoleiro = new JList<String>(modeloGoleiro);
		JScrollPane spnGoleiro = new JScrollPane(jltGoleiro);
		pnlGoleiro.add(spnGoleiro);

		JButton btnGoleiro = new JButton("Goleiro >>");
		btnGoleiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoleiro.setBackground(new Color(0, 128, 128));
		btnGoleiro.setBounds(278, 34, 103, 23);
		contentPanel.add(btnGoleiro);		
		btnGoleiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modeloGoleiro.addElement( jltJogadores.getSelectedValue() );
				//modelo.get( jltJogadores.getSelectedIndex() );
			}
		});
		
		JButton btnGoleiroRemover = new JButton("<< Goleiro");
		btnGoleiroRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoleiroRemover.setBackground(new Color(255, 69, 0));
		btnGoleiroRemover.setBounds(278, 68, 103, 23);
		btnGoleiroRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.addElement( jltGoleiro.getSelectedValue() );
			}
		});
		contentPanel.add(btnGoleiroRemover);
		
		/*
		 * Painel Defesa
		 */
		DefaultListModel<String> modeloDefesa = new DefaultListModel<String>();
		JPanel pnlDefesa = new JPanel();
		pnlDefesa.setBounds(391, 105, 235, 88);
		contentPanel.add(pnlDefesa);
		
		JList<String> jltDefesa = new JList<String>(modeloDefesa);
		JScrollPane spnDefesa = new JScrollPane(jltDefesa);
		pnlDefesa.add(spnDefesa);
		
		JButton btnDefesa = new JButton("Defesa >>");
		btnDefesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloDefesa.addElement( jltJogadores.getSelectedValue() );
			}
		});
		btnDefesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDefesa.setBackground(new Color(0, 128, 128));
		btnDefesa.setBounds(278, 122, 103, 23);
		contentPanel.add(btnDefesa);

		JButton btnDefesaRemover = new JButton("<< Defesa");
		btnDefesaRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDefesaRemover.setBackground(new Color(255, 69, 0));
		btnDefesaRemover.setBounds(278, 156, 103, 23);
		contentPanel.add(btnDefesaRemover);
		
		/*
		 * Painel Meia
		 */
		DefaultListModel<String> modeloMeioCampo = new DefaultListModel<String>();
		JPanel pnlMeioCampo = new JPanel();
		pnlMeioCampo.setBounds(391, 204, 235, 87);
		contentPanel.add(pnlMeioCampo);
		
		JList<String> jltMeioCampo = new JList<String>(modeloMeioCampo);
		JScrollPane spnMeioCampo = new JScrollPane(jltMeioCampo);
		pnlMeioCampo.add(spnMeioCampo);

		JButton btnMeioCampo = new JButton("Meia >>");
		btnMeioCampo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMeioCampo.setBackground(new Color(0, 128, 128));
		btnMeioCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloMeioCampo.addElement( jltJogadores.getSelectedValue() );
			}
		});
		btnMeioCampo.setBounds(278, 219, 103, 23);
		contentPanel.add(btnMeioCampo);
		
		JButton btnMeioCampoRemover = new JButton("<< Meia");
		btnMeioCampoRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMeioCampoRemover.setBackground(new Color(255, 69, 0));
		btnMeioCampoRemover.setBounds(278, 253, 103, 23);
		contentPanel.add(btnMeioCampoRemover);
		
		/*
		 * Painel Ataque
		 */
		DefaultListModel<String> modeloAtaque = new DefaultListModel<String>();
		JPanel pnlAtaque = new JPanel();
		pnlAtaque.setBounds(391, 302, 235, 75);
		contentPanel.add(pnlAtaque);
		
		JList<String> jltAtaque = new JList<String>(modeloAtaque);
		JScrollPane spnAtaque = new JScrollPane(jltAtaque);
		pnlAtaque.add(spnAtaque);
		
		JButton btnAtaque = new JButton("Ataque >>");
		btnAtaque.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtaque.setBackground(new Color(0, 128, 128));
		btnAtaque.setBounds(278, 314, 103, 23);
		btnAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloAtaque.addElement( jltJogadores.getSelectedValue() );
			}
		});
		contentPanel.add(btnAtaque);
		
		JButton btnAtaqueRemover = new JButton("<< Ataque");
		btnAtaqueRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtaqueRemover.setBackground(new Color(255, 69, 0));
		btnAtaqueRemover.setBounds(278, 348, 103, 23);
		contentPanel.add(btnAtaqueRemover);
		
		cbxTatica = new JComboBox<String>();
		cbxTatica.setBounds(18, 410, 258, 23);
		cbxTatica.addItem("T2");
		cbxTatica.addItem("T1");
		contentPanel.add(cbxTatica);
		
		JLabel lblSelecioneATtica = new JLabel("Selecione a tática utilizada");
		lblSelecioneATtica.setForeground(Color.WHITE);
		lblSelecioneATtica.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelecioneATtica.setBounds(18, 391, 198, 14);
		contentPanel.add(lblSelecioneATtica);

		
		/*
		 * Carrega a lista de jogadores
		 */
		// Adiciona os goleiros
		for (Jogador jogador : FrmPrincipal.selecaoGerenciada.getJogadores()) {
			if ( Jogador.GOLEIRO.equalsIgnoreCase( jogador.getPosicao() ) )
				modelo.addElement( " G "+ jogador.getNome() );
		}
		// Adiciona a defesa
		for (Jogador jogador : FrmPrincipal.selecaoGerenciada.getJogadores()) {
			if ( Jogador.DEFESA.equalsIgnoreCase( jogador.getPosicao() ) )
				modelo.addElement( " D "+ jogador.getNome() );
		}		
		// Adiciona o meioCampo
		for (Jogador jogador : FrmPrincipal.selecaoGerenciada.getJogadores()) {
			if ( Jogador.MEIO_CAMPO.equalsIgnoreCase( jogador.getPosicao() ) )
				modelo.addElement( " M "+ jogador.getNome() );
		}
		// Adiciona o ataque
		for (Jogador jogador : FrmPrincipal.selecaoGerenciada.getJogadores()) {
			if ( Jogador.ATAQUE.equalsIgnoreCase( jogador.getPosicao() ) )
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
	      jltJogadores.addListSelectionListener(listSelectionListener);		
	}
}
