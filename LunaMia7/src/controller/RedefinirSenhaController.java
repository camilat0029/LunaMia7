package controller;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.Mensagem;
import view.RedefinirSenha;

public class RedefinirSenhaController{
	
	private RedefinirSenha redefinirSenha;
	private NavegadorTelas navegadorTelas;
	private UsuarioPerfilDAO usuarioDAO;
	
	public RedefinirSenhaController(RedefinirSenha redefinirSenha, NavegadorTelas navegadorTelas, 
			UsuarioPerfilDAO usuarioDAO) {
		super();
		this.redefinirSenha = redefinirSenha;
		this.navegadorTelas = navegadorTelas;
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

		} else if(!senhaPermitida(new String(redefinirSenha.getPfNovaSenhaRS().getPassword()))){
			Mensagem.mostrar(null, "Inválido", "Senha inválida! \nMínimo 8 caracteres");
			return;
			
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
	
	//VALIDAÇÃO DE SENHA
	public boolean senhaPermitida(String senha) {
		String senhaValida = ".{8,}";
		return senha.matches(senhaValida);
	}
	
	public void limparCamposTelaRedSenha() {
		
		redefinirSenha.getPfNovaSenhaRS().setText("");
		redefinirSenha.getPfConfirmarNovaSenhaRS().setText("");
		
	}

}