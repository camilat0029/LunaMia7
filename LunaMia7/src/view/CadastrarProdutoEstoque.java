package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CadastrarProdutoEstoque extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeProduto;
	private JTextField tfValor;
	private JTextField tfQtdDisponivel;
	private JTextField tfMarca;
	private JTextField tfCor;
	private JTextField tfQtdUnidade;

	/**
	 * Create the panel.
	 */
	public CadastrarProdutoEstoque() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][][][][grow]", "[grow][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "flowx,cell 0 0");
		
		JLabel lbNomeProduto = new JLabel("Nome do Produto");
		lbNomeProduto.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeProduto, "cell 2 1");
		
		tfNomeProduto = new JTextField();
		tfNomeProduto.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfNomeProduto, "cell 2 2 3 1,growx");
		tfNomeProduto.setColumns(10);
		
		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValor, "cell 2 4");
		
		tfValor = new JTextField();
		tfValor.setText("R$");
		tfValor.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfValor, "cell 2 5 3 1,growx");
		tfValor.setColumns(10);
		
		JLabel lbQtdDisponivel = new JLabel("Quantidade Disponível");
		lbQtdDisponivel.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbQtdDisponivel, "cell 2 7");
		
		tfQtdDisponivel = new JTextField();
		tfQtdDisponivel.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfQtdDisponivel, "cell 2 8,growx");
		tfQtdDisponivel.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbMarca, "cell 2 10");
		
		JLabel lbCor = new JLabel("Cor");
		lbCor.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbCor, "cell 4 10");
		
		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfMarca, "cell 2 11,growx");
		tfMarca.setColumns(10);
		
		tfCor = new JTextField();
		tfCor.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfCor, "cell 4 11,growx");
		tfCor.setColumns(10);
		
		JLabel lbUnidadeMed = new JLabel("Unidade de Medida");
		lbUnidadeMed.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbUnidadeMed, "cell 2 13");
		
		JLabel lbQtdUnidade = new JLabel("Quantidade Por Unidade");
		lbQtdUnidade.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbQtdUnidade, "cell 4 13");
		
		JComboBox cbUnidadeMed = new JComboBox();
		cbUnidadeMed.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(cbUnidadeMed, "cell 2 14,growx");
		
		
		
		tfQtdUnidade = new JTextField();
		tfQtdUnidade.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfQtdUnidade, "cell 4 14,growx");
		tfQtdUnidade.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 16 3 1,grow");
		
		JButton btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel.add(btConfirmar);
		
		btConfirmar.setBorderPainted(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastrarProdutoEstoque.class.getResource("/imagensIcones/Icone_Seta2.png")));
		add(lblNewLabel_1, "cell 0 0");

	}

}
