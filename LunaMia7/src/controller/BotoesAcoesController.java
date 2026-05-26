package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.UsuarioPerfil;
import view.CadastroMateriaPrimaEstoque;
import view.MateriaPrimaView;
import view.TelaPrincipal;
import view.VisualizarMateriaPrima;
import view.VisualizarOrcamento;

public class BotoesAcoesController extends ComponentAdapter{
	
	private NavegadorTelas navegadorTelas;
	private TelaPrincipal tela;
	private VisualizarOrcamento visualizarOrcamento;
	private VisualizarMateriaPrima visualizarMateriaPrima;
	private Menu menu;
	private MateriaPrimaView materiaPrimaView;
	private CadastroMateriaPrimaEstoque cadMateriaPrima;
	private MateriaPrimaDAO materiaPrimaDAO;
	
	private MateriaPrima MpEditada;
	
	public BotoesAcoesController(NavegadorTelas navegadorTelas, TelaPrincipal tela, VisualizarOrcamento visualizarOrcamento,
			VisualizarMateriaPrima visualizarMateriaPrima, Menu menu, MateriaPrimaView materiaPrimaView,
			CadastroMateriaPrimaEstoque cadMateriaPrima, MateriaPrimaDAO materiaPrimaDAO) {
		super();
		this.navegadorTelas = navegadorTelas;
		this.tela = tela;
		this.visualizarOrcamento = visualizarOrcamento;
		this.visualizarMateriaPrima = visualizarMateriaPrima;
		this.menu = menu;
		this.materiaPrimaView = materiaPrimaView;
		this.cadMateriaPrima = cadMateriaPrima;
		this.materiaPrimaDAO = materiaPrimaDAO;
		
		//AÇÃO VOLTAR DA TELA DE VISUALIZAÇÃO DA MATERIA PRIMA
		this.visualizarMateriaPrima.voltar(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				menu.mostrarPanelCont();
				navegadorTelas.navegarTela("MATERIA_PRIMA");

			}
		});
		
		//VISUALIZANDO AS INFORMAÇÕES DA MATERIA PRIMA
		this.materiaPrimaView.visualizar(materiaPrima -> {
			visualizarMP(materiaPrima);
		});
		
		//ATUALIZANDO AS INFORMAÇÕES DA MATERIA PRIMA
		this.materiaPrimaView.atualizar(materiaPrima -> {
			irParaAtualizarMP(materiaPrima);
		});
		
		this.cadMateriaPrima.confirmar(e -> {
			
			if(cadMateriaPrima.getBtConfirmar().getText().equals("Atualizar")) {
				atualizarMP();
				JOptionPane.showMessageDialog(null, "Materia Prima Atualizada com Sucesso", "Informação", 1);
				navegadorTelas.navegarTela("MATERIA_PRIMA");
			}
		});
		
		//EXCLUINDO MATERIA PRIMA
		this.materiaPrimaView.excluir(materiaPrima -> {
			excluirMP(materiaPrima);
		});
		
	}
	
	
	//MÉTODO PARA VISUALIZAR MATERIA PRIMA
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
	
	//MÉTODO PARA IR PARA A TELA DE ATUALIZAR MATERIA PRIMA
	public void irParaAtualizarMP(MateriaPrima MP) {
		
		MpEditada = MP;
		
		cadMateriaPrima.getTfNomeMateriaPrima().setText(MP.getNome());
		cadMateriaPrima.getTfMarca().setText(MP.getMarca());
		cadMateriaPrima.getTfCor().setText(MP.getCor());
		cadMateriaPrima.getTfQtdDisponivel().setText(String.valueOf(MP.getQuantidadeDisponivel()));
		cadMateriaPrima.getTfQtdUnidade().setText(String.valueOf(MP.getQtdPorUnidade()));
		cadMateriaPrima.getCbUnidadeMedida().setSelectedItem(MP.getUnidadeMedida());;
		cadMateriaPrima.getTfValor().setText(String.valueOf(MP.getValor()));
		
		cadMateriaPrima.getBtConfirmar().setText("Atualizar");
		
		navegadorTelas.navegarTela("CADASTRO_MATERIA_PRIMA");
		menu.removerMenu();
	}
	
	//MÉTODO PARA ATUALIZAR MATERIA PRIMA
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
	
	//MÉTODO EXCLUIR MATERIA PRIMA
	public void excluirMP(MateriaPrima MP) {
		
		int linhaSelecionada = materiaPrimaView.getTabelaMateriaPrima().getSelectedRow();
		
		materiaPrimaView.tabelaModeloMateriaPrima.removerMatPrima(linhaSelecionada);
		materiaPrimaDAO.excluirMateriasPrimas(MP);
		
		JOptionPane.showMessageDialog(null, "Materia Prima Excluída com Sucesso", "Informação", 1);
	}
	
	//RECARREGANDO TABELA
	public void carregarTabela() {

		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;

		List<MateriaPrima> lista = MateriaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
		materiaPrimaView.tabelaModeloMateriaPrima.limpar();
		materiaPrimaView.tabelaModeloMateriaPrima.setLista(lista);

	}
	
	public void componentShown(ComponentEvent e) {
		this.carregarTabela();
	}
	
	
	

}
