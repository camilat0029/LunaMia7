package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
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
			navegadorTelas.navegarTela("CONFIGURARPERFIL");
			limparCamposTelaRedSenha();
		});
		
	}
	
	public void novaSenha() {
		
		UsuarioPerfil usuarioLogado = LoginController.usuarioLogado;
		
		if(redefinirSenha.getPfNovaSenhaRS().getText().isEmpty() || redefinirSenha.getPfConfirmarNovaSenhaRS().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!", "Informação", 1);
		} else {
			
			if(redefinirSenha.getPfNovaSenhaRS().getText().equals(redefinirSenha.getPfConfirmarNovaSenhaRS().getText())) {
				
				String novaSenha = redefinirSenha.getPfNovaSenhaRS().getText();
				
				
				
				usuarioDAO.atualizarSenha(usuarioLogado.getNomeUsuario(), usuarioLogado.getEmail(), novaSenha);
				
				JOptionPane.showMessageDialog(null, "Senha Atualizada com Sucesso", "Informação", 1);
				navegadorTelas.navegarTela("CONFIGURARPERFIL");
				
			} else {
				JOptionPane.showMessageDialog(null, "O Campo de Nova Senha e Confirmar \nSenha estão Diferentes!", "Informação", 1);
			}
			
		}
	}
	
	public void limparCamposTelaRedSenha() {
		
		redefinirSenha.getPfNovaSenhaRS().setText("");
		redefinirSenha.getPfConfirmarNovaSenhaRS().setText("");
		
	}

}
