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
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaCadastroFornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField idText;
	private JLabel idLabel;
	private JLabel fundo;
	private JTextField razaoText;
	private JTextField nomeText;
	private JTextField cnpjText;
	private JTextField inscriText;
	private JTextField cepText;
	private JTextField ufText;
	private JTextField paisText;
	private JTextField cidadeText;
	private JTextField ruaText;
	private JTextField bairroText;
	private JTextField nText;
	private JTextField telText;
	private JTextField emialText;
	private JButton cadastrarButton;
	private JButton atualizarButton;
	private JButton limparButton;
	
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
		
		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(51, 5, 54, 25);
		contentPane.add(idText);
		idText.setColumns(10);
		
		idLabel = new JLabel("ID:");
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(10, 15, 46, 14);
		idLabel.setFont(CoresFontes.fonteStencil);
		contentPane.add(idLabel);
		
		razaoText = new JTextField();
		razaoText.setColumns(10);
		razaoText.setBounds(140, 30, 222, 25);
		contentPane.add(razaoText);
		
		JLabel razaoLabel = new JLabel("Raz\u00E3o Social:");
		razaoLabel.setForeground(Color.WHITE);
		razaoLabel.setFont(CoresFontes.fonteStencil);
		razaoLabel.setBounds(10, 40, 121, 14);
		contentPane.add(razaoLabel);
		
		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(140, 55, 121, 25);
		contentPane.add(nomeText);
		
		JLabel nomeLabel = new JLabel("Nome fantasia:");
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setFont(CoresFontes.fonteStencil);
		nomeLabel.setBounds(10, 65, 142, 14);
		contentPane.add(nomeLabel);
		
		cnpjText = new JTextField();
		cnpjText.setColumns(10);
		cnpjText.setBounds(60, 80, 183, 25);
		contentPane.add(cnpjText);
		
		JLabel cnpjLabel = new JLabel("CNPJ:");
		cnpjLabel.setForeground(Color.WHITE);
		cnpjLabel.setFont(CoresFontes.fonteStencil);
		cnpjLabel.setBounds(10, 90, 46, 14);
		contentPane.add(cnpjLabel);
		
		inscriText = new JTextField();
		inscriText.setColumns(10);
		inscriText.setBounds(385, 80, 121, 25);
		contentPane.add(inscriText);
		
		JLabel inscriLabel = new JLabel("Inscri\u00E7\u00E3o est.:");
		inscriLabel.setForeground(Color.WHITE);
		inscriLabel.setFont(CoresFontes.fonteStencil);
		inscriLabel.setBounds(255, 90, 142, 14);
		contentPane.add(inscriLabel);
		
		JLabel cepLabel = new JLabel("CEP:");
		cepLabel.setForeground(Color.WHITE);
		cepLabel.setFont(CoresFontes.fonteStencil);
		cepLabel.setBounds(10, 115, 54, 14);
		contentPane.add(cepLabel);
		
		cepText = new JTextField();
		cepText.setColumns(10);
		cepText.setBounds(60, 105, 99, 25);
		contentPane.add(cepText);
		
		ufText = new JTextField();
		ufText.setColumns(10);
		ufText.setBounds(200, 105, 54, 25);
		contentPane.add(ufText);
		
		JLabel ufLabel = new JLabel("UF:");
		ufLabel.setForeground(Color.WHITE);
		ufLabel.setFont(CoresFontes.fonteStencil);
		ufLabel.setBounds(164, 115, 38, 14);
		contentPane.add(ufLabel);
		
		paisText = new JTextField();
		paisText.setColumns(10);
		paisText.setBounds(315, 105, 54, 25);
		contentPane.add(paisText);
		
		JLabel paisLabel = new JLabel("PA\u00CDS:");
		paisLabel.setForeground(Color.WHITE);
		paisLabel.setFont(CoresFontes.fonteStencil);
		paisLabel.setBounds(265, 115, 54, 14);
		contentPane.add(paisLabel);
		
		JLabel cidadeLabel = new JLabel("CIDADE:");
		cidadeLabel.setForeground(Color.WHITE);
		cidadeLabel.setFont(CoresFontes.fonteStencil);
		cidadeLabel.setBounds(10, 140, 70, 14);
		contentPane.add(cidadeLabel);
		
		cidadeText = new JTextField();
		cidadeText.setColumns(10);
		cidadeText.setBounds(80, 130, 99, 25);
		contentPane.add(cidadeText);
		
		JLabel ruaLabel = new JLabel("RUA:");
		ruaLabel.setForeground(Color.WHITE);
		ruaLabel.setFont(CoresFontes.fonteStencil);
		ruaLabel.setBounds(10, 165, 54, 14);
		contentPane.add(ruaLabel);
		
		ruaText = new JTextField();
		ruaText.setColumns(10);
		ruaText.setBounds(60, 155, 119, 25);
		contentPane.add(ruaText);
		
		JLabel biarroLabel = new JLabel("BAIRRO:");
		biarroLabel.setForeground(Color.WHITE);
		biarroLabel.setFont(CoresFontes.fonteStencil);
		biarroLabel.setBounds(193, 140, 70, 14);
		contentPane.add(biarroLabel);
		
		bairroText = new JTextField();
		bairroText.setColumns(10);
		bairroText.setBounds(263, 130, 99, 25);
		contentPane.add(bairroText);
		
		JLabel nLabel = new JLabel("N\u00BA:");
		nLabel.setForeground(Color.WHITE);
		nLabel.setFont(CoresFontes.fonteStencil);
		nLabel.setBounds(193, 164, 38, 14);
		contentPane.add(nLabel);
		
		nText = new JTextField();
		nText.setColumns(10);
		nText.setBounds(229, 154, 54, 25);
		contentPane.add(nText);
		
		JLabel telLabel = new JLabel("TEL.:");
		telLabel.setForeground(Color.WHITE);
		telLabel.setFont(CoresFontes.fonteStencil);
		telLabel.setBounds(10, 190, 54, 14);
		contentPane.add(telLabel);
		
		telText = new JTextField();
		telText.setColumns(10);
		telText.setBounds(60, 180, 119, 25);
		contentPane.add(telText);
		
		JLabel emailLabel = new JLabel("E-MAIL:");
		emailLabel.setForeground(Color.WHITE);
		emailLabel.setFont(CoresFontes.fonteStencil);
		emailLabel.setBounds(191, 189, 70, 14);
		contentPane.add(emailLabel);
		
		emialText = new JTextField();
		emialText.setColumns(10);
		emialText.setBounds(255, 179, 119, 25);
		contentPane.add(emialText);
		
		JScrollPane fornecedoresSP = new JScrollPane();
		fornecedoresSP.setBounds(0, 216, 633, 144);
		contentPane.add(fornecedoresSP);
		
		cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.setForeground(Color.WHITE);
		cadastrarButton.setBounds(483, 140, 134, 23);
		cadastrarButton.setFont(CoresFontes.fonteStencil);
		cadastrarButton.setBackground(CoresFontes.corBotão);
		contentPane.add(cadastrarButton);
		
		limparButton = new JButton("Limpar");
		limparButton.setForeground(Color.WHITE);
		limparButton.setBounds(483, 186, 134, 23);
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setBackground(CoresFontes.corBotão);
		contentPane.add(limparButton);
		
		atualizarButton = new JButton("Atualizar");
		atualizarButton.setVisible(false);
		atualizarButton.setForeground(Color.WHITE);
		atualizarButton.setBounds(483, 140, 134, 23);
		atualizarButton.setFont(CoresFontes.fonteStencil);
		atualizarButton.setBackground(CoresFontes.corBotão);
		contentPane.add(atualizarButton);
		
		fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(TelaCadastroFornecedor.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundo.setBounds(0, 0, 633, 360);
		contentPane.add(fundo);
	}
}
