package controller;

import javax.swing.JOptionPane;

import view.TelaCadastroClientes;
import view.TelaCadastroPedidos;
import view.TelaCadastroProduto;
import view.TelaCadastroUsuario;
import view.TelaLogin;
import view.TelaPrincipal;

/**
 * 
 * @author MATIAS
 *
 *	Classe para controle de navegação das telas
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
	
	
	public static void abrirTela(String tela) {
		switch (tela) {
		case "TelaPrincipal":
			
			if(principal == false) {//Verifica a variavel boolean referente a tela
				telaprincipal = new TelaPrincipal();//Instancia a tela caso a variavel esteja com false
				telaprincipal.setVisible(true);//Torna a tela visivel
				principal = true;//E passa true para a variavel boolean
					
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela já esta aberta");
				telaprincipal.toFront();//Joga a tela já aberta para frente
			}
			
			break;
		
		case "TelaLogin":
			
			if(login == false) {//Verifica a variavel boolean referente a tela
				telalogin = new TelaLogin();//Instancia a tela caso a variavel esteja com false
				telalogin.setVisible(true);//Torna a tela visivel
				login = true;//E passa true para a variavel boolean
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela já esta aberta");
				telalogin.toFront();//Joga a tela já aberta para frente
			}
			
			break;
			
		case "TelaCadastroProduto":
			
			if(cadastroproduto == false) {//Verifica a variavel boolean referente a tela
				if(model.Sessao.getFuncao() == 1) { //Verifica e controla o nivel de permissão do usuário
				telacadastroproduto = new TelaCadastroProduto();//Instancia a tela caso a variavel esteja com false
				telacadastroproduto.setVisible(true);//Torna a tela visivel
				cadastroproduto = true;//E passa true para a variavel boolean
				}else {
					JOptionPane.showMessageDialog(null, "Você não tem permissões para acessar esta tela.","Falha de permissão", 0);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela já esta aberta");
				telacadastroproduto.toFront();//Joga a tela já aberta para frente
			}
			
			break;
			
		case "TelaCadastroPedidos":
			
			if(cadastropedidos == false) {//Verifica a variavel boolean referente a tela
				telacadastropedidos = new TelaCadastroPedidos();//Instancia a tela caso a variavel esteja com false
				telacadastropedidos.setVisible(true);//Torna a tela visivel
				cadastropedidos = true;//E passa true para a variavel boolean
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela já esta aberta");
				telacadastropedidos.toFront();//Joga a tela já aberta para frente
			}
			
			break;
			
		case "TelaCadastroUsuario":
			
			if(cadastrousuario== false) {//Verifica a variavel boolean referente a tela
				if(model.Sessao.getFuncao() == 1) {//Verifica e controla o nivel de permissão do usuário
				telacadastrousuario = new TelaCadastroUsuario();//Instancia a tela caso a variavel esteja com false
				telacadastrousuario.setVisible(true);//Torna a tela visivel
				cadastrousuario = true;//E passa true para a variavel boolean
				}else {
					JOptionPane.showMessageDialog(null, "Você não tem permissões para acessar esta tela.","Falha de permissão", 0);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela já esta aberta");
				telacadastrousuario.toFront();//Joga a tela já aberta para frente
			}
			
			break;
			
		case "TelaCadastroClientes":
			
			if(cadastrocliente== false) {//Verifica a variavel boolean referente a tela
				telacadastrocliente = new TelaCadastroClientes();//Instancia a tela caso a variavel esteja com false
				telacadastrocliente.setVisible(true);//Torna a tela visivel
				cadastrocliente = true;//E passa true para a variavel boolean
			}else {
				JOptionPane.showMessageDialog(null, "Esta tela já esta aberta");
				telacadastrocliente.toFront();//Joga a tela já aberta para frente
			}
			
			break;
		default:
			break;
		}
	}
	
	public void finalizarSistema() {
		
	}
}
