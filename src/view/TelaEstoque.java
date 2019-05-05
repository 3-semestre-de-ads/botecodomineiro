package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controle;
import model.CoresFontes;
import model.EstoqueDAO;
import model.TextPrompt;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author MATIAS
 *
 *         Nesta tela e feito a visualizacao e controle de estoque, verificando
 *         produtos cadastrados e suas quantidades
 */

public class TelaEstoque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField idText;
	private JTextField produtoText;
	private JTextField precoText;
	private JTextField fornecedorText;
	private JTextField unidadeText;
	private JTextField tipoText;
	private JScrollPane produtosSP;
	private JTable produtosTable;
	private JLabel fundo;
	private JLabel idLabel;
	private JLabel produtoLabel;
	private JLabel unidadeLabel;
	private JLabel descLabel;
	private JTextArea descText;
	private JLabel precoLabel;
	private JLabel fornecedorLabel;
	private JLabel tipoLabel;
	private JTextField pesquisarText;
	private TableRowSorter<TableModel> sorter;
	private JLabel pesquisaFornLabel;
	private JComboBox<String> pesquisaFornecedor;
	private JComboBox<String> pesquisaUnidade;
	private JLabel pesquisaUniLabel;
	private JComboBox<String> pesquisaTipo;
	private JLabel tipoUniLabel;

	EstoqueDAO metodos = new EstoqueDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEstoque frame = new TelaEstoque();
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
	public TelaEstoque() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				dispose();
				Controle.estoquetela = false;
			}
		});
		setSize(1280, 720);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		pesquisarText = new JTextField();
		pesquisarText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				filtroTabela(pesquisarText.getText(), 0);
			}
		});
		TextPrompt tp = new TextPrompt("PESQUISAR", pesquisarText);
		tp.setForeground(Color.WHITE);
		tp.setFont(CoresFontes.fonteStencil);
		tp.changeAlpha(0.5f);

		pesquisaUniLabel = new JLabel("Unidade");
		pesquisaUniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pesquisaUniLabel.setForeground(Color.WHITE);
		pesquisaUniLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		pesquisaUniLabel.setBounds(508, 215, 133, 14);
		contentPane.add(pesquisaUniLabel);

		pesquisaUnidade = new JComboBox<String>();
		pesquisaUnidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pesquisaUnidade.getSelectedIndex() != 0) {
					filtroTabela(pesquisaUnidade.getSelectedItem().toString(), 3);
				} else {
					filtroTabela("", 0);
				}
			}
		});
		pesquisaUnidade.setModel(new DefaultComboBoxModel<String>(new String[] { "Selecione", "Litro", "Saco",
				"Prato P", "Prato M", "Prato G", "Por\u00E7\u00E3o P", "Por\u00E7\u00E3o M", "Por\u00E7\u00E3o G" }));
		pesquisaUnidade.setBounds(508, 241, 133, 25);
		contentPane.add(pesquisaUnidade);

		pesquisaTipo = new JComboBox<String>();
		pesquisaTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (pesquisaTipo.getSelectedIndex() != 0) {
					filtroTabela(pesquisaTipo.getSelectedItem().toString(), 6);
				} else {
					filtroTabela("", 0);
				}
			}
		});
		pesquisaTipo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Selecione", "Alimentos", "Bebidas Alcolicas", "Bebidas N\u00E3o Alcolicas" }));
		pesquisaTipo.setBounds(651, 241, 133, 25);
		contentPane.add(pesquisaTipo);

		tipoUniLabel = new JLabel("TIPO");
		tipoUniLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tipoUniLabel.setForeground(Color.WHITE);
		tipoUniLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		tipoUniLabel.setBounds(651, 215, 133, 14);
		contentPane.add(tipoUniLabel);

		pesquisaFornLabel = new JLabel("Fornecedor");
		pesquisaFornLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pesquisaFornLabel.setFont(CoresFontes.fonteStencil);
		pesquisaFornLabel.setForeground(Color.WHITE);
		pesquisaFornLabel.setBounds(365, 215, 133, 14);
		contentPane.add(pesquisaFornLabel);

		pesquisaFornecedor = new JComboBox<String>();
		pesquisaFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pesquisaFornecedor.getSelectedIndex() != 0) {
					filtroTabela(pesquisaFornecedor.getSelectedItem().toString(), 1);
				} else {
					filtroTabela("", 0);
				}
			}
		});
		pesquisaFornecedor.setModel(new DefaultComboBoxModel<String>(new String[] { "Selecione" }));
		pesquisaFornecedor.setBounds(365, 241, 133, 25);
		contentPane.add(pesquisaFornecedor);

		pesquisarText.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		pesquisarText.setBounds(10, 240, 229, 25);
		pesquisarText.setBackground(CoresFontes.fundoTransparente);
		pesquisarText.setFont(CoresFontes.fonteStencil);
		pesquisarText.setForeground(Color.WHITE);
		contentPane.add(pesquisarText);

		idLabel = new JLabel("ID:");
		idLabel.setForeground(Color.WHITE);
		idLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		idLabel.setBounds(10, 16, 56, 14);
		contentPane.add(idLabel);

		idText = new JTextField();
		idText.setEditable(false);
		idText.setColumns(10);
		idText.setBounds(105, 11, 45, 25);
		contentPane.add(idText);

		produtoLabel = new JLabel("Produto:");
		produtoLabel.setForeground(Color.WHITE);
		produtoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		produtoLabel.setBounds(10, 46, 85, 14);
		contentPane.add(produtoLabel);

		produtoText = new JTextField();
		produtoText.setEditable(false);
		produtoText.setColumns(10);
		produtoText.setBounds(105, 41, 133, 25);
		contentPane.add(produtoText);

		unidadeLabel = new JLabel("Unidade:");
		unidadeLabel.setForeground(Color.WHITE);
		unidadeLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		unidadeLabel.setBounds(10, 76, 80, 14);
		contentPane.add(unidadeLabel);

		descLabel = new JLabel("Descri\u00E7\u00E3o:");
		descLabel.setForeground(Color.WHITE);
		descLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		descLabel.setBounds(10, 134, 95, 14);
		contentPane.add(descLabel);

		descText = new JTextArea();
		descText.setEditable(false);
		descText.setBounds(105, 101, 225, 80);
		contentPane.add(descText);

		precoText = new JTextField();
		precoText.setEditable(false);
		precoText.setColumns(10);
		precoText.setBounds(290, 11, 135, 25);
		contentPane.add(precoText);

		tipoLabel = new JLabel("Tipo:");
		tipoLabel.setForeground(Color.WHITE);
		tipoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		tipoLabel.setBounds(435, 16, 56, 14);
		contentPane.add(tipoLabel);

		fornecedorLabel = new JLabel("Fornecedor:");
		fornecedorLabel.setForeground(Color.WHITE);
		fornecedorLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		fornecedorLabel.setBounds(248, 63, 110, 14);
		contentPane.add(fornecedorLabel);

		precoLabel = new JLabel("Pre\u00E7o:");
		precoLabel.setForeground(Color.WHITE);
		precoLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		precoLabel.setBounds(224, 16, 56, 14);
		contentPane.add(precoLabel);

		fornecedorText = new JTextField();
		fornecedorText.setEditable(false);
		fornecedorText.setBounds(365, 58, 250, 25);
		contentPane.add(fornecedorText);
		fornecedorText.setColumns(10);

		unidadeText = new JTextField();
		unidadeText.setEditable(false);
		unidadeText.setColumns(10);
		unidadeText.setBounds(105, 71, 133, 25);
		contentPane.add(unidadeText);

		tipoText = new JTextField();
		tipoText.setEditable(false);
		tipoText.setColumns(10);
		tipoText.setBounds(482, 11, 133, 25);
		contentPane.add(tipoText);

		fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(TelaEstoque.class.getResource("/assets/fundo com cerveja Full HD.jpeg")));
		fundo.setBounds(0, 0, 1264, 681);
		contentPane.add(fundo);

		listarTabela();
		preencherComboFornecedor();
	}

	public void listarTabela() {

		Vector<String> cabecalhoPersonalizado = new Vector<>();
		cabecalhoPersonalizado.addElement("ID");
		cabecalhoPersonalizado.addElement("Fornecedor");
		cabecalhoPersonalizado.addElement("Nome");
		cabecalhoPersonalizado.addElement("Unidade");
		cabecalhoPersonalizado.addElement("Descricao");
		cabecalhoPersonalizado.addElement("Preco");
		cabecalhoPersonalizado.addElement("Tipo");
		cabecalhoPersonalizado.addElement("Quantidade");
		cabecalhoPersonalizado.addElement("Minimo");
		cabecalhoPersonalizado.addElement("Maximo");

		String sql = "SELECT p.idproduto,\r\n" + "	  	f.nomefantasia fornecedor,\r\n" + "       p.nome,\r\n"
				+ "       p.unidade,\r\n" + "       p.descricao,\r\n" + "       p.preco,\r\n" + "       p.tipo,\r\n"
				+ "       p.quantidade,\r\n  " + "       p.qtdmin,\r\n  " + "       p.qtdmax\r\n  "
				+ "FROM produto p \r\n " + "INNER JOIN fornecedor f \r\n" + "ON p.idfornecedor = f.idfornecedor\r\n"
				+ "ORDER BY idproduto;";

		if (produtosTable != null) {
			produtosTable.setVisible(false);
			produtosTable = null;
			produtosSP.setVisible(false);
			produtosSP = null;
		}

		produtosTable = metodos.criarTabela(sql, cabecalhoPersonalizado);
		produtosTable.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent a) {
				idText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 0).toString());
				fornecedorText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 1).toString());
				produtoText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 2).toString());
				unidadeText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 3).toString());
				descText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 4).toString());
				precoText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 5).toString());
				tipoText.setText(produtosTable.getValueAt(produtosTable.getSelectedRow(), 6).toString());

			}
		});

		produtosSP = new JScrollPane(produtosTable);
		produtosSP.setBounds(0, 276, 1264, 405);

		contentPane.remove(fundo);
		contentPane.add(produtosSP);
		contentPane.add(fundo);
		contentPane.updateUI();

		sorter = new TableRowSorter<TableModel>(produtosTable.getModel());
		produtosTable.setRowSorter(sorter);
	}

	public void preencherComboFornecedor() {
		ResultSet consultarFornRS = metodos.consultarForn();
		try {
			while (consultarFornRS.next()) {
				pesquisaFornecedor.addItem(consultarFornRS.getString(1));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void filtroTabela(String filtro, int coluna) {
		if (coluna == 0) {
			sorter.setRowFilter(RowFilter.regexFilter(filtro));

		} else {
			sorter.setRowFilter(RowFilter.regexFilter(filtro, coluna));

		}
	}

}
