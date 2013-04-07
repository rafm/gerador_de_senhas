package br.rafael.mulock.gerador_de_senhas.visao;

import java.awt.Color;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public final class TelaPasso3 extends JFrame {

	/**
	 * Terceira tela a ser exibida pela aplicação
	 */
	private static final long serialVersionUID = 3L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public TelaPasso3(Map<String, Object> parametros) {
		setTitle("Gerador de senhas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
	}

}
