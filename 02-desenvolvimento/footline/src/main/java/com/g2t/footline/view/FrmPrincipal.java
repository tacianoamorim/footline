package com.g2t.footline.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import com.g2t.footline.entity.Jogador;
import com.g2t.footline.entity.Jogo;
import com.g2t.footline.service.JogoService;
import com.g2t.footline.view.componentes.JogadorTableModel;

public class FrmPrincipal extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2575483770162322308L;
	
	private Jogo jogo;
	private Clube clubeGerenciado;
	private JLabel lblBarraStatus;
	private JogadorTableModel jogadorTableModel;
	private boolean novoJogo;
	
	private JLabel lblEscudo;
	private JLabel lblNomeClube;
	private JLabel lblEstadio;
	private JLabel lblTecnico;
	private JLabel lblCaixa; 
	
	/**
	 * Create the application.
	 */
	public FrmPrincipal() {
		setResizable(false);
		
		// Cria os objetos
		jogo= new Jogo();
		clubeGerenciado= new Clube();
		jogo.setClubeGerenciado( clubeGerenciado );
		
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
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 23));
		
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
					
					JogoService.getInstance().salvar(nomeArquivo, jogo);
					JOptionPane.showMessageDialog(null, "Jogo salvo!", "Salvar Jogo", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					
					// TODO: handle exception
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
		
		JButton btnCampeao = new JButton("Campeões");
		btnCampeao.setForeground(Color.WHITE);
		toolBar.add(btnCampeao);
		
		JLabel label_2 = new JLabel("     ");
		toolBar.add(label_2);
		
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
		
		JLabel lblEscudoAdversario = new JLabel("Escudo");
		lblEscudoAdversario.setBounds(10, 58, 80, 71);
		panel_6.add(lblEscudoAdversario);
		
		JLabel lblLocalPartida = new JLabel("Em casa");
		lblLocalPartida.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocalPartida.setBounds(107, 11, 86, 14);
		panel_6.add(lblLocalPartida);
		
		JLabel lblRodada = new JLabel("5 Rodada");
		lblRodada.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRodada.setBounds(10, 31, 137, 14);
		panel_6.add(lblRodada);
		
		JLabel label_6 = new JLabel("");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_6.setBounds(100, 73, 137, 29);
		panel_6.add(label_6);
		
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(287, 11, 597, 417);
		pnlCentro.add(panel_4);
		
		jogadorTableModel = new JogadorTableModel();
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		JTable jTableJogador = new JTable(jogadorTableModel);

//		jTableJogador.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// "P", "Nome", "Nível", "Salário", "Passe", "Gols", "CA", "CV" 
		jTableJogador.getColumnModel().getColumn(0).setWidth(1);
		jTableJogador.getColumnModel().getColumn(1).setWidth(30);
		jTableJogador.getColumnModel().getColumn(2).setWidth(5);
		jTableJogador.getColumnModel().getColumn(3).setWidth(20);
		jTableJogador.getColumnModel().getColumn(4).setWidth(20);
		jTableJogador.getColumnModel().getColumn(5).setWidth(10);
		jTableJogador.getColumnModel().getColumn(6).setWidth(10);
		jTableJogador.getColumnModel().getColumn(7).setWidth(10);		
		
		
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

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
	public Jogo getJogo() {
		return jogo;
	}

	public void setClubeGerenciado(Clube clubeGerenciado) {
		this.clubeGerenciado = clubeGerenciado;
	}

	public void setNovoJogo(boolean novoJogo) {
		this.novoJogo = novoJogo;
	}
	
	protected void exibirDados() {
		// Carrega os dados do jogo
		if ( novoJogo ) {
			JogoService.getInstance().inicializarJogo( jogo );
			
			lblNomeClube.setText(jogo.getClubeGerenciado().getNome());
			lblEstadio.setText(jogo.getClubeGerenciado().getNomeEstadio());
			lblTecnico.setText(jogo.getClubeGerenciado().getTecnico());
			
			String strPath = FrmPrincipal.class.getResource("").getPath();
			lblEscudo.setIcon(new ImageIcon(strPath+ "escudos/" + jogo.getClubeGerenciado().getNomeArquivo() +".gif"));

			for (Jogador jogador : jogo.getClubeGerenciado().getGoleiro()) {
				jogadorTableModel.addJogador(jogador);
			}
			
			
		} else {
			
		}
		
	}
}
