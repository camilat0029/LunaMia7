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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolTip;
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
		setLayout(new MigLayout("", "[grow][-60.00][][389.00][grow]", "[grow][][][grow]"));
		
		JLabel lbCrieNovoOrcamento = new JLabel("Crie um novo orçamento");
		lbCrieNovoOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCrieNovoOrcamento, "cell 2 1,alignx center");
		
		btCriar = new JButton("Criar");
		btCriar.setBackground(new Color(193, 151, 232));
		btCriar.setBorderPainted(false);
		btCriar.setFocusPainted(false);
		btCriar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btCriar, "cell 3 1,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 2 2 1,grow");
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		tabelaModeloOrcamento = new OrcamentoTableModel();
		tabelaOrcamentos = new JTable(tabelaModeloOrcamento);
		
		JTableHeader header = tabelaOrcamentos.getTableHeader();		
		header = new JTableHeader(tabelaOrcamentos.getColumnModel()) {

		    @Override
		    public String getToolTipText(java.awt.event.MouseEvent e) {

		        int coluna = columnAtPoint(e.getPoint());

		        if (coluna == COLUNA_BOTOES) {
		        	
		            return "<html> <div style = 'width:100px;'><b>Visualizar</b>: para ver detalhes<br><b>Atualizar</b>: permite modificar"
		            		+ "<br> <b>Excluir</b>: todos os dados são apagados e as matérias primas não voltam para o estoque"
		            		+ "<br> <b>Cancelar</b>: o orçamento é apagado e as matérias primas voltam para o estoque</div></html>";
		        }

		        return null;
		    }
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(234, 219, 247));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		tabelaOrcamentos.setTableHeader(header);

		header.setBackground(new Color(234, 219, 247));
		header.setForeground(new Color(103, 80, 125));
		header.setFont(new Font("Times New Roman", Font.BOLD, 18));
		header.setReorderingAllowed(false); 
		
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
		
		addComponentListener(new ComponentAdapter() {
			
	        @Override
	        public void componentResized(ComponentEvent e) {

	            int largura = getWidth();

	            // Fonte dos labels e botão (igual ao Login e CadastroUsuario)
	            int fonteLabel = Math.max(18, Math.min(30, largura / 40));
	            lbCrieNovoOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, fonteLabel));
	            btCriar.setFont(new Font("Times New Roman", Font.PLAIN, fonteLabel));

	            // Fonte e altura da tabela crescem a partir de 1280px
	            if (largura >= 1280) {
	            	
	                int fonteTabela = Math.max(16, Math.min(20, largura / 55));
	                int alturaLinha = Math.max(30, largura / 35);

	                tabelaOrcamentos.setFont(new Font("Times New Roman", Font.PLAIN, fonteTabela));
	                tabelaOrcamentos.setRowHeight(alturaLinha);
	                tabelaOrcamentos.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, fonteTabela + 2));

	            } else {
	            	tabelaOrcamentos.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	                tabelaOrcamentos.setRowHeight(35);
	                tabelaOrcamentos.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));

	            }
	        }

	});
		
		popupBotoes();
		eventoTabela();
				
		
	}
	
	private void popupBotoes() {
		
		botoesAcoes = new JPopupMenu();
		
		botoesAcoes.setBackground(new Color(234, 219, 247));
	    botoesAcoes.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(234, 219, 247)));
		
		JMenuItem btVisualizar = new JMenuItem("Visualizar");
		JMenuItem btAtualizar = new JMenuItem("Atualizar");
		JMenuItem btExcluir = new JMenuItem("Excluir");
		JMenuItem btCancelar = new JMenuItem("Cancelar");
		
		Font fonteMenu = new Font("Bodoni Bk BT", Font.BOLD, 16);
	    Color corTexto = new Color(80,80,80); 

	    JMenuItem[] itens = {btVisualizar, btAtualizar, btExcluir, btCancelar};
	    for (JMenuItem item : itens) {
	        item.setFont(fonteMenu);
	        item.setForeground(corTexto);
	        item.setOpaque(false); 
	        item.setContentAreaFilled(false); 
	        item.setBackground(new Color(0, 0, 0, 0)); 
	        
	        item.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 15, 5, 15));
	    }
		
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
	
	public void adicionarOuvinte(ComponentListener listener) {
		this.addComponentListener(listener);
	}
}