package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MateriaPrimaTableModel extends AbstractTableModel{
	
	private List<MateriaPrima> listaMateriasPrimas = new ArrayList<>();
	
	private String[] colunas = {"Nome", "Valor", "Quantia"};

	// QUANTAS LINHAS TEM A TABELA
	@Override
	public int getRowCount() {
		return listaMateriasPrimas.size();
	}

	// QUANTAS COLUNAS TEM A TABELA
	@Override
	public int getColumnCount() {
		return colunas.length;
	}
	
	// DEFINE O NOME DO TOPO DA TABELA
	@Override
	public String getColumnName(int colunm) {
		return colunas[colunm];
	}
	
	
	// DEFINE OQUE APARECE EM CADA CÉDULA DA TABELA
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		MateriaPrima materiaPrima = listaMateriasPrimas.get(rowIndex);
		
		switch (columnIndex) {
		
		case 0:
			return materiaPrima.getNome();
			
		case 1:
			return materiaPrima.getValor();
			
		case 2:
			return materiaPrima.getQuantidadeDisponivel();
			
		default:
			return null;
		}
		
	}
	
	// ADIOCIONA UM ITEM NA LISTA
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
	
	public void setLista(List<MateriaPrima> lista) {
		this.listaMateriasPrimas = lista;
		fireTableDataChanged();
	}
	
	public void limpar() {
		listaMateriasPrimas.clear();
		fireTableDataChanged();
	}
	
	
	

}
