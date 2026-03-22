package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import view.Login;
import view.MenuContraido2;
import view.MenuExpandido2;
import view.TelaPrincipal2;

public class Menu {
	
	
	private MenuExpandido2 mnExp;
	private MenuContraido2 mnCont;
	private JPanel menuAtual;
	private TelaPrincipal2 tela;
	
	public Menu(TelaPrincipal2 tela, MenuExpandido2 mnExp, MenuContraido2 mnCont) {
		this.tela = tela;
		this.mnExp = mnExp;
		this.mnCont = mnCont;
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
