package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.Produto;
import model.ProdutoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * 
 * @author MATIAS
 *
 * Nesta tela feita a visualiza��o, cadastro e altera��o dos produtos
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
	private JScrollPane scrollPane;
	private JButton salvarButton;
	private JButton cancelarButton;
	
	String[] stringInicialCombo = {"Selecione"};
	ProdutoDAO metodos = new ProdutoDAO();

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
		
		idText = new JTextField();
		idText.setBounds(105, 10, 45, 25);
		idText.setEditable(false);
		contentPane.add(idText);
		idText.setColumns(10);
		
		produtoText = new JTextField();
		produtoText.setColumns(10);
		produtoText.setBounds(105, 40, 133, 25);
		contentPane.add(produtoText);
		
		unidadeCombo = new JComboBox(stringInicialCombo);
		unidadeCombo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Litro", "Saco", "Prato P", "Prato M", "Prato G", "Por\u00E7\u00E3o P", "Por\u00E7\u00E3o M", "Por\u00E7\u00E3o G"}));
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
		
		tipoCombo = new JComboBox(stringInicialCombo);
		tipoCombo.setModel(new DefaultComboBoxModel(new String[] {"Selecione", "Alimentos", "Bebidas Alcolicas", "Bebidas N\u00E3o Alcolicas"}));
		tipoCombo.setBounds(491, 10, 133, 25);
		contentPane.add(tipoCombo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 188, 634, 173);
		contentPane.add(scrollPane);
		
		cancelarButton = new JButton("Limpar");
		cancelarButton.setVerticalTextPosition(SwingConstants.TOP);
		cancelarButton.setVerticalAlignment(SwingConstants.TOP);
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idText.setText("");
				produtoText.setText("");
				unidadeCombo.setSelectedIndex(0);
				descTextArea.setText("");
				precoText.setText("");
				tipoCombo.setSelectedIndex(0);
				
			}
		});
		cancelarButton.setForeground(Color.WHITE);
		cancelarButton.setFont(CoresFontes.fonteStencil);
		cancelarButton.setBackground(CoresFontes.corBot�o);
		cancelarButton.setBounds(490, 155, 130, 25);
		contentPane.add(cancelarButton);
		
		salvarButton = new JButton("Cadastrar");
		salvarButton.setVerticalTextPosition(SwingConstants.TOP);
		salvarButton.setVerticalAlignment(SwingConstants.TOP);
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setBackground(CoresFontes.corBot�o);
		salvarButton.setBounds(345, 155, 130, 25);
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (produtoText.getText().equals("") || unidadeCombo.getSelectedItem().equals(null) || descTextArea.getText().equals("")
						|| precoText.getText().equals("") || tipoCombo.getSelectedItem().equals(null)|| unidadeCombo.getSelectedIndex()== 0 || tipoCombo.getSelectedIndex()== 0) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos n�o preenchidos", 2);
				} else {// Se todos os campos estiverem preenchidos cria o objeto usuario e seta os
						// valores e manda cadastrar
					Produto produto = new Produto(produtoText.getText(), String.valueOf(unidadeCombo.getSelectedItem()), descTextArea.getText(), Double.parseDouble(precoText.getText()), String.valueOf(tipoCombo.getSelectedItem()));
					
					if (metodos.cadastrar(produto)) limpar(); // Se der sucesso no  cadastro limpa os campos
				}
			}
		});
		contentPane.add(salvarButton);
		
		
		fundoLabel = new JLabel("");
		fundoLabel.setBounds(0, 0, 634, 361);
		fundoLabel.setIcon(new ImageIcon(TelaCadastroProduto.class.getResource("/assets/fundo com cerveja.jpeg")));
		contentPane.add(fundoLabel);
	}
	public void limpar() {
		produtoText.setText("");
		unidadeCombo.setSelectedItem("");
		descTextArea.setText("");
		precoText.setText("");
		tipoCombo.setSelectedItem("");
}
}
