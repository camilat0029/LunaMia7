package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Mensagem extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JButton btOk;
	private JLabel lbMensagem;

	public Mensagem(Frame parent, String mensagem) {

		super(parent, true);

		setTitle("Informação");
		setResizable(false);

		getContentPane().setLayout(new BorderLayout());

		contentPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		contentPanel.setBackground(new Color(234, 219, 247));
		contentPanel.setLayout(new BorderLayout());

		getContentPane().add(contentPanel, BorderLayout.CENTER);

		lbMensagem = new JLabel(formatarMensagem(mensagem));

		lbMensagem.setHorizontalAlignment(SwingConstants.CENTER);

		lbMensagem.setFont(new Font("Times New Roman", Font.BOLD, 16));

		contentPanel.add(lbMensagem, BorderLayout.CENTER);

		setMinimumSize(new Dimension(330, 150));
		setLocationRelativeTo(parent);

		contentPanel.add(lbMensagem, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPane.setBackground(new Color(234, 219, 247));

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		btOk = new JButton("OK");

		btOk.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btOk.setBackground(new Color(193, 151, 232));
		btOk.setBorderPainted(false);

		btOk.setFocusPainted(false);

		btOk.addActionListener(e -> dispose());
		buttonPane.add(btOk);

		ImageIcon icone = new ImageIcon(getClass().getResource("/imagensIcones/Logo8.png"));
		setIconImage(icone.getImage());
		
		pack();

	}

	private String formatarMensagem(String mensagem) {

		mensagem = mensagem == null ? "" : mensagem;

		return "<html><div style='text-align: center;'>"
				+ mensagem.replace("\n", "<br>")
				+ "</div></html>";
	}
	
	public static void mostrar(Frame parent, String titulo, String mensagem) {

		Mensagem dialogo = new Mensagem(parent, mensagem);

		dialogo.setTitulo(titulo);

		dialogo.setVisible(true);
	}

	public void setMensagem(String mensagem) {
	    lbMensagem.setText(formatarMensagem(mensagem));
	}

	public void setTitulo(String titulo) {
		setTitle(titulo);
	}

	public void ok(ActionListener actionListener) {
		btOk.addActionListener(actionListener);
	}

}