package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MateriaPrimaViewTableModel extends AbstractTableModel{
	
	private List<MateriaPrima> listaMateriasPrimas = new ArrayList<>();
	
	private String[] colunas = {"Matérias Primas", "Quantidade", "Unidade de Medida", "..."};

	@Override
	public int getRowCount() {
		return listaMateriasPrimas.size();
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
		
		MateriaPrima materiaPrima = listaMateriasPrimas.get(rowIndex);
		
		switch (columnIndex) {
		
		case 0:
			return materiaPrima.getNome();
			
		case 1:
			return materiaPrima.getQuantidadeDisponivel();
			
		case 2:
			return materiaPrima.getUnidadeMedida();
			
		default:
			return null;
		}
	}
	
	// ADICIONA UM ITEM NA LISTA
	public void adicionarMatPrima(MateriaPrima matPrima) {
		listaMateriasPrimas.add(matPrima);
		
		fireTableRowsInserted(listaMateriasPrimas.size()-1, listaMateriasPrimas.size()-1);
	}
	
	//REMOVE UM ITEM DA LISTA
	public void removerMatPrima(int linha) {
		
		listaMateriasPrimas.remove(linha);
		fireTableRowsDeleted(linha, linha);
		
	}
	
	//RETORNA O OBJETO INTEIRO DA LINHA
	public MateriaPrima getMatPrima(int linha) {
		return listaMateriasPrimas.get(linha);
	}
	
	//INSERE UMA LISTA
	public void setLista(List<MateriaPrima> lista) {
		this.listaMateriasPrimas = lista;
		fireTableDataChanged();
	}
	
	//LIMPA A LISTA
	public void limpar() {
		listaMateriasPrimas.clear();
		fireTableDataChanged();
	}  
	
	//PROCURA UMA MATERIA PRIMA PELO SEU ID
	public int procurarId(int idMateriaPrima) {
		
		for (int i = 0; i < listaMateriasPrimas.size(); i++) {
			
			if (listaMateriasPrimas.get(i).getIdMateriaPrima() == idMateriaPrima) {
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
