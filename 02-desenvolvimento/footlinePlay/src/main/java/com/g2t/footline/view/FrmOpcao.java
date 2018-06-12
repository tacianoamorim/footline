package com.g2t.footline.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Taciano
 */
public class FrmOpcao extends javax.swing.JFrame {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6372065349465603650L;

	/**
	 * Creates new form Principal
	 */
	public FrmOpcao() {
		getContentPane().setBackground(new Color(0, 128, 128));
		setBackground(new Color(0, 128, 128));
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
		panel.setBackground(new Color(0, 128, 128));
		panel.setLayout(null);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 586, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JButton btnNovo = new JButton();
		btnNovo = new javax.swing.JButton();
		btnNovo.setBounds(429, 11, 147, 90);
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNovo.setIcon(new ImageIcon(FrmOpcao.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		btnNovo.setText("Novo jogo");
		btnNovo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				FrmJogoNovo app= new FrmJogoNovo();
				app.setFrmOpcao( getFrmOpcao() );
                app.setVisible(true);				
			}
		});
		panel.add(btnNovo);
		
		JButton btnJogosSalvos = new JButton();
		btnJogosSalvos.setIcon(new ImageIcon(FrmOpcao.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		btnJogosSalvos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmJogosSalvos app= new FrmJogosSalvos();
				app.setFrmOpcao( getFrmOpcao() );
                app.setVisible(true);
			}
		});
		btnJogosSalvos.setText("Jogos salvos");
		btnJogosSalvos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnJogosSalvos.setBounds(429, 112, 147, 90);
		panel.add(btnJogosSalvos);
		
		JButton btnSobre = new JButton();
		btnSobre.setIcon(new ImageIcon(FrmOpcao.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmSobre frmSobre= new FrmSobre();
				frmSobre.setVisible(true);
			}
		});
		btnSobre.setText("Sobre");
		btnSobre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSobre.setBounds(429, 213, 147, 90);
		panel.add(btnSobre);
		
		JButton btnSair = new JButton();
		btnSair.setIcon(new ImageIcon(FrmOpcao.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setText("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(429, 314, 147, 90);
		panel.add(btnSair);
		
		JLabel lblFootline = new JLabel("Footline");
		lblFootline.setForeground(Color.WHITE);
		lblFootline.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 60));
		lblFootline.setBounds(10, 6, 274, 65);
		panel.add(lblFootline);
		
		JLabel lblImgArruda = new JLabel("");
		String strPath = FrmPrincipal.class.getResource("").getPath();
		lblImgArruda.setIcon(new ImageIcon(strPath+ "arruda.jpg"));
		
		//lblImgArruda.setIcon(new ImageIcon(FrmOpcao.class.getResource("/javax/swing/plaf/basic/icons/JavaCup16.png")));
		lblImgArruda.setBounds(0, 11, 586, 427);
		panel.add(lblImgArruda);
		getContentPane().setLayout(groupLayout);

		pack();
	}

	FrmOpcao getFrmOpcao() {
		return this;
	}
}