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
		
		this.inicio.irParaConfigurarPerfil(e -> {
			this.navegadorTelas.navegarTela("CONFIGURARPERFIL");
			menu.removerMenu();
		});
		
		
	}

}
