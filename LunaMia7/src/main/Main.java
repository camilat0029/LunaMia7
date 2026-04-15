package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

import controller.CadastroUsuarioController;
import controller.InicioController;
import controller.LoginController;
import controller.Menu;
import controller.NavegadorTelas;
import controller.OrcamentoController;
import controller.RedefinirSenhaController;
import model.OrcamentoDAO;
import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.CadastrarProdutoEstoque;
import view.CadastroUsuario;
import view.ConfigurarPerfil;
import view.ConfigurarPerfilAposCadastrar;
import view.CriarOrcamento;
import view.CriarOrcamentoAposCalcular;
import view.CriarOrcamentoComFormaPagamento;
import view.Inicio;
import view.Login;
import view.MenuContraido;
import view.MenuExpandido;
import view.Orcamentos;
import view.ProdutoEstoque;
import view.RedefinirSenha;
import view.Relatorios;
import view.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		UIManager.put("ToolTip.background", new Color(0, 0, 0, 0));
        UIManager.put("ToolTip.foreground", Color.GRAY);
        UIManager.put("ToolTip.font", new Font("Bodoni Bk BT", Font.BOLD, 16));
        UIManager.put("ToolTip.border", BorderFactory.createEmptyBorder());
        
        ToolTipManager manager = ToolTipManager.sharedInstance();

        manager.setInitialDelay(100);   // tempo até aparecer (ms)
        manager.setDismissDelay(3000);   // tempo que fica visível (ms)
        manager.setReshowDelay(100);     // tempo para reaparecer rápido
		
		//JFrame
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		
		
		//Model
		UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioPerfilDAO();
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil(null, null, null, null, null, null, 0, 0, null);
		
		//View
		Login login = new Login();
		CadastroUsuario cadastro = new CadastroUsuario();
		CadastrarProdutoEstoque cadastroProduto = new CadastrarProdutoEstoque();
		ConfigurarPerfil configurarPerfil = new ConfigurarPerfil();
		ConfigurarPerfilAposCadastrar configurarPerfiAposCadastrar = new ConfigurarPerfilAposCadastrar();
		CriarOrcamento criarOrcamento = new CriarOrcamento();
		CriarOrcamentoAposCalcular criarOrcamentoAposCalcular = new CriarOrcamentoAposCalcular();
		CriarOrcamentoComFormaPagamento criarOrcamentoComFormaPagamento = new CriarOrcamentoComFormaPagamento();
		Inicio inicio = new Inicio();
		RedefinirSenha redefinirSenha = new RedefinirSenha();
		Relatorios relatorios = new Relatorios();
		MenuContraido menuCont = new MenuContraido();
		MenuExpandido menuExp = new MenuExpandido();
		ProdutoEstoque produtoEstoque = new ProdutoEstoque();
		
		//adicionei isso pra depois não esquecer
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		Orcamentos orcamentos = new Orcamentos();
		
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal);
		
		Menu menu = new Menu(telaPrincipal, menuExp, menuCont, navegadorTelas);
		
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(cadastro, usuarioPerfilDAO, navegadorTelas, 
				menu, configurarPerfiAposCadastrar, configurarPerfil);
		LoginController loginController = new LoginController(login, usuarioPerfilDAO, navegadorTelas, menu);
		
		//adicionei isso já, pra depois não esquecer
		OrcamentoController orcamentoController = new OrcamentoController(orcamentoDAO, telaPrincipal, menu, navegadorTelas, orcamentos);
		InicioController inicioController = new InicioController(inicio, navegadorTelas, menu);
		
		RedefinirSenhaController redefSenhaController = new RedefinirSenhaController(redefinirSenha, navegadorTelas, usuarioPerfil, usuarioPerfilDAO);
				
		configurarPerfiAposCadastrar.adicionarOuvinte(cadastroUsuarioController);
		configurarPerfil.adicionarOuvinte(cadastroUsuarioController);
		redefinirSenha.adicionarOuvinte(redefSenhaController);
		
		
		navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTROPRODUTO", cadastroProduto);
		navegadorTelas.adicionarPainel("CONFIGURARPERFIL", configurarPerfil);
		navegadorTelas.adicionarPainel("CONFIGURARPERFILAPOSCADASTRAR", configurarPerfiAposCadastrar);
		navegadorTelas.adicionarPainel("CRIARORCAMENTO",criarOrcamento );
		//navegadorTelas.adicionarPainel("CRIARORCAMENTOAPOSCALCULAR", criarOrcamentoAposCalcular);
		//navegadorTelas.adicionarPainel("CRIARORCAMENTOCOMFORMAPAGAMENTO", criarOrcamentoComFormaPagamento);
		navegadorTelas.adicionarPainel("INICIO", inicio);
		navegadorTelas.adicionarPainel("REDEFINIRSENHA", redefinirSenha);
		navegadorTelas.adicionarPainel("RELATORIOS", relatorios);
		navegadorTelas.adicionarPainel("ORCAMENTOS", orcamentos);
		navegadorTelas.adicionarPainel("PRODUTO_ESTOQUE", produtoEstoque);
		
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		
		//telaPrincipal2.setVisible(true);
		
		navegadorTelas.navegarTela("LOGIN");
		
		
		menu.iniciar();

	}

}
