package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

import controller.CadastroUsuarioController;
import controller.LoginController;
import controller.Menu;
import controller.NavegadorTelas;
import model.UsuarioPerfilDAO;
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
import view.MenuContraido;
import view.MenuExpandido;
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
		TelaPrincipal telaPrincipal2 = new TelaPrincipal();
		
		
		//Controller
		UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioPerfilDAO();
		
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
		InicioPosCadastro inicioPosCadastro = new InicioPosCadastro();
		RedefinirSenha redefinirSenha = new RedefinirSenha();
		Relatorios relatorios = new Relatorios();
		MenuContraido menuCont = new MenuContraido();
		MenuExpandido menuExp = new MenuExpandido();

		
		
		
		Menu menu = new Menu(telaPrincipal2, menuExp, menuCont);
		NavegadorTelas navegadorTelas2 = new NavegadorTelas(telaPrincipal2, login, menu, cadastro);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(cadastro, usuarioPerfilDAO, navegadorTelas2, menu);
		LoginController loginController = new LoginController(login, usuarioPerfilDAO, navegadorTelas2, menu);
		
		
		navegadorTelas2.setCadastroController(cadastroUsuarioController);
		navegadorTelas2.setLoginController(loginController);
		
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
