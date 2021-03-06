package br.rafael.mulock.gerador_de_senhas.visao;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import br.rafael.mulock.gerador_de_senhas.controle.SenhaAction;

public final class TelaPasso2 extends JFrame {

	/**
	 * Segunda tela a ser exibida pela aplica��o
	 */
	private static final long serialVersionUID = 2L;
	private JPanel contentPane;
	private JList<Integer> listPosicao;
	private JList<Integer> listLetrasMinusculas;
	private JList<Integer> listLetrasMaiusculas;
	private JList<Integer> listNumeros;
	private JList<Integer> listSimbolos;
	private ButtonGroup rdbtnGroup;
	private JRadioButton rdbtnLetrasMinusculas;
	private JRadioButton rdbtnLetrasMaiusculas;
	private JRadioButton rdbtnNumeros;
	private JRadioButton rdbtnSimbolos;

	/**
	 * Create the frame.
	 */
	public TelaPasso2(final Map<String, Object> parametros) {
		setTitle("Gerador de senhas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 360);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		
		rdbtnGroup = new ButtonGroup();
		
		rdbtnLetrasMinusculas = new JRadioButton("Letras min\u00FAsculas");
		rdbtnLetrasMinusculas.setBackground(Color.WHITE);
		rdbtnLetrasMinusculas.setBounds(138, 63, 141, 23);
		contentPane.add(rdbtnLetrasMinusculas);
		rdbtnGroup.add(rdbtnLetrasMinusculas);
		
		rdbtnLetrasMaiusculas = new JRadioButton("Letras mai\u00FAsculas");
		rdbtnLetrasMaiusculas.setBackground(Color.WHITE);
		rdbtnLetrasMaiusculas.setBounds(301, 63, 141, 23);
		contentPane.add(rdbtnLetrasMaiusculas);
		rdbtnGroup.add(rdbtnLetrasMaiusculas);
		
		rdbtnNumeros = new JRadioButton("N\u00FAmeros");
		rdbtnNumeros.setBackground(Color.WHITE);
		rdbtnNumeros.setBounds(440, 63, 109, 23);
		contentPane.add(rdbtnNumeros);
		rdbtnGroup.add(rdbtnNumeros);
		
		rdbtnSimbolos = new JRadioButton("S\u00EDmbolos/Caracteres especiais");
		rdbtnSimbolos.setBackground(Color.WHITE);
		rdbtnSimbolos.setBounds(590, 63, 203, 23);
		contentPane.add(rdbtnSimbolos);
		rdbtnGroup.add(rdbtnSimbolos);
		
		JButton btnAdicionarLetrasMinusculas = new JButton("+");
		btnAdicionarLetrasMinusculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> listaValoresSelecionados = listPosicao.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listLetrasMinusculas.getModel().getSize(); i++)
						listaNova.add(listLetrasMinusculas.getModel().getElementAt(i));
					
					if (!listaNova.contains(listaValoresSelecionados)) {
						for(Integer valorSelecionado : listaValoresSelecionados)
							listaNova.add(valorSelecionado);
						
						listLetrasMinusculas.setListData(listaNova.toArray(new Integer[listaNova.size()]));
					}
				}
			}
		});
		btnAdicionarLetrasMinusculas.setBounds(138, 212, 41, 23);
		contentPane.add(btnAdicionarLetrasMinusculas);
		
		JButton btnDiminuirLetrasMinusculas = new JButton("-");
		btnDiminuirLetrasMinusculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> listaValoresSelecionados = listLetrasMinusculas.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listLetrasMinusculas.getModel().getSize(); i++)
						listaNova.add(listLetrasMinusculas.getModel().getElementAt(i));
					
					for(Integer valorSelecionado : listaValoresSelecionados)
						listaNova.remove(valorSelecionado);
						
					listLetrasMinusculas.setListData(listaNova.toArray(new Integer[listaNova.size()]));
				}
			}
		});
		btnDiminuirLetrasMinusculas.setBounds(206, 212, 41, 23);
		contentPane.add(btnDiminuirLetrasMinusculas);
		
		JButton btnAdicionarLetrasMaiusculas = new JButton("+");
		btnAdicionarLetrasMaiusculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> listaValoresSelecionados = listPosicao.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listLetrasMaiusculas.getModel().getSize(); i++)
						listaNova.add(listLetrasMaiusculas.getModel().getElementAt(i));
					
					if (!listaNova.contains(listaValoresSelecionados)) {
						for(Integer valorSelecionado : listaValoresSelecionados)
							listaNova.add(valorSelecionado);
						
						listLetrasMaiusculas.setListData(listaNova.toArray(new Integer[listaNova.size()]));
					}
				}
			}
		});
		btnAdicionarLetrasMaiusculas.setBounds(301, 212, 41, 23);
		contentPane.add(btnAdicionarLetrasMaiusculas);
		
		JButton btnDiminuirLetrasMaiusculas = new JButton("-");
		btnDiminuirLetrasMaiusculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> listaValoresSelecionados = listLetrasMaiusculas.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listLetrasMaiusculas.getModel().getSize(); i++)
						listaNova.add(listLetrasMaiusculas.getModel().getElementAt(i));
					
					for(Integer valorSelecionado : listaValoresSelecionados)
						listaNova.remove(valorSelecionado);
						
					listLetrasMaiusculas.setListData(listaNova.toArray(new Integer[listaNova.size()]));
				}
			}
		});
		btnDiminuirLetrasMaiusculas.setBounds(369, 212, 41, 23);
		contentPane.add(btnDiminuirLetrasMaiusculas);
		
		JButton btnAdicionarSimbolos = new JButton("+");
		btnAdicionarSimbolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> listaValoresSelecionados = listPosicao.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listSimbolos.getModel().getSize(); i++)
						listaNova.add(listSimbolos.getModel().getElementAt(i));
					
					if (!listaNova.contains(listaValoresSelecionados)) {
						for(Integer valorSelecionado : listaValoresSelecionados)
							listaNova.add(valorSelecionado);
						
						listSimbolos.setListData(listaNova.toArray(new Integer[listaNova.size()]));
					}
				}
			}
		});
		
		JButton btnAdicionarNumeros = new JButton("+");
		btnAdicionarNumeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Integer> listaValoresSelecionados = listPosicao.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listNumeros.getModel().getSize(); i++)
						listaNova.add(listNumeros.getModel().getElementAt(i));
					
					if (!listaNova.contains(listaValoresSelecionados)) {
						for(Integer valorSelecionado : listaValoresSelecionados)
							listaNova.add(valorSelecionado);
						
						listNumeros.setListData(listaNova.toArray(new Integer[listaNova.size()]));
					}
				}
			}
		});
		btnAdicionarNumeros.setBounds(440, 212, 41, 23);
		contentPane.add(btnAdicionarNumeros);
		
		JButton btnDiminuirNumeros = new JButton("-");
		btnDiminuirNumeros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> listaValoresSelecionados = listNumeros.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listNumeros.getModel().getSize(); i++)
						listaNova.add(listNumeros.getModel().getElementAt(i));
					
					for(Integer valorSelecionado : listaValoresSelecionados)
						listaNova.remove(valorSelecionado);
						
					listNumeros.setListData(listaNova.toArray(new Integer[listaNova.size()]));
				}
			}
		});
		btnDiminuirNumeros.setBounds(514, 212, 41, 23);
		contentPane.add(btnDiminuirNumeros);
		btnAdicionarSimbolos.setBounds(590, 212, 41, 23);
		contentPane.add(btnAdicionarSimbolos);
		
		JButton btnDiminuirSimbolos = new JButton("-");
		btnDiminuirSimbolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> listaValoresSelecionados = listSimbolos.getSelectedValuesList();
				
				if (!listaValoresSelecionados.isEmpty()) {
					Set<Integer> listaNova = new HashSet<Integer>();
					
					for (int i = 0; i < listSimbolos.getModel().getSize(); i++)
						listaNova.add(listSimbolos.getModel().getElementAt(i));
					
					for(Integer valorSelecionado : listaValoresSelecionados)
						listaNova.remove(valorSelecionado);
						
					listSimbolos.setListData(listaNova.toArray(new Integer[listaNova.size()]));
				}
			}
		});
		btnDiminuirSimbolos.setBounds(671, 212, 41, 23);
		contentPane.add(btnDiminuirSimbolos);
		
		JLabel lblPosioDoCaracter = new JLabel("Posi\u00E7\u00E3o");
		lblPosioDoCaracter.setBounds(37, 67, 63, 14);
		contentPane.add(lblPosioDoCaracter);
		
		
		Vector<Integer> listaPosicoes = new Vector<Integer>();
		int qtdCaracteres = (Integer) parametros.get("qtdCaracteres");
		for (int i = 0; i < qtdCaracteres; listaPosicoes.add(++i));
		
		listPosicao = new JList<Integer>();
		listPosicao.setListData(listaPosicoes);
		
		JScrollPane scrollPaneListPosicoes = new JScrollPane(listPosicao);
		scrollPaneListPosicoes.setBounds(10, 93, 90, 100);
		contentPane.add(scrollPaneListPosicoes);
		
		listLetrasMinusculas = new JList<Integer>();
		listLetrasMinusculas.setBounds(138, 93, 109, 100);
		
		JScrollPane scrollPaneListLetrasMinusculas = new JScrollPane(listLetrasMinusculas);
		scrollPaneListLetrasMinusculas.setBounds(138, 93, 109, 100);
		contentPane.add(scrollPaneListLetrasMinusculas);
		
		listLetrasMaiusculas = new JList<Integer>();
		listLetrasMaiusculas.setBounds(301, 93, 109, 100);
		
		JScrollPane scrollPaneListLetrasMaiusculas = new JScrollPane(listLetrasMaiusculas);
		scrollPaneListLetrasMaiusculas.setBounds(301, 93, 109, 100);
		contentPane.add(scrollPaneListLetrasMaiusculas);
		
		JScrollPane scrollPaneListNumeros = new JScrollPane();
		scrollPaneListNumeros.setBounds(440, 93, 115, 100);
		contentPane.add(scrollPaneListNumeros);
		
		listNumeros = new JList<Integer>();
		scrollPaneListNumeros.setViewportView(listNumeros);
		
		listSimbolos = new JList<Integer>();
		listSimbolos.setBounds(475, 93, 109, 100);
		
		JScrollPane scrollPaneListSimbolos = new JScrollPane(listSimbolos);
		scrollPaneListSimbolos.setBounds(590, 93, 109, 100);
		contentPane.add(scrollPaneListSimbolos);
		
		JButton btnSeguinte = new JButton("Gerar Senha");
		btnSeguinte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnGroup.getSelection() == null) {
					JOptionPane.showMessageDialog(null, "Selecione um padr�o para a senha");
				} else {
					if (rdbtnLetrasMaiusculas.isSelected())
						parametros.put("padrao", SenhaAction.LETRAS_MAIUSCULAS);
					else if (rdbtnLetrasMinusculas.isSelected())
						parametros.put("padrao", SenhaAction.LETRAS_MINUSCULAS);
					else if (rdbtnNumeros.isSelected())
						parametros.put("padrao", SenhaAction.NUMEROS);
					else if (rdbtnSimbolos.isSelected())
						parametros.put("padrao", SenhaAction.SIMBOLOS);
					
					List<Integer> listaLetrasMinusculas = new ArrayList<Integer>();
					List<Integer> listaLetrasMaiusculas = new ArrayList<Integer>();
					List<Integer> listaNumeros = new ArrayList<Integer>();
					List<Integer> listaSimbolos = new ArrayList<Integer>();
					
					if (listLetrasMinusculas.getModel().getSize() > 0)
						for (int i = 0; i < listLetrasMinusculas.getModel().getSize(); i++)
							listaLetrasMinusculas.add(listLetrasMinusculas.getModel().getElementAt(i));
					
					if (listLetrasMaiusculas.getModel().getSize() > 0)
						for (int i = 0; i < listLetrasMaiusculas.getModel().getSize(); i++)
							listaLetrasMaiusculas.add(listLetrasMaiusculas.getModel().getElementAt(i));
					
					if (listNumeros.getModel().getSize() > 0)
						for (int i = 0; i < listNumeros.getModel().getSize(); i++)
							listaNumeros.add(listNumeros.getModel().getElementAt(i));
					
					if (listSimbolos.getModel().getSize() > 0)
						for (int i = 0; i < listSimbolos.getModel().getSize(); i++)
							listaSimbolos.add(listSimbolos.getModel().getElementAt(i));
					
					parametros.put("listaLetrasMinusculas", listaLetrasMinusculas);
					parametros.put("listaLetrasMaiusculas", listaLetrasMaiusculas);
					parametros.put("listaNumeros", listaNumeros);
					parametros.put("listaSimbolos", listaSimbolos);
					
					dispose();
					TelaBarraDeProgresso aguarde = new TelaBarraDeProgresso();
					aguarde.setVisible(true);
					
					try {
						new SenhaAction().gerarSenha(parametros);
					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Erro ao gerar a senha. O programa ser� fechado.");
						System.exit(0);
					}
					
					TelaPasso3 telaPasso3 = new TelaPasso3(parametros);
					telaPasso3.setVisible(true);
					aguarde.dispose();
				}
			}
		});
		btnSeguinte.setBounds(513, 277, 118, 23);
		contentPane.add(btnSeguinte);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				TelaPrincipal telaPrincipal = new TelaPrincipal();
				telaPrincipal.setVisible(true);
			}
		});
		btnVoltar.setBounds(353, 277, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnLimparListas = new JButton("Limpar listas");
		btnLimparListas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listLetrasMaiusculas.setListData(new Integer[0]);
				listLetrasMinusculas.setListData(new Integer[0]);
				listNumeros.setListData(new Integer[0]);
				listSimbolos.setListData(new Integer[0]);
			}
		});
		btnLimparListas.setBounds(196, 277, 109, 23);
		contentPane.add(btnLimparListas);
		
		JButton btnLimparPadro = new JButton("Limpar padr\u00E3o");
		btnLimparPadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnGroup.clearSelection();
			}
		});
		btnLimparPadro.setBounds(37, 277, 124, 23);
		contentPane.add(btnLimparPadro);

	}
}
