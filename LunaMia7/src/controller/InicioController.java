package controller;

import model.UsuarioPerfil;
import view.CriarOrcamento;
import view.Inicio;

public class InicioController {
	
	private Inicio inicio;
	private NavegadorTelas navegadorTelas;
	private Menu menu;
	private CriarOrcamento criarOrcamento;
	
	public InicioController(Inicio inicio, NavegadorTelas navegadorTelas, Menu menu, CriarOrcamento criarOrcamento) {
		super();
		this.inicio = inicio;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		this.criarOrcamento = criarOrcamento;
		
		this.inicio.criarOrcamento(e ->{
			irParaTelaCriarOrc();
		});
		this.inicio.criarEstoque(e ->{
			navegadorTelas.navegarTela("CADASTRO_MATERIA_PRIMA");
			menu.removerMenu();
		});
		this.inicio.configurarPerfil(e ->{
			navegadorTelas.navegarTela("CONFIGURAR_PERFIL");
			menu.removerMenu();
		});
	}
	
	public void irParaTelaCriarOrc() {
		
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;
		
		criarOrcamento.getLbPrecoHoraUsuario().setText(String.valueOf(usuarioLogado.getPrecoHora()));
		criarOrcamento.getLbPercLucroUsuario().setText(String.valueOf(usuarioLogado.getPercentualLucro()));
		
		criarOrcamento.getLbValorCalcSemLucro().setVisible(false);
		criarOrcamento.getLbValorCalVenda().setVisible(false);
		criarOrcamento.getLbCalcGastos().setVisible(false);
		criarOrcamento.getLbCalcLucro().setVisible(false);
		
		criarOrcamento.getLbValorSemLucro().setVisible(false);
		criarOrcamento.getLbValorVenda().setVisible(false);
		criarOrcamento.getLbGastos().setVisible(false);
		criarOrcamento.getLbValorLucro().setVisible(false);
		
		criarOrcamento.getBtConfirmar().setVisible(false);
		
		menu.removerMenu();
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
		
	}

}
