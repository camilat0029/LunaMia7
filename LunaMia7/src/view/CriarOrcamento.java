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

public class CriarOrcamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tituloOrcamento;
	private JTextField tfNomeCliente;
	private JTextField tfEmail;
	private JTextField tfContato;
	private JTextField tfHorasPrevistas;
	private JTextField tfQuantMaxDias;
	private JLabel lbPrecoHoraUsuario, lbPercLucroUsuario, lbValorCalcSemLucro, lbCalcLucro, lbCalcGastos, lbValorCalVenda;
	private JLabel lbValorSemLucro, lbValorLucro, lbGastos, lbValorVenda;
	private JButton btCalcEdi;
	private JButton btConfirmar;

	/**
	 * Create the panel.
	 */
	public CriarOrcamento() {
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020, 890));
		
		setLayout(new MigLayout("gap 15", "[grow][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][grow]"));
		
		
		
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
		panel.setBackground(new Color(234, 219, 247));
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
		
		btCalcEdi = new JButton("Calcular");
		btCalcEdi.setBackground(new Color(193, 151, 232));
		btCalcEdi.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btCalcEdi, "cell 2 13,growx,aligny center");
		
		lbValorSemLucro = new JLabel("Valor sem lucro");
		lbValorSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorSemLucro, "cell 1 14");
		
		lbValorLucro = new JLabel("Valor do lucro");
		lbValorLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorLucro, "cell 3 14");
		
		lbValorCalcSemLucro = new JLabel("R$");
		lbValorCalcSemLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorCalcSemLucro, "cell 1 15");
		
		lbCalcLucro = new JLabel("R$");
		lbCalcLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCalcLucro, "cell 3 15");
		
		lbGastos = new JLabel("Total de Gastos");
		lbGastos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbGastos, "cell 1 16");
		
		lbValorVenda = new JLabel("Valor de venda");
		lbValorVenda.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorVenda, "cell 3 16");
		
		lbCalcGastos = new JLabel("R$");
		lbCalcGastos.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCalcGastos, "cell 1 17");
		
		lbValorCalVenda = new JLabel("R$");
		lbValorCalVenda.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbValorCalVenda, "cell 3 17");
		
		btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btConfirmar, "cell 2 18");
		
		btCalcEdi.setBorderPainted(false);
		btConfirmar.setBorderPainted(false);

	}
	
	
	public void calcEdita(ActionListener actionListener) {
		this.btCalcEdi.addActionListener(actionListener);
	}
	
	public void confirmarValor(ActionListener actionListener) {
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
	
	
	
	
	
	
	

}
