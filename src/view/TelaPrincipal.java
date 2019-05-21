package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela, temos o acesso a todas outras telas a partir das opções
 *         no menu superior, sendo tudo controlado pela clase Controle do pacote
 *         controller
 *
 */
public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar principalMenu;
	private JMenu arquivoMenu;
	private JMenuItem sairMenuItem;
	private JLabel fundoLabel;
	private JMenu produtosMenu;
	private JMenuItem cadastroMenuItem;
	private JMenuItem estoqueMenuItem;
	private JMenu pedidosMenu;
	private JMenuItem fazerPedidoMenuItem;
	private JMenu administracaoMenu;
	private JMenuItem usuariosMenuItem;
	private JMenuItem clientesMenuItem;
	private JMenuItem fornecedoresMenuItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.Controle.principal = false;// Passa um false para a variavel boolean referente a tela
				controller.Controle.abrirTela("TelaLogin");// Abre a tela login
				dispose();// fecha tela atual
			}
		});
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Buteco do mineiro");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/assets/fundo com cerveja Full HD.jpeg")));
		fundoLabel.setBounds(0, 0, 1280, 669);
		fundoLabel.setBackground(Color.RED);
		contentPane.add(fundoLabel);

		principalMenu = new JMenuBar();
		setJMenuBar(principalMenu);

		arquivoMenu = new JMenu("Arquivo");
		principalMenu.add(arquivoMenu);

		sairMenuItem = new JMenuItem("Sair");
		sairMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Controle.principal = false;// Passa um false para a variavel boolean referente a tela
				controller.Controle.abrirTela("TelaLogin");// Abre a tela login
				dispose();// fecha tela atual
			}
		});
		arquivoMenu.add(sairMenuItem);

		produtosMenu = new JMenu("Produtos");
		principalMenu.add(produtosMenu);

		cadastroMenuItem = new JMenuItem("Cadastro");
		cadastroMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.Controle.abrirTela("TelaCadastroProduto");
			}
		});
		produtosMenu.add(cadastroMenuItem);

		estoqueMenuItem = new JMenuItem("Estoque");
		estoqueMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.Controle.abrirTela("TelaEstoque");
			}
		});
		produtosMenu.add(estoqueMenuItem);

		pedidosMenu = new JMenu("Pedidos");
		principalMenu.add(pedidosMenu);

		fazerPedidoMenuItem = new JMenuItem("Fazer pedido");
		fazerPedidoMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.Controle.abrirTela("TelaCadastroPedidos");
			}
		});
		pedidosMenu.add(fazerPedidoMenuItem);

		administracaoMenu = new JMenu("Administra\u00E7\u00E3o");
		principalMenu.add(administracaoMenu);

		usuariosMenuItem = new JMenuItem("Usuarios");
		usuariosMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.Controle.abrirTela("TelaCadastroUsuario");
			}
		});
		administracaoMenu.add(usuariosMenuItem);

		clientesMenuItem = new JMenuItem("Clientes");
		clientesMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Controle.abrirTela("TelaCadastroClientes");
			}
		});
		administracaoMenu.add(clientesMenuItem);

		fornecedoresMenuItem = new JMenuItem("Fornecedores");
		fornecedoresMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.Controle.abrirTela("TelaCadastroFornecedor");
			}
		});
		administracaoMenu.add(fornecedoresMenuItem);

		JMenu relatoriosMenu = new JMenu("Relat\u00F3rios");
		principalMenu.add(relatoriosMenu);

		JMenuItem reportUsuariosMenuItem = new JMenuItem("Funcion\u00E1rios/Usu\u00E1rios");
		reportUsuariosMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.Controle.abrirTela("TelaParametrosReportUsuario");
			}
		});
		relatoriosMenu.add(reportUsuariosMenuItem);

	}
}
