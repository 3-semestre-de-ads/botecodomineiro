package model;

public class Sessao {
	private static Sessao instance = null;
	private String usuario;
	private String senha;
	private String nome;
	private static int funcao;

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

	public static int getFuncao() {
		return funcao;
	}

	public void setFuncao(int funcao) {
		Sessao.funcao = funcao;
	}

	public Sessao() {

	}

	public static Sessao getInstance() {
		if (instance == null) {
			instance = new Sessao();
		}
		return instance;
	}
}