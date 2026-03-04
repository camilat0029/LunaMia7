package controller;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import view.MenuContraido2;
import view.MenuExpandido2;
import view.TelaPrincipal;
import view.TelaPrincipal2;
import view.Teste;

public class Menu {
	
	
	private MenuExpandido2 mnExp;
	private MenuContraido2 mnCont;
	private JPanel menuAtual;
	private TelaPrincipal2 tela;
	
	public Menu(TelaPrincipal2 tela) {
		this.tela = tela;
		mnExp = new MenuExpandido2(this);
		mnCont = new MenuContraido2(this);
		menuAtual = mnCont;
		//tela.getContentPane().add(menuAtual, BorderLayout.WEST);
		
		tela.mudarMenu(menuAtual);
	}
	
	public void mostrarPanelCont() {
		menuAtual = mnCont;
		tela.mudarMenu(menuAtual);
		//tela.getContentPane().remove(menuAtual);
		//tela.getContentPane().add(mnExp, BorderLayout.WEST);
		//menuAtual = mnExp;
		//tela.getContentPane().revalidate();
		//tela.getContentPane().repaint();
	}
	
	public void mostrarPanelExp() {
		menuAtual = mnExp;
		tela.mudarMenu(menuAtual);
		//tela.getContentPane().remove(menuAtual);
		//tela.getContentPane().add(mnCont, BorderLayout.WEST);
		//menuAtual = mnCont;
		tela.getContentPane().revalidate();
		tela.getContentPane().repaint();
	}
	
	public void iniciar() {
		tela.setVisible(true);
	}
	
	//public void cont() {
	//	tela.mostrarPainelCont();
	//}
	
	//public void exp() {
	//	tela.mostrarPainelExp();
	//}
	

}
