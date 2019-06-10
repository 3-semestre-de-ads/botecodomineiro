package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.CoresFontes;
import model.Pedido;
import model.PedidoDAO;
import model.Produto;
import model.ProdutoNaComanda;
import model.ProdutosNaComandaModel;
import model.Sessao;
import model.TableGrade;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela é possivel, visualizar pedidos, fazer pedidos e
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
	private JTable produtosComandaTabela;
	private JLabel produtosComandaLabel;
	private JScrollPane produtosComandaSP;
	private JLabel comandasLabel;
	private JScrollPane comandasSP;
	private JButton fazerPedidoButton;
	private JButton limparButton;
	private JTextField precoText;
	private JLabel precoTotalLabel;

	PedidoDAO metodos = new PedidoDAO();
	ProdutosNaComandaModel ModeloDeTabela = new ProdutosNaComandaModel();
	private JButton atualizarPedidoButton;

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
		idLabel.setBounds(10, 8, 65, 25);
		contentPane.add(idLabel);

		clienteLabel = new JLabel("Cliente:");
		clienteLabel.setForeground(Color.WHITE);
		clienteLabel.setFont(CoresFontes.fonteStencil);
		clienteLabel.setBounds(10, 38, 83, 25);
		contentPane.add(clienteLabel);

		mesaLabel = new JLabel("Mesa:");
		mesaLabel.setForeground(Color.WHITE);
		mesaLabel.setFont(CoresFontes.fonteStencil);
		mesaLabel.setBounds(10, 68, 65, 25);
		contentPane.add(mesaLabel);

		tipoLabel = new JLabel("Tipo:");
		tipoLabel.setForeground(Color.WHITE);
		tipoLabel.setFont(CoresFontes.fonteStencil);
		tipoLabel.setBounds(355, 68, 65, 25);
		contentPane.add(tipoLabel);

		statusLabel = new JLabel("Status:");
		statusLabel.setForeground(Color.WHITE);
		statusLabel.setFont(CoresFontes.fonteStencil);
		statusLabel.setBounds(355, 38, 75, 25);
		contentPane.add(statusLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setBounds(90, 8, 56, 25);
		contentPane.add(idText);
		idText.setColumns(10);

		clienteCombo = new JComboBox<String>();
		clienteCombo.setBounds(90, 38, 200, 25);
		contentPane.add(clienteCombo);

		mesaCombo = new JComboBox<String>();
		mesaCombo.addItem("Mesa da comanda");
		mesaCombo.addItem("1");
		mesaCombo.addItem("2");
		mesaCombo.addItem("3");
		mesaCombo.addItem("4");
		mesaCombo.addItem("5");
		mesaCombo.addItem("6");
		mesaCombo.setBounds(90, 68, 200, 25);
		contentPane.add(mesaCombo);

		tipoCombo = new JComboBox<String>();
		tipoCombo.addItem("Tipo da comanda");
		tipoCombo.addItem("Comum");
		tipoCombo.addItem("Happy Hour");
		tipoCombo.setBounds(430, 68, 200, 25);
		contentPane.add(tipoCombo);

		statusCombo = new JComboBox<String>();
		statusCombo.addItem("Status da comanda");
		statusCombo.addItem("Aberta");
		statusCombo.addItem("Paga");
		statusCombo.setBounds(430, 38, 200, 25);
		contentPane.add(statusCombo);

		produtosLabel = new JLabel("Produtos");
		produtosLabel.setForeground(Color.WHITE);
		produtosLabel.setFont(CoresFontes.fonteStencil);
		produtosLabel.setBounds(908, 13, 95, 14);
		contentPane.add(produtosLabel);

		produtosComandaLabel = new JLabel("Produtos na comanda");
		produtosComandaLabel.setForeground(Color.WHITE);
		produtosComandaLabel.setFont(CoresFontes.fonteStencil);
		produtosComandaLabel.setBounds(226, 104, 189, 25);
		contentPane.add(produtosComandaLabel);

		comandasLabel = new JLabel("Comandas em aberto");
		comandasLabel.setForeground(Color.WHITE);
		comandasLabel.setFont(CoresFontes.fonteStencil);
		comandasLabel.setBounds(226, 415, 189, 25);
		contentPane.add(comandasLabel);

		fazerPedidoButton = new JButton("Fazer Pedido");
		fazerPedidoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (clienteCombo.getSelectedIndex() != 0 && tipoCombo.getSelectedIndex() != 0
						&& mesaCombo.getSelectedIndex() != 0 && statusCombo.getSelectedIndex() != 0) {

					Pedido pedido = new Pedido(tipoCombo.getSelectedItem().toString(),
							mesaCombo.getSelectedItem().toString(), statusCombo.getSelectedItem().toString(),
							clienteCombo.getSelectedItem().toString());

					if (metodos.cadastrar(pedido)) {
						listarTabelaComandas();
						atualizarPedidoButton.setVisible(true);
						fazerPedidoButton.setVisible(false);
						idText.setText(String.valueOf(pedido.getIdPedido()));

					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campos vazios", 2);
				}
			}
		});
		fazerPedidoButton.setVerticalAlignment(SwingConstants.TOP);
		fazerPedidoButton.setForeground(Color.WHITE);
		fazerPedidoButton.setFont(CoresFontes.fonteStencil);
		fazerPedidoButton.setBounds(644, 469, 146, 25);
		fazerPedidoButton.setBackground(CoresFontes.corBotão);
		contentPane.add(fazerPedidoButton);

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
				ModeloDeTabela.removeAll();
				atualizarPedidoButton.setVisible(false);
				fazerPedidoButton.setVisible(true);
			}
		});

		atualizarPedidoButton = new JButton("Atualizar");
		atualizarPedidoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhas = produtosComandaTabela.getRowCount();
				String idPedido = idText.getText();

				for (int x = 0; x < linhas; x++) {
					if (produtosComandaTabela.getValueAt(x, 5) == null
							&& statusCombo.getSelectedItem().toString() == "Aberta") {
						if (metodos.inserirProdutoNaComanda(produtosComandaTabela.getValueAt(x, 0).toString(), idPedido,
								Integer.parseInt(produtosComandaTabela.getValueAt(x, 4).toString()))) {
							ModeloDeTabela.updateRow(x, "Registrado");
						}
					}
				}
			}
		});
		atualizarPedidoButton.setActionCommand("");
		atualizarPedidoButton.setVisible(false);
		atualizarPedidoButton.setVerticalAlignment(SwingConstants.TOP);
		atualizarPedidoButton.setForeground(Color.WHITE);
		atualizarPedidoButton.setFont(new Font("Stencil", Font.PLAIN, 16));
		atualizarPedidoButton.setBackground(new Color(50, 0, 0));
		atualizarPedidoButton.setBounds(644, 469, 146, 25);
		contentPane.add(atualizarPedidoButton);
		limparButton.setForeground(Color.WHITE);
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setBounds(833, 469, 146, 25);
		limparButton.setBackground(CoresFontes.corBotão);
		contentPane.add(limparButton);

		precoTotalLabel = new JLabel("PRE\u00C7O TOTAL:");
		precoTotalLabel.setForeground(Color.WHITE);
		precoTotalLabel.setFont(CoresFontes.fonteStencil);
		precoTotalLabel.setBounds(364, 380, 116, 30);
		contentPane.add(precoTotalLabel);

		precoText = new JTextField();
		precoText.setEditable(false);
		precoText.setBounds(480, 380, 150, 30);
		contentPane.add(precoText);
		precoText.setColumns(10);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(
				new ImageIcon(TelaCadastroPedidos.class.getResource("/assets/fundo com cerveja Full HD.jpeg")));
		fundoLabel.setBounds(0, 0, 1274, 691);
		contentPane.add(fundoLabel);

		listarTabelaProdutos();
		listarTabelaComandas();
		listarTabelaProdutosNaComanda();
		preencherComboClientes();
	}

	public void listarTabelaProdutos() {
		Vector<String> cabecalhoPersonalizado = new Vector<>();
		cabecalhoPersonalizado.addElement("ID");
		cabecalhoPersonalizado.addElement("Produto");
		cabecalhoPersonalizado.addElement("Unidade");
		cabecalhoPersonalizado.addElement("Preco");
		cabecalhoPersonalizado.addElement("Descriçao");
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
		produtosTabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {

					if (idText.getText().equals("")) {
						JOptionPane.showMessageDialog(null,
								"Faça um novo pedido ou selecione um na lista para alterar/inserir os produtos");

					} else {
						String qtd = JOptionPane.showInputDialog(null, "Informe a quantidade desejada: ");
						if (qtd != null) {
							ProdutoNaComanda produto = new ProdutoNaComanda();
							produto.setID(Integer.parseInt(
									produtosTabela.getValueAt(produtosTabela.getSelectedRow(), 0).toString()));
							produto.setProduto(
									produtosTabela.getValueAt(produtosTabela.getSelectedRow(), 1).toString());
							produto.setUnidade(
									produtosTabela.getValueAt(produtosTabela.getSelectedRow(), 2).toString());
							produto.setPreco(Double.parseDouble(
									produtosTabela.getValueAt(produtosTabela.getSelectedRow(), 3).toString()));
							produto.setQuantidade(Integer.parseInt(qtd));
							
							if(metodos.inserirProdutoNaComanda(String.valueOf(produto.getID()), idText.getText(), Integer.parseInt(qtd))){
								precoText.setText("R$: " + ModeloDeTabela.addRow(produto));
							}
						}
					}
				}
			}
		});

		produtosSP = new JScrollPane(produtosTabela);
		produtosSP.setBounds(644, 38, 620, 420);

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
				+ "FROM pedido \r\n" + "INNER JOIN cliente \r\n" + "ON pedido.idcliente = cliente.idcliente \r\n"
				+ "INNER JOIN usuario \r\n" + "ON pedido.idusuario = usuario.id_usuario \r\n"
				+ "WHERE pedido.status = 'Aberta'";

		if (comandaTabela != null) {
			comandaTabela.setVisible(false);
			comandaTabela = null;
			comandasSP.setVisible(false);
			comandasSP = null;
		}

		comandaTabela = metodos.criaTabelaComandas(sql, cabecalhoPersonalizado);

		comandaTabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					idText.setText(comandaTabela.getValueAt(comandaTabela.getSelectedRow(), 0).toString());
					tipoCombo.setSelectedItem(comandaTabela.getValueAt(comandaTabela.getSelectedRow(), 1).toString());
					mesaCombo.setSelectedItem(comandaTabela.getValueAt(comandaTabela.getSelectedRow(), 2).toString());
					statusCombo.setSelectedItem(comandaTabela.getValueAt(comandaTabela.getSelectedRow(), 3).toString());
					clienteCombo
							.setSelectedItem(comandaTabela.getValueAt(comandaTabela.getSelectedRow(), 4).toString());

					produtosComandaTabela.setModel(metodos.buscarProdutoNaComanda(Integer.parseInt(idText.getText())));
					ModeloDeTabela = (ProdutosNaComandaModel) produtosComandaTabela.getModel();

					atualizarPedidoButton.setVisible(true);
					fazerPedidoButton.setVisible(false);
				}
			}
		});

		comandasSP = new JScrollPane(comandaTabela);
		comandasSP.setBounds(10, 440, 620, 240);
		contentPane.add(comandasSP);

		contentPane.remove(fundoLabel);
		contentPane.add(fundoLabel);
		contentPane.updateUI();

	}

	public void listarTabelaProdutosNaComanda() {

		produtosComandaTabela = new JTable();
		produtosComandaTabela.setModel(ModeloDeTabela);
		produtosComandaTabela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					Sessao sessao = Sessao.getInstance();
					if (produtosComandaTabela.getValueAt(produtosComandaTabela.getSelectedRow(), 5) == null
							|| sessao.getFuncao() == 1) {
						String qtd = JOptionPane.showInputDialog(null, "Informe a quantidade que deseja remover: ");
						if (qtd != null) {
							ProdutoNaComanda produto = new ProdutoNaComanda();
							produto.setID(Integer.parseInt(produtosComandaTabela
									.getValueAt(produtosComandaTabela.getSelectedRow(), 0).toString()));
							produto.setProduto(produtosComandaTabela
									.getValueAt(produtosComandaTabela.getSelectedRow(), 1).toString());
							produto.setUnidade(produtosComandaTabela
									.getValueAt(produtosComandaTabela.getSelectedRow(), 2).toString());
							produto.setPreco(Double.parseDouble(produtosComandaTabela
									.getValueAt(produtosComandaTabela.getSelectedRow(), 3).toString()));
							produto.setQuantidade(Integer.parseInt(qtd));

							if (metodos.removerProdutoDaComanda(String.valueOf(produto.getID()), idText.getText(), qtd)) {
								precoText.setText("R$: "
										+ ModeloDeTabela.removeRow(produtosComandaTabela.getSelectedRow(), produto));
							}

						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Apenas administradores podem remover produtos registrados");
					}
				}
			}
		});

		produtosComandaSP = new JScrollPane(produtosComandaTabela);
		produtosComandaSP.setBounds(10, 129, 620, 240);
		produtosComandaSP.setVisible(true);

		contentPane.remove(fundoLabel);
		contentPane.add(produtosComandaSP);
		contentPane.add(fundoLabel);
		contentPane.updateUI();
	}

	public void preencherComboClientes() {
		ResultSet clientes = metodos.buscarClientes();
		clienteCombo.addItem("Clientes");
		try {
			while (clientes.next()) {
				clienteCombo.addItem(clientes.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
