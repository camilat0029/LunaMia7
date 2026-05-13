package controller;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ClienteDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
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
	private MateriaPrimaDAO materiaPrimaDAO;
	private NavegadorTelas navegadorTelas;
	private Orcamentos orcamentos;
	private CriarOrcamento criarOrcamento;

	public OrcamentoController(OrcamentoDAO orcamentoDAO, TelaPrincipal telaPrincipal, Menu menu,
			NavegadorTelas navegadorTelas, Orcamentos orcamentos, CriarOrcamento criarOrcamento,
			ClienteDAO clienteDAO, MateriaPrimaDAO materiaPrimaDAO) {
		this.orcamentoDAO = orcamentoDAO;
		this.telaPrincipal = telaPrincipal;
		this.menu = menu;
		this.navegadorTelas = navegadorTelas;
		this.orcamentos = orcamentos;
		this.criarOrcamento = criarOrcamento;
		this.clienteDAO = clienteDAO;
		this.materiaPrimaDAO = materiaPrimaDAO;
		
		criarOrcamento.getTabMateriaisEstoque().setModel(criarOrcamento.tabModeloEstoque);
		criarOrcamento.getTabMateriaisOrcam().setModel(criarOrcamento.tabModeloOrcam);

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
		
		this.criarOrcamento.adicionar(e -> {
			adicionar();
		});
		
		this.criarOrcamento.remover(e -> {
			remover();
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
		criarOrcamento.setPreferredSize(new Dimension(1020,920));
		
		
		
		List<MateriaPrima> listaMateriasPrimas = this.materiaPrimaDAO.listarMateriaPrima();
		criarOrcamento.tabModeloEstoque.limpar();
		criarOrcamento.tabModeloOrcam.limpar();
		criarOrcamento.tabModeloEstoque.setLista(listaMateriasPrimas);
	
		
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
		
		
	}
	
	//ADICIONANDO DA TABELA DE ESTOQUE PARA ORÇAMENTO
	public void adicionar() {
		
		int linhaSelecionada = criarOrcamento.getTabMateriaisEstoque().getSelectedRow();
		
		if (linhaSelecionada >= 0) {
			MateriaPrima matPrima = criarOrcamento.tabModeloEstoque.getMatPrima(linhaSelecionada);
			int quantidadeEstoque = matPrima.getQuantidadeDisponivel();
			int idMateriaPrima = matPrima.getIdMateriaPrima();
			
			if(quantidadeEstoque <= 0) {
				JOptionPane.showMessageDialog(null, "Não tem mais itens no estoque", "Informação", 1);
				return;
			}
			
			int linha = criarOrcamento.tabModeloOrcam.procurarId(idMateriaPrima);
			
			if(linha >= 0) {
				
				MateriaPrima matPrimaOrcam = criarOrcamento.tabModeloOrcam.getMatPrima(linha);
				
				int novaQuantidadeOrcam = matPrimaOrcam.getQuantidadeDisponivel() + 1;
				
				criarOrcamento.tabModeloOrcam.setValueAt(novaQuantidadeOrcam, linha, 2);
				
			} else {
				
				MateriaPrima matPrimaNova = new MateriaPrima(null, null, null, linha, linha, linha, null);
				
				matPrimaNova.setIdMateriaPrima(matPrima.getIdMateriaPrima());
				matPrimaNova.setNome(matPrima.getNome());
				matPrimaNova.setValor(matPrima.getValor());
				matPrimaNova.setQuantidadeDisponivel(1);
				
				criarOrcamento.tabModeloOrcam.adicionarMatPrima(matPrimaNova);
			}
			
			criarOrcamento.tabModeloEstoque.setValueAt(quantidadeEstoque - 1, linhaSelecionada, 2);
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para adicionar", "Informação", 1);
		}
		
	}
	
	//REMOVENDO DA LISTA DE ORÇAMENTO PARA ESTOQUE
	public void remover() {
		int linhaSelecionada = criarOrcamento.getTabMateriaisOrcam().getSelectedRow();
		
		if (linhaSelecionada >= 0) {
			
			MateriaPrima matPrima = criarOrcamento.tabModeloOrcam.getMatPrima(linhaSelecionada);
			int idMateriaPrima = matPrima.getIdMateriaPrima();
			int linha = criarOrcamento.tabModeloEstoque.procurarId(idMateriaPrima);
			
			if(matPrima.getQuantidadeDisponivel() > 0) {
				
				criarOrcamento.tabModeloOrcam.setValueAt(matPrima.getQuantidadeDisponivel() - 1, linhaSelecionada, 2);
				
				MateriaPrima matPrimaEstoque = criarOrcamento.tabModeloEstoque.getMatPrima(linha);
				int novaQuantidadeEstoque = matPrimaEstoque.getQuantidadeDisponivel() + 1;
				criarOrcamento.tabModeloEstoque.setValueAt(novaQuantidadeEstoque, linha, 2);
				
				if(matPrima.getQuantidadeDisponivel() == 0) {
					
					criarOrcamento.tabModeloOrcam.removerMatPrima(linhaSelecionada);
					
				}
				
			}
			
			
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma linha para remover", "Informação", 1);
		}
	}
	
	//CALCULANDO VALORES
	public void calcular() {
		
		criarOrcamento.setPreferredSize(new Dimension(1020,1150));
		
		criarOrcamento.getTfQuantMaxDias().setEditable(false);
		criarOrcamento.getTfHorasPrevistas().setEditable(false);
		criarOrcamento.getTfCustoAdicional().setEditable(false);
		criarOrcamento.getBtAdicionar().setVisible(false);
		criarOrcamento.getBtRemover().setVisible(false);
		
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
		
		criarOrcamento.setPreferredSize(new Dimension(1020,1520));
		
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
