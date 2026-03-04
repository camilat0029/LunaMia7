package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelContr extends JPanel {

	private static final long serialVersionUID = 1L;
	
	 private ControllerTeste controller;
	/**
	 * Create the panel.
	 * @param teste 
	 */
	public PanelContr(ControllerTeste controllerTeste) {
		
		this.controller = controllerTeste;
		
		setBackground(new Color(255, 0, 128));
		setPreferredSize(new Dimension(100, 400));
		setLayout(new MigLayout("", "[grow]", "[]"));
	
		JButton btnNewButton = new JButton(">>>");
		btnNewButton.addActionListener(e -> {
			controller.exp();
		});
		add(btnNewButton, "cell 0 0");

	}

}
