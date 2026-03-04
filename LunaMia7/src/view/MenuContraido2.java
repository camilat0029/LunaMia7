
package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import controller.Menu;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuContraido2 extends JPanel {

	private static final long serialVersionUID = 1L;
	private Menu menu;

	/**
	 * Create the panel.
	 */
	public MenuContraido2(Menu menu) {
		
		this.menu = menu;
		setBackground(new Color(234, 219, 247));
		
		setPreferredSize(new Dimension(50,640));
		setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clique detectado");
				menu.mostrarPanelExp();
			}
		});
		add(lblNewLabel, "cell 0 0");

	}

}
