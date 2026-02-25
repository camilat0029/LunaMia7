package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class PanelExp extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 * @param teste 
	 */
	public PanelExp(Teste teste) {
		setBackground(new Color(255, 0, 128));
		setLayout(new MigLayout("", "[grow,fill]", "[][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("<<<");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("ghjkghkhjk");
				teste.mostrarPainelCont();
			}
		});
		add(lblNewLabel, "cell 0 0");
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, "cell 0 3");
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1, "cell 0 4");
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2, "cell 0 5");

	}

}
