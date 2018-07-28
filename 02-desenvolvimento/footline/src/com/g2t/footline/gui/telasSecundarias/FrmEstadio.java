package com.g2t.footline.gui.telasSecundarias;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Estadio;
import com.g2t.footline.util.Biblioteca;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class FrmEstadio extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3835487868126017777L;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblImgEstadio;

	/**
	 * Create the frame.
	 */
	public FrmEstadio() {
		setUndecorated(true);
		setTitle("Calendário");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 623, 471);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 623, 33);
		getContentPane().add(panel);
		panel.setBackground(Color.BLACK);
		
		JLabel lblEstdios = new JLabel("Estádios");
		lblEstdios.setForeground(Color.WHITE);
		lblEstdios.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblEstdios);
		contentPanel.setBounds(10, 36, 606, 385);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel pnlNomeEstadio = new JPanel();
		pnlNomeEstadio.setBounds(5, 5, 178, 390);
		pnlNomeEstadio.setBackground(Color.WHITE);
		contentPanel.add(pnlNomeEstadio);
		
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JList<String> listEstadios =  new JList<String>(modelo);
		listEstadios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String estadioSelecionado= listEstadios.getSelectedValue();

				// trata nome para recuperar arquivo
				if ( estadioSelecionado != null && estadioSelecionado.length() > 0 ) {
					estadioSelecionado= Biblioteca.removerAcentosEspacos( estadioSelecionado );
					lblImgEstadio.setIcon(new ImageIcon(
							FrmEstadio.class.getResource("/imagens/estadios/"+estadioSelecionado+".png")));
				}
			}
		});
		listEstadios.setVisibleRowCount(10);
		
		JScrollPane scrollPane = new JScrollPane(listEstadios);
		
		// Carregar a lista
		List<Estadio> estadios= Fachada.getInstance().listarEstadio();
		String nomeEstadio= null;
		for (Estadio estadio : estadios) {
			modelo.addElement( estadio.getNome() );
			// Pega o primeiro nome para exibir no painel de imagem
			if (nomeEstadio == null) {
				nomeEstadio= Biblioteca.removerAcentosEspacos( estadio.getNome() );
				listEstadios.setSelectedIndex(0);
			}
		}
		pnlNomeEstadio.setLayout(new BorderLayout(0, 0));
		pnlNomeEstadio.add(scrollPane);
		
		JPanel pnlFoto = new JPanel();
		pnlFoto.setBackground(Color.WHITE);
		pnlFoto.setBounds(193, 5, 410, 390);
		contentPanel.add(pnlFoto);
		pnlFoto.setLayout(new BorderLayout(0, 0));
		
		lblImgEstadio = new JLabel("");
		lblImgEstadio.setIcon(new ImageIcon(FrmEstadio.class.getResource("/imagens/estadios/"+nomeEstadio+".png")));
		pnlFoto.add(lblImgEstadio);
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
		
	}
}
