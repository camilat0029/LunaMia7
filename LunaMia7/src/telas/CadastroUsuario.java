package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfUsuario;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JTextField tfSenha;
	private JPanel panel;
	private JButton btCadastrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public CadastroUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 573);
		
		setLocationRelativeTo(null);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 219, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][][][][grow]", "[grow][][116.00][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Luna & Mia");
		lblNewLabel.setFont(new Font("David Libre", Font.PLAIN, 99));
		contentPane.add(lblNewLabel, "cell 2 2 4 1");
		
		JLabel lbNomeComp = new JLabel("Nome Completo");
		lbNomeComp.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbNomeComp, "cell 2 4");
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(tfNome, "cell 4 4 2 1,growx");
		tfNome.setColumns(10);
		
		JLabel lbNomeUsuario = new JLabel("Nome de Usuário");
		lbNomeUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbNomeUsuario, "cell 2 5");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(tfUsuario, "cell 4 5 2 1,growx");
		tfUsuario.setColumns(10);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbEmail, "cell 2 6");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(tfEmail, "cell 4 6 2 1,growx");
		tfEmail.setColumns(10);
		
		JLabel lbtelefone = new JLabel("Telefone");
		lbtelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbtelefone, "cell 2 7");
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(tfTelefone, "cell 4 7 2 1,growx");
		tfTelefone.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbSenha, "cell 2 8");
		
		tfSenha = new JTextField();
		tfSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(tfSenha, "cell 4 8 2 1,growx");
		tfSenha.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		contentPane.add(panel, "cell 2 10 4 1,grow");
		
		btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBackground(new Color(193, 151, 232));
		btCadastrar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);

	}
	
}
