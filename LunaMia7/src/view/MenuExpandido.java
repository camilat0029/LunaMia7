package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class MenuExpandido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbMostrarMenuCont;
	
	public MenuExpandido() {
		
		setBackground(new Color(234, 219, 247));
		
		setPreferredSize(new Dimension(200,640));
		setLayout(new MigLayout("gap 18", "[][][]", "[][][][][][][][][][]"));
		
		lbMostrarMenuCont = new JLabel(""){
		    @Override
		    public java.awt.Point getToolTipLocation(java.awt.event.MouseEvent event) {
		        return new java.awt.Point(getWidth(), 10);
		    }
		};
		
		lbMostrarMenuCont.setIcon(new ImageIcon(MenuExpandido.class.getResource("/imagensIcones/Icone_Fechar.png")));
		add(lbMostrarMenuCont, "cell 1 0,alignx right");
		
		lbMostrarMenuCont.setToolTipText("Fechar Menu");
		
		JLabel lbImagem = new JLabel("Imagem");
		lbImagem.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		add(lbImagem, "cell 1 1");
		
		JLabel lbNomeUsuarioMN = new JLabel("Nome de Usuário");
		lbNomeUsuarioMN.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lbNomeUsuarioMN, "cell 1 2,aligny center");
		
		JButton btInicio = new JButton("Início");
		btInicio.setBackground(new Color(193, 151, 232));
		btInicio.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(btInicio, "cell 1 4,growx");
		
		JButton btPerfil = new JButton("Perfil");
		btPerfil.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btPerfil.setBackground(new Color(193, 151, 232));
		add(btPerfil, "cell 1 5,growx");
		
		JButton btOrcamento = new JButton("Orçamento");
		btOrcamento.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btOrcamento.setBackground(new Color(193, 151, 232));
		add(btOrcamento, "cell 1 6,growx");
		
		JButton btEstoque = new JButton("Estoque");
		btEstoque.setBackground(new Color(193, 151, 232));
		btEstoque.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(btEstoque, "cell 1 7,growx");
		
		JButton btRelatorios = new JButton("Relatórios");
		btRelatorios.setBackground(new Color(193, 151, 232));
		btRelatorios.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(btRelatorios, "cell 1 8,growx");
		
		btInicio.setBorderPainted(false);
		btPerfil.setBorderPainted(false);
		btOrcamento.setBorderPainted(false);
		btEstoque.setBorderPainted(false);
		btRelatorios.setBorderPainted(false);

	}
	
	public void mostrarMenuContraido(MouseListener mouseListener) {
		this.lbMostrarMenuCont.addMouseListener(mouseListener);
	}

}
