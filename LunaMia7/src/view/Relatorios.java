package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Relatorios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btRelatorioGT;
	private JButton btRelatorioHT;
	private JButton btRelatorioLC;
	
	/**
	 * Create the panel.
	 */
	public Relatorios() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow][][][grow]", "[grow][][][][][][][][grow]"));
		
		JLabel lbVisualizeRelatorioa = new JLabel("Visualize seus relatórios a\r\n partir do primeiro mês!");
		lbVisualizeRelatorioa.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbVisualizeRelatorioa, "cell 2 1");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(193, 151, 232));
		add(panel, "cell 2 3,grow");
		
		btRelatorioHT = new JButton("Relatório de Horas Trabalhadas");
		btRelatorioHT.setBackground(new Color(193, 151, 232));
		btRelatorioHT.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel.add(btRelatorioHT);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(193, 151, 232));
		add(panel_1, "cell 2 5,grow");
		
		btRelatorioLC = new JButton("Relatório de Lucros");
		btRelatorioLC.setBackground(new Color(193, 151, 232));
		btRelatorioLC.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_1.add(btRelatorioLC);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(193, 151, 232));
		add(panel_2, "cell 2 7,grow");
		
		btRelatorioGT = new JButton("Relatório de Gastos");
		btRelatorioGT.setBackground(new Color(193, 151, 232));
		btRelatorioGT.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_2.add(btRelatorioGT);
		
		btRelatorioHT.setBorderPainted(false);
		btRelatorioLC.setBorderPainted(false);
		btRelatorioGT.setBorderPainted(false);

	}
	
	public void relatorioHT(ActionListener actionListener) {
		this.btRelatorioHT.addActionListener(actionListener);
	}
	public void relatorioGT(ActionListener actionListener) {
		this.btRelatorioGT.addActionListener(actionListener);
	}
	public void relatorioLC(ActionListener actionListener) {
		this.btRelatorioLC.addActionListener(actionListener);
	}

}
