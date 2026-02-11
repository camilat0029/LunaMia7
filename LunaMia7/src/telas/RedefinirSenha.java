package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class RedefinirSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField pfSenha;
	private JPasswordField pfNovaSenha;
	private JLabel lbConfirmarNovaSenha;
	private JPasswordField pfConfirmarNovaSenha;
	private JPanel panel;
	private JButton btSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RedefinirSenha frame = new RedefinirSenha();
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
	public RedefinirSenha() {
		setBackground(new Color(234, 219, 247));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(234, 219, 247));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][][][30][][30][30][30][][30][30][40.00,grow]"));
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbSenha, "cell 2 1,alignx center,aligny center");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(pfSenha, "cell 2 2,growx");
		
		JLabel lbNovaSenha = new JLabel("Nova Senha");
		lbNovaSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbNovaSenha, "cell 2 4,alignx center,aligny center");
		
		pfNovaSenha = new JPasswordField();
		pfNovaSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(pfNovaSenha, "cell 2 5,growx");
		
		lbConfirmarNovaSenha = new JLabel("Confirmar a nova senha");
		lbConfirmarNovaSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		contentPane.add(lbConfirmarNovaSenha, "cell 2 7,alignx center");
		
		pfConfirmarNovaSenha = new JPasswordField();
		pfConfirmarNovaSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 18));
		contentPane.add(pfConfirmarNovaSenha, "cell 2 8,growx");
		
		panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		contentPane.add(panel, "cell 2 10,grow");
		
		btSalvar = new JButton("Salvar");
		btSalvar.setBackground(new Color(193, 151, 232));
		btSalvar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel.add(btSalvar);
		
		btSalvar.setBorderPainted(false);

	}

}
