package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.BotoesMateriaPrima;
import view.BotoesOrcamento;
import view.TelaPrincipal;
import view.VisualizarMateriaPrima;
import view.VisualizarOrcamento;


public class BotoesLateralController {

	private BotoesMateriaPrima botoesMateriaPrima;
	private BotoesOrcamento botoesOrcamento;
	private NavegadorTelas navegadorTelas;
	private TelaPrincipal tela;
	private VisualizarOrcamento visualizarOrcamento;
	private VisualizarMateriaPrima visualizarMateriaPrima;
	private Menu menu;

	public BotoesLateralController(BotoesMateriaPrima botoesMateriaPrima, BotoesOrcamento botoesOrcamento,
			NavegadorTelas navegadorTelas, TelaPrincipal tela,
			VisualizarOrcamento visualizarOrcamento, VisualizarMateriaPrima visualizarMateriaPrima,
			Menu menu) {
		super();
		this.botoesMateriaPrima = botoesMateriaPrima;
		this.botoesOrcamento = botoesOrcamento;
		this.navegadorTelas = navegadorTelas;
		this.tela = tela;
		this.visualizarOrcamento = visualizarOrcamento;
		this.visualizarMateriaPrima = visualizarMateriaPrima;
		this.menu = menu;

		//BOTÕES MATÉRIA PRIMA
		this.botoesMateriaPrima.visualizar(e -> {
			menu.removerMenu();
			navegadorTelas.navegarTela("VISUALIZAR_MATERIA_PRIMA");
			
		});
		
		this.botoesMateriaPrima.editar(e -> {

		});

		this.botoesMateriaPrima.excluir(e -> {

		});

		//BOTÕES ORCAMENTO
		this.botoesOrcamento.visualizar(e -> {
			menu.removerMenu();
			navegadorTelas.navegarTela("VISUALIZAR_ORCAMENTO");

		});
		this.botoesOrcamento.editar(e -> {

		});
		this.botoesOrcamento.cancelar(e -> {

		});
		this.botoesOrcamento.excluir(e -> {

		});
		
		//VISUALIZAR ORCAMENTO
		this.visualizarOrcamento.voltar(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				menu.removerMenu();
				navegadorTelas.navegarTela("ORCAMENTOS");

			}
		});
		
		//VISUALIZAR MATÉRIA PRIMA
		this.visualizarMateriaPrima.voltar(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				menu.removerMenu();
				navegadorTelas.navegarTela("MATERIA_PRIMA");

			}
		});

	}

	public void mostrarBotoesMateriaPrima() {
		tela.getPanelBotoesMateriaPrima();

	}
	public void mostrarBotoesOrcamento() {
		tela.getPanelBotoesOrcamento();
	}

	public void removerBotoes() {
		tela.getPanelBotoesMateriaPrima().removeAll();
		tela.getPanelBotoesOrcamento().removeAll();
		tela.revalidate();
		tela.repaint();
	}

}
