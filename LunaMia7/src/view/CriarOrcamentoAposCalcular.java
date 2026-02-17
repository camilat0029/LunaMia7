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
	private JTextField tituloOrcamento;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField txtR_1;
	private JTextField txtR;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Create the panel.
	 */
	public CriarOrcamentoAposCalcular() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][207.00][][207.00][grow]", "[grow][][][][][][][][][][][][][][][][][][][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Título do orçamento");
		lblNewLabel.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblNewLabel, "cell 2 1 3 1");
		
		tituloOrcamento = new JTextField();
		tituloOrcamento.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tituloOrcamento, "cell 2 2 3 1,growx");
		tituloOrcamento.setColumns(10);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do cliente");
		lblNomeDoCliente.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblNomeDoCliente, "cell 2 4");
		
		textField = new JTextField();
		textField.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField.setColumns(10);
		add(textField, "cell 2 5 3 1,growx");
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblEmail, "cell 2 7");
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblContato, "cell 4 7");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_1.setColumns(10);
		add(textField_1, "cell 2 8,growx");
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_2.setColumns(10);
		add(textField_2, "cell 4 8,growx");
		
		JLabel lblPreoDaHora = new JLabel("Preço da hora");
		lblPreoDaHora.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblPreoDaHora, "cell 2 10");
		
		JLabel lblPercentualDeLucro = new JLabel("Percentual de lucro");
		lblPercentualDeLucro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblPercentualDeLucro, "cell 4 10");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_3.setColumns(10);
		add(textField_3, "cell 2 11,growx");
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_4.setColumns(10);
		add(textField_4, "cell 4 11,growx");
		
		JLabel lblMateriais = new JLabel("Materiais");
		lblMateriais.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblMateriais, "cell 2 13");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 2 14,grow");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel.add(comboBox);
		
		JLabel lblHorasPrevistas = new JLabel("Horas previstas");
		lblHorasPrevistas.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblHorasPrevistas, "cell 2 16");
		
		JLabel lblQuantidadeMximaDe = new JLabel("Quantidade máxima de dias");
		lblQuantidadeMximaDe.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblQuantidadeMximaDe, "cell 4 16");
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_5.setColumns(10);
		add(textField_5, "cell 2 17,growx");
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_6.setColumns(10);
		add(textField_6, "cell 4 17,growx");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 3 19,grow");
		
		JButton btCalcular = new JButton("Editar");
		btCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCalcular.setBackground(new Color(193, 151, 232));
		btCalcular.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel_1.add(btCalcular);
		btCalcular.setBorderPainted(false);
		
		JLabel lblValorSemLucro = new JLabel("Valor sem lucro");
		lblValorSemLucro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblValorSemLucro, "cell 2 21");
		
		JLabel lblValorDoLucro = new JLabel("Valor do lucro");
		lblValorDoLucro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblValorDoLucro, "cell 4 21");
		
		txtR_1 = new JTextField();
		txtR_1.setText("R$");
		txtR_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		txtR_1.setColumns(10);
		add(txtR_1, "cell 2 22,growx");
		
		txtR = new JTextField();
		txtR.setText("R$");
		txtR.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		txtR.setColumns(10);
		add(txtR, "cell 4 22,growx");
		
		JLabel lblValorDeLucro = new JLabel("Total de gastos");
		lblValorDeLucro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblValorDeLucro, "cell 2 24");
		
		JLabel lblTotalDeGastos = new JLabel("Valor de venda");
		lblTotalDeGastos.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(lblTotalDeGastos, "cell 4 24");
		
		textField_7 = new JTextField();
		textField_7.setText("R$");
		textField_7.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_7.setColumns(10);
		add(textField_7, "cell 2 25,growx");
		
		textField_8 = new JTextField();
		textField_8.setText("R$");
		textField_8.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		textField_8.setColumns(10);
		add(textField_8, "cell 4 25,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 3 27,grow");
		
		JButton btConfirmar = new JButton("Confirmar");
		btConfirmar.setBackground(new Color(193, 151, 232));
		btConfirmar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		panel_2.add(btConfirmar);
		btConfirmar.setBorderPainted(false);
		

	}

}