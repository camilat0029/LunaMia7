package controller;

import view.Inicio;

public class InicioController {
	
	private Inicio inicio;
	private NavegadorTelas navegadorTelas;
	private Menu menu;
	
	public InicioController(Inicio inicio, NavegadorTelas navegadorTelas, Menu menu) {
		super();
		this.inicio = inicio;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		
		this.inicio.criarOrcamento(e ->{
			navegadorTelas.navegarTela("CRIARORCAMENTO");
			menu.removerMenu();
		});
		this.inicio.criarEstoque(e ->{
			navegadorTelas.navegarTela("CADASTROPRODUTO");
			menu.removerMenu();
		});
		this.inicio.configurarPerfil(e ->{
			navegadorTelas.navegarTela("CONFIGURARPERFIL");
			menu.removerMenu();
		});
	}

}
