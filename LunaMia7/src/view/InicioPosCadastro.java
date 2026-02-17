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
		
		JLabel lblNewLabel = new JLabel("Bem Vindo!");
		lblNewLabel.setFont(new Font("Constantia", Font.PLAIN, 80));
		add(lblNewLabel, "cell 2 1 3 1,alignx center,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Por onde deseja começar?");
		lblNewLabel_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblNewLabel_1, "cell 2 3 3 1,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 5 3 1,grow");
		
		JButton btConfigurarPerfil = new JButton("Configurar perfil");
		btConfigurarPerfil.setBackground(new Color(193, 151, 232));
		btConfigurarPerfil.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel.add(btConfigurarPerfil);
		btConfigurarPerfil.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 2 7 3 1,grow");
		
		JButton btCriarEstoque = new JButton("Criar estoque");
		btCriarEstoque.setBackground(new Color(193, 151, 232));
		btCriarEstoque.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel_1.add(btCriarEstoque);
		btCriarEstoque.setBorderPainted(false);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 2 9 3 1,grow");
		
		JButton btCriarOrcamento = new JButton("Criar orçamento");
		btCriarOrcamento.setBackground(new Color(193, 151, 232));
		btCriarOrcamento.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel_2.add(btCriarOrcamento);
		btCriarOrcamento.setBorderPainted(false);
		

	}

}
