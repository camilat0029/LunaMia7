package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][][][][grow]", "[grow][][][][][][][][][][][grow]"));
		
		JLabel lbLunaEMia = new JLabel("Luna & Mia");
		lbLunaEMia.setFont(new Font("Constantia", Font.PLAIN, 80));
		add(lbLunaEMia, "cell 1 1 4 1,alignx center,aligny center");
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lbUsuario, "cell 1 2 4 1,alignx center");
		
		textField = new JTextField();
		textField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		textField.setColumns(10);
		add(textField, "cell 1 3 4 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblNewLabel_2, "cell 1 5 4 1,alignx center");
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		add(passwordField, "cell 1 6 4 1,growx");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 1 8 4 1,grow");
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.setBackground(new Color(193, 151, 232));
		btEntrar.setForeground(new Color(0, 0, 0));
		btEntrar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel.add(btEntrar);
		btEntrar.setBorderPainted(false);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 1 10 2 1,alignx left,growy");
		
		JLabel lblNewLabel = new JLabel("Não tem conta?");
		lblNewLabel.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 3 10 2 1,alignx right,growy");
		
		JButton btCadastrese = new JButton("Cadastre-se");
		btCadastrese.setBackground(new Color(193, 151, 232));
		btCadastrese.setFont(new Font("Bodoni MT", Font.PLAIN, 18));
		panel_2.add(btCadastrese);
		btCadastrese.setBorderPainted(false);
		

	}

}