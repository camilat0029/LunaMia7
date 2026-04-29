package view;

import javax.swing.JPanel;
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

public class CriarOrcamento extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tituloOrcamento;
	private JTextField tfNomeCliente;
	private JTextField tfEmail;
	private JTextField tfContato;
	private JTextField tfPrecoHora;
	private JTextField tfPercentualLucro;
	private JTextField tfHorasPrevistas;
	private JTextField tfQuantMaxDias;
	private JButton btCalcular;

	/**
	 * Create the panel.
	 */
	public CriarOrcamento() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lbTituloOrcamento = new JLabel("Título do orçamento");
		lbTituloOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTituloOrcamento, "cell 2 1 3 1");
		
		tituloOrcamento = new JTextField();
		tituloOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		add(tituloOrcamento, "cell 2 2 3 1,growx");
		tituloOrcamento.setColumns(10);
		
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
		tfPercentualLucro.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfPercentualLucro.setColumns(10);
		add(tfPercentualLucro, "cell 4 11,growx");
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lblMateriais, "cell 2 13");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 14,grow");
		
		JComboBox cbMateriaisCO = new JComboBox();
		cbMateriaisCO.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		panel.add(cbMateriaisCO);
		
		JLabel lbHorasPrevistas = new JLabel("Horas previstas");
		lbHorasPrevistas.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbHorasPrevistas, "cell 2 16");
		
		JLabel lbQuantMaxDiasCO = new JLabel("Quantidade máxima de dias");
		lbQuantMaxDiasCO.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(lbQuantMaxDiasCO, "cell 4 16");
		
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
		
		btCalcular = new JButton("Calcular");
		btCalcular.setBackground(new Color(193, 151, 232));
		btCalcular.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_1.add(btCalcular);
		btCalcular.setBorderPainted(false);

	}
	
	public void calcular(ActionListener actionListener) {
		this.btCalcular.addActionListener(actionListener);
	}
	
	
	

}
