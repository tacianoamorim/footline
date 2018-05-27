package com.g2t.footline.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrmJogoNovo extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7085709480620475219L;
	
	private final JPanel contentPanel = new JPanel();
	DefaultListModel<String> modelo = new DefaultListModel<String>();
	private FrmOpcao frmOpcao;
	private JTextField txtNomeTecnico;

	/**
	 * Create the dialog.
	 */
	public FrmJogoNovo() {
		setTitle("Novo jogo");
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 410, 167);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nome do técnico");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(10, 38, 106, 14);
			contentPanel.add(lblNewLabel);
		}
		
		txtNomeTecnico = new JTextField();
		txtNomeTecnico.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtNomeTecnico.setBounds(119, 33, 265, 27);
		contentPanel.add(txtNomeTecnico);
		txtNomeTecnico.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 128, 128));
			buttonPane.setForeground(new Color(0, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				
						// Valida se o nome foi prenchido
						if (  txtNomeTecnico.getText() == null || txtNomeTecnico.getText().trim().length() == 0 ) {
							JOptionPane.showMessageDialog(null, "Informe o nome do técnico.");
							
						} else {
			                FrmPrincipal frmPrincipal= new FrmPrincipal();
			                setVisible( false );
			                
			                getFrmOpcao().setVisible( false );
			                
			                frmPrincipal.setVisible( true );
			                frmPrincipal.getFootline().setUsuario( txtNomeTecnico.getText() );
			                frmPrincipal.processarCarregamentoApp( true );
						}

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
