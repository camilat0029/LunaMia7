package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RedefinirSenhaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField pfNovaSenha;
	private JPasswordField pfSenha;
	private JPasswordField pfConfirmarNovaSenha;

	/**
	 * Create the panel.
	 */
	public RedefinirSenhaPanel() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[][grow][][grow][]", "[][][][][][][][][][][grow][]"));
		
		JLabel lblNewLabel = new JLabel("Senha");
		lblNewLabel.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblNewLabel, "cell 1 1 3 1,alignx center");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(pfSenha, "cell 1 2 3 1,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Nova Senha");
		lblNewLabel_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblNewLabel_1, "cell 1 4 3 1,alignx center");
		
		pfNovaSenha = new JPasswordField();
		pfNovaSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(pfNovaSenha, "cell 1 5 3 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Confirmar nova senha");
		lblNewLabel_2.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblNewLabel_2, "cell 1 7 3 1,alignx center");
		
		pfConfirmarNovaSenha = new JPasswordField();
		pfConfirmarNovaSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(pfConfirmarNovaSenha, "cell 1 8 3 1,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 1 10,grow");
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCancelar.setBackground(new Color(193, 151, 232));
		btCancelar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel_1.add(btCancelar);
		btCancelar.setBorderPainted(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 3 10,grow");
		
		JButton btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btConfirmar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel.add(btConfirmar);
		btConfirmar.setBorderPainted(false);
		

	}

}
