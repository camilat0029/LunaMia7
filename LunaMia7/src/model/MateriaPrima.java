package model;

public class MateriaPrima {
	
	private String nome, marca,cor;
	private float valor,unidadePorUnidade;
	private int quantidadeDisponivel;
	private enum UnidadeMedida{
		
		CENTIMETROS, METROS,UNIDADE,MILIMETROS,LITROS;
		
		private float centimetros,metros,milimetros,litros;
		private int unidade;
		
		UnidadeMedida(){
		
			this.centimetros = centimetros;
			this.metros = metros;
			this.milimetros = milimetros;
			this.litros = litros;
			this.unidade = unidade;
			
		}

		public float getCentimetros() {
			return centimetros;
		}

		public void setCentimetros(float centimetros) {
			this.centimetros = centimetros;
		}

		public float getMetros() {
			return metros;
		}

		public void setMetros(float metros) {
			this.metros = metros;
		}

		public float getMilimetros() {
			return milimetros;
		}

		public void setMilimetros(float milimetros) {
			this.milimetros = milimetros;
		}

		public float getLitros() {
			return litros;
		}

		public void setLitros(float litros) {
			this.litros = litros;
		}

		public int getUnidade() {
			return unidade;
		}

		public void setUnidade(int unidade) {
			this.unidade = unidade;
		}
		
	}
	public MateriaPrima(String nome, String marca, String cor, float valor, float unidadePorUnidade,
			int quantidadeDisponivel) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.cor = cor;
		this.valor = valor;
		this.unidadePorUnidade = unidadePorUnidade;
		this.quantidadeDisponivel = quantidadeDisponivel;
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
	

}
