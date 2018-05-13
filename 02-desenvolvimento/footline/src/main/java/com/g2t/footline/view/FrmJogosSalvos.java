package com.g2t.footline.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.g2t.footline.service.JogoService;

public class FrmJogosSalvos extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7085709480620475219L;
	
	private final JPanel contentPanel = new JPanel();
	private JList<String> listJogos;
	DefaultListModel<String> modelo = new DefaultListModel<String>();
	private FrmOpcao frmOpcao;

	/**
	 * Create the dialog.
	 */
	public FrmJogosSalvos() {
		setTitle("Carregar jogos salvos");
		getContentPane().setBackground(new Color(0, 128, 128));
		getContentPane().setForeground(new Color(0, 128, 128));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 434, 342);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 128, 128));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		listJogos =  new JList<String>(modelo);
		listJogos.setVisibleRowCount(10);
		
		panel.add(listJogos, BorderLayout.NORTH);
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
		                FrmPrincipal frmPrincipal= new FrmPrincipal();
		                frmPrincipal.setNovoJogo(false);
		                frmPrincipal.getJogo().setUsuario(listJogos.getSelectedValue());
		                setVisible(false);
		                getFrmOpcao().setVisible(false);
		                frmPrincipal.setVisible(true);
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
		
		carregarJogosSalvos();
	}
	
	private void carregarJogosSalvos() {
		try {
			List<String> arquivos= JogoService.getInstance().listaArquivos();
			for (String nomeArquivo : arquivos) {
				modelo.addElement(nomeArquivo);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public FrmOpcao getFrmOpcao() {
		return frmOpcao;
	}

	public void setFrmOpcao(FrmOpcao frmOpcao) {
		this.frmOpcao = frmOpcao;
	}
	
}
