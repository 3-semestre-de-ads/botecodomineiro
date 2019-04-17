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

public class UsuarioDAO {

	private JTable tabela;

	public boolean cadastrar(Usuario usuario) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conexão está estabelecida
			if (verificarLogin(usuario)) {
				usuario.setSenha(criptografarSenha(usuario.getSenha()));

				String sql = "INSERT INTO usuario (login, senha, nome, funcao, ativo)" + "VALUES ('" + usuario.getLogin()
						+ "','" + usuario.getSenha() + "','" + usuario.getNome() + "','" + usuario.getFuncao() + "','" + usuario.getAtivo() + "')";

				try {
					BD.st = BD.con.prepareStatement(sql);
					if (BD.st.executeUpdate() == 1) {
						JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso", "Sucesso no cadastro", 1);
						retorno = true;
					} else {
						JOptionPane.showMessageDialog(null, "Falha no cadastro do usuário", "Falha no cadastro", 0);
					}

				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inserção do usuário no banco", 0);
				}

			} else {
				JOptionPane.showMessageDialog(null, "Login já existe", "Login existente", 2);
			}

		}
		return retorno;
	}

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
						JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso", "Sucesso na atualizaçao",
								1);
						retorno = true;
					} else {
						JOptionPane.showMessageDialog(null, "Falha na atualizaço do usuário", "Falha na atualizaçao",
								0);
					}

				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualizaçao do usuário no banco", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Login já existe", "Login existente", 2);
			}

		}

		return retorno;
	}

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
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na consulta para criação da tabela", 0);
			}
		}

		return tabela;

	}

	public String criptografarSenha(String senha) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA");// Definindo SHA como metodo de criptografia
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		md.update(senha.getBytes());// Criptografando
		BigInteger hash = new BigInteger(1, md.digest());// Criptografando
		
		return hash.toString(16);// senha criptografada
	}

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
				JOptionPane.showMessageDialog(null, erro.toString(), "Erro ao verifica existencia do usuario", 0);
			}

		}

		return retorno;
	}
}

