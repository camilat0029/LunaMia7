package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class VisualizarMateriaPrima extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbIconeVoltar;
	private JPanel panel_materiaPrima, panel_marca, panel_cor, panel_UnidadeMedida, panel_QuantPorUnidade,
			panel_QuantDispo, panel_valor;
	

	/**
	 * Create the panel.
	 */
	public VisualizarMateriaPrima() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020, 700));
		setLayout(new MigLayout("gap 16", "[grow][][][][grow]", "[grow][][][][][][][][][grow]"));

		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "flowx,cell 0 0");

		lbIconeVoltar = new JLabel("");
		lbIconeVoltar
				.setIcon(new ImageIcon(VisualizarMateriaPrima.class.getResource("/imagensIcones/Icone_Seta2.png")));
		add(lbIconeVoltar, "pos 20 20");

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

		//PANELS
		
		panel_materiaPrima = new JPanel();
		add(panel_materiaPrima, "cell 2 2 2 1,growx,width 71%,height 38!");

		panel_marca = new JPanel();
		add(panel_marca, "cell 2 4,width 71%,height 38!");

		panel_cor = new JPanel();
		add(panel_cor, "cell 3 4,width 71%,height 38!");

		panel_UnidadeMedida = new JPanel();
		add(panel_UnidadeMedida, "cell 2 6,width 71%,height 38!");

		panel_QuantPorUnidade = new JPanel();
		add(panel_QuantPorUnidade, "cell 3 6,width 71%,height 38!");

		panel_QuantDispo = new JPanel();
		add(panel_QuantDispo, "cell 2 8,width 71%,height 38!");

		panel_valor = new JPanel();
		add(panel_valor, "cell 3 8,growx,width 71%,height 38!");

	}

	public void voltar(MouseListener mouseListener) {
		this.lbIconeVoltar.addMouseListener(mouseListener);
	}

}
