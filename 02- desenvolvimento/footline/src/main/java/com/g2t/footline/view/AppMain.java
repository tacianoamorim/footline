package com.g2t.footline.view;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

/**
 * @author Taciano
 */
public class AppMain extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6372065349465603650L;

	private javax.swing.JButton btnNovo;

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
		btnNovo.setBounds(214, 67, 107, 29);
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovo.setIcon(null);

		btnNovo.setText("Novo jogo");
		btnNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnNovoActionPerformed(evt);
			}
		});
		panel.add(btnNovo);
		getContentPane().setLayout(groupLayout);

		pack();
	}

	private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {

	}
}
