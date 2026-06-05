package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class ComboBoxEstilizacao {
	
	public static void estilizarComboBox(JComboBox<?> comboBox) {
		
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox.setBorder(BorderFactory.createLineBorder(new Color(193, 151, 232), 1));
        comboBox.setFocusable(false);
        
        for (Component componente : comboBox.getComponents()) {
        	if(componente instanceof JButton botao) {
        		botao.setBackground(new Color(193, 151, 232));
        		botao.setBorderPainted(false);
        		botao.setFocusPainted(false);
        		botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        	}
        }
        
        comboBox.setRenderer(new ListCellRenderer<Object>() {
        	private final JLabel label = new JLabel();
        	{
        		label.setOpaque(true);
        		label.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                label.setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        	}
			@Override
			public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
					boolean isSelected, boolean cellHasFocus) {
				
				label.setText(value != null ? value.toString() : "");
				
				if(isSelected) {
					label.setBackground(new Color(193, 151, 232));
                    label.setForeground(Color.WHITE);
				} else {
					label.setBackground(Color.WHITE);
                    label.setForeground(Color.BLACK);
				}
				return label;
			}
        	
        });
        
        comboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {

	        @Override
	        public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent e) {
	            javax.swing.SwingUtilities.invokeLater(() -> {
	                Object popup = comboBox.getUI().getAccessibleChild(comboBox, 0);
	                if (popup instanceof javax.swing.plaf.basic.BasicComboPopup basicPopup) {
	                	for (Component comp : basicPopup.getComponents()) {
	            	        if (comp instanceof JScrollPane scrollPane) {
	            	            ScrollPaneEstilizacao.aplicarEstilizacao(scrollPane);
	            	        }
	            	    }
	                }
	            });
	        }

	        @Override public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent e) {}
	        @Override public void popupMenuCanceled(javax.swing.event.PopupMenuEvent e) {}
	    });
		
	}
	
	

}
