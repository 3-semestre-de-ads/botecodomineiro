package model;

public class ProdutoNaComanda {
	
	private int ID;
	private String Produto;
	private String Unidade;
	private Double Preco;
	private int Quantidade;
	
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public String getUnidade() {
		return Unidade;
	}
	public void setUnidade(String unidade) {
		Unidade = unidade;
	}
	public Double getPreco() {
		return Preco;
	}
	public void setPreco(Double preco) {
		Preco = preco;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}

}
