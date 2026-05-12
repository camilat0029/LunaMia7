package view;

import javax.swing.JPanel;
import java.awt.Color;
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
		setLayout(new MigLayout("", "[grow][][][][][grow]", "[grow][][][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel, "flowx,cell 0 0");
		
		JLabel lbMateriaPrima = new JLabel("Nome da Matéria Prima");
		lbMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMateriaPrima, "cell 2 1");
		
		tfNomeMateriaPrima = new JTextField();
		tfNomeMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfNomeMateriaPrima, "cell 2 2 3 1,growx");
		tfNomeMateriaPrima.setColumns(10);
		
		JLabel lbValor = new JLabel("Valor");
		lbValor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValor, "cell 2 3");
		
				tfValor = new JTextField();
		tfValor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfValor, "cell 2 4 3 1,growx");
		tfValor.setColumns(10);
		
		JLabel lbMarca = new JLabel("Marca");
		lbMarca.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMarca, "cell 2 5");
		
		JLabel lbCor = new JLabel("Cor");
		lbCor.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCor, "cell 4 5");
		
		tfMarca = new JTextField();
		tfMarca.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfMarca, "cell 2 6,growx");
		tfMarca.setColumns(10);
		
		tfCor = new JTextField();
		tfCor.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfCor, "cell 4 6,growx");
		tfCor.setColumns(10);
		
		JLabel lbUnidadeMed = new JLabel("Unidade de Medida");
		lbUnidadeMed.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbUnidadeMed, "flowx,cell 2 7");		
		
		JLabel lbQtdUnidade = new JLabel("Quantidade Por Unidade");
		lbQtdUnidade.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdUnidade, "cell 4 7");
		
		cbUnidadeMedida = new JComboBox<>(model.MateriaPrima.UnidadeMedida.values());		
		cbUnidadeMedida.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(cbUnidadeMedida, "cell 2 8,growx");
		
		tfQtdUnidade = new JTextField();
		tfQtdUnidade.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfQtdUnidade, "cell 4 8,growx");
		tfQtdUnidade.setColumns(10);
		
		JLabel lbQtdDisponivel = new JLabel("Quantidade Disponível");
		lbQtdDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQtdDisponivel, "flowx,cell 2 9");
		
		tfQtdDisponivel = new JTextField();
		tfQtdDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfQtdDisponivel, "cell 2 10,growx");
		tfQtdDisponivel.setColumns(10);
		
		lbIconeVoltar = new JLabel("");
		lbIconeVoltar.setIcon(new ImageIcon(CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Seta2.png")));
		add(lbIconeVoltar, "cell 0 0");
		
		btConfirmar = new JButton("Confirmar");
		add(btConfirmar, "cell 2 11 3 1,alignx center,aligny center");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		btConfirmar.setBorderPainted(false);
		
		JLabel interrogacaoQntDisponivel = new JLabel("");
		interrogacaoQntDisponivel.setFont(new Font("Times New Roman", Font.PLAIN, 5));	
		add(interrogacaoQntDisponivel, "cell 2 9");
		
		ImageIcon iconInterrogacao = new ImageIcon(
		        CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png")
		);

		Image imgInterrogacao = iconInterrogacao.getImage().getScaledInstance(
		        18,
		        18,
		        Image.SCALE_SMOOTH
		);
		interrogacaoQntDisponivel.setIcon(new ImageIcon(imgInterrogacao));
		
		
		JLabel interrogacaoQntUnidade = new JLabel("");
		interrogacaoQntUnidade.setIcon(new ImageIcon(CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png")));
		add(interrogacaoQntUnidade, "flowy,cell 4 7");
		
		ImageIcon iconInterrogacao2 = new ImageIcon(
		        CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png")
		);

		Image imgInterrogacao2 = iconInterrogacao2.getImage().getScaledInstance(
		        18,
		        18,
		        Image.SCALE_SMOOTH
		);

		interrogacaoQntUnidade.setIcon(new ImageIcon(imgInterrogacao2));
		
		interrogacaoQntDisponivel.setToolTipText("<html>Informe a quantidade <br> disponível em relação às unidades. <br> Por exemplo: se tem cinco novelos de lã.</html> ");
		
		interrogacaoQntUnidade.setToolTipText("<html>Informe a quantidade <br> disponível em relação à <br> unidade de medida. <br> Por exemplo: uma linha <br> que possua 8 metros.</html>" );
	
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
