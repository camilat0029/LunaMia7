package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import view.MenuContraido;
import view.MenuExpandido;
import view.TelaPrincipal;

public class Menu {
	
	
	private MenuExpandido mnExp;
	private MenuContraido mnCont;
	private JPanel menuAtual;
	private TelaPrincipal tela;
	private NavegadorTelas navegadorTelas;
	
	public Menu(TelaPrincipal tela, MenuExpandido mnExp, MenuContraido mnCont, NavegadorTelas navegadorTelas) {
		this.tela = tela;
		this.mnExp = mnExp;
		this.mnCont = mnCont;
		this.navegadorTelas = navegadorTelas;
		menuAtual = mnCont;
		
		tela.mudarMenu(menuAtual);
		
		this.mnExp.mostrarMenuContraido(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarPanelCont();
			}
		});
		
		this.mnCont.mostrarMenuExpandido(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarPanelExp();
			}
			
		});
		
		this.mnExp.perfil(e ->{
			navegadorTelas.navegarTela("CONFIGURARPERFIL");
			removerMenu();
		});
		this.mnExp.estoque(e -> {
			navegadorTelas.navegarTela("PRODUTO_ESTOQUE");
		});
		this.mnExp.inicio(e -> {
			navegadorTelas.navegarTela("INICIO");
		});
		this.mnExp.orcamentos(e ->{
			navegadorTelas.navegarTela("ORCAMENTOS");
		});
		this.mnExp.relatorios(e ->{
			navegadorTelas.navegarTela("RELATORIOS");
		});
	
	}
	
	 
	
	public void mostrarPanelCont() {
		menuAtual = mnCont;
		tela.mudarMenu(menuAtual);
	}
	
	public void mostrarPanelExp() {
		menuAtual = mnExp;
		tela.mudarMenu(menuAtual);
	}
	
	public void removerMenu() {
		tela.getPanelMenu().removeAll();
		tela.revalidate();  
        tela.repaint(); 
	}
	
	
	public void iniciar() {
		if(tela.getPanelAtual().equals("LOGIN") || tela.getPanelAtual().equals("CADASTRO")) {
			removerMenu();
            tela.setVisible(true);
		} else {
			tela.setVisible(true);
			menuAtual = mnCont;
			tela.mudarMenu(menuAtual);
		}
	}

}
