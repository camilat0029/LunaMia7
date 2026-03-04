package controller;

import javax.swing.JPanel;

import main.Main2;
import view.Login;
import view.TelaPrincipal;
import view.TelaPrincipal2;

public class NavegadorTelas2 {
	
	private TelaPrincipal2 telaPrincipal2;
	private Login login;
	private Menu menu;
	
	
	
	public NavegadorTelas2(TelaPrincipal2 telaPrincipal2, Login login, Menu menu) {
		
		this.login = login;
		this.menu = menu;
		
		this.telaPrincipal2 = telaPrincipal2;
		
		//Ação botão 
		this.login.getBtEntrarLogin().addActionListener(e -> {
			navegarTela("INICIO");
			this.menu.mostrarPanelCont();
			
		});
		
		this.login.getBtCadastreseLogin().addActionListener(e -> {
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
