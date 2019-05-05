package model;

import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

public class PedidoDAO {

	private JTable tabela;
	Sessao sessao = Sessao.getInstance();

	public boolean cadastrar(Pedido pedido) {
		boolean retorno = false;

		if (BD.conexao) {

			String sql = "INSERT INTO pedido (tipopedido, mesa, status, idcliente, idusuario) \r\n" + "VALUES ('"
					+ pedido.getTipo() + "', '" + pedido.getMesa() + "', '" + pedido.getStatus() + "', "
					+ buscarIdCliente(pedido.getCliente()) + ", " + sessao.getId() + ")";

			try {
				BD.st = BD.con.prepareStatement(sql);
				if (BD.st.executeUpdate() == 1) {
					JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso", "Sucesso no cadastro", 1);
					retorno = true;
				} else {
					JOptionPane.showMessageDialog(null, "Falha no cadastro do pedido", "Falha no cadastro", 0);
				}

			} catch (SQLException erro) {
				JOptionPane.showMessageDialog(null, erro.toString(), "Falha na inserção do pedido no banco", 0);
			}

		}

		return retorno;
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
		tabela = null;

		if (BD.conexao) {
			try {
				BD.st = BD.con.prepareStatement(sql);
				BD.rs = BD.st.executeQuery();
				if (BD.rs.next()) {
					tabela = null;

					tabela = TableGrade.getTable(sql, cabecalhoPersonalizado);

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
		
		if(BD.conexao) {
			String sql = "SELECT idcliente FROM cliente WHERE nome = '"+cliente+"'";
			
			try {
				BD.st = BD.con.prepareStatement(sql);
				
				BD.rs = BD.st.executeQuery();
				
				if(BD.rs.next()) {
					retorno = BD.rs.getInt("idcliente");
				}
			} catch ( SQLException erro) {
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
}
