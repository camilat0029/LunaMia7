package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class PanelContr extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param teste 
	 */
	public PanelContr(Teste teste) {
		setBackground(new Color(255, 0, 128));
		setLayout(new MigLayout("", "[grow]", "[]"));
		
		JLabel lblNewLabel = new JLabel(">>>");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ghjkghkhjk");
				teste.mostrarPainelExp();
			}
		});
		add(lblNewLabel, "cell 0 0");

	}

}
