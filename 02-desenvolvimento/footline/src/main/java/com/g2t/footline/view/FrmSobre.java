package com.g2t.footline.view;

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
		setModal(true);
		setTitle("Sobre o footline");
		setResizable(false);
		setBounds(100, 100, 333, 224);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("1.0.0");
			lblNewLabel_1.setBounds(37, 50, 46, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("    Footline");
			lblNewLabel.setBackground(new Color(255, 255, 255));
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel.setBounds(0, 0, 444, 64);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
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
