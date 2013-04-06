package br.rafael.mulock.gerador_de_senhas.visao;

import javax.swing.JFrame;

public class TelaPrincipal_BKP extends JFrame {

	/**
	 * Versão 1.0 da TelaPrincipal
	 */
	private static final long serialVersionUID = 1L;
	
	public TelaPrincipal_BKP() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName(getClass().getSimpleName());
		setTitle("Gerador de senhas");
		setVisible(true);
		setSize(500, 500);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		TelaPrincipal_BKP telaPrincipal = new TelaPrincipal_BKP();
	}
}
