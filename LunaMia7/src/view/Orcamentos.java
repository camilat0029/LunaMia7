package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import model.MateriaPrima;
import model.MateriaPrimaTableModel;
import model.Orcamento;
import model.OrcamentoTableModel;

public class Orcamentos extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int COLUNA_BOTOES = 3;
	private JTable tabelaOrcamentos;
	private JButton btCriar;
	public OrcamentoTableModel tabelaModeloOrcamento;
	private JPopupMenu botoesAcoes;
	private Orcamento orcamentoSelecionado;
	
	private ActionListener acaoVisualizar, acaoAtualizar, acaoExcluir, acaoCancelar;

	public Orcamentos() {
		
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
		
		tabelaModeloOrcamento = new OrcamentoTableModel();
		tabelaOrcamentos = new JTable(tabelaModeloOrcamento);
		
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
		tabelaOrcamentos.getColumnModel().getColumn(3).setCellRenderer(tabelaOrcamentos.getDefaultRenderer(javax.swing.Icon.class));
		((DefaultTableCellRenderer)tabelaOrcamentos.getColumnModel().getColumn(3).getCellRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
		tabelaOrcamentos.getColumnModel().getColumn(0).setPreferredWidth(200); // Orçamentos
		tabelaOrcamentos.getColumnModel().getColumn(1).setPreferredWidth(200); // Status
		tabelaOrcamentos.getColumnModel().getColumn(2).setPreferredWidth(200); // Data
		tabelaOrcamentos.getColumnModel().getColumn(3).setPreferredWidth(200); // Cliente
		//tabelaOrcamentos.getColumnModel().getColumn(4).setPreferredWidth(50);  // Botão / mais
				
		scrollPane.setViewportView(tabelaOrcamentos);
		
		popupBotoes();
		eventoTabela();
				
		
	}
	
	private void popupBotoes() {
		
		botoesAcoes = new JPopupMenu();
		
		JMenuItem btVisualizar = new JMenuItem("Visualizar");
		JMenuItem btAtualizar = new JMenuItem("Atualizar");
		JMenuItem btExcluir = new JMenuItem("Excluir");
		JMenuItem btCancelar = new JMenuItem("Cancelar");
		
		btVisualizar.addActionListener(e -> {
			if(acaoVisualizar != null) {
				acaoVisualizar.actionPerformed(e);
			}
		});
		
		btAtualizar.addActionListener(e -> {
			if(acaoAtualizar != null) {
				acaoAtualizar.actionPerformed(e);
			}
		});
		
		btExcluir.addActionListener(e -> {
			if(acaoExcluir != null) {
				acaoExcluir.actionPerformed(e);
			}
		});
		
		btCancelar.addActionListener(e -> {
			if(acaoCancelar != null) {
				acaoCancelar.actionPerformed(e);
			}
		});
		
		botoesAcoes.add(btVisualizar);
		botoesAcoes.add(btAtualizar);
		botoesAcoes.add(btExcluir);
		botoesAcoes.add(btCancelar);
		
	}
	
	private void eventoTabela() {
		
		tabelaOrcamentos.addMouseListener(new java.awt.event.MouseAdapter() {
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
				int linha = tabelaOrcamentos.rowAtPoint(e.getPoint());
				int coluna = tabelaOrcamentos.columnAtPoint(e.getPoint());
				
				if (linha != -1 && coluna == COLUNA_BOTOES){
					
					orcamentoSelecionado = tabelaModeloOrcamento.getOrcamento(linha);
					botoesAcoes.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		
	}
	
	public void visualizar(java.util.function.Consumer<Orcamento> actionListener) {
		this.acaoVisualizar = e -> actionListener.accept(orcamentoSelecionado);
	}
	
	public void atualizar(java.util.function.Consumer<Orcamento> actionListener) {
		this.acaoAtualizar = e -> actionListener.accept(orcamentoSelecionado);
	}
	
	public void excluir(java.util.function.Consumer<Orcamento> actionListener) {
		this.acaoExcluir = e -> actionListener.accept(orcamentoSelecionado);
	}
	
	public void cancelar(java.util.function.Consumer<Orcamento> actionListener) {
		this.acaoCancelar = e -> actionListener.accept(orcamentoSelecionado);
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