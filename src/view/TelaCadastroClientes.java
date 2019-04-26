package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Cliente;
import model.ClienteDAO;
import model.CoresFontes;
import model.Produto;
import model.WebServiceCep;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela é feito o cadastro e alteração de clientes
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
	private JLabel emailLabel;
	private JLabel telFixoLabel;
	private JLabel cidadeLabel;
	private JTextField ufText;
	private JFormattedTextField cepText;
	private JButton pesquisarCepButton;
	private JLabel cepLabel;
	private JLabel ufSP;
	private JTextField cpfText;
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
		idLabel.setBounds(10, 4, 55, 25);
		contentPane.add(idLabel);

		nomeLabel = new JLabel("Nome Cliente:");
		nomeLabel.setFont(CoresFontes.fonteStencil);
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setBounds(10, 32, 123, 25);
		contentPane.add(nomeLabel);

		bairroLabel = new JLabel("Bairro:");
		bairroLabel.setFont(CoresFontes.fonteStencil);
		bairroLabel.setForeground(Color.WHITE);
		bairroLabel.setBounds(10, 88, 74, 25);
		contentPane.add(bairroLabel);

		ruaLabel = new JLabel("Rua:");
		ruaLabel.setFont(CoresFontes.fonteStencil);
		ruaLabel.setForeground(Color.WHITE);
		ruaLabel.setBounds(10, 116, 65, 25);
		contentPane.add(ruaLabel);

		nLabel = new JLabel("N\u00FAmero:");
		nLabel.setFont(CoresFontes.fonteStencil);
		nLabel.setForeground(Color.WHITE);
		nLabel.setBounds(10, 172, 85, 25);
		contentPane.add(nLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(134, 4, 47, 25);
		contentPane.add(idText);
		idText.setColumns(10);

		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(134, 32, 240, 25);
		contentPane.add(nomeText);

		bairroText = new JTextField();
		bairroText.setEditable(false);
		bairroText.setColumns(10);
		bairroText.setBounds(85, 88, 289, 25);
		contentPane.add(bairroText);

		ruaText = new JTextField();
		ruaText.setEditable(false);
		ruaText.setColumns(10);
		ruaText.setBounds(85, 116, 230, 25);
		contentPane.add(ruaText);

		nText = new JTextField();
		nText.setColumns(10);
		nText.setBounds(85, 172, 47, 25);
		contentPane.add(nText);

		cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setForeground(Color.WHITE);
		cidadeLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cidadeLabel.setBounds(10, 144, 65, 25);
		contentPane.add(cidadeLabel);

		cidadeText = new JTextField();
		cidadeText.setEditable(false);
		cidadeText.setColumns(10);
		cidadeText.setBounds(85, 144, 164, 25);
		contentPane.add(cidadeText);

		telFixoLabel = new JLabel("TEL FIXO:");
		telFixoLabel.setForeground(Color.WHITE);
		telFixoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		telFixoLabel.setBounds(386, 61, 101, 25);
		contentPane.add(telFixoLabel);

		telCelularLabel = new JLabel("TEL CELULAR:");
		telCelularLabel.setForeground(Color.WHITE);
		telCelularLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		telCelularLabel.setBounds(386, 88, 105, 25);
		contentPane.add(telCelularLabel);

		telFixoText = new JFormattedTextField(model.Mascara.Mascara("(##) ####-####"));
		telFixoText.setColumns(10);
		telFixoText.setBounds(495, 60, 130, 26);
		contentPane.add(telFixoText);

		telCelularText = new JFormattedTextField(model.Mascara.Mascara("(##) #####-####"));
		telCelularText.setColumns(10);
		telCelularText.setBounds(495, 87, 130, 26);
		contentPane.add(telCelularText);

		emailLabel = new JLabel("E-MAIL:");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		emailLabel.setBounds(325, 116, 65, 25);
		contentPane.add(emailLabel);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(386, 116, 239, 25);
		contentPane.add(emailText);

		clientesSP = new JScrollPane();
		clientesSP.setBounds(0, 206, 633, 154);
		contentPane.add(clientesSP);

		limparButton = new JButton("Limpar");
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setForeground(Color.WHITE);
		limparButton.setBackground(CoresFontes.corBotão);
		limparButton.setBounds(495, 170, 130, 28);
		contentPane.add(limparButton);

		salvarButton = new JButton("Salvar");
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (nomeText.getText().equals("") || cepText.getText().equals("") || bairroText.getText().equals("") ||
					ruaText.getText().equals("") || cidadeText.getText().equals("") || nText.getText().equals("") ||
					ufText.getText().equals("") || cpfText.getText().equals("") || telFixoText.getText().equals("") ||
					telCelularText.getText().equals("") || emailText.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos não preenchidos", 2);
					} else {// Se todos os campos estiverem preenchidos cria o objeto usuario e seta os valores e manda cadastrar
						Cliente cliente = new Cliente(nomeText.getText(), cepText.getText(), bairroText.getText(),
								ruaText.getText(), cidadeText.getText(), nText.getText(), ufText.getText(), cpfText.getText(),
								telFixoText.getText(), telCelularText.getText(), emailText.getText());
						if (metodos.cadastrar(cliente)) {
							limpar(); // Se der sucesso no cadastro limpa os campos
						//	listarTabela(); //lista a tabela de produtos
						}
					}
				}
			});
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setBackground(CoresFontes.corBotão);
		salvarButton.setBounds(350, 170, 130, 28);
		contentPane.add(salvarButton);

		ufSP = new JLabel("UF:");
		ufSP.setForeground(Color.WHITE);
		ufSP.setFont(new Font("Stencil", Font.PLAIN, 16));
		ufSP.setBounds(165, 172, 36, 25);
		contentPane.add(ufSP);

		ufText = new JTextField();
		ufText.setEditable(false);
		ufText.setColumns(10);
		ufText.setBounds(202, 172, 47, 25);
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
		pesquisarCepButton.setBounds(217, 61, 32, 23);
		contentPane.add(pesquisarCepButton);

		cpfLabel = new JLabel("CPF:");
		cpfLabel.setForeground(Color.WHITE);
		cpfLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cpfLabel.setBounds(386, 32, 74, 25);
		contentPane.add(cpfLabel);

		cpfText = new JTextField();
		cpfText.setColumns(10);
		cpfText.setBounds(495, 32, 130, 25);
		contentPane.add(cpfText);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaCadastroClientes.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);
		
		JButton atualizarButton = new JButton("Atualizar");
		atualizarButton.setVisible(false);
		atualizarButton.setVerticalAlignment(SwingConstants.TOP);
		atualizarButton.setForeground(Color.WHITE);
		atualizarButton.setFont(new Font("Stencil", Font.PLAIN, 16));
		atualizarButton.setBackground(new Color(50, 0, 0));
		atualizarButton.setBounds(350, 170, 130, 28);
		contentPane.add(atualizarButton);
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

			JOptionPane.showMessageDialog(null, "Descrição do erro: " + WSC.getResultText());
		}
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
		telSecundText.setText("");
		emailText.setText("");

	}
}
