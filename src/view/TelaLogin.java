package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import banco.BD;
import model.CoresFontes;
import model.LoginDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela é feito o login no sistema, caso o login for bem sucedido
 *         e aberta a TelaPrincipal, caso não seja o usuario recebe mensagem de login incorreto
 *
 */

public class TelaLogin extends JFrame {

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel fundoLabel;
	private JTextField loginText;
	private JPasswordField senhaText;
	private JButton loginButton;
	private JButton cancelarButton;
	private JLabel senhaLabel;
	private JLabel loginLabel;

	LoginDAO metodo = new LoginDAO();

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							TelaLogin frame = new TelaLogin();
							frame.setVisible(true);
							break;
						}
					}
				} catch (Exception e) {
					// If Nimbus is not available, you can set the GUI to another look and feel.
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				BD.close();
				System.exit(0);
			}
		});
		setResizable(false);
		setBounds(100, 100, 355, 390);
		setLocationRelativeTo(null);
		setTitle("Buteco do mineiro");
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		loginLabel = new JLabel("Login:");
		loginLabel.setFont(CoresFontes.fonteStencil);
		loginLabel.setForeground(Color.WHITE);
		loginLabel.setBounds(56, 77, 75, 14);
		contentPane.add(loginLabel);

		senhaLabel = new JLabel("Senha:");
		senhaLabel.setFont(CoresFontes.fonteStencil);
		senhaLabel.setForeground(Color.WHITE);
		senhaLabel.setBounds(56, 139, 75, 14);
		contentPane.add(senhaLabel);

		loginText = new JTextField();
		loginText.setForeground(Color.WHITE);
		loginText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		loginText.setBackground(CoresFontes.fundoTransparente);
		loginText.setBounds(128, 71, 164, 20);
		contentPane.add(loginText);
		loginText.setColumns(10);

		senhaText = new JPasswordField();
		senhaText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getKeyCode() == KeyEvent.VK_ENTER) {
					if (metodo.logar(loginText.getText(), String.valueOf(senhaText.getPassword()))) {
						controller.Controle.abrirTela("TelaPrincipal");
						controller.Controle.login = false;
						dispose();
					}
				}
			}
		});
		senhaText.setForeground(Color.WHITE);
		senhaText.setBackground(CoresFontes.fundoTransparente);
		senhaText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		senhaText.setColumns(10);
		senhaText.setBounds(128, 133, 164, 20);
		contentPane.add(senhaText);

		loginButton = new JButton("Login");
		loginButton.setForeground(new Color(255, 255, 255));
		loginButton.setBackground(CoresFontes.corBotão);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (metodo.logar(loginText.getText(), String.valueOf(senhaText.getPassword()))) {
					controller.Controle.abrirTela("TelaPrincipal");
					controller.Controle.login = false;
					dispose();
				}
			}
		});
		loginButton.setFont(CoresFontes.fonteStencil);
		loginButton.setBounds(56, 206, 110, 23);
		contentPane.add(loginButton);

		cancelarButton = new JButton("Cancelar");
		cancelarButton.setForeground(Color.WHITE);
		cancelarButton.setBackground(CoresFontes.corBotão);
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BD.close();
				System.exit(0);
			}
		});
		cancelarButton.setFont(CoresFontes.fonteStencil);
		cancelarButton.setBounds(182, 206, 110, 23);
		contentPane.add(cancelarButton);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/assets/fundo.jpeg")));
		fundoLabel.setBounds(0, -44, 354, 441);
		contentPane.add(fundoLabel);

		BD.conexao();//Estabelece conexão com o banco
	}
}
