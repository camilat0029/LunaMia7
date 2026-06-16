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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MensagemSimNao extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JButton btSim;
	private JLabel lbMensagem;
	private JButton btNao;
	private int resposta = JOptionPane.NO_OPTION;

	public MensagemSimNao(Frame parent, String mensagem) {

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

		setMinimumSize(new Dimension(330, 150));
		setLocationRelativeTo(parent);

		contentPanel.add(lbMensagem, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPane.setBackground(new Color(234, 219, 247));

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		btSim = new JButton("Sim");

		btSim.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btSim.setBackground(new Color(193, 151, 232));
		btSim.setBorderPainted(false);

		// ISSO AQUI NÃO DEIXA COM AQUELE RISCO AZUL AO REDOR
		btSim.setFocusPainted(false);

		btSim.addActionListener(e -> {

			resposta = JOptionPane.YES_OPTION;
			dispose();
		});

		buttonPane.add(btSim);

		btNao = new JButton("Não");
		btNao.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btNao.setFocusPainted(false);
		btNao.setBorderPainted(false);
		btNao.setBackground(new Color(193, 151, 232));
		btNao.setFocusPainted(false);

		btNao.addActionListener(e -> {

			resposta = JOptionPane.NO_OPTION;
			dispose();
			
		});

		buttonPane.add(btNao);

		ImageIcon icone = new ImageIcon(getClass().getResource("/imagensIcones/Logo8.png"));
		setIconImage(icone.getImage());
		
		pack();

	}

	private String formatarMensagem(String mensagem) {

		mensagem = mensagem == null ? "" : mensagem;

		return "<html><div style='text-align: center;'>" + mensagem.replace("\n", "<br>") + "</div></html>";
	}

	public static int mostrar(Frame parent, String titulo, String mensagem) {

		MensagemSimNao dialogo = new MensagemSimNao(parent, mensagem);

		dialogo.setTitulo(titulo);

		dialogo.setVisible(true);

		return dialogo.resposta;
	}

	public void setMensagem(String mensagem) {
		lbMensagem.setText(formatarMensagem(mensagem));
	}

	public void setTitulo(String titulo) {
		setTitle(titulo);
	}

	public void sim(ActionListener actionListener) {
		btSim.addActionListener(actionListener);
	}

	public void nao(ActionListener actionListener) {
		btNao.addActionListener(actionListener);
	}

}