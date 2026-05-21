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

public class VisualizarOrcamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbValorSemLucro, lbValorLucro, lbGastos, lbValorVenda, lbDtConfPedido, lbDtPrevEntrega;
	private JLabel lbFormaPaga, lbValorFinal, lbCustoAdicional, lbStatus, lbVoltar;
	private JScrollPane scrollPane;
	private JTable tabMateriaisEstoque;
	public MateriaPrimaTableModel tabModeloEstoque = new MateriaPrimaTableModel();
	public MateriaPrimaTableModel tabModeloOrcam = new MateriaPrimaTableModel();
	private JPanel panel_Titulo;
	private JPanel panel_Cliente;
	private JPanel panel_email;
	private JPanel panel_Contato;
	private JPanel panel_PrecoHora;
	private JPanel panel_PercentualLucro;
	private JPanel panel_HorasPrevistas;
	private JPanel panel_QuantMaxDias;
	private JPanel panel_CustoAdicional;
	private JPanel panel_Status;
	private JPanel panel_ValorSemLucro;
	private JPanel panel_ValorLucro;
	private JPanel panel_TotalGastos;
	private JPanel panel_ValorVenda;
	private JPanel panel_DataConfirmacao;
	private JPanel panel_DataPrevistaEnt;
	private JPanel panel_FormaPagamento;
	private JPanel panel_ValorFinal;

	/**
	 * Create the panel.
	 */
	public VisualizarOrcamento() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020, 1464));

		setLayout(new MigLayout("gap 15", "[grow][207.00,grow][207.00,grow][grow]",
				"[grow][][grow][][grow][][grow][][grow][][][][75px:n][75px:n][][grow][][grow][][grow][][grow][][grow][][grow][grow]"));

		lbVoltar = new JLabel("");
		lbVoltar.setIcon(
				new ImageIcon(VisualizarOrcamento.class.getResource("/imagensIcones/Icone_SetaVaziaDentro.png")));
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

		lbValorSemLucro = new JLabel("Valor sem lucro");
		lbValorSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorSemLucro, "cell 1 18");

		lbValorLucro = new JLabel("Valor do lucro");
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

		//PANELS
		
		panel_Titulo = new JPanel();
		add(panel_Titulo, "cell 1 2 2 1,width 71%,height 38!");

		panel_Cliente = new JPanel();
		add(panel_Cliente, "cell 1 4 2 1,width 71%,height 38!");

		panel_email = new JPanel();
		add(panel_email, "cell 1 6,width 71%,height 38!");

		panel_Contato = new JPanel();
		add(panel_Contato, "cell 2 6, width 71%,height 38!");

		panel_PrecoHora = new JPanel();
		add(panel_PrecoHora, "cell 1 8,width 71%,height 38!");

		panel_PercentualLucro = new JPanel();
		add(panel_PercentualLucro, "cell 2 8,width 71%,height 38!");

		panel_HorasPrevistas = new JPanel();
		add(panel_HorasPrevistas, "cell 1 15,width 71%,height 38!");

		panel_QuantMaxDias = new JPanel();
		add(panel_QuantMaxDias, "cell 2 15,width 71%,height 38!");

		panel_TotalGastos = new JPanel();
		add(panel_TotalGastos, "cell 1 21,width 71%,height 38!");

		panel_ValorVenda = new JPanel();
		add(panel_ValorVenda, "cell 2 21,width 71%,height 38!");

		panel_CustoAdicional = new JPanel();
		add(panel_CustoAdicional, "cell 1 17,width 71%,height 38!");

		panel_Status = new JPanel();
		add(panel_Status, "cell 2 17,width 71%,height 38");

		panel_ValorSemLucro = new JPanel();
		add(panel_ValorSemLucro, "cell 1 19,width 71%,height 38!");

		panel_ValorLucro = new JPanel();
		add(panel_ValorLucro, "cell 2 19,width 71%,height 38!");

		panel_DataConfirmacao = new JPanel();
		add(panel_DataConfirmacao, "cell 1 23,width 71%,height 38!");

		panel_DataPrevistaEnt = new JPanel();
		add(panel_DataPrevistaEnt, "cell 2 23,width 71%,height 38!");

		panel_FormaPagamento = new JPanel();
		add(panel_FormaPagamento, "cell 1 25,width 71%,height 38!");

		panel_ValorFinal = new JPanel();
		add(panel_ValorFinal, "cell 2 25,width 71%,height 38!");

	}

	public void voltar(MouseListener mouseListener) {
		this.lbVoltar.addMouseListener(mouseListener);
	}

	public JLabel getLbValorSemLucro() {
		return lbValorSemLucro;
	}

	public void setLbValorSemLucro(JLabel lbValorSemLucro) {
		this.lbValorSemLucro = lbValorSemLucro;
	}

	public JLabel getLbValorLucro() {
		return lbValorLucro;
	}

	public void setLbValorLucro(JLabel lbValorLucro) {
		this.lbValorLucro = lbValorLucro;
	}

	public JLabel getLbGastos() {
		return lbGastos;
	}

	public void setLbGastos(JLabel lbGastos) {
		this.lbGastos = lbGastos;
	}

	public JLabel getLbValorVenda() {
		return lbValorVenda;
	}

	public void setLbValorVenda(JLabel lbValorVenda) {
		this.lbValorVenda = lbValorVenda;
	}

	public JLabel getLbDtConfPedido() {
		return lbDtConfPedido;
	}

	public void setLbDtConfPedido(JLabel lbDtConfPedido) {
		this.lbDtConfPedido = lbDtConfPedido;
	}

	public JLabel getLbDtPrevEntrega() {
		return lbDtPrevEntrega;
	}

	public void setLbDtPrevEntrega(JLabel lbDtPrevEntrega) {
		this.lbDtPrevEntrega = lbDtPrevEntrega;
	}

	public JLabel getLbFormaPaga() {
		return lbFormaPaga;
	}

	public void setLbFormaPaga(JLabel lbFormaPaga) {
		this.lbFormaPaga = lbFormaPaga;
	}

	public JLabel getLbValorFinal() {
		return lbValorFinal;
	}

	public void setLbValorFinal(JLabel lbValorFinal) {
		this.lbValorFinal = lbValorFinal;
	}

	public JLabel getLbCustoAdicional() {
		return lbCustoAdicional;
	}

	public void setLbCustoAdicional(JLabel lbCustoAdicional) {
		this.lbCustoAdicional = lbCustoAdicional;
	}

	public JLabel getLbStatus() {
		return lbStatus;
	}

	public void setLbStatus(JLabel lbStatus) {
		this.lbStatus = lbStatus;
	}

	public JTable getTabMateriaisEstoque() {
		return tabMateriaisEstoque;
	}

	public void setTabMateriaisEstoque(JTable tabMateriaisEstoque) {
		this.tabMateriaisEstoque = tabMateriaisEstoque;
	}

}