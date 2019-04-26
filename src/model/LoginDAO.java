package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.BD;
import model.Sessao;

public class LoginDAO {

	/**
	 * Neste metodo logar, e feito uma consulta no banco com os dados fornecidos pelo usuario para verificar se o login e senha esto corretos, 
	 * para isso a senha passa por um processo de criptografia antes que seja feita a consulta
	 * 
	 * @param login fornecido pelo usuario no campo login da TelaLogin
	 * @param senha fornecido pelo usuario no campo senha da TelaLogin
	 * @return retorna true caso o usuario e senha estejam corretos ou false caso estejam incorretos
	 */
	public boolean logar(String login, String senha) {
		boolean retorno = false;
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA");// Definindo SHA como metodo de criptografia
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		md.update(senha.getBytes());// Criptografando
		BigInteger hash = new BigInteger(1, md.digest());// Criptografando
		String senhaCript = hash.toString(16);// senha criptografada

		
		System.out.println(senhaCript);
		if (BD.conexao()) {// Caso o metodo de conexão retorne true prossiga com a consulta
			try {
				String sql = "SELECT * FROM usuario WHERE login = '" + login + "' and senha = '" + senhaCript + "'";
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();

				if (BD.rs.next() && BD.rs.getInt("ativo") == 1) {// Caso exista resultado armazena dados do usuario na sessao e colocar true no retorno
					Sessao sessao = Sessao.getInstance();
					sessao.setSenha(BD.rs.getString("senha"));
					sessao.setUsuario(BD.rs.getString("login"));
					sessao.setNome(BD.rs.getString("nome"));
					sessao.setFuncao(BD.rs.getInt("funcao"));
					sessao.setId(BD.rs.getInt("id_usuario"));
					retorno = true;
				}else {
					JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto ou usuario bloqueado", "Falha no login", 0);
				}

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na consulta para verificação do usuario",
						0);
			}

		}
		return retorno;
	}
}
