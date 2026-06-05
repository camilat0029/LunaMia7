package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollPaneEstilizacao {
	
	public static void estilizarTodos(Container container) {
		
		for (Component componente : container.getComponents()) {
			if(componente instanceof JScrollPane) {
				aplicarEstilizacao((JScrollPane) componente);
			}
			
			if(componente instanceof Container) {
				estilizarTodos((Container) componente);
			}
		}
	}
	
	public static void aplicarEstilizacao(JScrollPane scrollPane) {
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
		JPanel corner = new JPanel();
		corner.setBackground(new Color(234, 219, 247));

		corner.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, new Color(193, 151, 232)));

		scrollPane.setCorner(JScrollPane.UPPER_RIGHT_CORNER,corner);
		scrollPane.getVerticalScrollBar().setBorder(BorderFactory.createEmptyBorder());
		scrollPane.getViewport().setBackground(Color.WHITE);
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(8,0));
		scrollPane.getVerticalScrollBar().setOpaque(false);
		
		scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
			
			@Override
			public void configureScrollBarColors() {
				this.thumbColor = new Color(193, 151, 232);
				this.trackColor = new Color(234, 219, 247);
			}
			
			@Override
			public JButton createDecreaseButton(int orientacao) {
				JButton botao = new JButton();
				botao.setPreferredSize(new Dimension(0,0));
				return botao;
			}
			
			@Override
			public JButton createIncreaseButton(int orientacao) {
				JButton botao =  new JButton();
				botao.setPreferredSize(new Dimension(0,0));
				return botao;
			}
			
			@Override
			public void paintThumb(Graphics grafico, JComponent comp, Rectangle retan) {
				Graphics2D grafico2 = (Graphics2D) grafico.create();
				grafico2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				grafico2.setColor(thumbColor);
				grafico2.fillRoundRect(retan.x, retan.y, retan.width, retan.height, 8, 8);
				grafico2.dispose();
			}
			
			@Override
			public void paintTrack(Graphics grafico, JComponent comp, Rectangle retan) {
				Graphics2D grafico2 = (Graphics2D) grafico.create();
				grafico2.setColor(trackColor);
				grafico2.fillRect(retan.x, retan.y, retan.width, retan.height);
				grafico2.dispose();
			}
		});
	}

}
