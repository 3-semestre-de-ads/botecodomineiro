package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.Pedido;
import model.PedidoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela � possivel, visualizar pedidos, fazer pedidos e
 *         atualiza-los.
 *
 */

public class TelaCadastroPedidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idText;
	private JLabel idLabel;
	private JLabel clienteLabel;
	private JLabel mesaLabel;
	private JLabel tipoLabel;
	private JLabel statusLabel;
	private JComboBox<String> clienteCombo;
	private JComboBox<String> mesaCombo;
	private JComboBox<String> tipoCombo;
	private JComboBox<String> statusCombo;
	private JTable produtosTabela;
	private JLabel produtosLabel;
	private JScrollPane produtosSP;
	private JLabel fundoLabel;
	private JTable comandaTabela;
	private JLabel produtosComandaLabel;
	private JScrollPane produtosComandaSP;
	private JLabel comandasLabel;
	private JScrollPane comandasSP;
	private JButton fazerEAtualizarPedidoButton;
	private JButton limparButton;
	private JTextField precoText;
	private JLabel precoTotalLabel;

	PedidoDAO metodos = new PedidoDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPedidos frame = new TelaCadastroPedidos();
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
	public TelaCadastroPedidos() {
		setTitle("Pedidos");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.Controle.cadastropedidos = false;
				dispose();
			}
		});
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		idLabel = new JLabel("ID:");
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(CoresFontes.fonteStencil);
		idLabel.setBounds(10, 13, 65, 14);
		contentPane.add(idLabel);

		clienteLabel = new JLabel("Cliente:");
		clienteLabel.setForeground(Color.WHITE);
		clienteLabel.setFont(CoresFontes.fonteStencil);
		clienteLabel.setBounds(10, 43, 83, 14);
		contentPane.add(clienteLabel);

		mesaLabel = new JLabel("Mesa:");
		mesaLabel.setForeground(Color.WHITE);
		mesaLabel.setFont(CoresFontes.fonteStencil);
		mesaLabel.setBounds(10, 73, 65, 14);
		contentPane.add(mesaLabel);

		tipoLabel = new JLabel("Tipo:");
		tipoLabel.setForeground(Color.WHITE);
		tipoLabel.setFont(CoresFontes.fonteStencil);
		tipoLabel.setBounds(10, 103, 65, 14);
		contentPane.add(tipoLabel);

		statusLabel = new JLabel("Status:");
		statusLabel.setForeground(Color.WHITE);
		statusLabel.setFont(CoresFontes.fonteStencil);
		statusLabel.setBounds(201, 43, 75, 14);
		contentPane.add(statusLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(81, 8, 56, 25);
		contentPane.add(idText);
		idText.setColumns(10);

		clienteCombo = new JComboBox<String>();
		clienteCombo.setBounds(81, 38, 110, 25);
		contentPane.add(clienteCombo);

		mesaCombo = new JComboBox<String>();
		mesaCombo.addItem("Mesa da comanda");
		mesaCombo.addItem("Mesa 1");
		mesaCombo.addItem("Mesa 2");
		mesaCombo.addItem("Mesa 3");
		mesaCombo.addItem("Mesa 4");
		mesaCombo.addItem("Mesa 5");
		mesaCombo.addItem("Mesa 6");
		mesaCombo.setBounds(81, 68, 110, 25);
		contentPane.add(mesaCombo);

		tipoCombo = new JComboBox<String>();
		tipoCombo.addItem("Tipo da comanda");
		tipoCombo.addItem("Comum");
		tipoCombo.addItem("Happy Hour");
		tipoCombo.setBounds(81, 98, 110, 25);
		contentPane.add(tipoCombo);

		statusCombo = new JComboBox<String>();
		statusCombo.addItem("Status da comanda");
		statusCombo.addItem("Aberta");
		statusCombo.addItem("Paga");
		statusCombo.setBounds(269, 38, 110, 25);
		contentPane.add(statusCombo);

		produtosLabel = new JLabel("Produtos");
		produtosLabel.setForeground(Color.WHITE);
		produtosLabel.setFont(CoresFontes.fonteStencil);
		produtosLabel.setBounds(908, 14, 95, 14);
		contentPane.add(produtosLabel);

		produtosComandaLabel = new JLabel("Produtos na comanda");
		produtosComandaLabel.setForeground(Color.WHITE);
		produtosComandaLabel.setFont(CoresFontes.fonteStencil);
		produtosComandaLabel.setBounds(147, 134, 189, 14);
		contentPane.add(produtosComandaLabel);

		produtosComandaSP = new JScrollPane();
		produtosComandaSP.setBounds(10, 153, 463, 215);
		contentPane.add(produtosComandaSP);

		comandasLabel = new JLabel("Comandas em aberto");
		comandasLabel.setForeground(Color.WHITE);
		comandasLabel.setFont(CoresFontes.fonteStencil);
		comandasLabel.setBounds(147, 442, 189, 14);
		contentPane.add(comandasLabel);
		
		fazerEAtualizarPedidoButton = new JButton("Fazer Pedido");
		fazerEAtualizarPedidoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clienteCombo.getSelectedIndex() != 0 && tipoCombo.getSelectedIndex() != 0
						&& mesaCombo.getSelectedIndex() != 0 && statusCombo.getSelectedIndex() != 0) {

					Pedido pedido = new Pedido(tipoCombo.getSelectedItem().toString(),
							mesaCombo.getSelectedItem().toString(), statusCombo.getSelectedItem().toString(),
							clienteCombo.getSelectedItem().toString());
					
					if(metodos.cadastrar(pedido)) {
						
						listarTabelaProdutos();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos vazios", 2);
				}
			}
		});
		fazerEAtualizarPedidoButton.setVerticalAlignment(SwingConstants.TOP);
		fazerEAtualizarPedidoButton.setForeground(Color.WHITE);
		fazerEAtualizarPedidoButton.setFont(CoresFontes.fonteStencil);
		fazerEAtualizarPedidoButton.setBounds(644, 379, 146, 25);
		fazerEAtualizarPedidoButton.setBackground(CoresFontes.corBot�o);
		contentPane.add(fazerEAtualizarPedidoButton);

		limparButton = new JButton("Limpar");
		limparButton.setVerticalTextPosition(SwingConstants.TOP);
		limparButton.setVerticalAlignment(SwingConstants.TOP);
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idText.setText("");
				clienteCombo.setSelectedIndex(0);
				mesaCombo.setSelectedIndex(0);
				tipoCombo.setSelectedIndex(0);
				statusCombo.setSelectedIndex(0);
				precoText.setText("");
			}
		});
		limparButton.setForeground(Color.WHITE);
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setBounds(833, 379, 146, 25);
		limparButton.setBackground(CoresFontes.corBot�o);
		contentPane.add(limparButton);

		precoTotalLabel = new JLabel("PRE\u00C7O TOTAL:");
		precoTotalLabel.setForeground(Color.WHITE);
		precoTotalLabel.setFont(CoresFontes.fonteStencil);
		precoTotalLabel.setBounds(10, 381, 181, 16);
		contentPane.add(precoTotalLabel);

		precoText = new JTextField();
		precoText.setEditable(false);
		precoText.setBounds(351, 375, 122, 28);
		contentPane.add(precoText);
		precoText.setColumns(10);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(
				new ImageIcon(TelaCadastroPedidos.class.getResource("/assets/fundo com cerveja Full HD.jpeg")));
		fundoLabel.setBounds(0, 0, 1274, 691);
		contentPane.add(fundoLabel);

		listarTabelaProdutos();
		listarTabelaComandas();
		preencherComboClientes();
	}

	public void listarTabelaProdutos() {
		Vector<String> cabecalhoPersonalizado = new Vector<>();
		cabecalhoPersonalizado.addElement("ID");
		cabecalhoPersonalizado.addElement("Produto");
		cabecalhoPersonalizado.addElement("Unidade");
		cabecalhoPersonalizado.addElement("Preco");
		cabecalhoPersonalizado.addElement("Descri�ao");
		cabecalhoPersonalizado.addElement("Tipo");
		cabecalhoPersonalizado.addElement("Fornecedor");

		String sql = "SELECT produto.idproduto, produto.nome, produto.unidade, produto.preco, produto.descricao, produto.tipo, produto.quantidade, fornecedor.nomefantasia \r\n"
				+ "FROM produto \r\n" + "INNER JOIN fornecedor \r\n"
				+ "ON produto.idfornecedor = fornecedor.idfornecedor";

		if (produtosTabela != null) {
			produtosTabela.setVisible(false);
			produtosTabela = null;
			produtosSP.setVisible(false);
			produtosSP = null;
		}

		produtosTabela = metodos.criaTabelaProduto(sql, cabecalhoPersonalizado);

		produtosSP = new JScrollPane(produtosTabela);
		produtosSP.setBounds(644, 42, 624, 326);
		contentPane.remove(fundoLabel);
		contentPane.add(produtosSP);
		contentPane.add(fundoLabel);
		contentPane.updateUI();

	}

	public void listarTabelaComandas() {
		Vector<String> cabecalhoPersonalizado = new Vector<>();
		cabecalhoPersonalizado.addElement("ID");
		cabecalhoPersonalizado.addElement("Tipo");
		cabecalhoPersonalizado.addElement("Mesa");
		cabecalhoPersonalizado.addElement("Status");
		cabecalhoPersonalizado.addElement("Cliente");
		cabecalhoPersonalizado.addElement("Usuario");

		String sql = "SELECT pedido.idpedido, pedido.tipopedido, pedido.mesa, pedido.status, cliente.nome, usuario.nome \r\n"
				+ "FROM pedido \r\n"
				+ "INNER JOIN cliente \r\n"
				+ "ON pedido.idcliente = cliente.idcliente \r\n"
				+ "INNER JOIN usuario \r\n"
				+ "ON pedido.idusuario = usuario.id_usuario \r\n"
				+ "WHERE pedido.status = 'Aberta'";

		if (comandaTabela != null) {
			comandaTabela.setVisible(false);
			comandaTabela = null;
			comandasSP.setVisible(false);
			comandasSP = null;
		}

		comandaTabela = metodos.criaTabelaProduto(sql, cabecalhoPersonalizado);

		comandasSP = new JScrollPane(comandaTabela);
		comandasSP.setBounds(10, 468, 463, 217);
		contentPane.remove(fundoLabel);
		contentPane.add(comandasSP);
		contentPane.add(fundoLabel);
		contentPane.updateUI();
		
	}
	
	public void preencherComboClientes() {
		ResultSet clientes = metodos.buscarClientes();
		clienteCombo.addItem("Clientes");
		try {
			while(clientes.next()) {
				clienteCombo.addItem(clientes.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
