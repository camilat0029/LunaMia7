package main;

import controller.NavegadorTelas;
import view.CadastrarProdutoEstoque;
import view.CadastroUsuario;
import view.ConfigurarPerfil;
import view.ConfigurarPerfilAposCadastrar;
import view.CriarOrcamento;
import view.CriarOrcamentoAposCalcular;
import view.CriarOrcamentoComFormaPagamento;
import view.Inicio;
import view.InicioPosCadastro;
import view.Login;
import view.RedefinirSenha;
import view.Relatorios;
import view.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal);
		
		//Login login = new Login();
		//CadastroUsuario cadastro = new CadastroUsuario(navegadorTelas2);
		CadastrarProdutoEstoque cadastroProduto = new CadastrarProdutoEstoque();
		ConfigurarPerfil configurarPerfil = new ConfigurarPerfil();
		ConfigurarPerfilAposCadastrar configurarPerfiAposCadastrar = new ConfigurarPerfilAposCadastrar();
		CriarOrcamento criarOrcamento = new CriarOrcamento();
		CriarOrcamentoAposCalcular criarOrcamentoAposCalcular = new CriarOrcamentoAposCalcular();
		CriarOrcamentoComFormaPagamento criarOrcamentoComFormaPagamento = new CriarOrcamentoComFormaPagamento();
		Inicio inicio = new Inicio();
		InicioPosCadastro inicioPosCadastro = new InicioPosCadastro();
		RedefinirSenha redefinirSenha = new RedefinirSenha();
		Relatorios relatorios = new Relatorios();
		
		//navegadorTelas.adicionarPainel("LOGIN", login);
		//navegadorTelas.adicionarPainel("CADASTROPRODUTO", cadastroProduto);
		//navegadorTelas.adicionarPainel("CONFIGURARPERFIL", configurarPerfil);
		//navegadorTelas.adicionarPainel("CONFIGURARPERFILAPOSCASDASTRAR", configuarPerfilAposCadastrar);
		//navegadorTelas.adicionarPainel("CRIARORCAMENTO",criarOrcamento );
		//navegadorTelas.adicionarPainel("CRIARORCAMENTOAPOSCALCULAR", criarOrcamentoAposCalcular);
		//navegadorTelas.adicionarPainel("CRIARORCAMENTOCOMFORMAPAGAMENTO", criarOrcamentoComFormaPagamento);
		navegadorTelas.adicionarPainel("INICIO", inicio);
		//navegadorTelas.adicionarPainel("INICIOPOSCADASTRO", inicioPosCadastro);
		//navegadorTelas.adicionarPainel("REDEFINIRSENHA", redefinirSenha);
		//navegadorTelas.adicionarPainel("RELATORIOS", relatorios);
		
		//navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		
		
		
		telaPrincipal.setVisible(true);
		
		navegadorTelas.navegarTela("INICIO");

	}

}
