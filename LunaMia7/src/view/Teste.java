package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class Teste extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
JPanel panelc;
JPanel panel;
JPanel panelAtual;
	/**
	 * Create the frame.
	 * @param controllerTeste 
	 */
	public Teste(ControllerTeste controllerTeste) {
		panelc = new PanelContr(this);
		panel = new PanelExp(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelAtual = panel;
		contentPane.add(panelAtual, BorderLayout.WEST);
		
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[]", "[]"));

	}


	public void mostrarPainelCont() {
		// TODO Auto-generated method stub
		contentPane.remove(panelAtual);
		contentPane.add(panelc, BorderLayout.WEST);
		panelAtual = panelc;
		validate();
		repaint();
				
	}

	public void mostrarPainelExp() {
		// TODO Auto-generated method stub
		contentPane.remove(panelAtual);
		contentPane.add(panel, BorderLayout.WEST);
		panelAtual = panel;
		validate();
		repaint();
		
		
	}

}
