package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

public class MenuExpandido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbMostrarMenuCont;
	private JButton btInicio;
	private JButton btPerfil;
	private JButton btEstoque;
	private JButton btRelatorios;
	private JButton btOrcamentos;
	private JButton btSair;
	private JLabel lbNomeUsuarioMN;
	
	
	public MenuExpandido() {
		
		setBackground(new Color(234, 219, 247));
		
		setPreferredSize(new Dimension(200,640));
		setLayout(new MigLayout("gap 18", "[][][]", "[][][][][][][][][][grow][]"));
		
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
		lbImagem.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lbImagem, "cell 1 1");
		
		lbNomeUsuarioMN = new JLabel("Nome de Usuário");
		lbNomeUsuarioMN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lbNomeUsuarioMN, "cell 1 2,aligny center");
		
		btInicio = new JButton("Início");
		btInicio.setBackground(new Color(193, 151, 232));
		btInicio.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btInicio, "cell 1 4,growx");
		
		btPerfil = new JButton("Perfil");
		btPerfil.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btPerfil.setBackground(new Color(193, 151, 232));
		add(btPerfil, "cell 1 5,growx");
		
		btOrcamentos = new JButton("Orçamento");
		btOrcamentos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btOrcamentos.setBackground(new Color(193, 151, 232));
		add(btOrcamentos, "cell 1 6,growx");
		
		btEstoque = new JButton("Estoque");
		btEstoque.setBackground(new Color(193, 151, 232));
		btEstoque.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btEstoque, "cell 1 7,growx");
		
		btRelatorios = new JButton("Relatórios");
		btRelatorios.setBackground(new Color(193, 151, 232));
		btRelatorios.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btRelatorios, "cell 1 8,growx");
		
		btInicio.setBorderPainted(false);
		btPerfil.setBorderPainted(false);
		btOrcamentos.setBorderPainted(false);
		btEstoque.setBorderPainted(false);
		btRelatorios.setBorderPainted(false);
		
		btSair = new JButton("Sair");
		btSair.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btSair.setBorderPainted(false);
		btSair.setBackground(new Color(193, 151, 232));
		add(btSair, "cell 1 10,growx,aligny center");

	}
	
	public void inicio(ActionListener actionListener) {
		this.btInicio.addActionListener(actionListener);
	}
	
	public void estoque(ActionListener actionListener) {
		this.btEstoque.addActionListener(actionListener);
	}
	
	public void perfil(ActionListener actionListener) {
		this.btPerfil.addActionListener(actionListener);
	}
	
	public void relatorios(ActionListener actionListener) {
		this.btRelatorios.addActionListener(actionListener);
	}
	
	public void orcamentos(ActionListener actionListener) {
		this.btOrcamentos.addActionListener(actionListener);
	}
	
	public void sair(ActionListener actionListener) {
	    this.btSair.addActionListener(actionListener);
	}
		
	public void mostrarMenuContraido(MouseListener mouseListener) {
		this.lbMostrarMenuCont.addMouseListener(mouseListener);
	}

	public JLabel getLbNomeUsuarioMN() {
		return lbNomeUsuarioMN;
	}

	public void setNomeUsuario(String nome) {
	    lbNomeUsuarioMN.setText(nome);
	}
	
	

}
