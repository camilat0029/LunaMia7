package model;

import java.awt.Image;

public class UsuarioPerfil {
	
	private String nome, nomeUsuario,email, senha, telefone, cidade,  estado, fotoPerfil;
	private float precoHora, percentualLucro;
	
	//construtor	
	
	public UsuarioPerfil(String nome, String nomeUsuario, String email, String senha, String telefone, String cidade, String estado,
			float precoHora, float percentualLucro, String fotoPerfil) {
		super();
		this.nome = nome;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cidade = cidade;
		this.estado = estado;
		this.precoHora = precoHora;
		this.percentualLucro = percentualLucro;
		this.fotoPerfil = fotoPerfil;
	}
	
	//métodos 
	
	public void adicionarDados() {
		
	}
	
	public void atualizarDados() {
		
	}
	
	public void excluirDados(){
		
	}
	
	//getters and setters 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getPrecoHora() {
		return precoHora;
	}


	public void setPrecoHora(float precoHora) {
		this.precoHora = precoHora;
	}


	public float getPercentualLucro() {
		return percentualLucro;
	}


	public void setPercentualLucro(float percentualLucro) {
		this.percentualLucro = percentualLucro;
	}


	public String getFotoPerfil() {
		return fotoPerfil;
	}


	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}
	
}
