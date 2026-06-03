package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

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
import javax.swing.border.EmptyBorder;

public class VisualizarMateriaPrima extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbIconeVoltar;
	private JPanel panel_materiaPrima, panel_marca, panel_cor, panel_UnidadeMedida, panel_QuantPorUnidade,
			panel_QuantDispo, panel_valor;
	private JLabel lbNomeMpCad;
	private JLabel lbMarcaCad;
	private JLabel lbUnMedCad;
	private JLabel lbQuantCad;
	private JLabel lbCorCad;
	private JLabel lbQuantUniCad;
	private JLabel lbValorCad;

	/**
	 * Create the panel.
	 */
	public VisualizarMateriaPrima() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1232, 700));
		setLayout(new MigLayout("gap 16", "[grow][][][][grow]", "[grow][][][][][][][][][grow]"));

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
		lbIconeVoltar.setIcon(new ImageIcon(VisualizarMateriaPrima.class.getResource("/imagensIcones/Icone_Seta2.png")));
		lbIconeVoltar.setToolTipText("Voltar");
		add(lbIconeVoltar, "pos 20 20,cell 0 0");

		JLabel lbMateriaPrima = new JLabel("Nome da Matéria Prima");
		lbMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMateriaPrima, "cell 2 1");

		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMarca, "cell 2 3");

		JLabel lbCor = new JLabel("Cor");
		lbCor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCor, "cell 3 3");

		JLabel lbUnidadeMed = new JLabel("Unidade de Medida");
		lbUnidadeMed.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbUnidadeMed, "flowx,cell 2 5");

		JLabel lbQtdUnidade = new JLabel("Quantidade Por Unidade");
		lbQtdUnidade.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdUnidade, "cell 3 5");

		JLabel lbQtdDisponivel = new JLabel("Quantidade Disponível");
		lbQtdDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdDisponivel, "flowx,cell 2 7");

		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValor, "cell 3 7");

		// PANELS

		panel_materiaPrima = new JPanel();
		panel_materiaPrima.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_materiaPrima, "cell 2 2,growx,width 35%,height 38!");
		panel_materiaPrima.setLayout(new MigLayout("", "[]", "[]"));

		lbNomeMpCad = new JLabel("");
		lbNomeMpCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_materiaPrima.add(lbNomeMpCad, "cell 0 0,alignx left");

		panel_marca = new JPanel();
		panel_marca.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_marca, "cell 2 4,width 35%,height 38!");
		panel_marca.setLayout(new MigLayout("", "[]", "[]"));

		lbMarcaCad = new JLabel("");
		lbMarcaCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_marca.add(lbMarcaCad, "cell 0 0,alignx left");

		panel_cor = new JPanel();
		panel_cor.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_cor, "cell 3 4,width 35%,height 38!");
		panel_cor.setLayout(new MigLayout("", "[]", "[]"));

		lbCorCad = new JLabel("");
		lbCorCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_cor.add(lbCorCad, "cell 0 0,alignx left");

		panel_UnidadeMedida = new JPanel();
		panel_UnidadeMedida.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_UnidadeMedida, "cell 2 6,width 35%,height 38!");
		panel_UnidadeMedida.setLayout(new MigLayout("", "[]", "[]"));

		lbUnMedCad = new JLabel("");
		lbUnMedCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_UnidadeMedida.add(lbUnMedCad, "cell 0 0,alignx left");

		panel_QuantPorUnidade = new JPanel();
		panel_QuantPorUnidade.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_QuantPorUnidade, "cell 3 6,width 35%,height 38!");
		panel_QuantPorUnidade.setLayout(new MigLayout("", "[]", "[]"));

		lbQuantUniCad = new JLabel("");
		lbQuantUniCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_QuantPorUnidade.add(lbQuantUniCad, "cell 0 0,alignx left");

		panel_QuantDispo = new JPanel();
		panel_QuantDispo.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_QuantDispo, "cell 2 8,width 35%,height 38!");
		panel_QuantDispo.setLayout(new MigLayout("", "[]", "[]"));

		lbQuantCad = new JLabel("");
		lbQuantCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_QuantDispo.add(lbQuantCad, "cell 0 0,alignx left");

		panel_valor = new JPanel();
		panel_valor.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_valor, "cell 3 8,growx,width 35%,height 38!");
		panel_valor.setLayout(new MigLayout("", "[]", "[]"));

		lbValorCad = new JLabel("");
		lbValorCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_valor.add(lbValorCad, "cell 0 0,alignx left");

	}

	public void voltar(MouseListener mouseListener) {
		this.lbIconeVoltar.addMouseListener(mouseListener);
	}

	public JLabel getLbIconeVoltar() {
		return lbIconeVoltar;
	}

	public void setLbIconeVoltar(JLabel lbIconeVoltar) {
		this.lbIconeVoltar = lbIconeVoltar;
	}

	public JLabel getLbNomeMpCad() {
		return lbNomeMpCad;
	}

	public void setLbNomeMpCad(JLabel lbNomeMpCad) {
		this.lbNomeMpCad = lbNomeMpCad;
	}

	public JLabel getLbMarcaCad() {
		return lbMarcaCad;
	}

	public void setLbMarcaCad(JLabel lbMarcaCad) {
		this.lbMarcaCad = lbMarcaCad;
	}

	public JLabel getLbUnMedCad() {
		return lbUnMedCad;
	}

	public void setLbUnMedCad(JLabel lbUnMedCad) {
		this.lbUnMedCad = lbUnMedCad;
	}

	public JLabel getLbQuantCad() {
		return lbQuantCad;
	}

	public void setLbQuantCad(JLabel lbQuantCad) {
		this.lbQuantCad = lbQuantCad;
	}

	public JLabel getLbCorCad() {
		return lbCorCad;
	}

	public void setLbCorCad(JLabel lbCorCad) {
		this.lbCorCad = lbCorCad;
	}

	public JLabel getLbQuantUniCad() {
		return lbQuantUniCad;
	}

	public void setLbQuantUniCad(JLabel lbQuantUniCad) {
		this.lbQuantUniCad = lbQuantUniCad;
	}

	public JLabel getLbValorCad() {
		return lbValorCad;
	}

	public void setLbValorCad(JLabel lbValorCad) {
		this.lbValorCad = lbValorCad;
	}

}