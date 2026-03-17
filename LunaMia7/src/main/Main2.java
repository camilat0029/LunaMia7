package main;

import controller.CadastroUsuarioController;
import controller.LoginController;
import controller.Menu;
import controller.NavegadorTelas;
import controller.NavegadorTelas2;
import model.UsuarioPerfilDAO;
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
		UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioPerfilDAO();
		
		//View
		Login login = new Login( menu);
		CadastroUsuario cadastro = new CadastroUsuario( menu);
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
		NavegadorTelas2 navegadorTelas2 = new NavegadorTelas2(telaPrincipal2, login, menu, cadastro);
		
		
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(cadastro, usuarioPerfilDAO, navegadorTelas2, menu);
		LoginController loginController = new LoginController(login, usuarioPerfilDAO, navegadorTelas2, menu);
		
		navegadorTelas2.adicionarPainel("LOGIN", login);
		//navegadorTelas.adicionarPainel("CADASTROPRODUTO", cadastroProduto);
		navegadorTelas2.adicionarPainel("CONFIGURARPERFIL", configurarPerfil);
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
