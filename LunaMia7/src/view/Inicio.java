
package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Inicio() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 15", "[][grow][][][][grow]", "[grow][][][][][][][][grow]"));
		
		JLabel lbPorOndeDesejaComecarIn = new JLabel("Por onde deseja começar?");
		lbPorOndeDesejaComecarIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPorOndeDesejaComecarIn, "cell 2 1 3 1,alignx center");
		
		JPanel panelConfigurarPerfilIn = new JPanel();
		panelConfigurarPerfilIn.setBackground(new Color(234, 219, 247));
		add(panelConfigurarPerfilIn, "cell 2 3 3 1,grow");
		
		JButton btConfigurarPerfilIn = new JButton("Configurar perfil");
		btConfigurarPerfilIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btConfigurarPerfilIn.setBackground(new Color(193, 151, 232));
		btConfigurarPerfilIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelConfigurarPerfilIn.add(btConfigurarPerfilIn);
		btConfigurarPerfilIn.setBorderPainted(false);
		
		JPanel panelCriarEstoqueIn = new JPanel();
		panelCriarEstoqueIn.setBackground(new Color(234, 219, 247));
		add(panelCriarEstoqueIn, "cell 2 5 3 1,grow");
		
		JButton btCriarEstoqueIn = new JButton("Criar estoque");
		btCriarEstoqueIn.setBackground(new Color(193, 151, 232));
		btCriarEstoqueIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelCriarEstoqueIn.add(btCriarEstoqueIn);
		btCriarEstoqueIn.setBorderPainted(false);
		
		JPanel panelCriarOrcamentoIn = new JPanel();
		panelCriarOrcamentoIn.setBackground(new Color(234, 219, 247));
		add(panelCriarOrcamentoIn, "cell 2 7 3 1,grow");
		
		JButton btCriarOrcamentoIn = new JButton("Criar orçamento");
		btCriarOrcamentoIn.setBackground(new Color(193, 151, 232));
		btCriarOrcamentoIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelCriarOrcamentoIn.add(btCriarOrcamentoIn);
		btCriarOrcamentoIn.setBorderPainted(false);
		
		

	}

}
