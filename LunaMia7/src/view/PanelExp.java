package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelExp extends JPanel {

	private static final long serialVersionUID = 1L;

	private ControllerTeste controller;
	/**
	 * Create the panel.
	 * @param teste 
	 */
	public PanelExp(ControllerTeste controllerTeste) {
		setBackground(new Color(255, 0, 128));
		
		setPreferredSize(new Dimension(100, 400));
		setLayout(new MigLayout("", "[grow,fill]", "[][][][][][]"));
		
		this.controller = controllerTeste;
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(e ->{
			controller.cont();
		});
		btnNewButton_3.setSelectedIcon(new ImageIcon(PanelExp.class.getResource("/imagensIcones/AbrirFechar.png")));
		btnNewButton_3.setBackground(new Color(255, 0, 128));
		add(btnNewButton_3, "cell 0 0");
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton, "cell 0 3");
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1, "cell 0 4");
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2, "cell 0 5");

	}

}
