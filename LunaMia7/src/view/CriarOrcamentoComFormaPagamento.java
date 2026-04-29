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

public class CriarOrcamentoComFormaPagamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfTituloOrcamento;
	private JTextField tfNomeCliente;
	private JTextField tfEmail;
	private JTextField tfContato;
	private JTextField tfPrecoHora;
	private JTextField tfPercentualLucro;
	private JTextField tfHorasPrevistas;
	private JTextField tfQuantMaxDias;
	private JTextField tfValorSemLucro;
	private JTextField tfValorLucro;
	private JTextField tfTotalGastos;
	private JTextField tfValorDeVenda;
	private JTextField tfDtPrevistaEntrega;
	private JTextField tfDtConfirmacaoPedido;
	private JTextField tfValorFinal;
	private JButton btConfirmar;

	/**
	 * Create the panel.
	 */
	public CriarOrcamentoComFormaPagamento() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lbTituloOrcamentoCOFP = new JLabel("Título do orçamento");
		lbTituloOrcamentoCOFP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTituloOrcamentoCOFP, "cell 2 1 3 1");
		
		tfTituloOrcamento = new JTextField();
		tfTituloOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfTituloOrcamento, "cell 2 2 3 1,growx");
		tfTituloOrcamento.setColumns(10);
		
		JLabel lbNomeCliente = new JLabel("Nome do cliente");
		lbNomeCliente.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeCliente, "cell 2 4");
		
		tfNomeCliente = new JTextField();
		tfNomeCliente.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfNomeCliente.setColumns(10);
		add(tfNomeCliente, "cell 2 5 3 1,growx");
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmail, "cell 2 7");
		
		JLabel lbContato = new JLabel("Contato");
		lbContato.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbContato, "cell 4 7");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfEmail.setColumns(10);
		add(tfEmail, "cell 2 8,growx");
		
		tfContato = new JTextField();
		tfContato.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfContato.setColumns(10);
		add(tfContato, "cell 4 8,growx");
		
		JLabel lbPrecoHora = new JLabel("Preço da hora");
		lbPrecoHora.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPrecoHora, "cell 2 10");
		
		JLabel lbPercentualLucro = new JLabel("Percentual de lucro");
		lbPercentualLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPercentualLucro, "cell 4 10");
		
		tfPrecoHora = new JTextField();
		tfPrecoHora.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfPrecoHora.setColumns(10);
		add(tfPrecoHora, "cell 2 11,growx");
		
		tfPercentualLucro = new JTextField();
		tfPercentualLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfPercentualLucro.setColumns(10);
		add(tfPercentualLucro, "cell 4 11,growx");
		
		JLabel lbMateriais = new JLabel("Materiais");
		lbMateriais.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMateriais, "cell 2 13");
		
		JPanel panelMateriais = new JPanel();
		panelMateriais.setBackground(new Color(234, 219, 247));
		add(panelMateriais, "cell 2 14,grow");
		
		JComboBox cbMateriais = new JComboBox();
		cbMateriais.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panelMateriais.add(cbMateriais);
		
		JLabel lbHorasPrevistas = new JLabel("Horas previstas");
		lbHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbHorasPrevistas, "cell 2 16");
		
		JLabel lbQuantMaxDias = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQuantMaxDias, "cell 4 16");
		
		tfHorasPrevistas = new JTextField();
		tfHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfHorasPrevistas.setColumns(10);
		add(tfHorasPrevistas, "cell 2 17,growx");
		
		tfQuantMaxDias = new JTextField();
		tfQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfQuantMaxDias.setColumns(10);
		add(tfQuantMaxDias, "cell 4 17,growx");
		
		JLabel lbValorSemLucro = new JLabel("Valor sem lucro");
		lbValorSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorSemLucro, "cell 2 19");
		
		JLabel lbValorLucro = new JLabel("Valor do lucro");
		lbValorLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorLucro, "cell 4 19");
		
		tfValorSemLucro = new JTextField();
		tfValorSemLucro.setText("R$");
		tfValorSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfValorSemLucro.setColumns(10);
		add(tfValorSemLucro, "cell 2 20,growx");
		
		tfValorLucro = new JTextField();
		tfValorLucro.setText("R$");
		tfValorLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfValorLucro.setColumns(10);
		add(tfValorLucro, "cell 4 20,growx");
		
		JLabel lbTotalGastos = new JLabel("Total de gastos");
		lbTotalGastos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTotalGastos, "cell 2 22");
		
		JLabel lbValorDeVenda = new JLabel("Valor de venda");
		lbValorDeVenda.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorDeVenda, "cell 4 22");
		
		tfTotalGastos = new JTextField();
		tfTotalGastos.setText("R$");
		tfTotalGastos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfTotalGastos.setColumns(10);
		add(tfTotalGastos, "cell 2 23,growx");
		
		tfValorDeVenda = new JTextField();
		tfValorDeVenda.setText("R$");
		tfValorDeVenda.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfValorDeVenda.setColumns(10);
		add(tfValorDeVenda, "cell 4 23,growx");
		
		JLabel lbDtPrevistaEntrega = new JLabel("Data prevista de entrega");
		lbDtPrevistaEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtPrevistaEntrega, "cell 2 25");
		
		JLabel lbDtConfirmacaoPedido = new JLabel("Data da confirmação do pedido");
		lbDtConfirmacaoPedido.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtConfirmacaoPedido, "cell 4 25");
		
		tfDtPrevistaEntrega = new JTextField();
		tfDtPrevistaEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfDtPrevistaEntrega.setColumns(10);
		add(tfDtPrevistaEntrega, "cell 2 26,growx");
		
		tfDtConfirmacaoPedido = new JTextField();
		tfDtConfirmacaoPedido.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfDtConfirmacaoPedido.setColumns(10);
		add(tfDtConfirmacaoPedido, "cell 4 26,growx");
		
		JLabel lbFormaPagamento = new JLabel("Forma de pagamento");
		lbFormaPagamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbFormaPagamento, "cell 2 28");
		
		JLabel lbValorFinal = new JLabel("Valor final");
		lbValorFinal.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorFinal, "cell 4 28");
		
		JPanel panelFormaPagamento = new JPanel();
		panelFormaPagamento.setBackground(new Color(234, 219, 247));
		add(panelFormaPagamento, "cell 2 29,grow");
		
		JComboBox cbFormaPagamento = new JComboBox();
		cbFormaPagamento.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panelFormaPagamento.add(cbFormaPagamento);
		
		tfValorFinal = new JTextField();
		tfValorFinal.setText("R$");
		tfValorFinal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfValorFinal.setColumns(10);
		add(tfValorFinal, "cell 4 29,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 3 31,grow");
		
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_2.add(btConfirmar);
		btConfirmar.setBorderPainted(false);

	}
	
	public void confirmar(ActionListener actionListener) {
		this.btConfirmar.addActionListener(actionListener);
	}

}
