package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import model.MateriaPrimaTableModel;
import model.Orcamento;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class VisualizarOrcamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbValorSemLucro, lbValorLucro, lbGastos, lbValorVenda, lbDtConfPedido, lbDtPrevEntrega;
	private JLabel lbFormaPaga, lbValorFinal, lbCustoAdicional, lbStatus, lbVoltar;
	private JScrollPane scrollPane;
	private JTable tabMateriaisEstoque;
	public MateriaPrimaTableModel tabModeloEstoque = new MateriaPrimaTableModel();
	public MateriaPrimaTableModel tabModeloOrcam = new MateriaPrimaTableModel();
	private JPanel panel_Titulo, panel_Cliente, panel_email, panel_Contato, panel_PrecoHora, panel_PercentualLucro;
	private JPanel panel_HorasPrevistas, panel_QuantMaxDias, panel_CustoAdicional, panel_Status, panel_ValorSemLucro;
	private JPanel panel_ValorLucro, panel_TotalGastos, panel_ValorVenda, panel_DataConfirmacao, panel_DataPrevistaEnt;
	private JPanel panel_FormaPagamento, panel_ValorFinal;
	private JLabel lbTituloOrcamCad, lbNomeClienteCad, lbEmailClienteCad, lbContClienteCad, lbPrecoHoraCad;
	private JLabel lbPercLucroCad, lbHorasPrevistasCad, lbQuantDiasMaxCad, lbCustoAdiCad, lbStatusCad;
	private JLabel lbValorSemLucroCad, lbValorLucroCad, lbTotalGastosCad, lbValorVendaCad;
	private JLabel lbDtConfirCad, lbDtEntregaCad, lbFormaPagCad, lbValorFinalCad;

	/**
	 * Create the panel.
	 */
	public VisualizarOrcamento() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020, 1300));

		setLayout(new MigLayout("gap 15", "[grow][grow][grow][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][][][][][][grow]"));

		lbVoltar = new JLabel("") {
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
		lbVoltar.setIcon(new ImageIcon(VisualizarOrcamento.class.getResource("/imagensIcones/Icone_SetaVaziaDentro.png")));
		lbVoltar.setToolTipText("Voltar");
		add(lbVoltar, "pos 20 20");

		JLabel lbTituloOrcamento = new JLabel("Título do orçamento");
		lbTituloOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTituloOrcamento, "cell 1 1 2 1");

		JLabel lbNomeCliente = new JLabel("Nome do cliente");
		lbNomeCliente.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeCliente, "cell 1 3");

		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmail, "cell 1 5");

		JLabel lbContato = new JLabel("Contato");
		lbContato.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbContato, "cell 2 5");

		JLabel lbPrecoHora = new JLabel("Preço da hora (R$)");
		lbPrecoHora.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPrecoHora, "cell 1 7");

		JLabel lbPercentualLucro = new JLabel("Percentual de lucro (%)");
		lbPercentualLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPercentualLucro, "cell 2 7");

		JLabel lbHorasPrevistas = new JLabel("Horas previstas");
		lbHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbHorasPrevistas, "cell 1 14");

		JLabel lbQuantMaxDias = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQuantMaxDias, "cell 2 14");

		Dimension tamanhoFixo = new Dimension(300, 180);

		JLabel lblMateriais = new JLabel("Materias usados");
		lblMateriais.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lblMateriais, "cell 1 9 2 1,alignx center");

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(tamanhoFixo);
		scrollPane.setMinimumSize(tamanhoFixo);
		scrollPane.setMaximumSize(tamanhoFixo);
		add(scrollPane, "cell 1 10 2 4,alignx center");

		tabMateriaisEstoque = new JTable(tabModeloEstoque);

		scrollPane.setViewportView(tabMateriaisEstoque);

		// Estilização do cabeçalho
		JTableHeader header = tabMateriaisEstoque.getTableHeader();
		header.setBackground(new Color(234, 219, 247));
		header.setForeground(new Color(103, 80, 125));
		header.setFont(new Font("Times New Roman", Font.BOLD, 18));
		header.setReorderingAllowed(false); // impede arrastar colunas

		// Estilização das linhas e colunas
		tabMateriaisEstoque.setRowHeight(35);
		tabMateriaisEstoque.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tabMateriaisEstoque.setGridColor(new Color(220, 220, 220));
		tabMateriaisEstoque.setShowVerticalLines(false);
		tabMateriaisEstoque.setSelectionBackground(new Color(193, 151, 232));
		tabMateriaisEstoque.setSelectionForeground(Color.WHITE);

		scrollPane.setBorder(null);
		tabMateriaisEstoque.setBorder(null);

		lbCustoAdicional = new JLabel("Custo Adicional");
		lbCustoAdicional.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCustoAdicional, "cell 1 16");

		lbStatus = new JLabel("Status do Pedido");
		lbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbStatus, "cell 2 16");

		lbValorSemLucro = new JLabel("Valor do lucro adicional");
		lbValorSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorSemLucro, "cell 1 18");

		lbValorLucro = new JLabel("Valor do lucro total");
		lbValorLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorLucro, "cell 2 18");

		lbGastos = new JLabel("Total de Gastos");
		lbGastos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbGastos, "cell 1 20");

		lbValorVenda = new JLabel("Valor de venda");
		lbValorVenda.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorVenda, "cell 2 20");

		lbDtConfPedido = new JLabel("Data de confirmação do pedido");
		lbDtConfPedido.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtConfPedido, "cell 1 22");

		lbDtPrevEntrega = new JLabel("Data prevista de entrega");
		lbDtPrevEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtPrevEntrega, "cell 2 22");

		lbFormaPaga = new JLabel("Forma de pagamento");
		lbFormaPaga.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbFormaPaga, "cell 1 24");

		lbValorFinal = new JLabel("Valor final");
		lbValorFinal.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorFinal, "cell 2 24");

		// PANELS

		panel_Titulo = new JPanel();
		panel_Titulo.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_Titulo, "cell 1 2 2 1,growx,height 38!");
		panel_Titulo.setLayout(new MigLayout("", "[]", "[]"));

		lbTituloOrcamCad = new JLabel("");
		lbTituloOrcamCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_Titulo.add(lbTituloOrcamCad, "cell 0 0");

		panel_Cliente = new JPanel();
		panel_Cliente.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_Cliente, "cell 1 4 2 1,growx,height 38!");
		panel_Cliente.setLayout(new MigLayout("", "[]", "[]"));

		lbNomeClienteCad = new JLabel("");
		lbNomeClienteCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_Cliente.add(lbNomeClienteCad, "cell 0 0");

		panel_email = new JPanel();
		panel_email.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_email, "cell 1 6, growx,height 38!");
		panel_email.setLayout(new MigLayout("", "[]", "[]"));

		lbEmailClienteCad = new JLabel("");
		lbEmailClienteCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_email.add(lbEmailClienteCad, "cell 0 0");

		panel_Contato = new JPanel();
		panel_Contato.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_Contato, "cell 2 6,growx, height 38!");
		panel_Contato.setLayout(new MigLayout("", "[]", "[]"));

		lbContClienteCad = new JLabel("");
		lbContClienteCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_Contato.add(lbContClienteCad, "cell 0 0");

		panel_PrecoHora = new JPanel();
		panel_PrecoHora.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_PrecoHora, "cell 1 8, growx,height 38!");
		panel_PrecoHora.setLayout(new MigLayout("", "[]", "[]"));

		lbPrecoHoraCad = new JLabel("");
		lbPrecoHoraCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_PrecoHora.add(lbPrecoHoraCad, "cell 0 0");

		panel_PercentualLucro = new JPanel();
		panel_PercentualLucro.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_PercentualLucro, "cell 2 8,growx,height 38!");
		panel_PercentualLucro.setLayout(new MigLayout("", "[]", "[]"));

		lbPercLucroCad = new JLabel("");
		lbPercLucroCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_PercentualLucro.add(lbPercLucroCad, "cell 0 0");

		panel_HorasPrevistas = new JPanel();
		panel_HorasPrevistas.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_HorasPrevistas, "cell 1 15,growx,height 38!");
		panel_HorasPrevistas.setLayout(new MigLayout("", "[]", "[]"));

		lbHorasPrevistasCad = new JLabel("");
		lbHorasPrevistasCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_HorasPrevistas.add(lbHorasPrevistasCad, "cell 0 0");

		panel_QuantMaxDias = new JPanel();
		panel_QuantMaxDias.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_QuantMaxDias, "cell 2 15,growx,height 38!");
		panel_QuantMaxDias.setLayout(new MigLayout("", "[]", "[]"));

		lbQuantDiasMaxCad = new JLabel("");
		lbQuantDiasMaxCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_QuantMaxDias.add(lbQuantDiasMaxCad, "cell 0 0");

		panel_TotalGastos = new JPanel();
		panel_TotalGastos.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_TotalGastos, "cell 1 21,growx,height 38!");
		panel_TotalGastos.setLayout(new MigLayout("", "[]", "[]"));

		lbTotalGastosCad = new JLabel("");
		lbTotalGastosCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_TotalGastos.add(lbTotalGastosCad, "cell 0 0");

		panel_ValorVenda = new JPanel();
		panel_ValorVenda.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_ValorVenda, "cell 2 21,growx, height 38!");
		panel_ValorVenda.setLayout(new MigLayout("", "[]", "[]"));

		lbValorVendaCad = new JLabel("");
		lbValorVendaCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_ValorVenda.add(lbValorVendaCad, "cell 0 0");

		panel_CustoAdicional = new JPanel();
		panel_CustoAdicional.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_CustoAdicional, "cell 1 17,growx,height 38!");
		panel_CustoAdicional.setLayout(new MigLayout("", "[]", "[]"));

		lbCustoAdiCad = new JLabel("");
		lbCustoAdiCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_CustoAdicional.add(lbCustoAdiCad, "cell 0 0");

		panel_Status = new JPanel();
		panel_Status.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_Status, "cell 2 17,growx,height 38");
		panel_Status.setLayout(new MigLayout("", "[]", "[]"));

		lbStatusCad = new JLabel("");
		lbStatusCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_Status.add(lbStatusCad, "cell 0 0");

		panel_ValorSemLucro = new JPanel();
		panel_ValorSemLucro.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_ValorSemLucro, "cell 1 19,growx,height 38!");
		panel_ValorSemLucro.setLayout(new MigLayout("", "[]", "[]"));

		lbValorSemLucroCad = new JLabel("");
		lbValorSemLucroCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_ValorSemLucro.add(lbValorSemLucroCad, "cell 0 0");

		panel_ValorLucro = new JPanel();
		panel_ValorLucro.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_ValorLucro, "cell 2 19,growx,height 38!");
		panel_ValorLucro.setLayout(new MigLayout("", "[]", "[]"));

		lbValorLucroCad = new JLabel("");
		lbValorLucroCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_ValorLucro.add(lbValorLucroCad, "cell 0 0");

		panel_DataConfirmacao = new JPanel();
		panel_DataConfirmacao.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_DataConfirmacao, "cell 1 23,growx,height 38!");
		panel_DataConfirmacao.setLayout(new MigLayout("", "[]", "[]"));

		lbDtConfirCad = new JLabel("");
		lbDtConfirCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_DataConfirmacao.add(lbDtConfirCad, "cell 0 0");

		panel_DataPrevistaEnt = new JPanel();
		panel_DataPrevistaEnt.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_DataPrevistaEnt, "cell 2 23,growx,height 38!");
		panel_DataPrevistaEnt.setLayout(new MigLayout("", "[]", "[]"));

		lbDtEntregaCad = new JLabel("");
		lbDtEntregaCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_DataPrevistaEnt.add(lbDtEntregaCad, "cell 0 0");

		panel_FormaPagamento = new JPanel();
		panel_FormaPagamento.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_FormaPagamento, "cell 1 25,growx,height 38!");
		panel_FormaPagamento.setLayout(new MigLayout("", "[]", "[]"));

		lbFormaPagCad = new JLabel("");
		lbFormaPagCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_FormaPagamento.add(lbFormaPagCad, "cell 0 0");

		panel_ValorFinal = new JPanel();
		panel_ValorFinal.setBorder(new EmptyBorder(0, 0, 0, 0));
		add(panel_ValorFinal, "cell 2 25,growx,height 38!");
		panel_ValorFinal.setLayout(new MigLayout("", "[]", "[]"));

		lbValorFinalCad = new JLabel("");
		lbValorFinalCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_ValorFinal.add(lbValorFinalCad, "cell 0 0");

	}

	public void voltar(MouseListener mouseListener) {
		this.lbVoltar.addMouseListener(mouseListener);
	}

	public JLabel getLbTituloOrcamCad() {
		return lbTituloOrcamCad;
	}

	public void setLbTituloOrcamCad(JLabel lbTituloOrcamCad) {
		this.lbTituloOrcamCad = lbTituloOrcamCad;
	}

	public JLabel getLbNomeClienteCad() {
		return lbNomeClienteCad;
	}

	public void setLbNomeClienteCad(JLabel lbNomeClienteCad) {
		this.lbNomeClienteCad = lbNomeClienteCad;
	}

	public JLabel getLbEmailClienteCad() {
		return lbEmailClienteCad;
	}

	public void setLbEmailClienteCad(JLabel lbEmailClienteCad) {
		this.lbEmailClienteCad = lbEmailClienteCad;
	}

	public JLabel getLbContClienteCad() {
		return lbContClienteCad;
	}

	public void setLbContClienteCad(JLabel lbContClienteCad) {
		this.lbContClienteCad = lbContClienteCad;
	}

	public JLabel getLbPrecoHoraCad() {
		return lbPrecoHoraCad;
	}

	public void setLbPrecoHoraCad(JLabel lbPrecoHoraCad) {
		this.lbPrecoHoraCad = lbPrecoHoraCad;
	}

	public JLabel getLbPercLucroCad() {
		return lbPercLucroCad;
	}

	public void setLbPercLucroCad(JLabel lbPercLucroCad) {
		this.lbPercLucroCad = lbPercLucroCad;
	}

	public JLabel getLbHorasPrevistasCad() {
		return lbHorasPrevistasCad;
	}

	public void setLbHorasPrevistasCad(JLabel lbHorasPrevistasCad) {
		this.lbHorasPrevistasCad = lbHorasPrevistasCad;
	}

	public JLabel getLbQuantDiasMaxCad() {
		return lbQuantDiasMaxCad;
	}

	public void setLbQuantDiasMaxCad(JLabel lbQuantDiasMaxCad) {
		this.lbQuantDiasMaxCad = lbQuantDiasMaxCad;
	}

	public JLabel getLbCustoAdiCad() {
		return lbCustoAdiCad;
	}

	public void setLbCustoAdiCad(JLabel lbCustoAdiCad) {
		this.lbCustoAdiCad = lbCustoAdiCad;
	}

	public JLabel getLbStatusCad() {
		return lbStatusCad;
	}

	public void setLbStatusCad(JLabel lbStatusCad) {
		this.lbStatusCad = lbStatusCad;
	}

	public JLabel getLbValorSemLucroCad() {
		return lbValorSemLucroCad;
	}

	public void setLbValorSemLucroCad(JLabel lbValorSemLucroCad) {
		this.lbValorSemLucroCad = lbValorSemLucroCad;
	}

	public JLabel getLbValorLucroCad() {
		return lbValorLucroCad;
	}

	public void setLbValorLucroCad(JLabel lbValorLucroCad) {
		this.lbValorLucroCad = lbValorLucroCad;
	}

	public JLabel getLbTotalGastosCad() {
		return lbTotalGastosCad;
	}

	public void setLbTotalGastosCad(JLabel lbTotalGastosCad) {
		this.lbTotalGastosCad = lbTotalGastosCad;
	}

	public JLabel getLbValorVendaCad() {
		return lbValorVendaCad;
	}

	public void setLbValorVendaCad(JLabel lbValorVendaCad) {
		this.lbValorVendaCad = lbValorVendaCad;
	}

	public JLabel getLbDtConfirCad() {
		return lbDtConfirCad;
	}

	public void setLbDtConfirCad(JLabel lbDtConfirCad) {
		this.lbDtConfirCad = lbDtConfirCad;
	}

	public JLabel getLbDtEntregaCad() {
		return lbDtEntregaCad;
	}

	public void setLbDtEntregaCad(JLabel lbDtEntregaCad) {
		this.lbDtEntregaCad = lbDtEntregaCad;
	}

	public JLabel getLbFormaPagCad() {
		return lbFormaPagCad;
	}

	public void setLbFormaPagCad(JLabel lbFormaPagCad) {
		this.lbFormaPagCad = lbFormaPagCad;
	}

	public JTable getTabMateriaisEstoque() {
		return tabMateriaisEstoque;
	}

	public void setTabMateriaisEstoque(JTable tabMateriaisEstoque) {
		this.tabMateriaisEstoque = tabMateriaisEstoque;
	}

	public JLabel getLbValorFinalCad() {
		return lbValorFinalCad;
	}

	public void setLbValorFinalCad(JLabel lbValorFinalCad) {
		this.lbValorFinalCad = lbValorFinalCad;
	}

}