
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import main.Main2;
import view.CadastroUsuario;
import view.Login;
import view.TelaPrincipal;
import view.TelaPrincipal2;

public class NavegadorTelas2 {
	
	private TelaPrincipal2 telaPrincipal2;
	private Login login;
	private Menu menu;
	private CadastroUsuario cadastro;
		
	public NavegadorTelas2(TelaPrincipal2 telaPrincipal2, Login login, Menu menu, CadastroUsuario cadastro) {
		
		this.login = login;
		this.menu = menu;
		this.cadastro = cadastro;
		this.telaPrincipal2 = telaPrincipal2;
		
		//Ação botão 
		//MUDEI AQUI
		this.cadastro.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegarTela("LOGIN");
				menu.mostrarPanelCont();
				menu.removerMenu();
			}
		});
		
		
		this.login.cadastrese(e -> {
			navegarTela("CADASTRO");
			this.menu.removerMenu();
		});
		
		
	
	}
	
	
			
	
	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal2.adicionarTela(nome, tela);
	}
	
	public void navegarTela(String nome) {
		this.telaPrincipal2.mostrarTela(nome);
	}
	
}