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
			navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
			menu.removerMenu();
		});
		this.inicio.criarEstoque(e ->{
			navegadorTelas.navegarTela("CADASTRO_PRODUTO");
			menu.removerMenu();
		});
		this.inicio.configurarPerfil(e ->{
			navegadorTelas.navegarTela("CONFIGURAR_PERFIL");
			menu.removerMenu();
		});
	}

}
