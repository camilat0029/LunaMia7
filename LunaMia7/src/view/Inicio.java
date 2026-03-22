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

	public Inicio() {
		
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 30", "[][grow][][][][grow]", "[grow][][][][][grow]"));
		
		JLabel lbPorOndeDesejaComecarIn = new JLabel("Por onde deseja começar?");
		lbPorOndeDesejaComecarIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPorOndeDesejaComecarIn, "cell 2 1 3 1,alignx center");
		
		JButton btConfigurarPerfil = new JButton("Configurar Perfil");
		btConfigurarPerfil.setBackground(new Color(193, 151, 232));
		btConfigurarPerfil.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(btConfigurarPerfil, "cell 2 2 3 1,grow");
		
		JButton btCriarEstoqueIn = new JButton("Criar estoque");
		btCriarEstoqueIn.setBackground(new Color(193, 151, 232));
		btCriarEstoqueIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(btCriarEstoqueIn, "cell 2 3 3 1, width 45%,height 38px");
		
		JButton btCriarOrcamentoIn = new JButton("Criar orçamento");
		btCriarOrcamentoIn.setBackground(new Color(193, 151, 232));
		btCriarOrcamentoIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(btCriarOrcamentoIn, "cell 2 4 3 1,grow");
		
		
		
		btCriarOrcamentoIn.setBorderPainted(false);
		btCriarEstoqueIn.setBorderPainted(false);
		btConfigurarPerfil.setBorderPainted(false);
		
		
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
                int fonteProporcional = Math.max(20, Math.min(40, getWidth() / 30));
                
                lbPorOndeDesejaComecarIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, fonteProporcional));
                btCriarOrcamentoIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, fonteProporcional));
                btCriarEstoqueIn.setFont(new Font("Bodoni Bk BT", Font.PLAIN, fonteProporcional));
        		btConfigurarPerfil.setFont(new Font("Bodoni Bk BT", Font.PLAIN, fonteProporcional));
                
            }
        });
	}
}