package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InicioPosCadastro extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public InicioPosCadastro() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[][][][][grow][]", "[][][][][26.00][26][26][26][][][23.00,grow]"));
		
		JLabel lbBemVindoIPC = new JLabel("Bem Vindo!");
		lbBemVindoIPC.setFont(new Font("Constantia", Font.PLAIN, 80));
		add(lbBemVindoIPC, "cell 2 1 3 1,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Por onde deseja começar?");
		lblNewLabel_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lblNewLabel_1, "cell 2 3 3 1,alignx center");
		
		JPanel panelConfigurarPerfil = new JPanel();
		panelConfigurarPerfil.setBackground(new Color(234, 219, 247));
		add(panelConfigurarPerfil, "cell 2 5 3 1,grow");
		
		JButton btConfigurarPerfil = new JButton("Configurar perfil");
		btConfigurarPerfil.setBackground(new Color(193, 151, 232));
		btConfigurarPerfil.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelConfigurarPerfil.add(btConfigurarPerfil);
		btConfigurarPerfil.setBorderPainted(false);
		
		JPanel panelCriarEstoque = new JPanel();
		panelCriarEstoque.setBackground(new Color(234, 219, 247));
		add(panelCriarEstoque, "cell 2 7 3 1,grow");
		
		JButton btCriarEstoque = new JButton("Criar estoque");
		btCriarEstoque.setBackground(new Color(193, 151, 232));
		btCriarEstoque.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelCriarEstoque.add(btCriarEstoque);
		btCriarEstoque.setBorderPainted(false);
		
		JPanel panelCriarOrcamento = new JPanel();
		panelCriarOrcamento.setBackground(new Color(234, 219, 247));
		add(panelCriarOrcamento, "cell 2 9 3 1,grow");
		
		JButton btCriarOrcamento = new JButton("Criar orçamento");
		btCriarOrcamento.setBackground(new Color(193, 151, 232));
		btCriarOrcamento.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelCriarOrcamento.add(btCriarOrcamento);
		btCriarOrcamento.setBorderPainted(false);
		

	}

}
