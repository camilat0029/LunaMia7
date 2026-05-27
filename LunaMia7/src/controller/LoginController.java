package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.Login;
import view.Mensagem;

public class LoginController {
	
	private Login login;
	public static UsuarioPerfil usuarioLogado;
	private UsuarioPerfilDAO usuarioDAO;
	private NavegadorTelas navegadorTelas;
	private Menu menu;
	private String usuario;
	
	public LoginController(Login login, UsuarioPerfilDAO usuarioDAO, NavegadorTelas navegadorTelas, Menu menu) {
		super();
		this.login = login;
		this.usuarioDAO = usuarioDAO;
		this.navegadorTelas = navegadorTelas;
		this.menu = menu;
		
		this.login.entrar(e -> {
			verificarCadastroUsuario();
			
		});
		
		this.login.cadastrese(e -> {
			navegadorTelas.navegarTela("CADASTRO");
			limparCamposLogin();
			this.menu.removerMenu();
		});
	}
	
	//VERIFICAÇÃO DE USUÁRIO, VE SE JÁ ESTÁ CADASTRADO
	public void verificarCadastroUsuario() {
		
		List<UsuarioPerfil> usuarios = usuarioDAO.listarUsuarios();
		
		
		if(login.getTfUsuarioLogin().getText().isEmpty() || login.getPfSenhaLogin().getText().isEmpty()) {
			
			//AQUI 
			Mensagem.mostrar(
				    null,
				    "Informação",
				    "Opa, algum campo está vazio!"
				);
			// JOptionPane.showMessageDialog(null, "Opa, algum campo está vazio");
			
		}
		else{
			boolean usuarioEncontrado = false; 
			
			for (UsuarioPerfil usuarioPerfil : usuarios) {
				
				if(usuarioPerfil.getNomeUsuario().equals(login.getTfUsuarioLogin().getText()) && 
						usuarioPerfil.getSenha().equals(login.getPfSenhaLogin().getText())) {
					
					 usuarioLogado = usuarioPerfil;
					 usuarioEncontrado = true;
					
					 
					 break;
				}
				
			}
			
			if (usuarioEncontrado) {
				 limparCamposLogin();
				 this.navegadorTelas.navegarTela("INICIO");
				 this.menu.mostrarPanelCont();	
			}else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado! \nVerfique as informações.", "Informação", 1);
			}
			
		}
		
		
	}
	
	public void limparCamposLogin() {
		login.getTfUsuarioLogin().setText("");
		login.getPfSenhaLogin().setText("");
	}
	
	

}