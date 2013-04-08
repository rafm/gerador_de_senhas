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
import java.awt.Color;

public final class TelaPrincipal extends JFrame {


	/**
	 * Primeira tela a ser exibida pela aplicação
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQtdCaracteres;

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
		setBounds(0, 0, 600, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuantidadeDeCaracteres = new JLabel("Quantidade de caracteres:");
		lblQuantidadeDeCaracteres.setBounds(10, 59, 151, 14);
		contentPane.add(lblQuantidadeDeCaracteres);
		
		txtQtdCaracteres = new JTextField();
		txtQtdCaracteres.setBounds(171, 56, 97, 20);
		contentPane.add(txtQtdCaracteres);
		txtQtdCaracteres.setColumns(10);
		
		JButton btnGerarSenha = new JButton("Seguinte");
		btnGerarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if("".equals(txtQtdCaracteres.getText())) {
					JOptionPane.showMessageDialog(null, "Digite uma quantidade de caracteres");
				} else {
					try {
						int qtdCaracteres = Integer.parseInt(txtQtdCaracteres.getText());
						
						if (qtdCaracteres > 0) {
							Map<String, Object> parametros = new HashMap<String, Object>();
							parametros.put("qtdCaracteres", qtdCaracteres);
							
							dispose();
							TelaPasso2 telaPasso2 = new TelaPasso2(parametros);
							telaPasso2.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "Digite uma quantidade maior do que 0");
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Digite somente números inteiros");
					}
				}

//				parametros.put("letrasMinusculas", txtLetrasMinusculas.getText());
//				parametros.put("letrasMaiusculas", txtLetrasMaiusculas.getText());
//				parametros.put("simbolos", txtSimbolos.getText());
//
//				try {
//					if (senhaAction.gerarSenha(parametros)) {
//						txtSenha.setEnabled(true);
//						txtSenha.setVisible(true);
//						txtSenha.setText(parametros.get("senha"));
//					} else {
//						txtSenha.setEnabled(false);
//						txtSenha.setVisible(false);
//						txtSenha.setText("");
//					}
//
//					if (parametros.get("mensagem") != null)
//						JOptionPane.showMessageDialog(null, parametros.get("mensagem"));
//				} catch (Exception e) {
//					e.printStackTrace();
//					JOptionPane.showMessageDialog(null, "Houve um erro:\n"+e.getMessage());
//				}
			}
		});
		btnGerarSenha.setBounds(304, 55, 111, 23);
		contentPane.add(btnGerarSenha);
	}
}
