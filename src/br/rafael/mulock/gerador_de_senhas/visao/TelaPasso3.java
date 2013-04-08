package br.rafael.mulock.gerador_de_senhas.visao;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public final class TelaPasso3 extends JFrame {

	/**
	 * Terceira tela a ser exibida pela aplicação
	 */
	private static final long serialVersionUID = 3L;
	private JPanel contentPane;
	private JTextField txtNovaSenha;

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
		
		JLabel lblNovaSenhaGerada = new JLabel("Nova senha gerada:");
		lblNovaSenhaGerada.setBounds(10, 72, 122, 14);
		contentPane.add(lblNovaSenhaGerada);
		
		txtNovaSenha = new JTextField();
		txtNovaSenha.setEditable(false);
		txtNovaSenha.setBounds(135, 69, 122, 20);
		txtNovaSenha.setColumns(10);
		txtNovaSenha.setText((String) parametros.get("senha"));
		contentPane.add(txtNovaSenha);
		
		JButton btnCopiar = new JButton("<html><center>Copiar para a \u00E1rea<br/>de tr\u00E2nsfer\u00EAncia</center></html>");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
				StringSelection selection = new StringSelection(txtNovaSenha.getText());  
				clipboard.setContents(selection, null);
			}
		});
		btnCopiar.setBounds(274, 61, 150, 37);
		contentPane.add(btnCopiar);
		
		JButton btnReiniciarOPrograma = new JButton("Reiniciar o programa");
		btnReiniciarOPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
			}
		});
		btnReiniciarOPrograma.setBounds(39, 142, 153, 23);
		contentPane.add(btnReiniciarOPrograma);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(274, 142, 81, 23);
		contentPane.add(btnFechar);
	}
}
