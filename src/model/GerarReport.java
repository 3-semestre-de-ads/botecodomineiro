package model;

import java.util.Map;

import javax.swing.JOptionPane;

import banco.BD;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GerarReport {

	public static boolean geraRelatorio(String arquivo, Map<String, Object> parametros) throws JRException {
		boolean retorno = false;

		if (BD.conexao()) {// Verificando se a conexão está estabelecida
			try {
				JasperPrint print = JasperFillManager
						.fillReport(GerarReport.class.getResourceAsStream("reports/" + arquivo), parametros, BD.con);
				JasperViewer jrviewer = new JasperViewer(print, false);
				jrviewer.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}
		return retorno;
	}
}
