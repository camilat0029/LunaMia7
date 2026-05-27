package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import model.Cliente;
import model.ClienteDAO;
import model.ConfirOrcam;
import model.ConfirOrcamDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.Orcamento;
import model.OrcamentoDAO;
import model.OrcamentoProdutoDAO;
import model.UsuarioPerfil;
import view.CadastroMateriaPrimaEstoque;
import view.CriarOrcamento;
import view.MateriaPrimaView;
import view.Mensagem;
import view.Orcamentos;
import view.TelaPrincipal;
import view.VisualizarMateriaPrima;
import view.VisualizarOrcamento;

public class BotoesAcoesController extends ComponentAdapter {

	private NavegadorTelas navegadorTelas;
	private TelaPrincipal tela;
	private VisualizarOrcamento visualizarOrcamento;
	private VisualizarMateriaPrima visualizarMateriaPrima;
	private Menu menu;
	private MateriaPrimaView materiaPrimaView;
	private Orcamentos orcamentos;
	private CadastroMateriaPrimaEstoque cadMateriaPrima;
	private CriarOrcamento criarOrcamento;
	private MateriaPrimaDAO materiaPrimaDAO;
	private ConfirOrcamDAO confirOrcamDAO;
	private OrcamentoProdutoDAO orcamProdDAO;
	private ClienteDAO clienteDAO;
	private OrcamentoDAO orcamentoDAO;
	private MateriaPrima MpEditada;
	private Orcamento OrcEditada;

