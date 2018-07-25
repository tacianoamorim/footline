package com.g2t.footline.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;

import com.g2t.footline.gui.componentes.JogadorTableModel;
import com.g2t.footline.gui.telasSecundarias.FrmCalendario;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.util.Biblioteca;

public class FrmPrincipal extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2575483770162322308L;
	
	public static Selecao selecaoGerenciada;
	private JLabel lblBarraStatus;
	private JogadorTableModel jogadorTableModel;
	
	private JLabel lblEscudo;
	private JLabel lblNomeSelecao;
	private JLabel lblTecnico;
	
	private JLabel lblNomeAdversario;
	private JLabel lblNomeTecnicoAdversario;
	private JLabel lblRodada;
	private JLabel lblEscudoAdversario;
	private JLabel lblLocalPartida;
	
	private Integer numeroRodadaAtual;
		
	/**
	 * Create the application.
	 */
	public FrmPrincipal() {
		setTitle("Footline - Copa Russia 2018");
		setResizable(false);
		
		// Exibe a tela
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//frame = new JFrame();
		setBounds(100, 100, 900, 531);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTopo = new JPanel();
		pnlTopo.setForeground(new Color(0, 100, 0));
		pnlTopo.setBackground(Color.BLACK);
		getContentPane().add(pnlTopo, BorderLayout.NORTH);
		pnlTopo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		pnlTopo.add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("  Footline - Rússia Copa 2018  ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 26));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		pnlTopo.add(panel_1, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(Color.WHITE);
		panel_1.add(toolBar);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		
		// --------------------------------------------------------
		// BOTOES MENU - INICIO
		// --------------------------------------------------------		
		JButton btnCalendario = new JButton("Calendário");
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                FrmCalendario frmCalendario= new FrmCalendario();
                frmCalendario.setVisible(true);
			}
		});
		btnCalendario.setForeground(Color.WHITE);
		toolBar.add(btnCalendario);
		
		JLabel label_4 = new JLabel("     ");
		toolBar.add(label_4);
		
		JButton btnClassificacao = new JButton("Classificação");
		btnClassificacao.setForeground(Color.WHITE);
		toolBar.add(btnClassificacao);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					//FootlineService.getInstance().salvar(nomeArquivo, footline);
					JOptionPane.showMessageDialog(null, "Jogo salvo!", "Salvar Jogo", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		JLabel label_3 = new JLabel("     ");
		toolBar.add(label_3);
		
		JButton btnArtilheiro = new JButton("Artilheiros");
		btnArtilheiro.setForeground(Color.WHITE);
		toolBar.add(btnArtilheiro);
		
		JLabel label_5 = new JLabel("     ");
		toolBar.add(label_5);
		
		JButton btnTime = new JButton("Seleções");
		btnTime.setForeground(Color.WHITE);
		toolBar.add(btnTime);
		
		JLabel label_1 = new JLabel("     ");
		toolBar.add(label_1);
		
		JButton btnEstadio = new JButton("Estádio");
		btnEstadio.setForeground(Color.WHITE);
		toolBar.add(btnEstadio);
		
		JLabel lblEspacos1 = new JLabel("     ");
		toolBar.add(lblEspacos1);
		toolBar.add(btnSalvar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.BLACK);
		pnlTopo.add(panel_2, BorderLayout.EAST);
		
		JButton btnSair = new JButton("Sair");
		panel_2.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// --------------------------------------------------------
		// BOTOES MENU - FIM
		// --------------------------------------------------------		
		
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBackground(new Color(255, 255, 255));
		getContentPane().add(pnlCentro);
		pnlCentro.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(new Color(255, 255, 255));
		panel_3.setBackground(Color.BLACK);
		panel_3.setBorder(new CompoundBorder());
		panel_3.setBounds(10, 11, 267, 417);
		pnlCentro.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(10, 11, 247, 104);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		lblEscudo = new JLabel("Escudo");
		lblEscudo.setBounds(10, 11, 80, 71);
		panel_7.add(lblEscudo);
		
		lblNomeSelecao = new JLabel("lblNome");
		lblNomeSelecao.setBounds(92, 11, 148, 20);
		panel_7.add(lblNomeSelecao);
		lblNomeSelecao.setForeground(Color.BLACK);
		lblNomeSelecao.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblTecnico = new JLabel("lblTecnico");
		lblTecnico.setBounds(92, 38, 137, 20);
		panel_7.add(lblTecnico);
		lblTecnico.setForeground(Color.BLACK);
		lblTecnico.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 174, 247, 150);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblPrximaPartida = new JLabel("Próximo jogo -");
		lblPrximaPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrximaPartida.setBounds(10, 11, 100, 14);
		panel_6.add(lblPrximaPartida);
		
		lblEscudoAdversario = new JLabel("Escudo");
		lblEscudoAdversario.setBounds(10, 56, 80, 71);
		panel_6.add(lblEscudoAdversario);

		lblLocalPartida = new JLabel(" - - - - - ");
		lblLocalPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalPartida.setBounds(107, 11, 86, 14);
		panel_6.add(lblLocalPartida);
		
		lblRodada = new JLabel("");
		lblRodada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRodada.setBounds(10, 31, 137, 14);
		panel_6.add(lblRodada);
		
		lblNomeAdversario = new JLabel("lblNomeAdversario");
		lblNomeAdversario.setForeground(Color.BLACK);
		lblNomeAdversario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNomeAdversario.setBounds(92, 56, 137, 29);
		panel_6.add(lblNomeAdversario);
		
		lblNomeTecnicoAdversario = new JLabel("lblTecnico");
		lblNomeTecnicoAdversario.setForeground(Color.BLACK);
		lblNomeTecnicoAdversario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNomeTecnicoAdversario.setBounds(92, 84, 137, 20);
		panel_6.add(lblNomeTecnicoAdversario);
		
		JButton btnEscalar = new JButton("Escalar");
		btnEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmEscalarSelecao frmEscalarSelecao= new FrmEscalarSelecao( numeroRodadaAtual, getInstancia() );
				frmEscalarSelecao.setVisible(true);
			}
		});
		btnEscalar.setIcon(new ImageIcon(FrmPrincipal.class
				.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		btnEscalar.setBounds(130, 352, 127, 54);
		panel_3.add(btnEscalar);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carregarDadosRodadaAtual();
			}
		});
		btnNewButton.setBounds(11, 352, 106, 52);
		panel_3.add(btnNewButton);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(287, 11, 597, 417);
		pnlCentro.add(panel_4);
		
		jogadorTableModel = new JogadorTableModel();
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		JTable jTableJogador = new JTable(jogadorTableModel);
		formatarTabela(jTableJogador);	
		
		JScrollPane scrollPane = new JScrollPane(jTableJogador);
		jTableJogador.setFillsViewportHeight(true);
		
		panel_4.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.BLACK);
		getContentPane().add(panel_5, BorderLayout.SOUTH);
		lblBarraStatus = new JLabel(" . . . ");
		panel_5.add(lblBarraStatus);
		lblBarraStatus.setForeground(new Color(255, 255, 255));
		lblBarraStatus.setBackground(new Color(0, 128, 128));
		lblBarraStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
	}

	/**
	 * Realiza a formatacao das linhas e colunas da tabela de jogadores
	 * @param JTable jTableJogador
	 */
	private void formatarTabela(JTable jTableJogador) {
		jTableJogador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// "P", "Nome", "Nível", "Gols", "CA", "CV" 
		jTableJogador.getColumnModel().getColumn(0).setPreferredWidth(40);
		jTableJogador.getColumnModel().getColumn(1).setPreferredWidth(200);
		jTableJogador.getColumnModel().getColumn(2).setPreferredWidth(50);
		jTableJogador.getColumnModel().getColumn(3).setPreferredWidth(50);
		jTableJogador.getColumnModel().getColumn(4).setPreferredWidth(50);
	}

	protected void processarCarregamentoApp(boolean novoJogo) {
		/*
		 *  Carregar as informacoes do time e jogadores
		 */
		if ( novoJogo ) {
			carregarNovoJogo();	
			
		} else {
			carregarJogoExistente();	
		}
		
		// Carrega as informacoes do time gerenciado
		lblNomeSelecao.setText(FrmPrincipal.selecaoGerenciada.getNome());
		lblTecnico.setText(FrmPrincipal.selecaoGerenciada.getTecnico().getNome());
		
//		String strPathGerente = FrmPrincipal.class.getResource("").getPath();
		lblEscudo.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/imagens/escudos/"
						+ Biblioteca.removerAcentosEspacos(
								FrmPrincipal.selecaoGerenciada.getNome() +".png")) ));

		// Carrega a lista de jogadores do time
		List<Jogador> jogadores= Fachada.getInstance().listarJogadores(
				FrmPrincipal.selecaoGerenciada);
		
		// Adiciona os goleiros
		for (Jogador jogador : jogadores ) {
			if ( jogador.getPosicao().compareTo(Jogador.GOLEIRO) == 0 )
				jogadorTableModel.addJogador(jogador);
		}
		
		// Adiciona a defesa
		for (Jogador jogador : jogadores ) {
			if ( jogador.getPosicao().compareTo(Jogador.DEFESA) == 0 )
				jogadorTableModel.addJogador(jogador);
		}		
		
		// Adiciona o meioCampo
		for (Jogador jogador : jogadores ) {
			if ( jogador.getPosicao().compareTo(Jogador.MEIO_CAMPO) == 0 )
				jogadorTableModel.addJogador(jogador);
		}
		
		// Adiciona o ataque
		for (Jogador jogador : jogadores ) {
			if ( jogador.getPosicao().compareTo(Jogador.ATAQUE) == 0 )
				jogadorTableModel.addJogador(jogador);
		}		
		
		carregarDadosRodadaAtual();
		
	}

	public void carregarDadosRodadaAtual() {
		// Indetifica a rodada, a partida e o adversario
		boolean achei= false;
		for ( Rodada rodada : Fachada.getInstance().listarRodadas() ) {
			
			if ( !rodada.isFinalizada() ) { // a proxima rodada 
				numeroRodadaAtual= rodada.getNumero();
				
				System.out.println( rodada.getNumero() +" Rodada" );
				for (Partida partida : rodada.getPartidas() ) {
					
					System.out.println("Mandante "+ partida.getMandante().getSelecao());
					System.out.println("Visitante "+ partida.getVisitante().getSelecao());
					System.out.println("Gerenciado "+ FrmPrincipal.selecaoGerenciada);
					System.out.println();
					// Quando achar a partida do clube
					if ( partida.getMandante().getSelecao().getId() == FrmPrincipal.selecaoGerenciada.getId() ||
						 partida.getVisitante().getSelecao().getId() == FrmPrincipal.selecaoGerenciada.getId() ) {
						
						// Clube gerenciado e o mandante
						if ( partida.getMandante().getSelecao().getId() == 
								FrmPrincipal.selecaoGerenciada.getId() ) {
							
							lblNomeAdversario.setText( partida.getVisitante().getSelecao().getNome() );
							lblNomeTecnicoAdversario.setText(
									partida.getVisitante().getSelecao().getTecnico().getNome() );
							
//							String strPath = FrmPrincipal.class.getResource("").getPath();
//							lblEscudoAdversario.setIcon(new ImageIcon(strPath+ "escudos/" 
//									+ partida.getVisitante().getSelecao().getNome() +".gif"));
							lblEscudoAdversario.setIcon(new ImageIcon(
									FrmPrincipal.class.getResource("/imagens/escudos/"
										+ Biblioteca.removerAcentosEspacos(
												partida.getVisitante().getSelecao().getNome() ) 
										+".png")));							
					
						} else {
							lblNomeAdversario.setText( partida.getMandante().getSelecao().getNome() );
							lblNomeTecnicoAdversario.setText(
									partida.getMandante().getSelecao().getTecnico().getNome() );
							
//							String strPath = FrmPrincipal.class.getResource("").getPath();
//							lblEscudoAdversario.setIcon(new ImageIcon(strPath+ "escudos/" 
//									+ partida.getMandante().getSelecao().getNome() +".png"));
							lblEscudoAdversario.setIcon(new ImageIcon(
									FrmPrincipal.class.getResource("/imagens/escudos/"
											+ Biblioteca.removerAcentosEspacos(
													partida.getMandante().getSelecao().getNome() ) 
											+".png")));

						}

						lblRodada.setText( rodada.getNumero() +" Rodada" );
						lblLocalPartida.setText( "Em casa" );
						
						achei= true;
						// Sai do metodo
						break;
					}
				}
			}
			if ( achei ) { // Caso ja tenha achado a rodada atual
				break;
			}
		} // Fim for rodadas
	}

	public FrmPrincipal getInstancia() {
		return this;
	}
	
	/**
	 * Carrega as informacoes do time gerenciado e das rodadas para um novo jogo
	 */
	private void carregarNovoJogo() {
		// Realiza o sorteio do time que sera gerenciado
		//FootlineService.getInstance().inicializarJogo( footline );
	}
	
	/**
	 * Carrega as informacoes salvas de time gerenciado e suas rodadas
	 */
	private void carregarJogoExistente() {
//		try {
//			//footline= FootlineService.getInstance().carregar( footline.getNomeJogoSalvo() );
//			
//		} catch (ClassNotFoundException | IOException e) {
////			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cerregar o jogo "+
////												footline.getNomeJogoSalvo());
//			e.printStackTrace();
//		}
	}
}
