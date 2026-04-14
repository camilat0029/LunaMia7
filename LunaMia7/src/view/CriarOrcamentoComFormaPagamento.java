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
	private JTextField tfValorSemLuvro;
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
		lbTituloOrcamentoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTituloOrcamentoCOFP, "cell 2 1 3 1");
		
		tfTituloOrcamento = new JTextField();
		tfTituloOrcamento.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfTituloOrcamento, "cell 2 2 3 1,growx");
		tfTituloOrcamento.setColumns(10);
		
		JLabel lbNomeClienteCOFP = new JLabel("Nome do cliente");
		lbNomeClienteCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeClienteCOFP, "cell 2 4");
		
		tfNomeCliente = new JTextField();
		tfNomeCliente.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfNomeCliente.setColumns(10);
		add(tfNomeCliente, "cell 2 5 3 1,growx");
		
		JLabel lbEmailCOFP = new JLabel("Email");
		lbEmailCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmailCOFP, "cell 2 7");
		
		JLabel lbContatoCOFP = new JLabel("Contato");
		lbContatoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbContatoCOFP, "cell 4 7");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfEmail.setColumns(10);
		add(tfEmail, "cell 2 8,growx");
		
		tfContato = new JTextField();
		tfContato.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfContato.setColumns(10);
		add(tfContato, "cell 4 8,growx");
		
		JLabel lbPrecoHoraCOFP = new JLabel("Preço da hora");
		lbPrecoHoraCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPrecoHoraCOFP, "cell 2 10");
		
		JLabel lbPercentualLucroCOFP = new JLabel("Percentual de lucro");
		lbPercentualLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPercentualLucroCOFP, "cell 4 10");
		
		tfPrecoHora = new JTextField();
		tfPrecoHora.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfPrecoHora.setColumns(10);
		add(tfPrecoHora, "cell 2 11,growx");
		
		tfPercentualLucro = new JTextField();
		tfPercentualLucro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfPercentualLucro.setColumns(10);
		add(tfPercentualLucro, "cell 4 11,growx");
		
		JLabel lbMateriaisCOFP = new JLabel("Materiais");
		lbMateriaisCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbMateriaisCOFP, "cell 2 13");
		
		JPanel panelMateriaisCOFP = new JPanel();
		panelMateriaisCOFP.setBackground(new Color(234, 219, 247));
		add(panelMateriaisCOFP, "cell 2 14,grow");
		
		JComboBox cbMateriaisCOFP = new JComboBox();
		cbMateriaisCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		panelMateriaisCOFP.add(cbMateriaisCOFP);
		
		JLabel lbHorasPrevistasCOFP = new JLabel("Horas previstas");
		lbHorasPrevistasCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbHorasPrevistasCOFP, "cell 2 16");
		
		JLabel lbQuantMaxDiasCOFP = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDiasCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbQuantMaxDiasCOFP, "cell 4 16");
		
		tfHorasPrevistas = new JTextField();
		tfHorasPrevistas.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfHorasPrevistas.setColumns(10);
		add(tfHorasPrevistas, "cell 2 17,growx");
		
		tfQuantMaxDias = new JTextField();
		tfQuantMaxDias.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfQuantMaxDias.setColumns(10);
		add(tfQuantMaxDias, "cell 4 17,growx");
		
		JLabel lbValorSemLucroCOFP = new JLabel("Valor sem lucro");
		lbValorSemLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorSemLucroCOFP, "cell 2 19");
		
		JLabel lbValorLucroCOFP = new JLabel("Valor do lucro");
		lbValorLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorLucroCOFP, "cell 4 19");
		
		tfValorSemLuvro = new JTextField();
		tfValorSemLuvro.setText("R$");
		tfValorSemLuvro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorSemLuvro.setColumns(10);
		add(tfValorSemLuvro, "cell 2 20,growx");
		
		tfValorLucro = new JTextField();
		tfValorLucro.setText("R$");
		tfValorLucro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorLucro.setColumns(10);
		add(tfValorLucro, "cell 4 20,growx");
		
		JLabel lbTotalGastosCOFP = new JLabel("Total de gastos");
		lbTotalGastosCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTotalGastosCOFP, "cell 2 22");
		
		JLabel lbValorDeVendaCOFP = new JLabel("Valor de venda");
		lbValorDeVendaCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorDeVendaCOFP, "cell 4 22");
		
		tfTotalGastos = new JTextField();
		tfTotalGastos.setText("R$");
		tfTotalGastos.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfTotalGastos.setColumns(10);
		add(tfTotalGastos, "cell 2 23,growx");
		
		tfValorDeVenda = new JTextField();
		tfValorDeVenda.setText("R$");
		tfValorDeVenda.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorDeVenda.setColumns(10);
		add(tfValorDeVenda, "cell 4 23,growx");
		
		JLabel lbDtPrevistaEntregaCOFP = new JLabel("Data prevista de entrega");
		lbDtPrevistaEntregaCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbDtPrevistaEntregaCOFP, "cell 2 25");
		
		JLabel lbDtConfirmacaoPedidoCOFP = new JLabel("Data da confirmação do pedido");
		lbDtConfirmacaoPedidoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbDtConfirmacaoPedidoCOFP, "cell 4 25");
		
		tfDtPrevistaEntrega = new JTextField();
		tfDtPrevistaEntrega.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfDtPrevistaEntrega.setColumns(10);
		add(tfDtPrevistaEntrega, "cell 2 26,growx");
		
		tfDtConfirmacaoPedido = new JTextField();
		tfDtConfirmacaoPedido.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfDtConfirmacaoPedido.setColumns(10);
		add(tfDtConfirmacaoPedido, "cell 4 26,growx");
		
		JLabel lbFormaPagamentoCOFP = new JLabel("Forma de pagamento");
		lbFormaPagamentoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbFormaPagamentoCOFP, "cell 2 28");
		
		JLabel lbValorFinalCOFP = new JLabel("Valor final");
		lbValorFinalCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorFinalCOFP, "cell 4 28");
		
		JPanel panelFormaPagamentoCOFP = new JPanel();
		panelFormaPagamentoCOFP.setBackground(new Color(234, 219, 247));
		add(panelFormaPagamentoCOFP, "cell 2 29,grow");
		
		JComboBox cbFormaPagamentoCOFP = new JComboBox();
		cbFormaPagamentoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		panelFormaPagamentoCOFP.add(cbFormaPagamentoCOFP);
		
		tfValorFinal = new JTextField();
		tfValorFinal.setText("R$");
		tfValorFinal.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorFinal.setColumns(10);
		add(tfValorFinal, "cell 4 29,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 3 31,grow");
		
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_2.add(btConfirmar);
		btConfirmar.setBorderPainted(false);

	}
	
	public void confirmar(ActionListener actionListener) {
		this.btConfirmar.addActionListener(actionListener);
	}

}
