package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class OrcamentoTableModel extends AbstractTableModel{
	
	private final javax.swing.ImageIcon ICONE_ACOES = new javax.swing.ImageIcon(getClass().getResource("/imagensIcones/Icone_3_Pontos.png"));
	
	private List<Orcamento> listaOrcamentos = new ArrayList<>();
	
	private String[] colunas = {"Orcamentos", "Status", "Cliente", "Ações"};

	@Override
	public int getRowCount() {
		return listaOrcamentos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Orcamento orcamento = listaOrcamentos.get(rowIndex);
		
		switch(columnIndex) {
		
		case 0:
			return orcamento.getTituloPedido();
			
		case 1:
			return orcamento.getStatus();
			
		case 2:
			return orcamento.getCliente().getNome();
			
		case 3:
			return ICONE_ACOES;
			
		default: 
			return null;
		}
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    if (columnIndex == 3) {
	        return javax.swing.Icon.class;
	    }
	    return super.getColumnClass(columnIndex);
	}
	
	// ADICIONA UM ITEM NA LISTA
	public void adicionarOrcamento(Orcamento orcam) {
		listaOrcamentos.add(orcam);
		fireTableRowsInserted(listaOrcamentos.size()-1, listaOrcamentos.size()-1);
	}
		
	//REMOVE UM ITEM DA LISTA
	public void removerOrcamento(int linha) {
			
		listaOrcamentos.remove(linha);
		fireTableRowsDeleted(linha, linha);
			
	}
		
	//RETORNA O OBJETO INTEIRO DA LINHA
	public Orcamento getOrcamento(int linha) {
		return listaOrcamentos.get(linha);
	}
		
	//INSERE UMA LISTA
	public void setLista(List<Orcamento> lista) {
		this.listaOrcamentos = lista;
		fireTableDataChanged();
	}
		
	//LIMPA A LISTA
	public void limpar() {
		listaOrcamentos.clear();
		fireTableDataChanged();
	}  
		
	//PROCURA UMA MATERIA PRIMA PELO SEU ID
	public int procurarId(int idOrcamento) {
			
		for (int i = 0; i < listaOrcamentos.size(); i++) {
				
			if (listaOrcamentos.get(i).getIdOrcamento() == idOrcamento) {
				return i;
			}
		}
			
		return -1;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}