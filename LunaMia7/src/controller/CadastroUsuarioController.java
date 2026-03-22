package controller;

import java.util.List;

import javax.swing.JOptionPane;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.CadastroUsuario;

public class CadastroUsuarioController {

	private CadastroUsuario cadastroUsuario;
	private UsuarioPerfilDAO usuarioDAO;
	private NavegadorTelas2 navegadorTelas2;
	private Menu menu;
	private boolean EmailRepetido;

	public CadastroUsuarioController(CadastroUsuario cadastroUsuario,
			UsuarioPerfilDAO usuarioDAO, NavegadorTelas2 navegadorTelas2, Menu menu) {
		super();
		this.cadastroUsuario = cadastroUsuario;
		this.usuarioDAO = usuarioDAO;
		this.menu = menu;
		this.navegadorTelas2 = navegadorTelas2;

		this.cadastroUsuario.cadastrar(e -> {
			
			UsuarioPerfil novoUsuario = new UsuarioPerfil(null, null, null, null, null, null, 0, 0, null);
			
			
			if(cadastroUsuario.getTfNomeUsuario().getText().isEmpty() ||
					cadastroUsuario.getTfNomeComp().getText().isEmpty() ||
					cadastroUsuario.getTfEmail().getText().isEmpty() ||
					cadastroUsuario.getTfTelefone().getText().isEmpty() ||
					cadastroUsuario.getPfSenha().getText().isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!", "Informação", 1);
				
			} else {
				
				verificarEmail();
				
				if(EmailRepetido == false){
					
					novoUsuario.setNome(cadastroUsuario.getTfNomeComp().getText());
					novoUsuario.setNomeUsuario(cadastroUsuario.getTfNomeUsuario().getText());
					novoUsuario.setEmail(cadastroUsuario.getTfEmail().getText());
					novoUsuario.setSenha(cadastroUsuario.getPfSenha().getText());			
					novoUsuario.setTelefone(cadastroUsuario.getTfTelefone().getText());
					
					novoUsuario.setEndereco("");
					novoUsuario.setFotoPerfil(null);
					novoUsuario.setPercentualLucro(0);
					novoUsuario.setPrecoHora(0);
					

					usuarioDAO.adicionarDados(novoUsuario);
					
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Informação", 1);

					navegadorTelas2.navegarTela("LOGIN");
					limparCamposTelaCadastro();
					
				}else {
					JOptionPane.showMessageDialog(null, "Este Email já Existe!! Informe outro.", "Informação", 1);
				}
			}
			
			System.out.println("clique");

		});
	}
	
	public void limparCamposTelaCadastro() {
		cadastroUsuario.getTfNomeComp().setText("");
		cadastroUsuario.getTfNomeUsuario().setText("");
		cadastroUsuario.getTfEmail().setText("");
		cadastroUsuario.getTfTelefone().setText("");
		cadastroUsuario.getPfSenha().setText("");
	}
	
	public void verificarEmail() {
		List<UsuarioPerfil> usuarios = usuarioDAO.listarUsuarios();
		
		EmailRepetido = false;
		
		for (UsuarioPerfil usuarioPerfil : usuarios) {
			
			if(usuarioPerfil.getEmail().equals(cadastroUsuario.getTfEmail().getText())) {
				EmailRepetido = true;
				break;
			}
		}
	}
	
}
