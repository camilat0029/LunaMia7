package controller;

import model.MateriaPrimaDAO;
import view.MateriaPrimaView;
import view.TelaPrincipal;

public class MateriaPEstoqueController {
	
	private MateriaPrimaView materiaPrimaView;
	private NavegadorTelas navegadorTelas;
	private Menu menu;
	private TelaPrincipal telaPrincipal;
	private MateriaPrimaDAO materiaPrimaDAO;
	
	public MateriaPEstoqueController(MateriaPrimaView materiaPrimaView, NavegadorTelas navegadorTelas, Menu menu, TelaPrincipal telaPrincipal, 
			MateriaPrimaDAO produtoEstoqeuDAO) {
		super();
		this.materiaPrimaView = materiaPrimaView;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		this.telaPrincipal = telaPrincipal;
		this.materiaPrimaDAO = materiaPrimaDAO;
		
//		this.materiaPrimaView.adicionar(e -> {
//			System.out.println("CLIQUE");
//			navegadorTelas.navegarTela("CADASTRO_PRODUTO");
//			menu.removerMenu();
//			
//		});
		
		
	}

	

}
