package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
import javax.swing.table.JTableHeader;

import model.MateriaPrimaTableModel;
import model.Orcamento;
import javax.swing.ImageIcon;

public class CriarOrcamento extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField tituloOrcamento, tfNomeCliente, tfEmail, tfContato, tfHorasPrevistas, tfQuantMaxDias;
	private JTextField tfDataConfPedido, tfDtPrevEntrega, tfCustoAdicional;

	private JLabel lbPrecoHoraUsuario, lbPercLucroUsuario, lbLucroAdicionalCad, lbCalcLucro, lbCalcGastos,
			lbValorCalVenda;
	private JLabel lbLucroAdicional, lbValorLucro, lbGastos, lbValorVenda, lbDtConfPedido, lbDtPrevEntrega;
	private JLabel lbFormaPaga, lbValorFinal, lbCustoAdicional, lbStatus, lbMateriasOrcam, lbValorFinalCad, lbVoltar;

	private JButton btCalcEdi, btSalvar, btConfirmar, btAdicionar, btRemover;

	private JComboBox cbFormaPaga;

	private JComboBox<model.Orcamento.Status> cbStatus;
	private JScrollPane scrollPane, scrollPane_1;
	private JTable tabMateriaisEstoque, tabMateriaisOrcam;
	public MateriaPrimaTableModel tabModeloEstoque = new MateriaPrimaTableModel();
	public MateriaPrimaTableModel tabModeloOrcam = new MateriaPrimaTableModel();
	private JLabel interrogacaoHrsPrev;
	private JLabel interrogacaoQuantMaxDias;
	private JLabel interrogacaoCustoAdic;

	/**
	 * Create the panel.
	 */
	public CriarOrcamento() {
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020, 1464));

		setLayout(new MigLayout("gap 15", "[grow][207.00][][207.00][grow]",
				"[grow][][][][][][][][][][][][75px:n][75px:n][][][][][][][][][][][][][][][][grow]"));

		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(CriarOrcamento.class.getResource("/imagensIcones/Icone_SetaVaziaDentro.png")));
		add(lbVoltar, "pos 20 20");

		JLabel lbTituloOrcamento = new JLabel("Título do orçamento");
		lbTituloOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTituloOrcamento, "cell 1 1 3 1");

		tituloOrcamento = new JTextField();
		tituloOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tituloOrcamento, "cell 1 2 3 1,growx");
		tituloOrcamento.setColumns(10);

		JLabel lbNomeCliente = new JLabel("Nome do cliente");
		lbNomeCliente.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeCliente, "cell 1 3");

		tfNomeCliente = new JTextField();
		tfNomeCliente.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfNomeCliente.setColumns(10);
		add(tfNomeCliente, "cell 1 4 3 1,growx");

		JLabel lbEmail = new JLabel("Email do cliente");
		lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmail, "cell 1 5");

		JLabel lbContato = new JLabel("Telefone do Cliente");
		lbContato.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbContato, "cell 3 5");

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfEmail.setColumns(10);
		add(tfEmail, "cell 1 6,growx");

		tfContato = new JTextField();
		tfContato.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfContato.setColumns(10);
		add(tfContato, "cell 3 6,growx");

		JLabel lbPrecoHora = new JLabel("Preço da hora (R$)");
		lbPrecoHora.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPrecoHora, "cell 1 7");

		JLabel lbPercentualLucro = new JLabel("Percentual de lucro (%)");
		lbPercentualLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPercentualLucro, "cell 3 7");

		lbPrecoHoraUsuario = new JLabel("R$");
		lbPrecoHoraUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPrecoHoraUsuario, "cell 1 8");

		lbPercLucroUsuario = new JLabel("%");
		lbPercLucroUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPercLucroUsuario, "cell 3 8");

		JLabel lblMateriais = new JLabel("Materiais do Estoque");
		lblMateriais.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lblMateriais, "cell 1 9");

		lbMateriasOrcam = new JLabel("Materiais para Orçamento");
		lbMateriasOrcam.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbMateriasOrcam, "cell 3 9");

		Dimension tamanhoFixo = new Dimension(300, 180);

		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(tamanhoFixo);
		scrollPane.setMinimumSize(tamanhoFixo);
		scrollPane.setMaximumSize(tamanhoFixo);
		add(scrollPane, "cell 1 10 1 4");

		tabMateriaisEstoque = new JTable(tabModeloEstoque);

		scrollPane.setViewportView(tabMateriaisEstoque);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(tamanhoFixo);
		scrollPane_1.setMinimumSize(tamanhoFixo);
		scrollPane_1.setMaximumSize(tamanhoFixo);

		add(scrollPane_1, "cell 3 10 1 4");

		tabMateriaisOrcam = new JTable(tabModeloOrcam);
		scrollPane_1.setViewportView(tabMateriaisOrcam);

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
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);

		// Estilização do cabeçalho
		JTableHeader header2 = tabMateriaisOrcam.getTableHeader();
		header2.setBackground(new Color(234, 219, 247));
		header2.setForeground(new Color(103, 80, 125));
		header2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		header2.setReorderingAllowed(false); // impede arrastar colunas

		// Estilização das linhas e colunas
		tabMateriaisOrcam.setRowHeight(35);
		tabMateriaisOrcam.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tabMateriaisOrcam.setGridColor(new Color(220, 220, 220));
		tabMateriaisOrcam.setShowVerticalLines(false);
		tabMateriaisOrcam.setSelectionBackground(new Color(193, 151, 232));
		tabMateriaisOrcam.setSelectionForeground(Color.WHITE);

		scrollPane_1.setBorder(null);
		tabMateriaisOrcam.setBorder(null);
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(20);

		btAdicionar = new JButton("Adicionar");
		ImageIcon iconAdd = new ImageIcon(CriarOrcamento.class.getResource("/imagensIcones/8.png"));
		Image imgAdd = iconAdd.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btAdicionar.setIcon(new ImageIcon(imgAdd));
		btAdicionar.setHorizontalTextPosition(SwingConstants.LEFT);
		btAdicionar.setBackground(new Color(208, 176, 238));
		btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(btAdicionar, "cell 2 12,alignx center");

		btAdicionar.setBorderPainted(false);
		btAdicionar.setFocusPainted(false);

		btRemover = new JButton("Remover");
		ImageIcon iconRem = new ImageIcon(CriarOrcamento.class.getResource("/imagensIcones/7.png"));
		Image imgRem = iconRem.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		btRemover.setIcon(new ImageIcon(imgRem));
		btRemover.setBackground(new Color(208, 176, 238));
		btRemover.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(btRemover, "cell 2 13,alignx center");

		btRemover.setBorderPainted(false);
		btRemover.setFocusPainted(false);

		JLabel lbHorasPrevistas = new JLabel("Horas previstas");
		lbHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbHorasPrevistas, "flowx,cell 1 14");

		JLabel lbQuantMaxDias = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQuantMaxDias, "flowx,cell 3 14");

		tfHorasPrevistas = new JTextField();
		tfHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfHorasPrevistas.setColumns(10);
		add(tfHorasPrevistas, "cell 1 15,growx");

		tfQuantMaxDias = new JTextField();
		tfQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfQuantMaxDias.setColumns(10);
		add(tfQuantMaxDias, "cell 3 15,growx");

		lbCustoAdicional = new JLabel("Custo Adicional");
		lbCustoAdicional.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCustoAdicional, "flowx,cell 1 16");

		lbStatus = new JLabel("Status do Pedido");
		lbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbStatus, "cell 3 16");

		tfCustoAdicional = new JTextField();
		tfCustoAdicional.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfCustoAdicional, "cell 1 17,growx");
		tfCustoAdicional.setColumns(10);

		cbStatus = new JComboBox<>(model.Orcamento.Status.values());
		cbStatus.setSelectedItem(Orcamento.Status.PENDENTE);
		cbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(cbStatus, "cell 3 17,growx");

		btCalcEdi = new JButton("Calcular");
		btCalcEdi.setBackground(new Color(193, 151, 232));
		btCalcEdi.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btCalcEdi, "cell 2 18,growx,aligny center");

		lbLucroAdicional = new JLabel("Valor do lucro adicional");
		lbLucroAdicional.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbLucroAdicional, "cell 1 19");

		lbValorLucro = new JLabel("Valor do lucro total");
		lbValorLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorLucro, "cell 3 19");

		lbLucroAdicionalCad = new JLabel("R$");
		lbLucroAdicionalCad.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbLucroAdicionalCad, "cell 1 20");

		lbCalcLucro = new JLabel("R$");
		lbCalcLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbCalcLucro, "cell 3 20");

		lbGastos = new JLabel("Total de Gastos");
		lbGastos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbGastos, "cell 1 21");

		lbValorVenda = new JLabel("Valor de venda");
		lbValorVenda.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorVenda, "cell 3 21");

		lbCalcGastos = new JLabel("R$");
		lbCalcGastos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbCalcGastos, "cell 1 22");

		lbValorCalVenda = new JLabel("R$");
		lbValorCalVenda.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbValorCalVenda, "cell 3 22");

		btSalvar = new JButton("Salvar");
		btSalvar.setBackground(new Color(193, 151, 232));
		btSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btSalvar, "cell 2 23,growx");

		lbDtConfPedido = new JLabel("Data de confirmação do pedido");
		lbDtConfPedido.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtConfPedido, "cell 1 24");

		lbDtPrevEntrega = new JLabel("Data prevista de entrega");
		lbDtPrevEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtPrevEntrega, "cell 3 24");

		tfDataConfPedido = new JTextField();
		tfDataConfPedido.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfDataConfPedido, "cell 1 25,growx");
		tfDataConfPedido.setColumns(10);

		tfDtPrevEntrega = new JTextField();
		tfDtPrevEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfDtPrevEntrega, "cell 3 25,growx");
		tfDtPrevEntrega.setColumns(10);

		lbFormaPaga = new JLabel("Forma de pagamento");
		lbFormaPaga.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbFormaPaga, "cell 1 26");

		lbValorFinal = new JLabel("Valor final");
		lbValorFinal.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorFinal, "cell 3 26");

		cbFormaPaga = new JComboBox();
		cbFormaPaga.setModel(new DefaultComboBoxModel(
				new String[] { "", "Cartão Crédito", "Cartão Débito", "Pix", "Dinheiro", "Outro" }));
		cbFormaPaga.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(cbFormaPaga, "cell 1 27,growx");

		lbValorFinalCad = new JLabel("R$");
		lbValorFinalCad.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbValorFinalCad, "cell 3 27");

		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btConfirmar, "cell 2 28,growx");

		btCalcEdi.setBorderPainted(false);
		btSalvar.setBorderPainted(false);
		btConfirmar.setBorderPainted(false);

		btCalcEdi.setFocusPainted(false);
		btSalvar.setFocusPainted(false);
		btConfirmar.setFocusPainted(false);

		interrogacaoHrsPrev = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(234, 219, 247));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		add(interrogacaoHrsPrev, "cell 1 14");

		interrogacaoQuantMaxDias = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(234, 219, 247));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		add(interrogacaoQuantMaxDias, "cell 3 14");

		interrogacaoCustoAdic = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(234, 219, 247));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		add(interrogacaoCustoAdic, "cell 1 16");

		ImageIcon iconInterrogacao = new ImageIcon(
				CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png"));

		Image imgInterrogacao = iconInterrogacao.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		interrogacaoHrsPrev.setIcon(new ImageIcon(imgInterrogacao));
		interrogacaoQuantMaxDias.setIcon(new ImageIcon(imgInterrogacao));
		interrogacaoCustoAdic.setIcon(new ImageIcon(imgInterrogacao));

		interrogacaoQuantMaxDias.setOpaque(false);
		interrogacaoHrsPrev.setOpaque(false);
		interrogacaoCustoAdic.setOpaque(false);

		interrogacaoHrsPrev.setToolTipText(
				"<html><div style = 'width:100px;' > A quantidade de horas que você acha que levará para finalizar o trabalho. </div></html>");
		interrogacaoQuantMaxDias.setToolTipText(
				"<html><div style='width:80px;'>" + "A quantidade máxima de dias que você tem para finalizar o pedido. "
						+ "Você pode indicar em números inteiros, como 1, 2, 3..." + "</div></html>");
		interrogacaoCustoAdic.setToolTipText("<html> <div style='width:100px;'>"
				+ "Custos adicionais podem incluir frete, reelaboração do pedido,  entre outros... </div></html>");

	}

	public void calcEdita(ActionListener actionListener) {
		this.btCalcEdi.addActionListener(actionListener);
	}

	public void salvarValor(ActionListener actionListener) {
		this.btSalvar.addActionListener(actionListener);
	}

	public void confirmar(ActionListener actionListener) {
		this.btConfirmar.addActionListener(actionListener);
	}

	public void adicionar(ActionListener actionListener) {
		this.btAdicionar.addActionListener(actionListener);
	}

	public void remover(ActionListener actionListener) {
		this.btRemover.addActionListener(actionListener);
	}

	public void voltar(MouseListener mouseListener) {
		this.lbVoltar.addMouseListener(mouseListener);
	}

	public JTextField getTfNomeCliente() {
		return tfNomeCliente;
	}

	public void setTfNomeCliente(JTextField tfNomeCliente) {
		this.tfNomeCliente = tfNomeCliente;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	public JTextField getTfContato() {
		return tfContato;
	}

	public void setTfContato(JTextField tfContato) {
		this.tfContato = tfContato;
	}

	public JTextField getTfHorasPrevistas() {
		return tfHorasPrevistas;
	}

	public void setTfHorasPrevistas(JTextField tfHorasPrevistas) {
		this.tfHorasPrevistas = tfHorasPrevistas;
	}

	public JTextField getTfQuantMaxDias() {
		return tfQuantMaxDias;
	}

	public void setTfQuantMaxDias(JTextField tfQuantMaxDias) {
		this.tfQuantMaxDias = tfQuantMaxDias;
	}

	public JLabel getLbPrecoHoraUsuario() {
		return lbPrecoHoraUsuario;
	}

	public void setLbPrecoHoraUsuario(JLabel lbPrecoHoraUsuario) {
		this.lbPrecoHoraUsuario = lbPrecoHoraUsuario;
	}

	public JLabel getLbPercLucroUsuario() {
		return lbPercLucroUsuario;
	}

	public void setLbPercLucroUsuario(JLabel lbPercLucroUsuario) {
		this.lbPercLucroUsuario = lbPercLucroUsuario;
	}

	public JLabel getLbValorCalLucroAdici() {
		return lbLucroAdicionalCad;
	}

	public void setLbValorCalLucroAdici(JLabel lbValorCalLucroAdici) {
		this.lbLucroAdicionalCad = lbValorCalLucroAdici;
	}

	public JLabel getLbCalcLucro() {
		return lbCalcLucro;
	}

	public void setLbCalcLucro(JLabel lbCalcLucro) {
		this.lbCalcLucro = lbCalcLucro;
	}

	public JLabel getLbCalcGastos() {
		return lbCalcGastos;
	}

	public void setLbCalcGastos(JLabel lbCalcGastos) {
		this.lbCalcGastos = lbCalcGastos;
	}

	public JLabel getLbValorCalVenda() {
		return lbValorCalVenda;
	}

	public void setLbValorCalVenda(JLabel lbValorCalVenda) {
		this.lbValorCalVenda = lbValorCalVenda;
	}

	public JButton getBtCalcEdi() {
		return btCalcEdi;
	}

	public void setBtCalcEdi(JButton btCalcEdi) {
		this.btCalcEdi = btCalcEdi;
	}

	public JButton getBtConfirmar() {
		return btConfirmar;
	}

	public void setBtConfirmar(JButton btConfirmar) {
		this.btConfirmar = btConfirmar;
	}

	public JLabel getLbValorLucroAdicional() {
		return lbLucroAdicional;
	}

	public void setLbValorLucroAdicional(JLabel lbValorLucroAdicional) {
		this.lbLucroAdicional = lbValorLucroAdicional;
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

	public JButton getBtSalvar() {
		return btSalvar;
	}

	public void setBtSalvar(JButton btSalvar) {
		this.btSalvar = btSalvar;
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

	public JTextField getTfDataConfPedido() {
		return tfDataConfPedido;
	}

	public void setTfDataConfPedido(JTextField tfDataConfPedido) {
		this.tfDataConfPedido = tfDataConfPedido;
	}

	public JTextField getTfDtPrevEntrega() {
		return tfDtPrevEntrega;
	}

	public void setTfDtPrevEntrega(JTextField tfDtPrevEntrega) {
		this.tfDtPrevEntrega = tfDtPrevEntrega;
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

	public JComboBox getCbFormaPaga() {
		return cbFormaPaga;
	}

	public void setCbFormaPaga(JComboBox cbFormaPaga) {
		this.cbFormaPaga = cbFormaPaga;
	}

	public JLabel getLbValorFinalCad() {
		return lbValorFinalCad;
	}

	public void setLbValorFinalCad(JLabel lbValorFinalCad) {
		this.lbValorFinalCad = lbValorFinalCad;
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

	public JTextField getTfCustoAdicional() {
		return tfCustoAdicional;
	}

	public void setTfCustoAdicional(JTextField tfCustoAdicional) {
		this.tfCustoAdicional = tfCustoAdicional;
	}

	public JComboBox<model.Orcamento.Status> getCbStatus() {
		return cbStatus;
	}

	public void setCbStatus(JComboBox<model.Orcamento.Status> cbStatus) {
		this.cbStatus = cbStatus;
	}

	public JButton getBtAdicionar() {
		return btAdicionar;
	}

	public void setBtAdicionar(JButton btAdicionar) {
		this.btAdicionar = btAdicionar;
	}

	public JButton getBtRemover() {
		return btRemover;
	}

	public void setBtRemover(JButton btRemover) {
		this.btRemover = btRemover;
	}

	public JTable getTabMateriaisEstoque() {
		return tabMateriaisEstoque;
	}

	public void setTabMateriaisEstoque(JTable tabMateriaisEstoque) {
		this.tabMateriaisEstoque = tabMateriaisEstoque;
	}

	public JTable getTabMateriaisOrcam() {
		return tabMateriaisOrcam;
	}

	public void setTabMateriaisOrcam(JTable tabMateriaisOrcam) {
		this.tabMateriaisOrcam = tabMateriaisOrcam;
	}

	public JTextField getTituloOrcamento() {
		return tituloOrcamento;
	}

	public void setTituloOrcamento(JTextField tituloOrcamento) {
		this.tituloOrcamento = tituloOrcamento;
	}

}