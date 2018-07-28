package com.g2t.footline.gui.telasSecundarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import com.g2t.footline.exception.RegistroNaoEncontradoException;
import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Jogador;
import com.g2t.footline.negocio.entidades.Selecao;

public class FrmSelecao extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3835487868126017777L;
	
	private final JPanel contentPanel = new JPanel();
	private Logger logger = Logger.getLogger( FrmSelecao.class );	
	private DefaultListModel<String> modeloJogador;
	private JList<String> listJogadores;

	/**
	 * Create the frame.
	 */
	public FrmSelecao() {
		setUndecorated(true);
		setTitle("Calendário");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 623, 471);
		getContentPane().setLayout(null);
		
		JPanel pnlNome = new JPanel();
		pnlNome.setBounds(0, 0, 623, 33);
		getContentPane().add(pnlNome);
		pnlNome.setBackground(Color.BLACK);
		
		JLabel lblNome = new JLabel("Seleções");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
		pnlNome.add(lblNome);
		contentPanel.setBounds(10, 36, 606, 385);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel pnlNomeSelecao = new JPanel();
		pnlNomeSelecao.setBounds(5, 5, 178, 390);
		pnlNomeSelecao.setBackground(Color.WHITE);
		contentPanel.add(pnlNomeSelecao);
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JList<String> listSelecoes =  new JList<String>(modelo);
		JScrollPane spnSelecoes = new JScrollPane(listSelecoes);
		modeloJogador = new DefaultListModel<String>();
		listSelecoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String selecaoSelecionado= listSelecoes.getSelectedValue();
				try {
					modeloJogador.removeAllElements();
					// trata nome para recuperar arquivo
					if ( selecaoSelecionado != null && selecaoSelecionado.length() > 0 ) {
						List<Jogador> jogadores;
							jogadores = Fachada.getInstance().listarJogadorPorSelecao( selecaoSelecionado );
						for (Jogador jogador : jogadores) {
							String texto= "  - ("+ jogador.getPosicao() +") "+ jogador.getNome() + 
									"  ["+ jogador.getNivel() +"]";
							modeloJogador.addElement( texto );
						}
						modeloJogador.addElement( " " );
					}
				} catch (RegistroNaoEncontradoException e) {
					logger.error( e.getMensagem() );
				}
			}
		});
		listSelecoes.setVisibleRowCount(10);
		pnlNomeSelecao.setLayout(new BorderLayout(0, 0));
		pnlNomeSelecao.add(spnSelecoes);
		
		JPanel pnlJogadores = new JPanel();
		pnlJogadores.setBackground(Color.WHITE);
		pnlJogadores.setBounds(193, 5, 410, 390);
		contentPanel.add(pnlJogadores);
		pnlJogadores.setLayout(new BorderLayout(0, 0));
		{
			JPanel pnlBotao = new JPanel();
			pnlBotao.setBounds(20, 427, 596, 33);
			pnlBotao.setBackground(Color.BLACK);
			pnlBotao.setForeground(Color.BLACK);
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
		
		listJogadores =  new JList<String>(modeloJogador);
		JScrollPane spnJogadores = new JScrollPane(listJogadores);
		listJogadores.setVisibleRowCount(10);
		pnlJogadores.setLayout(new BorderLayout(0, 0));
		pnlJogadores.add(spnJogadores);		
		
		try {
			// Carregar a lista
			List<Selecao> selecoes= Fachada.getInstance().listarSelecoes();
			int idx= 0;
			String selecaoInicial="";
			for (Selecao selecao : selecoes) {
				modelo.addElement( selecao.getNome() );
				if ( idx == 0 ) {
					selecaoInicial= selecao.getNome();
					idx++;
				}
			}	
			modelo.addElement( " " );
			listSelecoes.setSelectedIndex(0);
			
			List<Jogador> jogadores = Fachada.getInstance().listarJogadorPorSelecao( selecaoInicial );
			for (Jogador jogador : jogadores) {
				String texto= "  - ("+ jogador.getPosicao() +") "+ jogador.getNome()+ 
						"  ["+ jogador.getNivel() +"]";
				modeloJogador.addElement( texto );
			}
			modeloJogador.addElement( " " );
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
	}
}
