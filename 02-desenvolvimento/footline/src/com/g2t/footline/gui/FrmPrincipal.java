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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;

import org.apache.log4j.Logger;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.gui.componentes.JogadorTableModel;
import com.g2t.footline.gui.telasSecundarias.FrmArtilheiro;
import com.g2t.footline.gui.telasSecundarias.FrmCalendario;
import com.g2t.footline.gui.telasSecundarias.FrmEstadio;
import com.g2t.footline.gui.telasSecundarias.FrmSelecao;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Estadio;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Partida;
import com.g2t.footline.negocio.entidades.Rodada;
import com.g2t.footline.negocio.entidades.Selecao;
import com.g2t.footline.util.Biblioteca;
import com.g2t.footline.util.Constantes;

public class FrmPrincipal extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2575483770162322308L;
	
	public static Selecao selecaoGerenciada;
	public static Selecao selecaoCampea;
	public static boolean selecaoGerenciadaDesclassificada;
	
	private JLabel lblBarraStatus;
	private JogadorTableModel jogadorTableModel;
	private JTable jTableJogador;
	
	private JLabel lblEscudo;
	private JLabel lblNomeSelecao;
	private JLabel lblTecnico;
	
	private JLabel lblNomeAdversario;
	private JLabel lblNomeTecnicoAdversario;
	private JLabel lblRodada;
	private JLabel lblEscudoAdversario;
	private JLabel lblLocalPartida;
	private JLabel lblProximaPartida;
	private JButton btnEscalar;
	
	private Logger logger = Logger.getLogger( FrmPrincipal.class );
	
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
		
		setBounds(100, 100, 900, 531);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTopo = new JPanel();
		pnlTopo.setForeground(new Color(0, 100, 0));
		pnlTopo.setBackground(Color.BLACK);
		getContentPane().add(pnlTopo, BorderLayout.NORTH);
		pnlTopo.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlLogo = new JPanel();
		pnlLogo.setBackground(Color.BLACK);
		pnlTopo.add(pnlLogo, BorderLayout.WEST);
		
		JLabel lblLogo = new JLabel("  Footline - Rússia Copa 2018  ");
		lblLogo.setForeground(new Color(255, 255, 255));
		pnlLogo.add(lblLogo);
		lblLogo.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 26));
		
		JPanel pnlMenu = new JPanel();
		pnlMenu.setBackground(Color.BLACK);
		pnlTopo.add(pnlMenu, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setForeground(Color.WHITE);
		pnlMenu.add(toolBar);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		
		// --------------------------------------------------------
		// BOTOES MENU - INICIO
		// --------------------------------------------------------		
		JButton btnCalendario = new JButton("Calendário");
		btnCalendario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FrmCalendario frmCalendario= new FrmCalendario();
	                frmCalendario.setVisible(true);
					
				} catch (Exception e) {
					logger.error("Error ", e);
				}
			}
		});
		btnCalendario.setForeground(Color.WHITE);
		toolBar.add(btnCalendario);
		
		JLabel label_4 = new JLabel("     ");
		toolBar.add(label_4);
		
		JButton btnArtilheiro = new JButton("Artilheiros");
		btnArtilheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FrmArtilheiro frmArtilheiro= new FrmArtilheiro();
					frmArtilheiro.setVisible(true);
					
				} catch (Exception e) {
					logger.error("Error ", e);
				}
			}
		});
		btnArtilheiro.setForeground(Color.WHITE);
		toolBar.add(btnArtilheiro);
		
		JLabel label_5 = new JLabel("     ");
		toolBar.add(label_5);
		
		JButton btnSelecao = new JButton("Seleções");
		btnSelecao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FrmSelecao frmSelecao= new FrmSelecao();
					frmSelecao.setVisible(true);
					
				} catch (Exception e) {
					logger.error("Error ", e);
				}
			}
		});
		btnSelecao.setForeground(Color.WHITE);
		toolBar.add(btnSelecao);
		
		JLabel label_1 = new JLabel("     ");
		toolBar.add(label_1);
		
		JButton btnEstadio = new JButton("Estádio");
		btnEstadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FrmEstadio frmEstadio= new FrmEstadio();
					frmEstadio.setVisible(true);
					
				} catch (Exception e) {
					logger.error("Error ", e);
				}
			}
		});
		btnEstadio.setForeground(Color.WHITE);
		toolBar.add(btnEstadio);
		
		JPanel pnlSair = new JPanel();
		pnlSair.setBackground(Color.BLACK);
		pnlTopo.add(pnlSair, BorderLayout.EAST);
		
		JButton btnSair = new JButton("Sair");
		pnlSair.add(btnSair);
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
		
		JPanel pnlSelecoes = new JPanel();
		pnlSelecoes.setForeground(new Color(255, 255, 255));
		pnlSelecoes.setBackground(Color.BLACK);
		pnlSelecoes.setBorder(new CompoundBorder());
		pnlSelecoes.setBounds(10, 11, 316, 417);
		pnlCentro.add(pnlSelecoes);
		pnlSelecoes.setLayout(null);
		
		JPanel pnlSelecaoGerenciada = new JPanel();
		pnlSelecaoGerenciada.setBackground(Color.WHITE);
		pnlSelecaoGerenciada.setBounds(10, 11, 296, 104);
		pnlSelecoes.add(pnlSelecaoGerenciada);
		pnlSelecaoGerenciada.setLayout(null);
		
		lblEscudo = new JLabel("Escudo");
		lblEscudo.setBounds(10, 11, 80, 71);
		pnlSelecaoGerenciada.add(lblEscudo);
		
		lblNomeSelecao = new JLabel("lblNome");
		lblNomeSelecao.setBounds(92, 11, 194, 20);
		pnlSelecaoGerenciada.add(lblNomeSelecao);
		lblNomeSelecao.setForeground(Color.BLACK);
		lblNomeSelecao.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblTecnico = new JLabel("lblTecnico");
		lblTecnico.setBounds(92, 38, 194, 20);
		pnlSelecaoGerenciada.add(lblTecnico);
		lblTecnico.setForeground(Color.BLACK);
		lblTecnico.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JPanel pnlSelecaoAdversaria = new JPanel();
		pnlSelecaoAdversaria.setBackground(Color.WHITE);
		pnlSelecaoAdversaria.setBounds(10, 157, 296, 145);
		pnlSelecoes.add(pnlSelecaoAdversaria);
		pnlSelecaoAdversaria.setLayout(null);
		
		lblProximaPartida = new JLabel("Próximo jogo -");
		lblProximaPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProximaPartida.setBounds(10, 11, 100, 14);
		pnlSelecaoAdversaria.add(lblProximaPartida);
		
		lblEscudoAdversario = new JLabel("Escudo");
		lblEscudoAdversario.setBounds(10, 63, 80, 71);
		pnlSelecaoAdversaria.add(lblEscudoAdversario);

		lblLocalPartida = new JLabel(" - - - - - ");
		lblLocalPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalPartida.setBounds(107, 11, 179, 14);
		pnlSelecaoAdversaria.add(lblLocalPartida);
		
		lblRodada = new JLabel("");
		lblRodada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRodada.setBounds(10, 31, 276, 14);
		pnlSelecaoAdversaria.add(lblRodada);
		
		lblNomeAdversario = new JLabel("lblNomeAdversario");
		lblNomeAdversario.setForeground(Color.BLACK);
		lblNomeAdversario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNomeAdversario.setBounds(92, 61, 194, 29);
		pnlSelecaoAdversaria.add(lblNomeAdversario);
		
		lblNomeTecnicoAdversario = new JLabel("lblTecnico");
		lblNomeTecnicoAdversario.setForeground(Color.BLACK);
		lblNomeTecnicoAdversario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNomeTecnicoAdversario.setBounds(92, 101, 194, 20);
		pnlSelecaoAdversaria.add(lblNomeTecnicoAdversario);
		
		btnEscalar = new JButton("Escalar");
		btnEscalar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( FrmPrincipal.selecaoGerenciadaDesclassificada ) {
					
					FrmProcessarRodada frmProcessarRodada= 
							new FrmProcessarRodada( numeroRodadaAtual, getInstancia() );
					
					if ( FrmPrincipal.selecaoCampea != null ) { 
						FrmCampeao frmCampeao= new FrmCampeao();
						frmCampeao.setVisible(true);
					} else {
						frmProcessarRodada.setVisible(true);
					}
				} else {
					FrmEscalarSelecao frmEscalarSelecao= 
							new FrmEscalarSelecao( numeroRodadaAtual, getInstancia() );
					frmEscalarSelecao.setVisible(true);
				}			
			}
		});
		btnEscalar.setIcon(new ImageIcon(FrmPrincipal.class
				.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		btnEscalar.setBounds(10, 352, 296, 54);
		pnlSelecoes.add(btnEscalar);
		
		JPanel pnlJogadores = new JPanel();
		pnlJogadores.setBounds(336, 11, 548, 417);
		pnlCentro.add(pnlJogadores);
		
		jogadorTableModel = new JogadorTableModel();
		pnlJogadores.setLayout(new BoxLayout(pnlJogadores, BoxLayout.X_AXIS));
		jTableJogador = new JTable(jogadorTableModel);
		formatarTabela(jTableJogador);	
		
		JScrollPane scrollPane = new JScrollPane(jTableJogador);
		jTableJogador.setFillsViewportHeight(true);
		
		pnlJogadores.add(scrollPane);
		
		JPanel pnlBarraStatus = new JPanel();
		pnlBarraStatus.setBackground(Color.BLACK);
		getContentPane().add(pnlBarraStatus, BorderLayout.SOUTH);
		lblBarraStatus = new JLabel(" . . . ");
		pnlBarraStatus.add(lblBarraStatus);
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

	protected void processarCarregamentoApp() {
		
		// Carrega as informacoes do time gerenciado
		lblNomeSelecao.setText(FrmPrincipal.selecaoGerenciada.getNome());
		lblTecnico.setText(FrmPrincipal.selecaoGerenciada.getTecnico().getNome());
		lblEscudo.setIcon(new ImageIcon(
				FrmPrincipal.class.getResource("/imagens/escudos/"
						+ Biblioteca.removerAcentosEspacos(
								FrmPrincipal.selecaoGerenciada.getNome() +".png")) ));

		// Carrega a lista de jogadores do time
		List<Jogador> jogadores= Fachada.getInstance().listarJogadores(
				FrmPrincipal.selecaoGerenciada);
		
		jogadorTableModel.limpar();
		
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
		try { 
			// Indetifica a rodada, a partida e o adversario
			boolean achei= false;
			for ( Rodada rodada : Fachada.getInstance().listarRodadas() ) {
				
				if ( !rodada.isFinalizada() ) { // a proxima rodada 
					numeroRodadaAtual= rodada.getNumero();
					achei= true;
					
					for (Partida partida : rodada.getPartidas() ) {
						
						if (!FrmPrincipal.selecaoGerenciadaDesclassificada) {
							// Quando achar a partida do clube
							if ( partida.getMandante().getSelecao().getId() == FrmPrincipal.selecaoGerenciada.getId() ||
								 partida.getVisitante().getSelecao().getId() == FrmPrincipal.selecaoGerenciada.getId() ) {
								
								// Clube gerenciado e o mandante
								if ( partida.getMandante().getSelecao().getId() == 
										FrmPrincipal.selecaoGerenciada.getId() ) {
									
									lblNomeAdversario.setText( partida.getVisitante().getSelecao().getNome() );
									lblNomeTecnicoAdversario.setText(
											partida.getVisitante().getSelecao().getTecnico().getNome() );
									lblEscudoAdversario.setIcon(new ImageIcon(
											FrmPrincipal.class.getResource("/imagens/escudos/"
												+ Biblioteca.removerAcentosEspacos(
														partida.getVisitante().getSelecao().getNome() ) 
												+".png")));							
							
								} else {
									lblNomeAdversario.setText( partida.getMandante().getSelecao().getNome() );
									lblNomeTecnicoAdversario.setText(
											partida.getMandante().getSelecao().getTecnico().getNome() );
									lblEscudoAdversario.setIcon(new ImageIcon(
											FrmPrincipal.class.getResource("/imagens/escudos/"
													+ Biblioteca.removerAcentosEspacos(
															partida.getMandante().getSelecao().getNome() ) 
													+".png")));
								}
		
								if ( rodada.getNumero() < Constantes.RODADA_OITAVA_FINAL)
									lblRodada.setText( rodada.getNumero() +" Rodada - "
											+ rodada.getDescricao() );
								else 
									lblRodada.setText( rodada.getDescricao() );
								
								// Identifica o estadio
								Estadio estadio= Fachada.getInstance()
										.buscarEstadio( partida.getEstadio().getId() );
								
								lblLocalPartida.setText( estadio.getNome() );
								
								// Sai do for
								break;
							}	
						} 
					}
				}
				if ( achei ) { // Caso ja tenha achado a rodada atual
					if ( FrmPrincipal.selecaoGerenciadaDesclassificada ) {
						lblNomeAdversario.setText( " " );
						lblProximaPartida.setText(" ");
						lblNomeTecnicoAdversario.setText(" ");
						lblEscudoAdversario.setIcon(new ImageIcon(
								FrmPrincipal.class.getResource("/imagens/escudos/vazio.png")));	
						lblRodada.setText( rodada.getDescricao() );
						lblLocalPartida.setText( " " );		
						btnEscalar.setText("Processar rodada");
					}
					break;
				}
			} // Fim for rodadas
			
			if ( FrmPrincipal.selecaoGerenciadaDesclassificada ) {
//				btnEscalar.addActionListener(new ActionListener() {
//					public void actionPerformed(ActionEvent arg0) {
//						FrmProcessarRodada frmProcessarRodada= 
//								new FrmProcessarRodada( numeroRodadaAtual, getInstancia() );
//						frmProcessarRodada.setVisible(true);
//					}
//				});			
			}			
		} catch (RegistroNaoEncontradoException e) {
			logger.error(e.getMensagem());
		}
	}

	public FrmPrincipal getInstancia() {
		return this;
	}
}
