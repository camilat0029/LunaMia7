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

import model.MateriaPrimaTableModel;

public class Orcamentos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaOrcamentos;
	private JButton btCriar;
	public DefaultTableModel tabelaModeloOrcamentos;
	//public MateriaPrimaTableModel tabModeloOrcamentos = new MateriaPrimaTableModel();

	/**
	 * Create the panel.
	 */
	public Orcamentos() {
		
		//FAZER A TABELA EM STATIC PARA PODER EDITAR COM AS COISAS DO BANCO 
		
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow][-60.00][][389.00][grow]", "[][][grow][]"));
		
		JLabel lbCrieNovoOrcamento = new JLabel("Crie um novo orçamento");
		lbCrieNovoOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCrieNovoOrcamento, "cell 2 1,alignx center");
		
		btCriar = new JButton("Criar");
		btCriar.setBackground(new Color(193, 151, 232));
		btCriar.setBorderPainted(false);
		btCriar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btCriar, "cell 3 1,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 2 2 1,grow");
		
		;
		
		String[] colunas = {"Orcamentos", "Status", "Cliente", ""};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		tabelaOrcamentos = new JTable(modelo);
		
		//Estilização do cabeçalho
		
		JTableHeader header = tabelaOrcamentos.getTableHeader();
		header.setBackground(new Color(234, 219, 247));
		header.setForeground(new Color(103, 80, 125));
		header.setFont(new Font("Times New Roman", Font.BOLD, 18));
		header.setReorderingAllowed(false); // impede arrastar colunas
		
		//Estilização das linhas e colunas
		
		tabelaOrcamentos.setRowHeight(35);
		tabelaOrcamentos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tabelaOrcamentos.setGridColor(new Color(220, 220, 220));
		tabelaOrcamentos.setShowVerticalLines(false);
		tabelaOrcamentos.setSelectionBackground(new Color(193, 151, 232));
		tabelaOrcamentos.setSelectionForeground(Color.WHITE);
		
		scrollPane.setBorder(null);
		tabelaOrcamentos.setBorder(null);
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
		center.setHorizontalAlignment(JLabel.CENTER);

		tabelaOrcamentos.getColumnModel().getColumn(1).setCellRenderer(center);
		tabelaOrcamentos.getColumnModel().getColumn(2).setCellRenderer(center);
		
		tabelaOrcamentos.getColumnModel().getColumn(0).setPreferredWidth(200); // Orçamentos
		tabelaOrcamentos.getColumnModel().getColumn(1).setPreferredWidth(200); // Status
		tabelaOrcamentos.getColumnModel().getColumn(2).setPreferredWidth(200); // Data
		tabelaOrcamentos.getColumnModel().getColumn(3).setPreferredWidth(200); // Cliente
		//tabelaOrcamentos.getColumnModel().getColumn(4).setPreferredWidth(50);  // Botão / mais
				
		scrollPane.setViewportView(tabelaOrcamentos);
				
		
	}
	
	public void criar(ActionListener actionListener) {
		this.btCriar.addActionListener(actionListener);
	}

	public JTable getTabelaOrcamentos() {
		return tabelaOrcamentos;
	}

	public void setTabelaOrcamentos(JTable tabelaOrcamentos) {
		this.tabelaOrcamentos = tabelaOrcamentos;
	}
	
	

}