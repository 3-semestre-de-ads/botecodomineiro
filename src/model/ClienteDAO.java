package model;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import banco.BD;

public class ClienteDAO {

	public boolean cadastrar(Cliente cliente) {
		boolean retorno = false;

		if (BD.conexao) {
			String sql = "INSERT INTO cliente(nome, email, celular, bairro, rua, numero, telefoneresidencial, telefonecomercial) \r\n"
					+ "VALUES ('" + cliente.getNome() + "','" + cliente.getEmail() + "','" + cliente.getMovel() + "','"
					+ cliente.getBairro() + "','" + cliente.getRua() + "','" + cliente.getNumero() + "','"
					+ cliente.getFixo() + "','" + cliente.getTelSecundario() + "')";

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					retorno = true;
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Cadastro de cliente", 1);
				}

			} catch (SQLException erro) {

			}
		}

		return retorno;
	}
	
	public boolean verificar(Cliente cliente) {
		boolean retorno = false;
		
		if(BD.conexao) {
			String sql = "";
		}
		
		return retorno;
	}

}
