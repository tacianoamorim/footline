package com.g2t.footline.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Dialog.ModalExclusionType;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

/**
 * @author Taciano
 */
public class AppMain extends javax.swing.JFrame {
    
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6372065349465603650L;
	
	private DefaultTableModel tableModel;
    private javax.swing.JButton btnNovo;
    // End of variables declaration         
    
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
//        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Footline");
        
        JPanel panel = new JPanel();
                panel.setLayout(null);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(7)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(7)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
                btnNovo = new javax.swing.JButton();
                btnNovo.setBounds(214, 67, 107, 29);
                btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 16));
                btnNovo.setIcon(null);
                
                        btnNovo.setText("Novo jogo");
                        btnNovo.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSalvarActionPerformed(evt);
                            }
                        });
                        panel.add(btnNovo);
        getContentPane().setLayout(groupLayout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    	  

    }//GEN-LAST:event_btnSalvarActionPerformed

    
    private void carregarLinhas() {
        try {
        	limpaTabela();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    } 

    public void limpaTabela() {
		int size = tableModel.getRowCount();
		for(int i = size; i > 0; i--) {
			tableModel.removeRow(i-1);
		}
	}    
}
