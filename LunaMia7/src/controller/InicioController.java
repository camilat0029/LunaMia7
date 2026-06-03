package controller;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

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
	private JScrollPane scrollPaneOrcamento;
	
	public InicioController(Inicio inicio, NavegadorTelas navegadorTelas, Menu menu, CriarOrcamento criarOrcamento,
			MateriaPrimaDAO materiaPrimaDAO, JScrollPane scrollPaneOrcamento) {
		super();
		this.inicio = inicio;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		this.criarOrcamento = criarOrcamento;
		this.materiaPrimaDAO = materiaPrimaDAO;
		this.scrollPaneOrcamento = scrollPaneOrcamento;
		
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
		criarOrcamento.getBtCalcEdi().setText("Calcular");
		criarOrcamento.getBtConfirmar().setText("Confirmar");
		criarOrcamento.setPreferredSize(new Dimension(1020,970));
		
		List<MateriaPrima> listaMateriasPrimas = this.materiaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
		criarOrcamento.tabModeloEstoque.limpar();
		criarOrcamento.tabModeloOrcam.limpar();
		criarOrcamento.tabModeloEstoque.setLista(listaMateriasPrimas);
	
		limparCamposCriarORC();
		navegadorTelas.navegarTela("CRIAR_ORCAMENTO");
		
		SwingUtilities.invokeLater(() -> {
			scrollPaneOrcamento.getVerticalScrollBar().setValue(0);
		});
		
	}

	public void ativandoDesativandoComp() {
		
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
		criarOrcamento.getLbValorFinalCad().setVisible(false);
		
		criarOrcamento.getInterrogacaoLucroAdicional().setVisible(false);
		criarOrcamento.getInterTotal().setVisible(false);
		criarOrcamento.getInterLT().setVisible(false);
		criarOrcamento.getInterTotal().setVisible(false);

		criarOrcamento.getBtAdicionar().setVisible(true);
		criarOrcamento.getBtRemover().setVisible(true);
		criarOrcamento.getBtConfirmar().setVisible(false);
		criarOrcamento.getBtSalvar().setVisible(true);
		criarOrcamento.getBtCalcEdi().setVisible(true);
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

}