package model;

public class MateriaPrima {
	
	private String nome, marca,cor;
	private float valor,qtdPorUnidade;
	private int quantidadeDisponivel, idMateriaPrima;
	private UnidadeMedida unidadeMedida;
	
	
	private static final long serialVersionUID = 1L;
	
	public enum UnidadeMedida{
		
		METRO("Metros"),
		CENTIMETRO("Centímetros"),
		LITRO("Litros"),
		MILIMETRO("Milímetros"),
		UNIDADE("Unidade");
		
		private String unidMed;
		
		UnidadeMedida(String unidMed){
			this.unidMed=unidMed;
		}
		
		@Override 
		public String toString() {
			return unidMed;
		}
		
	}
	
	public MateriaPrima(String nome, String marca, String cor, float valor, float qtdPorUnidade,
			int quantidadeDisponivel, UnidadeMedida unidadeMedida) {
		super();
		this.nome = nome;
		this.marca = marca;
		this.cor = cor;
		this.valor = valor;
		this.qtdPorUnidade = qtdPorUnidade;
		this.quantidadeDisponivel = quantidadeDisponivel;
		this.unidadeMedida = unidadeMedida;
	}
	
	
	//métodos
	
	
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
	public float getQtdPorUnidade() {
		return qtdPorUnidade;
	}
	public void setQtdPorUnidade(float qtdPorUnidade) {
		this.qtdPorUnidade = qtdPorUnidade;
	}
	public int getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}
	public void setQuantidadeDisponivel(int quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public int getIdMateriaPrima() {
		return idMateriaPrima;
	}


	public void setIdMateriaPrima(int idMateriaPrima) {
		this.idMateriaPrima = idMateriaPrima;
	}


	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}


	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	
	

}