package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JOptionPane;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.CadastroUsuario;
import view.ConfigurarPerfilAposCadastrar;

public class CadastroUsuarioController extends ComponentAdapter{

	private CadastroUsuario cadastroUsuario;
	private UsuarioPerfilDAO usuarioDAO;
	private NavegadorTelas navegadorTelas2;
	private Menu menu;
	private ConfigurarPerfilAposCadastrar confPerfilAposCad;
	private UsuarioPerfil usuarioCadastrado;
	private boolean EmailRepetido;
	private boolean UsuarioRepetido;

	public CadastroUsuarioController(CadastroUsuario cadastroUsuario,
			UsuarioPerfilDAO usuarioDAO, NavegadorTelas navegadorTelas2, Menu menu, 
			ConfigurarPerfilAposCadastrar confPerfilAposCad) {
		super();
		this.cadastroUsuario = cadastroUsuario;
		this.usuarioDAO = usuarioDAO;
		this.menu = menu;
		this.navegadorTelas2 = navegadorTelas2;
		this.confPerfilAposCad = confPerfilAposCad;

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
				verificarUsuarioPerfil();
				
				if(EmailRepetido == false && UsuarioRepetido == false){
					
					novoUsuario.setNome(cadastroUsuario.getTfNomeComp().getText());
					novoUsuario.setNomeUsuario(cadastroUsuario.getTfNomeUsuario().getText());
					novoUsuario.setEmail(cadastroUsuario.getTfEmail().getText());
					novoUsuario.setSenha(cadastroUsuario.getPfSenha().getText());			
					novoUsuario.setTelefone(cadastroUsuario.getTfTelefone().getText());
					
					novoUsuario.setEndereco("");
					novoUsuario.setFotoPerfil("");
					novoUsuario.setPercentualLucro(0);
					novoUsuario.setPrecoHora(0);

					usuarioDAO.adicionarDados(novoUsuario);
					this.usuarioCadastrado = novoUsuario;
					
					JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Informação", 1);

					navegadorTelas2.navegarTela("CONFIGURARPERFILAPOSCASDASTRAR");
					limparCamposTelaCadastro();
					
				}else if (EmailRepetido == true && UsuarioRepetido == true){
					JOptionPane.showMessageDialog(null, "Este Email e Usuário já Existem!! Informe outros.", "Informação", 1);
				} else if(EmailRepetido == true && UsuarioRepetido == false) {
					JOptionPane.showMessageDialog(null, "Este Email já Existe!! Informe outro.", "Informação", 1);
				} else if(EmailRepetido == false && UsuarioRepetido == true) {
					JOptionPane.showMessageDialog(null, "Este Usuário já Existe!! Informe outro.", "Informação", 1);
				} 
			}
			
			System.out.println("clique");

		});
		
		this.confPerfilAposCad.salvarCadCompleto(e -> {
			
			atualizarCadastro();
			JOptionPane.showMessageDialog(null, "Cadastro Atualizado com Sucesso", "Informação", 1);
			
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
	
	public void verificarUsuarioPerfil() {
		
		List<UsuarioPerfil> usuarios = usuarioDAO.listarUsuarios();
		
		UsuarioRepetido = false;
		
		for (UsuarioPerfil usuarioPerfil : usuarios) {
			
			if(usuarioPerfil.getNomeUsuario().equals(cadastroUsuario.getTfNomeUsuario().getText())) {
				UsuarioRepetido = true;
				break;
			}
		}
	}
	
	public void atualizarCadastro() {
		 
		UsuarioPerfil usuarioAtualizado = new UsuarioPerfil(null, null, null, null, null, null, 0, 0, null);
		
		usuarioAtualizado.setFotoPerfil(null);
		usuarioAtualizado.setSenha(confPerfilAposCad.getPfSenhaCP().getText());
		usuarioAtualizado.setTelefone(confPerfilAposCad.getTfTelefoneCP().getText());
		usuarioAtualizado.setNome(confPerfilAposCad.getTfNomeCompCP().getText());
		usuarioAtualizado.setPrecoHora(Float.parseFloat(confPerfilAposCad.getTfPrecoHoraCP().getText()));
		usuarioAtualizado.setEndereco(confPerfilAposCad.getTfEnderecoCP().getText() + ", " + 
				confPerfilAposCad.getCbBairro().getSelectedItem() + "-" + 
				confPerfilAposCad.getCbCidade().getSelectedItem() + "/" +
				confPerfilAposCad.getCbEstadoCP().getSelectedItem());
		usuarioAtualizado.setPercentualLucro(Float.parseFloat(confPerfilAposCad.getTfPercLucroCP().getText()));
		usuarioAtualizado.setNomeUsuario(confPerfilAposCad.getLbNomeUsuarioCad().getText());
		usuarioAtualizado.setEmail(confPerfilAposCad.getLbEmailCad().getText());
		
	
		usuarioDAO.atualizarUsuario(usuarioAtualizado);
		
		
	}
	
	public void componentShown(ComponentEvent e) {
		this.informacoesJaCadastradas();
	}
	
	
	public void informacoesJaCadastradas() {
		confPerfilAposCad.getTfNomeCompCP().setText(usuarioCadastrado.getNome());
		confPerfilAposCad.getLbNomeUsuarioCad().setText(usuarioCadastrado.getNomeUsuario());
		confPerfilAposCad.getLbEmailCad().setText(usuarioCadastrado.getEmail());
		confPerfilAposCad.getTfTelefoneCP().setText(usuarioCadastrado.getTelefone());
		confPerfilAposCad.getPfSenhaCP().setText(usuarioCadastrado.getSenha());
	}
	
	
}
