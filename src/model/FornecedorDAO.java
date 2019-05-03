package model;

import java.awt.Cursor;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

/**
 * 
 * @author MATIAS e Heitor
 *
 *	Nesta classe cont�m os metodos para tratamento de fornecedor
 */

public class FornecedorDAO {

	private JTable tabela;

	/**
	 * Neste metodo cadastrar, � feita a inser��o de fornecedor no banco de dados
	 * @param fornecedor como parametro recebe um objeto da classe Fornecedor contendo as informa��es referente ao fornecedor a ser cadastrado
	 * @return retorna TRUE caso a inser��o no banco seja bem sucedida ou false caso ocorra uma falha
	 */
	
	public boolean cadastrar(Fornecedor fornecedor) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conex�o est� estabelecida
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
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inser��o do fornecedor no banco", 0);
			}

		}
		return retorno;
	}
	
	/**
	 * Neste metodo atualizar, � feita a atualiza��o do fornecedor no banco de dados
	 * @param fornecedor como parametro recebe um objeto da classe Formecedor contendo as informa��es referente ao fornecedor a ser atualizado
	 * @return retorna TRUE caso a atualiza��o no banco seja bem sucedida ou false caso ocorra uma falha
	 */
	
	public boolean atualizar(Fornecedor fornecedor) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conex�o est� estabelecida
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
					JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso", "Sucesso na atualiza��o", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha na atualiza��o do fornecedor", "Falha na atualiza��o", 0);
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualiza��o do fornecedor no banco", 0);
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
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na consulta para cria��o da tabela", 0);
			}
		}
		return tabela;
	}
}