package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.Fornecedor;
import model.FornecedorDAO;
import model.WebServiceCep;

/**
 * 
 * @author MATIAS E HEITOR
 *
 *         Nesta tela feita a visualiza��o, cadastro e altera��o dos
 *         fornecedores no sistema
 *
 */
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
	private JFormattedTextField cnpjText;
	private JTextField inscText;
	private JFormattedTextField cepText;
	private JButton pesquisarCepButton;
	private JTextField ufText;
	private JTextField paisText;
	private JTextField cidadeText;
	private JTextField ruaText;
	private JTextField bairroText;
	private JTextField numText;
	private JFormattedTextField telText;
	private JTextField emailText;
	private JButton salvarButton;
	private JButton atualizarButton;
	private JButton limparButton;
	private JFormattedTextField celularText;
	private JTable fornecedorTable;
	private JScrollPane fornecedorSP;
	private JLabel nomeLabel;
	private JLabel cepLabel;
	private JLabel ruaLabel;
	private JLabel telLabel;
	private JLabel emailLabel;
	private JLabel ufLabel;
	private JLabel paisLabel;
	private JLabel biarroLabel;
	private JLabel celularLabel;
	private JLabel numLabel;
	private JLabel cidadeLabel;
	private JLabel razaoLabel;
	private JLabel inscLabel;
	private JLabel cnpjLabel;

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
				controller.Controle.cadastrofornecedor = false;// Passa um false para a variavel boolean referente a
																// tela
				dispose();// fecha tela atual
			}
		});
		setBounds(100, 100, 639, 389);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		celularText = new JFormattedTextField(model.Mascara.Mascara("(##) #####-####"));
		celularText.setColumns(10);
		celularText.setBounds(335, 145, 135, 26);
		contentPane.add(celularText);

		celularLabel = new JLabel("CELULAR:");
		celularLabel.setVerticalAlignment(SwingConstants.TOP);
		celularLabel.setForeground(Color.WHITE);
		celularLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		celularLabel.setBounds(248, 151, 85, 14);
		contentPane.add(celularLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(40, 5, 50, 26);
		contentPane.add(idText);
		idText.setColumns(10);

		idLabel = new JLabel("ID:");
		idLabel.setVerticalAlignment(SwingConstants.TOP);
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(10, 11, 46, 14);
		idLabel.setFont(CoresFontes.fonteStencil);
		contentPane.add(idLabel);

		razaoText = new JTextField();
		razaoText.setColumns(10);
		razaoText.setBounds(412, 40, 211, 26);
		contentPane.add(razaoText);

		razaoLabel = new JLabel("<html>Raz\u00E3o<br/>Social:<html/>");
		razaoLabel.setVerticalAlignment(SwingConstants.TOP);
		razaoLabel.setForeground(Color.WHITE);
		razaoLabel.setFont(CoresFontes.fonteStencil);
		razaoLabel.setBounds(345, 36, 64, 35);
		contentPane.add(razaoLabel);

		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(100, 40, 233, 26);
		contentPane.add(nomeText);

		nomeLabel = new JLabel("<html>Nome<br/> fantasia:</html>");
		nomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nomeLabel.setVerticalAlignment(SwingConstants.TOP);
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setFont(CoresFontes.fonteStencil);
		nomeLabel.setBounds(10, 36, 85, 35);
		contentPane.add(nomeLabel);

		cnpjText = new JFormattedTextField(model.Mascara.Mascara("##.###.###/####-##"));
		cnpjText.setColumns(10);
		cnpjText.setBounds(150, 5, 183, 26);
		contentPane.add(cnpjText);

		cnpjLabel = new JLabel("CNPJ:");
		cnpjLabel.setVerticalAlignment(SwingConstants.TOP);
		cnpjLabel.setForeground(Color.WHITE);
		cnpjLabel.setFont(CoresFontes.fonteStencil);
		cnpjLabel.setBounds(100, 11, 46, 14);
		contentPane.add(cnpjLabel);

		inscText = new JTextField();
		inscText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "./-0987654321";

				/*
				 * Se o caractere digitado for um contido na String caracteres o caractere �
				 * removido atrav�s do m�todo consume
				 */
				if (!caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();

				}
			}
		});
		inscText.setColumns(10);
		inscText.setBounds(446, 5, 177, 26);
		contentPane.add(inscText);

		inscLabel = new JLabel("Insc. estad:");
		inscLabel.setVerticalAlignment(SwingConstants.TOP);
		inscLabel.setForeground(Color.WHITE);
		inscLabel.setFont(CoresFontes.fonteStencil);
		inscLabel.setBounds(343, 11, 104, 14);
		contentPane.add(inscLabel);

		cepLabel = new JLabel("CEP:");
		cepLabel.setVerticalAlignment(SwingConstants.TOP);
		cepLabel.setForeground(Color.WHITE);
		cepLabel.setFont(CoresFontes.fonteStencil);
		cepLabel.setBounds(10, 81, 40, 14);
		contentPane.add(cepLabel);

		cepText = new JFormattedTextField(model.Mascara.Mascara("#####-###"));
		cepText.setColumns(10);
		cepText.setBounds(54, 75, 72, 26);
		contentPane.add(cepText);

		pesquisarCepButton = new JButton("New button");
		pesquisarCepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaCep(cepText.getText());
			}
		});
		pesquisarCepButton.setBounds(130, 77, 32, 23);
		contentPane.add(pesquisarCepButton);

		ufText = new JTextField();
		ufText.setColumns(10);
		ufText.setBounds(200, 75, 54, 26);
		contentPane.add(ufText);

		ufLabel = new JLabel("UF:");
		ufLabel.setVerticalAlignment(SwingConstants.TOP);
		ufLabel.setForeground(Color.WHITE);
		ufLabel.setFont(CoresFontes.fonteStencil);
		ufLabel.setBounds(164, 81, 38, 14);
		contentPane.add(ufLabel);

		paisText = new JTextField();
		paisText.setColumns(10);
		paisText.setBounds(315, 75, 84, 26);
		contentPane.add(paisText);

		paisLabel = new JLabel("PA\u00CDS:");
		paisLabel.setVerticalAlignment(SwingConstants.TOP);
		paisLabel.setForeground(Color.WHITE);
		paisLabel.setFont(CoresFontes.fonteStencil);
		paisLabel.setBounds(265, 81, 54, 14);
		contentPane.add(paisLabel);

		cidadeLabel = new JLabel("CIDADE:");
		cidadeLabel.setVerticalAlignment(SwingConstants.TOP);
		cidadeLabel.setForeground(Color.WHITE);
		cidadeLabel.setFont(CoresFontes.fonteStencil);
		cidadeLabel.setBounds(411, 81, 70, 14);
		contentPane.add(cidadeLabel);

		cidadeText = new JTextField();
		cidadeText.setColumns(10);
		cidadeText.setBounds(481, 75, 142, 26);
		contentPane.add(cidadeText);

		ruaLabel = new JLabel("RUA:");
		ruaLabel.setVerticalAlignment(SwingConstants.TOP);
		ruaLabel.setForeground(Color.WHITE);
		ruaLabel.setFont(CoresFontes.fonteStencil);
		ruaLabel.setBounds(10, 116, 40, 14);
		contentPane.add(ruaLabel);

		ruaText = new JTextField();
		ruaText.setColumns(10);
		ruaText.setBounds(54, 110, 200, 26);
		contentPane.add(ruaText);

		biarroLabel = new JLabel("BAIRRO:");
		biarroLabel.setVerticalAlignment(SwingConstants.TOP);
		biarroLabel.setForeground(Color.WHITE);
		biarroLabel.setFont(CoresFontes.fonteStencil);
		biarroLabel.setBounds(265, 116, 70, 14);
		contentPane.add(biarroLabel);

		bairroText = new JTextField();
		bairroText.setColumns(10);
		bairroText.setBounds(335, 110, 135, 26);
		contentPane.add(bairroText);

		numLabel = new JLabel("Num\u00BA:");
		numLabel.setVerticalAlignment(SwingConstants.TOP);
		numLabel.setForeground(Color.WHITE);
		numLabel.setFont(CoresFontes.fonteStencil);
		numLabel.setBounds(480, 116, 50, 14);
		contentPane.add(numLabel);

		numText = new JTextField();
		numText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String caracteres = "0987654321";

				/*
				 * Se o caractere digitado for um contido na String caracteres o caractere �
				 * removido atrav�s do m�todo consume
				 */
				if (!caracteres.contains(arg0.getKeyChar() + "")) {
					arg0.consume();
				}
			}
		});
		numText.setColumns(10);
		numText.setBounds(538, 110, 85, 26);
		contentPane.add(numText);

		telLabel = new JLabel("TELEFONE:");
		telLabel.setVerticalAlignment(SwingConstants.TOP);
		telLabel.setForeground(Color.WHITE);
		telLabel.setFont(CoresFontes.fonteStencil);
		telLabel.setBounds(10, 151, 89, 14);
		contentPane.add(telLabel);

		telText = new JFormattedTextField(model.Mascara.Mascara("(##) ####-####"));
		telText.setColumns(10);
		telText.setBounds(100, 145, 135, 26);
		contentPane.add(telText);

		emailLabel = new JLabel("E-MAIL:");
		emailLabel.setVerticalAlignment(SwingConstants.TOP);
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(CoresFontes.fonteStencil);
		emailLabel.setBounds(10, 186, 70, 14);
		contentPane.add(emailLabel);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(75, 180, 395, 26);
		contentPane.add(emailText);

		salvarButton = new JButton("Cadastrar");
		salvarButton.setVerticalAlignment(SwingConstants.TOP);
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setBounds(483, 146, 140, 25);
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setBackground(CoresFontes.corBot�o);
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (razaoText.getText().replaceAll(" ", "").equals("")
						|| nomeText.getText().replaceAll(" ", "").equals("")
						|| cnpjText.getText().replaceAll(" ", "").equals("")
						|| inscText.getText().replaceAll(" ", "").equals("")
						|| cepText.getText().replaceAll(" ", "").equals("")
						|| ufText.getText().replaceAll(" ", "").equals("")
						|| paisText.getText().replaceAll(" ", "").equals("")
						|| cidadeText.getText().replaceAll(" ", "").equals("")
						|| ruaText.getText().replaceAll(" ", "").equals("")
						|| bairroText.getText().replaceAll(" ", "").equals("")
						|| numText.getText().replaceAll(" ", "").equals("")
						|| telText.getText().replaceAll(" ", "").equals("")
						|| celularText.getText().replaceAll(" ", "").equals("")
						|| emailText.getText().replaceAll(" ", "").equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos n�o preenchidos", 2);
				} else {// Se todos os campos estiverem preenchidos cria o objeto fornecedor e seta os
						// valores e manda cadastrar
					Fornecedor fornecedor = new Fornecedor(paisText.getText().trim(), cidadeText.getText().trim(),
							razaoText.getText().trim(), nomeText.getText().trim(), inscText.getText().trim(),
							cnpjText.getText().trim(), ufText.getText().trim(), ruaText.getText().trim(),
							telText.getText().trim(), numText.getText().trim(), bairroText.getText().trim(),
							emailText.getText().trim(), cepText.getText().trim(), celularText.getText().trim());
					if (metodos.cadastrar(fornecedor)) {
						limpar(); // Se der sucesso no cadastro limpa os campos
						listarTabela(); // lista a tabela de fornecedor
					}
				}
			}
		});
		contentPane.add(salvarButton);

		limparButton = new JButton("Limpar");
		limparButton.setVerticalAlignment(SwingConstants.TOP);
		limparButton.setForeground(Color.WHITE);
		limparButton.setBounds(483, 181, 140, 25);
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setBackground(CoresFontes.corBot�o);
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		contentPane.add(limparButton);

		atualizarButton = new JButton("Atualizar");
		atualizarButton.setVerticalAlignment(SwingConstants.TOP);
		atualizarButton.setVisible(false);
		atualizarButton.setForeground(Color.WHITE);
		atualizarButton.setBounds(483, 146, 134, 25);
		atualizarButton.setFont(CoresFontes.fonteStencil);
		atualizarButton.setBackground(CoresFontes.corBot�o);
		atualizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (razaoText.getText().replaceAll(" ", "").equals("")
						|| nomeText.getText().replaceAll(" ", "").equals("")
						|| cnpjText.getText().replaceAll(" ", "").equals("")
						|| inscText.getText().replaceAll(" ", "").equals("")
						|| cepText.getText().replaceAll(" ", "").equals("")
						|| ufText.getText().replaceAll(" ", "").equals("")
						|| paisText.getText().replaceAll(" ", "").equals("")
						|| cidadeText.getText().replaceAll(" ", "").equals("")
						|| ruaText.getText().replaceAll(" ", "").equals("")
						|| bairroText.getText().replaceAll(" ", "").equals("")
						|| numText.getText().replaceAll(" ", "").equals("")
						|| telText.getText().replaceAll(" ", "").equals("")
						|| celularText.getText().replaceAll(" ", "").equals("")
						|| emailText.getText().replaceAll(" ", "").equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos n�o preenchidos", 2);
				} else {// Se todos os campos estiverem preenchidos cria o objeto fornecedor e seta os
						// valores e manda atualizar
					Fornecedor fornecedor = new Fornecedor(Integer.parseInt(idText.getText().trim()),
							paisText.getText().trim(), cidadeText.getText().trim(), razaoText.getText().trim(),
							nomeText.getText().trim(), inscText.getText().trim(), cnpjText.getText().trim(),
							ufText.getText().trim(), ruaText.getText().trim(), telText.getText().trim(),
							numText.getText().trim(), bairroText.getText().trim(), emailText.getText().trim(),
							cepText.getText().trim(), celularText.getText().trim());
					if (metodos.atualizar(fornecedor)) {
						limpar(); // Se der sucesso na atualiza��o limpa os campos
						listarTabela(); // lista a tabela de fornecedor
					}
				}
			}
		});
		contentPane.add(atualizarButton);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaCadastroFornecedor.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);

		listarTabela(); // lista a tabela de fornecedor
	}

	public void buscaCep(String cep) {

		// Faz a busca para o cep 58043-280
		WebServiceCep WSC = WebServiceCep.searchCep(cep);
		// A ferramenta de busca ignora qualquer caracter que n?o seja n?mero.

		// caso a busca ocorra bem, imprime os resultados.
		if (WSC.wasSuccessful()) {
			ruaText.setText(WSC.getLogradouroFull());
			cidadeText.setText(WSC.getCidade());
			bairroText.setText(WSC.getBairro());
			ufText.setText(WSC.getUf());
			// caso haja problemas imprime as exce??es.
		} else {
			JOptionPane.showMessageDialog(null, "Erro numero: " + WSC.getResulCode());
			JOptionPane.showMessageDialog(null, "Descri��o do erro: " + WSC.getResultText());
			bairroText.setEditable(true);
			ruaText.setEditable(true);
			cidadeText.setEditable(true);
			ufText.setEditable(true);
			JOptionPane.showMessageDialog(null,
					"Devido a falha na valida��o do CEP, preencha os campos de endere�o manualmente!");
		}
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
		ruaText.setText("");
		bairroText.setText("");
		numText.setText("");
		telText.setText("");
		emailText.setText("");
		celularText.setText("");

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
		cabecalhoPersonalizado.addElement("Razao Social");
		cabecalhoPersonalizado.addElement("Insc. Estadual");
		cabecalhoPersonalizado.addElement("Nome Fantasia");
		cabecalhoPersonalizado.addElement("CNPJ");
		cabecalhoPersonalizado.addElement("Pais");
		cabecalhoPersonalizado.addElement("Estado");
		cabecalhoPersonalizado.addElement("CEP");
		cabecalhoPersonalizado.addElement("Cidade");
		cabecalhoPersonalizado.addElement("Bairro");
		cabecalhoPersonalizado.addElement("Rua");
		cabecalhoPersonalizado.addElement("N�mero");
		cabecalhoPersonalizado.addElement("E-mail");
		cabecalhoPersonalizado.addElement("Telefone");
		cabecalhoPersonalizado.addElement("Celular");

		String sql = "select idfornecedor ID,\r\n" + "	   razaosocial 'Razao Social',\r\n"
				+ "       inscestadual 'Insc. Estadual',\r\n" + "       nomefantasia 'Nome Fantasia',\r\n"
				+ "       cnpj,\r\n" + "       pais,\r\n" + "       estado,\r\n" + "       cep,\r\n"
				+ "       cidade,\r\n" + "       bairro,\r\n" + "       rua,\r\n" + "       numero,\r\n"
				+ "       email,\r\n" + "       telefone,\r\n" + "       celular\r\n"
				+ "from fornecedor order by nomefantasia;";

		if (fornecedorTable != null) {
			fornecedorTable.setVisible(false);
			fornecedorTable = null;
			fornecedorSP.setVisible(false);
			fornecedorSP = null;
		}

		fornecedorTable = metodos.criarTabela(sql, cabecalhoPersonalizado);
		fornecedorTable.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent a) {
				idText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 0).toString());
				razaoText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 1).toString());
				inscText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 2).toString());
				nomeText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 3).toString());
				cnpjText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 4).toString());
				paisText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 5).toString());
				ufText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 6).toString());
				cepText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 7).toString());
				cidadeText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 8).toString());
				bairroText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 9).toString());
				ruaText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 10).toString());
				numText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 11).toString());
				emailText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 12).toString());
				telText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 13).toString());
				celularText.setText(fornecedorTable.getValueAt(fornecedorTable.getSelectedRow(), 14).toString());

				ativarBotao(atualizarButton);
			}
		});
		fornecedorSP = new JScrollPane(fornecedorTable);
		fornecedorSP.setBounds(0, 215, 633, 145);

		contentPane.remove(fundoLabel);
		contentPane.add(fornecedorSP);
		contentPane.add(fundoLabel);
		contentPane.updateUI();
	}
}
