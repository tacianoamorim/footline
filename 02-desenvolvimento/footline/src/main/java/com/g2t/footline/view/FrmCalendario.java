package com.g2t.footline.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.g2t.footline.entity.Footline;
import com.g2t.footline.entity.Rodada;

public class FrmCalendario extends JDialog {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5577059619343394507L;
	
	private final JPanel contentPanel = new JPanel();
	private JList<String> listJogos;
	DefaultListModel<String> modelo = new DefaultListModel<String>();

	/**
	 * Create the frame.
	 */
	public FrmCalendario(Footline gerente) {
		setTitle("Calendário");
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
		
		JScrollPane scrollPane = new JScrollPane(listJogos);
		//panel.add(scrollPane, BorderLayout.SOUTH);
		
		listJogos =  new JList<String>(modelo);
		listJogos.setVisibleRowCount(10);
		
		// Carregar a lista
		final DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		List<Rodada> rodadas= FrmPrincipal.rodadas;
		for (Rodada rodada : rodadas) {
			modelo.addElement( " > "+ rodada.getNumero() +" - " + df.format( rodada.getData().getTime() ) );
		}
		panel.setLayout(new BorderLayout(0, 0));
		
		panel.add(scrollPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 128, 128));
			buttonPane.setForeground(new Color(0, 128, 128));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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

}
