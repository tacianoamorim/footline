package com.g2t.footline.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
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
	DefaultListModel<String> modelo = new DefaultListModel<String>();
	private FrmOpcao frmOpcao;
	private JComboBox<Selecao> comboBox;

	/**
	 * Create the dialog.
	 */
	public FrmJogoNovo() {
		setTitle("Novo jogo");
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 496, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		
		// Cria e carrega a lista de selecoes
		comboBox = new JComboBox<Selecao>();
		comboBox.setBounds(130, 26, 327, 30);
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
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setForeground(new Color(0, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		                setVisible( false );
		                getFrmOpcao().setVisible( false );
		                
		                FrmPrincipal.selecaoGerenciada= 
		                		(Selecao) comboBox.getSelectedItem();
		                
		                FrmPrincipal frmPrincipal= new FrmPrincipal();
		                frmPrincipal.setVisible( true );
		                frmPrincipal.processarCarregamentoApp( true );
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Fechar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
	}

	public FrmOpcao getFrmOpcao() {
		return frmOpcao;
	}

	public void setFrmOpcao(FrmOpcao frmOpcao) {
		this.frmOpcao = frmOpcao;
	}
}
