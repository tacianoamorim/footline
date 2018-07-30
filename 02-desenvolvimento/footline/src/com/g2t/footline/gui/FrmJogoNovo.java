package com.g2t.footline.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.g2t.footline.negocio.Fachada;
import com.g2t.footline.negocio.entidades.Selecao;

public class FrmJogoNovo extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7085709480620475219L;
	
	private final JPanel contentPanel = new JPanel();
	private FrmOpcao frmOpcao;
	private JComboBox<Selecao> comboBox;

	/**
	 * Create the dialog.
	 */
	public FrmJogoNovo() {
		setUndecorated(true);
		setTitle("Novo jogo");
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setForeground(Color.BLACK);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 496, 158);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 37, 496, 69);
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		
		// Cria e carrega a lista de selecoes
		comboBox = new JComboBox<Selecao>();
		comboBox.setBounds(130, 26, 345, 30);
		contentPanel.add(comboBox);
		List<Selecao> selecoes= Fachada.getInstance().listarSelecoes();
		for (Selecao selecao : selecoes) {
			comboBox.addItem(selecao);
		}
		
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Escolha uma seleção");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(10, 38, 124, 14);
			contentPanel.add(lblNewLabel);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 114, 476, 33);
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setForeground(new Color(0, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		                setVisible( false );
		                getFrmOpcao().setVisible( false );
		                
		                FrmPrincipal.selecaoGerenciada= 
		                		(Selecao) comboBox.getSelectedItem();
		                
		                FrmPrincipal frmPrincipal= new FrmPrincipal();
		                frmPrincipal.setVisible( true );
		                frmPrincipal.processarCarregamentoApp( );
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				JButton btnFechar = new JButton("Fechar");
				btnFechar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnFechar.setActionCommand("Cancel");
				buttonPane.add(btnFechar);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 11, 496, 33);
		getContentPane().add(panel);
		
		JLabel lblNovoJogo = new JLabel("Novo jogo");
		lblNovoJogo.setForeground(Color.WHITE);
		lblNovoJogo.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 20));
		panel.add(lblNovoJogo);
		
	}

	public FrmOpcao getFrmOpcao() {
		return frmOpcao;
	}

	public void setFrmOpcao(FrmOpcao frmOpcao) {
		this.frmOpcao = frmOpcao;
	}
}
