package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Orcamentos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaOrcamentos;

	/**
	 * Create the panel.
	 */
	public Orcamentos() {
		
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow][][][][grow]", "[][][grow][]"));
		
		JLabel lbCrieNovoOrcamento = new JLabel("Crie um novo orçamento");
		lbCrieNovoOrcamento.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbCrieNovoOrcamento, "cell 2 1,alignx center");
		
		JButton btCriar = new JButton("Criar");
		btCriar.setBackground(new Color(193, 151, 232));
		btCriar.setBorderPainted(false);
		btCriar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(btCriar, "cell 3 1,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 2 2 1,grow");
		
		;
		
		String[] colunas = {"Orcamentos", "Status", "Data de Entrega", "Cliente", ""};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		tabelaOrcamentos = new JTable(modelo);
		

		tabelaOrcamentos.getTableHeader().setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
				
		scrollPane.setViewportView(tabelaOrcamentos);
				
	}
	
	//public void adicionarLinha(String tituloOrcamento, boolean status, String dataEntrega, String cliente, String mais) {
	//	modelo.addRow(new Object[] {tituloOrcamento, status, dataEntrega, cliente, mais});
		
	//}

}
