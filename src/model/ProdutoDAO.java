package model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

public class ProdutoDAO {
	
	private JTable tabela;
	
			public boolean cadastrar(Produto produto) {
			boolean retorno = false;
			if (BD.conexao()) {// Verificando se a conexão está estabelecida
			String sql = "INSERT INTO produto(nome, unidade, descricao, preco, tipo, idfornecedor)" 
			+ "VALUES ('" + produto.getNome() + "','"+ produto.getUnidade() + "','" + produto.getDescricao() + "','" + produto.getPreco()
			+ "','" + produto.getTipo() + "'," + "(SELECT idfornecedor FROM fornecedor where nomefantasia = '" + produto.getFornecedor() + "'))";

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso", "Sucesso no cadastro", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do produto", "Falha no cadastro", 0);
				}

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inserção do produto no banco", 0);
			}

		}
		return retorno;
}
			public boolean atualizar(Produto produto) {
				boolean retorno = false;
				if (BD.conexao()) {// Verificando se a conexão está estabelecida
				String sql = "UPDATE produto SET\r\n" + 
						"fornecedor = '" + produto.getFornecedor() + "',\r\n" + 
						"nome = '" + produto.getNome() + "',\r\n" +
						"unidade = '" + produto.getUnidade() + "',\r\n" +
						"descricao = '" + produto.getDescricao() + "',\r\n" +
						"preco = '" + produto.getPreco() + "',\r\n" + 
						"tipo = '" + produto.getTipo() + "',\r\n" + 
						"WHERE idproduto = '" + produto.getIdproduto() + "'";

				try {
					BD.st = BD.con.prepareStatement(sql);
					if (BD.st.executeUpdate() == 1) {
						JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso", "Sucesso na atualizaçao",
								1);
						retorno = true;
					} else {
						JOptionPane.showMessageDialog(null, "Falha na atualizaço do produto", "Falha na atualizaçao",
								0);
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro.toString(), "Falha na atualizaçao do produto no banco", 0);
				}

			}
			return retorno;
	}
			
			public static ResultSet consultarForn() {
			ResultSet resultado = null;
			String sql = "SELECT nomefantasia FROM fornecedor ORDER BY nomefantasia";
			if (BD.conexao) {
				try {
					BD.st = BD.con.prepareStatement(sql);
					BD.rs = BD.st.executeQuery();
					resultado = BD.rs;
				}catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro.toString(), "Erro ao realizar a consulta de fornecedores", 0);
				}
			}
			return resultado;
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
							tabela.getColumnModel().getColumn(3).setPreferredWidth(140);
							tabela.getColumnModel().getColumn(4).setPreferredWidth(140);
							tabela.getColumnModel().getColumn(5).setPreferredWidth(140);
							tabela.getColumnModel().getColumn(6).setPreferredWidth(140);
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
