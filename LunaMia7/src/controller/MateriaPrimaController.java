package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.MateriaPrimaDAO;
import model.UsuarioPerfil;
import view.CadastroMateriaPrimaEstoque;
import view.MateriaPrimaView;
import view.Mensagem;
import model.MateriaPrima;

public class MateriaPrimaController extends ComponentAdapter {

	private MateriaPrima materiaPrima;
	private MateriaPrimaView materiaPrimaView;
	private MateriaPrimaDAO materiaPrimaDAO;
	private NavegadorTelas navegador;
	private CadastroMateriaPrimaEstoque cadastroMateriaPrima;
	private Menu menu;

	public MateriaPrimaController(MateriaPrima materiaPrima, MateriaPrimaDAO materiaPrimaDAO, NavegadorTelas navegador,
			Menu menu, CadastroMateriaPrimaEstoque cadastroMateriaPrima, MateriaPrimaView materiaPrimaView) {

		this.materiaPrima = materiaPrima;
		this.materiaPrimaDAO = materiaPrimaDAO;
		this.navegador = navegador;
		this.cadastroMateriaPrima = cadastroMateriaPrima;
		this.menu = menu;
		this.materiaPrimaView = materiaPrimaView;
		
		materiaPrimaView.getTabelaMateriaPrima().setModel(materiaPrimaView.tabelaModeloMateriaPrima);		

		this.cadastroMateriaPrima.confirmar(e -> {

			if(cadastroMateriaPrima.getBtConfirmar().getText().equals("Confirmar")) {
				cadastrarMateriaPrima();
			}
			

		});

		this.cadastroMateriaPrima.voltar(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.navegarTela("MATERIA_PRIMA");
				menu.mostrarPanelCont();

			}
		});

		this.materiaPrimaView.adicionar(e -> {
			navegador.navegarTela("CADASTRO_MATERIA_PRIMA");
			cadastroMateriaPrima.getBtConfirmar().setText("Confirmar");
			menu.removerMenu();
		});

	}

	public void cadastrarMateriaPrima() {

		String nome = cadastroMateriaPrima.getTfNomeMateriaPrima().getText();
		String cor = cadastroMateriaPrima.getTfCor().getText();
		String marca = cadastroMateriaPrima.getTfMarca().getText();
		String qtdDisponivelStr = cadastroMateriaPrima.getTfQtdDisponivel().getText();
		String qtdUnidadeStr = cadastroMateriaPrima.getTfQtdUnidade().getText().replace(",", ".");
		String valorStr = cadastroMateriaPrima.getTfValor().getText().replace(",", ".");

		if (nome.isEmpty() || qtdDisponivelStr.isEmpty() || qtdUnidadeStr.isEmpty() || valorStr.isEmpty()) {

			Mensagem.mostrar(null, "Informação", "Você precisa preencher os campos obrigatórios!");
		}

		if (!qtdDisponivelPermitida(qtdDisponivelStr) || !qtdUnidadePermitida(qtdUnidadeStr)
				|| !valorPermitido(valorStr)) {

			Mensagem.mostrar(null, "Inválido", "Valores numéricos inválidos!");
			return;
		}

		try {
			
			UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;

			MateriaPrima novaMateriaPrima = new MateriaPrima(null, null, null, 0, 0, 0, null);

			novaMateriaPrima.setUsuario(usuarioLogado);
			novaMateriaPrima.setNome(nome);
			novaMateriaPrima.setCor(cor);
			novaMateriaPrima.setMarca(marca);

			novaMateriaPrima.setQuantidadeDisponivel(Integer.parseInt(qtdDisponivelStr));
			novaMateriaPrima.setQtdPorUnidade(Float.parseFloat(qtdUnidadeStr));
			novaMateriaPrima.setValor(Float.parseFloat(valorStr));

			novaMateriaPrima.setUnidadeMedida((MateriaPrima.UnidadeMedida) cadastroMateriaPrima.getCbUnidadeMedida().getSelectedItem());

			materiaPrimaDAO.adicionarInsumos(novaMateriaPrima);

			this.materiaPrima = novaMateriaPrima;

			limparCamposMP();
			carregarTabela();

			Mensagem.mostrar(null, "Sucesso", "Matéria Prima cadastrada com sucesso!");

			

		} catch (Exception ex) {
			Mensagem.mostrar(null, "Erro", "Erro ao cadastrar: " + ex.getMessage());

		}
	}

	public void limparCamposMP() {
		cadastroMateriaPrima.getTfNomeMateriaPrima().setText("");
		cadastroMateriaPrima.getTfCor().setText("");
		cadastroMateriaPrima.getTfMarca().setText("");
		cadastroMateriaPrima.getTfQtdDisponivel().setText("");
		cadastroMateriaPrima.getTfQtdUnidade().setText("");
		cadastroMateriaPrima.getTfValor().setText("");
		cadastroMateriaPrima.getCbUnidadeMedida().setSelectedIndex(0);

	}

	public void carregarTabela() {

		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;

		List<MateriaPrima> lista = MateriaPrimaDAO.listarMateriaPrima(usuarioLogado.getEmail());
		materiaPrimaView.tabelaModeloMateriaPrima.limpar();
		materiaPrimaView.tabelaModeloMateriaPrima.setLista(lista);

	}

	public boolean qtdDisponivelPermitida(String qtdDisponivelValida) {
		boolean valido;
		if (!qtdDisponivelValida.matches("\\d+")) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

	public boolean qtdUnidadePermitida(String qtdUnidadeValida) {

		boolean valido;
		if (!qtdUnidadeValida.matches("\\d+(\\.\\d{1,2})?")) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

	public boolean valorPermitido(String valorValido) {
		boolean valido;
		if (!valorValido.matches("\\d+(\\.\\d{1,2})?")) {
			valido = false;
		} else {
			valido = true;
		}
		return valido;
	}

	public void componentShown(ComponentEvent e) {
		this.carregarTabela();
	}

}
