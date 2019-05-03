package model;

public class Fornecedor {
	private int idfornecedor;
	private String pais;
	private String cidade;
	private String razaosocial;
	private String nomefantasia;
	private String inscestadual;
	private String cnpj;
	private String estado;
	private String rua;
	private String telefone;
	private String numero;
	private String bairro;
	private String email;
	private String cep;
	private String celular;

	// Construtor para atualização
	public Fornecedor(int idfornecedor, String pais, String cidade, String razaosocial, String nomefantasia,
			String inscestadual, String cnpj, String estado, String rua, String telefone, String numero, String bairro,
			String email, String cep, String celular) {
		super();
		this.idfornecedor = idfornecedor;
		this.pais = pais;
		this.cidade = cidade;
		this.razaosocial = razaosocial;
		this.nomefantasia = nomefantasia;
		this.inscestadual = inscestadual;
		this.cnpj = cnpj;
		this.estado = estado;
		this.rua = rua;
		this.telefone = telefone;
		this.numero = numero;
		this.bairro = bairro;
		this.email = email;
		this.cep = cep;
		this.celular = celular;
	}

	// Construtor para cadastro
	public Fornecedor(String pais, String cidade, String razaosocial, String nomefantasia, String inscestadual,
			String cnpj, String estado, String rua, String telefone, String numero, String bairro, String email,
			String cep, String celular) {
		super();
		this.pais = pais;
		this.cidade = cidade;
		this.razaosocial = razaosocial;
		this.nomefantasia = nomefantasia;
		this.inscestadual = inscestadual;
		this.cnpj = cnpj;
		this.estado = estado;
		this.rua = rua;
		this.telefone = telefone;
		this.numero = numero;
		this.bairro = bairro;
		this.email = email;
		this.cep = cep;
		this.celular = celular;
	}

	public int getIdfornecedor() {
		return idfornecedor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
	}

	public String getNomefantasia() {
		return nomefantasia;
	}

	public void setNomefantasia(String nomefantasia) {
		this.nomefantasia = nomefantasia;
	}

	public String getInscestadual() {
		return inscestadual;
	}

	public void setInscestadual(String inscestadual) {
		this.inscestadual = inscestadual;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
}