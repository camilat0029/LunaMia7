package model;

public class MateriaPrima {
	
	private String nome, marca,cor;
	private float valor,unidadePorUnidade;
	private int quantidadeDisponivel;
	private UnidadeMedida unidadeMedida;
	
	
	private static final long serialVersionUID = 1L;
	

	public enum UnidadeMedida{
		
		
		CENTIMETROS, METROS,UNIDADE,MILIMETROS,LITROS;
		
		UnidadeMedida(){

		}
		
	}
	public MateriaPrima(String nome, String marca, String cor, float valor, float unidadePorUnidade,
			int quantidadeDisponivel, UnidadeMedida unidadeMedida) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.cor = cor;
		this.valor = valor;
		this.unidadePorUnidade = unidadePorUnidade;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.unidadeMedida = unidadeMedida;
	}
	
	
	//métodos
	
	public void adicionarInsumos() {
		
	}
	public void atualizarInsumos() {
		
	}
	public void excluirInsumos(){
		
	}
	
	//getters and setters
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getUnidadePorUnidade() {
		return unidadePorUnidade;
	}
	public void setUnidadePorUnidade(float unidadePorUnidade) {
		this.unidadePorUnidade = unidadePorUnidade;
	}
	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}
	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}


	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}


	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	
	

}
