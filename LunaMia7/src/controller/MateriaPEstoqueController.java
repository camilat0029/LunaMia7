package controller;

import model.MateriaPrimaDAO;
import view.MateriaPrima;
import view.TelaPrincipal;

public class MateriaPEstoqueController {
	
	private MateriaPrima materiaPrima;
	private NavegadorTelas navegadorTelas;
	private Menu menu;
	private TelaPrincipal telaPrincipal;
	private MateriaPrimaDAO materiaPrimaDAO;
	
	public MateriaPEstoqueController(MateriaPrima materiaPrima, NavegadorTelas navegadorTelas, Menu menu, TelaPrincipal telaPrincipal, 
			MateriaPrimaDAO produtoEstoqeuDAO) {
		super();
		this.materiaPrima = materiaPrima;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		this.telaPrincipal = telaPrincipal;
		this.materiaPrimaDAO = materiaPrimaDAO;
		
		this.materiaPrima.adicionar(e -> {
			System.out.println("CLIQUE");
			navegadorTelas.navegarTela("CADASTRO_PRODUTO");
			menu.removerMenu()
			
;		});
	}

	

}
