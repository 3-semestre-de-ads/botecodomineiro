package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * 
 * @author MATIAS
 *
 * Nesta tela é possivel, visualizar pedidos, fazer pedidos e atualiza-los.
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
	private JLabel produtosLabel;
	private JScrollPane produtosSP;
	private JLabel fundoLabel;
	private JLabel produtosComandaLabel;
	private JScrollPane produtosComandaSP;
	private JLabel comandasLabel;
	private JScrollPane comandasSP;
	private JButton fazerEAtualizarPedidoButton;
	private JButton limparButton;
	private JTextField precoText;

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
		mesaCombo.setBounds(81, 68, 110, 25);
		contentPane.add(mesaCombo);
		
		tipoCombo = new JComboBox<String>();
		tipoCombo.setBounds(81, 98, 110, 25);
		contentPane.add(tipoCombo);
		
		statusCombo = new JComboBox<String>();
		statusCombo.setBounds(269, 38, 110, 25);
		contentPane.add(statusCombo);
		
		produtosLabel = new JLabel("Produtos");
		produtosLabel.setForeground(Color.WHITE);
		produtosLabel.setFont(CoresFontes.fonteStencil);
		produtosLabel.setBounds(908, 14, 95, 14);
		contentPane.add(produtosLabel);
		
		produtosSP = new JScrollPane();
		produtosSP.setBounds(644, 42, 624, 326);
		contentPane.add(produtosSP);
		
		produtosComandaLabel = new JLabel("Produtos na comanda");
		produtosComandaLabel.setForeground(Color.WHITE);
		produtosComandaLabel.setFont(CoresFontes.fonteStencil);
		produtosComandaLabel.setBounds(147, 134, 189, 14);
		contentPane.add(produtosComandaLabel);
		
		produtosComandaSP = new JScrollPane();
		produtosComandaSP.setBounds(10, 153, 463, 215);
		contentPane.add(produtosComandaSP);
		
		comandasSP = new JScrollPane();
		comandasSP.setBounds(10, 468, 463, 217);
		contentPane.add(comandasSP);
		
		comandasLabel = new JLabel("Comandas em aberto");
		comandasLabel.setForeground(Color.WHITE);
		comandasLabel.setFont(CoresFontes.fonteStencil);
		comandasLabel.setBounds(147, 442, 189, 14);
		contentPane.add(comandasLabel);
		
		fazerEAtualizarPedidoButton = new JButton("Fazer Pedido");
		fazerEAtualizarPedidoButton.setVerticalTextPosition(SwingConstants.TOP);
		fazerEAtualizarPedidoButton.setVerticalAlignment(SwingConstants.TOP);
		fazerEAtualizarPedidoButton.setForeground(Color.WHITE);
		fazerEAtualizarPedidoButton.setFont(CoresFontes.fonteStencil);
		fazerEAtualizarPedidoButton.setBounds(644, 379, 146, 25);
		fazerEAtualizarPedidoButton.setBackground(CoresFontes.corBotão);
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
		limparButton.setBackground(CoresFontes.corBotão);
		contentPane.add(limparButton);
		
		JLabel precoTotalLabel = new JLabel("PRE\u00C7O TOTAL:");
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
		fundoLabel.setIcon(new ImageIcon(TelaCadastroPedidos.class.getResource("/assets/fundo com cerveja Full HD.jpeg")));
		fundoLabel.setBounds(0, 0, 1274, 691);
		contentPane.add(fundoLabel);
	}
}
