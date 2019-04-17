package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.Usuario;
import model.UsuarioDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela é feito o cadastro e alteração de usuarios do sistema
 *
 */

public class TelaCadastroUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idText;
	private JTextField nomeText;
	private JTextField loginText;
	private JPasswordField senhaText;
	private JPasswordField confirmarText;
	private JScrollPane usersSP;
	private JTable userTable;
	private JRadioButton admRB;
	private JRadioButton userRB;
	private JLabel confirmarLabel;
	private JLabel senhaLabel;
	private JLabel nomeLabel;
	private JLabel loginLabel;
	private JLabel idLabel;
	private JLabel funcaoLabel;
	private JButton salvarButton;
	private JButton limparButton;
	private JLabel fundoLabel;
	private ButtonGroup funcao;

	UsuarioDAO metodos = new UsuarioDAO();
	private JButton atualizarButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario() {
		setTitle("Usuarios");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.Controle.cadastrousuario = false;
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
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(CoresFontes.fonteStencil);
		idLabel.setBounds(10, 11, 46, 14);
		contentPane.add(idLabel);

		nomeLabel = new JLabel("Nome:");
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setFont(CoresFontes.fonteStencil);
		nomeLabel.setBounds(10, 52, 95, 14);
		contentPane.add(nomeLabel);

		loginLabel = new JLabel("Login:");
		loginLabel.setForeground(Color.WHITE);
		loginLabel.setFont(CoresFontes.fonteStencil);
		loginLabel.setBounds(10, 77, 95, 14);
		contentPane.add(loginLabel);

		senhaLabel = new JLabel("Senha:");
		senhaLabel.setForeground(Color.WHITE);
		senhaLabel.setFont(CoresFontes.fonteStencil);
		senhaLabel.setBounds(10, 102, 116, 14);
		contentPane.add(senhaLabel);

		confirmarLabel = new JLabel("Confirmar senha:");
		confirmarLabel.setForeground(Color.WHITE);
		confirmarLabel.setFont(CoresFontes.fonteStencil);
		confirmarLabel.setBounds(10, 127, 166, 14);
		contentPane.add(confirmarLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(186, 4, 46, 25);
		contentPane.add(idText);
		idText.setColumns(10);

		nomeText = new JTextField();
		nomeText.setColumns(10);
		nomeText.setBounds(186, 45, 168, 25);
		contentPane.add(nomeText);

		loginText = new JTextField();
		loginText.setColumns(10);
		loginText.setBounds(186, 70, 108, 25);
		contentPane.add(loginText);

		senhaText = new JPasswordField();
		senhaText.setColumns(10);
		senhaText.setBounds(186, 95, 108, 25);
		contentPane.add(senhaText);

		confirmarText = new JPasswordField();
		confirmarText.setColumns(10);
		confirmarText.setBounds(186, 120, 108, 25);
		contentPane.add(confirmarText);

		admRB = new JRadioButton("Administrador");
		admRB.setForeground(Color.WHITE);
		admRB.setFont(CoresFontes.fonteStencil);
		admRB.setBackground(CoresFontes.fundoTransparente);
		admRB.setBounds(10, 176, 166, 23);
		contentPane.add(admRB);

		userRB = new JRadioButton("Atendente");
		userRB.setForeground(Color.WHITE);
		userRB.setFont(CoresFontes.fonteStencil);
		userRB.setBackground(CoresFontes.fundoTransparente);
		userRB.setBounds(186, 176, 134, 23);
		contentPane.add(userRB);

		funcaoLabel = new JLabel("Fun\u00E7\u00E3o");
		funcaoLabel.setFont(CoresFontes.fonteStencil);
		funcaoLabel.setForeground(Color.WHITE);
		funcaoLabel.setBounds(131, 150, 69, 19);
		contentPane.add(funcaoLabel);

		salvarButton = new JButton("Salvar");
		salvarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {// Veri
				if (nomeText.getText().equals("") || loginText.getText().equals("")
						|| String.valueOf(senhaText.getPassword()).equals("")
						|| String.valueOf(confirmarText.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos não preenchidos", 2);
				} else {// se todos os campos estiverem preenchidos cria o objeto usuario e seta os
						// valores e manda cadastrar
					
					Usuario usuario = new Usuario(loginText.getText(), String.valueOf(senhaText.getPassword()),
							nomeText.getText(), 1);
					if (funcao.isSelected(admRB.getModel()))
						usuario.setFuncao(1); // Se for adm seta 1
					if (funcao.isSelected(userRB.getModel()))
						usuario.setFuncao(0); // Se for atendente seta 0

					if (metodos.cadastrar(usuario))
						limpar(); // Se der sucesso no cadastro limpa os campos
						listarTabela();
					
				}
			}
		});
		salvarButton.setForeground(Color.WHITE);
		salvarButton.setFont(CoresFontes.fonteStencil);
		salvarButton.setBackground(CoresFontes.corBotão);
		salvarButton.setBounds(10, 206, 134, 23);
		contentPane.add(salvarButton);

		limparButton = new JButton("Limpar");
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		limparButton.setForeground(Color.WHITE);
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setBackground(CoresFontes.corBotão);
		limparButton.setBounds(174, 206, 134, 23);
		contentPane.add(limparButton);

		funcao = new ButtonGroup();
		funcao.add(admRB);
		funcao.add(userRB);
		funcao.setSelected(userRB.getModel(), true);

		atualizarButton = new JButton("Atualizar");
		atualizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Usuario usuario = null;

				if (String.valueOf(senhaText.getPassword()).equals("")) {
					if (nomeText.getText().equals("") || loginText.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos não preenchidos", 2);
					} else {
						int func = (funcao.getSelection().equals(admRB.getModel())) ? 1 : 0;
						usuario = new Usuario(Integer.parseInt(idText.getText()), loginText.getText(),
								nomeText.getText(), func);

						if (metodos.atualizar(usuario)) {
							limpar();
							listarTabela();
						
						}
					}

				} else {
					if (nomeText.getText().equals("") || loginText.getText().equals("")
							|| String.valueOf(senhaText.getPassword()).equals("")
							|| String.valueOf(confirmarText.getPassword()).equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos não preenchidos", 2);
					} else {
						int func = (funcao.getSelection().equals(admRB.getModel())) ? 1 : 0;
						usuario = new Usuario(Integer.parseInt(idText.getText()), loginText.getText(),
								String.valueOf(senhaText.getPassword()), nomeText.getText(), func);

						if (metodos.atualizar(usuario)) {
							limpar();
							listarTabela();
					
						}
					}

				}

			}
		});
		atualizarButton.setVisible(false);
		atualizarButton.setForeground(Color.WHITE);
		atualizarButton.setFont(new Font("Stencil", Font.PLAIN, 16));
		atualizarButton.setBackground(new Color(50, 0, 0));
		atualizarButton.setBounds(10, 206, 134, 23);
		contentPane.add(atualizarButton);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);
		
		listarTabela();
	}

	public void ativarBotao(JButton botao) {
		if (botao.getModel().equals(salvarButton.getModel())) {
			salvarButton.setVisible(true);
			atualizarButton.setVisible(false);
		} else {
			salvarButton.setVisible(false);
			atualizarButton.setVisible(true);
		}
	}

	public void listarTabela() {

		Vector<String> cabecalhoPersonalizado = new Vector<>();
		cabecalhoPersonalizado.addElement("ID");
		cabecalhoPersonalizado.addElement("Login");
		cabecalhoPersonalizado.addElement("Nome");
		cabecalhoPersonalizado.addElement("Função");

		String sql = "SELECT id_usuario, login, nome, " 
		+ "CASE (funcao)"
		+ "WHEN 1 THEN 'Administrador' "
		+ "WHEN 0 THEN 'Atendente'" 
		+ "ELSE 'Campo vazio'" 
		+ "END AS Funcao \r\n " 
		+ "FROM usuario";
		
		if(userTable != null) {
			userTable.setVisible(false);
			userTable = null;
			usersSP.setVisible(false);		
			usersSP = null;
		}
		
		userTable = metodos.criarTabela(sql, cabecalhoPersonalizado);
		userTable.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent a) {
				idText.setText(userTable.getValueAt(userTable.getSelectedRow(), 0).toString());
				loginText.setText(userTable.getValueAt(userTable.getSelectedRow(), 1).toString());
				nomeText.setText(userTable.getValueAt(userTable.getSelectedRow(), 2).toString());

				if (userTable.getValueAt(userTable.getSelectedRow(), 3).toString().equals("Administrador")) {
					funcao.setSelected(admRB.getModel(), true);
				} else {
					funcao.setSelected(userRB.getModel(), true);
				}

				ativarBotao(atualizarButton);

			}
		});
		usersSP = new JScrollPane(userTable);
		usersSP.setBounds(378, 11, 249, 218);
		contentPane.remove(fundoLabel);
		contentPane.add(usersSP);
		contentPane.add(fundoLabel);
		contentPane.updateUI();

	}

	public void limpar() {
		idText.setText("");
		nomeText.setText("");
		loginText.setText("");
		senhaText.setText("");
		confirmarText.setText("");

		ativarBotao(salvarButton);
	}
}
