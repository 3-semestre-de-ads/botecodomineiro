package model;

public class Usuario {
	
	private int ID;
	private String login;
	private String senha;
	private String nome;
	private int ativo;
	private int funcao;
	
	//Construtor para atualizacao sem senha
	public Usuario(int ID, String login, String nome, int ativo, int funcao) {
		this.ID = ID;
		this.login = login;
		this.nome = nome;
		this.ativo = ativo;
		this.funcao = funcao;
	}
	
	//Construtor para atualizaçao com senha
	public Usuario(int ID, String login, String senha, String nome, int ativo, int funcao) {
		this.ID = ID;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.ativo = ativo;
		this.funcao = funcao;
	}
	
	//Construtor para cadastro
	public Usuario(String login, String senha, String nome, int ativo, int funcao) {
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.ativo = ativo;
		this.funcao = funcao;
	}
	
	public int getID() {
		return ID;
	}
	
	public void seID(int ID) {
		this.ID = ID;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getFuncao() {
		return funcao;
	}
	
	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}
	

}
