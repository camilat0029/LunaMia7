package controller;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Cliente;
import model.ClienteDAO;
import model.ConfirOrcam;
import model.ConfirOrcamDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.Orcamento;
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
	private ConfirOrcamDAO confirOrcamDAO;
	private MateriaPrimaDAO materiaPrimaDAO;
	private NavegadorTelas navegadorTelas;
	private Orcamentos orcamentos;
	private CriarOrcamento criarOrcamento;
	
	private ConfirOrcam confirOrcamAtual;
    private Orcamento orcamentoAtual;

	public OrcamentoController(OrcamentoDAO orcamentoDAO, TelaPrincipal telaPrincipal, Menu menu,
			NavegadorTelas navegadorTelas, Orcamentos orcamentos, CriarOrcamento criarOrcamento,
			ClienteDAO clienteDAO, MateriaPrimaDAO materiaPrimaDAO, ConfirOrcamDAO confirOrcamDAO) {
		this.orcamentoDAO = orcamentoDAO;
		this.telaPrincipal = telaPrincipal;
		this.menu = menu;
		this.navegadorTelas = navegadorTelas;
		this.orcamentos = orcamentos;
		this.criarOrcamento = criarOrcamento;
		this.clienteDAO = clienteDAO;
		this.materiaPrimaDAO = materiaPrimaDAO;
		this.confirOrcamDAO = confirOrcamDAO;
		
		criarOrcamento.getTabMateriaisEstoque().setModel(criarOrcamento.tabModeloEstoque);
		criarOrcamento.getTabMateriaisOrcam().setModel(criarOrcamento.tabModeloOrcam);
		//orcamentos.getta

		this.orcamentos.criar(e -> {
			irParaTelaCriarOrc();
		});
		
		this.criarOrcamento.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegadorTelas.navegarTela("ORCAMENTOS");
			}
		});
		
		this.criarOrcamento.calcEdita(e -> {
			
			if(criarOrcamento.getBtCalcEdi().getText().equals("Calcular")) {
				calcular();
			} else if (criarOrcamento.getBtCalcEdi().getText().equals("Editar")) {
				editarValores();
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
		
		this.criarOrcamento.confirmar(e -> {
			confirmar();
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
		criarOrcamento.getLbValorFinalCad().setVisible(false);
		
		criarOrcamento.getBtConfirmar().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(false);
		
		menu.removerMenu();
		criarOrcamento.setPreferredSize(new Dimension(1020,920));
		
		
		
		List<MateriaPrima> listaMateriasPrimas = this.materiaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
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
		
		ativandoDevativandoComp();
		
		float percLucro = Float.parseFloat(criarOrcamento.getLbPercLucroUsuario().getText());
		float custoAdicional = Float.parseFloat(criarOrcamento.getTfCustoAdicional().getText());
		float horasPrevistas = Float.parseFloat(criarOrcamento.getTfHorasPrevistas().getText());
		float precoHora =  Float.parseFloat(criarOrcamento.getLbPrecoHoraUsuario().getText());
		
		float valorTrabalho = horasPrevistas * precoHora;
		
		int totalLinhas = criarOrcamento.tabModeloOrcam.getRowCount();
		
		float somaProdutos = 0;
		
		for (int i = 0; i < totalLinhas; i++) {
			
			float valorProduto = Float.parseFloat(criarOrcamento.tabModeloOrcam.getValueAt(i, 1).toString());
			float quantProduto = Float.parseFloat(criarOrcamento.tabModeloOrcam.getValueAt(i, 2).toString());
			
			float valorPorProduto = valorProduto * quantProduto;
			
			somaProdutos += valorPorProduto;
			
		}
		
		//VALORES QUE VÃO PARA OS LABELS
		float totalGastos = custoAdicional + somaProdutos;
		float valorSemLucro = custoAdicional + somaProdutos + valorTrabalho;
		float valorVenda = valorSemLucro + (valorSemLucro * (percLucro/100));
		float lucroAdicional = valorVenda - valorSemLucro;
		float lucro = lucroAdicional + valorTrabalho;
		
		//LABELS RECEBENDO OS VALORES
		criarOrcamento.getLbCalcGastos().setText(String.valueOf(totalGastos));
		criarOrcamento.getLbValorCalcSemLucro().setText(String.valueOf(valorSemLucro));
		criarOrcamento.getLbValorCalVenda().setText(String.valueOf(valorVenda));
		criarOrcamento.getLbCalcLucro().setText(String.valueOf(lucro));
	}

	
	//EDITANDO VALORES
	public void editarValores() {
		
		criarOrcamento.getBtCalcEdi().setText("Calcular");
		
		criarOrcamento.getTfQuantMaxDias().setEditable(true);
		criarOrcamento.getTfHorasPrevistas().setEditable(true);
		criarOrcamento.getTfCustoAdicional().setEditable(true);
		criarOrcamento.getBtAdicionar().setVisible(true);
		criarOrcamento.getBtRemover().setVisible(true);
	}
	
	public void salvarInformacoes() {
		
		ativDesativCompAoSalvar();
		
		criarOrcamento.getLbValorFinalCad().setText(criarOrcamento.getLbValorCalVenda().getText());
		
		//DO CLIENTE
		Cliente cliente = new Cliente(null, null, null);
		
		cliente.setNome(criarOrcamento.getTfNomeCliente().getText());
		cliente.setEmail(criarOrcamento.getTfEmail().getText());
		cliente.setTelefone(criarOrcamento.getTfContato().getText());		
		clienteDAO.adicionarDados(cliente);
		
		//DO ORÇAMENTO
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;
		Orcamento novoOrcamento = new Orcamento(null, 0, 0, 0, null);
		
		novoOrcamento.setTituloPedido(criarOrcamento.getTituloOrcamento().getText());
		novoOrcamento.setStatus((Orcamento.Status) criarOrcamento.getCbStatus().getSelectedItem());
		novoOrcamento.setPrecoHora(Float.parseFloat(criarOrcamento.getLbPrecoHoraUsuario().getText()));
		novoOrcamento.setQuantHorasPrevistas(Float.parseFloat(criarOrcamento.getTfHorasPrevistas().getText()));
		novoOrcamento.setMaxDias(Integer.parseInt(criarOrcamento.getTfQuantMaxDias().getText()));
		novoOrcamento.setUsuarioPerfil(usuarioLogado);;
		novoOrcamento.setCliente(cliente);;
		orcamentoDAO.adicionarDados(novoOrcamento);
		this.orcamentoAtual = novoOrcamento;
		
		//DE CONFIRMAÇÃO DO ORCAMENTO
		ConfirOrcam confirOrcam = new ConfirOrcam(null, null, null, 0, 0);
		
		confirOrcam.setFormPagamento(null);
		confirOrcam.setDataPrevistaEntrega(null);
		confirOrcam.setDataConfirmacao(null);
		confirOrcam.setOrcamento(novoOrcamento);
		confirOrcam.setValorVenda(Float.parseFloat(criarOrcamento.getLbValorCalVenda().getText()));
		confirOrcam.setLucro(Float.parseFloat(criarOrcamento.getLbCalcLucro().getText()));
		confirOrcamDAO.adicionarDados(confirOrcam);
		this.confirOrcamAtual = confirOrcam;
		
		atualizarQuantMP();
		
	}
	
	public void confirmar() {
		
		confirOrcamAtual.setFormPagamento(criarOrcamento.getCbFormaPaga().getSelectedItem().toString());
		confirOrcamAtual.setDataPrevistaEntrega(LocalDate.parse(criarOrcamento.getTfDtPrevEntrega().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		confirOrcamAtual.setDataConfirmacao(LocalDate.parse(criarOrcamento.getTfDataConfPedido().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		confirOrcamAtual.setValorVenda(Float.parseFloat(criarOrcamento.getLbValorCalVenda().getText()));
		confirOrcamAtual.setLucro(Float.parseFloat(criarOrcamento.getLbCalcLucro().getText()));
		confirOrcamAtual.setOrcamento(orcamentoAtual);
		confirOrcamDAO.atualizarConfirOrcam(confirOrcamAtual);
		
		JOptionPane.showMessageDialog(null, "Orçamento Confirmado com Sucesso", "informação", 1);
		navegadorTelas.navegarTela("ORCAMENTOS");
		
		carregarTabelaOrcamentos();
		
		//CRIAR E COLOCAR METODO DE LIMPAR A TELA
		//FAZER VALIDAÇÕES
		
	}
	
	public void ativandoDevativandoComp() {
		
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
	
	public void atualizarQuantMP() {
		
		int totalLinhas = criarOrcamento.tabModeloEstoque.getRowCount();
		
		
		for (int i = 0; i < totalLinhas; i++) {
			MateriaPrima materiaPrima = criarOrcamento.tabModeloEstoque.getMatPrima(i);
			materiaPrimaDAO.atualizarQuantMP(materiaPrima.getIdMateriaPrima(), materiaPrima.getQuantidadeDisponivel());
		}
		
	}
	
	public void ativDesativCompAoSalvar() {
		criarOrcamento.setPreferredSize(new Dimension(1020,1520));
		
		criarOrcamento.getLbDtConfPedido().setVisible(true);
		criarOrcamento.getTfDataConfPedido().setVisible(true);
		criarOrcamento.getLbDtPrevEntrega().setVisible(true);
		criarOrcamento.getTfDtPrevEntrega().setVisible(true);
		
		criarOrcamento.getLbFormaPaga().setVisible(true);
		criarOrcamento.getCbFormaPaga().setVisible(true);
		criarOrcamento.getLbValorFinal().setVisible(true);
		criarOrcamento.getLbValorFinalCad().setVisible(true);
		
		criarOrcamento.getBtConfirmar().setVisible(true);
		criarOrcamento.getBtCalcEdi().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(false);
	}
	
	public void carregarTabelaOrcamentos() {
		
		List<Orcamento> orcamentosCad = orcamentoDAO.listarOrcamentos();
		
		orcamentos.tabelaModeloOrcamentos = (DefaultTableModel) orcamentos.getTabelaOrcamentos().getModel();
		
		orcamentos.tabelaModeloOrcamentos.setRowCount(0);

		for(Orcamento orcam : orcamentosCad) {
			Object[] informacoes = {orcam.getTituloPedido(), orcam.getStatus(), orcam.getCliente().getNome()};
			orcamentos.tabelaModeloOrcamentos.addRow(informacoes);
		}
	}
	
}