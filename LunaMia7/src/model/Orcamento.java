package model;

import java.time.LocalDate;

public class Orcamento {
	
	private String tituloPedido;
	private float precoHora, percentualLucro;
	private float valorAdicional, valorGastos, valorSemLucro;
	private int maxDias, idOrcamento, quantHorasPrevistas;
	private Cliente cliente;
	private UsuarioPerfil usuarioPerfil;
	public Status status;
	
	public enum Status{
		CONCLUIDO("Concluído"),
		ANDAMENTO("Em andamento"),
		PENDENTE("Pendente");
		
		private String status;
		
		Status(String status){
			this.status = status;
		}
		
		@Override
		public String toString() {
			return status;
		}
	}
	
	public Orcamento(String tituloPedido, int quantHorasPrevistas, float precoHora,
			int maxDias, Status status, float percentualLucro, float valorAdicional,
			float valorGastos, float valorSemLucro) {
		super();
		this.tituloPedido = tituloPedido;
		this.quantHorasPrevistas = quantHorasPrevistas;
		this.precoHora = precoHora;
		this.maxDias = maxDias;
		this.status = status;
		this.percentualLucro = percentualLucro;
		this.valorAdicional = valorAdicional;
		this.valorGastos = valorGastos;
		this.valorSemLucro = valorSemLucro;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getTituloPedido() {
		return tituloPedido;
	}
	
	public void setTituloPedido(String tituloPedido) {
		this.tituloPedido = tituloPedido;
	}
	
	public int getQuantHorasPrevistas() {
		return quantHorasPrevistas;
	}
	
	public void setQuantHorasPrevistas(int quantHorasPrevistas) {
		this.quantHorasPrevistas = quantHorasPrevistas;
	}
	
	public float getPrecoHora() {
		return precoHora;
	}

	public void setPrecoHora(float precoHora) {
		this.precoHora = precoHora;
	}

	public int getMaxDias() {
		return maxDias;
	}
	
	public void setMaxDias(int maxDias) {
		this.maxDias = maxDias;
	}

	public int getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(int idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public UsuarioPerfil getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(UsuarioPerfil usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public float getPercentualLucro() {
		return percentualLucro;
	}

	public void setPercentualLucro(float percentualLucro) {
		this.percentualLucro = percentualLucro;
	}

	public float getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(float valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public float getValorGastos() {
		return valorGastos;
	}

	public void setValorGastos(float valorGastos) {
		this.valorGastos = valorGastos;
	}

	public float getValorSemLucro() {
		return valorSemLucro;
	}

	public void setValorSemLucro(float valorSemLucro) {
		this.valorSemLucro = valorSemLucro;
	}
}