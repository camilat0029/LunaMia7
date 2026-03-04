package controller;

import javax.swing.JPanel;

import view.TelaPrincipal;
import view.TelaPrincipal2;

public class NavegadorTelas2 {
	
	private TelaPrincipal2 telaPrincipal2;
	
	public NavegadorTelas2(TelaPrincipal2 telaPrincipal2) {
		this.telaPrincipal2 = telaPrincipal2;
	}
	
	public void adicionarPainel(String nome, JPanel tela) {
		this.telaPrincipal2.adicionarTela(nome, tela);
	}
	
	public void navegarTela(String nome) {
		this.telaPrincipal2.mostrarTela(nome);
	}

}
