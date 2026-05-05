package controller;

import java.awt.Dimension;

import model.OrcamentoDAO;
import model.UsuarioPerfil;
import view.CriarOrcamento;
import view.CriarOrcamentoComFormaPagamento;
import view.Orcamentos;
import view.TelaPrincipal;

public class OrcamentoController {

	private Menu menu;
	private TelaPrincipal telaPrincipal;
	private OrcamentoDAO orcamentoDAO;
	private NavegadorTelas navegadorTelas;
	private Orcamentos orcamentos;
	private CriarOrcamento criarOrcamento;

	public OrcamentoController(OrcamentoDAO orcamentoDAO, TelaPrincipal telaPrincipal, Menu menu,
			NavegadorTelas navegadorTelas, Orcamentos orcamentos, CriarOrcamento criarOrcamento) {
		this.orcamentoDAO = orcamentoDAO;
		this.telaPrincipal = telaPrincipal;
		this.menu = menu;
		this.navegadorTelas = navegadorTelas;
		this.orcamentos = orcamentos;
		this.criarOrcamento = criarOrcamento;

		this.orcamentos.criar(e -> {
			irParaTelaCriarOrc();
		});
		
		this.criarOrcamento.calcEdita(e -> {
			
			if(criarOrcamento.getBtCalcEdi().getText().equals("Calcular")) {
				calcular();
			} else if (criarOrcamento.getBtCalcEdi().getText().equals("Editar")) {
				
			}
			
		});
		
	}
	
	//COLOCANDO INFORMAÇÕES E INDO PARA A TELA DE CRIAR ORÇAMENTO
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
		criarOrcamento.setPreferredSize(new Dimension(1020,640));
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
		
	}
	
	//CALCULANDO VALORES
	public void calcular() {
		
		criarOrcamento.setPreferredSize(new Dimension(1020,890));
		
		criarOrcamento.getTfQuantMaxDias().setEditable(false);
		criarOrcamento.getTfHorasPrevistas().setEditable(false);
		
		criarOrcamento.getLbValorCalcSemLucro().setVisible(true);
		criarOrcamento.getLbValorCalVenda().setVisible(true);
		criarOrcamento.getLbCalcGastos().setVisible(true);
		criarOrcamento.getLbCalcLucro().setVisible(true);
		
		criarOrcamento.getLbValorSemLucro().setVisible(true);
		criarOrcamento.getLbValorVenda().setVisible(true);
		criarOrcamento.getLbGastos().setVisible(true);
		criarOrcamento.getLbValorLucro().setVisible(true);
		
		criarOrcamento.getBtConfirmar().setVisible(true);

		criarOrcamento.getBtCalcEdi().setText("Editar");
		
		
	}
	
	//EDITANDO VALORES
	public void editarValores() {
		
		criarOrcamento.getBtCalcEdi().setText("Calcular");
	}
	
	
}
