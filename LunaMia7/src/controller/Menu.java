package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.Login;
import view.MensagemSimNao;
import view.MenuContraido;
import view.MenuExpandido;
import view.TelaPrincipal;

public class Menu {

	private MenuExpandido mnExp;
	private MenuContraido mnCont;
	private JPanel menuAtual;
	private TelaPrincipal tela;
	private NavegadorTelas navegadorTelas;
	private Login login;

	public Menu(TelaPrincipal tela, MenuExpandido mnExp, MenuContraido mnCont, NavegadorTelas navegadorTelas,
			Login login) {
		this.tela = tela;
		this.mnExp = mnExp;
		this.mnCont = mnCont;
		this.navegadorTelas = navegadorTelas;
		this.login = login;
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

		this.mnExp.perfil(e -> {
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
		this.mnExp.orcamentos(e -> {
			mostrarPanelCont();
			navegadorTelas.navegarTela("ORCAMENTOS");
		});
		this.mnExp.relatorios(e -> {
			navegadorTelas.navegarTela("RELATORIOS");
		});

		this.mnExp.sair(e -> {

			int confirm = MensagemSimNao.mostrar(tela, "Sair da Conta", "Deseja sair da conta?");

			if (confirm == JOptionPane.YES_OPTION) {

				LoginController.usuarioLogado = null;

				removerMenu();

				navegadorTelas.navegarTela("LOGIN");
			}
		});

		if (LoginController.usuarioLogado != null) {
			mnExp.setNomeUsuario(LoginController.usuarioLogado.getNomeUsuario());
		}

		if (LoginController.usuarioLogado != null) {

			mnExp.setNomeUsuario(LoginController.usuarioLogado.getNomeUsuario());

			String foto = LoginController.usuarioLogado.getFotoPerfil();
			if (foto != null && !foto.isEmpty()) {
				mnExp.setImagemPerfil(foto);

			}
		}

	}

	public void mostrarPanelCont() {
		menuAtual = mnCont;
		tela.mudarMenu(menuAtual);
	}

	public void mostrarPanelExp() {
		menuAtual = mnExp;
		tela.mudarMenu(menuAtual);

		if (LoginController.usuarioLogado != null) {
			mnExp.setNomeUsuario(LoginController.usuarioLogado.getNomeUsuario());
		}
		String foto = LoginController.usuarioLogado.getFotoPerfil();
		if (foto != null && !foto.isEmpty()) {
			mnExp.setImagemPerfil(foto);
		}
	}

	public void removerMenu() {
		tela.getPanelMenu().removeAll();
		tela.revalidate();
		tela.repaint();
	}

	public void iniciar() {
		if (tela.getPanelAtual().equals("LOGIN") || tela.getPanelAtual().equals("CADASTRO")) {
			removerMenu();
			tela.setVisible(true);
		} else {
			tela.setVisible(true);
			menuAtual = mnCont;
			tela.mudarMenu(menuAtual);
		}
	}

}
