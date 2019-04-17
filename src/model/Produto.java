package model;

public class Produto {
	private String nome;
	private String unidade;
	private String descricao;
	private double preco;
	private String tipo;
	
	public Produto(String nome, String unidade, String descricao, double preco, String tipo) {
		this.nome = nome;
		this.unidade = unidade;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
