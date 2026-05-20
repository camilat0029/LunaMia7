package view;

import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

public class BotoesMateriaPrima extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btVisualizar, btEditar, btExcluir;

	/**
	 * Create the panel.
	 */
	public BotoesMateriaPrima() {
		setBackground(new Color(239, 239, 239));

		setPreferredSize(new Dimension(200, 640));
		setMinimumSize(new Dimension(200, 640)); // Tamanho minimo
		setLayout(new MigLayout("gap 18", "[][][]", "[grow][][][][grow]"));

		btVisualizar = new JButton("Visualizar");
		btVisualizar.setBackground(new Color(193, 151, 232));
		btVisualizar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btVisualizar, "cell 1 1,growx");
		btVisualizar.setBorderPainted(false);

		btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btEditar.setBackground(new Color(193, 151, 232));
		add(btEditar, "cell 1 2,growx");
		btEditar.setBorderPainted(false);

		btExcluir = new JButton("Excluir");
		btExcluir.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btExcluir.setBackground(new Color(193, 151, 232));
		add(btExcluir, "cell 1 3,growx");
		btExcluir.setBorderPainted(false);

	}
	
	public void visualizar(ActionListener actionListener) {
		btVisualizar.addActionListener(actionListener);
	}
	public void editar(ActionListener actionListener) {
		btEditar.addActionListener(actionListener);
	}
	public void excluir(ActionListener actionListener) {
		btExcluir.addActionListener(actionListener);
	}
-
}
