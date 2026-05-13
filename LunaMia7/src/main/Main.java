package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

import controller.CadastroUsuarioController;
import controller.InicioController;
import controller.LoginController;
import controller.MateriaPEstoqueController;
import controller.MateriaPrimaController;
import controller.Menu;
import controller.NavegadorTelas;
import controller.OrcamentoController;
import controller.RedefinirSenhaController;
import controller.RelatoriosController;
import model.OrcamentoDAO;
import model.ClienteDAO;
import model.MateriaPrimaDAO;
import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.CadastroMateriaPrimaEstoque;
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
import view.MateriaPrima;
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
		UsuarioPerfil usuarioPerfil = new UsuarioPerfil(null, null, null, null, null, null, null, 0, 0, null);
		OrcamentoDAO orcamentoDAO = new OrcamentoDAO();
		MateriaPrimaDAO materiaPrimaDAO = new MateriaPrimaDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		
		//VIEW
		Login login = new Login();
		CadastroUsuario cadastro = new CadastroUsuario();
		CadastroMateriaPrimaEstoque cadastroMateriaPrimaEstoque = new CadastroMateriaPrimaEstoque();
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
		MateriaPrima materiaPrima = new MateriaPrima();
		RelatorioLucros relatorioLucros = new RelatorioLucros();
		RelatorioHorasTrabalhadas relatorioHorasTrabalhadas = new RelatorioHorasTrabalhadas();
		RelatorioGastos relatorioGastos = new RelatorioGastos();
		Orcamentos orcamentos = new Orcamentos();
		
		//CONTROLLER
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal);
		Menu menu = new Menu(telaPrincipal, menuExp, menuCont, navegadorTelas);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(cadastro, usuarioPerfilDAO, navegadorTelas, 
				menu, configurarPerfiAposCadastrar, configurarPerfil, redefinirSenha);
		LoginController loginController = new LoginController(login, usuarioPerfilDAO, navegadorTelas, menu);
		OrcamentoController orcamentoController = new OrcamentoController(orcamentoDAO, telaPrincipal, menu, navegadorTelas, orcamentos, 
				criarOrcamento, clienteDAO, materiaPrimaDAO);
		InicioController inicioController = new InicioController(inicio, navegadorTelas, menu, criarOrcamento, materiaPrimaDAO);
		MateriaPEstoqueController materiaPEstoqueController = new MateriaPEstoqueController(materiaPrima, navegadorTelas, menu, telaPrincipal, materiaPrimaDAO);
		RelatoriosController relatoriosController = new RelatoriosController(menu, navegadorTelas, relatorios, telaPrincipal, relatorioLucros, orcamentoDAO, relatorioHorasTrabalhadas, relatorioGastos);
		RedefinirSenhaController redefSenhaController = new RedefinirSenhaController(redefinirSenha, navegadorTelas, usuarioPerfil, usuarioPerfilDAO);
		MateriaPrimaController materiaPrimaController = new MateriaPrimaController();
		
		JScrollPane scrollpaneOrcamento = new JScrollPane(criarOrcamento, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		configurarPerfiAposCadastrar.adicionarOuvinte(cadastroUsuarioController);
		configurarPerfil.adicionarOuvinte(cadastroUsuarioController);
		
		navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTRO_MATERIA_PRIMA", cadastroMateriaPrimaEstoque);
		navegadorTelas.adicionarPainel("CONFIGURAR_PERFIL", configurarPerfil);
		navegadorTelas.adicionarPainel("CONFIGURAR_PERFIL_APOS_CADASTRAR", configurarPerfiAposCadastrar);
		navegadorTelas.adicionarPainel("CRIAR_ORCAMENTO", scrollpaneOrcamento);
		navegadorTelas.adicionarPainel("CRIAR_ORCAMENTO_APOS_CALCULAR", criarOrcamentoAposCalcular);
		navegadorTelas.adicionarPainel("CRIAR_ORCAMENTO_COM_FORMA_PAGAMENTO", criarOrcamentoComFormaPagamento);
		navegadorTelas.adicionarPainel("INICIO", inicio);
		navegadorTelas.adicionarPainel("REDEFINIR_SENHA", redefinirSenha);
		navegadorTelas.adicionarPainel("RELATORIOS", relatorios);
		navegadorTelas.adicionarPainel("RELATORIO_LUCROS", relatorioLucros);
		navegadorTelas.adicionarPainel("RELATORIO_HORAS_TRABALHADAS", relatorioHorasTrabalhadas);
		navegadorTelas.adicionarPainel("RELATORIO_GASTOS", relatorioGastos);
		navegadorTelas.adicionarPainel("ORCAMENTOS", orcamentos);
		navegadorTelas.adicionarPainel("MATERIA_PRIMA", materiaPrima);
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		
		navegadorTelas.navegarTela("LOGIN");

		menu.iniciar();

	}

}
