package view;

import javax.swing.JPanel;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class CriarOrcamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tituloOrcamentoCO;
	private JTextField tfNomeClienteCO;
	private JTextField tfEmailCO;
	private JTextField tfContatoCO;
	private JTextField tfPrecoHoraCO;
	private JTextField tfPercentualLucroCO;
	private JTextField tfHorasPrevistas;
	private JTextField tfQuantMaxDiasCO;

	/**
	 * Create the panel.
	 */
	public CriarOrcamento() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lbTituloOrcamento = new JLabel("Título do orçamento");
		lbTituloOrcamento.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTituloOrcamento, "cell 2 1 3 1");
		
		tituloOrcamentoCO = new JTextField();
		tituloOrcamentoCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tituloOrcamentoCO, "cell 2 2 3 1,growx");
		tituloOrcamentoCO.setColumns(10);
		
		JLabel lbNomeCliente = new JLabel("Nome do cliente");
		lbNomeCliente.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeCliente, "cell 2 4");
		
		tfNomeClienteCO = new JTextField();
		tfNomeClienteCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfNomeClienteCO.setColumns(10);
		add(tfNomeClienteCO, "cell 2 5 3 1,growx");
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmail, "cell 2 7");
		
		JLabel lbContato = new JLabel("Contato");
		lbContato.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbContato, "cell 4 7");
		
		tfEmailCO = new JTextField();
		tfEmailCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfEmailCO.setColumns(10);
		add(tfEmailCO, "cell 2 8,growx");
		
		tfContatoCO = new JTextField();
		tfContatoCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfContatoCO.setColumns(10);
		add(tfContatoCO, "cell 4 8,growx");
		
		JLabel lbPrecoHora = new JLabel("Preço da hora");
		lbPrecoHora.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPrecoHora, "cell 2 10");
		
		JLabel lbPercentualLucro = new JLabel("Percentual de lucro");
		lbPercentualLucro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPercentualLucro, "cell 4 10");
		
		tfPrecoHoraCO = new JTextField();
		tfPrecoHoraCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfPrecoHoraCO.setColumns(10);
		add(tfPrecoHoraCO, "cell 2 11,growx");
		
		tfPercentualLucroCO = new JTextField();
		tfPercentualLucroCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		tfPercentualLucroCO.setColumns(10);
		add(tfPercentualLucroCO, "cell 4 11,growx");
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lblMateriais, "cell 2 13");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 14,grow");
		
		JComboBox cbMateriaisCO = new JComboBox();
		cbMateriaisCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		panel.add(cbMateriaisCO);
		
		JLabel lbHorasPrevistas = new JLabel("Horas previstas");
		lbHorasPrevistas.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbHorasPrevistas, "cell 2 16");
		
		JLabel lbQuantMaxDiasCO = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDiasCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lbQuantMaxDiasCO, "cell 4 16");
		
		tfHorasPrevistas = new JTextField();
		tfHorasPrevistas.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfHorasPrevistas.setColumns(10);
		add(tfHorasPrevistas, "cell 2 17,growx");
		
		tfQuantMaxDiasCO = new JTextField();
		tfQuantMaxDiasCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfQuantMaxDiasCO.setColumns(10);
		add(tfQuantMaxDiasCO, "cell 4 17,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 3 19,grow");
		
		JButton btCalcularCO = new JButton("Calcular");
		btCalcularCO.setBackground(new Color(193, 151, 232));
		btCalcularCO.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_1.add(btCalcularCO);
		btCalcularCO.setBorderPainted(false);

	}

}
