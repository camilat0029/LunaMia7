package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

import controller.BotoesAcoesController;
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
import model.OrcamentoProdutoDAO;
import model.ClienteDAO;
import model.ConfirOrcamDAO;
import model.MateriaPrima;
import model.MateriaPrimaDAO;
import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.CadastroMateriaPrimaEstoque;
import view.CadastroUsuario;
import view.ConfigurarPerfil;
import view.ConfigurarPerfilAposCadastrar;
import view.CriarOrcamento;
import view.Inicio;
import view.Login;
import view.MenuContraido;
import view.MenuExpandido;
import view.Orcamentos;
import view.MateriaPrimaView;
import view.Mensagem;
import view.RedefinirSenha;
import view.RelatorioGastos;
import view.RelatorioHorasTrabalhadas;
import view.RelatorioLucros;
import view.Relatorios;
import view.TelaPrincipal;
import view.VisualizarMateriaPrima;
import view.VisualizarOrcamento;

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
		MateriaPrima materiaPrima = new MateriaPrima(null, null, null, 0, 0, 0, null);
		ClienteDAO clienteDAO = new ClienteDAO();
		ConfirOrcamDAO confirOrcamDAO= new ConfirOrcamDAO();
		OrcamentoProdutoDAO orcamProdDAO = new OrcamentoProdutoDAO();
		
		//VIEW
		Login login = new Login();
		CadastroUsuario cadastro = new CadastroUsuario();
		CadastroMateriaPrimaEstoque cadastroMateriaPrimaEstoque = new CadastroMateriaPrimaEstoque();
		ConfigurarPerfil configurarPerfil = new ConfigurarPerfil();
		ConfigurarPerfilAposCadastrar configurarPerfilAposCadastrar = new ConfigurarPerfilAposCadastrar();
		CriarOrcamento criarOrcamento = new CriarOrcamento();
		Inicio inicio = new Inicio();
		RedefinirSenha redefinirSenha = new RedefinirSenha();
		Relatorios relatorios = new Relatorios();
		MenuContraido menuCont = new MenuContraido();
		MenuExpandido menuExp = new MenuExpandido();
		MateriaPrimaView materiaPrimaView = new MateriaPrimaView();
		RelatorioLucros relatorioLucros = new RelatorioLucros();
		RelatorioHorasTrabalhadas relatorioHorasTrabalhadas = new RelatorioHorasTrabalhadas();
		RelatorioGastos relatorioGastos = new RelatorioGastos();
		Orcamentos orcamentos = new Orcamentos();
		VisualizarMateriaPrima visualizarMateriaPrima = new VisualizarMateriaPrima();
		VisualizarOrcamento visualizarOrcamento = new VisualizarOrcamento();
		
		//AQUII
		Mensagem mensagem = new Mensagem(telaPrincipal, null);
		
		//CONTROLLER
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal);
		Menu menu = new Menu(telaPrincipal, menuExp, menuCont, navegadorTelas, login);
		CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController(cadastro, usuarioPerfilDAO, navegadorTelas, 
				menu, configurarPerfilAposCadastrar, configurarPerfil, redefinirSenha);
		LoginController loginController = new LoginController(login, usuarioPerfilDAO, navegadorTelas, menu);
		OrcamentoController orcamentoController = new OrcamentoController(orcamentoDAO, telaPrincipal, menu, navegadorTelas, orcamentos, criarOrcamento,  
				clienteDAO, materiaPrimaDAO, confirOrcamDAO);
		InicioController inicioController = new InicioController(inicio, navegadorTelas, menu, criarOrcamento, materiaPrimaDAO);
		MateriaPEstoqueController materiaPEstoqueController = new MateriaPEstoqueController(materiaPrimaView, navegadorTelas, menu, telaPrincipal, materiaPrimaDAO);
		RelatoriosController relatoriosController = new RelatoriosController(menu, navegadorTelas, relatorios, telaPrincipal, relatorioLucros, orcamentoDAO, 
				relatorioHorasTrabalhadas, relatorioGastos);
		RedefinirSenhaController redefSenhaController = new RedefinirSenhaController(redefinirSenha, navegadorTelas, usuarioPerfil, usuarioPerfilDAO);
		MateriaPrimaController materiaPrimaController = new MateriaPrimaController(materiaPrima, materiaPrimaDAO, navegadorTelas, menu, cadastroMateriaPrimaEstoque,
				materiaPrimaView);
		BotoesAcoesController botoesLateralController = new BotoesAcoesController( navegadorTelas, telaPrincipal, visualizarOrcamento, visualizarMateriaPrima, menu, 
				materiaPrimaView, cadastroMateriaPrimaEstoque, materiaPrimaDAO, confirOrcamDAO, orcamentos, orcamProdDAO, criarOrcamento, clienteDAO, orcamentoDAO);
		
		JScrollPane scrollPaneOrcamento = new JScrollPane(criarOrcamento, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane scrollPaneVisualizarOrcamento = new JScrollPane(visualizarOrcamento, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane scrollPaneConfigurarPerfil = new JScrollPane(configurarPerfil, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane scrollPaneConfigPerfilAposCad = new JScrollPane(configurarPerfilAposCadastrar, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		

		scrollPaneConfigurarPerfil.addComponentListener(cadastroUsuarioController);
		scrollPaneConfigPerfilAposCad.addComponentListener(cadastroUsuarioController);
		
		materiaPrimaView.adicionarOuvinte(materiaPrimaController);
		
		navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTRO_MATERIA_PRIMA", cadastroMateriaPrimaEstoque);
		navegadorTelas.adicionarPainel("CONFIGURAR_PERFIL", scrollPaneConfigurarPerfil);
		navegadorTelas.adicionarPainel("CONFIGURAR_PERFIL_APOS_CADASTRAR", scrollPaneConfigPerfilAposCad);
		navegadorTelas.adicionarPainel("CRIAR_ORCAMENTO", scrollPaneOrcamento );
		navegadorTelas.adicionarPainel("INICIO", inicio);
		navegadorTelas.adicionarPainel("REDEFINIR_SENHA", redefinirSenha);
		navegadorTelas.adicionarPainel("RELATORIOS", relatorios);
		navegadorTelas.adicionarPainel("RELATORIO_LUCROS", relatorioLucros);
		navegadorTelas.adicionarPainel("RELATORIO_HORAS_TRABALHADAS", relatorioHorasTrabalhadas);
		navegadorTelas.adicionarPainel("RELATORIO_GASTOS", relatorioGastos);
		navegadorTelas.adicionarPainel("ORCAMENTOS", orcamentos);
		navegadorTelas.adicionarPainel("MATERIA_PRIMA", materiaPrimaView);
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		navegadorTelas.adicionarPainel("VISUALIZAR_MATERIA_PRIMA", visualizarMateriaPrima);
		navegadorTelas.adicionarPainel("VISUALIZAR_ORCAMENTO", scrollPaneVisualizarOrcamento);
		
		navegadorTelas.navegarTela("LOGIN");

		menu.iniciar();
		

	}

}
