package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public abstract class BD {
	public static Connection con = null; // conecta ao banco
	public static PreparedStatement st = null; // Executa SQL
	public static ResultSet rs = null; // recebe resultado SQL
	public static boolean conexao = false;

	// CONEX�O PARA O SERVIDOR AWS
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://butecomineiro.c8egphw0jq8h.sa-east-1.rds.amazonaws.com/buteco_mineiro";
	private static final String LOGIN = "Matias";
	private static final String SENHA = "Matias2201";

	// CONEX�O LOCAL HEITOR AMARAL
	//private static final String DRIVER = "com.mysql.jdbc.Driver";
	//private static final String URL = "jdbc:mysql://localhost/buteco_mineiro";
	//private static final String LOGIN = "root";
	//private static final String SENHA = "colete47";
	
	/**
	 * Realiza a conex�o com o banco de dados
	 * 
	 * @return retorna true caso obtenha sucesso na conex�o
	 */
	public static boolean getConnection() {

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, LOGIN, SENHA);
			System.out.println("Conectou...");
			conexao = true;
			return true;
		} catch (ClassNotFoundException erro) {
			System.out.println("Driver n�o encontrado! ");
			conexao = false;
			return false;
		} catch (SQLException erro) {
			System.out.println("Erro " + erro.toString());
			conexao = false;
			return false;
		}
	}

	/**
	 * Encerra a conex�o ao banco de dados
	 */
	public static void close() {
		conexao = false;
		try {
			if (rs != null) {
				rs.close(); // encerra o rs
			}
		} catch (SQLException erro) {
		}
		try {
			if (st != null) {
				st.close(); // encerra o st
			}
		} catch (SQLException erro) {
		}
		try {
			if (con != null) {
				con.close(); // encerra a conex�o
				System.out.println("Desconectou...");
			}
		} catch (SQLException erro) {
			JOptionPane.showMessageDialog(null, "Falha ao fechar conex�o com o banco");
		}
	}

	/**
	 * Verifica se a conex�o com o banco est� estabelecida caso n�o esteja tenta
	 * conectar
	 * 
	 * @return retorna true caso a conex�o esteja ou seja estabelecida false para
	 *         falha na conex�o
	 */
	public static boolean conexao() {
		boolean retorno = false;
		if (BD.conexao == false) {// Se o banco n�o estiver conectado tente conectar
			try {// Tente conectar
				BD.getConnection();
				retorno = true;
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na conex�o com o banco", 0);
				retorno = false;
			}
		} else {
			retorno = true;
		}
		return retorno;
	}

	/**
	 * void main para teste de conex�o direto da classe BD
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		BD.getConnection();
		BD.close();
	}
}