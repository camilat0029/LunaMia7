package controller;

import view.BotoesMateriaPrima;
import view.BotoesOrcamento;
import view.TelaPrincipal;


public class BotoesLateralController {

	private BotoesMateriaPrima botoesMateriaPrima;
	private BotoesOrcamento botoesOrcamento;
	private NavegadorTelas navegadorTelas;
	private TelaPrincipal tela;

	public BotoesLateralController(BotoesMateriaPrima botoesMateriaPrima, BotoesOrcamento botoesOrcamento,
			NavegadorTelas navegadorTelas, TelaPrincipal tela) {
		super();
		this.botoesMateriaPrima = botoesMateriaPrima;
		this.botoesOrcamento = botoesOrcamento;
		this.navegadorTelas = navegadorTelas;
		this.tela = tela;

		//BOTÕES MATÉRIA PRIMA
		this.botoesMateriaPrima.visualizar(e -> {
			navegadorTelas.navegarTela("VISUALIZAR_MATERIA_PRIMA");
		});
		
		this.botoesMateriaPrima.editar(e -> {

		});

		this.botoesMateriaPrima.excluir(e -> {

		});

		//BOTÕES ORCAMENTO
		this.botoesOrcamento.visualizar(e -> {
			navegadorTelas.navegarTela("VISUALIZAR_ORCAMENTO");

		});
		this.botoesOrcamento.editar(e -> {

		});
		this.botoesOrcamento.cancelar(e -> {

		});
		this.botoesOrcamento.excluir(e -> {

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
