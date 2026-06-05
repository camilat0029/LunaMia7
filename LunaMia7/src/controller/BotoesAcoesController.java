package controller;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;
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
import view.CadastroMateriaPrimaEstoque;
import view.CriarOrcamento;
import view.MateriaPrimaView;
import view.Mensagem;
import view.MensagemSimNao;
import view.Orcamentos;
import view.VisualizarMateriaPrima;
import view.VisualizarOrcamento;

public class BotoesAcoesController extends ComponentAdapter {

	private NavegadorTelas navegadorTelas;
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
	private JScrollPane scrollPaneOrcamento;

	public BotoesAcoesController(NavegadorTelas navegadorTelas, VisualizarOrcamento visualizarOrcamento, 
			VisualizarMateriaPrima visualizarMateriaPrima, Menu menu,
			MateriaPrimaView materiaPrimaView, CadastroMateriaPrimaEstoque cadMateriaPrima,
			MateriaPrimaDAO materiaPrimaDAO, ConfirOrcamDAO confirOrcamDAO, Orcamentos orcamentos,
			OrcamentoProdutoDAO orcamProdDAO, CriarOrcamento criarOrcamento, ClienteDAO clienteDAO,
			OrcamentoDAO orcamentoDAO, JScrollPane scrollPaneOrcamento) {
		super();
		this.navegadorTelas = navegadorTelas;
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
		this.scrollPaneOrcamento = scrollPaneOrcamento;

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
				limparCamposMP();
				navegadorTelas.navegarTela("MATERIA_PRIMA");
				SwingUtilities.invokeLater(() -> {
					scrollPaneOrcamento.getVerticalScrollBar().setValue(0);
				});
				menu.mostrarPanelCont();
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
		
		this.criarOrcamento.confirmar(e -> {
			if(criarOrcamento.getBtConfirmar().getText().equals("Atualizar")) {
				atualizarORC();
			}
		});
		
		//EXCLUINDO INFORMAÇÕES DO ORCAMENTO
		this.orcamentos.excluir(orcamento -> {
			excluirORC(orcamento);
		});
		
		//CANCELANDO INFORMAÇÕES DO ORÇAMENTO
		this.orcamentos.cancelar(orcamento -> {
			cancelarORC(orcamento);
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
	    boolean emUso = orcamProdDAO.existePorIdMateriaPrima(MP.getIdMateriaPrima());

	    if (emUso) {
	        Mensagem.mostrar(null, "Atenção", "Essa matéria prima está \nvinculada a um ou mais orçamentos \ne não pode ser excluída!");
	        return;
	    }

	    int linhaSelecionada = materiaPrimaView.getTabelaMateriaPrima().getSelectedRow();
	   
		int confirm = MensagemSimNao.mostrar(null, "Excluir", "Deseja excluir a matéria prima? \nEsta ação não poderá ser desfeita.");

		if (confirm == JOptionPane.YES_OPTION) {
			
		    materiaPrimaView.tabelaModeloMateriaPrima.removerMatPrima(linhaSelecionada);
		    materiaPrimaDAO.excluirMateriasPrimas(MP);

		    Mensagem.mostrar(null, "Informação", "Materia prima excluída com sucesso!");

		}

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
		
		if (orcam.getCliente().getTelefone() != null) {
			visualizarOrcamento.getLbContClienteCad().setText(orcam.getCliente().getTelefone());
		} else {
			visualizarOrcamento.getLbContClienteCad().setText("");
		}
		
		if(orcam.getCliente().getEmail() != null) {
			visualizarOrcamento.getLbEmailClienteCad().setText(orcam.getCliente().getEmail());
		} else {
			visualizarOrcamento.getLbEmailClienteCad().setText("");
		}
		
		visualizarOrcamento.getLbPrecoHoraCad().setText(String.valueOf(orcam.getPrecoHora()));
		visualizarOrcamento.getLbPercLucroCad().setText(String.valueOf(orcam.getUsuarioPerfil().getPercentualLucro()));
		visualizarOrcamento.getLbHorasPrevistasCad().setText(String.valueOf(orcam.getQuantHorasPrevistas()));
		visualizarOrcamento.getLbQuantDiasMaxCad().setText(String.valueOf(orcam.getMaxDias()));
		visualizarOrcamento.getLbCustoAdiCad().setText(String.valueOf(orcam.getValorAdicional()));
		visualizarOrcamento.getLbStatusCad().setText(String.valueOf(orcam.getStatus()));

		ConfirOrcam confirOrcam = confirOrcamDAO.buscarPeloOrcamento(orcam.getIdOrcamento());

		if (confirOrcam != null) {
			visualizarOrcamento.getLbFormaPagCad().setText(confirOrcam.getFormPagamento());
			if(confirOrcam.getDataConfirmacao()==null) {
				visualizarOrcamento.getLbDtConfirCad().setText("");
			} else {
				visualizarOrcamento.getLbDtConfirCad().setText(String.valueOf(confirOrcam.getDataConfirmacao()));
			}
			
			if(confirOrcam.getDataPrevistaEntrega()==null) {
				visualizarOrcamento.getLbDtEntregaCad().setText("");
			} else {
				visualizarOrcamento.getLbDtEntregaCad().setText(String.valueOf(confirOrcam.getDataPrevistaEntrega()));
			}
			
			visualizarOrcamento.getLbValorVendaCad().setText(String.valueOf(confirOrcam.getValorVenda()));
			visualizarOrcamento.getLbValorLucroCad().setText(String.valueOf(confirOrcam.getLucro()));
			visualizarOrcamento.getLbValorFinalCad().setText(String.valueOf(confirOrcam.getValorVenda()));
		}

		visualizarOrcamento.getLbTotalGastosCad().setText(String.valueOf(orcam.getValorGastos()));
		visualizarOrcamento.getLbValorSemLucroCad().setText(String.valueOf(orcam.getValorSemLucro()));

		List<MateriaPrima> MPs = orcamProdDAO.buscarPeloIdOrcamento(orcam.getIdOrcamento());
		visualizarOrcamento.tabModeloEstoque.setLista(MPs);

		menu.removerMenu();
		navegadorTelas.navegarTela("VISUALIZAR_ORCAMENTO");

	}

	// MÉTODO PARA IR PARA A TELA DE ATUALIZAR ORCAMENTO
	public void irParaAtualizarORC(Orcamento orcam) {
		
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;
		List<MateriaPrima> estoque = materiaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
		criarOrcamento.tabModeloEstoque.limpar();
		criarOrcamento.tabModeloEstoque.setLista(estoque);

		OrcEditada = orcam;

		criarOrcamento.getTituloOrcamento().setText(orcam.getTituloPedido());
		criarOrcamento.getTfNomeCliente().setText(orcam.getCliente().getNome());
		
		if(orcam.getCliente().getTelefone() != null) {
			criarOrcamento.getTfContato().setText(orcam.getCliente().getTelefone());
		} else {
			criarOrcamento.getTfContato().setText("");
		}
		
		if(orcam.getCliente().getEmail() != null) {
			criarOrcamento.getTfEmail().setText(orcam.getCliente().getEmail());
		} else {
			criarOrcamento.getTfEmail().setText("");
		}
		
		criarOrcamento.getLbPrecoHoraUsuario().setText(String.valueOf(orcam.getPrecoHora())); // Vefificar se dará certo caso a																									     // pessoa queira mudar esse valor
		criarOrcamento.getLbPercLucroUsuario().setText(String.valueOf(orcam.getPercentualLucro())); // verificar também
		criarOrcamento.getTfHorasPrevistas().setText(String.valueOf(orcam.getQuantHorasPrevistas()));
		criarOrcamento.getTfQuantMaxDias().setText(String.valueOf(orcam.getMaxDias()));
		criarOrcamento.getLbCalcGastos().setText(String.valueOf(orcam.getValorGastos()));
		criarOrcamento.getLbValorCalLucroAdici().setText(String.valueOf(orcam.getValorSemLucro()));
		criarOrcamento.getCbStatus().setSelectedItem(orcam.getStatus());

		ConfirOrcam confirOrcam = confirOrcamDAO.buscarPeloOrcamento(orcam.getIdOrcamento());

		if (confirOrcam != null) {

			criarOrcamento.getCbFormaPaga().setSelectedItem(confirOrcam.getFormPagamento());
			
			DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			if(confirOrcam.getDataConfirmacao()==null) {
				criarOrcamento.getTfDataConfPedido().setText("");
			} else {
				criarOrcamento.getTfDataConfPedido().setText(confirOrcam.getDataConfirmacao().format(formatacao));
			}
			
			if(confirOrcam.getDataPrevistaEntrega()==null) {
				criarOrcamento.getTfDtPrevEntrega().setText("");
			} else {
				criarOrcamento.getTfDtPrevEntrega().setText(confirOrcam.getDataPrevistaEntrega().format(formatacao));
			}
			
			criarOrcamento.getLbValorCalVenda().setText(String.valueOf(confirOrcam.getValorVenda()));
			criarOrcamento.getLbCalcLucro().setText(String.valueOf(confirOrcam.getLucro()));
			criarOrcamento.getLbValorFinalCad().setText(String.valueOf(confirOrcam.getValorVenda()));
		}

		List<MateriaPrima> MPs = orcamProdDAO.buscarPeloIdOrcamento(orcam.getIdOrcamento());
		criarOrcamento.tabModeloOrcam.setLista(MPs);

		ativDesaCompParaIrAtualizar();
		criarOrcamento.getBtCalcEdi().setText("Calcular");
		criarOrcamento.getBtConfirmar().setText("Atualizar");

		menu.removerMenu();
		
		criarOrcamento.setPreferredSize(new Dimension(1020, 1520));
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
		
		SwingUtilities.invokeLater(() -> {

		    JScrollPane scrollReal = (JScrollPane)
		            SwingUtilities.getAncestorOfClass(
		                    JScrollPane.class,
		                    criarOrcamento);

		    if (scrollReal != null) {
		        scrollReal.getVerticalScrollBar().setValue(0);
		    }
		});

	}

	// MÉTODO PARA ATUALIZAR ORCAMENTO
	public void atualizarORC() {
		
		//COLOCAR VALIDAÇÕES DO ORÇAMENTO AQUI
		//PERMITIR A ATUALIZAÇÃO DO NOME DO CLIENTE
		//FORMATAR OS VALORES DE CÁLCULOS QUE APAREM NOS LABELS PARA SÓ TEREM 2 CASAS DECIMAIS.
		
		String tituloOrcamStr = criarOrcamento.getTituloOrcamento().getText();
		String nomeClienteStr = criarOrcamento.getTfNomeCliente().getText();
		String telefoneClienteStr = criarOrcamento.getTfContato().getText();
		String emailClienteStr = criarOrcamento.getTfEmail().getText();
		String custoAdicStr = criarOrcamento.getTfCustoAdicional().getText();
		String horasPrevStr = criarOrcamento.getTfHorasPrevistas().getText();
		String quantDiasStr = criarOrcamento.getTfQuantMaxDias().getText();
		String dataConfirStr = criarOrcamento.getTfDataConfPedido().getText();
		String dataEntregaStr = criarOrcamento.getTfDtPrevEntrega().getText();
		
		if (tituloPermit(tituloOrcamStr)==false) {
			Mensagem.mostrar(null, "Informação", "Título do orcamento inválido! \nExexmplo: Título orçamento-01");
			return;
			
		}else if(nomePermit(nomeClienteStr)==false){
			Mensagem.mostrar(null, "Informação", "Nome do cliente inválido! \nExexmplo: Júlia, Dr. Lara...");
			return;
			
		}else if(!emailClienteStr.isEmpty() && emailClientePermit(emailClienteStr)==false){
			Mensagem.mostrar(null, "Informação", "Email inválido! \nExexmplo: aaA@bbbb.cc");
			return;
			
		}else if(!telefoneClienteStr.isEmpty() && telefonePermit(telefoneClienteStr)==false){
			Mensagem.mostrar(null, "Informação", "Telefone inválido! \nExexmplo: (11) 22222-3333");
			return;
			
		}else if (diasMaxQuantHrsPermit(horasPrevStr)==false) {
		
			Mensagem.mostrar(null, "Informação", "Horas previstas inválido! \nExexmplo: 2, 5, 8...");
			return;
			
		}  else if(diasMaxQuantHrsPermit(quantDiasStr)==false) {
			Mensagem.mostrar(null, "Informação", "Quantidade máxima de dias Inválido! \nExexmplo: 2, 5, 8...");
			return;
			
		} else if(!custoAdicStr.isEmpty() && custoAdicPermit(custoAdicStr)==false) {
			Mensagem.mostrar(null, "Informação", "Custo adicional inválido! \nExexmplo: (2.5); (5,8); (8)...");
			return;
			
		} else if(!dataPermit(dataConfirStr)) {
			Mensagem.mostrar(null, "Informação", "Data de confitmação inválida! \nExemplo: 01/02/2026");
			return;
			
		} else if(!dataPermit(dataEntregaStr)) {
			Mensagem.mostrar(null, "Informação", "Data de entrega inválida! \nExemplo: 01/02/2026");
			return;
			
		} else {
			
			Cliente clienteEdtidado = OrcEditada.getCliente();
			
			clienteEdtidado.setNome(criarOrcamento.getTfNomeCliente().getText());

			if(criarOrcamento.getTfContato().getText().isEmpty()) {
				clienteEdtidado.setTelefone(null);
			} else {
				clienteEdtidado.setTelefone(criarOrcamento.getTfContato().getText());
			}
			
			if(criarOrcamento.getTfEmail().getText().isEmpty()) {
				clienteEdtidado.setEmail(null);
			} else {
				clienteEdtidado.setEmail(criarOrcamento.getTfEmail().getText());
			}
			
			clienteDAO.atualizarCliente(clienteEdtidado);

			OrcEditada.setTituloPedido(criarOrcamento.getTituloOrcamento().getText());
			OrcEditada.setQuantHorasPrevistas(Integer.parseInt(criarOrcamento.getTfHorasPrevistas().getText()));
			OrcEditada.setPrecoHora(Float.parseFloat(criarOrcamento.getLbPrecoHoraUsuario().getText().replace(",", ".")));
			OrcEditada.setPercentualLucro(Float.parseFloat(criarOrcamento.getLbPercLucroUsuario().getText().replace(",", ".")));
			OrcEditada.setMaxDias(Integer.parseInt(criarOrcamento.getTfQuantMaxDias().getText()));
			OrcEditada.setStatus((Orcamento.Status) criarOrcamento.getCbStatus().getSelectedItem());
			
			if(custoAdicStr.isEmpty()) {
				OrcEditada.setValorAdicional(Float.parseFloat("0"));
			} else {
				OrcEditada.setValorAdicional(Float.parseFloat(formatarCustoAdic(criarOrcamento.getTfCustoAdicional().getText().replace(",", "."))));
			}
			
			OrcEditada.setValorGastos(Float.parseFloat(criarOrcamento.getLbCalcGastos().getText().replace(",", ".")));
			OrcEditada.setValorSemLucro(Float.parseFloat(criarOrcamento.getLbValorCalLucroAdici().getText().replace(",", ".")));
			orcamentoDAO.atualizarOrcamento(OrcEditada);

			ConfirOrcam confirOrcam = confirOrcamDAO.buscarPeloOrcamento(OrcEditada.getIdOrcamento());

			if (confirOrcam != null) {
				confirOrcam.setOrcamento(OrcEditada);
				confirOrcam.setFormPagamento(criarOrcamento.getCbFormaPaga().getSelectedItem().toString());
				
				if(!dataConfirStr.trim().isEmpty()) {
					confirOrcam.setDataConfirmacao(LocalDate.parse(criarOrcamento.getTfDataConfPedido().getText(),
							DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				} else {
					confirOrcam.setDataConfirmacao(null);
				}
				
				if(!dataEntregaStr.trim().isEmpty()) {
					confirOrcam.setDataPrevistaEntrega(LocalDate.parse(criarOrcamento.getTfDtPrevEntrega().getText(),
							DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				} else {
					confirOrcam.setDataPrevistaEntrega(null);
				}
				
				confirOrcam.setValorVenda(Float.parseFloat(criarOrcamento.getLbValorCalVenda().getText().replace(",", ".")));
				confirOrcam.setLucro(Float.parseFloat(criarOrcamento.getLbCalcLucro().getText().replace(",", ".")));
				
				confirOrcamDAO.atualizarConfirOrcam(confirOrcam);
			}
			
			orcamProdDAO.excluirPorIdOrcamento(OrcEditada.getIdOrcamento());
			
			List<MateriaPrima> listaMP = criarOrcamento.tabModeloOrcam.getListaMP();
			
			for (MateriaPrima materiaPrima : listaMP) {
				OrcamentoProduto orcamProd = new OrcamentoProduto();
				
				orcamProd.setOrcamento(OrcEditada);
				orcamProd.setMateriaPrima(materiaPrima);
				orcamProd.setQuantidade(materiaPrima.getQuantidadeDisponivel());
				orcamProdDAO.adicionarDados(orcamProd);
				
			}
			
			atualizarQuantMP();

			Mensagem.mostrar(null, "Informação", "Orçamento atualizado com sucesso!");
			navegadorTelas.navegarTela("ORCAMENTOS");
			limparCamposCriarORC();
			menu.mostrarPanelCont();
			
			OrcEditada = null;
			
		}
	}
	
	// MÉTODO DE EXCLUIR ORÇAMENTO
	// MÉTODO DE EXCLUIR ORÇAMENTO
	public void excluirORC(Orcamento orcamento) {
		
		int linhaSelecionada = orcamentos.getTabelaOrcamentos().getSelectedRow();
		
		
		int confirm = MensagemSimNao.mostrar(null, "Excluir", "Deseja excluir o orçamento? \nEsta ação não poderá desfeita.");

		if (confirm == JOptionPane.YES_OPTION) {
			
			orcamProdDAO.excluirPorIdOrcamento(orcamento.getIdOrcamento());
			confirOrcamDAO.excluirConfirOrcam(orcamento.getIdOrcamento());
			
			orcamentos.tabelaModeloOrcamento.removerOrcamento(linhaSelecionada);
			orcamentoDAO.excluirOrcamento(orcamento);
			clienteDAO.excluirCliente(orcamento.getCliente().getIdCliente());
			
			Mensagem.mostrar(null, "Informação", "Orçamento exluído com sucesso!");
		}
		
	}
	
	
	// MÉTODO DE CANCELAR ORÇAMENTO
	public void cancelarORC(Orcamento orcamento) {
		
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;
		int linhaSelecionada = orcamentos.getTabelaOrcamentos().getSelectedRow();
		
		//orcamentos.tabelaModeloOrcamento.getOrcamento(linhaSelecionada);
		
		ConfirOrcamDAO confirOrcamDAO = new ConfirOrcamDAO();
		Cliente cliente = orcamento.getCliente();
		
		int confirm = MensagemSimNao.mostrar(null, "Cancelar", "Deseja cancelar o orçamento? \nEsta ação não poderá desfeita, \ne a matéria prima voltará para o estoque.");

		if (confirm == JOptionPane.YES_OPTION) {
		
		List<OrcamentoProduto> listaProdUtiORC = orcamProdDAO.listarOrcamProd();
		List<MateriaPrima> listaMP = materiaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
		
		for (OrcamentoProduto orcamentoProduto : listaProdUtiORC) {
			
			if(orcamentoProduto.getOrcamento().getIdOrcamento() == orcamento.getIdOrcamento()) {
				
				int idMP = orcamentoProduto.getMateriaPrima().getIdMateriaPrima();
				int quantORC = orcamentoProduto.getQuantidade();
				int quantMP = 0;
				
				for (MateriaPrima materiaPrima : listaMP) {
					if(materiaPrima.getIdMateriaPrima() == idMP) {
						quantMP = materiaPrima.getQuantidadeDisponivel();
						break;
					}
				}
				
				int quantAtualizMP = quantMP + quantORC;
				materiaPrimaDAO.atualizarQuantMP(idMP,quantAtualizMP);
				
			}
		}
		
		orcamProdDAO.excluirPorIdOrcamento(orcamento.getIdOrcamento());
		confirOrcamDAO.excluirConfirOrcam(orcamento.getIdOrcamento());
		
		orcamentos.tabelaModeloOrcamento.removerOrcamento(linhaSelecionada);
		orcamentoDAO.excluirOrcamento(orcamento);
		clienteDAO.excluirCliente(orcamento.getCliente().getIdCliente());
		
		Mensagem.mostrar(null, "Informação", "Orçamento cancelado com sucesso! \nQuantidade das materias primas \nutilizadas no seu orçamento \natualizadas com sucesso! ");
		}
	}
	
	
	public void atualizarQuantMP() {

		int totalLinhas = criarOrcamento.tabModeloEstoque.getRowCount();

		for (int i = 0; i < totalLinhas; i++) {
			MateriaPrima materiaPrima = criarOrcamento.tabModeloEstoque.getMatPrima(i);
			materiaPrimaDAO.atualizarQuantMP(materiaPrima.getIdMateriaPrima(), materiaPrima.getQuantidadeDisponivel());
		}
	}
	
	//VALIDAÇÃO DE NOME DO CLIENTE
		public boolean nomePermit(String nome) {
			String nomeValido = "[A-Za-zÀ-úçÇ. ]+";
			
			if(nome==null) {
				return false;
			}
			
			return nome.matches(nomeValido);
		}
	
	//VALIDAÇÃO DE TITULO DO ORÇAMENTO
	public boolean tituloPermit(String titulo) {
		String tituloValido = "[A-Za-zÀ-ú0-9çÇ. -]+";
			
		if(titulo==null) {
			return false;
		}
			
		return titulo.matches(tituloValido);
	}
		
	//VALIDAÇÃO DO EMAIL DO CLIENTE
	public boolean emailClientePermit(String email) {
		String emailValido = "[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		if(email==null) {
			return false;
		}
		return email.matches(emailValido);
	}
		
	//VALIDAÇÃO DO TELEFONE DO CLIENTE
	public boolean telefonePermit(String telefone) {
		String telefoneValido = "[0-9\\-() ]{8,15}";
		if(telefone==null) {
			return false;
		}
		//boolean telefoneValido = telefone.matches("[0-9\\-() ]{8,15}");
		//boolean temDigitos = telefone.matches(".*[0-9].*");
		//return telefoneValido && temDigitos;
		return telefone.matches(telefoneValido);
	}
		
	//VALIDAÇÃO QUANTIDADE DE DIAS MÁXIMO E QUANTIDADE DE HORAS
	public boolean diasMaxQuantHrsPermit(String diasHoras) {
		String diasHorasValido = "[0-9]+$";
		if(diasHoras==null) {
			return false;
		}
		return diasHoras.matches(diasHorasValido);
	}
	//VALIDAÇÃO DE CUSTO ADICIONAL
	public boolean custoAdicPermit(String custoAdic) {
		String custoAdicValido = "[0-9]+([.,][0-9]+)?";
		if(custoAdic==null) {
			return false;
		}
		return custoAdic.matches(custoAdicValido);
	}
		
	//VALIDAÇÃO PARA CUSTO DE 2 CASAS DECIMAIS
	public String formatarCustoAdic(String custoAdic) {
		if (custoAdic == null) {
			return "0.00";
		}
		String custoAdicFormat = custoAdic.replace(",", ".");
		float custoAdicF = Float.parseFloat(custoAdicFormat);
		    
		custoAdicF = (float)(Math.floor(custoAdicF * 100) / 100);
		return String.valueOf(custoAdicF);
	}
		
	//VALIDAÇÃO DE DATAS
	public boolean dataPermit(String data) {
		if(data==null || data.trim().isEmpty()) {
			return true;
		}
			
		if(!data.matches("\\d{2}/\\d{2}/\\d{4}")){
			return false;
		};
			
		try {
			LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		    return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void ativDesaCompParaIrAtualizar() {
		criarOrcamento.getTituloOrcamento().setEditable(true);
		criarOrcamento.getTfContato().setEditable(true);
		criarOrcamento.getTfEmail().setEditable(true);
		criarOrcamento.getTfCustoAdicional().setEditable(true);
		criarOrcamento.getTfHorasPrevistas().setEditable(true);
		criarOrcamento.getTfQuantMaxDias().setEditable(true);
		criarOrcamento.getBtAdicionar().setVisible(true);
		criarOrcamento.getBtRemover().setVisible(true);
		criarOrcamento.getBtCalcEdi().setVisible(true);
		criarOrcamento.getBtSalvar().setVisible(false);
		criarOrcamento.getLbCalcGastos().setVisible(true);
		criarOrcamento.getLbCalcLucro().setVisible(true);
		criarOrcamento.getLbValorCalLucroAdici().setVisible(true);
		criarOrcamento.getTfDataConfPedido().setVisible(true);
		criarOrcamento.getTfDtPrevEntrega().setVisible(true);
		criarOrcamento.getLbGastos().setVisible(true);
		criarOrcamento.getLbValorLucro().setVisible(true);
		criarOrcamento.getInterrogacaoLucroAdicional().setVisible(true);
		criarOrcamento.getInterTotal().setVisible(true);
		criarOrcamento.getInterLT().setVisible(true);
		criarOrcamento.getInterTotal().setVisible(true);
		criarOrcamento.getLbStatus().setVisible(true);
		criarOrcamento.getCbStatus().setVisible(true);
		criarOrcamento.getLbValorLucroAdicional().setVisible(true);
		criarOrcamento.getLbValorVenda().setVisible(true);
		criarOrcamento.getLbValorCalVenda().setVisible(true);
		criarOrcamento.getLbFormaPaga().setVisible(true);
		criarOrcamento.getLbDtConfPedido().setVisible(true);
		criarOrcamento.getLbDtPrevEntrega().setVisible(true);
		criarOrcamento.getCbFormaPaga().setVisible(true);
		criarOrcamento.getLbValorFinal().setVisible(true);
		criarOrcamento.getLbValorFinalCad().setVisible(true);
		criarOrcamento.getBtConfirmar().setVisible(true);
	}
	
	public void limparCamposMP() {
		cadMateriaPrima.getTfNomeMateriaPrima().setText("");
		cadMateriaPrima.getTfCor().setText("");
		cadMateriaPrima.getTfMarca().setText("");
		cadMateriaPrima.getTfQtdDisponivel().setText("");
		cadMateriaPrima.getTfQtdUnidade().setText("");
		cadMateriaPrima.getTfValor().setText("");
		cadMateriaPrima.getCbUnidadeMedida().setSelectedIndex(0);

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
		this.carregarTabela();
	}

}