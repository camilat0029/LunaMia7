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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CriarOrcamentoAposCalcular extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfTituloOrcamentoCOAC;
	private JTextField textField;
	private JTextField tfEmailCOAC;
	private JTextField tfContatoCOAC;
	private JTextField tfPrecoHoraCOAC;
	private JTextField tfPercentualLucroCOAC;
	private JTextField tfHorasPrevistasCOAC;
	private JTextField tfQuantMaxDiasCOAC;
	private JTextField tfValorSemLucroCOAC;
	private JTextField tfValorDoLucroCOAC;
	private JTextField tfTotalDeGastos;
	private JTextField tfValorDeVendaCOAC;

	/**
	 * Create the panel.
	 */
	public CriarOrcamentoAposCalcular() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lbTituloOrcamentoCOAC = new JLabel("Título do orçamento");
		lbTituloOrcamentoCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTituloOrcamentoCOAC, "cell 2 1 3 1");
		
		tfTituloOrcamentoCOAC = new JTextField();
		tfTituloOrcamentoCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfTituloOrcamentoCOAC, "cell 2 2 3 1,growx");
		tfTituloOrcamentoCOAC.setColumns(10);
		
		JLabel lbNomeClienteCOAC = new JLabel("Nome do cliente");
		lbNomeClienteCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeClienteCOAC, "cell 2 4");
		
		textField = new JTextField();
		textField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField.setColumns(10);
		add(textField, "cell 2 5 3 1,growx");
		
		JLabel lbEmailCOAC = new JLabel("Email");
		lbEmailCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmailCOAC, "cell 2 7");
		
		JLabel lbContatoCOAC = new JLabel("Contato");
		lbContatoCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbContatoCOAC, "cell 4 7");
		
		tfEmailCOAC = new JTextField();
		tfEmailCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfEmailCOAC.setColumns(10);
		add(tfEmailCOAC, "cell 2 8,growx");
		
		tfContatoCOAC = new JTextField();
		tfContatoCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfContatoCOAC.setColumns(10);
		add(tfContatoCOAC, "cell 4 8,growx");
		
		JLabel lbPrecoHoraCOAC = new JLabel("Preço da hora");
		lbPrecoHoraCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPrecoHoraCOAC, "cell 2 10");
		
		JLabel lbPercentualLucroCOAC = new JLabel("Percentual de lucro");
		lbPercentualLucroCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPercentualLucroCOAC, "cell 4 10");
		
		tfPrecoHoraCOAC = new JTextField();
		tfPrecoHoraCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfPrecoHoraCOAC.setColumns(10);
		add(tfPrecoHoraCOAC, "cell 2 11,growx");
		
		tfPercentualLucroCOAC = new JTextField();
		tfPercentualLucroCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfPercentualLucroCOAC.setColumns(10);
		add(tfPercentualLucroCOAC, "cell 4 11,growx");
		
		JLabel lbMateriaisCOAC = new JLabel("Materiais");
		lbMateriaisCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbMateriaisCOAC, "cell 2 13");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 14,grow");
		
		JComboBox cbMateriaisCOAC = new JComboBox();
		cbMateriaisCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		panel.add(cbMateriaisCOAC);
		
		JLabel lbHorasPrevistasCOAC = new JLabel("Horas previstas");
		lbHorasPrevistasCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbHorasPrevistasCOAC, "cell 2 16");
		
		JLabel lbQuantMaxDiasCOAC = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDiasCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbQuantMaxDiasCOAC, "cell 4 16");
		
		tfHorasPrevistasCOAC = new JTextField();
		tfHorasPrevistasCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfHorasPrevistasCOAC.setColumns(10);
		add(tfHorasPrevistasCOAC, "cell 2 17,growx");
		
		tfQuantMaxDiasCOAC = new JTextField();
		tfQuantMaxDiasCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfQuantMaxDiasCOAC.setColumns(10);
		add(tfQuantMaxDiasCOAC, "cell 4 17,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 3 19,grow");
		
		JButton btCalcularCOAC = new JButton("Editar");
		btCalcularCOAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCalcularCOAC.setBackground(new Color(193, 151, 232));
		btCalcularCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_1.add(btCalcularCOAC);
		btCalcularCOAC.setBorderPainted(false);
		
		JLabel lbValorSemLucroCOAC = new JLabel("Valor sem lucro");
		lbValorSemLucroCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorSemLucroCOAC, "cell 2 21");
		
		JLabel lbValorDoLucroCOAC = new JLabel("Valor do lucro");
		lbValorDoLucroCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorDoLucroCOAC, "cell 4 21");
		
		tfValorSemLucroCOAC = new JTextField();
		tfValorSemLucroCOAC.setText("R$");
		tfValorSemLucroCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorSemLucroCOAC.setColumns(10);
		add(tfValorSemLucroCOAC, "cell 2 22,growx");
		
		tfValorDoLucroCOAC = new JTextField();
		tfValorDoLucroCOAC.setText("R$");
		tfValorDoLucroCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorDoLucroCOAC.setColumns(10);
		add(tfValorDoLucroCOAC, "cell 4 22,growx");
		
		JLabel lbTotalDeGastosCOAC = new JLabel("Total de gastos");
		lbTotalDeGastosCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTotalDeGastosCOAC, "cell 2 24");
		
		JLabel lbValorDeVendaCOAC = new JLabel("Valor de venda");
		lbValorDeVendaCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorDeVendaCOAC, "cell 4 24");
		
		tfTotalDeGastos = new JTextField();
		tfTotalDeGastos.setText("R$");
		tfTotalDeGastos.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfTotalDeGastos.setColumns(10);
		add(tfTotalDeGastos, "cell 2 25,growx");
		
		tfValorDeVendaCOAC = new JTextField();
		tfValorDeVendaCOAC.setText("R$");
		tfValorDeVendaCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorDeVendaCOAC.setColumns(10);
		add(tfValorDeVendaCOAC, "cell 4 25,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 3 27,grow");
		
		JButton btConfirmarCOAC = new JButton("Confirmar");
		btConfirmarCOAC.setBackground(new Color(193, 151, 232));
		btConfirmarCOAC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_2.add(btConfirmarCOAC);
		btConfirmarCOAC.setBorderPainted(false);
		

	}

}