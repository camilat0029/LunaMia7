package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.BorderLayout;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	JPanel panelTelas = new JPanel();
	JPanel panelMenu;
	private String panelAtual;
	
	public TelaPrincipal() {
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
		this.panelAtual = nome;
		this.pack();
	}
	
	public String getPanelAtual() {
		return panelAtual;
	}
	public void setPanelAtual(String panelAtual) {
		this.panelAtual = panelAtual;
	}
	public void mudarMenu(JPanel menu) {
	    panelMenu.removeAll();
	    panelMenu.add(menu, BorderLayout.CENTER);
	    panelMenu.revalidate();
	    panelMenu.repaint();
	}
	public JPanel getPanelMenu() {
		return panelMenu;
	}
	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}
	public JPanel getPanelTelas() {
		return panelTelas;
	}
	public void setPanelTelas(JPanel panelTelas) {
		this.panelTelas = panelTelas;
	}
	
	
	

}
