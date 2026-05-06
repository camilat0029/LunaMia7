package model;

import java.time.LocalDate;

public class Orcamento {
	
	private String tituloPedido, pagamento;
	private float quantHorasPrevistas, precoHora;
	private int maxDias;
	private LocalDate dataPrevistaEntrega, dataConfirmacao;
	private Cliente cliente;
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
	
	public Orcamento(String tituloPedido, String pagamento, float quantHorasPrevistas, float precoHora,
			int maxDias, LocalDate dataPrevistaEntrega, LocalDate dataConfirmacao, Status status) {
		super();
		this.tituloPedido = tituloPedido;
		this.pagamento = pagamento;
		this.quantHorasPrevistas = quantHorasPrevistas;
		this.precoHora = precoHora;
		this.maxDias = maxDias;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConfirmacao = dataConfirmacao;
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
	
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
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
	public LocalDate getDataPrevistaEntrega() {
		return dataPrevistaEntrega;
	}
	public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
		this.dataPrevistaEntrega = dataPrevistaEntrega;
	}
	public LocalDate getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(LocalDate dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	


	
	

}
