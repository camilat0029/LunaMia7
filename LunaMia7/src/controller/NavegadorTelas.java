
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import view.CadastroUsuario;
import view.Login;
import view.TelaPrincipal;

public class NavegadorTelas {
	
	private TelaPrincipal telaPrincipal2;
	private Login login;
	private Menu menu;
	private CadastroUsuario cadastro;
	private CadastroUsuarioController cadastroController;
	private LoginController loginController;
		
	public NavegadorTelas(TelaPrincipal telaPrincipal2, Login login, Menu menu, 
			CadastroUsuario cadastro) {
		
		this.login = login;
		this.menu = menu;
		this.cadastro = cadastro;
		this.telaPrincipal2 = telaPrincipal2;
		
		this.cadastro.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegarTela("LOGIN");
				cadastroController.limparCamposTelaCadastro();
				menu.mostrarPanelCont();
				menu.removerMenu();
			}
		});
		
		
		this.login.cadastrese(e -> {
			navegarTela("CADASTRO");
			loginController.limparCamposLogin();
			this.menu.removerMenu();
		});
		
	}
	

	public void setCadastroController(CadastroUsuarioController cadastroController) {
		this.cadastroController = cadastroController;
	}

	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}


	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal2.adicionarTela(nome, tela);
	}
	
	public void navegarTela(String nome) {
		this.telaPrincipal2.mostrarTela(nome);
	}
	
}