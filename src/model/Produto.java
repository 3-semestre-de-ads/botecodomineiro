package model;

/**
 * 
 * @author MATIAS e Heitor
 * 
 * Classe que representa o objeto produto
 *
 */

public class Produto {
	private int idproduto;
	private String nome;
	private String unidade;
	private String descricao;
	private double preco;
	private String tipo;
	private String fornecedor;
	private String qtdmin;
	private String qtdmax;
	private String qtdreposicao;
	
	//Construtor para atualização
	public Produto(int idproduto, String nome, String unidade, String descricao, double preco, String tipo,
			String fornecedor, String qtdmin, String qtdmax, String qtdreposicao) {
		super();
		this.idproduto = idproduto;
		this.nome = nome;
		this.unidade = unidade;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
		this.qtdmin = qtdmin;
		this.qtdmax = qtdmax;
		this.qtdreposicao = qtdreposicao;
	}
	//Construtor para cadastro
	public Produto(String nome, String unidade, String descricao, double preco, String tipo, String fornecedor, String qtdmin, String qtdmax, String qtdreposicao) {
		this.nome = nome;
		this.unidade = unidade;
		this.descricao = descricao;
		this.preco = preco;
		this.tipo = tipo;
		this.fornecedor = fornecedor;
		this.qtdmin = qtdmin;
		this.qtdmax = qtdmax;
		this.qtdreposicao = qtdreposicao;
	}
	public int getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
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
	public String getQtdmin() {
		return qtdmin;
	}
	public void setQtdmin(String qtdmin) {
		this.qtdmin = qtdmin;
	}
	public String getQtdmax() {
		return qtdmax;
	}
	public void setQtdmax(String qtdmax) {
		this.qtdmax = qtdmax;
	}
	public String getQtdreposicao() {
		return qtdreposicao;
	}
	public void setQtdreposicao(String qtdreposicao) {
		this.qtdreposicao = qtdreposicao;
	}
}
