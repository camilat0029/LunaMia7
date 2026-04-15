package controller;

import model.ProdutoEstoqueDAO;
import view.ProdutoEstoque;
import view.TelaPrincipal;

public class ProdutoEstoqueController {
	
	private ProdutoEstoque produtoEstoque;
	private NavegadorTelas navegadorTelas;
	private Menu menu;
	private TelaPrincipal telaPrincipal;
	private ProdutoEstoqueDAO produtoEstoqueDAO;
	
	public ProdutoEstoqueController(ProdutoEstoque produtoEstoque, NavegadorTelas navegadorTelas, Menu menu, TelaPrincipal telaPrincipal, 
			ProdutoEstoqueDAO produtoEstoqeuDAO) {
		super();
		this.produtoEstoque = produtoEstoque;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		this.telaPrincipal = telaPrincipal;
		this.produtoEstoqueDAO = produtoEstoqueDAO;
		
		this.produtoEstoque.adicionar(e -> {
			System.out.println("CLIQUE");
			navegadorTelas.navegarTela("CADASTRO_PRODUTO");
			menu.removerMenu()
			
;		});
	}

	

}
