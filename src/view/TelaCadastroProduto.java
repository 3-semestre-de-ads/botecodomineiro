package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.Produto;
import model.ProdutoDAO;

/**
 * 
 * @author MATIAS
 *
 * Nesta tela feita a visualização, cadastro e alteração dos produtos
 *
 */

public class TelaCadastroProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField idText;
	private JTextField produtoText;
	private JComboBox<String> unidadeCombo;
	private JTextArea descTextArea;
	private JLabel descLabel;
	private JLabel unidadeLabel;
	private JLabel produtoLabel;
	private JLabel idLabel;
	private JLabel fundoLabel;
	private JTextField precoText;
	private JLabel precoLabel;
	private JLabel tipoLabel;
	private JComboBox<String> tipoCombo;
	private JComboBox<String> fornecedorCombo;
	private JScrollPane produtosSP;
	private JButton salvarButton;
	private JButton cancelarButton;
	private JTable produtosTable;
	private JLabel fornecedorLabel;
	
	ProdutoDAO metodos = new ProdutoDAO();
	private JButton atualizarButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProduto frame = new TelaCadastroProduto();
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
	public TelaCadastroProduto() {
		setTitle("Cadastro de produto");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.Controle.cadastroproduto = false;//Passa um false para a variavel boolean referente a tela
				dispose();//fecha tela atual
			}
		});
		setBounds(100, 100, 639, 389);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		salvarButton = new JButton("Cadastrar");
		salvarButton.setVisible(true);
		salvarButton.setVerticalTextPosition(SwingConstants.TOP);
		salvarButton.setVerticalAlignment(SwingConstants.TOP);
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setBackground(CoresFontes.corBotão);
		salvarButton.setBounds(416, 110, 130, 25);
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (produtoText.getText().equals("") || unidadeCombo.getSelectedItem().equals(null) || descTextArea.getText().equals("")
					|| precoText.getText().equals("") || tipoCombo.getSelectedItem().equals(null) || fornecedorCombo.getSelectedItem().equals(null)
					|| unidadeCombo.getSelectedIndex()== 0	|| tipoCombo.getSelectedIndex()== 0 || fornecedorCombo.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos não preenchidos", 2);
				} else {// Se todos os campos estiverem preenchidos cria o objeto usuario e seta os valores e manda cadastrar
					Produto produto = new Produto(produtoText.getText(), String.valueOf(unidadeCombo.getSelectedItem()), descTextArea.getText(),
							Double.parseDouble(precoText.getText()), String.valueOf(tipoCombo.getSelectedItem()),
							String.valueOf(fornecedorCombo.getSelectedItem()));
					if (metodos.cadastrar(produto)) {
						limpar(); // Se der sucesso no cadastro limpa os campos
						listarTabela(); //lista a tabela de produtos
					}
				}
			}
		});
		contentPane.add(salvarButton);
		
		atualizarButton = new JButton("Atualizar");
		atualizarButton.setVerticalAlignment(SwingConstants.TOP);
		atualizarButton.setVisible(false);
		atualizarButton.setForeground(Color.WHITE);
		atualizarButton.setFont(new Font("Stencil", Font.PLAIN, 16));
		atualizarButton.setBackground(new Color(50, 0, 0));
		atualizarButton.setBounds(416, 110, 130, 25);
		atualizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (produtoText.getText().equals("") || unidadeCombo.getSelectedItem().equals(null) || descTextArea.getText().equals("")
					|| precoText.getText().equals("") || tipoCombo.getSelectedItem().equals(null) || fornecedorCombo.getSelectedItem().equals(null)
					|| unidadeCombo.getSelectedIndex()== 0	|| tipoCombo.getSelectedIndex()== 0 || fornecedorCombo.getSelectedIndex()==0){
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos não preenchidos", 2);
				} else {// Se todos os campos estiverem preenchidos cria o objeto usuario e seta os valores e manda cadastrar
					Produto produto = new Produto(Integer.parseInt(idText.getText()),produtoText.getText(), String.valueOf(unidadeCombo.getSelectedItem()), descTextArea.getText(),
							Double.parseDouble(precoText.getText()), String.valueOf(tipoCombo.getSelectedItem()),
							String.valueOf(fornecedorCombo.getSelectedItem()));
					if (metodos.atualizar(produto)) {
						limpar(); // Se der sucesso no cadastro limpa os campos
						listarTabela(); //lista a tabela de produtos
					}
				}
			}
		});
		contentPane.add(atualizarButton);
		
		fornecedorLabel = new JLabel("Fornecedor:");
		fornecedorLabel.setForeground(Color.WHITE);
		fornecedorLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		fornecedorLabel.setBounds(248, 60, 110, 14);
		contentPane.add(fornecedorLabel);
		
		fornecedorCombo = new JComboBox<String>();
		fornecedorCombo.setModel(new DefaultComboBoxModel(new String[] {"Selecione"}));
		ResultSet consultarFornRS = ProdutoDAO.consultarForn();
			try {
				while(consultarFornRS.next()) {
					fornecedorCombo.addItem(consultarFornRS.getString(1));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		fornecedorCombo.setBounds(361, 55, 264, 25);
		contentPane.add(fornecedorCombo);
		
		idText = new JTextField();
		idText.setBounds(105, 10, 45, 25);
		idText.setEditable(false);
		contentPane.add(idText);
		idText.setColumns(10);
		
		produtoText = new JTextField();
		produtoText.setColumns(10);
		produtoText.setBounds(105, 40, 133, 25);
		contentPane.add(produtoText);
		
		unidadeCombo = new JComboBox<String>();
		unidadeCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione", "Litro", "Saco", "Prato P", "Prato M", "Prato G", "Por\u00E7\u00E3o P", "Por\u00E7\u00E3o M", "Por\u00E7\u00E3o G"}));
		unidadeCombo.setBounds(105, 70, 133, 25);
		contentPane.add(unidadeCombo);
		
		descTextArea = new JTextArea();
		descTextArea.setBounds(105, 100, 225, 80);
		contentPane.add(descTextArea);
		
		idLabel = new JLabel("ID:");
		idLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(10, 15, 56, 14);
		contentPane.add(idLabel);
		
		produtoLabel = new JLabel("Produto:");
		produtoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		produtoLabel.setForeground(Color.WHITE);
		produtoLabel.setBounds(10, 45, 85, 14);
		contentPane.add(produtoLabel);
		
		unidadeLabel = new JLabel("Unidade:");
		unidadeLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		unidadeLabel.setForeground(Color.WHITE);
		unidadeLabel.setBounds(10, 75, 80, 14);
		contentPane.add(unidadeLabel);
		
		descLabel = new JLabel("Descri\u00E7\u00E3o:");
		descLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		descLabel.setForeground(Color.WHITE);
		descLabel.setBounds(10, 133, 95, 14);
		contentPane.add(descLabel);
		
		precoText = new JTextField();
		precoText.setColumns(10);
		precoText.setBounds(290, 10, 135, 25);
		contentPane.add(precoText);
		
		precoLabel = new JLabel("Pre\u00E7o:");
		precoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		precoLabel.setForeground(Color.WHITE);
		precoLabel.setBounds(227, 15, 56, 14);
		contentPane.add(precoLabel);
		
		tipoLabel = new JLabel("Tipo:");
		tipoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		tipoLabel.setForeground(Color.WHITE);
		tipoLabel.setBounds(435, 15, 56, 14);
		contentPane.add(tipoLabel);
		
		tipoCombo = new JComboBox<String>();
		tipoCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"Selecione", "Alimentos", "Bebidas Alcolicas", "Bebidas N\u00E3o Alcolicas"}));
		tipoCombo.setBounds(491, 10, 133, 25);
		contentPane.add(tipoCombo);
		
		cancelarButton = new JButton("Limpar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		cancelarButton.setVerticalTextPosition(SwingConstants.TOP);
		cancelarButton.setVerticalAlignment(SwingConstants.TOP);
		cancelarButton.setForeground(Color.WHITE);
		cancelarButton.setFont(CoresFontes.fonteStencil);
		cancelarButton.setBackground(CoresFontes.corBotão);
		cancelarButton.setBounds(416, 145, 130, 25);
		contentPane.add(cancelarButton);
		
		fundoLabel = new JLabel("");
		fundoLabel.setBounds(0, 0, 634, 361);
		fundoLabel.setIcon(new ImageIcon(TelaCadastroProduto.class.getResource("/assets/fundo com cerveja.jpeg")));
		contentPane.add(fundoLabel);
		
		listarTabela(); //lista a tabela de produtos
		}
	
	public void ativarBotao(JButton botao) {
		if (botao.getModel().equals(atualizarButton.getModel())) {
			salvarButton.setVisible(false);
			atualizarButton.setVisible(true);
		} else {
			salvarButton.setVisible(true);
			atualizarButton.setVisible(false);
		}
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
		produtosTable.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent a) {
				idText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 0).toString());
				fornecedorCombo.setSelectedItem(produtosTable.getValueAt(produtosTable.getSelectedRow(), 1).toString());
				produtoText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 2).toString());
				unidadeCombo.setSelectedItem(produtosTable.getValueAt(produtosTable.getSelectedRow(), 3).toString());
				descTextArea.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 4).toString());
				precoText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 5).toString());
				tipoCombo.setSelectedItem(produtosTable.getValueAt(produtosTable.getSelectedRow(), 6).toString());
				
				ativarBotao(atualizarButton);
			}
		});
		produtosSP = new JScrollPane(produtosTable);
		produtosSP.setBounds(0, 188, 634, 173);
		
		contentPane.remove(fundoLabel);
		contentPane.add(produtosSP);
		contentPane.add(fundoLabel);
		contentPane.updateUI();
		
	}
	public void limpar() {
		idText.setText("");
		produtoText.setText("");
		unidadeCombo.setSelectedIndex(0);
		descTextArea.setText("");
		precoText.setText("");
		tipoCombo.setSelectedIndex(0);
		fornecedorCombo.setSelectedIndex(0);
		
		ativarBotao(salvarButton);
	}
}
