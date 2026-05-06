package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class MateriaPrimaView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaMateriaPrima;
	private JButton btAdicionar;

	/**
	 * Create the panel.
	 */
	public MateriaPrimaView() {
		
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow][-60.00][][389.00][grow]", "[][][grow][]"));
		
		JLabel lbCrieNovoOrcamento = new JLabel("Adicione uma nova matéria prima");
		lbCrieNovoOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCrieNovoOrcamento, "cell 2 1,alignx center");
		
		btAdicionar = new JButton("Adicionar");
		btAdicionar.setBackground(new Color(193, 151, 232));
		btAdicionar.setBorderPainted(false);
		btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btAdicionar, "cell 3 1,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 2 2 1,grow");
		
		String[] colunas = {"Matérias Primas", "Quantidade", "Unidade de Medida", ""};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		tabelaMateriaPrima = new JTable(modelo);
		
		//Estilização do cabeçalho
		
		JTableHeader header = tabelaMateriaPrima.getTableHeader();
		header.setBackground(new Color(234, 219, 247));
		header.setForeground(new Color(103, 80, 125));
		header.setFont(new Font("Times New Roman", Font.BOLD, 20));
		header.setReorderingAllowed(false); // impede arrastar colunas
		
		//Estilização das linhas e colunas
		
		tabelaMateriaPrima.setRowHeight(35);
		tabelaMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tabelaMateriaPrima.setGridColor(new Color(220, 220, 220));
		tabelaMateriaPrima.setShowVerticalLines(false);
		tabelaMateriaPrima.setSelectionBackground(new Color(193, 151, 232));
		tabelaMateriaPrima.setSelectionForeground(Color.WHITE);
		
		scrollPane.setBorder(null);
		tabelaMateriaPrima.setBorder(null);
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		tabelaMateriaPrima.getColumnModel().getColumn(1).setCellRenderer(center);
		tabelaMateriaPrima.getColumnModel().getColumn(2).setCellRenderer(center);
		
		tabelaMateriaPrima.getColumnModel().getColumn(0).setPreferredWidth(200); // Matérias Primas
		tabelaMateriaPrima.getColumnModel().getColumn(1).setPreferredWidth(200); // Quantidade
		tabelaMateriaPrima.getColumnModel().getColumn(2).setPreferredWidth(200); // Unidade de Medida
		tabelaMateriaPrima.getColumnModel().getColumn(3).setPreferredWidth(50);  // Botão / mais
				
		scrollPane.setViewportView(tabelaMateriaPrima);
				
		
	}
	
	public void adicionar(ActionListener actionListener) {
		this.btAdicionar.addActionListener(actionListener);
	}

}
