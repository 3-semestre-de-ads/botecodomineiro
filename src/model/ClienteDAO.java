package model;

import java.awt.Cursor;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

public class ClienteDAO {
	
	private JTable tabela;

	public boolean cadastrar(Cliente cliente) {
		boolean retorno = false;

		if (BD.conexao()) {// Verificando se a conexão está estabelecida
			String sql = "INSERT INTO cliente(nome, cpf, telefoneFixo, telefoneCelular, email, cep, uf, cidade, bairro, rua, numero) \r\n"
					+ "VALUES ('" + cliente.getNome() + "','" + cliente.getCpf() + "','" + cliente.getFixo() + "','"
					+ cliente.getCelular() + "','" + cliente.getEmail() + "','" + cliente.getCep() + "','"
					+ cliente.getuf() + "','" + cliente.getCidade() + "','" + cliente.getBairro() + "','"
					+ cliente.getRua() + "','" + cliente.getNumero() + "')";
			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Sucesso no cadastro", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do cliente", "Falha no cadastro", 0);
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inserção do cliente no banco", 0);
			}
		}
		return retorno;
	}

	public boolean atualizar(Cliente cliente) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conexão está estabelecida
			String sql = "UPDATE cliente SET"
					+ " nome = '" + cliente.getNome() + "',"
					+ " cpf = '" + cliente.getCpf() + "',"
					+ " telefoneFixo = '" + cliente.getFixo() + "',"
					+ " telefoneCelular = '" + cliente.getCelular() + "',"
					+ " email = '" + cliente.getEmail() + "',"
					+ " cep = '" + cliente.getCep() + "',"
					+ " uf = '" + cliente.getuf() + "',"
					+ " cidade = '" + cliente.getCidade() + "',"
					+ " bairro = '" + cliente.getBairro() + "',"
					+ " rua = '" + cliente.getRua() + "',"
					+ " numero = '" + cliente.getNumero() + "'"
					+ " WHERE idcliente = '" + cliente.getId() + "';";
			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso", "Sucesso na atualização", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha na atualização do cliente", "Falha na atualização", 0);
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualização do cliente no banco", 0);
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
					tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(3).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(4).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(5).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(6).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(7).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(8).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(9).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(10).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(11).setPreferredWidth(150);
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
}
