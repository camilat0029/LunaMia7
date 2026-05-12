package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CadastroMateriaPrimaEstoque extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeMateriaPrima;
	private JTextField tfValor;
	private JTextField tfQtdDisponivel;
	private JTextField tfMarca;
	private JTextField tfCor;
	private JTextField tfQtdUnidade;
	private JLabel lbIconeVoltar;
	JButton btConfirmar;
	
	private JComboBox<model.MateriaPrima.UnidadeMedida> cbUnidadeMedida;

	/**
	 * Create the panel.
	 */
	public CadastroMateriaPrimaEstoque() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][][][][grow]", "[grow][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "flowx,cell 0 0");
		
		JLabel lbNomeProduto = new JLabel("Nome do Produto");
		lbNomeProduto.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeProduto, "cell 2 1");
		
		tfNomeMateriaPrima = new JTextField();
		tfNomeMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfNomeMateriaPrima, "cell 2 2 3 1,growx");
		tfNomeMateriaPrima.setColumns(10);
		
		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValor, "cell 2 4");
		
				tfValor = new JTextField();
		tfValor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfValor, "cell 2 5 3 1,growx");
		tfValor.setColumns(10);
		
		JLabel lbQtdDisponivel = new JLabel("Quantidade Disponível");
		lbQtdDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdDisponivel, "cell 2 7");
		
		tfQtdDisponivel = new JTextField();
		tfQtdDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfQtdDisponivel, "cell 2 8,growx");
		tfQtdDisponivel.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMarca, "cell 2 10");
		
		JLabel lbCor = new JLabel("Cor");
		lbCor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCor, "cell 4 10");
		
		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfMarca, "cell 2 11,growx");
		tfMarca.setColumns(10);
		
		tfCor = new JTextField();
		tfCor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfCor, "cell 4 11,growx");
		tfCor.setColumns(10);
		
		JLabel lbUnidadeMed = new JLabel("Unidade de Medida");
		lbUnidadeMed.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbUnidadeMed, "cell 2 13");
		
		JLabel lbQtdUnidade = new JLabel("Quantidade Por Unidade");
		lbQtdUnidade.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdUnidade, "cell 4 13");
		
		cbUnidadeMedida = new JComboBox<>(model.MateriaPrima.UnidadeMedida.values());		
		cbUnidadeMedida.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(cbUnidadeMedida, "cell 2 14,growx");
		
		tfQtdUnidade = new JTextField();
		tfQtdUnidade.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfQtdUnidade, "cell 4 14,growx");
		tfQtdUnidade.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 16 3 1,grow");
		
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel.add(btConfirmar);
		
		btConfirmar.setBorderPainted(false);
		
		lbIconeVoltar = new JLabel("");
		lbIconeVoltar.setIcon(new ImageIcon(CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Seta2.png")));
		add(lbIconeVoltar, "cell 0 0");

	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbIconeVoltar.addMouseListener(mouseListener);
	}
	
	public void confirmar(ActionListener actionListener) {
		this.btConfirmar.addActionListener(actionListener);
	}

	public JTextField getTfNomeMateriaPrima() {
		return tfNomeMateriaPrima;
	}

	public void setTfNomeMateriaPrima(JTextField tfNomeMateriaPrima) {
		this.tfNomeMateriaPrima = tfNomeMateriaPrima;
	}

	public JTextField getTfValor() {
		return tfValor;
	}

	public void setTfValor(JTextField tfValor) {
		this.tfValor = tfValor;
	}

	public JTextField getTfQtdDisponivel() {
		return tfQtdDisponivel;
	}

	public void setTfQtdDisponivel(JTextField tfQtdDisponivel) {
		this.tfQtdDisponivel = tfQtdDisponivel;
	}

	public JTextField getTfMarca() {
		return tfMarca;
	}

	public void setTfMarca(JTextField tfMarca) {
		this.tfMarca = tfMarca;
	}

	public JTextField getTfCor() {
		return tfCor;
	}

	public void setTfCor(JTextField tfCor) {
		this.tfCor = tfCor;
	}

	public JTextField getTfQtdUnidade() {
		return tfQtdUnidade;
	}

	public void setTfQtdUnidade(JTextField tfQtdUnidade) {
		this.tfQtdUnidade = tfQtdUnidade;
	}

	public JComboBox<model.MateriaPrima.UnidadeMedida> getCbUnidadeMedida() {
		return cbUnidadeMedida;
	}

	public void setCbUnidadeMedida(JComboBox<model.MateriaPrima.UnidadeMedida> cbUnidadeMedida) {
		this.cbUnidadeMedida = cbUnidadeMedida;
	}
	
}
