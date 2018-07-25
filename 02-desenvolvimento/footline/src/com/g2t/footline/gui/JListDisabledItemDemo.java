package com.g2t.footline.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class JListDisabledItemDemo implements ItemListener, Runnable {

    private JFrame f = new JFrame("Colors");
    private static final String ITEMS[] = {" black ", " blue ", " green ",
        " orange ", " purple ", " red ", " white ", " yellow "};
    private JList jList;
    private JCheckBox[] checkBoxes;
    private boolean[] enabledFlags;

    @Override
    public void run() {
        JPanel pnlEnablers = new JPanel(new GridLayout(0, 1));
        pnlEnablers.setBorder(BorderFactory.createTitledBorder("Enabled Items"));
        checkBoxes = new JCheckBox[ITEMS.length];
        enabledFlags = new boolean[ITEMS.length];
        for (int i = 0; i < ITEMS.length; i++) {
            checkBoxes[i] = new JCheckBox(ITEMS[i]);
            checkBoxes[i].setSelected(true);
            checkBoxes[i].addItemListener(this);
            enabledFlags[i] = true;
            pnlEnablers.add(checkBoxes[i]);
        }
        jList = new JList(ITEMS);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList.setSelectionModel(new DisabledItemSelectionModel());
        jList.setCellRenderer(new DisabledItemListCellRenderer());
        jList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    System.out.println("selection");
                }
            }
        });
        JScrollPane scroll = new JScrollPane(jList);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Container contentPane = f.getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));
        contentPane.add(pnlEnablers);
        contentPane.add(scroll);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(240, 280);
        UIManager.put("List.background", Color.lightGray);
        UIManager.put("List.selectionBackground", Color.orange);
        UIManager.put("List.selectionForeground", Color.blue);
        UIManager.put("Label.disabledForeground", Color.magenta);
        SwingUtilities.updateComponentTreeUI(f);
        f.pack();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                f.setVisible(true);
            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent event) {
        JCheckBox checkBox = (JCheckBox) event.getSource();
        int index = -1;
        for (int i = 0; i < ITEMS.length; i++) {
            if (ITEMS[i].equals(checkBox.getText())) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            enabledFlags[index] = checkBox.isSelected();
            jList.repaint();
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new JListDisabledItemDemo());
    }

    private class DisabledItemListCellRenderer extends DefaultListCellRenderer {

        private static final long serialVersionUID = 1L;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component comp = super.getListCellRendererComponent(list, value, index, false, false);
            JComponent jc = (JComponent) comp;
            if (enabledFlags[index]) {
                if (isSelected & cellHasFocus) {
                    comp.setForeground(Color.black);
                    comp.setBackground(Color.red);
                } else {
                    comp.setForeground(Color.blue);
                }
                if (!isSelected) {
                    if ((value.toString()).trim().equals("yellow")) {
                        comp.setForeground(Color.orange);
                        comp.setBackground(Color.magenta);
                    }
                }
                return comp;
            }
            comp.setEnabled(false);
            return comp;
        }
    }

    private class DisabledItemSelectionModel extends DefaultListSelectionModel {

        private static final long serialVersionUID = 1L;

        @Override
        public void setSelectionInterval(int index0, int index1) {
            if (enabledFlags[index0]) {
                super.setSelectionInterval(index0, index0);
            } else {
                /*
                 * The previously selected index is before this one,
                 * so walk forward to find the next selectable item.
                 */
                if (getAnchorSelectionIndex() < index0) {
                    for (int i = index0; i < enabledFlags.length; i++) {
                        if (enabledFlags[i]) {
                            super.setSelectionInterval(i, i);
                            return;
                        }
                    }
                } /*
                 * Otherwise, walk backward to find the next selectable item.
                 */ else {
                    for (int i = index0; i >= 0; i--) {
                        if (enabledFlags[i]) {
                            super.setSelectionInterval(i, i);
                            return;
                        }
                    }
                }
            }
        }
    }
}
