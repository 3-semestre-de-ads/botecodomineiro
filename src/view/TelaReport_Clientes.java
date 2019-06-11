package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.CoresFontes;
import model.GerarReport;
import net.sf.jasperreports.engine.JRException;

/**
 * 
 * @author Heitor Amaral
 * 
 *         Nesta tela é feito a inserção de parametros para ser gerado o
 *         relatório de pedidos
 *
 */

public class TelaReport_Clientes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeClienteText;
	private JLabel nomeClienteLabel;
	private JLabel cpfLabel;
	private JButton gerarButton;
	private JButton limparButton;
	private JLabel fundoLabel;
	private JTextField cpfText;
	private JTextField cidadeText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReport_Clientes frame = new TelaReport_Clientes();
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
	public TelaReport_Clientes() {
		setTitle("Relatório de Clientes");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.Controle.parametrosReportClientes = false;
			}
		});
		setBounds(100, 100, 639, 389);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		cidadeText = new JTextField();
		cidadeText.setToolTipText("Deixe em branco para visualizar todos os registros.");
		cidadeText.setColumns(10);
		cidadeText.setBounds(280, 161, 170, 25);
		contentPane.add(cidadeText);

		cpfText = new JTextField();
		cpfText.setToolTipText("Deixe em branco para visualizar todos os registros.");
		cpfText.setColumns(10);
		cpfText.setBounds(280, 125, 170, 25);
		contentPane.add(cpfText);

		JLabel cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		cidadeLabel.setForeground(Color.WHITE);
		cidadeLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		cidadeLabel.setBounds(182, 161, 98, 25);
		contentPane.add(cidadeLabel);

		JLabel reportNameLabel = new JLabel("Relatório de Clientes");
		reportNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		reportNameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		reportNameLabel.setForeground(Color.WHITE);
		reportNameLabel.setFont(new Font("Stencil", Font.PLAIN, 16));
		reportNameLabel.setBounds(185, 30, 263, 25);
		contentPane.add(reportNameLabel);

		gerarButton = new JButton("Gerar");
		gerarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Thread(new thread1()).start();
			}
		});
		gerarButton.setForeground(Color.WHITE);
		gerarButton.setFont(CoresFontes.fonteStencil);
		gerarButton.setBackground(CoresFontes.corBotão);
		gerarButton.setBounds(185, 199, 120, 23);
		contentPane.add(gerarButton);

		limparButton = new JButton("Limpar");
		limparButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpar();
			}
		});
		limparButton.setForeground(Color.WHITE);
		limparButton.setFont(CoresFontes.fonteStencil);
		limparButton.setBackground(CoresFontes.corBotão);
		limparButton.setBounds(328, 199, 120, 23);
		contentPane.add(limparButton);

		cpfLabel = new JLabel("CPF:");
		cpfLabel.setBounds(182, 125, 98, 25);
		contentPane.add(cpfLabel);
		cpfLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		cpfLabel.setForeground(Color.WHITE);
		cpfLabel.setFont(CoresFontes.fonteStencil);

		nomeClienteText = new JTextField();
		nomeClienteText.setToolTipText("Deixe em branco para visualizar todos os registros.");
		nomeClienteText.setBounds(280, 90, 170, 25);
		contentPane.add(nomeClienteText);
		nomeClienteText.setColumns(10);

		nomeClienteLabel = new JLabel("Cliente:");
		nomeClienteLabel.setBounds(182, 90, 98, 25);
		contentPane.add(nomeClienteLabel);
		nomeClienteLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		nomeClienteLabel.setForeground(Color.WHITE);
		nomeClienteLabel.setFont(CoresFontes.fonteStencil);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaReport_Clientes.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);

	}

	public void limpar() {
		nomeClienteText.setText("");
		cidadeText.setText("");
		cpfText.setText("");
	}

	public class thread1 implements Runnable {

		public void run() {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("NOME", nomeClienteText.getText());
			parametros.put("CPF", cpfText.getText());
			parametros.put("CIDADE", cidadeText.getText());
			try {
				GerarReport.geraRelatorio("Clientes_Report.jasper", parametros, "Clientes");
			} catch (JRException ex) {
				ex.printStackTrace();
			}
		}

	}
}