	public BotoesAcoesController(NavegadorTelas navegadorTelas, TelaPrincipal tela,
			VisualizarOrcamento visualizarOrcamento, VisualizarMateriaPrima visualizarMateriaPrima, Menu menu,
			MateriaPrimaView materiaPrimaView, CadastroMateriaPrimaEstoque cadMateriaPrima,
			MateriaPrimaDAO materiaPrimaDAO, ConfirOrcamDAO confirOrcamDAO, Orcamentos orcamentos,
			OrcamentoProdutoDAO orcamProdDAO, CriarOrcamento criarOrcamento, ClienteDAO clienteDAO,
			OrcamentoDAO orcamentoDAO) {
		super();
		this.navegadorTelas = navegadorTelas;
		this.tela = tela;
		this.visualizarOrcamento = visualizarOrcamento;
		this.visualizarMateriaPrima = visualizarMateriaPrima;
		this.menu = menu;
		this.materiaPrimaView = materiaPrimaView;
		this.cadMateriaPrima = cadMateriaPrima;
		this.materiaPrimaDAO = materiaPrimaDAO;
		this.confirOrcamDAO = confirOrcamDAO;
		this.orcamentos = orcamentos;
		this.orcamProdDAO = orcamProdDAO;
		this.criarOrcamento = criarOrcamento;
		this.clienteDAO = clienteDAO;
		this.orcamentoDAO = orcamentoDAO;

		visualizarOrcamento.getTabMateriaisEstoque().setModel(visualizarOrcamento.tabModeloEstoque);

		// AÇÃO VOLTAR DA TELA DE VISUALIZAÇÃO DA MATERIA PRIMA
		this.visualizarMateriaPrima.voltar(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				menu.mostrarPanelCont();
				navegadorTelas.navegarTela("MATERIA_PRIMA");

			}
		});

		this.visualizarOrcamento.voltar(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				menu.mostrarPanelCont();
				navegadorTelas.navegarTela("ORCAMENTOS");
			}
		});

		// VISUALIZANDO AS INFORMAÇÕES DA MATERIA PRIMA
		this.materiaPrimaView.visualizar(materiaPrima -> {
			visualizarMP(materiaPrima);
		});

		// ATUALIZANDO AS INFORMAÇÕES DA MATERIA PRIMA
		this.materiaPrimaView.atualizar(materiaPrima -> {
			irParaAtualizarMP(materiaPrima);
		});

		this.cadMateriaPrima.confirmar(e -> {

			if (cadMateriaPrima.getBtConfirmar().getText().equals("Atualizar")) {
				atualizarMP();

				Mensagem.mostrar(null, "Informação", "Materia Prima Atualizada com Sucesso!");
				navegadorTelas.navegarTela("MATERIA_PRIMA");
			}
		});

		// EXCLUINDO MATERIA PRIMA
		this.materiaPrimaView.excluir(materiaPrima -> {
			excluirMP(materiaPrima);
		});

		// VISUALIZANDO ORCAMENTO
		this.orcamentos.visualizar(orcamento -> {
			visualizarOrcam(orcamento);
		});

		// ATUALIZANDO INFORMAÇÕES DO ORCAMENTO
		this.orcamentos.atualizar(orcamento -> {
			irParaAtualizarORC(orcamento);
		});

	}

	// MÉTODO PARA VISUALIZAR MATERIA PRIMA
	public void visualizarMP(MateriaPrima MP) {

		visualizarMateriaPrima.getLbNomeMpCad().setText(MP.getNome());
		visualizarMateriaPrima.getLbMarcaCad().setText(MP.getMarca());
		visualizarMateriaPrima.getLbCorCad().setText(MP.getCor());
		visualizarMateriaPrima.getLbQuantCad().setText(String.valueOf(MP.getQuantidadeDisponivel()));
		visualizarMateriaPrima.getLbQuantUniCad().setText(String.valueOf(MP.getQtdPorUnidade()));
		visualizarMateriaPrima.getLbUnMedCad().setText(String.valueOf(MP.getUnidadeMedida()));
		visualizarMateriaPrima.getLbValorCad().setText(String.valueOf(MP.getValor()));

		menu.removerMenu();
		navegadorTelas.navegarTela("VISUALIZAR_MATERIA_PRIMA");

	}

	// MÉTODO PARA IR PARA A TELA DE ATUALIZAR MATERIA PRIMA
	public void irParaAtualizarMP(MateriaPrima MP) {

		MpEditada = MP;

		cadMateriaPrima.getTfNomeMateriaPrima().setText(MP.getNome());
		cadMateriaPrima.getTfMarca().setText(MP.getMarca());
		cadMateriaPrima.getTfCor().setText(MP.getCor());
		cadMateriaPrima.getTfQtdDisponivel().setText(String.valueOf(MP.getQuantidadeDisponivel()));
		cadMateriaPrima.getTfQtdUnidade().setText(String.valueOf(MP.getQtdPorUnidade()));
		cadMateriaPrima.getCbUnidadeMedida().setSelectedItem(MP.getUnidadeMedida());
		;
		cadMateriaPrima.getTfValor().setText(String.valueOf(MP.getValor()));

		cadMateriaPrima.getBtConfirmar().setText("Atualizar");

		navegadorTelas.navegarTela("CADASTRO_MATERIA_PRIMA");
		menu.removerMenu();
	}

	// MÉTODO PARA ATUALIZAR MATERIA PRIMA
	public void atualizarMP() {

		MpEditada.setNome(cadMateriaPrima.getTfNomeMateriaPrima().getText());
		MpEditada.setMarca(cadMateriaPrima.getTfMarca().getText());
		MpEditada.setCor(cadMateriaPrima.getTfCor().getText());
		MpEditada.setQuantidadeDisponivel(Integer.parseInt(cadMateriaPrima.getTfQtdDisponivel().getText()));
		MpEditada.setQtdPorUnidade(Float.parseFloat(cadMateriaPrima.getTfQtdUnidade().getText()));
		MpEditada.setUnidadeMedida((MateriaPrima.UnidadeMedida) cadMateriaPrima.getCbUnidadeMedida().getSelectedItem());
		MpEditada.setValor(Float.parseFloat(cadMateriaPrima.getTfValor().getText()));

		materiaPrimaDAO.atualizarMateriasPrimas(MpEditada);

		carregarTabela();

		MpEditada = null;

	}

	// MÉTODO EXCLUIR MATERIA PRIMA
	public void excluirMP(MateriaPrima MP) {

		int linhaSelecionada = materiaPrimaView.getTabelaMateriaPrima().getSelectedRow();

		materiaPrimaView.tabelaModeloMateriaPrima.removerMatPrima(linhaSelecionada);
		materiaPrimaDAO.excluirMateriasPrimas(MP);

		Mensagem.mostrar(null, "Informação", "Materia prima exluída com sucesso!");
	}

	// RECARREGANDO TABELA MATERIA PRIMA
	public void carregarTabela() {

		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;

		List<MateriaPrima> lista = MateriaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
		materiaPrimaView.tabelaModeloMateriaPrima.limpar();
		materiaPrimaView.tabelaModeloMateriaPrima.setLista(lista);

	}

	// MÉTODO PARA VISUALIZAR ORCAMENTO
	public void visualizarOrcam(Orcamento orcam) {

		visualizarOrcamento.getLbTituloOrcamCad().setText(orcam.getTituloPedido());
		visualizarOrcamento.getLbNomeClienteCad().setText(orcam.getCliente().getNome());
		visualizarOrcamento.getLbContClienteCad().setText(orcam.getCliente().getTelefone());
		visualizarOrcamento.getLbEmailClienteCad().setText(orcam.getCliente().getEmail());
		visualizarOrcamento.getLbPrecoHoraCad().setText(String.valueOf(orcam.getPrecoHora()));
		visualizarOrcamento.getLbPercLucroCad().setText(String.valueOf(orcam.getUsuarioPerfil().getPercentualLucro()));
		visualizarOrcamento.getLbHorasPrevistasCad().setText(String.valueOf(orcam.getQuantHorasPrevistas()));
		visualizarOrcamento.getLbQuantDiasMaxCad().setText(String.valueOf(orcam.getMaxDias()));
		// visualizarOrcamento.getLbCustoAdiCad().setText(orcam.get); // calor adcional
		visualizarOrcamento.getLbStatusCad().setText(String.valueOf(orcam.getStatus()));

		ConfirOrcam confirOrcam = confirOrcamDAO.buscarPeloOrcamento(orcam.getIdOrcamento());

		if (confirOrcam != null) {
			visualizarOrcamento.getLbFormaPagCad().setText(confirOrcam.getFormPagamento());
			visualizarOrcamento.getLbDtConfirCad().setText(String.valueOf(confirOrcam.getDataConfirmacao()));
			visualizarOrcamento.getLbDtEntregaCad().setText(String.valueOf(confirOrcam.getDataPrevistaEntrega()));
			visualizarOrcamento.getLbValorVendaCad().setText(String.valueOf(confirOrcam.getValorVenda()));
			visualizarOrcamento.getLbValorLucroCad().setText(String.valueOf(confirOrcam.getLucro()));
			visualizarOrcamento.getLbValorFinalCad().setText(String.valueOf(confirOrcam.getValorVenda()));
		}

		// visualizarOrcamento.getLbTituloOrcamCad().setText(orcam.getTituloPedido());
		// // valor gastos
		// visualizarOrcamento.getLbTituloOrcamCad().setText(orcam.getTituloPedido());
		// // valor sem lucro

		List<MateriaPrima> MPs = orcamProdDAO.buscarPeloIdOrcamento(orcam.getIdOrcamento());
		visualizarOrcamento.tabModeloEstoque.setLista(MPs);

		menu.removerMenu();
		navegadorTelas.navegarTela("VISUALIZAR_ORCAMENTO");

	}

	// MÉTODO PARA IR PARA A TELA DE ATUALIZAR ORCAMENTO
	public void irParaAtualizarORC(Orcamento orcam) {

		OrcEditada = orcam;

		criarOrcamento.getTituloOrcamento().setText(orcam.getTituloPedido());
		criarOrcamento.getTfNomeCliente().setText(orcam.getTituloPedido());
		criarOrcamento.getTfContato().setText(orcam.getCliente().getTelefone());
		criarOrcamento.getTfEmail().setText(orcam.getCliente().getEmail());
		criarOrcamento.getLbPrecoHoraUsuario().setText(String.valueOf(orcam.getUsuarioPerfil().getPrecoHora())); // Vefificar
																													// se
																													// dará
																													// certo
																													// caso
																													// a
																													// pessoa
																													// queira
																													// mudar
																													// esse
																													// valor
		criarOrcamento.getLbPercLucroUsuario().setText(String.valueOf(orcam.getUsuarioPerfil().getPercentualLucro())); // verificar
																														// também
		criarOrcamento.getTfHorasPrevistas().setText(String.valueOf(orcam.getQuantHorasPrevistas()));
		criarOrcamento.getTfQuantMaxDias().setText(String.valueOf(orcam.getMaxDias()));
		// custo adicional
		criarOrcamento.getCbStatus().setSelectedItem(orcam.getStatus());

		ConfirOrcam confirOrcam = confirOrcamDAO.buscarPeloOrcamento(orcam.getIdOrcamento());

		if (confirOrcam != null) {

			criarOrcamento.getCbFormaPaga().setSelectedItem(confirOrcam.getFormPagamento());
			criarOrcamento.getTfDataConfPedido().setText(String.valueOf(confirOrcam.getDataConfirmacao()));
			criarOrcamento.getTfDtPrevEntrega().setText(String.valueOf(confirOrcam.getDataPrevistaEntrega()));
			criarOrcamento.getLbValorCalVenda().setText(String.valueOf(confirOrcam.getValorVenda()));
			criarOrcamento.getLbValorLucro().setText(String.valueOf(confirOrcam.getLucro()));
			criarOrcamento.getLbValorFinalCad().setText(String.valueOf(confirOrcam.getValorVenda()));
		}

		List<MateriaPrima> MPs = orcamProdDAO.buscarPeloIdOrcamento(orcam.getIdOrcamento());
		criarOrcamento.tabModeloOrcam.setLista(MPs);

		criarOrcamento.getBtSalvar().setVisible(false);
		criarOrcamento.getBtConfirmar().setText("Atualizar");

		criarOrcamento.getTfNomeCliente().setEditable(false);

		menu.removerMenu();
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");

	}

	// MÉTODO PARA ATUALIZAR ORCAMENTO
	public void atualizarORC() {

		Cliente clienteEdtidado = OrcEditada.getCliente();

		clienteEdtidado.setTelefone(criarOrcamento.getTfContato().getText());
		clienteEdtidado.setEmail(criarOrcamento.getTfEmail().getText());
		clienteDAO.atualizarCliente(clienteEdtidado);

		OrcEditada.setTituloPedido(criarOrcamento.getTituloOrcamento().getText());
		OrcEditada.setQuantHorasPrevistas(Float.parseFloat(criarOrcamento.getTfHorasPrevistas().getText()));
		OrcEditada.setMaxDias(Integer.parseInt(criarOrcamento.getTfQuantMaxDias().getText()));
		OrcEditada.setStatus((Orcamento.Status) criarOrcamento.getCbStatus().getSelectedItem());
		orcamentoDAO.atualizarOrcamento(OrcEditada);

		ConfirOrcam confirOrcam = confirOrcamDAO.buscarPeloOrcamento(OrcEditada.getIdOrcamento());

		if (confirOrcam != null) {
			confirOrcam.setOrcamento(OrcEditada);
			confirOrcam.setFormPagamento(criarOrcamento.getCbFormaPaga().getSelectedItem().toString());
			confirOrcam.setDataConfirmacao(LocalDate.parse(criarOrcamento.getTfDataConfPedido().getText(),
					DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			confirOrcam.setDataPrevistaEntrega(LocalDate.parse(criarOrcamento.getTfDtPrevEntrega().getText(),
					DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			confirOrcam.setValorVenda(Float.parseFloat(criarOrcamento.getLbValorCalVenda().getText()));
			confirOrcam.setLucro(Float.parseFloat(criarOrcamento.getLbCalcLucro().getText()));
		}

		// TERMINAR ATUALIZAR COM AS MATERIAS PRIMAS UTILIZADAS NO ORÇAMENTO

		Mensagem.mostrar(null, "Informação", "Orçamento atualizado com sucesso!");
		navegadorTelas.navegarTela("ORCAMENTOS");

		OrcEditada = null;

	}

	// MÉTODO DE EXCLUIR ORÇAMENTO
	// MÉTODO DE CANCELAR ORÇAMENTO

	public void componentShown(ComponentEvent e) {
		this.carregarTabela();
	}

}