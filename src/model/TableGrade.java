package model;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import banco.BD;

public class TableGrade {
	private static Vector<String> cabecalho;
	private static Vector<Vector<String>> linhas;
	private static ResultSetMetaData rsmd;

	public static JTable getTable(String sql, Vector<String> cabecalhoPersonalizado) {
		JTable table;
		try {
			cabecalho = cabecalhoPersonalizado;

			linhas = new Vector<Vector<String>>();

			BD.st = BD.con.prepareStatement(sql);
			BD.rs = BD.st.executeQuery();
			BD.rs.next();

			// busca metadados
			rsmd = BD.rs.getMetaData();

			// busca dados das linhas
			do {

				Vector<String> linhaAtual = new Vector<String>();
				DecimalFormat df = new DecimalFormat("R$ 00.00");
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {

					switch (rsmd.getColumnType(i)) {

					case Types.LONGVARCHAR:
						linhaAtual.addElement(BD.rs.getString(i));
						break;
					case Types.BIT:
						linhaAtual.addElement(BD.rs.getString(i));
						break;
					case Types.VARCHAR:
						linhaAtual.addElement(BD.rs.getString(i));
						break;
					case Types.CHAR:
						linhaAtual.addElement(BD.rs.getString(i));
						break;
					case Types.DOUBLE:
						linhaAtual.addElement("" + BD.rs.getDouble(i));
						break;
					case Types.INTEGER:
						linhaAtual.addElement("" + BD.rs.getInt(i));
						break;
					case Types.NUMERIC:
						linhaAtual.addElement("" + df.format(BD.rs.getDouble(i)));
						break;
					case Types.SMALLINT:
						linhaAtual.addElement("" + BD.rs.getInt(i));
						break;
					case Types.DECIMAL:
						linhaAtual.addElement("" + BD.rs.getDouble(i));
						break;
					case Types.DATE:
						if (BD.rs.getDate(i) == null) {
							linhaAtual.addElement("Sem Data");
							break;
						} else {
							String s = new SimpleDateFormat("dd/MM/yyyy").format(BD.rs.getDate(i));// Tranformando data
																									// para BR
							linhaAtual.addElement(s);
							break;
						}
					case Types.TIMESTAMP:
						if (BD.rs.getDate(i) == null) {
							linhaAtual.addElement("Sem Data");
							break;
						} else {
							String s = new SimpleDateFormat("dd/MM/yyyy").format(BD.rs.getDate(i));// Tranformando data
																									// para BR
							linhaAtual.addElement(s);
							break;
						}
						// default:System.out.println(rsmd.getColumnType(i));
					}
				}
				linhas.addElement(linhaAtual);
			} while (BD.rs.next());

			table = new JTable(linhas, cabecalho) {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int rowIndex, int collIndex) {
					return false;
				}
			};
			table.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			table.setSelectionForeground(Color.WHITE);
			table.setSelectionBackground(CoresFontes.corBotão);
			table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			table.setFont(new Font("Arial", Font.ITALIC, 13));
			table.setBackground(Color.WHITE);
			table.setShowVerticalLines(true);
			table.setShowHorizontalLines(true);
			table.getTableHeader().setReorderingAllowed(false);
			table.setRowHeight(25);

			@SuppressWarnings("unused")
			JTableHeader header = table.getTableHeader();

		}

		catch (SQLException erro) {
			System.out.println(erro.toString());
			return null;
		}
		return table;
	}

}
