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

import model.Cliente;
import model.ClienteDAO;
import model.CoresFontes;
import model.WebServiceCep;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela � feito o cadastro e altera��o de clientes
 *
 */

public class TelaCadastroClientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel idLabel;
	private JTextField idText;
	private JTextField nomeText;
	private JTextField bairroText;
	private JTextField ruaText;
	private JTextField nText;
	private JTextField cidadeText;
	private JTextField emailText;
	private JLabel nomeLabel;
	private JLabel bairroLabel;
	private JLabel ruaLabel;
	private JLabel nLabel;
	private JButton limparButton;
	private JButton salvarButton;
	private JButton atualizarButton;
	private JLabel fundoLabel;
	private JScrollPane clientesSP;
	private JTable clientesTable;
	private JLabel emailLabel;
	private JLabel telFixoLabel;
	private JLabel cidadeLabel;
	private JTextField ufText;
	private JFormattedTextField cepText;
	private JButton pesquisarCepButton;
	private JLabel cepLabel;
	private JLabel ufSP;
	private JFormattedTextField cpfText;
	private JLabel cpfLabel;
	private JFormattedTextField telFixoText;
	private JFormattedTextField telCelularText;
	private JLabel telCelularLabel;

	ClienteDAO metodos = new ClienteDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroClientes frame = new TelaCadastroClientes();
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
	public TelaCadastroClientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				controller.Controle.cadastrocliente = false;
			}
		});
		setBounds(100, 100, 639, 389);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		idLabel = new JLabel("ID:");
		idLabel.setFont(CoresFontes.fonteStencil);
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(10, 5, 55, 25);
		contentPane.add(idLabel);

		nomeLabel = new JLabel("Nome Cliente:");
		nomeLabel.setFont(CoresFontes.fonteStencil);
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setBounds(10, 33, 123, 25);
		contentPane.add(nomeLabel);

		bairroLabel = new JLabel("Bairro:");
		bairroLabel.setFont(CoresFontes.fonteStencil);
		bairroLabel.setForeground(Color.WHITE);
		bairroLabel.setBounds(10, 89, 74, 25);
		contentPane.add(bairroLabel);

		ruaLabel = new JLabel("Rua:");
		ruaLabel.setFont(CoresFontes.fonteStencil);
		ruaLabel.setForeground(Color.WHITE);
		ruaLabel.setBounds(10, 117, 65, 25);
		contentPane.add(ruaLabel);

		nLabel = new JLabel("N\u00FAmero:");
		nLabel.setFont(CoresFontes.fonteStencil);
		nLabel.setForeground(Color.WHITE);
		nLabel.setBounds(10, 173, 85, 25);
		contentPane.add(nLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(134, 4, 47, 26);
		contentPane.add(idText);
		idText.setColumns(10);

		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(134, 32, 240, 26);
		contentPane.add(nomeText);

		bairroText = new JTextField();
		bairroText.setEditable(false);
		bairroText.setColumns(10);
		bairroText.setBounds(85, 88, 289, 26);
		contentPane.add(bairroText);

		ruaText = new JTextField();
		ruaText.setEditable(false);
		ruaText.setColumns(10);
		ruaText.setBounds(85, 116, 230, 26);
		contentPane.add(ruaText);

		nText = new JTextField();
		nText.addKeyListener(new KeyAdapter() {
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
		nText.setColumns(10);
		nText.setBounds(85, 172, 47, 26);
		contentPane.add(nText);

		cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setForeground(Color.WHITE);
		cidadeLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cidadeLabel.setBounds(10, 145, 65, 25);
		contentPane.add(cidadeLabel);

		cidadeText = new JTextField();
		cidadeText.setEditable(false);
		cidadeText.setColumns(10);
		cidadeText.setBounds(85, 144, 164, 26);
		contentPane.add(cidadeText);

		telFixoLabel = new JLabel("TEL FIXO:");
		telFixoLabel.setForeground(Color.WHITE);
		telFixoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		telFixoLabel.setBounds(386, 61, 101, 25);
		contentPane.add(telFixoLabel);

		telCelularLabel = new JLabel("TEL CELULAR:");
		telCelularLabel.setForeground(Color.WHITE);
		telCelularLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		telCelularLabel.setBounds(386, 89, 105, 25);
		contentPane.add(telCelularLabel);

		telFixoText = new JFormattedTextField(model.Mascara.Mascara("(##) ####-####"));
		telFixoText.setColumns(10);
		telFixoText.setBounds(495, 60, 130, 26);
		contentPane.add(telFixoText);

		telCelularText = new JFormattedTextField(model.Mascara.Mascara("(##) #####-####"));
		telCelularText.setColumns(10);
		telCelularText.setBounds(495, 88, 130, 26);
		contentPane.add(telCelularText);

		emailLabel = new JLabel("E-MAIL:");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		emailLabel.setBounds(325, 117, 65, 25);
		contentPane.add(emailLabel);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(386, 117, 239, 25);
		contentPane.add(emailText);

		limparButton = new JButton("Limpar");
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setForeground(Color.WHITE);
		limparButton.setBackground(CoresFontes.corBot�o);
		limparButton.setBounds(495, 171, 130, 28);
		contentPane.add(limparButton);

		salvarButton = new JButton("Salvar");
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nomeText.getText().replaceAll(" ", "").equals("")
						|| cepText.getText().replaceAll(" ", "").equals("")
						|| bairroText.getText().replaceAll(" ", "").equals("")
						|| ruaText.getText().replaceAll(" ", "").equals("")
						|| cidadeText.getText().replaceAll(" ", "").equals("")
						|| nText.getText().replaceAll(" ", "").equals("")
						|| ufText.getText().replaceAll(" ", "").equals("")
						|| cpfText.getText().replaceAll(" ", "").equals("")
						|| telFixoText.getText().replaceAll(" ", "").equals("")
						|| telCelularText.getText().replaceAll(" ", "").equals("")
						|| emailText.getText().replaceAll(" ", "").equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos n�o preenchidos", 2);
				} else {// Se todos os campos estiverem preenchidos cria o objeto usuario e seta os
						// valores e manda cadastrar
					Cliente cliente = new Cliente(nomeText.getText().trim(), cepText.getText().trim(),
							bairroText.getText().trim(), ruaText.getText().trim(), cidadeText.getText().trim(),
							nText.getText().trim(), ufText.getText().trim(), cpfText.getText().trim(),
							telFixoText.getText().trim(), telCelularText.getText().trim(), emailText.getText().trim());
					if (metodos.cadastrar(cliente)) {
						limpar(); // Se der sucesso no cadastro limpa os campos
						listarTabela(); // lista a tabela de clientes
					}
				}
			}
		});
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setBackground(CoresFontes.corBot�o);
		salvarButton.setBounds(350, 171, 130, 28);
		contentPane.add(salvarButton);

		ufSP = new JLabel("UF:");
		ufSP.setForeground(Color.WHITE);
		ufSP.setFont(new Font("Stencil", Font.PLAIN, 16));
		ufSP.setBounds(165, 173, 36, 25);
		contentPane.add(ufSP);

		ufText = new JTextField();
		ufText.setEditable(false);
		ufText.setColumns(10);
		ufText.setBounds(202, 172, 47, 26);
		contentPane.add(ufText);

		cepLabel = new JLabel("CEP:");
		cepLabel.setForeground(Color.WHITE);
		cepLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cepLabel.setBounds(10, 61, 74, 25);
		contentPane.add(cepLabel);

		cepText = new JFormattedTextField(model.Mascara.Mascara("#####-###"));
		cepText.setColumns(10);
		cepText.setBounds(85, 60, 128, 26);
		contentPane.add(cepText);

		pesquisarCepButton = new JButton("New button");
		pesquisarCepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscaCep(cepText.getText());
			}
		});
		pesquisarCepButton.setBounds(217, 62, 32, 23);
		contentPane.add(pesquisarCepButton);

		cpfLabel = new JLabel("CPF:");
		cpfLabel.setForeground(Color.WHITE);
		cpfLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cpfLabel.setBounds(386, 33, 74, 25);
		contentPane.add(cpfLabel);

		cpfText = new JFormattedTextField(model.Mascara.Mascara("###.###.###-##"));
		cpfText.setColumns(10);
		cpfText.setBounds(495, 32, 130, 26);
		contentPane.add(cpfText);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaCadastroClientes.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);

		atualizarButton = new JButton("Atualizar");
		atualizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nomeText.getText().replaceAll(" ", "").equals("")
						|| cepText.getText().replaceAll(" ", "").equals("")
						|| bairroText.getText().replaceAll(" ", "").equals("")
						|| ruaText.getText().replaceAll(" ", "").equals("")
						|| cidadeText.getText().replaceAll(" ", "").equals("")
						|| nText.getText().replaceAll(" ", "").equals("")
						|| ufText.getText().replaceAll(" ", "").equals("")
						|| cpfText.getText().replaceAll(" ", "").equals("")
						|| telFixoText.getText().replaceAll(" ", "").equals("")
						|| telCelularText.getText().replaceAll(" ", "").equals("")
						|| emailText.getText().replaceAll(" ", "").equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos n�o preenchidos", 2);
				} else {// Se todos os campos estiverem preenchidos cria o objeto usuario e seta os
						// valores e manda cadastrar
					Cliente cliente = new Cliente(Integer.parseInt(idText.getText().trim()), nomeText.getText().trim(),
							cepText.getText().trim(), bairroText.getText().trim(), ruaText.getText().trim(),
							cidadeText.getText().trim(), nText.getText().trim(), ufText.getText().trim(),
							telFixoText.getText().trim(), telCelularText.getText().trim(), emailText.getText().trim());
					if (metodos.atualizar(cliente)) {
						limpar(); // Se der sucesso na atualiza��o limpa os campos
						listarTabela(); // lista a tabela de clientes
					}
				}
			}
		});
		atualizarButton.setVisible(false);
		atualizarButton.setVerticalAlignment(SwingConstants.TOP);
		atualizarButton.setForeground(Color.WHITE);
		atualizarButton.setFont(new Font("Stencil", Font.PLAIN, 16));
		atualizarButton.setBackground(new Color(50, 0, 0));
		atualizarButton.setBounds(350, 170, 130, 28);
		contentPane.add(atualizarButton);

		listarTabela(); // lista a tabela de clientes

	}

	public void buscaCep(String cep) {

		// Faz a busca para o cep 58043-280
		WebServiceCep WSC = WebServiceCep.searchCep(cep);
		/*
		 * A ferramenta de busca ignora qualquer caracter que n�o seja n�mero. Caso a
		 * busca ocorra bem, imprime os resultados. Se n�o tiver correspondencias,
		 * libera os campos para edi��o manual.
		 */
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

	/*
	 * M�todo que alterna entre o bot�o de cadastro e atualizar Quando a tabela
	 * recebe um clique de sele��o, ele � ativado
	 */
	public void ativarBotao(JButton botao) {
		if (botao.getModel().equals(atualizarButton.getModel())) {
			salvarButton.setVisible(false);
			atualizarButton.setVisible(true);
			/*
			 * Passa um false na edi��o do CPF, pois o mesmo � PK no Banco de Dados
			 */
			cpfText.setEditable(false);
		} else {
			salvarButton.setVisible(true);
			atualizarButton.setVisible(false);
			cpfText.setEditable(true);
		}
	}

	/*
	 * Limpa todos os campos do cadastro
	 */
	public void limpar() {
		idText.setText("");
		nomeText.setText("");
		cepText.setText("");
		bairroText.setText("");
		ruaText.setText("");
		nText.setText("");
		ufText.setText("");
		cidadeText.setText("");
		emailText.setText("");
		telFixoText.setText("");
		telCelularText.setText("");
		emailText.setText("");
		cpfText.setText("");
	}

	public void listarTabela() {

		Vector<String> cabecalhoPersonalizado = new Vector<>();
		cabecalhoPersonalizado.addElement("ID");
		cabecalhoPersonalizado.addElement("Nome");
		cabecalhoPersonalizado.addElement("CPF");
		cabecalhoPersonalizado.addElement("Telefone");
		cabecalhoPersonalizado.addElement("Celular");
		cabecalhoPersonalizado.addElement("E-mail");
		cabecalhoPersonalizado.addElement("CEP");
		cabecalhoPersonalizado.addElement("UF");
		cabecalhoPersonalizado.addElement("Cidade");
		cabecalhoPersonalizado.addElement("Bairro");
		cabecalhoPersonalizado.addElement("Rua");
		cabecalhoPersonalizado.addElement("N�mero");

		String sql = "select idcliente ID,\r\n" + "	   nome,\r\n" + "       cpf,\r\n" + "       telefoneFixo,\r\n"
				+ "       telefoneCelular,\r\n" + "       email,\r\n" + "       cep,\r\n" + "       uf,\r\n"
				+ "       cidade,\r\n" + "       bairro,\r\n" + "       rua,\r\n" + "       numero\r\n"
				+ "FROM cliente\r\n" + "ORDER BY nome;";

		if (clientesTable != null) {
			clientesTable.setVisible(false);
			clientesTable = null;
			clientesSP.setVisible(false);
			clientesSP = null;
		}

		clientesTable = metodos.criarTabela(sql, cabecalhoPersonalizado);
		clientesTable.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent a) {
				idText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 0).toString());
				nomeText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 1).toString());
				cpfText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 2).toString());
				telFixoText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 3).toString());
				telCelularText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 4).toString());
				emailText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 5).toString());
				cepText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 6).toString());
				ufText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 7).toString());
				cidadeText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 8).toString());
				bairroText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 9).toString());
				ruaText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 10).toString());
				nText.setText(clientesTable.getValueAt(clientesTable.getSelectedRow(), 11).toString());

				ativarBotao(atualizarButton);
			}
		});
		clientesSP = new JScrollPane(clientesTable);
		clientesSP.setBounds(0, 206, 633, 154);

		contentPane.remove(fundoLabel);
		contentPane.add(clientesSP);
		contentPane.add(fundoLabel);
		contentPane.updateUI();

	}
}
