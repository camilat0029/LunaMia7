package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class CadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeComp;
	private JTextField tfNomeUsuario;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JPasswordField pfSenha;
	private JLabel lbIconeVoltar;
	private JButton btCadastrar;
	private JLabel asteriscoNC, asteriscoNU, asteriscoE, asteriscoS, asteriscoCS;
	private JLabel lbConfirmarSenha;
	private JPasswordField pfConfirmarSenha;
	
	public CadastroUsuario() {
		
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow][][][grow]", "[grow][][][][][][][][][][grow]"));
		
		lbIconeVoltar = new JLabel(""){
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.BOLD, 15));

				return tooltip;
			}
		};
		
		lbIconeVoltar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/imagensIcones/Icone_Seta.png")));
		add(lbIconeVoltar, "pos 20 20,cell 0 0");
		lbIconeVoltar.setToolTipText("Voltar");
		
		JLabel lbLunaMia = new JLabel("Luna & Mia");
		lbLunaMia.setFont(new Font("Constantia", Font.PLAIN, 99));
		add(lbLunaMia, "cell 1 1 2 1,alignx center,aligny center");
		
		JLabel lbNomeComp = new JLabel("Nome Completo");
		lbNomeComp.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeComp, "cell 1 3");
		
		tfNomeComp = new JTextField();
		tfNomeComp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfNomeComp, "cell 2 3,growx,width 27%,height 38px");
		tfNomeComp.setColumns(10);
				
		JLabel lbNomeUsuario = new JLabel("Nome de Usuário");
		lbNomeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeUsuario, "cell 1 4");
		
		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfNomeUsuario, "cell 2 4,growx,width 27%,height 38px");
		tfNomeUsuario.setColumns(10);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmail, "cell 1 5");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfEmail, "cell 2 5,growx,width 27%,height 38px");
		tfEmail.setColumns(10);
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTelefone, "cell 1 6");
			
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfTelefone, "cell 2 6,growx,width 27%,height 38px");
		tfTelefone.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbSenha, "cell 1 7");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(pfSenha, "cell 2 7,growx,width 27%,height 38px");
		
		lbConfirmarSenha = new JLabel("Confirme a senha");
		lbConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbConfirmarSenha, "cell 1 8");
		
		pfConfirmarSenha = new JPasswordField();
		pfConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(pfConfirmarSenha, "cell 2 8,growx, width 27%,height 38px");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 1 9 2 1,grow");
		
		
		btCadastrar = new JButton("Cadastrar");
		
		btCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btCadastrar.setBackground(new Color(193, 151, 232));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);
		btCadastrar.setFocusPainted(false);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
                int novaFonte = Math.max(20, Math.min(40, getWidth() / 30));

                lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbNomeComp.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbNomeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbTelefone.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbSenha.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbConfirmarSenha.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                btCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                                
            }
        });
		
		ImageIcon iconAsterisco = new ImageIcon(CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Asterisco.png"));
		Image imgAsterisco = iconAsterisco.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		
		asteriscoNC = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239,239,239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		asteriscoNC.setIcon(new ImageIcon(imgAsterisco));
		add(asteriscoNC, "cell 1 3,alignx left,aligny top");
		
		asteriscoNU = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		asteriscoNU.setIcon(new ImageIcon(imgAsterisco));
		add(asteriscoNU, "cell 1 4,alignx left,aligny top");
		
		asteriscoE = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		asteriscoE.setIcon(new ImageIcon(imgAsterisco));
		add(asteriscoE, "cell 1 5,alignx left,aligny top");
		
		asteriscoS = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		
		asteriscoS.setIcon(new ImageIcon(imgAsterisco));
		add(asteriscoS, "cell 1 7,alignx left,aligny top");
		
		asteriscoCS = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		asteriscoCS.setIcon(new ImageIcon(imgAsterisco));
		add(asteriscoCS, "cell 1 8,alignx left,aligny top");
		
		asteriscoNC.setToolTipText("<html><b>É obrigatório</b></html>");
		asteriscoNU.setToolTipText("<html><b>É obrigatório</b></html>");
		asteriscoE.setToolTipText("<html><b>É obrigatório</b></html>");
		asteriscoS.setToolTipText("<html><b>É obrigatório</b></html>");
		asteriscoCS.setToolTipText("<html><b>É obrigatório</b></html>");

	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbIconeVoltar.addMouseListener(mouseListener);
	}
	
	public void cadastrar(ActionListener actionListener) {
		this.btCadastrar.addActionListener(actionListener);
	}
	
	public JTextField getTfNomeComp() {
		return tfNomeComp;
	}

	public void setTfNomeComp(JTextField tfNomeComp) {
		this.tfNomeComp = tfNomeComp;
	}

	public JTextField getTfNomeUsuario() {
		return tfNomeUsuario;
	}

	public void setTfNomeUsuario(JTextField tfNomeUsuario) {
		this.tfNomeUsuario = tfNomeUsuario;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfTelefone() {
		return tfTelefone;
	}

	public void setTfTelefone(JTextField tfTelefone) {
		this.tfTelefone = tfTelefone;
	}

	public JPasswordField getPfSenha() {
		return pfSenha;
	}

	public void setPfSenha(JPasswordField pfSenha) {
		this.pfSenha = pfSenha;
	}

	public JPasswordField getPfConfirmarSenha() {
		return pfConfirmarSenha;
	}

	public void setPfConfirmarSenha(JPasswordField pfConfirmarSenha) {
		this.pfConfirmarSenha = pfConfirmarSenha;
	}

	
	

}
