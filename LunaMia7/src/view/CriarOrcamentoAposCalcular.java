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
	private JTextField tfTituloOrcamento;
	private JTextField textField;
	private JTextField tfEmail;
	private JTextField tfContato;
	private JTextField tfPrecoHora;
	private JTextField tfPercentualLucro;
	private JTextField tfHorasPrevistas;
	private JTextField tfQuantMaxDias;
	private JTextField tfValorSemLucro;
	private JTextField tfValorDoLucro;
	private JTextField tfTotalDeGastos;
	private JTextField tfValorDeVenda;
	private JButton btConfirmar;
	private JButton btEditar;
	
	

	/**
	 * Create the panel.
	 */
	public CriarOrcamentoAposCalcular() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lbTituloOrcamentoCOAC = new JLabel("Título do orçamento");
		lbTituloOrcamentoCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTituloOrcamentoCOAC, "cell 2 1 3 1");
		
		tfTituloOrcamento = new JTextField();
		tfTituloOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfTituloOrcamento, "cell 2 2 3 1,growx");
		tfTituloOrcamento.setColumns(10);
		
		JLabel lbNomeClienteCOAC = new JLabel("Nome do cliente");
		lbNomeClienteCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeClienteCOAC, "cell 2 4");
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textField.setColumns(10);
		add(textField, "cell 2 5 3 1,growx");
		
		JLabel lbEmailCOAC = new JLabel("Email");
		lbEmailCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmailCOAC, "cell 2 7");
		
		JLabel lbContatoCOAC = new JLabel("Contato");
		lbContatoCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbContatoCOAC, "cell 4 7");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfEmail.setColumns(10);
		add(tfEmail, "cell 2 8,growx");
		
		tfContato = new JTextField();
		tfContato.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfContato.setColumns(10);
		add(tfContato, "cell 4 8,growx");
		
		JLabel lbPrecoHoraCOAC = new JLabel("Preço da hora");
		lbPrecoHoraCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPrecoHoraCOAC, "cell 2 10");
		
		JLabel lbPercentualLucroCOAC = new JLabel("Percentual de lucro");
		lbPercentualLucroCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPercentualLucroCOAC, "cell 4 10");
		
		tfPrecoHora = new JTextField();
		tfPrecoHora.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfPrecoHora.setColumns(10);
		add(tfPrecoHora, "cell 2 11,growx");
		
		tfPercentualLucro = new JTextField();
		tfPercentualLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfPercentualLucro.setColumns(10);
		add(tfPercentualLucro, "cell 4 11,growx");
		
		JLabel lbMateriaisCOAC = new JLabel("Materiais");
		lbMateriaisCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMateriaisCOAC, "cell 2 13");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 14,grow");
		
		JComboBox cbMateriaisCOAC = new JComboBox();
		cbMateriaisCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel.add(cbMateriaisCOAC);
		
		JLabel lbHorasPrevistasCOAC = new JLabel("Horas previstas");
		lbHorasPrevistasCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbHorasPrevistasCOAC, "cell 2 16");
		
		JLabel lbQuantMaxDiasCOAC = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDiasCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQuantMaxDiasCOAC, "cell 4 16");
		
		tfHorasPrevistas = new JTextField();
		tfHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfHorasPrevistas.setColumns(10);
		add(tfHorasPrevistas, "cell 2 17,growx");
		
		tfQuantMaxDias = new JTextField();
		tfQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfQuantMaxDias.setColumns(10);
		add(tfQuantMaxDias, "cell 4 17,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 3 19,grow");
		
		btEditar = new JButton("Editar");
		btEditar.setBackground(new Color(193, 151, 232));
		btEditar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(btEditar);
		btEditar.setBorderPainted(false);
		
		JLabel lbValorSemLucroCOAC = new JLabel("Valor sem lucro");
		lbValorSemLucroCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorSemLucroCOAC, "cell 2 21");
		
		JLabel lbValorDoLucroCOAC = new JLabel("Valor do lucro");
		lbValorDoLucroCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorDoLucroCOAC, "cell 4 21");
		
		tfValorSemLucro = new JTextField();
		tfValorSemLucro.setText("R$");
		tfValorSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfValorSemLucro.setColumns(10);
		add(tfValorSemLucro, "cell 2 22,growx");
		
		tfValorDoLucro = new JTextField();
		tfValorDoLucro.setText("R$");
		tfValorDoLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfValorDoLucro.setColumns(10);
		add(tfValorDoLucro, "cell 4 22,growx");
		
		JLabel lbTotalDeGastosCOAC = new JLabel("Total de gastos");
		lbTotalDeGastosCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTotalDeGastosCOAC, "cell 2 24");
		
		JLabel lbValorDeVendaCOAC = new JLabel("Valor de venda");
		lbValorDeVendaCOAC.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorDeVendaCOAC, "cell 4 24");
		
		tfTotalDeGastos = new JTextField();
		tfTotalDeGastos.setText("R$");
		tfTotalDeGastos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfTotalDeGastos.setColumns(10);
		add(tfTotalDeGastos, "cell 2 25,growx");
		
		tfValorDeVenda = new JTextField();
		tfValorDeVenda.setText("R$");
		tfValorDeVenda.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfValorDeVenda.setColumns(10);
		add(tfValorDeVenda, "cell 4 25,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 3 27,grow");
		
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_2.add(btConfirmar);
		btConfirmar.setBorderPainted(false);
		
	}
	
	public void editar(ActionListener actionListener) {
		this.btEditar.addActionListener(actionListener);
	}
	public void confirmar(ActionListener actionListener) {
		this.btConfirmar.addActionListener(actionListener);
	}

}