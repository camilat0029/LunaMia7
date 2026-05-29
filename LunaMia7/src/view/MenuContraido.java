
package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JToolTip;
import javax.swing.ToolTipManager;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

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
		    
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.BOLD, 15));

				return tooltip;
			}
		};
		
		
		
		lbMostrarMenuExp.setIcon(new ImageIcon(MenuContraido.class.getResource("/imagensIcones/Icone_Abrir.png")));
		
		add(lbMostrarMenuExp, "cell 0 0");
		
		lbMostrarMenuExp.setToolTipText("Menu");
		
		  addAncestorListener(new AncestorListener() {
		        @Override
		        public void ancestorRemoved(AncestorEvent event) {
		            ToolTipManager.sharedInstance().setEnabled(false);
		            ToolTipManager.sharedInstance().setEnabled(true); 
		        }

		        @Override
		        public void ancestorAdded(AncestorEvent event) {}

		        @Override
		        public void ancestorMoved(AncestorEvent event) {}
		    });
		
	}
	
	public void mostrarMenuExpandido(MouseListener mouseListener) {
		this.lbMostrarMenuExp.addMouseListener(mouseListener);
	}
	
  

}
