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
import model.UsuarioDAO;
import net.sf.jasperreports.engine.JRException;

/**
 * 
 * @author Heitor Amaral
 * 
 *         Nesta tela é feito a inserção de parametros para ser gerado o
 *         relatório
 *
 */

public class TelaReports extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeText;
	private JTextField funcaoText;
	private JLabel nomeLabel;
	private JLabel funcaoLabel;
	private JButton gerarButton;
	private JButton limparButton;
	private JLabel fundoLabel;

	UsuarioDAO metodos = new UsuarioDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReports frame = new TelaReports();
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
	public TelaReports() {
		setTitle("Relatório de Funcionários");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				controller.Controle.parametrosReportUsuario = false;
			}
		});
		setBounds(100, 100, 639, 389);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel reportNameLabel = new JLabel("Relat\u00F3rio de Funcion\u00E1rios");
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
		gerarButton.setBounds(185, 156, 120, 23);
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
		limparButton.setBounds(328, 156, 120, 23);
		contentPane.add(limparButton);

		funcaoLabel = new JLabel("Fun\u00E7\u00E3o:");
		funcaoLabel.setBounds(185, 123, 74, 25);
		contentPane.add(funcaoLabel);
		funcaoLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		funcaoLabel.setForeground(Color.WHITE);
		funcaoLabel.setFont(CoresFontes.fonteStencil);

		funcaoText = new JTextField();
		funcaoText.setBounds(280, 123, 168, 25);
		contentPane.add(funcaoText);
		funcaoText.setColumns(10);

		nomeText = new JTextField();
		nomeText.setBounds(280, 87, 168, 25);
		contentPane.add(nomeText);
		nomeText.setColumns(10);

		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(185, 87, 74, 25);
		contentPane.add(nomeLabel);
		nomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setFont(CoresFontes.fonteStencil);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(
				new ImageIcon(TelaReports.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);
	}

	public void limpar() {
		nomeText.setText("");
		funcaoText.setText("");
	}

	public class thread1 implements Runnable {

		public void run() {
			Map<String, Object> parametros = new HashMap();
			parametros.put("NOME", nomeText.getText());
			parametros.put("FUNCAO", funcaoText.getText());
			parametros.put("ATIVO", "2");
			try {
				GerarReport.geraRelatorio("Funcionarios_Report.jasper", parametros);
			} catch (JRException ex) {
				ex.printStackTrace();
			}
		}

	}
}
