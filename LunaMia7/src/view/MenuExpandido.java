package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class MenuExpandido extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbMostrarMenuCont;
	private JButton btInicio, btPerfil, btEstoque, btRelatorios, btOrcamentos, btSair;
	private JLabel lbNomeUsuario;
	private JLabel lbFoto;
	
	
	public MenuExpandido() {
		
		setBackground(new Color(234, 219, 247));
		
		setPreferredSize(new Dimension(200,640));
		setLayout(new MigLayout("gap 12", "[grow][160px:n][grow]", "[][][][][][][][][][grow][]"));
		
		lbMostrarMenuCont = new JLabel(""){
		    @Override
		    public java.awt.Point getToolTipLocation(java.awt.event.MouseEvent event) {
		        return new java.awt.Point(getWidth(), 10);
		    }
		};
		
		lbMostrarMenuCont.setIcon(new ImageIcon(MenuExpandido.class.getResource("/imagensIcones/Icone_Fechar.png")));
		add(lbMostrarMenuCont, "cell 1 0,alignx right");
		
		lbMostrarMenuCont.setToolTipText("Fechar Menu");
		
		lbFoto = new JLabel("");
		lbFoto.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		add(lbFoto, "cell 1 1,alignx center,aligny center");
		ImageIcon imagemPadrao = new ImageIcon(getClass().getResource("/imagensIcones/fotoPerfilPadrao.png"));
		lbFoto.setIcon(new ImageIcon(imagemPadrao.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

		lbFoto.setPreferredSize(new Dimension(120, 120));
		
		lbNomeUsuario = new JLabel("Nome de Usuário");
		lbNomeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lbNomeUsuario, "cell 1 2,alignx center,aligny center");
		
		btInicio = new JButton("Início");
		btInicio.setBackground(new Color(193, 151, 232));
		btInicio.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(btInicio, "cell 1 4,growx");
		
		btPerfil = new JButton("Perfil");
		btPerfil.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btPerfil.setBackground(new Color(193, 151, 232));
		add(btPerfil, "cell 1 5,growx");
		
		btOrcamentos = new JButton("Orçamento");
		btOrcamentos.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btOrcamentos.setBackground(new Color(193, 151, 232));
		add(btOrcamentos, "cell 1 6,growx");
		
		btEstoque = new JButton("Estoque");
		btEstoque.setBackground(new Color(193, 151, 232));
		btEstoque.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(btEstoque, "cell 1 7,growx");
		
		btRelatorios = new JButton("Relatórios");
		btRelatorios.setBackground(new Color(193, 151, 232));
		btRelatorios.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(btRelatorios, "cell 1 8,growx");
		
		btInicio.setBorderPainted(false);
		btPerfil.setBorderPainted(false);
		btOrcamentos.setBorderPainted(false);
		btEstoque.setBorderPainted(false);
		btRelatorios.setBorderPainted(false);
		
		btInicio.setFocusPainted(false);
		btPerfil.setFocusPainted(false);
		btOrcamentos.setFocusPainted(false);
		btEstoque.setFocusPainted(false);
		btRelatorios.setFocusPainted(false);
		
		btSair = new JButton("Sair");
		btSair.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btSair.setBorderPainted(false);
		btSair.setFocusPainted(false);
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

	public JLabel getLbNomeUsuario() {
		return lbNomeUsuario;
	}

	public void setNomeUsuario(String nome) {
	    lbNomeUsuario.setText(nome);
	}

	public JLabel getLbImagem() {
		return lbFoto;
	}
	
	public void setImagemPerfil(String caminho) {

	    try {
	        ImageIcon icon = new ImageIcon(caminho);

	        Image img = icon.getImage();

	        int size = 120;

	        BufferedImage buffered = new BufferedImage(
	                size, size, BufferedImage.TYPE_INT_ARGB);

	        Graphics2D g2 = buffered.createGraphics();

	        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
	                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);

	        g2.drawImage(img, 0, 0, size, size, null);
	        g2.dispose();
	 
	        BufferedImage circular = recortarCircular(buffered, size);

	        lbFoto.setIcon(new ImageIcon(circular));
	        lbFoto.setHorizontalAlignment(JLabel.CENTER);
	        lbFoto.setVerticalAlignment(JLabel.CENTER);
	       

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private BufferedImage recortarCircular(BufferedImage imagem, int tamanho) {

		BufferedImage saida = new BufferedImage(tamanho, tamanho, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = saida.createGraphics();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setClip(new Ellipse2D.Float(0, 0, tamanho, tamanho));

		g2.drawImage(imagem, 0, 0, tamanho, tamanho, null);

		g2.dispose();

		return saida;
	}
	
	

}
