package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/**
 * 
 * @author MATIAS
 *
 * Nesta tela, temos o acesso a todas outras telas a partir das op��es no menu superior
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
				controller.Controle.principal = false;//Passa um false para a variavel boolean referente a tela
				controller.Controle.abrirTela("TelaLogin");//Abre a tela login
				dispose();//fecha  tela atual
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
				controller.Controle.principal = false;//Passa um false para a variavel boolean referente a tela
				controller.Controle.abrirTela("TelaLogin");//Abre a tela login
				dispose();//fecha  tela atual
			}
		});
		arquivoMenu.add(sairMenuItem);
		
		produtosMenu = new JMenu("Produtos");
		principalMenu.add(produtosMenu);
		
		cadastroMenuItem = new JMenuItem("Cadastro");
		cadastroMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.Controle.abrirTela("TelaCadastroProduto");//Abre a tela login
			}
		});
		produtosMenu.add(cadastroMenuItem);
		
		estoqueMenuItem = new JMenuItem("Estoque");
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
		
		
	}
}
