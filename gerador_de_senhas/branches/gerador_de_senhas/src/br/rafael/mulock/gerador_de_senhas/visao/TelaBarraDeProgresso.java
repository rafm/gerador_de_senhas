package br.rafael.mulock.gerador_de_senhas.visao;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.Rectangle;

public class TelaBarraDeProgresso extends JFrame {
	
	/**
	 * Versão 1.0 da barra de progresso
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar barraDeProgresso;
	
	public TelaBarraDeProgresso() {
		setBounds(new Rectangle(0, 0, 180, 50));
		setUndecorated(true);
		setTitle("Aguarde...");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		
		barraDeProgresso = new JProgressBar();
		barraDeProgresso.setBounds(10, 11, 162, 28);
		barraDeProgresso.setIndeterminate(true);
		contentPane.add(barraDeProgresso);
	}
}
