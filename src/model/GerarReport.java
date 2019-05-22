package model;

import java.util.Map;

import javax.swing.WindowConstants;

import banco.BD;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GerarReport {

	public static boolean geraRelatorio(String arquivo, Map<String, Object> parametros) throws JRException {
		boolean retorno = false;

		if (BD.conexao()) {// Verificando se a conexão está estabelecida

			JasperPrint print = JasperFillManager
					.fillReport(GerarReport.class.getResourceAsStream("/reports/" + arquivo), parametros, BD.con);
			JasperViewer jrviewer = new JasperViewer(print, false);
			jrviewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			jrviewer.setTitle("Funcionários");
			jrviewer.setVisible(true);
		}
		return retorno;
	}
}
