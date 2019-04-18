package controller;

import javax.swing.JOptionPane;

import model.Sessao;
import view.TelaCadastroClientes;
import view.TelaCadastroFornecedor;
import view.TelaCadastroPedidos;
import view.TelaCadastroProduto;
import view.TelaCadastroUsuario;
import view.TelaLogin;
import view.TelaPrincipal;

/**
 * 
 * @author MATIAS
 *
 *	Classe para controle de navega��o das telas
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
	
	public static void abrirTela(String tela) {
		Sessao sessao = Sessao.getInstance();
		
		switch (tela) {
		case "TelaPrincipal":
			
			if(principal == false) {//Verifica a variavel boolean referente a tela
				telaprincipal = new TelaPrincipal();//Instancia a tela caso a variavel esteja com false
				telaprincipal.setVisible(true);//Torna a tela visivel
				principal = true;//E passa true para a variavel boolean
					
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telaprincipal.toFront();//Joga a tela j� aberta para frente
			}
			
			break;
		
		case "TelaLogin":
			
			if(login == false) {//Verifica a variavel boolean referente a tela
				telalogin = new TelaLogin();//Instancia a tela caso a variavel esteja com false
				telalogin.setVisible(true);//Torna a tela visivel
				login = true;//E passa true para a variavel boolean
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telalogin.toFront();//Joga a tela j� aberta para frente
			}
			
			break;
			
		case "TelaCadastroProduto":
			
			if(cadastroproduto == false) {//Verifica a variavel boolean referente a tela
				if(sessao.getFuncao() == 1) { //Verifica e controla o nivel de permiss�o do usu�rio
				telacadastroproduto = new TelaCadastroProduto();//Instancia a tela caso a variavel esteja com false
				telacadastroproduto.setVisible(true);//Torna a tela visivel
				cadastroproduto = true;//E passa true para a variavel boolean
				}else {
					JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�es para acessar esta tela.","Falha de permiss�o", 0);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastroproduto.toFront();//Joga a tela j� aberta para frente
			}
			
			break;
			
		case "TelaCadastroPedidos":
			
			if(cadastropedidos == false) {//Verifica a variavel boolean referente a tela
				telacadastropedidos = new TelaCadastroPedidos();//Instancia a tela caso a variavel esteja com false
				telacadastropedidos.setVisible(true);//Torna a tela visivel
				cadastropedidos = true;//E passa true para a variavel boolean
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastropedidos.toFront();//Joga a tela j� aberta para frente
			}
			
			break;
			
		case "TelaCadastroUsuario":
			
			if(cadastrousuario== false) {//Verifica a variavel boolean referente a tela
				if(sessao.getFuncao() == 1) {//Verifica e controla o nivel de permiss�o do usu�rio
				telacadastrousuario = new TelaCadastroUsuario();//Instancia a tela caso a variavel esteja com false
				telacadastrousuario.setVisible(true);//Torna a tela visivel
				cadastrousuario = true;//E passa true para a variavel boolean
				}else {
					JOptionPane.showMessageDialog(null, "Voc� n�o tem permiss�es para acessar esta tela.","Falha de permiss�o", 0);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastrousuario.toFront();//Joga a tela j� aberta para frente
			}
			
			break;
			
		case "TelaCadastroClientes":
			
			if(cadastrocliente== false) {//Verifica a variavel boolean referente a tela
				telacadastrocliente = new TelaCadastroClientes();//Instancia a tela caso a variavel esteja com false
				telacadastrocliente.setVisible(true);//Torna a tela visivel
				cadastrocliente = true;//E passa true para a variavel boolean
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela j� esta aberta");
				telacadastrocliente.toFront();//Joga a tela j� aberta para frente
			}
			
			break;
			
		case "TelaCadastroFornecedor":

			if (cadastrofornecedor == false) {// Verifica a variavel boolean referente a tela
				if (sessao.getFuncao() == 1) {// Verifica e controla o nivel de permiss�o do usu�rio
					telacadastrofornecedor = new TelaCadastroFornecedor();// Instancia a tela caso a variavel esteja com false
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
			
		default:
			break;
		}
	}
	
	public void finalizarSistema() {
		
	}
}
