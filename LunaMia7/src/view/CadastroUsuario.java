package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
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
	
	public CadastroUsuario() {
		
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[][30.00][grow][][][][][45.00][grow]", "[][grow][][][][][][][][71.00][][][grow]"));
		
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
		add(lbIconeVoltar, "cell 0 0 2 1");
		lbIconeVoltar.setToolTipText("Voltar");
		
		JLabel lbLunaMia = new JLabel("Luna & Mia");
		lbLunaMia.setFont(new Font("Constantia", Font.PLAIN, 99));
		add(lbLunaMia, "cell 3 2 4 1,alignx center,aligny center");
		
		JLabel lbNomeComp = new JLabel("Nome Completo");
		lbNomeComp.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeComp, "cell 3 4");
		
		tfNomeComp = new JTextField();
		tfNomeComp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfNomeComp, "cell 5 4 2 1,width 27%,alignx left,height 38px");
		tfNomeComp.setColumns(10);
				
		JLabel lbNomeUsuario = new JLabel("Nome de Usuário");
		lbNomeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeUsuario, "cell 3 5");
		
		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfNomeUsuario, "cell 5 5 2 1,width 27%,height 38px");
		tfNomeUsuario.setColumns(10);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmail, "cell 3 6");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfEmail, "cell 5 6 2 1,width 27%,height 38px");
		tfEmail.setColumns(10);
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTelefone, "cell 3 7");
			
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfTelefone, "cell 5 7 2 1,width 27%,height 38px");
		tfTelefone.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbSenha, "cell 3 8");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(pfSenha, "cell 5 8 2 1,width 27%,height 38px");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 3 10 4 1,grow");
		
		
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
                btCadastrar.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                                
            }
        });	
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

}
