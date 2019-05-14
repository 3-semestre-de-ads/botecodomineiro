package model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

/**
 * 
 * @author MATIAS e Heitor
 *
 *	Nesta classe cont�m os metodos para tratamento de produto
 */

public class ProdutoDAO {

	private JTable tabela;

	/**
	 * Neste metodo cadastrar, � feita a inser��o de produtos no banco de dados
	 * @param produto como parametro recebe um objeto da classe Produto contendo as informa��es referente ao produto a ser cadastrado
	 * @return retorna TRUE caso a inser��o no banco seja bem sucedida ou false caso ocorra uma falha
	 */
	
	public boolean cadastrar(Produto produto) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conex�o est� estabelecida
			String sql = "INSERT INTO produto(nome, unidade, descricao, preco, tipo, idfornecedor, qtdmin, qtdmax, qtdreposicao)" + "VALUES ('"
					+ produto.getNome() + "','" + produto.getUnidade() + "','" + produto.getDescricao() + "','"
					+ produto.getPreco() + "','" + produto.getTipo() + "',"
					+ "(SELECT idfornecedor FROM fornecedor where nomefantasia = '" + produto.getFornecedor() + "'),"
							+ "'" + produto.getQtdmin() + "', '" + produto.getQtdmax() + "', '" + produto.getQtdreposicao() + "')";

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Sucesso no cadastro", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do produto", "Falha no cadastro", 0);
				}

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inser��o do produto no banco", 0);
			}

		}
		return retorno;
	}

	/**
	 * Neste metodo atualizar, � feita a atualiza��o do produto no banco de dados
	 * @param produto como parametro recebe um objeto da classe Produto contendo as informa��es referente ao produto a ser atualizado
	 * @return retorna TRUE caso a atualiza��o no banco seja bem sucedida ou false caso ocorra uma falha
	 */
	
	public boolean atualizar(Produto produto) {
		boolean retorno = false;
		if (BD.conexao()) {// Verificando se a conex�o est� estabelecida
			String sql = "UPDATE produto SET\r\n" 
		+ " idfornecedor = (SELECT idfornecedor FROM fornecedor where nomefantasia = '" + produto.getFornecedor()+ "'),\r\n" 
		+ "nome = '" + produto.getNome() + "',\r\n" 
		+ "unidade = '" + produto.getUnidade()+ "',\r\n" 
		+ "descricao = '" + produto.getDescricao() + "',\r\n" 
		+ "preco = '" + produto.getPreco() + "',\r\n" 
		+ "tipo = '" + produto.getTipo() + "',\r\n" 
		+ "qtdmin = '" + produto.getQtdmin() + "',\r\n"
		+ "qtdmax = '" + produto.getQtdmax() + "',\r\n"
		+ "qtdreposicao = '" + produto.getQtdreposicao() + "'\r\n"
		+ "WHERE idproduto = "+ produto.getIdproduto();

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso", "Sucesso na atualiza�ao", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha na atualiza�o do produto", "Falha na atualiza�ao", 0);
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualiza�ao do produto no banco", 0);
			}

		}
		return retorno;
	}

	/**
	 * neste metodo ConsultarForn, � feito uma consulta no banco de dados na tabela fornecedor para ser usado esses dados para alimentar a combobox de fornecedor
	 * @return retornar o ResultSet com os fornecedores cadastrados no banco
	 */
	
	public static ResultSet consultarForn() {
		ResultSet resultado = null;
		String sql = "SELECT nomefantasia FROM fornecedor ORDER BY nomefantasia";
		if (BD.conexao) {
			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				resultado = BD.rs;
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Erro ao realizar a consulta de fornecedores", 0);
			}
		}
		return resultado;
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
					tabela.getColumnModel().getColumn(1).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
					tabela.getColumnModel().getColumn(4).setPreferredWidth(170);
					tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
					tabela.getColumnModel().getColumn(6).setPreferredWidth(150);
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
