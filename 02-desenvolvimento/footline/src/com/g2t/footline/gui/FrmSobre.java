package com.g2t.footline.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class FrmSobre extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4538290643035216092L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmSobre dialog = new FrmSobre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmSobre() {
		setResizable(false);
		setModal(true);
		setTitle("Sobre o footline");
		setBounds(100, 100, 333, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.BLACK);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Versão 1.0.0");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
			lblNewLabel_1.setForeground(new Color(255, 255, 255));
			lblNewLabel_1.setBounds(203, 69, 86, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("Footline");
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel.setForeground(new Color(255, 255, 255));
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Ink Free", Font.BOLD | Font.ITALIC, 60));
			lblNewLabel.setBounds(10, 0, 307, 95);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel label = new JLabel("- Gustavo Tabosa");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Source Sans Pro Semibold", Font.BOLD | Font.ITALIC, 13));
		label.setBounds(20, 120, 166, 23);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("- Taciano Amorim");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Source Sans Pro Semibold", Font.BOLD | Font.ITALIC, 13));
		label_1.setBounds(20, 141, 166, 23);
		contentPanel.add(label_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
