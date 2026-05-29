package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;

public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btConfigurarPerfil;
	private JButton btCriarEstoque;
	private JButton btCriarOrcamento;

	public Inicio() {
		
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 30", "[][grow][][][][grow]", "[grow][][][][][grow]"));
		
		JLabel lbPorOndeDesejaComecar = new JLabel("Por onde deseja começar?");
		lbPorOndeDesejaComecar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPorOndeDesejaComecar, "cell 2 1 3 1,alignx center");
		
		btConfigurarPerfil = new JButton("Configurar Perfil");
		btConfigurarPerfil.setBackground(new Color(193, 151, 232));
		btConfigurarPerfil.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btConfigurarPerfil, "cell 2 2 3 1,grow");
		
		btCriarEstoque = new JButton("Criar estoque");
		btCriarEstoque.setBackground(new Color(193, 151, 232));
		btCriarEstoque.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btCriarEstoque, "cell 2 3 3 1, width 45%,height 38px");
		
		btCriarOrcamento = new JButton("Criar orçamento");
		btCriarOrcamento.setBackground(new Color(193, 151, 232));
		btCriarOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btCriarOrcamento, "cell 2 4 3 1,grow");		
		
		btCriarOrcamento.setBorderPainted(false);
		btCriarEstoque.setBorderPainted(false);
		btConfigurarPerfil.setBorderPainted(false);
		
		btCriarOrcamento.setFocusPainted(false);
		btCriarEstoque.setFocusPainted(false);
		btConfigurarPerfil.setFocusPainted(false);
		
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
                int fonteProporcional = Math.max(20, Math.min(40, getWidth() / 30));
                
                lbPorOndeDesejaComecar.setFont(new Font("Times New Roman", Font.PLAIN, fonteProporcional));
                btCriarOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, fonteProporcional));
                btCriarEstoque.setFont(new Font("Times New Roman", Font.PLAIN, fonteProporcional));
        		btConfigurarPerfil.setFont(new Font("Times New Roman", Font.PLAIN, fonteProporcional));
                
            }
        });
	}
	
	public void criarOrcamento(ActionListener actionListener) {
		this.btCriarOrcamento.addActionListener(actionListener);
	}
	public void criarEstoque(ActionListener actionListener) {
		this.btCriarEstoque.addActionListener(actionListener);
	}
	public void configurarPerfil(ActionListener actionListener) {
		this.btConfigurarPerfil.addActionListener(actionListener);
	}
}