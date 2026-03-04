package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.BorderLayout;

public class TelaPrincipal2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	JPanel panelTelas = new JPanel();
	JPanel panelMenu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal2 frame = new TelaPrincipal2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.cardLayout = new CardLayout();
		
		panelMenu = new JPanel(new BorderLayout());
		contentPane.add(panelMenu, BorderLayout.WEST);
		
		contentPane.add(panelTelas, BorderLayout.CENTER);
		panelTelas.setLayout(cardLayout);
		
		
		
		setPreferredSize(new Dimension(1020,640)); // Tamanho de padrão
		setMinimumSize(new Dimension(1020, 640)); // Tamanho minimo
		setLocationRelativeTo(null); // Tela Centralizada
		

	}
	public void adicionarTela(String nome, JPanel tela){
		this.panelTelas.add(tela, nome);
	}
	
	public void mostrarTela(String nome) {
		this.cardLayout.show(this.panelTelas, nome);
		this.pack();
	}
	
	public void mudarMenu(JPanel menu) {
	    panelMenu.removeAll();
	    panelMenu.add(menu, BorderLayout.CENTER);
	    panelMenu.revalidate();
	    panelMenu.repaint();
	}

}
