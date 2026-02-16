package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeComp;
	private JTextField tfNomeUsuario;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JTextField tfSenha;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[][][][][][grow][][]", "[][][][][][][][][][][grow][][]"));
		
		JLabel lbLunaMia = new JLabel("Luna & Mia");
		lbLunaMia.setFont(new Font("Dialog", Font.PLAIN, 99));
		add(lbLunaMia, "cell 2 2 4 1");
		
		JLabel lbNomeComp = new JLabel("Nome Completo");
		lbNomeComp.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(lbNomeComp, "cell 2 4");
		
		tfNomeComp = new JTextField();
		tfNomeComp.setFont(new Font("Dialog", Font.PLAIN, 18));
		add(tfNomeComp, "cell 4 4 2 1,growx");
		tfNomeComp.setColumns(10);
		
		JLabel lbNomeUsuario = new JLabel("Nome de Usuário");
		lbNomeUsuario.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(lbNomeUsuario, "cell 2 5");
		
		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setFont(new Font("Dialog", Font.PLAIN, 18));
		add(tfNomeUsuario, "cell 4 5 2 1,growx");
		tfNomeUsuario.setColumns(10);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(lbEmail, "cell 2 6");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		add(tfEmail, "cell 4 6 2 1,growx");
		tfEmail.setColumns(10);
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(lbTelefone, "cell 2 7");
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Dialog", Font.PLAIN, 18));
		add(tfTelefone, "cell 4 7 2 1,growx");
		tfTelefone.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(lbSenha, "cell 2 8");
		
		tfSenha = new JTextField();
		tfSenha.setFont(new Font("Dialog", Font.PLAIN, 18));
		add(tfSenha, "cell 4 8 2 1,growx");
		tfSenha.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 10 4 1,grow");
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setFont(new Font("Dialog", Font.PLAIN, 20));
		btCadastrar.setBackground(new Color(193, 151, 232));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);

	}

}
