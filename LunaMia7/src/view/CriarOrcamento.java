package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;

public class CriarOrcamento extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField tituloOrcamento, tfNomeCliente, tfEmail, tfContato,tfHorasPrevistas, tfQuantMaxDias;
	private JTextField tfDataConfPedido, tfDtPrevEntrega, tfValorFinal, tfCustoAdicional;
	
	private JLabel lbPrecoHoraUsuario, lbPercLucroUsuario, lbValorCalcSemLucro, lbCalcLucro, lbCalcGastos, lbValorCalVenda;
	private JLabel lbValorSemLucro, lbValorLucro, lbGastos, lbValorVenda, lbDtConfPedido, lbDtPrevEntrega;
	private JLabel lbFormaPaga, lbValorFinal, lbCustoAdicional, lbStatus;
	
	private JButton btCalcEdi, btSalvar, btConfirmar;
	
	private JComboBox cbFormaPaga;
	
	private JComboBox<model.Orcamento.Status> cbStatus;

	/**
	 * Create the panel.
	 */
	public CriarOrcamento() {
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020, 1117));
		
		setLayout(new MigLayout("gap 15", "[grow][207.00,grow][][207.00,grow][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][][][][][][grow]"));
		
		
		
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
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmail, "cell 1 5");
		
		JLabel lbContato = new JLabel("Contato");
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
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lblMateriais, "cell 1 9");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(239, 239, 239));
		add(panel, "cell 1 10,grow");
		
		JComboBox cbMateriais = new JComboBox();
		cbMateriais.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel.add(cbMateriais);
		
		JLabel lbHorasPrevistas = new JLabel("Horas previstas");
		lbHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbHorasPrevistas, "cell 1 11");
		
		JLabel lbQuantMaxDias = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbQuantMaxDias, "cell 3 11");
		
		tfHorasPrevistas = new JTextField();
		tfHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfHorasPrevistas.setColumns(10);
		add(tfHorasPrevistas, "cell 1 12,growx");
		
		tfQuantMaxDias = new JTextField();
		tfQuantMaxDias.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tfQuantMaxDias.setColumns(10);
		add(tfQuantMaxDias, "cell 3 12,growx");
		
		lbCustoAdicional = new JLabel("Custo Adicional");
		lbCustoAdicional.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCustoAdicional, "cell 1 13");
		
		lbStatus = new JLabel("Status do Pedido");
		lbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbStatus, "cell 3 13");
		
		tfCustoAdicional = new JTextField();
		tfCustoAdicional.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfCustoAdicional, "cell 1 14,growx");
		tfCustoAdicional.setColumns(10);
		
		cbStatus = new JComboBox();
		cbStatus.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(cbStatus, "cell 3 14,growx");
		
		btCalcEdi = new JButton("Calcular");
		btCalcEdi.setBackground(new Color(193, 151, 232));
		btCalcEdi.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btCalcEdi, "cell 2 15,growx,aligny center");
		
		lbValorSemLucro = new JLabel("Valor sem lucro");
		lbValorSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorSemLucro, "cell 1 16");
		
		lbValorLucro = new JLabel("Valor do lucro");
		lbValorLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorLucro, "cell 3 16");
		
		lbValorCalcSemLucro = new JLabel("R$");
		lbValorCalcSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbValorCalcSemLucro, "cell 1 17");
		
		lbCalcLucro = new JLabel("R$");
		lbCalcLucro.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbCalcLucro, "cell 3 17");
		
		lbGastos = new JLabel("Total de Gastos");
		lbGastos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbGastos, "cell 1 18");
		
		lbValorVenda = new JLabel("Valor de venda");
		lbValorVenda.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorVenda, "cell 3 18");
		
		lbCalcGastos = new JLabel("R$");
		lbCalcGastos.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbCalcGastos, "cell 1 19");
		
		lbValorCalVenda = new JLabel("R$");
		lbValorCalVenda.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(lbValorCalVenda, "cell 3 19");
		
		btSalvar = new JButton("Salvar");
		btSalvar.setBackground(new Color(193, 151, 232));
		btSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btSalvar, "cell 2 20,growx");
		
		
		lbDtConfPedido = new JLabel("Data de confirmação do pedido");
		lbDtConfPedido.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtConfPedido, "cell 1 21");
		
		lbDtPrevEntrega = new JLabel("Data prevista de entrega");
		lbDtPrevEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbDtPrevEntrega, "cell 3 21");
		
		tfDataConfPedido = new JTextField();
		tfDataConfPedido.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfDataConfPedido, "cell 1 22,growx");
		tfDataConfPedido.setColumns(10);
		
		tfDtPrevEntrega = new JTextField();
		tfDtPrevEntrega.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tfDtPrevEntrega, "cell 3 22,growx");
		tfDtPrevEntrega.setColumns(10);
		
		lbFormaPaga = new JLabel("Forma de pagamento");
		lbFormaPaga.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbFormaPaga, "cell 1 23");
		
		lbValorFinal = new JLabel("Valor final");
		lbValorFinal.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorFinal, "cell 3 23");
		
		cbFormaPaga = new JComboBox();
		cbFormaPaga.setModel(new DefaultComboBoxModel(new String[] {"Cartão Crédito", "Cartão Débito", "Pix", "Dinheiro", "Outro"}));
		cbFormaPaga.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(cbFormaPaga, "cell 1 24,growx");
		
		tfValorFinal = new JTextField();
		tfValorFinal.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(tfValorFinal, "cell 3 24,growx");
		tfValorFinal.setColumns(10);
		
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btConfirmar, "cell 2 25,growx");
		
		btCalcEdi.setBorderPainted(false);
		btSalvar.setBorderPainted(false);
		btConfirmar.setBorderPainted(false);

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


	public JLabel getLbValorCalcSemLucro() {
		return lbValorCalcSemLucro;
	}


	public void setLbValorCalcSemLucro(JLabel lbValorCalcSemLucro) {
		this.lbValorCalcSemLucro = lbValorCalcSemLucro;
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


	public JTextField getTfValorFinal() {
		return tfValorFinal;
	}


	public void setTfValorFinal(JTextField tfValorFinal) {
		this.tfValorFinal = tfValorFinal;
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


	public JComboBox getCbStatus() {
		return cbStatus;
	}


	public void setCbStatus(JComboBox cbStatus) {
		this.cbStatus = cbStatus;
	}
	

}
