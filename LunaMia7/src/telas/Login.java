package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JPasswordField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 706, 571);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 219, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[126px,grow][25px][][][][112px,grow]", "[14px,grow][33px][14px][33px][30.00px][25.00][][30.00][30.00][37.00][25.00][23px,grow]"));
		
		JLabel lbLunaEMia = new JLabel("Luna & Mia");
		lbLunaEMia.setFont(new Font("David Libre", Font.PLAIN, 80));
		contentPane.add(lbLunaEMia, "cell 1 1 4 1,alignx center,aligny center");
		
		JLabel lbUsuario = new JLabel("Usuário");
		lbUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbUsuario, "cell 1 3 4 1,alignx center,aligny center");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(tfUsuario, "cell 1 4 4 1,growx");
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lblNewLabel_2, "cell 1 6 4 1,alignx center,aligny center");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(pfSenha, "cell 1 7 4 1,growx");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		contentPane.add(panel, "cell 1 9 4 1,growx,aligny center");
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.setBackground(new Color(193, 151, 232));
		btEntrar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel.add(btEntrar);
		btEntrar.setBorderPainted(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(234, 219, 247));
		contentPane.add(panel_3, "cell 1 10 3 1,growx,aligny center");
		
		JLabel lblNewLabel = new JLabel("Não tem uma conta?");
		lblNewLabel.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 15));
		panel_3.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		contentPane.add(panel_1, "cell 4 10,alignx right,growy");
		
		JButton btCadastrase = new JButton("Cadrastre-se");
		btCadastrase.setBackground(new Color(193, 151, 232));
		btCadastrase.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 16));
		panel_1.add(btCadastrase);
		btCadastrase.setBorderPainted(false);

	}
}
