package controller;

import javax.swing.JOptionPane;

import model.Sessao;
import view.TelaCadastroClientes;
import view.TelaCadastroFornecedor;
import view.TelaCadastroPedidos;
import view.TelaCadastroProduto;
import view.TelaCadastroUsuario;
import view.TelaEstoque;
import view.TelaLogin;
import view.TelaParametrosReportUsuario;
import view.TelaPrincipal;

/**
 * 
 * @author MATIAS
 *
 *         Classe usada para controle de acesso as telas
 *
 */

public class Controle {

	public static TelaPrincipal telaprincipal;
	public static boolean principal = false;
	public static TelaLogin telalogin;
	public static boolean login = false;
	public static TelaCadastroProduto telacadastroproduto;
	public static boolean cadastroproduto = false;
	public static TelaCadastroPedidos telacadastropedidos;
	public static boolean cadastropedidos = false;
	public static TelaCadastroUsuario telacadastrousuario;
	public static boolean cadastrousuario = false;
	public static TelaCadastroClientes telacadastrocliente;
	public static boolean cadastrocliente = false;
	public static TelaCadastroFornecedor telacadastrofornecedor;
	public static boolean cadastrofornecedor = false;
	public static TelaEstoque telaestoque;
	public static boolean estoquetela = false;
	public static TelaParametrosReportUsuario telaParametrosReportUsuario;
	public static boolean parametrosReportUsuario = false;

	/**
	 * Neste metodo abrirTela, e recebido como parametro o nome da tela a qual
	 * deseja ser aberta, feito um swtich case para verificar qual foi a tela
	 * solicitada a ser aberta quando encontrado, primeiro verifica a variavel
	 * booleana referente a tela, caso esta variavel esteja com true apresenta
	 * mensagem de que esta tela ja esta aberta e executa um metodo ToFront na tela,
	 * a colocando a frente, caso a variavel esteja com false, instanciamos a tela e
	 * usamos o metodo setVisible para que ela se torne visivel, e alimentamos a
	 * variavel booleana referente a esta tela com true;
	 * 
	 * @param parametro a qual e recebido o nome da tela, que deve ser executada
	 */
	public static void abrirTela(String tela) {
		Sessao sessao = Sessao.getInstance();

		switch (tela) {
		case "TelaPrincipal":

			if (principal == false) {// Verifica a variavel boolean referente a tela
				telaprincipal = new TelaPrincipal();// Instancia a tela caso a variavel esteja com false
				telaprincipal.setVisible(true);// Torna a tela visivel
				principal = true;// E passa true para a variavel boolean

			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telaprincipal.toFront();// Joga a tela j� aberta para frente
			}

			break;

		case "TelaLogin":

			if (login == false) {// Verifica a variavel boolean referente a tela
				telalogin = new TelaLogin();// Instancia a tela caso a variavel esteja com false
				telalogin.setVisible(true);// Torna a tela visivel
				login = true;// E passa true para a variavel boolean
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telalogin.toFront();// Joga a tela j� aberta para frente
			}

			break;

		case "TelaCadastroProduto":

			if (cadastroproduto == false) {// Verifica a variavel boolean referente a tela
				if (sessao.getFuncao() == 1) { // Verifica e controla o nivel de permiss�o do usu�rio
					telacadastroproduto = new TelaCadastroProduto();// Instancia a tela caso a variavel esteja com false
					telacadastroproduto.setVisible(true);// Torna a tela visivel
					cadastroproduto = true;// E passa true para a variavel boolean
				} else {
					JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�es para acessar esta tela.",
							"Falha de permiss�o", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastroproduto.toFront();// Joga a tela j� aberta para frente
			}

			break;

		case "TelaCadastroPedidos":

			if (cadastropedidos == false) {// Verifica a variavel boolean referente a tela
				telacadastropedidos = new TelaCadastroPedidos();// Instancia a tela caso a variavel esteja com false
				telacadastropedidos.setVisible(true);// Torna a tela visivel
				cadastropedidos = true;// E passa true para a variavel boolean
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastropedidos.toFront();// Joga a tela j� aberta para frente
			}

			break;

		case "TelaCadastroUsuario":

			if (cadastrousuario == false) {// Verifica a variavel boolean referente a tela
				if (sessao.getFuncao() == 1) {// Verifica e controla o nivel de permiss�o do usu�rio
					telacadastrousuario = new TelaCadastroUsuario();// Instancia a tela caso a variavel esteja com false
					telacadastrousuario.setVisible(true);// Torna a tela visivel
					cadastrousuario = true;// E passa true para a variavel boolean
				} else {
					JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�es para acessar esta tela.",
							"Falha de permiss�o", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastrousuario.toFront();// Joga a tela j� aberta para frente
			}

			break;

		case "TelaCadastroClientes":

			if (cadastrocliente == false) {// Verifica a variavel boolean referente a tela
				telacadastrocliente = new TelaCadastroClientes();// Instancia a tela caso a variavel esteja com false
				telacadastrocliente.setVisible(true);// Torna a tela visivel
				cadastrocliente = true;// E passa true para a variavel boolean
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastrocliente.toFront();// Joga a tela j� aberta para frente
			}

			break;

		case "TelaCadastroFornecedor":

			if (cadastrofornecedor == false) {// Verifica a variavel boolean referente a tela
				if (sessao.getFuncao() == 1) {// Verifica e controla o nivel de permiss�o do usu�rio
					telacadastrofornecedor = new TelaCadastroFornecedor();// Instancia a tela caso a variavel esteja com
																			// false
					telacadastrofornecedor.setVisible(true);// Torna a tela visivel
					cadastrofornecedor = true;// E passa true para a variavel boolean
				} else {
					JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�es para acessar esta tela.",
							"Falha de permiss�o", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastrofornecedor.toFront();// Joga a tela j� aberta para frente
			}

			break;

		case "TelaEstoque":

			if (estoquetela == false) {// Verifica a variavel boolean referente a tela
				if (sessao.getFuncao() == 1) {// Verifica e controla o nivel de permiss�o do usu�rio
					telaestoque = new TelaEstoque();// Instancia a tela caso a variavel esteja com
													// false
					telaestoque.setVisible(true);// Torna a tela visivel
					estoquetela = true;// E passa true para a variavel boolean
				} else {
					JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�es para acessar esta tela.",
							"Falha de permiss�o", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telaestoque.toFront();// Joga a tela j� aberta para frente
			}

			break;
		case "TelaParametrosReportUsuario":

			if (parametrosReportUsuario == false) {// Verifica a variavel boolean referente a tela
				if (sessao.getFuncao() == 1) {// Verifica e controla o nivel de permiss�o do usu�rio
					telaParametrosReportUsuario = new TelaParametrosReportUsuario();// Instancia a tela caso a variavel esteja com false
					telaParametrosReportUsuario.setVisible(true);// Torna a tela visivel
					parametrosReportUsuario = true;// E passa true para a variavel boolean
				} else {
					JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�es para acessar esta tela.",
							"Falha de permiss�o", 0);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telaParametrosReportUsuario.toFront();// Joga a tela j� aberta para frente
			}

			break;

		default:
			break;
		}

	}

}
