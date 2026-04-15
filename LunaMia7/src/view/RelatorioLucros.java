package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.event.MouseListener;

import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;

public class RelatorioLucros extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tabelaLucros;
	private JLabel lbVoltar;

	/**
	 * Create the panel.
	 */
	public RelatorioLucros() {
		setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][][][][][][][][grow]"));
		
		lbVoltar = new JLabel("");
		lbVoltar.setIcon(new ImageIcon(RelatorioLucros.class.getResource("/imagensIcones/Icone_SetaVaziaDentro.png")));
		add(lbVoltar, "cell 1 1");
		lbVoltar.setPreferredSize(new java.awt.Dimension(40, 40));

		JPanel panel = new JPanel();
		add(panel, "cell 2 3,grow");
		panel.setBackground(new Color(234, 219, 247));

		JLabel lbMes = new JLabel("Mês");
		lbMes.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbMes.setForeground(new Color(103, 80, 125));
		panel.add(lbMes);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 4,grow");

		String[] colunas = {"Pedidos", "Lucro", "Percentual de lucro",""};
		DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
		tabelaLucros = new JTable(modelo);
		
		JTableHeader header = tabelaLucros.getTableHeader();
		header.setBackground(new Color(234, 219, 247));
		header.setForeground(new Color(103, 80, 125));
		header.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		header.setReorderingAllowed(false);
		
		scrollPane.setViewportView(tabelaLucros);

		JPanel panelLucroMes = new JPanel();
		panelLucroMes.setBackground(new Color(234, 219, 247));
		add(panelLucroMes, "cell 2 6,grow");
		panelLucroMes.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel lbLucro = new JLabel("O lucro total obtido no mês foi de R$        .");
		lbLucro.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbLucro.setForeground(new Color(103, 80, 125));
		panelLucroMes.add(lbLucro);

		JPanel panelLucroDiferenca = new JPanel();
		panelLucroDiferenca.setBackground(new Color(234, 219, 247));
		add(panelLucroDiferenca, "cell 2 7,grow");
		panelLucroDiferenca.setLayout(new FlowLayout(FlowLayout.LEFT));

		JLabel lbDiferenca = new JLabel("Você obteve R$         de diferença no lucro em relação ao mês anterior");
		lbDiferenca.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lbDiferenca.setForeground(new Color(103, 80, 125));
		panelLucroDiferenca.add(lbDiferenca);

	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbVoltar.addMouseListener(mouseListener);
	}

}
