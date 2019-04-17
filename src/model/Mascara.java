package model;

import javax.swing.text.MaskFormatter;
/*
 * @Author Heitor
 * Classe para definir mascaras nos campos JFormattedTextField
 */
public class Mascara {

	public static MaskFormatter Mascara(String Mascara) {
		MaskFormatter F_Mascara = new MaskFormatter();
		try {
			F_Mascara.setMask(Mascara); // Atribui a mascara
			F_Mascara.setPlaceholderCharacter('_'); // Caracter para preencimento
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return F_Mascara;
	}
}
