package model;

import java.time.LocalDate;

public class Orcamento {
	
	private String tituloPedido, descricaoPedido, pagamento;
	private float quantHorasPrevistas;
	private int maxDias;
	private LocalDate dataPrevistaEntrega, dataConfirmacao;
	private Cliente cliente;
	
	private enum status{
		CONCLUIDO,ANDAMENTO,PENDENTE;
		
		private boolean concluido,andamento,pendente;
		
		status(){
			this.concluido = concluido;
			this.andamento = andamento;
			this.pendente = pendente;
		}

		public boolean isConcluido() {
			return concluido;
		}

		public void setConcluido(boolean concluido) {
			this.concluido = concluido;
		}

		public boolean isAndamento() {
			return andamento;
		}

		public void setAndamento(boolean andamento) {
			this.andamento = andamento;
		}

		public boolean isPendente() {
			return pendente;
		}

		public void setPendente(boolean pendente) {
			this.pendente = pendente;
		}
		
		
	}
	
	public Orcamento(String tituloPedido, String descricaoPedido, String pagamento, float quantHorasPrevistas,
			int maxDias, LocalDate dataPrevistaEntrega, LocalDate dataConfirmacao) {
		super();
		this.tituloPedido = tituloPedido;
		this.descricaoPedido = descricaoPedido;
		this.pagamento = pagamento;
		this.quantHorasPrevistas = quantHorasPrevistas;
		this.maxDias = maxDias;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConfirmacao = dataConfirmacao;
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
	public String getDescricaoPedido() {
		return descricaoPedido;
	}
	public void setDescricaoPedido(String descricaoPedido) {
		this.descricaoPedido = descricaoPedido;
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
