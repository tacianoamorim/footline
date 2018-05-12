package com.g2t.footline.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

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

import com.g2t.footline.entity.Jogo;
import com.g2t.footline.service.JogoService;
import com.g2t.footline.view.componentes.JogadorTableModel;

public class FrmPrincipal extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2575483770162322308L;
	
	private Jogo jogo;
	private final JLabel lblBarraStatus = new JLabel("Barra de status ...");
	
	/**
	 * Create the application.
	 */
	public FrmPrincipal() {
		setResizable(false);
		jogo= new Jogo();
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
		panel_1.add(toolBar);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		
		JButton btnCalendario = new JButton("Calendário");
		toolBar.add(btnCalendario);
		
		JLabel label_4 = new JLabel("     ");
		toolBar.add(label_4);
		
		JButton btnClassificacao = new JButton("Classificação");
		toolBar.add(btnClassificacao);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String nomeArquivo = getJogo().getUsuario();
				try {
					jogo.setUsuario(nomeArquivo);
					
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
		toolBar.add(btnArtilheiro);
		
		JLabel label_5 = new JLabel("     ");
		toolBar.add(label_5);
		
		JButton btnCampeao = new JButton("Campeões");
		toolBar.add(btnCampeao);
		
		JLabel label_2 = new JLabel("     ");
		toolBar.add(label_2);
		
		JButton btnTime = new JButton("Times");
		toolBar.add(btnTime);
		
		JLabel label_1 = new JLabel("     ");
		toolBar.add(label_1);
		
		JButton btnEstadio = new JButton("Estádio");
		toolBar.add(btnEstadio);
		
		JLabel label = new JLabel("     ");
		toolBar.add(label);
		
		JButton btnFinanca = new JButton("Finanças");
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
		
		JLabel lblEscudo = new JLabel("Escudo");
//		String strPath = System.getProperty("user.dir");
		String strPath = FrmPrincipal.class.getResource("").getPath();
		ImageIcon icon = new ImageIcon(strPath+ "escudos/afogados.gif");
										//C:\\fabrica\\workspace\\footline6\\02- desenvolvimento\\footline\\target\\classes\\
		//ImageIcon icon = new ImageIcon("/C:/fabrica/workspace/footline6/02- desenvolvimento/footline/target/classes/arruda.jpg");
		//ImageIcon icon = new ImageIcon("/C:/fabrica/workspace/footline6/02- desenvolvimento/footline/target/classes/arruda.jpg");
		icon.getImage().getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);
		lblEscudo.setIcon(icon);    
		lblEscudo.setBounds(10, 11, 80, 71);
		panel_3.add(lblEscudo);
		
		JLabel lblNomeAgremiacao = new JLabel("Santa Cruz");
		lblNomeAgremiacao.setForeground(new Color(255, 255, 255));
		lblNomeAgremiacao.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNomeAgremiacao.setBounds(97, 11, 160, 29);
		panel_3.add(lblNomeAgremiacao);
		
		JLabel lblNewLabel_1 = new JLabel("Confiaça");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 117, 66, 14);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(287, 11, 587, 417);
		pnlCentro.add(panel_4);
		
		JogadorTableModel jogadorTableModel = new JogadorTableModel();
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
		lblBarraStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		getContentPane().add(lblBarraStatus, BorderLayout.SOUTH);
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}
}
