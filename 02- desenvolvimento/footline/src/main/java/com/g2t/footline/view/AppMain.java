package com.g2t.footline.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Taciano
 */
public class AppMain extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6372065349465603650L;

	private javax.swing.JButton btnNovo;
	
	private Image img;

	/**
	 * Creates new form Principal
	 */
	public AppMain() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {
		// btnAtualizar = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Footline");

		JPanel panel = new JPanel();
		panel.setLayout(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(7)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(7)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		btnNovo = new javax.swing.JButton();
		btnNovo.setBounds(207, 65, 139, 29);
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovo.setIcon(null);

		btnNovo.setText("Novo jogo");
		btnNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNovoActionPerformed(evt);
			}
		});
		panel.add(btnNovo);
		
		JButton btnJogosSalvos = new JButton();
		btnJogosSalvos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnJogosSalvos.setText("Jogos salvos");
		btnJogosSalvos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnJogosSalvos.setBounds(207, 133, 139, 29);
		panel.add(btnJogosSalvos);
		
		JButton btnSobre = new JButton();
		btnSobre.setText("Sobre");
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSobre.setBounds(207, 199, 139, 29);
		panel.add(btnSobre);
		
		JButton btnSair = new JButton();
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				syste
			}
		});
		btnSair.setText("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(207, 267, 139, 29);
		panel.add(btnSair);
		getContentPane().setLayout(groupLayout);

		pack();
	}

	  
	private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {

	}
}
