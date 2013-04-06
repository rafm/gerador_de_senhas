package br.rafael.mulock.gerador_de_senhas.visao;

import javax.swing.JFrame;

public class TelaPrincipal extends JFrame {

	/**
	 * Versão 1.0 da TelaPrincipal
	 */
	private static final long serialVersionUID = 1L;
	
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName(getClass().getSimpleName());
		setTitle("Gerador de senhas");
		setVisible(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		TelaPrincipal telaPrincipal = new TelaPrincipal();
	}
}
