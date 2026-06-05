package controller;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import model.Cliente;
import model.ClienteDAO;
import model.ConfirOrcam;
import model.ConfirOrcamDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.Orcamento;
import model.OrcamentoDAO;
import model.OrcamentoProduto;
import model.OrcamentoProdutoDAO;
import model.UsuarioPerfil;
import view.CriarOrcamento;
import view.Mensagem;
import view.Orcamentos;
import view.TelaPrincipal;

public class OrcamentoController extends ComponentAdapter {

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
	private JScrollPane scrollPaneOrcamento;

	public OrcamentoController(OrcamentoDAO orcamentoDAO, TelaPrincipal telaPrincipal, Menu menu,
			NavegadorTelas navegadorTelas, Orcamentos orcamentos, CriarOrcamento criarOrcamento, ClienteDAO clienteDAO,
			MateriaPrimaDAO materiaPrimaDAO, ConfirOrcamDAO confirOrcamDAO, JScrollPane scrollPaneOrcamento) {

		this.orcamentoDAO = orcamentoDAO;
		this.telaPrincipal = telaPrincipal;
		this.menu = menu;
		this.navegadorTelas = navegadorTelas;
		this.orcamentos = orcamentos;
		this.criarOrcamento = criarOrcamento;
		this.clienteDAO = clienteDAO;
		this.materiaPrimaDAO = materiaPrimaDAO;
		this.confirOrcamDAO = confirOrcamDAO;
		this.scrollPaneOrcamento = scrollPaneOrcamento;

		criarOrcamento.getTabMateriaisEstoque().setModel(criarOrcamento.tabModeloEstoque);
		criarOrcamento.getTabMateriaisOrcam().setModel(criarOrcamento.tabModeloOrcam);
		orcamentos.getTabelaOrcamentos().setModel(orcamentos.tabelaModeloOrcamento);
		
		ComboBoxEstilizacao.estilizarComboBox(this.criarOrcamento.getCbStatus());
		ComboBoxEstilizacao.estilizarComboBox(this.criarOrcamento.getCbFormaPaga());

		this.orcamentos.criar(e -> {
			irParaTelaCriarOrc();
		});

		this.criarOrcamento.voltar(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				navegadorTelas.navegarTela("ORCAMENTOS");
				menu.mostrarPanelCont();
			}
		});

		this.criarOrcamento.calcEdita(e -> {
			if (criarOrcamento.getBtCalcEdi().getText().equals("Calcular")) {
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
			if (criarOrcamento.getBtConfirmar().getText().equals("Confirmar")) {
				confirmar();
			}
		});

	}

	// COLOCANDO INFORMAÇÕES E INDO PARA A TELA DE CRIAR ORÇAMENTO
	public void irParaTelaCriarOrc() {

		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;

		criarOrcamento.getLbPrecoHoraUsuario().setText(String.valueOf(usuarioLogado.getPrecoHora()));
		criarOrcamento.getLbPercLucroUsuario().setText(String.valueOf(usuarioLogado.getPercentualLucro()));
		criarOrcamento.getTituloOrcamento().setEditable(true);
		criarOrcamento.getTfNomeCliente().setEditable(true);
		criarOrcamento.getTfContato().setEditable(true);
		criarOrcamento.getTfEmail().setEditable(true);
		criarOrcamento.getTfCustoAdicional().setEditable(true);
		criarOrcamento.getTfHorasPrevistas().setEditable(true);
		criarOrcamento.getTfQuantMaxDias().setEditable(true);
		criarOrcamento.getLbValorCalLucroAdici().setVisible(false);
		criarOrcamento.getLbValorCalVenda().setVisible(false);
		criarOrcamento.getLbCalcGastos().setVisible(false);
		criarOrcamento.getLbCalcLucro().setVisible(false);
		criarOrcamento.getLbValorLucroAdicional().setVisible(false);
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
		criarOrcamento.getInterrogacaoLucroAdicional().setVisible(false);
		criarOrcamento.getInterTotal().setVisible(false);
		criarOrcamento.getInterLT().setVisible(false);
		criarOrcamento.getInterTotal().setVisible(false);
		criarOrcamento.getLbValorFinalCad().setVisible(false);
		criarOrcamento.getBtAdicionar().setVisible(true);
		criarOrcamento.getBtRemover().setVisible(true);
		criarOrcamento.getBtConfirmar().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(true);
		criarOrcamento.getBtCalcEdi().setVisible(true);

		menu.removerMenu();

		criarOrcamento.getBtCalcEdi().setText("Calcular");
		criarOrcamento.getBtConfirmar().setText("Confirmar");

		criarOrcamento.setPreferredSize(new Dimension(1020, 970));
		List<MateriaPrima> listaMateriasPrimas = this.materiaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());

		criarOrcamento.tabModeloEstoque.limpar();
		criarOrcamento.tabModeloOrcam.limpar();
		criarOrcamento.tabModeloEstoque.setLista(listaMateriasPrimas);

		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");

		SwingUtilities.invokeLater(() -> {
			scrollPaneOrcamento.getVerticalScrollBar().setValue(0);
		});

	}

	// ADICIONANDO DA TABELA DE ESTOQUE PARA ORÇAMENTO
	public void adicionar() {

		int linhaSelecionada = criarOrcamento.getTabMateriaisEstoque().getSelectedRow();

		if (linhaSelecionada >= 0) {
			MateriaPrima matPrima = criarOrcamento.tabModeloEstoque.getMatPrima(linhaSelecionada);
			int quantidadeEstoque = matPrima.getQuantidadeDisponivel();
			int idMateriaPrima = matPrima.getIdMateriaPrima();

			if (quantidadeEstoque <= 0) {

				Mensagem.mostrar(null, "Informação", "Não tem mais itens no estoque.");
				return;

			}

			int linha = criarOrcamento.tabModeloOrcam.procurarId(idMateriaPrima);

			if (linha >= 0) {

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
			Mensagem.mostrar(null, "Informação", "Selecione uma linha para adicionar.");

		}
	}

	// REMOVENDO DA LISTA DE ORÇAMENTO PARA ESTOQUE
	public void remover() {

		int linhaSelecionada = criarOrcamento.getTabMateriaisOrcam().getSelectedRow();

		if (linhaSelecionada >= 0) {

			MateriaPrima matPrima = criarOrcamento.tabModeloOrcam.getMatPrima(linhaSelecionada);
			int idMateriaPrima = matPrima.getIdMateriaPrima();
			int linha = criarOrcamento.tabModeloEstoque.procurarId(idMateriaPrima);

			if (matPrima.getQuantidadeDisponivel() > 0) {

				criarOrcamento.tabModeloOrcam.setValueAt(matPrima.getQuantidadeDisponivel() - 1, linhaSelecionada, 2);
				MateriaPrima matPrimaEstoque = criarOrcamento.tabModeloEstoque.getMatPrima(linha);
				int novaQuantidadeEstoque = matPrimaEstoque.getQuantidadeDisponivel() + 1;
				criarOrcamento.tabModeloEstoque.setValueAt(novaQuantidadeEstoque, linha, 2);

				if (matPrima.getQuantidadeDisponivel() == 0) {
					criarOrcamento.tabModeloOrcam.removerMatPrima(linhaSelecionada);
				}
			}

		} else {
			Mensagem.mostrar(null, "Informação", "Selecione uma linha para remover.");

		}
	}

	// CALCULANDO VALORES
	public void calcular() {

		if (criarOrcamento.getTfHorasPrevistas().getText().isEmpty() || criarOrcamento.getTfQuantMaxDias().getText().isEmpty()) {

			Mensagem.mostrar(null, "Informação", "Você precisa preencher os campos obrigatórios!");

		} else {
			String custoAdicStr = criarOrcamento.getTfCustoAdicional().getText();
			String horasPrevStr = criarOrcamento.getTfHorasPrevistas().getText();
			String quantDiasStr = criarOrcamento.getTfQuantMaxDias().getText();

			if (diasMaxQuantHrsPermit(horasPrevStr) == false) {
				Mensagem.mostrar(null, "Informação", "Horas previstas inválido! \nExemplo: 2, 5, 8...");
				return;

			} else if (diasMaxQuantHrsPermit(quantDiasStr) == false) {
				Mensagem.mostrar(null, "Informação", "Quantidade máxima de dias Inválido! \nExemplo: 2, 5, 8...");
				return;

			} else if (!custoAdicStr.isEmpty() && custoAdicPermit(formatarCustoAdic(custoAdicStr)) == false) {
				Mensagem.mostrar(null, "Informação", "Custo adicional inválido! \nExemplo: (2.5); (5,8); (8)...");
				return;

			} else {
				ativandoDevativandoComp();

				float percLucro = Float.parseFloat(criarOrcamento.getLbPercLucroUsuario().getText());
				float custoAdicional;
				
				if(custoAdicStr.isEmpty()) {
					custoAdicional = Float.parseFloat("0");
				} else {
					custoAdicional = Float.parseFloat(formatarCustoAdic(custoAdicStr));
				}
				
				float horasPrevistas = Float.parseFloat(criarOrcamento.getTfHorasPrevistas().getText());
				float precoHora = Float.parseFloat(criarOrcamento.getLbPrecoHoraUsuario().getText());
				float valorTrabalho = horasPrevistas * precoHora;
				
				int totalLinhas = criarOrcamento.tabModeloOrcam.getRowCount();
				float somaProdutos = 0;

				for (int i = 0; i < totalLinhas; i++) {
					float valorProduto = Float.parseFloat(criarOrcamento.tabModeloOrcam.getValueAt(i, 1).toString());
					float quantProduto = Float.parseFloat(criarOrcamento.tabModeloOrcam.getValueAt(i, 2).toString());
					float valorPorProduto = valorProduto * quantProduto;
					somaProdutos += valorPorProduto;

				}

				// VALORES QUE VÃO PARA OS LABELS
				float totalGastos = custoAdicional + somaProdutos;
				float valorSemLucroAdic = custoAdicional + somaProdutos + valorTrabalho;
				float valorVenda = valorSemLucroAdic + (valorSemLucroAdic * (percLucro / 100));
				float lucroAdicional = valorVenda - valorSemLucroAdic;
				float lucro = lucroAdicional + valorTrabalho;

				// LABELS RECEBENDO OS VALORES
				criarOrcamento.getLbCalcGastos().setText(String.format("%.2f", totalGastos));
				criarOrcamento.getLbValorCalLucroAdici().setText(String.format("%.2f", lucroAdicional));
				criarOrcamento.getLbValorCalVenda().setText(String.format("%.2f", valorVenda));
				criarOrcamento.getLbCalcLucro().setText(String.format("%.2f", lucro));
			}
		}
	}

	// EDITANDO VALORES
	public void editarValores() {

		criarOrcamento.getBtCalcEdi().setText("Calcular");
		criarOrcamento.getBtSalvar().setVisible(false);
		criarOrcamento.getTfQuantMaxDias().setEditable(true);
		criarOrcamento.getTfHorasPrevistas().setEditable(true);
		criarOrcamento.getTfCustoAdicional().setEditable(true);
		criarOrcamento.getBtAdicionar().setVisible(true);
		criarOrcamento.getBtRemover().setVisible(true);

	}

	public void salvarInformacoes() {

		if (criarOrcamento.getTituloOrcamento().getText().isEmpty() || criarOrcamento.getTfNomeCliente().getText().isEmpty()
				|| criarOrcamento.getTfHorasPrevistas().getText().isEmpty() || criarOrcamento.getTfQuantMaxDias().getText().isEmpty()) {
			Mensagem.mostrar(null, "Informação", "Você precisa preencher os campos obrigatórios!");

		} else {
			String tituloOrcamStr = criarOrcamento.getTituloOrcamento().getText();
			String nomeClienteStr = criarOrcamento.getTfNomeCliente().getText();
			String telefoneClienteStr = criarOrcamento.getTfContato().getText();
			String emailClienteStr = criarOrcamento.getTfEmail().getText();
			String custoAdicStr = criarOrcamento.getTfCustoAdicional().getText();
			String horasPrevStr = criarOrcamento.getTfHorasPrevistas().getText();
			String quantDiasStr = criarOrcamento.getTfQuantMaxDias().getText();

			if (tituloPermit(tituloOrcamStr) == false) {
				Mensagem.mostrar(null, "Informação", "Título do orcamento inválido! \nExemplo: Título orçamento-01");
				return;

			} else if (nomePermit(nomeClienteStr) == false) {
				Mensagem.mostrar(null, "Informação", "Nome do cliente inválido! \nExemplo: Júlia, Dr. Lara...");
				return;

			} else if (!emailClienteStr.isEmpty() && emailClientePermit(emailClienteStr) == false) {
				Mensagem.mostrar(null, "Informação", "Email inválido! \nExemplo: aaA@bbbb.cc");
				return;

			} else if (!telefoneClienteStr.isEmpty() && telefonePermit(telefoneClienteStr) == false) {
				Mensagem.mostrar(null, "Informação", "Telefone inválido! \nExemplo: (11) 22222-3333");
				return;

			} else if (diasMaxQuantHrsPermit(horasPrevStr) == false) {
				Mensagem.mostrar(null, "Informação", "Horas previstas inválido! \nExemplo: 2, 5, 8...");
				return;

			} else if (diasMaxQuantHrsPermit(quantDiasStr) == false) {
				Mensagem.mostrar(null, "Informação", "Quantidade máxima de dias Inválido! \nExemplo: 2, 5, 8...");
				return;

			} else if (!custoAdicStr.isEmpty() && custoAdicPermit(formatarCustoAdic(custoAdicStr)) == false) {
				Mensagem.mostrar(null, "Informação", "Custo adicional inválido! \nExemplo: (2.5); (5,8); (8)...");
				return;

			} else {

				ativDesativCompAoSalvar();

				criarOrcamento.getLbValorFinalCad().setText(criarOrcamento.getLbValorCalVenda().getText());

				// DO CLIENTE
				Cliente cliente = new Cliente(null, null, null);
				cliente.setNome(criarOrcamento.getTfNomeCliente().getText());
				
				if(criarOrcamento.getTfEmail().getText().isEmpty()) {
					cliente.setEmail(null);
				} else {
					cliente.setEmail(criarOrcamento.getTfEmail().getText());
				}
				
				if(criarOrcamento.getTfContato().getText().isEmpty()) {
					cliente.setTelefone(null);
				} else {
					cliente.setTelefone(criarOrcamento.getTfContato().getText());
				}
				
				clienteDAO.adicionarDados(cliente);

				// DO ORÇAMENTO
				UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;

				Orcamento novoOrcamento = new Orcamento(null, 0, 0, 0, null, 0, 0, 0, 0);
				novoOrcamento.setTituloPedido(criarOrcamento.getTituloOrcamento().getText());
				novoOrcamento.setStatus((Orcamento.Status) criarOrcamento.getCbStatus().getSelectedItem());
				novoOrcamento.setPrecoHora(Float.parseFloat(criarOrcamento.getLbPrecoHoraUsuario().getText()));
				novoOrcamento.setPercentualLucro(Float.parseFloat(criarOrcamento.getLbPercLucroUsuario().getText()));
				novoOrcamento.setQuantHorasPrevistas(Integer.parseInt(criarOrcamento.getTfHorasPrevistas().getText()));
				novoOrcamento.setMaxDias(Integer.parseInt(criarOrcamento.getTfQuantMaxDias().getText()));
				novoOrcamento.setUsuarioPerfil(usuarioLogado);
				novoOrcamento.setCliente(cliente);
				
				if(custoAdicStr.isEmpty()) {
					novoOrcamento.setValorAdicional(Float.parseFloat("0"));
				} else {
					novoOrcamento.setValorAdicional(Float.parseFloat(formatarCustoAdic(custoAdicStr)));
				}
				
				novoOrcamento.setValorGastos(Float.parseFloat(criarOrcamento.getLbCalcGastos().getText().replace(",", ".")));
				novoOrcamento.setValorSemLucro(Float.parseFloat(criarOrcamento.getLbValorCalLucroAdici().getText().replace(",", ".")));
				orcamentoDAO.adicionarDados(novoOrcamento);

				this.orcamentoAtual = novoOrcamento;

				// DE CONFIRMAÇÃO DO ORCAMENTO
				ConfirOrcam confirOrcam = new ConfirOrcam(null, null, null, 0, 0);
				confirOrcam.setFormPagamento(null);
				confirOrcam.setDataPrevistaEntrega(null);
				confirOrcam.setDataConfirmacao(null);
				confirOrcam.setOrcamento(novoOrcamento);
				confirOrcam.setValorVenda(Float.parseFloat(criarOrcamento.getLbValorCalVenda().getText().replace(",", ".")));
				confirOrcam.setLucro(Float.parseFloat(criarOrcamento.getLbCalcLucro().getText().replace(",", ".")));
				confirOrcamDAO.adicionarDados(confirOrcam);
				this.confirOrcamAtual = confirOrcam;

				// O ORCAMENTO PRODUTO
				List<MateriaPrima> listaMP = criarOrcamento.tabModeloOrcam.getListaMP();

				for (MateriaPrima materiaPrima : listaMP) {

					OrcamentoProduto OP = new OrcamentoProduto();
					OP.setOrcamento(novoOrcamento);
					OP.setMateriaPrima(materiaPrima);
					OP.setQuantidade(materiaPrima.getQuantidadeDisponivel());
					new OrcamentoProdutoDAO().adicionarDados(OP);

				}

				atualizarQuantMP();
			}
		}
	}

	public void confirmar() {

		String dataConfirStr = criarOrcamento.getTfDataConfPedido().getText();
		String dataEntregaStr = criarOrcamento.getTfDtPrevEntrega().getText();

		if (!dataPermit(dataConfirStr)) {
			Mensagem.mostrar(null, "Informação", "Data de confitmação inválida! \nExemplo: 01/02/2026");
			return;

		} else if (!dataPermit(dataEntregaStr)) {
			Mensagem.mostrar(null, "Informação", "Data de entrega inválida! \nExemplo: 01/02/2026");
			return;

		} else {

			confirOrcamAtual.setFormPagamento(criarOrcamento.getCbFormaPaga().getSelectedItem().toString());

			if (!dataEntregaStr.trim().isEmpty()) {
				confirOrcamAtual.setDataPrevistaEntrega(LocalDate.parse(criarOrcamento.getTfDtPrevEntrega().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

			} else {
				confirOrcamAtual.setDataPrevistaEntrega(null);
			}

			if (!dataConfirStr.trim().isEmpty()) {
				confirOrcamAtual.setDataConfirmacao(LocalDate.parse(criarOrcamento.getTfDataConfPedido().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));

			} else {
				confirOrcamAtual.setDataConfirmacao(null);
			}

			confirOrcamAtual.setValorVenda(Float.parseFloat(criarOrcamento.getLbValorCalVenda().getText().replace(",", ".")));
			confirOrcamAtual.setLucro(Float.parseFloat(criarOrcamento.getLbCalcLucro().getText().replace(",", ".")));
			confirOrcamAtual.setOrcamento(orcamentoAtual);
			confirOrcamDAO.atualizarConfirOrcam(confirOrcamAtual);

			Mensagem.mostrar(null, "Sucesso", "Orçamento Confirmado com Sucesso");

			menu.mostrarPanelCont();
			navegadorTelas.navegarTela("ORCAMENTOS");
			limparCamposCriarORC();

		}

	}

	public void ativandoDevativandoComp() {

		if (criarOrcamento.getBtConfirmar().getText().equals("Confirmar")) {

			criarOrcamento.setPreferredSize(new Dimension(1020, 1200));
			criarOrcamento.getBtSalvar().setVisible(true);

		} else {

			criarOrcamento.setPreferredSize(new Dimension(1020, 1520));
			criarOrcamento.getBtSalvar().setVisible(false);

		}

		criarOrcamento.getTfQuantMaxDias().setEditable(false);
		criarOrcamento.getTfHorasPrevistas().setEditable(false);
		criarOrcamento.getTfCustoAdicional().setEditable(false);
		criarOrcamento.getBtAdicionar().setVisible(false);
		criarOrcamento.getBtRemover().setVisible(false);
		criarOrcamento.getLbValorCalLucroAdici().setVisible(true);
		criarOrcamento.getLbValorCalVenda().setVisible(true);
		criarOrcamento.getLbCalcGastos().setVisible(true);
		criarOrcamento.getLbCalcLucro().setVisible(true);
		criarOrcamento.getLbValorLucroAdicional().setVisible(true);
		criarOrcamento.getLbValorVenda().setVisible(true);
		criarOrcamento.getLbGastos().setVisible(true);
		criarOrcamento.getLbValorLucro().setVisible(true);
		criarOrcamento.getInterrogacaoLucroAdicional().setVisible(true);
		criarOrcamento.getInterTotal().setVisible(true);
		criarOrcamento.getInterLT().setVisible(true);
		criarOrcamento.getInterTotal().setVisible(true);
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

		criarOrcamento.setPreferredSize(new Dimension(1020, 1520));

		criarOrcamento.getTituloOrcamento().setEditable(false);
		criarOrcamento.getTfNomeCliente().setEditable(false);
		criarOrcamento.getTfContato().setEditable(false);
		criarOrcamento.getTfEmail().setEditable(false);
		criarOrcamento.getLbDtConfPedido().setVisible(true);
		criarOrcamento.getTfDataConfPedido().setVisible(true);
		criarOrcamento.getLbDtPrevEntrega().setVisible(true);
		criarOrcamento.getTfDtPrevEntrega().setVisible(true);
		criarOrcamento.getLbFormaPaga().setVisible(true);
		criarOrcamento.getCbFormaPaga().setVisible(true);
		criarOrcamento.getLbValorFinal().setVisible(true);
		criarOrcamento.getLbValorFinalCad().setVisible(true);
		criarOrcamento.getBtConfirmar().setVisible(true);
		criarOrcamento.getBtAdicionar().setVisible(false);
		criarOrcamento.getBtRemover().setVisible(false);
		criarOrcamento.getBtCalcEdi().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(false);

	}

	// VALIDAÇÃO DE NOME DO CLIENTE
	public boolean nomePermit(String nome) {

		String nomeValido = "[A-Za-zÀ-úçÇ. ]+";

		if (nome == null) {
			return false;
		}

		return nome.matches(nomeValido);
	}

	// VALIDAÇÃO DE TITULO DO ORÇAMENTO
	public boolean tituloPermit(String titulo) {

		String tituloValido = "[A-Za-zÀ-ú0-9çÇ. -]+";

		if (titulo == null) {
			return false;
		}

		return titulo.matches(tituloValido);

	}

	// VALIDAÇÃO DO EMAIL DO CLIENTE
	public boolean emailClientePermit(String email) {

		String emailValido = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

		if (email == null) {
			return false;
		}
		
		return email.matches(emailValido);
	}

	// VALIDAÇÃO DO TELEFONE DO CLIENTE
	public boolean telefonePermit(String telefone) {

		String telefoneValido = "[0-9\\-() ]{8,15}";

		if (telefone == null) {
			return false;
		}
		// boolean telefoneValido = telefone.matches("[0-9\\-() ]{8,15}");
		// boolean temDigitos = telefone.matches(".*[0-9].*");
		// return telefoneValido && temDigitos;
		return telefone.matches(telefoneValido);

	}

	// VALIDAÇÃO QUANTIDADE DE DIAS MÁXIMO E QUANTIDADE DE HORAS
	public boolean diasMaxQuantHrsPermit(String diasHoras) {

		String diasHorasValido = "[0-9]+$";

		if (diasHoras == null) {
			return false;
		}

		return diasHoras.matches(diasHorasValido);
	}

	// VALIDAÇÃO DE CUSTO ADICIONAL
	public boolean custoAdicPermit(String custoAdic) {

		String custoAdicValido = "[0-9]+([.,][0-9]+)?";

		if (custoAdic == null) {
			return false;
		}

		return custoAdic.matches(custoAdicValido);
	}

	// VALIDAÇÃO PARA CUSTO DE 2 CASAS DECIMAIS
	public String formatarCustoAdic(String custoAdic) {

		if (custoAdic == null) {
			return "0.00";
		}
		
		String custoAdicFormat = custoAdic.replace(",", ".");
		float custoAdicF = Float.parseFloat(custoAdicFormat);
		custoAdicF = (float) (Math.floor(custoAdicF * 100) / 100);
		return String.valueOf(custoAdicF);
	}

	// VALIDAÇÃO DE DATAS
	public boolean dataPermit(String data) {

		if (data == null || data.trim().isEmpty()) {
			return true;
		}

		if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
			return false;
		};

		try {
			LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void carregarTabelaOrcamentos() {

		// TALVEZ IRA PRECISAR SE MODIFICAR O MÉTODO NA CLASSE DAO
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;

		List<Orcamento> orcamentosCad = orcamentoDAO.listarOrcamentos(usuarioLogado.getEmail());
		orcamentos.tabelaModeloOrcamento.limpar();
		orcamentos.tabelaModeloOrcamento.setLista(orcamentosCad);

	}

	public void limparCamposCriarORC() {

		criarOrcamento.getTituloOrcamento().setText("");
		criarOrcamento.getTfNomeCliente().setText("");
		criarOrcamento.getTfContato().setText("");
		criarOrcamento.getTfEmail().setText("");
		criarOrcamento.getTfHorasPrevistas().setText("");
		criarOrcamento.getTfQuantMaxDias().setText("");
		criarOrcamento.getTfCustoAdicional().setText("");
		criarOrcamento.getTfDataConfPedido().setText("");
		criarOrcamento.getTfDtPrevEntrega().setText("");
		criarOrcamento.getCbStatus().setSelectedIndex(2);
		criarOrcamento.getCbFormaPaga().setSelectedIndex(0);

	}

	public void componentShown(ComponentEvent e) {
		this.carregarTabelaOrcamentos();

	}

}