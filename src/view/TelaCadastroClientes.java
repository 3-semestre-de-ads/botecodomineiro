package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.WebServiceCep;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

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
	private JFormattedTextField telFixoText;
	private JFormattedTextField telCelText;
	private JTextField telSecundText;
	private JTextField emailText;
	private JLabel nomeLabel;
	private JLabel bairroLabel;
	private JLabel ruaLabel;
	private JLabel nLabel;
	private JButton limparButton;
	private JButton salvarButton;
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
	private JFormattedTextField telFixoText_1;
	private JFormattedTextField telCelText_1;
	private JLabel telSecundLabel;
	private JLabel telCelularLabel;

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
		idLabel.setBounds(10, 8, 55, 16);
		contentPane.add(idLabel);

		nomeLabel = new JLabel("Nome Cliente:");
		nomeLabel.setFont(CoresFontes.fonteStencil);
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setBounds(10, 36, 123, 16);
		contentPane.add(nomeLabel);

		bairroLabel = new JLabel("Bairro:");
		bairroLabel.setFont(CoresFontes.fonteStencil);
		bairroLabel.setForeground(Color.WHITE);
		bairroLabel.setBounds(10, 92, 74, 16);
		contentPane.add(bairroLabel);

		ruaLabel = new JLabel("Rua:");
		ruaLabel.setFont(CoresFontes.fonteStencil);
		ruaLabel.setForeground(Color.WHITE);
		ruaLabel.setBounds(10, 120, 65, 16);
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
		bairroText.setBounds(85, 88, 164, 25);
		contentPane.add(bairroText);

		ruaText = new JTextField();
		ruaText.setEditable(false);
		ruaText.setColumns(10);
		ruaText.setBounds(85, 116, 296, 25);
		contentPane.add(ruaText);

		nText = new JTextField();
		nText.setColumns(10);
		nText.setBounds(85, 172, 47, 25);
		contentPane.add(nText);

		cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setForeground(Color.WHITE);
		cidadeLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cidadeLabel.setBounds(10, 148, 65, 16);
		contentPane.add(cidadeLabel);

		cidadeText = new JTextField();
		cidadeText.setEditable(false);
		cidadeText.setColumns(10);
		cidadeText.setBounds(85, 144, 164, 25);
		contentPane.add(cidadeText);

		telFixoLabel = new JLabel("TEL FIXO:");
		telFixoLabel.setForeground(Color.WHITE);
		telFixoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		telFixoLabel.setBounds(386, 59, 101, 16);
		contentPane.add(telFixoLabel);

		telCelularLabel = new JLabel("TEL CELULAR:");
		telCelularLabel.setForeground(Color.WHITE);
		telCelularLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		telCelularLabel.setBounds(386, 87, 105, 16);
		contentPane.add(telCelularLabel);

		telSecundLabel = new JLabel("TEL SECUND:");
		telSecundLabel.setForeground(Color.WHITE);
		telSecundLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		telSecundLabel.setBounds(386, 115, 105, 16);
		contentPane.add(telSecundLabel);

		telFixoText_1 = new JFormattedTextField(model.Mascara.Mascara("(##) ####-####"));
		telFixoText_1.setColumns(10);
		telFixoText_1.setBounds(495, 55, 122, 26);
		contentPane.add(telFixoText_1);

		telCelText_1 = new JFormattedTextField(model.Mascara.Mascara("(##) #####-####"));
		telCelText_1.setColumns(10);
		telCelText_1.setBounds(495, 83, 122, 26);
		contentPane.add(telCelText_1);

		telSecundText = new JTextField();
		telSecundText.setColumns(10);
		telSecundText.setBounds(495, 111, 122, 25);
		contentPane.add(telSecundText);

		emailLabel = new JLabel("E-MAIL:");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		emailLabel.setBounds(386, 143, 101, 16);
		contentPane.add(emailLabel);

		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(495, 139, 122, 25);
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
		limparButton.setBounds(487, 170, 122, 28);
		contentPane.add(limparButton);

		salvarButton = new JButton("Salvar");
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setBackground(CoresFontes.corBotão);
		salvarButton.setBounds(350, 170, 122, 28);
		contentPane.add(salvarButton);

		ufSP = new JLabel("UF:");
		ufSP.setForeground(Color.WHITE);
		ufSP.setFont(new Font("Stencil", Font.PLAIN, 16));
		ufSP.setBounds(165, 176, 36, 16);
		contentPane.add(ufSP);

		ufText = new JTextField();
		ufText.setEditable(false);
		ufText.setColumns(10);
		ufText.setBounds(202, 172, 47, 25);
		contentPane.add(ufText);

		cepLabel = new JLabel("CEP:");
		cepLabel.setForeground(Color.WHITE);
		cepLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cepLabel.setBounds(10, 64, 74, 16);
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
		cpfLabel.setBounds(386, 35, 74, 16);
		contentPane.add(cpfLabel);

		cpfText = new JTextField();
		cpfText.setColumns(10);
		cpfText.setBounds(495, 29, 122, 25);
		contentPane.add(cpfText);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaCadastroClientes.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);
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
		telCelText.setText("");
		telSecundText.setText("");
		emailText.setText("");

	}
}
