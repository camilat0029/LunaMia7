package controller;

import model.OrcamentoDAO;
import view.CriarOrcamentoComFormaPagamento;
import view.TelaPrincipal;

public class OrcamentoController {
	
	private CriarOrcamentoComFormaPagamento criarOrcamentoComFormaPagamento;
	private Menu menu;
	private TelaPrincipal telaPrincipal;
	private OrcamentoDAO orcamentoDAO;
	private NavegadorTelas navegadorTelas;
	
	public OrcamentoController(CriarOrcamentoComFormaPagamento criarOrcamentoComFormaPagamento,
			OrcamentoDAO orcamentoDAO, TelaPrincipal telaPrinciapal, Menu menu, NavegadorTelas navegadorTelas) {
		this.criarOrcamentoComFormaPagamento = criarOrcamentoComFormaPagamento;
		this.orcamentoDAO = orcamentoDAO;
		this.telaPrincipal = telaPrincipal;
		this.menu = menu;
		this.navegadorTelas = navegadorTelas;
		
		this.criarOrcamentoComFormaPagamento.confirmar( e -> {
			
			
		}
		
				
		);
	}
	
	
	
	

}
