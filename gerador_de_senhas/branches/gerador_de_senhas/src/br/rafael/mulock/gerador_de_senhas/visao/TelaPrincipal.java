package br.rafael.mulock.gerador_de_senhas.visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.rafael.mulock.gerador_de_senhas.controle.action.SenhaAction;

public class TelaPrincipal extends JFrame {


	/**
	 * Versão 1.0 da parte visual da aplicação
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtA;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private SenhaAction senhaAction;

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
		setTitle("Gerador de senhas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		senhaAction = new SenhaAction();
		
		JLabel lblQuantidadeDeCaracteres = new JLabel("Quantidade de caracteres:");
		lblQuantidadeDeCaracteres.setBounds(10, 14, 134, 14);
		contentPane.add(lblQuantidadeDeCaracteres);
		
		txtA = new JTextField();
		txtA.setBounds(176, 11, 97, 20);
		contentPane.add(txtA);
		txtA.setColumns(10);
		
		JLabel lblLetrasMinsculas = new JLabel("Letras min\u00FAsculas:");
		lblLetrasMinsculas.setBounds(10, 45, 97, 14);
		contentPane.add(lblLetrasMinsculas);
		
		textField = new JTextField();
		textField.setBounds(176, 42, 97, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLetrasMaisculas = new JLabel("Letras mai\u00FAsculas:");
		lblLetrasMaisculas.setBounds(10, 76, 97, 14);
		contentPane.add(lblLetrasMaisculas);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 73, 97, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblSmboloscaracteresEspeciais = new JLabel("S\u00EDmbolos/Caracteres especiais:");
		lblSmboloscaracteresEspeciais.setBounds(10, 107, 148, 14);
		contentPane.add(lblSmboloscaracteresEspeciais);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("");
		textField_2.setName("");
		textField_2.setBounds(176, 104, 97, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblOrdem = new JLabel("Ordem:");
		lblOrdem.setBounds(316, 45, 46, 14);
		contentPane.add(lblOrdem);
		
		textField_3 = new JTextField();
		textField_3.setBounds(363, 42, 97, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblOrdem_1 = new JLabel("Ordem:");
		lblOrdem_1.setBounds(316, 76, 46, 14);
		contentPane.add(lblOrdem_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(363, 73, 97, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblOrdem_2 = new JLabel("Ordem:");
		lblOrdem_2.setBounds(316, 107, 46, 14);
		contentPane.add(lblOrdem_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(363, 104, 97, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnGerarSenha = new JButton("Gerar senha");
		btnGerarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, String> parametros = new HashMap<String, String>();
				parametros.put("qtdCaracteres", txtA.getText());
				parametros.put("letrasMinusculas", textField.getText());
				parametros.put("letrasMaiusculas", textField_1.getText());
				parametros.put("simbolos", textField_2.getText());
				parametros.put("ordemLetrasMinusculas", textField_3.getText());
				parametros.put("ordemLetrasMaiusculas", textField_4.getText());
				parametros.put("ordemSimbolos", textField_5.getText());
				String senha = null;
				try {
					senha = senhaAction.gerarSenha(parametros);
					if (senha != null) textField_6.setText(senha);
					String mensagem = parametros.get("mensagem");
					if (mensagem == null)
						JOptionPane.showMessageDialog(null, "Houve um erro desconhecido.");
					else
						JOptionPane.showMessageDialog(null, mensagem);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Houve um erro:\n"+e.getMessage());
				}
			}
		});
		btnGerarSenha.setBounds(10, 153, 97, 23);
		contentPane.add(btnGerarSenha);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setBounds(10, 204, 160, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
	}
}
