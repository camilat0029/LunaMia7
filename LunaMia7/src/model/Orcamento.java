package model;

import java.time.LocalDate;

public class Orcamento {
	
	private String tituloPedido;
	private float quantHorasPrevistas, precoHora;
	private int maxDias, idOrcamento;
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
	
	public Orcamento(String tituloPedido, float quantHorasPrevistas, float precoHora,
			int maxDias, Status status) {
		super();
		this.tituloPedido = tituloPedido;
		this.quantHorasPrevistas = quantHorasPrevistas;
		this.precoHora = precoHora;
		this.maxDias = maxDias;
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void adicionarDados() {
		
	}
	public void atualizarDados() {
		
	}
	public void excluirDados() {
		
	}
	public void calcularLucro() {
		
	}
	public void calcularGastoTotal(){
		
	}
	public void calcularValorDeVenda() {
		
	}
	public void duplicarOrcamento() {
		
	}
	public void guardarOrcamento() {
		
	}
	public void consultarHistOrcam() {
		
	}
	
	
	public String getTituloPedido() {
		return tituloPedido;
	}
	
	public void setTituloPedido(String tituloPedido) {
		this.tituloPedido = tituloPedido;
	}
	
	public float getQuantHorasPrevistas() {
		return quantHorasPrevistas;
	}
	
	public void setQuantHorasPrevistas(float quantHorasPrevistas) {
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
	
	
	
	
	


	
	

}