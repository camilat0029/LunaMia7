package model;

import java.time.LocalDate;

public class ConfirOrcam {
	
	private String  formPagamento;
	private LocalDate dataPrevistaEntrega, dataConfirmacao;
	private float valorVenda, lucro;
	private Orcamento orcamento;
	
	
	public ConfirOrcam(String  formPagamento, LocalDate dataPrevistaEntrega, 
			LocalDate dataConfirmacao, float valorVenda, float lucro) {
		super();
		this.formPagamento = formPagamento;
		this.dataPrevistaEntrega = dataPrevistaEntrega;
		this.dataConfirmacao = dataConfirmacao;
		this.valorVenda = valorVenda;
		this.lucro = lucro;
	}


	public String getFormPagamento() {
		return formPagamento;
	}


	public void setFormPagamento(String formPagamento) {
		this.formPagamento = formPagamento;
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


	public float getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(float valorVenda) {
		this.valorVenda = valorVenda;
	}


	public float getLucro() {
		return lucro;
	}


	public void setLucro(float lucro) {
		this.lucro = lucro;
	}


	public Orcamento getOrcamento() {
		return orcamento;
	}


	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	
}
