package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controle;
import model.EstoqueDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaEstoque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idText;
	private JTextField produtoText;
	private JTextField precoText;
	private JTextField fornecedorText;
	private JTextField unidadeText;
	private JTextField tipoText;
	private JScrollPane produtosSP;
	private JTable produtosTable;
	private JLabel fundo;
	private JLabel idLabel;
	private JLabel produtoLabel;
	private JLabel unidadeLabel;
	private JLabel descLabel;
	private JTextArea descText;
	private JLabel precoLabel;
	private JLabel fornecedorLabel;
	private JLabel tipoLabel;
	
	EstoqueDAO metodos = new EstoqueDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque frame = new TelaEstoque();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaEstoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				Controle.estoquetela = false;
			}
		});
		setSize(1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		idLabel = new JLabel("ID:");
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		idLabel.setBounds(10, 16, 56, 14);
		contentPane.add(idLabel);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setColumns(10);
		idText.setBounds(105, 11, 45, 25);
		contentPane.add(idText);
		
		produtoLabel = new JLabel("Produto:");
		produtoLabel.setForeground(Color.WHITE);
		produtoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		produtoLabel.setBounds(10, 46, 85, 14);
		contentPane.add(produtoLabel);
		
		produtoText = new JTextField();
		produtoText.setEditable(false);
		produtoText.setColumns(10);
		produtoText.setBounds(105, 41, 133, 25);
		contentPane.add(produtoText);
		
		unidadeLabel = new JLabel("Unidade:");
		unidadeLabel.setForeground(Color.WHITE);
		unidadeLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		unidadeLabel.setBounds(10, 76, 80, 14);
		contentPane.add(unidadeLabel);
		
		descLabel = new JLabel("Descri\u00E7\u00E3o:");
		descLabel.setForeground(Color.WHITE);
		descLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		descLabel.setBounds(10, 134, 95, 14);
		contentPane.add(descLabel);
		
		descText = new JTextArea();
		descText.setEditable(false);
		descText.setBounds(105, 101, 225, 80);
		contentPane.add(descText);
		
		precoText = new JTextField();
		precoText.setEditable(false);
		precoText.setColumns(10);
		precoText.setBounds(290, 11, 135, 25);
		contentPane.add(precoText);
		
		tipoLabel = new JLabel("Tipo:");
		tipoLabel.setForeground(Color.WHITE);
		tipoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		tipoLabel.setBounds(435, 16, 56, 14);
		contentPane.add(tipoLabel);
		
		fornecedorLabel = new JLabel("Fornecedor:");
		fornecedorLabel.setForeground(Color.WHITE);
		fornecedorLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		fornecedorLabel.setBounds(248, 61, 110, 14);
		contentPane.add(fornecedorLabel);
		
		precoLabel = new JLabel("Pre\u00E7o:");
		precoLabel.setForeground(Color.WHITE);
		precoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		precoLabel.setBounds(224, 16, 56, 14);
		contentPane.add(precoLabel);
		
		fornecedorText = new JTextField();
		fornecedorText.setEditable(false);
		fornecedorText.setBounds(365, 58, 250, 25);
		contentPane.add(fornecedorText);
		fornecedorText.setColumns(10);
		
		unidadeText = new JTextField();
		unidadeText.setEditable(false);
		unidadeText.setColumns(10);
		unidadeText.setBounds(105, 71, 133, 25);
		contentPane.add(unidadeText);
		
		tipoText = new JTextField();
		tipoText.setEditable(false);
		tipoText.setColumns(10);
		tipoText.setBounds(482, 11, 133, 25);
		contentPane.add(tipoText);
		
		fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(TelaEstoque.class.getResource("/assets/fundo com cerveja Full HD.jpeg")));
		fundo.setBounds(0, 0, 1264, 681);
		contentPane.add(fundo);
	
		listarTabela();
	}
	
	public void listarTabela() {

		Vector<String> cabecalhoPersonalizado = new Vector<>();
		cabecalhoPersonalizado.addElement("ID");
		cabecalhoPersonalizado.addElement("Fornecedor");
		cabecalhoPersonalizado.addElement("Nome");
		cabecalhoPersonalizado.addElement("Unidade");
		cabecalhoPersonalizado.addElement("Descricao");
		cabecalhoPersonalizado.addElement("Preco");
		cabecalhoPersonalizado.addElement("Tipo");

		String sql = "SELECT p.idproduto,\r\n" + 
				"	   f.nomefantasia fornecedor,\r\n" + 
				"       p.nome,\r\n" + 
				"       p.unidade,\r\n" + 
				"       p.descricao,\r\n" + 
				"       p.preco,\r\n" + 
				"       p.tipo\r\n" + 
				"FROM produto p \r\n " +
				"INNER JOIN fornecedor f \r\n" + 
				"ON p.idfornecedor = f.idfornecedor\r\n" + 
				"ORDER BY idproduto;";
		
		if(produtosTable != null) {
			produtosTable.setVisible(false);
			produtosTable = null;
			produtosSP.setVisible(false);		
			produtosSP = null;
		}
		
		produtosTable = metodos.criarTabela(sql, cabecalhoPersonalizado);
		
		produtosSP = new JScrollPane(produtosTable);
		produtosSP.setBounds(0, 276, 1264, 405);
		
		contentPane.remove(fundo);
		contentPane.add(produtosSP);
		contentPane.add(fundo);
		contentPane.updateUI();
		
	}
}
