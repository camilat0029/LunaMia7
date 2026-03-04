package controller;

import javax.swing.JPanel;

import view.Login;
import view.TelaPrincipal;

public class NavegadorTelas {
	
	private TelaPrincipal telaPrincipal;
	private Login login;
	
	
	public NavegadorTelas(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}
	
	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal.adicionarTela(nome, tela);
	}
	
	public void navegarTela(String nome) {
		this.telaPrincipal.mostrarTela(nome);
	}
	
	
	

}
