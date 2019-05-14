package model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

public class EstoqueDAO {

	Sessao sessao = Sessao.getInstance();

	private JTable tabela;

	public JTable criarTabela(String sql, Vector<String> cabecalhoPersonalizado) {
		tabela = null;

		if (BD.conexao()) {
			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				if (BD.rs.next()) {
					tabela = null;

					tabela = TableGrade.getTable(sql, cabecalhoPersonalizado);
					tabela.getColumnModel().getColumn(0).setPreferredWidth(50);
					tabela.getColumnModel().getColumn(1).setPreferredWidth(300);
					tabela.getColumnModel().getColumn(2).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
					tabela.getColumnModel().getColumn(4).setPreferredWidth(315);
					tabela.getColumnModel().getColumn(5).setPreferredWidth(70);
					tabela.getColumnModel().getColumn(6).setPreferredWidth(150);
					tabela.getColumnModel().getColumn(7).setPreferredWidth(100);
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

	public ResultSet consultarForn() {
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

	public boolean adicionarEstoque(Estoque estoque) {
		boolean retorno = false;

		if (verificarEstoque(estoque, "adicionar")) {
			if (BD.conexao()) {
				String sql = "UPDATE produto SET quantidade = quantidade + " + estoque.getQtd() + "\r\n"
						+ "WHERE idproduto = '" + estoque.getIdProduto() + "';"

						+ "INSERT INTO registro_estoque (descricao, quantidade, data, id_produto, id_usuario) "
						+ "VALUES ('" + estoque.getDescricao() + "', " + estoque.getQtd() + ", '" + convDataBanco()
						+ "', " + estoque.getIdProduto() + ", " + sessao.getId() + " )";
				try {
					BD.st = BD.con.prepareStatement(sql);
					BD.st.executeUpdate();

					retorno = true;
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.toString(), this.getClass().getName(), 0);
				}

			}
		}

		return retorno;
	}

	public boolean removerEstoque(Estoque estoque) {
		boolean retorno = false;

		if (verificarEstoque(estoque, "remover")) {
			if (BD.conexao()) {
				String sql = "UPDATE produto SET quantidade = quantidade - " + estoque.getQtd() + "\r\n"
						+ "WHERE idproduto = '" + estoque.getIdProduto() + "';"

						+ "INSERT INTO registro_estoque (descricao, quantidade, data, id_produto, id_usuario) "
						+ "VALUES ('" + estoque.getDescricao() + "', -" + estoque.getQtd() + ", '" + convDataBanco()
						+ "', " + estoque.getIdProduto() + ", " + sessao.getId() + ")";
				try {
					BD.st = BD.con.prepareStatement(sql);
					BD.st.executeUpdate();

					retorno = true;
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.toString(), this.getClass().getName(), 0);
				}

			}
		}

		return retorno;
	}

	public boolean verificarEstoque(Estoque estoque, String acao) {
		boolean retorno = true;

		if (BD.conexao()) {
			String sql = "SELECT * FROM produto WHERE idproduto = '" + estoque.getIdProduto() + "'";

			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				BD.rs.next();

				if (acao == "adicionar") {
					int quantidade = BD.rs.getInt("quantidade") + estoque.getQtd();

					if (quantidade > BD.rs.getInt("qtdmax")) {
						JOptionPane.showMessageDialog(null,
								"O estoque deste produto não pode ser maior que " + BD.rs.getString("qtdmax"),
								"Estoque máximo", 2);
						retorno = false;
					}
				}

				if (acao == "remover") {
					int quantidade = BD.rs.getInt("quantidade") - estoque.getQtd();

					if (quantidade < BD.rs.getInt("qtdmin")) {
						JOptionPane.showMessageDialog(null,
								"O estoque deste produto não pode ser menor que " + BD.rs.getString("qtdmin"),
								"Estoque minímo", 2);
						retorno = false;
					} else if (quantidade == BD.rs.getInt("qtdreposicao")) {
						JOptionPane.showMessageDialog(null,
								"Atenção para este produto ele chegou na quantidade que necessita reposição", "Atenção",
								2);
					} else if (quantidade == BD.rs.getInt("qtdmin")) {
						JOptionPane.showMessageDialog(null, "Atenção para este produto ele chegou no minimo em estoque",
								"Atenção", 2);
					}
				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString(), "Erro ao verificar estoque", 0);
			}

		}

		return retorno;
	}

	public String convDataBanco() {

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		return dateFormat.format(date);

	}

}
