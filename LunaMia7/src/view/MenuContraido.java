
package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;

public class MenuContraido extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MenuContraido() {
		setBackground(new Color(234, 219, 247));
		
		setPreferredSize(new Dimension(50,640));
		setLayout(new MigLayout("", "[]", "[]"));

	}

}
