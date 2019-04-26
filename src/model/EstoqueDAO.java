package model;

import java.awt.Cursor;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import banco.BD;

public class EstoqueDAO {
	
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
					tabela.getColumnModel().getColumn(4).setPreferredWidth(300);
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
