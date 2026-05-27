package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.Mensagem;
import view.RedefinirSenha;

public class RedefinirSenhaController{
	
	private RedefinirSenha redefinirSenha;
	private NavegadorTelas navegadorTelas;
	private UsuarioPerfilDAO usuarioDAO;
	private UsuarioPerfil usuarioCadastrado;
	
	public RedefinirSenhaController(RedefinirSenha redefinirSenha, NavegadorTelas navegadorTelas, 
			UsuarioPerfil usuarioCadastrado, UsuarioPerfilDAO usuarioDAO) {
		super();
		this.redefinirSenha = redefinirSenha;
		this.navegadorTelas = navegadorTelas;
		this.usuarioCadastrado = usuarioCadastrado;
		this.usuarioDAO = usuarioDAO;
		
		
		this.redefinirSenha.confirmar(e -> {
			novaSenha();
		});
		
		this.redefinirSenha.cancelar(e -> {
			navegadorTelas.navegarTela("CONFIGURAR_PERFIL");
			limparCamposTelaRedSenha();
		});
		
	}
	
	public void novaSenha() {
		
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;
		
		if(redefinirSenha.getPfNovaSenhaRS().getText().isEmpty() || redefinirSenha.getPfConfirmarNovaSenhaRS().getText().isEmpty()) {
			
			Mensagem.mostrar(null, "Informação",  "Preencha todos os campos!");

		} else {
			
			if(redefinirSenha.getPfNovaSenhaRS().getText().equals(redefinirSenha.getPfConfirmarNovaSenhaRS().getText())) {
				
				String novaSenha = redefinirSenha.getPfNovaSenhaRS().getText();
				
				
				
				usuarioDAO.atualizarSenha(usuarioLogado.getNomeUsuario(), usuarioLogado.getEmail(), novaSenha);
				
				Mensagem.mostrar(null, "Sucesso",  "Senha atualizada com sucesso!");

				navegadorTelas.navegarTela("CONFIGURAR_PERFIL");
				
			} else {
				
				Mensagem.mostrar(null, "Sucesso",  "O Campo de Nova Senha e Confirmar \nSenha estão Diferentes!");

			}
			
		}
	}
	
	public void limparCamposTelaRedSenha() {
		
		redefinirSenha.getPfNovaSenhaRS().setText("");
		redefinirSenha.getPfConfirmarNovaSenhaRS().setText("");
		
	}

}