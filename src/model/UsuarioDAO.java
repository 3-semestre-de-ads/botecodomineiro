package model;

import java.awt.Cursor;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.TableGrade;

import banco.BD;

/**
 * 
 * @author MATIAS e Heitor
 *
 *	Nesta classe cont�m os metodos para tratamento de usuarios
 */
public class UsuarioDAO {

	private JTable tabela;
	
	/**
	 * Neste metodo cadastrar, � feita a inser��o do usuario no banco de dados
	 * @param usuario como parametro recebe um objeto da classe Usuario contendo as informa��es referente ao usuario a ser cadastrado
	 * @return retorna TRUE caso a inser��o no banco seja bem sucedida ou false caso ocorra uma falha
	 */

	public boolean cadastrar(Usuario usuario) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conex�o est� estabelecida
			if (verificarLogin(usuario)) {
				usuario.setSenha(criptografarSenha(usuario.getSenha()));

				String sql = "INSERT INTO usuario (login, senha, nome, funcao, ativo)" + "VALUES ('" + usuario.getLogin()
						+ "','" + usuario.getSenha() + "','" + usuario.getNome() + "','" + usuario.getFuncao() + "','" + usuario.getAtivo() + "')";

				try {
					BD.st = BD.con.prepareStatement(sql);
					if (BD.st.executeUpdate() == 1) {
						JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso", "Sucesso no cadastro", 1);
						retorno = true;
					} else {
						JOptionPane.showMessageDialog(null, "Falha no cadastro do usu�rio", "Falha no cadastro", 0);
					}

				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inser��o do usu�rio no banco", 0);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Login j� existe", "Login existente", 2);
			}

		}
		return retorno;
	}

	/**
	 * Neste metodo atualizar, � feita a atualiza��o do usuario no banco de dados
	 * @param usuario como parametro recebe um objeto da classe Usuario contendo as informa��es referente ao usuario a ser atualizado
	 * @return retorna TRUE caso a atualiza��o no banco seja bem sucedida ou false caso ocorra uma falha
	 */
	
	public boolean atualizar(Usuario usuario) {
		boolean retorno = false;
		if (BD.conexao) {
			if (verificarLogin(usuario)) {
				String sql = "";

				if (usuario.getSenha() == null) {

					sql = "UPDATE usuario \r\n" 
					+ "SET nome = '" + usuario.getNome() 
					+ "', login = '" + usuario.getLogin() 
					+ "', funcao = " + usuario.getFuncao()
					+ ", ativo = " + usuario.getAtivo() + "\r\n" 
					+ "WHERE id_usuario = "	+ usuario.getID();

				} else {

					usuario.setSenha(criptografarSenha(usuario.getSenha()));

					sql = "UPDATE usuario \r\n" 
					+ "SET nome = '" + usuario.getNome() 
					+ "', login = '" + usuario.getLogin() 
					+ "', funcao = " + usuario.getFuncao() 
					+ ", ativo = " + usuario.getAtivo()
					+ ", senha = '" + usuario.getSenha() + "'\r\n" 
					+ "WHERE id_usuario = " + usuario.getID();

				}

				try {
					BD.st = BD.con.prepareStatement(sql);
					if (BD.st.executeUpdate() == 1) {
						JOptionPane.showMessageDialog(null, "Usu�rio atualizado com sucesso", "Sucesso na atualiza�ao",
								1);
						retorno = true;
					} else {
						JOptionPane.showMessageDialog(null, "Falha na atualiza�o do usu�rio", "Falha na atualiza�ao",
								0);
					}

				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualiza�ao do usu�rio no banco", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Login j� existe", "Login existente", 2);
			}

		}

		return retorno;
	}

	/**
	 * Neste metodo criar tabela, � feito a chamada da classe TableGrade para a cria��o da tabela
	 * @param sql este parametro tras a consulta a ser feita no banco para a cria��o da tabela
	 * @param cabecalhoPersonalizado este parametro cont�m o Vector com o cabe�alho da tabela
	 * @return
	 */
	
	public JTable criarTabela(String sql, Vector<String> cabecalhoPersonalizado) {
		tabela = null;

		if (BD.conexao) {
			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				if (BD.rs.next()) {
					tabela = null;

					tabela = TableGrade.getTable(sql, cabecalhoPersonalizado);
					tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
					tabela.getColumnModel().getColumn(1).setPreferredWidth(140);
					tabela.getColumnModel().getColumn(2).setPreferredWidth(140);
					tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
					tabela.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

					tabela.setEditingRow(0);
					tabela.setEditingColumn(0);
					tabela.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na consulta para cria��o da tabela", 0);
			}
		}

		return tabela;

	}

	/**
	 * Neste metodo � feito a criptografia da senha
	 * @param senha este parametro � a senha a ser criptografada
	 * @return retorna a senha criptografada
	 */
	
	public String criptografarSenha(String senha) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		md.update(senha.getBytes());// Criptografando
		BigInteger hash = new BigInteger(1, md.digest());// Criptografando
		
		return hash.toString(16);// senha criptografada
	}

	/**
	 * Neste metodo � feito a verifica��o do login, consultando no banco se o login a ser cadastrado ou atualizado j� existe
	 * @param usuario este parametro tras um objeto da classe Usuario, onde contem o login a ser verificado
	 * @return retorna true caso n�o exista este login no banco e false caso exista o login no banco
	 */
	
	public boolean verificarLogin(Usuario usuario) {
		boolean retorno = true;

		String sql = "SELECT * FROM usuario WHERE login = '" + usuario.getLogin() + "' AND id_usuario != '" + usuario.getID() + "'";

		if (BD.conexao) {
			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				
				if(BD.rs.next()) {
					retorno = false;
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Erro ao verificar existencia do usuario", 0);
			}

		}

		return retorno;
	}
}

