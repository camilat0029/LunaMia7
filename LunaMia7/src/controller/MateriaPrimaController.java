package controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.MateriaPrimaDAO;
import view.CadastroMateriaPrimaEstoque;
import view.MateriaPrimaView;
import model.MateriaPrima;

public class MateriaPrimaController {
	
	private MateriaPrima materiaPrima;
	private MateriaPrimaView materiaPrimaView;
	private MateriaPrimaDAO materiaPrimaDAO;
	private NavegadorTelas navegador;
	private CadastroMateriaPrimaEstoque cadastroMateriaPrima;
	private Menu menu;
	private boolean nomeMateria;
	private boolean marca;

	public MateriaPrimaController( MateriaPrima materiaPrima, 
			MateriaPrimaDAO materiaPrimaDAO, NavegadorTelas navegador, Menu menu,
			CadastroMateriaPrimaEstoque cadastroMateriaPrima, MateriaPrimaView materiaPrimaView) {
		
		this.materiaPrima = materiaPrima;
		this.materiaPrimaDAO = materiaPrimaDAO;
		this.navegador = navegador;
		this.cadastroMateriaPrima = cadastroMateriaPrima;
		this.menu = menu;
		this.materiaPrimaView = materiaPrimaView;
		
		this.cadastroMateriaPrima.confirmar(e ->{
			
			cadastrarMateriaPrima();
			
		});
			
		this.cadastroMateriaPrima.voltar(new MouseAdapter() {
				
			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.navegarTela("MATERIA_PRIMA");
				menu.mostrarPanelCont();
		
			}
		});
		
		
		this.materiaPrimaView.adicionar(e->{
			navegador.navegarTela("CADASTRO_MATERIA_PRIMA");
			menu.removerMenu();
		});
		
	}
	
	public void cadastrarMateriaPrima() {
		
		if(cadastroMateriaPrima.getTfNomeMateriaPrima().getText().isEmpty() ||
				cadastroMateriaPrima.getTfQtdDisponivel().getText().isEmpty() ||
				cadastroMateriaPrima.getTfQtdUnidade().getText().isEmpty() || 
				cadastroMateriaPrima.getTfValor().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null,"Você precisa preencher os campos obrigatórios!", "Informação",1);
			menu.removerMenu();
			
		} else {
			
			
			MateriaPrima novaMateriaPrima = new MateriaPrima (null,null,null, 0,0,0, null);
			
			novaMateriaPrima.setNome(cadastroMateriaPrima.getTfNomeMateriaPrima().getText());
			novaMateriaPrima.setCor(cadastroMateriaPrima.getTfCor().getText());
			novaMateriaPrima.setMarca(cadastroMateriaPrima.getTfMarca().getText());
			novaMateriaPrima.setQuantidadeDisponivel(Integer.parseInt(cadastroMateriaPrima.getTfQtdDisponivel().getText()));
			novaMateriaPrima.setQtdPorUnidade(Float.parseFloat(cadastroMateriaPrima.getTfQtdUnidade().getText()));
			novaMateriaPrima.setValor(Float.parseFloat(cadastroMateriaPrima.getTfValor().getText()));
			novaMateriaPrima.setUnidadeMedida((MateriaPrima.UnidadeMedida) cadastroMateriaPrima.getCbUnidadeMedida().getSelectedItem());
			
			materiaPrimaDAO.adicionarInsumos(novaMateriaPrima);
			this.materiaPrima = novaMateriaPrima;
			
			limparCamposMP();
			carregarTabela();
			JOptionPane.showMessageDialog(null, "Matéria Prima cadastrada com sucesso!", "Ação realizada com sucesso",1);
			
		}
		

	}
	
	public void limparCamposMP() {
		cadastroMateriaPrima.getTfNomeMateriaPrima().setText("");
		cadastroMateriaPrima.getTfCor().setText("");
		cadastroMateriaPrima.getTfMarca().setText("");
		cadastroMateriaPrima.getTfQtdDisponivel().setText("");
		cadastroMateriaPrima.getTfQtdUnidade().setText("");
		cadastroMateriaPrima.getTfValor().setText("");
		cadastroMateriaPrima.getCbUnidadeMedida().setSelectedIndex(0);
		
	}
	
	public void carregarTabela() {
		
		List<MateriaPrima> lista = MateriaPrimaDAO.listarMateriaPrima();
		materiaPrimaView.tabelaModeloMateriaPrima=(DefaultTableModel) materiaPrimaView.getTabelaMateriaPrima().getModel();
		
			for(MateriaPrima mp : lista) {
				Object[] materiasPrimas = {mp.getNome(), mp.getQuantidadeDisponivel(), mp.getUnidadeMedida()};
				materiaPrimaView.tabelaModeloMateriaPrima.addRow(materiasPrimas);
			}
			
		}
	
	
	public boolean qtdDisponivelPermitida(String qtdDisponivelValida) {
		boolean valido;
		if(!qtdDisponivelValida.matches("\\d+")) {
			valido=false;
		}
		else {
			valido=true;
		}
		return valido;
	} 
	
	public boolean qtdUnidadePermitida(String qtdUnidadeValida) {
		
		boolean valido;
		if(!qtdUnidadeValida.matches("\\d+")) {
			valido=false;
		}
		else {
			valido=true;
		}
		return valido;
	}
	
	public boolean valorPermitido(String valorValido) {
		boolean valido;
		if(!valorValido.matches("\\d+(\\.\\d{1,2})?")){
			valido=false;
		}
		else {
			valido=true;
		}
		return valido;
	}

}
