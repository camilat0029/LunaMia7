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
import controller.ProdutoEstoqueController;
import controller.RelatoriosController;
import model.OrcamentoDAO;
import model.ProdutoEstoqueDAO;
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
import view.RelatorioGastos;
import view.RelatorioHorasTrabalhadas;
import view.RelatorioLucros;
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
		
		//JFRAME
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		
		
		//MODEL
		
		UsuarioPerfilDAO usuarioPerfilDAO = new UsuarioPerfilDAO();
		//adicionei isso pra depois não esquecer
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		ProdutoEstoqueDAO produtoEstoqueDAO = new ProdutoEstoqueDAO();
		
		//VIEW
		
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
		RelatorioLucros relatorioLucros = new RelatorioLucros();
		RelatorioHorasTrabalhadas relatorioHorasTrabalhadas = new RelatorioHorasTrabalhadas();
		RelatorioGastos relatorioGastos = new RelatorioGastos();
		Orcamentos orcamentos = new Orcamentos();
		
		//CONTROLLER
		
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal);
		Menu menu = new Menu(telaPrincipal, menuExp, menuCont, navegadorTelas);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(cadastro, usuarioPerfilDAO, navegadorTelas, 
				menu, configurarPerfiAposCadastrar, configurarPerfil);
		LoginController loginController = new LoginController(login, usuarioPerfilDAO, navegadorTelas, menu);
		OrcamentoController orcamentoController = new OrcamentoController(orcamentoDAO, telaPrincipal, menu, navegadorTelas, orcamentos);
		InicioController inicioController = new InicioController(inicio, navegadorTelas, menu);
		ProdutoEstoqueController produtoEstoqueController = new ProdutoEstoqueController(produtoEstoque, navegadorTelas, menu, telaPrincipal, produtoEstoqueDAO);
		RelatoriosController relatoriosController = new RelatoriosController(menu, navegadorTelas, relatorios, telaPrincipal, relatorioLucros, orcamentoDAO, relatorioHorasTrabalhadas, relatorioGastos);
				
		configurarPerfiAposCadastrar.adicionarOuvinte(cadastroUsuarioController);
		configurarPerfil.adicionarOuvinte(cadastroUsuarioController);
		
		navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTRO_PRODUTO", cadastroProduto);
		navegadorTelas.adicionarPainel("CONFIGURAR_PERFIL", configurarPerfil);
		navegadorTelas.adicionarPainel("CONFIGURAR_PERFIL_APOS_CASDASTRAR", configurarPerfiAposCadastrar);
		navegadorTelas.adicionarPainel("CRIAR_ORCAMENTO",criarOrcamento );
		navegadorTelas.adicionarPainel("CRIAR_ORCAMENTO_APOS_CALCULAR", criarOrcamentoAposCalcular);
		navegadorTelas.adicionarPainel("CRIAR_ORCAMENTO_COM_FORMA_PAGAMENTO", criarOrcamentoComFormaPagamento);
		navegadorTelas.adicionarPainel("INICIO", inicio);
		navegadorTelas.adicionarPainel("REDEFINIR_SENHA", redefinirSenha);
		navegadorTelas.adicionarPainel("RELATORIOS", relatorios);
		navegadorTelas.adicionarPainel("RELATORIO_LUCROS", relatorioLucros);
		navegadorTelas.adicionarPainel("RELATORIO_HORAS_TRABALHADAS", relatorioHorasTrabalhadas);
		navegadorTelas.adicionarPainel("RELATORIO_GASTOS", relatorioGastos);
		navegadorTelas.adicionarPainel("ORCAMENTOS", orcamentos);
		navegadorTelas.adicionarPainel("PRODUTO_ESTOQUE", produtoEstoque);
		
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		
		//telaPrincipal2.setVisible(true);
		
		navegadorTelas.navegarTela("LOGIN");
		
		
		menu.iniciar();

	}

}
