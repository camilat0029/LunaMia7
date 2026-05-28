package controller;

import java.awt.Dimension;
import java.util.List;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.UsuarioPerfil;
import view.CriarOrcamento;
import view.Inicio;

public class InicioController {
	
	private Inicio inicio;
	private NavegadorTelas navegadorTelas;
	private Menu menu;
	private CriarOrcamento criarOrcamento;
	private MateriaPrimaDAO materiaPrimaDAO;
	
	public InicioController(Inicio inicio, NavegadorTelas navegadorTelas, Menu menu, CriarOrcamento criarOrcamento, MateriaPrimaDAO materiaPrimaDAO) {
		super();
		this.inicio = inicio;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		this.criarOrcamento = criarOrcamento;
		this.materiaPrimaDAO = materiaPrimaDAO;
		
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
		
		ativandoDesativandoComp();
		
		menu.removerMenu();
		criarOrcamento.setPreferredSize(new Dimension(1020,970));
		
		List<MateriaPrima> listaMateriasPrimas = this.materiaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
		criarOrcamento.tabModeloEstoque.limpar();
		criarOrcamento.tabModeloOrcam.limpar();
		criarOrcamento.tabModeloEstoque.setLista(listaMateriasPrimas);
	
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
		
	}

	public void ativandoDesativandoComp() {
		
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;
		
		criarOrcamento.getLbPrecoHoraUsuario().setText(String.valueOf(usuarioLogado.getPrecoHora()));
		criarOrcamento.getLbPercLucroUsuario().setText(String.valueOf(usuarioLogado.getPercentualLucro()));
		
		criarOrcamento.getTituloOrcamento().setEditable(true);
		criarOrcamento.getTfNomeCliente().setEditable(true);
		criarOrcamento.getTfContato().setEditable(true);
		criarOrcamento.getTfEmail().setEditable(true);
		
		criarOrcamento.getLbValorCalcSemLucro().setVisible(false);
		criarOrcamento.getLbValorCalVenda().setVisible(false);
		criarOrcamento.getLbCalcGastos().setVisible(false);
		criarOrcamento.getLbCalcLucro().setVisible(false);
		
		criarOrcamento.getLbValorSemLucro().setVisible(false);
		criarOrcamento.getLbValorVenda().setVisible(false);
		criarOrcamento.getLbGastos().setVisible(false);
		criarOrcamento.getLbValorLucro().setVisible(false);
		
		criarOrcamento.getLbDtConfPedido().setVisible(false);
		criarOrcamento.getTfDataConfPedido().setVisible(false);
		criarOrcamento.getLbDtPrevEntrega().setVisible(false);
		criarOrcamento.getTfDtPrevEntrega().setVisible(false);
		
		criarOrcamento.getLbFormaPaga().setVisible(false);
		criarOrcamento.getCbFormaPaga().setVisible(false);
		criarOrcamento.getLbValorFinal().setVisible(false);
		criarOrcamento.getLbValorFinalCad().setVisible(false);
		
		criarOrcamento.getBtConfirmar().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(false);
	}

}