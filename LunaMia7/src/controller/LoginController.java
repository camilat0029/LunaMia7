package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.Login;

public class LoginController {
	
	
	private Login login;
	private UsuarioPerfilDAO usuarioDAO;
	private UsuarioPerfil usuarioPerfil;
	private NavegadorTelas2 navegadorTelas2;
	private Menu menu;
	
	public LoginController(Login login, UsuarioPerfilDAO usuarioDAO, NavegadorTelas2 navegadorTelas2, Menu menu) {
		super();
		this.login = login;
		this.usuarioDAO = usuarioDAO;
		this.navegadorTelas2 = navegadorTelas2;
		this.menu = menu;
		
		this.login.entrar(e -> {
			verificarCadastroUsuario();
			
		});
	}
	
	public void verificarCadastroUsuario() {
		
		List<UsuarioPerfil> usuarios = usuarioDAO.listarUsuarios();
		
		for (UsuarioPerfil usuarioPerfil : usuarios) {
			
			if(login.getTfUsuarioLogin().getText().isEmpty() || login.getPfSenhaLogin().getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Opa, algum campo está vazio");
				
			}
			else if(usuarioPerfil.getNomeUsuario().equals(login.getTfUsuarioLogin().getText()) && 
					usuarioPerfil.getSenha().equals(login.getPfSenhaLogin().getText())) {
				
				this.navegadorTelas2.navegarTela("INICIO");
				this.menu.mostrarPanelCont();
				
			}
			
		}
	}

}
