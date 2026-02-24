package main;

import controller.NavegadorTelas;
import view.CadastroUsuario;
import view.LoginPanel;
import view.TelaPrincipal;

public class Main {

	public static void main(String[] args) {
		
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		NavegadorTelas navegadorTelas = new NavegadorTelas(telaPrincipal);
		
		LoginPanel login = new LoginPanel();
		CadastroUsuario cadastro = new CadastroUsuario();
		
		//navegadorTelas.adicionarPainel("LOGIN", login);
		navegadorTelas.adicionarPainel("CADASTRO", cadastro);
		
		telaPrincipal.setVisible(true);
		
		navegadorTelas.navegarTela("CADASTRO");

	}

}
