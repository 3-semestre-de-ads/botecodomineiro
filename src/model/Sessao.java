package model;

/**
 * 
 * @author MATIAS
 *
 * Nesta classe mantemos dados do usuario logado por toda a execução do software
 */
public class Sessao {
	private static Sessao instance = null;
	private String usuario;
	private String senha;
	private String nome;
	private int id;
	private int funcao;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public static Sessao getInstance() {
		if (instance == null) {
			instance = new Sessao();
		}
		return instance;
	}
}