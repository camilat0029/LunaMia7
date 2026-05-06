package controller;

import java.awt.Dimension;

import model.Cliente;
import model.ClienteDAO;
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
	private ClienteDAO clienteDAO;
	private NavegadorTelas navegadorTelas;
	private Orcamentos orcamentos;
	private CriarOrcamento criarOrcamento;

	public OrcamentoController(OrcamentoDAO orcamentoDAO, TelaPrincipal telaPrincipal, Menu menu,
			NavegadorTelas navegadorTelas, Orcamentos orcamentos, CriarOrcamento criarOrcamento,
			ClienteDAO clienteDAO) {
		this.orcamentoDAO = orcamentoDAO;
		this.telaPrincipal = telaPrincipal;
		this.menu = menu;
		this.navegadorTelas = navegadorTelas;
		this.orcamentos = orcamentos;
		this.criarOrcamento = criarOrcamento;
		this.clienteDAO = clienteDAO;

		this.orcamentos.criar(e -> {
			irParaTelaCriarOrc();
		});
		
		this.criarOrcamento.calcEdita(e -> {
			
			if(criarOrcamento.getBtCalcEdi().getText().equals("Calcular")) {
				calcular();
			} else if (criarOrcamento.getBtCalcEdi().getText().equals("Editar")) {
				
			}
			
		});
		
		this.criarOrcamento.salvarValor(e -> {
			salvarInformacoes();
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
		
		criarOrcamento.getLbDtConfPedido().setVisible(false);
		criarOrcamento.getTfDataConfPedido().setVisible(false);
		criarOrcamento.getLbDtPrevEntrega().setVisible(false);
		criarOrcamento.getTfDtPrevEntrega().setVisible(false);
		
		criarOrcamento.getLbFormaPaga().setVisible(false);
		criarOrcamento.getCbFormaPaga().setVisible(false);
		criarOrcamento.getLbValorFinal().setVisible(false);
		criarOrcamento.getTfValorFinal().setVisible(false);
		
		criarOrcamento.getBtConfirmar().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(false);
		
		menu.removerMenu();
		criarOrcamento.setPreferredSize(new Dimension(1020,790));
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
		
	}
	
	//CALCULANDO VALORES
	public void calcular() {
		
		criarOrcamento.setPreferredSize(new Dimension(1020,1010));
		
		criarOrcamento.getTfQuantMaxDias().setEditable(false);
		criarOrcamento.getTfHorasPrevistas().setEditable(false);
		criarOrcamento.getTfCustoAdicional().setEditable(false);
		
		criarOrcamento.getLbValorCalcSemLucro().setVisible(true);
		criarOrcamento.getLbValorCalVenda().setVisible(true);
		criarOrcamento.getLbCalcGastos().setVisible(true);
		criarOrcamento.getLbCalcLucro().setVisible(true);
		
		criarOrcamento.getLbValorSemLucro().setVisible(true);
		criarOrcamento.getLbValorVenda().setVisible(true);
		criarOrcamento.getLbGastos().setVisible(true);
		criarOrcamento.getLbValorLucro().setVisible(true);
		
		criarOrcamento.getBtSalvar().setVisible(true);

		criarOrcamento.getBtCalcEdi().setText("Editar");
		
		
	}
	
	//EDITANDO VALORES
	public void editarValores() {
		
		criarOrcamento.getBtCalcEdi().setText("Calcular");
	}
	
	public void salvarInformacoes() {
		
		criarOrcamento.setPreferredSize(new Dimension(1020,1310));
		
		criarOrcamento.getLbDtConfPedido().setVisible(true);
		criarOrcamento.getTfDataConfPedido().setVisible(true);
		criarOrcamento.getLbDtPrevEntrega().setVisible(true);
		criarOrcamento.getTfDtPrevEntrega().setVisible(true);
		
		criarOrcamento.getLbFormaPaga().setVisible(true);
		criarOrcamento.getCbFormaPaga().setVisible(true);
		criarOrcamento.getLbValorFinal().setVisible(true);
		criarOrcamento.getTfValorFinal().setVisible(true);
		
		criarOrcamento.getBtConfirmar().setVisible(true);
		criarOrcamento.getBtCalcEdi().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(false);
		
		//Do cliente
//		Cliente cliente = new Cliente(null, null, null);
//		
//		cliente.setNome(criarOrcamento.getTfNomeCliente().getText());
//		cliente.setEmail(criarOrcamento.getTfEmail().getText());
//		cliente.setTelefone(criarOrcamento.getTfContato().getText());
//		
		//clienteDAO.adicionarDados(cliente);
		
		//Demais informações de cálculo
	}
	
	
}
