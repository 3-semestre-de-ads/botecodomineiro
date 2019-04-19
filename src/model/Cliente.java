package model;

public class Cliente {
	private int id;
	private String nome;
	private String cep;
	private String bairro;
	private String rua;
	private String cidade;
	private String numero;
	private String uf;
	private String fixo;
	private String movel;
	private String telSecundario;
	private String email;
	private String cpf;
	
	public Cliente(int id, String nome, String cep, String bairro, String rua, String cidade, String numero, String uf,
			String fixo, String movel, String telSecundario, String email, String cpf) {
	
		this.id = id;
		this.nome = nome;
		this.cep = cep;
		this.bairro = bairro;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
		this.uf = uf;
		this.fixo = fixo;
		this.movel = movel;
		this.telSecundario = telSecundario;
		this.email = email;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getuf() {
		return uf;
	}
	public void setuf(String uf) {
		this.uf = uf;
	}
	public String getFixo() {
		return fixo;
	}
	public void setFixo(String fixo) {
		this.fixo = fixo;
	}
	public String getMovel() {
		return movel;
	}
	public void setMovel(String movel) {
		this.movel = movel;
	}
	public String getTelSecundario() {
		return telSecundario;
	}
	public void setTelSecundario(String telSecundario) {
		this.telSecundario = telSecundario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
