package model;

public class Produto {
	private int idproduto;
	private String nome;
	private String unidade;
	private String descricao;
	private double preco;
	private String tipo;
	private String fornecedor;
	
	//Construtor para atualização
	public Produto(int idproduto, String nome, String unidade, String descricao, double preco, String tipo,
			String fornecedor) {
		super();
		this.idproduto = idproduto;
		this.nome = nome;
		this.unidade = unidade;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
	}
	//Construtor para cadastro
	public Produto(String nome, String unidade, String descricao, double preco, String tipo, String fornecedor) {
		this.nome = nome;
		this.unidade = unidade;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
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
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getIdproduto() {
		return idproduto;
	}
}
