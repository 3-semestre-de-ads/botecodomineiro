package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.BD;

public class ClienteDAO {

	public boolean cadastrar(Cliente cliente) {
		boolean retorno = false;

		if (BD.conexao()) {// Verificando se a conex�o est� estabelecida
			String sql = "INSERT INTO cliente(nome, email, bairro, rua, numero, telefoneFixo, telefoneCelular, cpf, cep, uf, cidade) \r\n"
					+ "VALUES ('" + cliente.getNome() + "','" + cliente.getEmail() + "','" + cliente.getBairro() + "','"
					+ cliente.getRua() + "','" + cliente.getNumero() + "','" + cliente.getFixo() + "','"
					+ cliente.getCelular() + "','" + cliente.getCpf() + "','" + cliente.getCep() + "','"
					+ cliente.getuf() + "','" + cliente.getCidade() + "')";
			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso no cadastro", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do cliente", "Falha no cadastro", 0);
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inser��o do cliente no banco", 0);
			}
		}
		return retorno;
	}

	public boolean atualizar(Cliente cliente) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conex�o est� estabelecida
			String sql = "UPDATE cliente SET"
					+ " nome = '" + cliente.getNome() + "',"
					+ " email = '" + cliente.getEmail() + "',"
					+ " bairro = '" + cliente.getBairro() + "',"
					+ " rua = '" + cliente.getRua() + "',"
					+ " numero = '" + cliente.getNumero() + "',"
					+ " telefoneFixo = '" + cliente.getFixo() + "',"
					+ " telefoneCelular = '" + cliente.getCelular() + "',"
					+ " cpf = '" + cliente.getCpf() + "',"
					+ " cep = '" + cliente.getCep() + "',"
					+ " uf = '" + cliente.getuf() + "',"
					+ " cidade = '" + cliente.getCidade() + "'"
					+ " WHERE idcliente = '" + cliente.getId() + "';";
			
			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Sucesso na atualiza��o", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha na atualiza��o do cliente", "Falha na atualiza��o", 0);
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualiza��o do cliente no banco", 0);
			}

		}
		return retorno;
	}
	
}
