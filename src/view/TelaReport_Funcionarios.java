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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import groovy.util.slurpersupport.ReplacementNode;
import model.AtivoEnum;
import model.CoresFontes;
import model.FuncaoEnum;
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

public class TelaReport_Funcionarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nomeText;
	private JLabel nomeLabel;
	private JLabel funcaoLabel;
	private JButton gerarButton;
	private JButton limparButton;
	private JLabel fundoLabel;
	private JComboBox ativoCB = new JComboBox();

	UsuarioDAO metodos = new UsuarioDAO();
	private JComboBox funcaoCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaReport_Funcionarios frame = new TelaReport_Funcionarios();
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
	public TelaReport_Funcionarios() {
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

		funcaoCB = new JComboBox();
		funcaoCB.setModel(new DefaultComboBoxModel(FuncaoEnum.values()));
		funcaoCB.setBounds(280, 125, 170, 25);
		contentPane.add(funcaoCB);

		JLabel lblAtivo = new JLabel("Ativo:");
		lblAtivo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblAtivo.setForeground(Color.WHITE);
		lblAtivo.setFont(new Font("Stencil", Font.PLAIN, 16));
		lblAtivo.setBounds(185, 161, 74, 25);
		contentPane.add(lblAtivo);

		ativoCB.setModel(new DefaultComboBoxModel(AtivoEnum.values()));
		ativoCB.setBounds(280, 160, 170, 25);
		contentPane.add(ativoCB);

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

		funcaoLabel = new JLabel("Fun\u00E7\u00E3o:");
		funcaoLabel.setBounds(185, 125, 74, 25);
		contentPane.add(funcaoLabel);
		funcaoLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		funcaoLabel.setForeground(Color.WHITE);
		funcaoLabel.setFont(CoresFontes.fonteStencil);

		nomeText = new JTextField();
		nomeText.setBounds(280, 90, 170, 25);
		contentPane.add(nomeText);
		nomeText.setColumns(10);

		nomeLabel = new JLabel("Nome:");
		nomeLabel.setBounds(185, 90, 74, 25);
		contentPane.add(nomeLabel);
		nomeLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		nomeLabel.setForeground(Color.WHITE);
		nomeLabel.setFont(CoresFontes.fonteStencil);

		fundoLabel = new JLabel("");
		fundoLabel.setIcon(new ImageIcon(TelaReport_Funcionarios.class.getResource("/assets/fundo com cerveja.jpeg")));
		fundoLabel.setBounds(0, 0, 633, 360);
		contentPane.add(fundoLabel);

	}

	public void limpar() {
		nomeText.setText("");
		funcaoCB.setSelectedIndex(0);
		ativoCB.setSelectedIndex(0);
	}

	public class thread1 implements Runnable {

		public void run() {
			Map<String, Object> parametros = new HashMap();
			parametros.put("NOME", nomeText.getText());
			parametros.put("FUNCAO", String.valueOf(funcaoCB.getSelectedIndex()));
			parametros.put("ATIVO", String.valueOf(ativoCB.getSelectedIndex()));
			try {
				GerarReport.geraRelatorio("Funcionarios_Report.jasper", parametros);
			} catch (JRException ex) {
				ex.printStackTrace();
			}
		}

	}
}
