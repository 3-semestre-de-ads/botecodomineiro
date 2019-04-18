package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaCadastroFornecedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textField;
	private JLabel idLabel;
	private JLabel fundoLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(51, 5, 54, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		idLabel = new JLabel("ID:");
		idLabel.setForeground(Color.WHITE);
		idLabel.setBounds(10, 15, 46, 14);
		idLabel.setFont(CoresFontes.fonteStencil);
		contentPane.add(idLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 30, 222, 25);
		contentPane.add(textField_1);
		
		JLabel lblRazoSocial = new JLabel("Raz\u00E3o Social:");
		lblRazoSocial.setForeground(Color.WHITE);
		lblRazoSocial.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblRazoSocial.setBounds(10, 40, 121, 14);
		contentPane.add(lblRazoSocial);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 55, 121, 25);
		contentPane.add(textField_2);
		
		JLabel lblNomeFantasia = new JLabel("Nome fantasia:");
		lblNomeFantasia.setForeground(Color.WHITE);
		lblNomeFantasia.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblNomeFantasia.setBounds(10, 65, 142, 14);
		contentPane.add(lblNomeFantasia);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(60, 80, 183, 25);
		contentPane.add(textField_3);
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setForeground(Color.WHITE);
		lblCnpj.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblCnpj.setBounds(10, 90, 46, 14);
		contentPane.add(lblCnpj);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(385, 80, 121, 25);
		contentPane.add(textField_4);
		
		JLabel lblInscrioEst = new JLabel("Inscri\u00E7\u00E3o est.:");
		lblInscrioEst.setForeground(Color.WHITE);
		lblInscrioEst.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblInscrioEst.setBounds(255, 90, 142, 14);
		contentPane.add(lblInscrioEst);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblCep.setBounds(10, 115, 142, 14);
		contentPane.add(lblCep);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(60, 105, 99, 25);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(200, 105, 54, 25);
		contentPane.add(textField_6);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setForeground(Color.WHITE);
		lblUf.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblUf.setBounds(164, 115, 142, 14);
		contentPane.add(lblUf);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(315, 105, 54, 25);
		contentPane.add(textField_7);
		
		JLabel lblPas = new JLabel("PA\u00CDS:");
		lblPas.setForeground(Color.WHITE);
		lblPas.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblPas.setBounds(265, 115, 142, 14);
		contentPane.add(lblPas);
		
		JLabel lblCidade = new JLabel("CIDADE:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblCidade.setBounds(10, 140, 142, 14);
		contentPane.add(lblCidade);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(80, 130, 99, 25);
		contentPane.add(textField_8);
		
		JLabel lblRua = new JLabel("RUA:");
		lblRua.setForeground(Color.WHITE);
		lblRua.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblRua.setBounds(10, 165, 54, 14);
		contentPane.add(lblRua);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(60, 155, 119, 25);
		contentPane.add(textField_9);
		
		JLabel lblBairro = new JLabel("BAIRRO:");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblBairro.setBounds(193, 140, 142, 14);
		contentPane.add(lblBairro);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(263, 130, 99, 25);
		contentPane.add(textField_10);
		
		JLabel lblN = new JLabel("N\u00BA:");
		lblN.setForeground(Color.WHITE);
		lblN.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblN.setBounds(193, 164, 38, 14);
		contentPane.add(lblN);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(229, 154, 54, 25);
		contentPane.add(textField_11);
		
		JLabel lblTel = new JLabel("TEL.:");
		lblTel.setForeground(Color.WHITE);
		lblTel.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblTel.setBounds(10, 190, 54, 14);
		contentPane.add(lblTel);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(60, 180, 119, 25);
		contentPane.add(textField_12);
		
		JLabel lblEmail = new JLabel("E-MAIL:");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblEmail.setBounds(191, 189, 70, 14);
		contentPane.add(lblEmail);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(255, 179, 119, 25);
		contentPane.add(textField_13);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 216, 623, 134);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(398, 182, 90, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(510, 182, 90, 28);
		contentPane.add(btnNewButton_1);
		
		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaCadastroFornecedor.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 623, 350);
		contentPane.add(fundoLabel);
	}
}
