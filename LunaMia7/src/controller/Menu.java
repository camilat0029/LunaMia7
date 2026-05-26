package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
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
			navegadorTelas.navegarTela("CONFIGURAR_PERFIL");
			removerMenu();
		});
		this.mnExp.estoque(e -> {
			mostrarPanelCont();
			navegadorTelas.navegarTela("MATERIA_PRIMA");
		});
		this.mnExp.inicio(e -> {
			navegadorTelas.navegarTela("INICIO");
		});
		this.mnExp.orcamentos(e ->{
			mostrarPanelCont();
			navegadorTelas.navegarTela("ORCAMENTOS");
		});
		this.mnExp.relatorios(e ->{
			navegadorTelas.navegarTela("RELATORIOS");
		});
		
		this.mnExp.sair(e -> {
		    int confirm = JOptionPane.showConfirmDialog(
		        tela,
		        "Deseja sair da conta?",
		        "Sair",
		        JOptionPane.YES_NO_OPTION
		    );
		    if (confirm == JOptionPane.YES_OPTION) {
		        LoginController.usuarioLogado = null;
		        removerMenu();
		        navegadorTelas.navegarTela("LOGIN");
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
