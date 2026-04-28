package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;
import view.CadastroUsuario;
import view.ConfigurarPerfil;
import view.ConfigurarPerfilAposCadastrar;

public class CadastroUsuarioController extends ComponentAdapter{

	private CadastroUsuario cadastroUsuario;
	private UsuarioPerfilDAO usuarioDAO;
	private NavegadorTelas navegadorTelas2;
	private Menu menu;
	private ConfigurarPerfilAposCadastrar confPerfilAposCad;
	private ConfigurarPerfil confPerfil;
	private UsuarioPerfil usuarioCadastrado;
	private boolean EmailRepetido;
	private boolean UsuarioRepetido;

	public CadastroUsuarioController( CadastroUsuario cadastroUsuario,
			UsuarioPerfilDAO usuarioDAO, NavegadorTelas navegadorTelas, Menu menu, 
			ConfigurarPerfilAposCadastrar confPerfilAposCad, ConfigurarPerfil confPerfil ) {
		super();
		this.cadastroUsuario = cadastroUsuario;
		this.usuarioDAO = usuarioDAO;
		this.menu = menu;
		this.navegadorTelas2 = navegadorTelas;
		this.confPerfilAposCad = confPerfilAposCad;
		this.confPerfil = confPerfil;

		this.cadastroUsuario.voltar(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				navegadorTelas.navegarTela("LOGIN");
				limparCamposTelaCadastro();
				menu.mostrarPanelCont();
				menu.removerMenu();
			}
		});
		
		this.cadastroUsuario.cadastrar(e -> {
			
			cadastrarUsuario();
			System.out.println("clique");

		});
		
		this.confPerfilAposCad.salvarCadCompleto(e -> {
			
			atualizarCadTelaConfPerfilPosCad();
			
		});
		
		this.confPerfilAposCad.ignorar(e -> {
			navegadorTelas.navegarTela("LOGIN");
		});
		
		this.confPerfilAposCad.redefinirSenha(e -> {
			navegadorTelas.navegarTela("REDEFINIR_SENHA");
		});
		
		this.confPerfil.salvar(e -> {
			atualizarCadTelaConfPerfilCad();
		});
		
		//MUDANÇASSSSS
		
		adicionarEstado();
		
		this.confPerfil.getCbEstado().addActionListener(e -> {
		    String estadoSelecionado = (String) confPerfil.getCbEstado().getSelectedItem();
		    if (estadoSelecionado != null) {
		        pesquisarCidades(estadoSelecionado);
		    }
		});
		
	    String primeiroEstado = (String) confPerfil.getCbEstado().getSelectedItem();
	    if (primeiroEstado != null) {
	        pesquisarCidades(primeiroEstado);
	    }

	}
	
	//PREENCHE O COMBOBOX DOS ESTADOS
	public void adicionarEstado() {
	    
	    List<String> lista = usuarioDAO.listarEstados(); 
	    
	    confPerfil.getCbEstado(); 
	    
	    for (String estado : lista) {
	        confPerfil.getCbEstado().addItem(estado);
	    }
	}
	
	//PREENCHE COMBOBOX DAS CIDADES
	public void pesquisarCidades(String estado) {
	    
	    List<String> cidades = usuarioDAO.listarCidades(estado);
	    
	    confPerfil.getCbCidade().removeAllItems();
	    if (cidades != null) {
	        for (String cidade : cidades) {
	            confPerfil.getCbCidade().addItem(cidade);
	        }
	    }
	}

	//LIMPAR CAMPOS TELA DE CADASTRO
	public void limparCamposTelaCadastro() {
		cadastroUsuario.getTfNomeComp().setText("");
		cadastroUsuario.getTfNomeUsuario().setText("");
		cadastroUsuario.getTfEmail().setText("");
		cadastroUsuario.getTfTelefone().setText("");
		cadastroUsuario.getPfSenha().setText("");
		
	}
	
	//CADASTRO DE USUARIO - TELA CADASTRO
	public void cadastrarUsuario() {	
		
		if(cadastroUsuario.getTfNomeUsuario().getText().isEmpty() ||
				cadastroUsuario.getTfNomeComp().getText().isEmpty() ||
				cadastroUsuario.getTfEmail().getText().isEmpty() ||
				cadastroUsuario.getTfTelefone().getText().isEmpty() ||
				cadastroUsuario.getPfSenha().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Preencha Todos os Campos!", "Informação", 1);
			
		} else {
			
			verificarEmail();
			verificarUsuarioPerfil();
			
			if(EmailRepetido == false && UsuarioRepetido == false){
				
				UsuarioPerfil novoUsuario = new UsuarioPerfil(null, null, null, null, null, null, null, 0, 0, null);
				
				novoUsuario.setNome(cadastroUsuario.getTfNomeComp().getText());
				novoUsuario.setNomeUsuario(cadastroUsuario.getTfNomeUsuario().getText());
				novoUsuario.setEmail(cadastroUsuario.getTfEmail().getText());
				novoUsuario.setSenha(cadastroUsuario.getPfSenha().getText());			
				novoUsuario.setTelefone(cadastroUsuario.getTfTelefone().getText());
				
				novoUsuario.setCidade("");
				novoUsuario.setEstado("");
				novoUsuario.setFotoPerfil(null);
				novoUsuario.setPercentualLucro(0);
				novoUsuario.setPrecoHora(0);

				usuarioDAO.adicionarDados(novoUsuario);
				this.usuarioCadastrado = novoUsuario;
				
				JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Informação", 1);

				navegadorTelas2.navegarTela("CONFIGURAR_PERFIL_APOS_CADASTRAR");
				limparCamposTelaCadastro();
				
			}else if (EmailRepetido == true && UsuarioRepetido == true){
				JOptionPane.showMessageDialog(null, "Este Email e Usuário já Existem!! Informe outros.", "Informação", 1);
			} else if(EmailRepetido == true && UsuarioRepetido == false) {
				JOptionPane.showMessageDialog(null, "Este Email já Existe!! Informe outro.", "Informação", 1);
			} else if(EmailRepetido == false && UsuarioRepetido == true) {
				JOptionPane.showMessageDialog(null, "Este Usuário já Existe!! Informe outro.", "Informação", 1);
			} 
		}
	}
	
	//VERIFICAÇÃO EMAIL REPETIDO
	public void verificarEmail() {
		
		List<UsuarioPerfil> usuarios = usuarioDAO.listarUsuarios();
		
		
		EmailRepetido = false;
		
		for (UsuarioPerfil usuarioPerfil : usuarios) {
			
			if(usuarioPerfil.getEmail().equals(cadastroUsuario.getTfEmail().getText())) {
				EmailRepetido = true;
				break;
			}
		}
	}
	
	//VERIFICAÇÃO USUARIO REPETIDO
	public void verificarUsuarioPerfil() {
		
		List<UsuarioPerfil> usuarios = usuarioDAO.listarUsuarios();
		
		UsuarioRepetido = false;
		
		for (UsuarioPerfil usuarioPerfil : usuarios) {
			
			if(usuarioPerfil.getNomeUsuario().equals(cadastroUsuario.getTfNomeUsuario().getText())) {
				UsuarioRepetido = true;
				break;
			}
		}
	}

	//ATUALIZANDO CADASTRO USUÁRIO PELA TELA CONF PERFIL APÓS CADASTRAR
	public void atualizarCadTelaConfPerfilPosCad() {
		
		UsuarioPerfil usuarioAtualizado = new UsuarioPerfil(null, null, null, null, null, null, null, 0, 0, null);
		
	    String cidade = (String) confPerfilAposCad.getCbCidade().getSelectedItem();
	    String estado = (String) confPerfilAposCad.getCbEstadoCP().getSelectedItem();
		
		if(confPerfilAposCad.getTfNomeCompCP().getText().isEmpty() ||
				confPerfilAposCad.getTfPercLucroCP().getText().isEmpty() ||
				confPerfilAposCad.getTfPrecoHoraCP().getText().isEmpty() ||
				confPerfilAposCad.getTfTelefoneCP().getText().isEmpty() ||
				confPerfilAposCad.getPfSenhaCP().getText().isEmpty() ||
				cidade == null || cidade.isEmpty()  ||
				estado == null || estado.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Preencha todos os Campos!", "Informação", 1);
			
		} else {
			
			usuarioAtualizado.setFotoPerfil(null);
			usuarioAtualizado.setSenha(confPerfilAposCad.getPfSenhaCP().getText());
			usuarioAtualizado.setTelefone(confPerfilAposCad.getTfTelefoneCP().getText());
			usuarioAtualizado.setNome(confPerfilAposCad.getTfNomeCompCP().getText());
			usuarioAtualizado.setPrecoHora(Float.parseFloat(confPerfilAposCad.getTfPrecoHoraCP().getText()));
			usuarioAtualizado.setPercentualLucro(Float.parseFloat(confPerfilAposCad.getTfPercLucroCP().getText()));
			usuarioAtualizado.setNomeUsuario(confPerfilAposCad.getLbNomeUsuarioCad().getText());
			usuarioAtualizado.setEmail(confPerfilAposCad.getLbEmailCad().getText());
			
            usuarioAtualizado.setEstado((String) confPerfilAposCad.getCbEstadoCP().getSelectedItem());
            usuarioAtualizado.setCidade((String) confPerfilAposCad.getCbCidade().getSelectedItem());
		
			usuarioDAO.atualizarUsuario(usuarioAtualizado);
			
			JOptionPane.showMessageDialog(null, "Configuração de Perfil realizado com Sucesso", "Informação", 1);
			navegadorTelas2.navegarTela("LOGIN");
			
		}
	}
	
	//ATUALIZANDO CADASTRO USUÁRIO PELA TELA CONF PERFIL
    public void atualizarCadTelaConfPerfilCad() {
    	
    	String cidade = (String) confPerfil.getCbCidade().getSelectedItem();
	    String estado = (String) confPerfil.getCbEstado().getSelectedItem();
		
		if(confPerfil.getTfNomeCompCP().getText().isEmpty() ||				 
				confPerfil.getTfPercLucroCP().getText().isEmpty() ||
				confPerfil.getTfPrecoHoraCP().getText().isEmpty() ||
				confPerfil.getTfTelefoneCP().getText().isEmpty() ||
				confPerfil.getPfSenhaCP().getText().isEmpty() ||
				cidade == null || cidade.isEmpty()  ||
				estado == null || estado.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Preencha todos os Campos!", "Informação", 1);
			
		} else {
			
			UsuarioPerfil usuarioAtualizado = new UsuarioPerfil(null, null, null, null, null, null, null, 0, 0, null);
			usuarioAtualizado.setFotoPerfil(null);
			usuarioAtualizado.setSenha(confPerfil.getPfSenhaCP().getText());
			usuarioAtualizado.setTelefone(confPerfil.getTfTelefoneCP().getText());
			usuarioAtualizado.setNome(confPerfil.getTfNomeCompCP().getText());
			usuarioAtualizado.setPrecoHora(Float.parseFloat(confPerfil.getTfPrecoHoraCP().getText()));
			usuarioAtualizado.setPercentualLucro(Float.parseFloat(confPerfil.getTfPercLucroCP().getText()));
			usuarioAtualizado.setNomeUsuario(confPerfil.getLbNomeUsuarioCad().getText());
			usuarioAtualizado.setEmail(confPerfil.getLbEmailCad().getText());
			
            usuarioAtualizado.setEstado((String) confPerfil.getCbEstado().getSelectedItem());
            usuarioAtualizado.setCidade((String) confPerfil.getCbCidade().getSelectedItem());
			
		
			usuarioDAO.atualizarUsuario(usuarioAtualizado);
			
			JOptionPane.showMessageDialog(null, "Configuração de Perfil realizado com Sucesso", "Informação", 1);
			
		}
	}
	
    //ACIONA EVENTO AO APARECER UM JPANEL PARA CADASTRAR INFOS NA TELA JÁ CADASTRADAS
	public void componentShown(ComponentEvent e) {
		this.informacoesJaCadastradas((JPanel) e.getComponent());
	}
	
	//INFORMAÇÕES JÁ CADASTRADAS QUE IRÃO SER MOSTRADAS NAS TELAS DE CONFIGURAÇÃO
	public void informacoesJaCadastradas(JPanel tela) {
		
		if(tela == confPerfilAposCad) {
			
			confPerfilAposCad.getTfNomeCompCP().setText(usuarioCadastrado.getNome());
			confPerfilAposCad.getLbNomeUsuarioCad().setText(usuarioCadastrado.getNomeUsuario());
			confPerfilAposCad.getLbEmailCad().setText(usuarioCadastrado.getEmail());
			confPerfilAposCad.getTfTelefoneCP().setText(usuarioCadastrado.getTelefone());
			confPerfilAposCad.getPfSenhaCP().setText(usuarioCadastrado.getSenha());
			
		}
		
		if(tela == confPerfil) {
			
			UsuarioPerfil usuario = LoginController.usuarioLogado;
			
			confPerfil.getTfNomeCompCP().setText(usuario.getNome());
			confPerfil.getLbNomeUsuarioCad().setText(usuario.getNomeUsuario());
			confPerfil.getLbEmailCad().setText(usuario.getEmail());
			confPerfil.getTfTelefoneCP().setText(usuario.getTelefone());
			confPerfil.getPfSenhaCP().setText(usuario.getSenha());
			confPerfil.getTfPercLucroCP().setText(String.valueOf(usuario.getPercentualLucro()));
			
            confPerfil.getCbEstado().setSelectedItem(usuario.getEstado());
            confPerfil.getCbCidade().setSelectedItem(usuario.getCidade());
			
		}
	}
	
	
}