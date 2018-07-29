package com.g2t.footline.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.g2t.footline.negocio.entidades.Escalacao;
import com.g2t.footline.negocio.entidades.Jogador;

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
		setUndecorated(true);
		setType(Type.POPUP);
		setTitle("Escalar time");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 650, 502);
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
			btnCancelar.setBounds(444, 60, 81, 42);
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
			btnJogar.setBounds(535, 60, 91, 42);
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
		lblSelecioneOs.setBounds(10, 119, 198, 14);
		contentPanel.add(lblSelecioneOs);
		
		JPanel pnlJogadores = new JPanel();
		pnlJogadores.setBounds(10, 144, 218, 318);
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
		pnlGoleiro.setBounds(391, 144, 235, 42);
		contentPanel.add(pnlGoleiro);
		
		JList<String> jltGoleiro = new JList<String>(modeloGoleiro);
		JScrollPane spnGoleiro = new JScrollPane(jltGoleiro);
		pnlGoleiro.add(spnGoleiro);

		JButton btnGoleiro = new JButton(">>");
		btnGoleiro.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoleiro.setBackground(new Color(0, 128, 128));
		btnGoleiro.setBounds(315, 163, 66, 23);
		contentPanel.add(btnGoleiro);		
		btnGoleiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( modeloGoleiro.size() > 0 ) {
					JOptionPane.showMessageDialog(null, "Na escalação só pode ter goleiro titular");
				} else {
					modeloGoleiro.addElement( jltJogadores.getSelectedValue() );
					//modelo.get( jltJogadores.getSelectedIndex() );
				}
			}
		});
		
		JButton btnGoleiroRemover = new JButton("<<");
		btnGoleiroRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGoleiroRemover.setBackground(new Color(255, 69, 0));
		btnGoleiroRemover.setBounds(238, 163, 67, 23);
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
		pnlDefesa.setBounds(391, 193, 235, 95);
		contentPanel.add(pnlDefesa);
		
		JList<String> jltDefesa = new JList<String>(modeloDefesa);
		JScrollPane spnDefesa = new JScrollPane(jltDefesa);
		pnlDefesa.add(spnDefesa);
		
		JButton btnDefesa = new JButton(">>");
		btnDefesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloDefesa.addElement( jltJogadores.getSelectedValue() );
			}
		});
		btnDefesa.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDefesa.setBackground(new Color(0, 128, 128));
		btnDefesa.setBounds(315, 221, 66, 23);
		contentPanel.add(btnDefesa);

		JButton btnDefesaRemover = new JButton("<<");
		btnDefesaRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDefesaRemover.setBackground(new Color(255, 69, 0));
		btnDefesaRemover.setBounds(238, 221, 67, 23);
		contentPanel.add(btnDefesaRemover);
		
		/*
		 * Painel Meia
		 */
		DefaultListModel<String> modeloMeioCampo = new DefaultListModel<String>();

		JButton btnMeioCampo = new JButton(">>");
		btnMeioCampo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMeioCampo.setBackground(new Color(0, 128, 128));
		btnMeioCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloMeioCampo.addElement( jltJogadores.getSelectedValue() );
			}
		});
		JPanel pnlMeioCampo = new JPanel();
		pnlMeioCampo.setBounds(391, 292, 235, 95);
		contentPanel.add(pnlMeioCampo);
		
		JList<String> jltMeioCampo = new JList<String>(modeloMeioCampo);
		JScrollPane spnMeioCampo = new JScrollPane(jltMeioCampo);
		pnlMeioCampo.add(spnMeioCampo);
		btnMeioCampo.setBounds(315, 314, 66, 23);
		contentPanel.add(btnMeioCampo);
		
		JButton btnMeioCampoRemover = new JButton("<<");
		btnMeioCampoRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMeioCampoRemover.setBackground(new Color(255, 69, 0));
		btnMeioCampoRemover.setBounds(238, 314, 67, 23);
		contentPanel.add(btnMeioCampoRemover);
		
		/*
		 * Painel Ataque
		 */
		DefaultListModel<String> modeloAtaque = new DefaultListModel<String>();
		JPanel pnlAtaque = new JPanel();
		pnlAtaque.setBounds(391, 392, 235, 70);
		contentPanel.add(pnlAtaque);
		
		JList<String> jltAtaque = new JList<String>(modeloAtaque);
		JScrollPane spnAtaque = new JScrollPane(jltAtaque);
		pnlAtaque.add(spnAtaque);
		
		JButton btnAtaque = new JButton(">>");
		btnAtaque.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtaque.setBackground(new Color(0, 128, 128));
		btnAtaque.setBounds(315, 408, 66, 23);
		btnAtaque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modeloAtaque.addElement( jltJogadores.getSelectedValue() );
			}
		});
		contentPanel.add(btnAtaque);
		
		JButton btnAtaqueRemover = new JButton("<<");
		btnAtaqueRemover.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtaqueRemover.setBackground(new Color(255, 69, 0));
		btnAtaqueRemover.setBounds(238, 408, 67, 23);
		contentPanel.add(btnAtaqueRemover);
		
		JLabel lblSelecioneATtica = new JLabel("Selecione a tática utilizada");
		lblSelecioneATtica.setForeground(Color.WHITE);
		lblSelecioneATtica.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSelecioneATtica.setBounds(10, 47, 198, 14);
		contentPanel.add(lblSelecioneATtica);		
		
		cbxTatica = new JComboBox<String>();
		cbxTatica.setBounds(10, 70, 128, 23);
		cbxTatica.addItem("-- Selecione --");
		cbxTatica.addItem("3-5-2");
		cbxTatica.addItem("3-4-3");
		cbxTatica.addItem("4-3-3");
		cbxTatica.addItem("4-4-2");
		cbxTatica.addItem("4-2-4");
		cbxTatica.addItem("4-5-1");
		cbxTatica.addItem("5-2-3");
		cbxTatica.addItem("5-3-2");
		cbxTatica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("actionPerformed");
			}
		});		
		contentPanel.add(cbxTatica);
		
		JLabel lblGoleiro = new JLabel("Goleiro");
		lblGoleiro.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 16));
		lblGoleiro.setForeground(Color.WHITE);
		lblGoleiro.setBounds(238, 138, 143, 23);
		contentPanel.add(lblGoleiro);
		
		JLabel lblDefesa = new JLabel("Defesa");
		lblDefesa.setForeground(Color.WHITE);
		lblDefesa.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 16));
		lblDefesa.setBounds(238, 197, 143, 23);
		contentPanel.add(lblDefesa);
		
		JLabel lblMeioCampo = new JLabel("Meio campo");
		lblMeioCampo.setForeground(Color.WHITE);
		lblMeioCampo.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 16));
		lblMeioCampo.setBounds(238, 292, 143, 23);
		contentPanel.add(lblMeioCampo);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setForeground(Color.WHITE);
		lblAtaque.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 16));
		lblAtaque.setBounds(238, 384, 143, 23);
		contentPanel.add(lblAtaque);
		
		JCheckBox chckbxSelecaoAutomtica = new JCheckBox("Seleção automática");
		chckbxSelecaoAutomtica.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ( chckbxSelecaoAutomtica.isSelected() ) {
					
				} else {
					
				}
				
			}
		});
		chckbxSelecaoAutomtica.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 14));
		chckbxSelecaoAutomtica.setForeground(Color.WHITE);
		chckbxSelecaoAutomtica.setBackground(Color.BLACK);
		chckbxSelecaoAutomtica.setBounds(144, 68, 179, 26);
		contentPanel.add(chckbxSelecaoAutomtica);
		
		JButton btnLimparCombo = new JButton("Limpar tudo");
		btnLimparCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.removeAllElements();
				modeloDefesa.removeAllElements();
				modeloMeioCampo.removeAllElements();
				modeloAtaque.removeAllElements();
				modeloGoleiro.removeAllElements();
				carregarJogadores(modelo);	
			}
		});
		btnLimparCombo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLimparCombo.setBounds(329, 60, 105, 42);
		contentPanel.add(btnLimparCombo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(3, 0, 623, 33);
		contentPanel.add(panel);
		
		JLabel lblDefinirEscalao = new JLabel("Definir escalação");
		lblDefinirEscalao.setForeground(Color.WHITE);
		lblDefinirEscalao.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblDefinirEscalao);
		
		// Carrega a lista de jogadores
		carregarJogadores(modelo);		
		
		// carrega a lista de taticas
		
		

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

	private void carregarJogadores(DefaultListModel<String> modelo) {
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
	}
}
