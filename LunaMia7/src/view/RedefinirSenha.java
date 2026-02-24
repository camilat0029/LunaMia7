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

public class RedefinirSenha extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField pfNovaSenhaRS;
	private JPasswordField pfSenhaRS;
	private JPasswordField pfConfirmarNovaSenhaRS;

	/**
	 * Create the panel.
	 */
	public RedefinirSenha() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[][grow][][grow][]", "[][][][][][][][][][][grow][]"));
		
		JLabel lbSenhaRS = new JLabel("Senha");
		lbSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbSenhaRS, "cell 1 1 3 1,alignx center");
		
		pfSenhaRS = new JPasswordField();
		pfSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(pfSenhaRS, "cell 1 2 3 1,growx");
		
		JLabel lbNovaSenhaRS = new JLabel("Nova Senha");
		lbNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNovaSenhaRS, "cell 1 4 3 1,alignx center");
		
		pfNovaSenhaRS = new JPasswordField();
		pfNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(pfNovaSenhaRS, "cell 1 5 3 1,growx");
		
		JLabel lbConfirmarNovaSenhaRS = new JLabel("Confirmar nova senha");
		lbConfirmarNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbConfirmarNovaSenhaRS, "cell 1 7 3 1,alignx center");
		
		pfConfirmarNovaSenhaRS = new JPasswordField();
		pfConfirmarNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(pfConfirmarNovaSenhaRS, "cell 1 8 3 1,growx");
		
		JPanel panelCancelarRS = new JPanel();
		panelCancelarRS.setBackground(new Color(234, 219, 247));
		add(panelCancelarRS, "cell 1 10,grow");
		
		JButton btCancelarRS = new JButton("Cancelar");
		btCancelarRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCancelarRS.setBackground(new Color(193, 151, 232));
		btCancelarRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		panelCancelarRS.add(btCancelarRS);
		btCancelarRS.setBorderPainted(false);
		
		JPanel panelConfirmarRS = new JPanel();
		panelConfirmarRS.setBackground(new Color(234, 219, 247));
		add(panelConfirmarRS, "cell 3 10,grow");
		
		JButton btConfirmarRS = new JButton("Confirmar");
		btConfirmarRS.setBackground(new Color(193, 151, 232));
		btConfirmarRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btConfirmarRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelConfirmarRS.add(btConfirmarRS);
		btConfirmarRS.setBorderPainted(false);
		

	}

}
