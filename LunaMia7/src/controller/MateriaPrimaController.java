package controller;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.MateriaPrimaDAO;
import view.CadastroMateriaPrimaEstoque;
import model.MateriaPrima;

public class MateriaPrimaController {
	
	private MateriaPrima materiaPrima;
	private view.MateriaPrima materiaPrimaView;
	private MateriaPrimaDAO materiaPrimaDAO;
	private NavegadorTelas navegador;
	private CadastroMateriaPrimaEstoque cadastroMateriaPrima;
	private Menu menu;
	private boolean nomeMateria;
	private boolean marca;

	public MateriaPrimaController( MateriaPrima materiaPrima, 
			MateriaPrimaDAO materiaPrimaDAO, NavegadorTelas navegador, Menu menu,
			CadastroMateriaPrimaEstoque cadastroMateriaPrima, view.MateriaPrima materiaPrimaView) {
		
		this.materiaPrima = materiaPrima;
		this.materiaPrimaDAO = materiaPrimaDAO;
		this.navegador = navegador;
		this.cadastroMateriaPrima = cadastroMateriaPrima;
		this.menu = menu;
		this.materiaPrimaView = materiaPrimaView;
		
		this.cadastroMateriaPrima.confirmar(e ->{
			
			cadastrarMateriaPrima();
			navegador.navegarTela("MATERIA_PRIMA");
			menu.mostrarPanelCont();
			
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
			
		} else {
			
			MateriaPrima novaMateriaPrima = new MateriaPrima (null,null,null, 0,0,0,null);
			
			novaMateriaPrima.setNome(cadastroMateriaPrima.getTfNomeMateriaPrima().getText());
			novaMateriaPrima.setCor(cadastroMateriaPrima.getTfCor().getText());
			novaMateriaPrima.setMarca(cadastroMateriaPrima.getTfMarca().getText());
			novaMateriaPrima.setQuantidadeDisponivel(Integer.parseInt(cadastroMateriaPrima.getTfQtdDisponivel().getText()));
			novaMateriaPrima.setUnidadePorUnidade(Float.parseFloat(cadastroMateriaPrima.getTfQtdUnidade().getText()));
			novaMateriaPrima.setValor(Float.parseFloat(cadastroMateriaPrima.getTfValor().getText()));
			novaMateriaPrima.setUnidadeMed(cadastroMateriaPrima.getCbUnidadeMedida().getSelectedItem());
			
			
		}
	}

}
