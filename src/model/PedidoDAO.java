package model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

public class PedidoDAO {

	private JTable tabela;
	Sessao sessao = Sessao.getInstance();

	public boolean cadastrar(Pedido pedido) {

		if (BD.conexao) {

			String sql = "INSERT INTO pedido (tipopedido, mesa, status, idcliente, idusuario) \r\n" + "VALUES ('"
					+ pedido.getTipo() + "', '" + pedido.getMesa() + "', '" + pedido.getStatus() + "', "
					+ buscarIdCliente(pedido.getCliente()) + ", " + sessao.getId() + ")";

			try {
				BD.st = BD.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Comanda aberta com sucesso", "Comanda aberta", 1);
					BD.rs = BD.st.getGeneratedKeys();
					BD.rs.next();
					pedido.setIdPedido(BD.rs.getInt(1));
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha na abertura da comanda", "Falha", 0);
					return false;
				}

			} catch (SQLException erro) {
				erro.printStackTrace();
				return false;
			}

		} else {
			return false;
		}
	}

	public boolean inserirProdutoNaComanda(String idproduto, String idpedido, int qtd) {
		if (verificarEstoque(idproduto, qtd) == JOptionPane.YES_OPTION) {

			if (BD.conexao()) {
				String sql = "SELECT * FROM itens_pedido WHERE idpedido = " + idpedido + " AND idproduto = "
						+ idproduto;

				try {
					BD.st = BD.con.prepareStatement(sql);
					BD.rs = BD.st.executeQuery();

					if (BD.rs.next()) {
						int idItenPedido = BD.rs.getInt(1);
						int qtdAtual = BD.rs.getInt(6);

						sql = "UPDATE itens_pedido SET qtd = " + (qtdAtual + qtd) + " WHERE iditenpedido = "
								+ idItenPedido;

						BD.st = BD.con.prepareStatement(sql);

						if (BD.st.executeUpdate() == 1) {
							atualizarEstoque(idproduto, qtd);
							return true;
						} else {
							return false;

						}

					} else {
						sql = "INSERT INTO itens_pedido (statusitem, idproduto, idpedido, qtd) \r\n"
								+ "VALUES ('Registrado', " + idproduto + ", " + idpedido + ", " + qtd + ")";

						BD.st = BD.con.prepareStatement(sql);

						if (BD.st.executeUpdate() == 1) {
							atualizarEstoque(idproduto, qtd);
							return true;
						} else {
							return false;
						}
					}

				} catch (SQLException erro) {
					erro.printStackTrace();
					return false;
				}
			} else {
				return false;
			}

		} else {
			return false;
		}
	}

	public boolean removerProdutoDaComanda(String idproduto, String idpedido, String qtd) {
		if (BD.conexao()) {
			String sql = "SELECT * FROM itens_pedido WHERE idpedido = " + idpedido + " AND idproduto = " + idproduto;

			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				BD.rs.next();

				int idItenPedido = BD.rs.getInt(1);

				if (BD.rs.getString(6).equals(qtd)) {

					sql = "DELETE FROM itens_pedido WHERE iditenpedido = " + idItenPedido;
					BD.st = BD.con.prepareStatement(sql);

					if (BD.st.executeUpdate() == 1) {
						return true;
					} else {
						return false;
					}

				} else {
					sql = "UPDATE itens_pedido SET qtd = " + qtd + " WHERE iditenpedido = " + idItenPedido;
					BD.st = BD.con.prepareStatement(sql);

					if (BD.st.executeUpdate() == 1) {
						return true;
					} else {
						return false;
					}
				}

			} catch (SQLException erro) {
				erro.printStackTrace();
				return false;
			}
		} else {
			return false;
		}
	}

	public JTable criaTabelaProduto(String sql, Vector<String> cabecalhoPersonalizado) {
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
					tabela.getColumnModel().getColumn(2).setPreferredWidth(120);
					tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
					tabela.getColumnModel().getColumn(4).setPreferredWidth(315);
					tabela.getColumnModel().getColumn(5).setPreferredWidth(150);

					tabela.setEditingRow(0);
					tabela.setEditingColumn(0);
					tabela.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(),
						"Falha na consulta para criação da tabela produtos", 0);
			}
		}

		return tabela;

	}

	public JTable criaTabelaComandas(String sql, Vector<String> cabecalhoPersonalizado) {
		tabela = new JTable();

		if (BD.conexao) {
			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				if (BD.rs.next()) {
					tabela = null;

					tabela = TableGrade.getTable(sql, cabecalhoPersonalizado);

					tabela.getColumnModel().getColumn(0).setPreferredWidth(64);
					tabela.getColumnModel().getColumn(1).setPreferredWidth(90);
					tabela.getColumnModel().getColumn(2).setPreferredWidth(70);
					tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
					tabela.getColumnModel().getColumn(4).setPreferredWidth(160);
					tabela.getColumnModel().getColumn(5).setPreferredWidth(160);

					tabela.setEditingRow(0);
					tabela.setEditingColumn(0);
					tabela.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(),
						"Falha na consulta para criação da tabela produtos", 0);
			}
		}

		return tabela;
	}

	public int buscarIdCliente(String cliente) {
		int retorno = 0;

		if (BD.conexao) {
			String sql = "SELECT idcliente FROM cliente WHERE nome = '" + cliente + "'";

			try {
				BD.st = BD.con.prepareStatement(sql);

				BD.rs = BD.st.executeQuery();

				if (BD.rs.next()) {
					retorno = BD.rs.getInt("idcliente");
				}
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Falha na busca do id do cliente", "Falha na busca", 0);
			}

		}

		return retorno;
	}

	public ResultSet buscarClientes() {
		ResultSet retorno = null;

		if (BD.conexao) {
			String sql = "SELECT nome FROM cliente";

			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();

				retorno = BD.rs;
			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, "Falha ao listar clientes", "Falha listar clientes", 0);
			}
		}

		return retorno;
	}

	public ProdutosNaComandaModel buscarProdutoNaComanda(int idPedido) {
		ProdutosNaComandaModel modelo = new ProdutosNaComandaModel();

		String sql = "SELECT produto.idproduto, produto.nome, produto.unidade, produto.preco, itens_pedido.qtd, itens_pedido.statusitem \r\n"
				+ "FROM itens_pedido \r\n" + "INNER JOIN produto\r\n"
				+ "ON itens_pedido.idproduto = produto.idproduto\r\n" + "WHERE itens_pedido.idpedido = " + idPedido;

		if (BD.conexao()) {
			try {
				BD.st = BD.con.prepareStatement(sql);

				BD.rs = BD.st.executeQuery();

				while (BD.rs.next()) {
					ProdutoNaComanda p = new ProdutoNaComanda();

					p.setID(BD.rs.getInt(1));
					p.setProduto(BD.rs.getString(2));
					p.setUnidade(BD.rs.getString(3));
					p.setPreco(BD.rs.getDouble(4));
					p.setQuantidade(BD.rs.getInt(5));
					p.setStatus(BD.rs.getString(6));

					modelo.addRow(p);

				}
			} catch (SQLException erro) {

			}
		}

		return modelo;
	}

	public int verificarEstoque(String idProduto, int qtd) {
		if (BD.conexao()) {
			String sql = "SELECT quantidade, qtdmin, qtdreposicao FROM produto WHERE idproduto = " + idProduto;

			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				BD.rs.next();

				if ((BD.rs.getInt(1) - qtd) == BD.rs.getInt(3)) {
					JOptionPane.showMessageDialog(null,
							"Este produto chegou em seu ponto de reposição no estoque, entre em contato com o administrador");
					return JOptionPane.YES_OPTION;

				} else if ((BD.rs.getInt(1) - qtd) < BD.rs.getInt(2)) {
					return JOptionPane.showConfirmDialog(null,
							"Este produto já está abaixo do seu estoque mínimo \r\n"
									+ "deseja realmente adicionar a comanda ?",
							"Selecione uma opção", JOptionPane.YES_NO_OPTION);

				} else if ((BD.rs.getInt(1) - qtd) == BD.rs.getInt(2)) {
					return JOptionPane.showConfirmDialog(null,
							"Este produto já está em seu estoque mínimo \r\n"
									+ "deseja realmente adicionar a comanda ?",
							"Selecione uma opção", JOptionPane.YES_NO_OPTION);
				} else {
					return JOptionPane.YES_OPTION;
				}

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString());
				return JOptionPane.NO_OPTION;
			}

		} else {
			return JOptionPane.NO_OPTION;
		}

	}

	public boolean atualizarEstoque(String idProduto, int qtd) {
		if (BD.conexao()) {
			String sql = "UPDATE produto SET quantidade = quantidade - " + qtd + " WHERE idproduto = " + idProduto;

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					return true;
				} else {
					return false;
				}

			} catch (SQLException erro) {
				return false;
			}

		} else {
			return false;
		}
	}
}
