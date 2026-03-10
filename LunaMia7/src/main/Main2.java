package main;

import controller.Menu;
import controller.NavegadorTelas;
import controller.NavegadorTelas2;
import view.CadastrarProdutoEstoque;
import view.CadastroUsuario;
import view.ConfigurarPerfil;
import view.ConfigurarPerfilAposCadastrar;
import view.ControllerTeste;
import view.CriarOrcamento;
import view.CriarOrcamentoAposCalcular;
import view.CriarOrcamentoComFormaPagamento;
import view.Inicio;
import view.InicioPosCadastro;
import view.Login;
import view.RedefinirSenha;
import view.Relatorios;
import view.TelaPrincipal;
import view.TelaPrincipal2;

public class Main2 {

	public static void main(String[] args) {
		
		//this.main2 = main2;
		
		//JFrame
		TelaPrincipal2 telaPrincipal2 = new TelaPrincipal2();
		
		
		//Controller
		;
		Menu menu = new Menu(telaPrincipal2);
		
		//View
		Login login = new Login( menu);
		NavegadorTelas2 navegadorTelas2 = new NavegadorTelas2(telaPrincipal2, login, menu, null);
		CadastroUsuario cadastro = new CadastroUsuario(navegadorTelas2, menu);
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
		
		navegadorTelas2.adicionarPainel("LOGIN", login);
		//navegadorTelas.adicionarPainel("CADASTROPRODUTO", cadastroProduto);
		//navegadorTelas.adicionarPainel("CONFIGURARPERFIL", configurarPerfil);
		//navegadorTelas.adicionarPainel("CONFIGURARPERFILAPOSCASDASTRAR", configuarPerfilAposCadastrar);
		//navegadorTelas.adicionarPainel("CRIARORCAMENTO",criarOrcamento );
		//navegadorTelas.adicionarPainel("CRIARORCAMENTOAPOSCALCULAR", criarOrcamentoAposCalcular);
		//navegadorTelas.adicionarPainel("CRIARORCAMENTOCOMFORMAPAGAMENTO", criarOrcamentoComFormaPagamento);
		navegadorTelas2.adicionarPainel("INICIO", inicio);
		//navegadorTelas.adicionarPainel("INICIOPOSCADASTRO", inicioPosCadastro);
		//navegadorTelas.adicionarPainel("REDEFINIRSENHA", redefinirSenha);
		//navegadorTelas.adicionarPainel("RELATORIOS", relatorios);
		
		
		
		
		navegadorTelas2.adicionarPainel("CADASTRO", cadastro);
		
		
		
		//telaPrincipal2.setVisible(true);
		
		navegadorTelas2.navegarTela("LOGIN");
		
		
		menu.iniciar();

	}

}
