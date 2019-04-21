package model;

import java.awt.Cursor;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

public class FornecedorDAO {

	private JTable tabela;

	public boolean cadastrar(Fornecedor fornecedor) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conexão está estabelecida
			String sql = "INSERT INTO fornecedor(razaosocial, nomefantasia, inscestadual, cnpj, pais, estado, cep, cidade, bairro, rua, numero, email, telefone, celular)"
					+ "VALUES ('" + fornecedor.getRazaosocial() + "','" + fornecedor.getNomefantasia() + "','" + fornecedor.getInscestadual() + "','" + fornecedor.getCnpj()
					+ "','" + fornecedor.getPais() + "','" + fornecedor.getEstado() + "','" + fornecedor.getCep() + "','" + fornecedor.getCidade() + "','" + fornecedor.getBairro()
					+ "','" + fornecedor.getRua() + "','" + fornecedor.getNumero() + "','" + fornecedor.getEmail() + "','" + fornecedor.getTelefone() + "','" + fornecedor.getCelular()
					+ "')";

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor cadastrado com sucesso", "Sucesso no cadastro", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do fornecedor", "Falha no cadastro", 0);
				}

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inserção do fornecedor no banco", 0);
			}

		}
		return retorno;
	}
	
	public boolean atualizar(Fornecedor fornecedor) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conexão está estabelecida
			String sql = "UPDATE fornecedor SET"
					+ " razaosocial = '" + fornecedor.getRazaosocial() + "',"
					+ " nomefantasia = '" + fornecedor.getNomefantasia() + "',"
					+ " inscestadual = '" + fornecedor.getInscestadual() + "',"
					+ " cnpj = '" + fornecedor.getCnpj() + "',"
					+ " pais = '" + fornecedor.getPais() + "',"
					+ " estado = '" + fornecedor.getEstado() + "',"
					+ " cep = '" + fornecedor.getCep() + "',"
					+ " cidade = '" + fornecedor.getCidade() + "',"
					+ " bairro = '" + fornecedor.getBairro() + "',"
					+ " rua = '" + fornecedor.getRua() + "',"
					+ " numero = '" + fornecedor.getNumero() + "',"
					+ " email = '" + fornecedor.getEmail() + "',"
					+ " telefone = '" + fornecedor.getTelefone() + "',"
					+ " celular = '" + fornecedor.getCelular() + "'"
					+ " WHERE idfornecedor = '" + fornecedor.getIdfornecedor() + "';";
			
			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso", "Sucesso na atualização", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha na atualização do fornecedor", "Falha na atualização", 0);
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualização do fornecedor no banco", 0);
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
					tabela.getColumnModel().getColumn(12).setPreferredWidth(150);					
					tabela.getColumnModel().getColumn(13).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(14).setPreferredWidth(150);
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