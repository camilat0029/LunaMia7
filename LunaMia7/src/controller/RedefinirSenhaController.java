package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.RedefinirSenha;

public class RedefinirSenhaController extends ComponentAdapter{
	
	private RedefinirSenha redefinirSenha;
	private NavegadorTelas navegadorSenha;
	private UsuarioPerfilDAO usuarioDAO;
	private UsuarioPerfil usuarioCadastrado;
	
	public RedefinirSenhaController(RedefinirSenha redefinirSenha, NavegadorTelas navegadorSenha, 
			UsuarioPerfil usuarioCadastrado, UsuarioPerfilDAO usuarioDAO) {
		super();
		this.redefinirSenha = redefinirSenha;
		this.navegadorSenha = navegadorSenha;
		this.usuarioCadastrado = usuarioCadastrado;
		this.usuarioDAO = usuarioDAO;
	}
	
	public void componentShown(ComponentEvent e) {
		this.senhaCadastrada();
	}
	
	public void senhaCadastrada() {
		
		//UsuarioPerfil usuario = usuarioDAO.buscaUsuarioPelaChavePrim(usuarioCadastrado.getNomeUsuario()., null);
	}

}
