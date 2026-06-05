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
import model.MateriaPrimaViewTableModel;

public class MateriaPrimaView extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int COLUNA_BOTOES = 3;
	private JTable tabelaMateriaPrima;
	private JButton btAdicionar;
	public MateriaPrimaViewTableModel tabelaModeloMateriaPrima;
	private JPopupMenu botoesAcoes;
	private MateriaPrima materiaSelecionada;
	
	
	private ActionListener acaoVisualizar, acaoAtualizar, acaoExcluir;
	

	/**
	 * Create the panel.
	 */
	public MateriaPrimaView() {
		
		setBackground(new Color(239, 239, 239));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[grow][-60.00][][389.00][grow]", "[grow][][][grow]"));
		
		JLabel lbCrieNovoOrcamento = new JLabel("Adicione uma nova matéria prima");
		lbCrieNovoOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCrieNovoOrcamento, "cell 2 1,alignx center");
		
		btAdicionar = new JButton("Adicionar");
		btAdicionar.setBackground(new Color(193, 151, 232));
		btAdicionar.setBorderPainted(false);
		btAdicionar.setFocusPainted(false);
		btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(btAdicionar, "cell 3 1,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, "cell 2 2 2 1,grow");
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(20);
		
		tabelaModeloMateriaPrima = new MateriaPrimaViewTableModel();
		tabelaMateriaPrima = new JTable(tabelaModeloMateriaPrima);
		scrollPane.setViewportView(tabelaMateriaPrima);
			
		JTableHeader header = tabelaMateriaPrima.getTableHeader();
		
		header = new JTableHeader(tabelaMateriaPrima.getColumnModel()) {

		    @Override
		    public String getToolTipText(java.awt.event.MouseEvent e) {

		        int coluna = columnAtPoint(e.getPoint());

		        if (coluna == COLUNA_BOTOES) {
		        	
		            return "<html> <div style = 'width:100px;'><b>Visualizar</b>: para ver detalhes<br><b>Atualizar</b>: permite modificar"
		            		+ "<br> <b>Excluir</b>: pode ser excluída se não estiver vinculada a nenhum orçamento </div></html>";
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

		tabelaMateriaPrima.setTableHeader(header);
		header.setBackground(new Color(234, 219, 247));
		header.setForeground(new Color(103, 80, 125));
		header.setFont(new Font("Times New Roman", Font.BOLD, 20));
		header.setReorderingAllowed(false);
		
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
		tabelaMateriaPrima.getColumnModel().getColumn(3).setCellRenderer(tabelaMateriaPrima.getDefaultRenderer(javax.swing.Icon.class));
		((DefaultTableCellRenderer)tabelaMateriaPrima.getColumnModel().getColumn(3).getCellRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
		tabelaMateriaPrima.getColumnModel().getColumn(0).setPreferredWidth(200); // Matérias Primas
		tabelaMateriaPrima.getColumnModel().getColumn(1).setPreferredWidth(200); // Quantidade
		tabelaMateriaPrima.getColumnModel().getColumn(2).setPreferredWidth(200); // Unidade de Medida
		tabelaMateriaPrima.getColumnModel().getColumn(3).setPreferredWidth(50);  // Botão / mais
				
		scrollPane.setViewportView(tabelaMateriaPrima);
		
		addComponentListener(new ComponentAdapter() {
			
		        @Override
		        public void componentResized(ComponentEvent e) {

		            int largura = getWidth();

		            // Fonte dos labels e botão (igual ao Login e CadastroUsuario)
		            int fonteLabel = Math.max(18, Math.min(30, largura / 40));
		            lbCrieNovoOrcamento.setFont(new Font("Times New Roman", Font.PLAIN, fonteLabel));
		            btAdicionar.setFont(new Font("Times New Roman", Font.PLAIN, fonteLabel));

		            // Fonte e altura da tabela crescem a partir de 1280px
		            if (largura >= 1280) {
		            	
		                int fonteTabela = Math.max(16, Math.min(20, largura / 55));
		                int alturaLinha = Math.max(30, largura / 35);

		                tabelaMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, fonteTabela));
		                tabelaMateriaPrima.setRowHeight(alturaLinha);
		                tabelaMateriaPrima.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, fonteTabela + 2));
		            } else {
		                tabelaMateriaPrima.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		                tabelaMateriaPrima.setRowHeight(35);
		                tabelaMateriaPrima.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));
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
		
		Font fonteMenu = new Font("Bodoni Bk BT", Font.BOLD, 16);
	    Color corTexto = new Color(80,80,80); 

	    JMenuItem[] itens = {btVisualizar, btAtualizar, btExcluir};
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
		
		botoesAcoes.add(btVisualizar);
		botoesAcoes.add(btAtualizar);
		botoesAcoes.add(btExcluir);
		
	}
	
	private void eventoTabela() {
		
		tabelaMateriaPrima.addMouseListener(new java.awt.event.MouseAdapter() {
			
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int linha = tabelaMateriaPrima.rowAtPoint(e.getPoint());
				int coluna = tabelaMateriaPrima.columnAtPoint(e.getPoint());
				
				if(linha != -1 && coluna == COLUNA_BOTOES) {
					
					materiaSelecionada = tabelaModeloMateriaPrima.getMatPrima(linha);
					
					botoesAcoes.show(e.getComponent(),e.getX(), e.getY());
				}
			}
		});
	}
	
	public void visualizar(java.util.function.Consumer<MateriaPrima> actionListener) {
		this.acaoVisualizar = e -> actionListener.accept(materiaSelecionada);
	}
	
	public void atualizar(java.util.function.Consumer<MateriaPrima> actionListener) {
		this.acaoAtualizar = e -> actionListener.accept(materiaSelecionada);;
	}
	
	public void excluir(java.util.function.Consumer<MateriaPrima> actionListener) {
		this.acaoExcluir = e -> actionListener.accept(materiaSelecionada);;
	}
	
	public void adicionar(ActionListener actionListener) {
		this.btAdicionar.addActionListener(actionListener);
	}

	public JTable getTabelaMateriaPrima() {
		return tabelaMateriaPrima;
	}

	public void setTabelaMateriaPrima(JTable tabelaMateriaPrima) {
		this.tabelaMateriaPrima = tabelaMateriaPrima;
	}
	
	public void adicionarOuvinte(ComponentListener listener) {
		this.addComponentListener(listener);
	}
	
	

}
