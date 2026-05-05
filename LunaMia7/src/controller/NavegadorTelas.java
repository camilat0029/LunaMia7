
package controller;

import javax.swing.JPanel;

import view.TelaPrincipal;

public class NavegadorTelas {

	private TelaPrincipal telaPrincipal;

	public NavegadorTelas(TelaPrincipal telaPrincipal) {
		this.telaPrincipal = telaPrincipal;
	}

	public void adicionarPainel(String nome, java.awt.Component componente) {
		this.telaPrincipal.adicionarTela(nome, componente);
	}

	public void navegarTela(String nome) {
		this.telaPrincipal.mostrarTela(nome);
		this.telaPrincipal.setTitle(getTitulo(nome));
	}

	private String getTitulo(String nome) {
	    switch (nome) {
	        case "LOGIN":
	            return "Login";
	            
	        case "CADASTRO_MATERIA_PRIMA":
	            return "Cadastro de matéria prima";
	            
	        case "CONFIGURAR_PERFIL":
	            return "Configuração de perfil";
	            
	        case "CONFIGURAR_PERFIL_APOS_CADASTRAR":
	        	return "Configuração de perfil";
        	
	        case "CRIAR_ORCAMENTO":
	        	return "Criação de orçamento";
	        	
	        case "CRIAR_ORCAMENTO_APOS_CALCULAR":
	        	return "Criação de orçamento";
	        	
	        case "CRIAR_ORCAMENTO_COM_FORMA_PAGAMENTO":
				return "Criação de orcamento";
				
			case "INICIO":
	        	return "Início";
	        	
	        case "REDEFINIR SENHA":
	        	return "Redefinir senha";
	        	
	        case "RELATORIOS":
	        	return "Relatórios";
	        	
	        case "RELATORIO_LUCROS":
	        	return "Relatório de lucros";
	        	
	        case "RELATORIO_HORAS_TRABALHADAS":
	        	return "Relatório das horas trabalhadas";
	        	
	        case "RELATORIO_GASTOS":
	        	return "Relatório dos gastos";
	        	
	        case "ORCAMENTOS":
	        	return "Orçamentos";
	        	
	        case "MATERIA_PRIMA":
	        	return "Matérias primas em estoque";
	        	
	        case "CADASTRO": 
	        	return "Cadastro do usuário";
	        	
	        	default:
	            return "";
	    }
	}

}