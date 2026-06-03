package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolTip;

import java.awt.Font;
import java.awt.Image;
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
		setLayout(new MigLayout("gapy 16, gapx 50", "[grow][][][grow]", "[grow][][][][][][][][][][grow]"));

		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "flowx,cell 0 0");

		lbIconeVoltar = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.BOLD, 15));
				return tooltip;
			}
		};
		lbIconeVoltar.setToolTipText("Voltar");
		lbIconeVoltar.setIcon(new ImageIcon(CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Seta2.png")));
		add(lbIconeVoltar, "pos 20 20");

		JLabel lbMateriaPrima = new JLabel("Nome da Matéria Prima");
		lbMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMateriaPrima, "cell 1 1");

		tfNomeMateriaPrima = new JTextField();
		tfNomeMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfNomeMateriaPrima, "cell 1 2 2 1,growx");
		tfNomeMateriaPrima.setColumns(10);

		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMarca, "cell 1 3");

		JLabel lbCor = new JLabel("Cor");
		lbCor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCor, "cell 2 3");

		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfMarca, "cell 1 4,growx");
		tfMarca.setColumns(10);

		tfCor = new JTextField();
		tfCor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfCor, "cell 2 4,growx");
		tfCor.setColumns(10);

		JLabel lbUnidadeMed = new JLabel("Unidade de Medida");
		lbUnidadeMed.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbUnidadeMed, "flowx,cell 1 5");

		JLabel lbQtdUnidade = new JLabel("Quantidade Por Unidade");
		lbQtdUnidade.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdUnidade, "cell 2 5");

		cbUnidadeMedida = new JComboBox<>(model.MateriaPrima.UnidadeMedida.values());
		cbUnidadeMedida.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(cbUnidadeMedida, "cell 1 6,growx");

		tfQtdUnidade = new JTextField();
		tfQtdUnidade.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfQtdUnidade, "cell 2 6,growx");
		tfQtdUnidade.setColumns(10);

		JLabel lbQtdDisponivel = new JLabel("Quantidade Disponível");
		lbQtdDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdDisponivel, "flowx,cell 1 7");

		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValor, "cell 2 7");

		tfQtdDisponivel = new JTextField();
		tfQtdDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfQtdDisponivel, "cell 1 8,growx");
		tfQtdDisponivel.setColumns(10);

		tfValor = new JTextField();
		tfValor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfValor, "cell 2 8,growx");
		tfValor.setColumns(10);

		btConfirmar = new JButton("Confirmar");
		add(btConfirmar, "cell 1 9 2 1,alignx center,aligny center");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));

		btConfirmar.setBorderPainted(false);
		btConfirmar.setFocusPainted(false);

		JLabel interrogacaoQntDisponivel = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		interrogacaoQntDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		add(interrogacaoQntDisponivel, "cell 1 7");

		ImageIcon iconInterrogacao = new ImageIcon(
				CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png"));

		Image imgInterrogacao = iconInterrogacao.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		interrogacaoQntDisponivel.setIcon(new ImageIcon(imgInterrogacao));

		JLabel interrogacaoQntUnidade = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		interrogacaoQntUnidade.setIcon(
				new ImageIcon(CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png")));
		add(interrogacaoQntUnidade, "flowy,cell 2 5");

		ImageIcon iconInterrogacao2 = new ImageIcon(
				CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png"));

		Image imgInterrogacao2 = iconInterrogacao2.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);

		interrogacaoQntUnidade.setIcon(new ImageIcon(imgInterrogacao2));

		interrogacaoQntDisponivel.setToolTipText(
				"<html>Informe a quantidade <br> disponível em relação às unidades. <br> Por exemplo: se tem cinco novelos de lã.</html> ");

		interrogacaoQntUnidade.setToolTipText(
				"<html>Informe a quantidade <br> disponível em relação à <br> unidade de medida. <br> Por exemplo: uma linha <br> que possua 8 metros.</html>");

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

	public JButton getBtConfirmar() {
		return btConfirmar;
	}

	public void setBtConfirmar(JButton btConfirmar) {
		this.btConfirmar = btConfirmar;
	}
	
	

}