package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class Login extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuarioLogin;
	private JPasswordField pfSenhaLogin;

	/**
	 * Create the panel.
	 */
	public Login() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow][center][][center][267.00,center][grow]", "[grow][][][30.00][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "cell 0 0");
		
		JLabel lbLunaEMiaLogin = new JLabel("Luna & Mia");
		lbLunaEMiaLogin.setFont(new Font("Constantia", Font.PLAIN, 80));
		add(lbLunaEMiaLogin, "cell 1 1 4 1,aligny center");
		
		JLabel lbUsuarioLogin = new JLabel("Usuário");
		lbUsuarioLogin.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbUsuarioLogin, "cell 1 2 4 1");
		
		tfUsuarioLogin = new JTextField();
		tfUsuarioLogin.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		tfUsuarioLogin.setColumns(10);
		add(tfUsuarioLogin, "cell 1 3 4 1,width 400px,height 30px");
		
		JLabel lbSenhaLogin = new JLabel("Senha");
		lbSenhaLogin.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbSenhaLogin, "cell 1 5 4 1,alignx center");
		
		pfSenhaLogin = new JPasswordField();
		pfSenhaLogin.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		add(pfSenhaLogin, "cell 1 6 4 1,width 400px,height 30px");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 1 8 4 1,grow");
		
		JButton btEntrarLogin = new JButton("Entrar");
		btEntrarLogin.setBackground(new Color(193, 151, 232));
		btEntrarLogin.setForeground(new Color(0, 0, 0));
		btEntrarLogin.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel.add(btEntrarLogin);
		btEntrarLogin.setBorderPainted(false);
		
		JLabel lbNaoTemContaLogin = new JLabel("Não tem conta?");
		lbNaoTemContaLogin.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lbNaoTemContaLogin, "cell 1 10 3 1, gapx 60");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 4 10,alignx right,growy, gapafter 60");
		
		JButton btCadastreseLogin = new JButton("Cadastre-se");
		btCadastreseLogin.setBackground(new Color(193, 151, 232));
		btCadastreseLogin.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		panel_2.add(btCadastreseLogin);
		btCadastreseLogin.setBorderPainted(false);
		

	}

}