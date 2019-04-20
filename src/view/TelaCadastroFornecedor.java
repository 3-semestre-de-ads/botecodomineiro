package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.FornecedorDAO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.SwingConstants;
import java.awt.Font;

public class TelaCadastroFornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField idText;
	private JLabel idLabel;
	private JLabel fundoLabel;
	private JTextField razaoText;
	private JTextField nomeText;
	private JTextField cnpjText;
	private JTextField inscText;
	private JTextField cepText;
	private JTextField ufText;
	private JTextField paisText;
	private JTextField cidadeText;
	private JTextField ruaText;
	private JTextField bairroText;
	private JTextField numText;
	private JTextField telText;
	private JTextField emailText;
	private JButton salvarButton;
	private JButton atualizarButton;
	private JButton limparButton;
	private JTextField celularText;
	private JTable fornecedorTable;
	private JScrollPane fornecedorSP;
	
	FornecedorDAO metodos = new FornecedorDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFornecedor frame = new TelaCadastroFornecedor();
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
	public TelaCadastroFornecedor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.Controle.cadastrofornecedor = false;
			}
		});
		setBounds(100, 100, 639, 389);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		celularText = new JTextField();
		celularText.setColumns(10);
		celularText.setBounds(335, 145, 135, 25);
		contentPane.add(celularText);
		
		JLabel celularLabel = new JLabel("CELULAR:");
		celularLabel.setVerticalAlignment(SwingConstants.TOP);
		celularLabel.setForeground(Color.WHITE);
		celularLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		celularLabel.setBounds(248, 150, 85, 14);
		contentPane.add(celularLabel);
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(40, 5, 50, 25);
		contentPane.add(idText);
		idText.setColumns(10);
		
		idLabel = new JLabel("ID:");
		idLabel.setVerticalAlignment(SwingConstants.TOP);
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(10, 10, 46, 14);
		idLabel.setFont(CoresFontes.fonteStencil);
		contentPane.add(idLabel);
		
		razaoText = new JTextField();
		razaoText.setColumns(10);
		razaoText.setBounds(412, 40, 211, 25);
		contentPane.add(razaoText);
		
		JLabel razaoLabel = new JLabel("<html>Raz\u00E3o<br/>Social:<html/>");
		razaoLabel.setVerticalAlignment(SwingConstants.TOP);
		razaoLabel.setForeground(Color.WHITE);
		razaoLabel.setFont(CoresFontes.fonteStencil);
		razaoLabel.setBounds(345, 35, 64, 35);
		contentPane.add(razaoLabel);
		
		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(100, 40, 233, 25);
		contentPane.add(nomeText);
		
		JLabel nomeLabel = new JLabel("<html>Nome<br/> fantasia:</html>");
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLabel.setVerticalAlignment(SwingConstants.TOP);
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setFont(CoresFontes.fonteStencil);
		nomeLabel.setBounds(10, 35, 85, 35);
		contentPane.add(nomeLabel);
		
		cnpjText = new JTextField();
		cnpjText.setColumns(10);
		cnpjText.setBounds(150, 5, 183, 25);
		contentPane.add(cnpjText);
		
		JLabel cnpjLabel = new JLabel("CNPJ:");
		cnpjLabel.setVerticalAlignment(SwingConstants.TOP);
		cnpjLabel.setForeground(Color.WHITE);
		cnpjLabel.setFont(CoresFontes.fonteStencil);
		cnpjLabel.setBounds(100, 10, 46, 14);
		contentPane.add(cnpjLabel);
		
		inscText = new JTextField();
		inscText.setColumns(10);
		inscText.setBounds(446, 5, 177, 25);
		contentPane.add(inscText);
		
		JLabel inscLabel = new JLabel("Insc. estad:");
		inscLabel.setVerticalAlignment(SwingConstants.TOP);
		inscLabel.setForeground(Color.WHITE);
		inscLabel.setFont(CoresFontes.fonteStencil);
		inscLabel.setBounds(343, 10, 104, 14);
		contentPane.add(inscLabel);
		
		JLabel cepLabel = new JLabel("CEP:");
		cepLabel.setVerticalAlignment(SwingConstants.TOP);
		cepLabel.setForeground(Color.WHITE);
		cepLabel.setFont(CoresFontes.fonteStencil);
		cepLabel.setBounds(10, 80, 40, 14);
		contentPane.add(cepLabel);
		
		cepText = new JTextField();
		cepText.setColumns(10);
		cepText.setBounds(54, 75, 100, 25);
		contentPane.add(cepText);
		
		ufText = new JTextField();
		ufText.setColumns(10);
		ufText.setBounds(200, 75, 54, 25);
		contentPane.add(ufText);
		
		JLabel ufLabel = new JLabel("UF:");
		ufLabel.setVerticalAlignment(SwingConstants.TOP);
		ufLabel.setForeground(Color.WHITE);
		ufLabel.setFont(CoresFontes.fonteStencil);
		ufLabel.setBounds(164, 80, 38, 14);
		contentPane.add(ufLabel);
		
		paisText = new JTextField();
		paisText.setColumns(10);
		paisText.setBounds(315, 75, 84, 25);
		contentPane.add(paisText);
		
		JLabel paisLabel = new JLabel("PA\u00CDS:");
		paisLabel.setVerticalAlignment(SwingConstants.TOP);
		paisLabel.setForeground(Color.WHITE);
		paisLabel.setFont(CoresFontes.fonteStencil);
		paisLabel.setBounds(265, 80, 54, 14);
		contentPane.add(paisLabel);
		
		JLabel cidadeLabel = new JLabel("CIDADE:");
		cidadeLabel.setVerticalAlignment(SwingConstants.TOP);
		cidadeLabel.setForeground(Color.WHITE);
		cidadeLabel.setFont(CoresFontes.fonteStencil);
		cidadeLabel.setBounds(411, 80, 70, 14);
		contentPane.add(cidadeLabel);
		
		cidadeText = new JTextField();
		cidadeText.setColumns(10);
		cidadeText.setBounds(481, 75, 142, 25);
		contentPane.add(cidadeText);
		
		JLabel ruaLabel = new JLabel("RUA:");
		ruaLabel.setVerticalAlignment(SwingConstants.TOP);
		ruaLabel.setForeground(Color.WHITE);
		ruaLabel.setFont(CoresFontes.fonteStencil);
		ruaLabel.setBounds(10, 115, 40, 14);
		contentPane.add(ruaLabel);
		
		ruaText = new JTextField();
		ruaText.setColumns(10);
		ruaText.setBounds(54, 110, 200, 25);
		contentPane.add(ruaText);
		
		JLabel biarroLabel = new JLabel("BAIRRO:");
		biarroLabel.setVerticalAlignment(SwingConstants.TOP);
		biarroLabel.setForeground(Color.WHITE);
		biarroLabel.setFont(CoresFontes.fonteStencil);
		biarroLabel.setBounds(265, 115, 70, 14);
		contentPane.add(biarroLabel);
		
		bairroText = new JTextField();
		bairroText.setColumns(10);
		bairroText.setBounds(335, 110, 135, 25);
		contentPane.add(bairroText);
		
		JLabel numLabel = new JLabel("Num\u00BA:");
		numLabel.setVerticalAlignment(SwingConstants.TOP);
		numLabel.setForeground(Color.WHITE);
		numLabel.setFont(CoresFontes.fonteStencil);
		numLabel.setBounds(480, 115, 50, 14);
		contentPane.add(numLabel);
		
		numText = new JTextField();
		numText.setColumns(10);
		numText.setBounds(538, 110, 85, 25);
		contentPane.add(numText);
		
		JLabel telLabel = new JLabel("TELEFONE:");
		telLabel.setVerticalAlignment(SwingConstants.TOP);
		telLabel.setForeground(Color.WHITE);
		telLabel.setFont(CoresFontes.fonteStencil);
		telLabel.setBounds(10, 150, 89, 14);
		contentPane.add(telLabel);
		
		telText = new JTextField();
		telText.setColumns(10);
		telText.setBounds(100, 145, 135, 25);
		contentPane.add(telText);
		
		JLabel emailLabel = new JLabel("E-MAIL:");
		emailLabel.setVerticalAlignment(SwingConstants.TOP);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(CoresFontes.fonteStencil);
		emailLabel.setBounds(10, 185, 70, 14);
		contentPane.add(emailLabel);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(75, 180, 395, 25);
		contentPane.add(emailText);
		
		JScrollPane fornecedorSP = new JScrollPane();
		fornecedorSP.setBounds(0, 215, 633, 145);
		contentPane.add(fornecedorSP);
		
		salvarButton = new JButton("Cadastrar");
		salvarButton.setVerticalAlignment(SwingConstants.TOP);
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setBounds(483, 145, 140, 25);
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setBackground(CoresFontes.corBotão);
		contentPane.add(salvarButton);
		
		limparButton = new JButton("Limpar");
		limparButton.setVerticalAlignment(SwingConstants.TOP);
		limparButton.setForeground(Color.WHITE);
		limparButton.setBounds(483, 180, 140, 25);
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setBackground(CoresFontes.corBotão);
		contentPane.add(limparButton);
		
		atualizarButton = new JButton("Atualizar");
		atualizarButton.setVerticalAlignment(SwingConstants.TOP);
		atualizarButton.setVisible(false);
		atualizarButton.setForeground(Color.WHITE);
		atualizarButton.setBounds(483, 146, 134, 25);
		atualizarButton.setFont(CoresFontes.fonteStencil);
		atualizarButton.setBackground(CoresFontes.corBotão);
		contentPane.add(atualizarButton);
		
		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaCadastroFornecedor.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);
	}
	
	public void limpar() {
		idText.setText("");
		razaoText.setText("");
		nomeText.setText("");
		cnpjText.setText("");
		inscText.setText("");
		cepText.setText("");
		ufText.setText("");
		paisText.setText("");
		cidadeText.setText("");
		bairroText.setText("");
		numText.setText("");
		telText.setText("");
		emailText.setText("");
		
		ativarBotao(salvarButton);
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
		cabecalhoPersonalizado.addElement("Quantidade");

		String sql = "SELECT p.idproduto,\r\n" + 
				"	   f.nomefantasia fornecedor,\r\n" + 
				"       p.nome,\r\n" + 
				"       p.unidade,\r\n" + 
				"       p.descricao,\r\n" + 
				"       p.preco,\r\n" + 
				"       p.tipo,\r\n" + 
				"       p.quantidade AS Qtd\r\n" + 
				"FROM produto p INNER JOIN fornecedor f on p.idfornecedor = f.idfornecedor\r\n" + 
				"order by idproduto;";
		
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
		contentPane.add(fornecedorSP);
		contentPane.add(fornecedorSP);
		contentPane.updateUI();
		
	}
}
