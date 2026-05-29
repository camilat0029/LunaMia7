
package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class MenuContraido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbMostrarMenuExp;

	public MenuContraido() {
		
		setBackground(new Color(234, 219, 247));
		
		setPreferredSize(new Dimension(50,640));
		setLayout(new MigLayout("", "[]", "[]"));
		
		lbMostrarMenuExp = new JLabel(""){
		    @Override
		    public java.awt.Point getToolTipLocation(java.awt.event.MouseEvent event) {
		        return new java.awt.Point(getWidth(), 10);
		    }
		};
		
		
		lbMostrarMenuExp.setIcon(new ImageIcon(MenuContraido.class.getResource("/imagensIcones/Icone_Abrir.png")));
		
		add(lbMostrarMenuExp, "cell 0 0");
		
		lbMostrarMenuExp.setToolTipText("Menu");
		
	}
	
	public void mostrarMenuExpandido(MouseListener mouseListener) {
		this.lbMostrarMenuExp.addMouseListener(mouseListener);
	}

}
