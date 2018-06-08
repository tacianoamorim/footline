package com.g2t.footline.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;

import com.g2t.footline.entity.Clube;
import com.g2t.footline.entity.Footline;
import com.g2t.footline.entity.Jogador;
import com.g2t.footline.entity.Partida;
import com.g2t.footline.entity.Rodada;
import com.g2t.footline.service.FootlineService;
import com.g2t.footline.view.componentes.JogadorTableModel;
import com.g2t.footline.view.telasSecundarias.FrmCalendario;

public class FrmPrincipal extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2575483770162322308L;
	
	private Footline footline;
	private JLabel lblBarraStatus;
	private JogadorTableModel jogadorTableModel;
	
	private JLabel lblEscudo;
	private JLabel lblNomeClube;
	private JLabel lblEstadio;
	private JLabel lblTecnico;
	private JLabel lblCaixa; 
	
	private JLabel lblNomeAdversario;
	private JLabel lblRodada;
	private JLabel lblEscudoAdversario;
	private JLabel lblLocalPartida;
	
	
	/**
	 * Create the application.
	 */
	public FrmPrincipal() {
		setResizable(false);
		
		// Cria os objetos
		footline= new Footline();
		Clube clubeGerenciado= new Clube();
		footline.setClubeGerenciado( clubeGerenciado );
		
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
		pnlTopo.setBackground(new Color(34, 139, 34));
		getContentPane().add(pnlTopo, BorderLayout.NORTH);
		pnlTopo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		pnlTopo.add(panel, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel("  Footline      ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 26));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
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
                FrmCalendario frmCalendario= new FrmCalendario(footline);
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
					// Solicita o nome do jogo salvo
					String nomeArquivo= JOptionPane.showInputDialog(null, "Salvar com qual nome?", 
							"Salva jogo", JOptionPane.INFORMATION_MESSAGE);					
					
					FootlineService.getInstance().salvar(nomeArquivo, footline);
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
		
		JButton btnTime = new JButton("Times");
		btnTime.setForeground(Color.WHITE);
		toolBar.add(btnTime);
		
		JLabel label_1 = new JLabel("     ");
		toolBar.add(label_1);
		
		JButton btnEstadio = new JButton("Estádio");
		btnEstadio.setForeground(Color.WHITE);
		toolBar.add(btnEstadio);
		
		JLabel label = new JLabel("     ");
		toolBar.add(label);
		
		JButton btnFinanca = new JButton("Finanças");
		btnFinanca.setForeground(Color.WHITE);
		toolBar.add(btnFinanca);
		
		JLabel lblEspacos1 = new JLabel("     ");
		toolBar.add(lblEspacos1);
		toolBar.add(btnSalvar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
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
		panel_3.setBackground(new Color(0, 128, 128));
		panel_3.setBorder(new CompoundBorder());
		panel_3.setBounds(10, 11, 267, 417);
		pnlCentro.add(panel_3);
		panel_3.setLayout(null);
		
		lblEscudo = new JLabel("Escudo");
		lblEscudo.setBounds(10, 11, 80, 71);
		panel_3.add(lblEscudo);
		
		lblNomeClube = new JLabel("lblNome");
		lblNomeClube.setForeground(new Color(255, 255, 255));
		lblNomeClube.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNomeClube.setBounds(97, 11, 160, 29);
		panel_3.add(lblNomeClube);
		
		lblEstadio = new JLabel("lblEstadio");
		lblEstadio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblEstadio.setForeground(new Color(255, 255, 255));
		lblEstadio.setBounds(100, 63, 160, 14);
		panel_3.add(lblEstadio);
		
		JLabel lblConfianca = new JLabel("Confiança");
		lblConfianca.setForeground(new Color(255, 255, 255));
		lblConfianca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblConfianca.setBounds(10, 117, 91, 14);
		panel_3.add(lblConfianca);
		
		JProgressBar pBarConfianca = new JProgressBar();
		pBarConfianca.setForeground(Color.BLUE);
		pBarConfianca.setValue(90);
		pBarConfianca.setBounds(10, 135, 247, 22);
		panel_3.add(pBarConfianca);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 266, 247, 140);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblPrximaPartida = new JLabel("Próximo jogo -");
		lblPrximaPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrximaPartida.setBounds(10, 11, 100, 14);
		panel_6.add(lblPrximaPartida);
		
		lblEscudoAdversario = new JLabel("Escudo");
		lblEscudoAdversario.setBounds(10, 56, 80, 71);
		panel_6.add(lblEscudoAdversario);

		lblLocalPartida = new JLabel("Em casa");
		lblLocalPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalPartida.setBounds(107, 11, 86, 14);
		panel_6.add(lblLocalPartida);
		
		lblRodada = new JLabel("");
		lblRodada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRodada.setBounds(10, 31, 137, 14);
		panel_6.add(lblRodada);
		
		lblNomeAdversario = new JLabel("");
		lblNomeAdversario.setForeground(Color.BLACK);
		lblNomeAdversario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNomeAdversario.setBounds(100, 73, 137, 29);
		panel_6.add(lblNomeAdversario);
		
		lblCaixa = new JLabel("Caixa: R$ 3.000.000,00");
		lblCaixa.setForeground(Color.WHITE);
		lblCaixa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCaixa.setBounds(20, 168, 237, 14);
		panel_3.add(lblCaixa);
		
		lblTecnico = new JLabel("");
		lblTecnico.setForeground(Color.WHITE);
		lblTecnico.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTecnico.setBounds(100, 38, 160, 14);
		panel_3.add(lblTecnico);
		
		JButton btnEscalar = new JButton("Escalar");
		btnEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                FrmEscalarTime frmEscalarTime= new FrmEscalarTime(footline);
                frmEscalarTime.setVisible(true);
			}
		});
		btnEscalar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		btnEscalar.setBounds(11, 198, 115, 54);
		panel_3.add(btnEscalar);
		
		JButton btnDesafiar = new JButton("Desafiar");
		btnDesafiar.setToolTipText("Desafiar um time gerenciado por outra pessoa");
		btnDesafiar.setIcon(new ImageIcon(FrmPrincipal.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		btnDesafiar.setBounds(141, 199, 115, 54);
		panel_3.add(btnDesafiar);
		
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
		panel_5.setBackground(new Color(0, 128, 128));
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
		// "P", "Nome", "Nível", "Salário", "Passe", "Gols", "CA", "CV" 
		jTableJogador.getColumnModel().getColumn(0).setPreferredWidth(30);
		jTableJogador.getColumnModel().getColumn(1).setPreferredWidth(180);
		jTableJogador.getColumnModel().getColumn(2).setPreferredWidth(40);
		jTableJogador.getColumnModel().getColumn(3).setPreferredWidth(100);
		jTableJogador.getColumnModel().getColumn(4).setPreferredWidth(120);
		jTableJogador.getColumnModel().getColumn(5).setPreferredWidth(40);
		jTableJogador.getColumnModel().getColumn(6).setPreferredWidth(40);
		jTableJogador.getColumnModel().getColumn(7).setPreferredWidth(40);
	}

	public Footline getFootline() {
		return footline;
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
		lblNomeClube.setText(footline.getClubeGerenciado().getNome());
		lblEstadio.setText(footline.getClubeGerenciado().getNomeEstadio());
		lblTecnico.setText(footline.getClubeGerenciado().getTecnico());
		
		String strPathGerente = FrmPrincipal.class.getResource("").getPath();
		lblEscudo.setIcon(new ImageIcon(strPathGerente+ "escudos/" 
					+ footline.getClubeGerenciado().getNomeArquivo() +".gif"));

		// Adiciona os goleiros
		for (Jogador jogador : footline.getClubeGerenciado().getListaGoleiro()) {
			jogadorTableModel.addJogador(jogador);
		}
		
		// Adiciona a defesa
		for (Jogador jogador : footline.getClubeGerenciado().getListaDefesa()) {
			jogadorTableModel.addJogador(jogador);
		}		
		
		// Adiciona o meioCampo
		for (Jogador jogador : footline.getClubeGerenciado().getListaMeioCampo()) {
			jogadorTableModel.addJogador(jogador);
		}				
		
		// Adiciona o ataque
		for (Jogador jogador : footline.getClubeGerenciado().getListaAtaque()) {
			jogadorTableModel.addJogador(jogador);
		}		
		
		// Indetifica a rodada, a partida e o adversario
		boolean achei= false;
		for ( Rodada rodada : footline.getRodadas() ) {
			
			if ( !rodada.isFinalizada() ) { // a proxima rodada 
				
				System.out.println( rodada.getNumero() +" Rodada" );
				for (Partida partida : rodada.getPartidas() ) {
					
					System.out.println("Mandante "+ partida.getMandante().getClube());
					System.out.println("Visitante "+ partida.getVisitante().getClube());
					System.out.println("Gerenciado "+ footline.getClubeGerenciado());
					System.out.println();
					// Quando achar a partida do clube
					if ( partida.getMandante().getClube().getId() == footline.getClubeGerenciado().getId() ||
						 partida.getVisitante().getClube().getId() == footline.getClubeGerenciado().getId() ) {
						
						// Clube gerenciado e o mandante
						if ( partida.getMandante().getClube().getId() == 
								footline.getClubeGerenciado().getId() ) {
							
							lblNomeAdversario.setText( partida.getVisitante().getClube().getNome() );
							lblLocalPartida.setText( "Em casa" );
							
							String strPath = FrmPrincipal.class.getResource("").getPath();
							lblEscudoAdversario.setIcon(new ImageIcon(strPath+ "escudos/" 
									+ partida.getVisitante().getClube().getNomeArquivo() +".gif"));
					
						} else {
							lblNomeAdversario.setText( partida.getMandante().getClube().getNome() );
							lblLocalPartida.setText( "Fora" );
							
							String strPath = FrmPrincipal.class.getResource("").getPath();
							lblEscudoAdversario.setIcon(new ImageIcon(strPath+ "escudos/" 
									+ partida.getMandante().getClube().getNomeArquivo() +".gif"));
						}

						lblRodada.setText( rodada.getNumero() +" Rodada" );
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

	/**
	 * Carrega as informacoes do time gerenciado e das rodadas para um novo jogo
	 */
	private void carregarNovoJogo() {
		// Realiza o sorteio do time que sera gerenciado
		FootlineService.getInstance().inicializarJogo( footline );
		
	}
	
	/**
	 * Carrega as informacoes salvas de time gerenciado e suas rodadas
	 */
	private void carregarJogoExistente() {
		try {
			footline= FootlineService.getInstance().carregar( footline.getNomeJogoSalvo() );
			
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao cerregar o jogo "+
												footline.getNomeJogoSalvo());
			e.printStackTrace();
		}
	}
}
