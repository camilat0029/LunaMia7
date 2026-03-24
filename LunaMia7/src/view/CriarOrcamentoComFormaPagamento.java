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
	private JTextField tfTituloOrcamentoCOFP;
	private JTextField tfNomeClienteCOFP;
	private JTextField tfEmailCOFP;
	private JTextField tfContatoCOFP;
	private JTextField tfPrecoHoraCOFP;
	private JTextField tfPercentualLucroCOFP;
	private JTextField tfHorasPrevistasCOFP;
	private JTextField tfQuantMaxDiasCOFP;
	private JTextField tfValorSemLuvroCOFP;
	private JTextField tfValorLucroCOFP;
	private JTextField tfTotalGastosCOFP;
	private JTextField tfValorDeVendaCOFP;
	private JTextField tfDtPrevistaEntregaCOFP;
	private JTextField tfDtConfirmacaoPedidoCOFP;
	private JTextField tfValorFinalCOFP;

	/**
	 * Create the panel.
	 */
	public CriarOrcamentoComFormaPagamento() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lbTituloOrcamentoCOFP = new JLabel("Título do orçamento");
		lbTituloOrcamentoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTituloOrcamentoCOFP, "cell 2 1 3 1");
		
		tfTituloOrcamentoCOFP = new JTextField();
		tfTituloOrcamentoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfTituloOrcamentoCOFP, "cell 2 2 3 1,growx");
		tfTituloOrcamentoCOFP.setColumns(10);
		
		JLabel lbNomeClienteCOFP = new JLabel("Nome do cliente");
		lbNomeClienteCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeClienteCOFP, "cell 2 4");
		
		tfNomeClienteCOFP = new JTextField();
		tfNomeClienteCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfNomeClienteCOFP.setColumns(10);
		add(tfNomeClienteCOFP, "cell 2 5 3 1,growx");
		
		JLabel lbEmailCOFP = new JLabel("Email");
		lbEmailCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmailCOFP, "cell 2 7");
		
		JLabel lbContatoCOFP = new JLabel("Contato");
		lbContatoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbContatoCOFP, "cell 4 7");
		
		tfEmailCOFP = new JTextField();
		tfEmailCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfEmailCOFP.setColumns(10);
		add(tfEmailCOFP, "cell 2 8,growx");
		
		tfContatoCOFP = new JTextField();
		tfContatoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfContatoCOFP.setColumns(10);
		add(tfContatoCOFP, "cell 4 8,growx");
		
		JLabel lbPrecoHoraCOFP = new JLabel("Preço da hora");
		lbPrecoHoraCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPrecoHoraCOFP, "cell 2 10");
		
		JLabel lbPercentualLucroCOFP = new JLabel("Percentual de lucro");
		lbPercentualLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPercentualLucroCOFP, "cell 4 10");
		
		tfPrecoHoraCOFP = new JTextField();
		tfPrecoHoraCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfPrecoHoraCOFP.setColumns(10);
		add(tfPrecoHoraCOFP, "cell 2 11,growx");
		
		tfPercentualLucroCOFP = new JTextField();
		tfPercentualLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfPercentualLucroCOFP.setColumns(10);
		add(tfPercentualLucroCOFP, "cell 4 11,growx");
		
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
		
		tfHorasPrevistasCOFP = new JTextField();
		tfHorasPrevistasCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfHorasPrevistasCOFP.setColumns(10);
		add(tfHorasPrevistasCOFP, "cell 2 17,growx");
		
		tfQuantMaxDiasCOFP = new JTextField();
		tfQuantMaxDiasCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfQuantMaxDiasCOFP.setColumns(10);
		add(tfQuantMaxDiasCOFP, "cell 4 17,growx");
		
		JLabel lbValorSemLucroCOFP = new JLabel("Valor sem lucro");
		lbValorSemLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorSemLucroCOFP, "cell 2 19");
		
		JLabel lbValorLucroCOFP = new JLabel("Valor do lucro");
		lbValorLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorLucroCOFP, "cell 4 19");
		
		tfValorSemLuvroCOFP = new JTextField();
		tfValorSemLuvroCOFP.setText("R$");
		tfValorSemLuvroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorSemLuvroCOFP.setColumns(10);
		add(tfValorSemLuvroCOFP, "cell 2 20,growx");
		
		tfValorLucroCOFP = new JTextField();
		tfValorLucroCOFP.setText("R$");
		tfValorLucroCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorLucroCOFP.setColumns(10);
		add(tfValorLucroCOFP, "cell 4 20,growx");
		
		JLabel lbTotalGastosCOFP = new JLabel("Total de gastos");
		lbTotalGastosCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTotalGastosCOFP, "cell 2 22");
		
		JLabel lbValorDeVendaCOFP = new JLabel("Valor de venda");
		lbValorDeVendaCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbValorDeVendaCOFP, "cell 4 22");
		
		tfTotalGastosCOFP = new JTextField();
		tfTotalGastosCOFP.setText("R$");
		tfTotalGastosCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfTotalGastosCOFP.setColumns(10);
		add(tfTotalGastosCOFP, "cell 2 23,growx");
		
		tfValorDeVendaCOFP = new JTextField();
		tfValorDeVendaCOFP.setText("R$");
		tfValorDeVendaCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorDeVendaCOFP.setColumns(10);
		add(tfValorDeVendaCOFP, "cell 4 23,growx");
		
		JLabel lbDtPrevistaEntregaCOFP = new JLabel("Data prevista de entrega");
		lbDtPrevistaEntregaCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbDtPrevistaEntregaCOFP, "cell 2 25");
		
		JLabel lbDtConfirmacaoPedidoCOFP = new JLabel("Data da confirmação do pedido");
		lbDtConfirmacaoPedidoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbDtConfirmacaoPedidoCOFP, "cell 4 25");
		
		tfDtPrevistaEntregaCOFP = new JTextField();
		tfDtPrevistaEntregaCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfDtPrevistaEntregaCOFP.setColumns(10);
		add(tfDtPrevistaEntregaCOFP, "cell 2 26,growx");
		
		tfDtConfirmacaoPedidoCOFP = new JTextField();
		tfDtConfirmacaoPedidoCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfDtConfirmacaoPedidoCOFP.setColumns(10);
		add(tfDtConfirmacaoPedidoCOFP, "cell 4 26,growx");
		
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
		
		tfValorFinalCOFP = new JTextField();
		tfValorFinalCOFP.setText("R$");
		tfValorFinalCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		tfValorFinalCOFP.setColumns(10);
		add(tfValorFinalCOFP, "cell 4 29,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 3 31,grow");
		
		JButton btConfirmarCOFP = new JButton("Confirmar");
		btConfirmarCOFP.setBackground(new Color(193, 151, 232));
		btConfirmarCOFP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_2.add(btConfirmarCOFP);
		btConfirmarCOFP.setBorderPainted(false);
		
		

	}

}
