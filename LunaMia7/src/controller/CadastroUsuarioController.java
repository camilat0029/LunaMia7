package controller;

import model.UsuarioPerfil;
import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.CadastroUsuario;

public class CadastroUsuarioController {

	private CadastroUsuario cadastroUsuario;
	//private UsuarioPerfil novoUsuario;
	private UsuarioPerfilDAO usuarioDAO;
	private NavegadorTelas2 navegadorTelas2;
	private Menu menu;

	public CadastroUsuarioController(CadastroUsuario cadastroUsuario,
			UsuarioPerfilDAO usuarioDAO, NavegadorTelas2 navegadorTelas2, Menu menu) {
		super();
		this.cadastroUsuario = cadastroUsuario;
		this.usuarioDAO = usuarioDAO;
		this.menu = menu;
		this.navegadorTelas2 = navegadorTelas2;

		this.cadastroUsuario.cadastrar(e -> {
			
			UsuarioPerfil novoUsuario = new UsuarioPerfil(null, null, null, null, null, null, 0, 0, null);

			novoUsuario.setNome(cadastroUsuario.getTfNomeUsuario().getText());
			novoUsuario.setNomeUsuario(cadastroUsuario.getTfNomeUsuario().getText());
			novoUsuario.setEmail(cadastroUsuario.getTfEmail().getText());
			novoUsuario.setSenha(cadastroUsuario.getPfSenha().getText());			
			novoUsuario.setTelefone(cadastroUsuario.getTfTelefone().getText());
			
			novoUsuario.setEndereco("");
			novoUsuario.setFotoPerfil(null);
			novoUsuario.setPercentualLucro(0);
			novoUsuario.setPrecoHora(0);
			

			usuarioDAO.adicionarDados(novoUsuario);

			navegadorTelas2.navegarTela("LOGIN");
			menu.mostrarPanelCont();
			
			System.out.println("clique");

		});

	}

}
