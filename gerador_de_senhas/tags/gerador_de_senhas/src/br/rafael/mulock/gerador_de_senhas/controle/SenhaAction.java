package br.rafael.mulock.gerador_de_senhas.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class SenhaAction {

	public static final int LETRAS_MINUSCULAS = 1;
	public static final int LETRAS_MAIUSCULAS = 2;
	public static final int NUMEROS = 3;
	public static final int SIMBOLOS = 4;
	
	public static final int VALOR_INICIAL_CARACTERES_MINUSCULOS = 97;
	public static final int VALOR_FINAL_CARACTERES_MINUSCULOS = 122;
	public static final int VALOR_INICIAL_CARACTERES_MAIUSCULOS = 65;
	public static final int VALOR_FINAL_CARACTERES_MAIUSCULOS = 90;
	public static final int VALOR_INICIAL_NUMEROS = 48;
	public static final int VALOR_FINAL_NUMEROS = 57;
	public static final int VALOR_INICIAL_SIMBOLOS = 33;
	public static final int VALOR_FINAL_SIMBOLOS = 47;
	
	@SuppressWarnings("unchecked")
	public boolean gerarSenha(Map<String, Object> parametros) throws Exception {
		
		int qtdCaracteres = (Integer) parametros.get("qtdCaracteres");
		
		List<Integer> listaLetrasMinusculas = (ArrayList<Integer>) parametros.get("listaLetrasMinusculas");
		List<Integer> listaLetrasMaiusculas = (ArrayList<Integer>) parametros.get("listaLetrasMaiusculas");
		List<Integer> listaNumeros = (ArrayList<Integer>) parametros.get("listaNumeros");
		List<Integer> listaSimbolos = (ArrayList<Integer>) parametros.get("listaSimbolos");
		
		boolean flagLetrasMinusculas = !listaLetrasMinusculas.isEmpty();
		boolean flagLetrasMaiusculas = !listaLetrasMaiusculas.isEmpty();
		boolean flagNumeros = !listaNumeros.isEmpty();
		boolean flagSimbolos = !listaSimbolos.isEmpty();
		
		int padrao = (Integer) parametros.get("padrao");
		
		String senha = new String();
		
		if (!flagLetrasMinusculas &&
			!flagLetrasMaiusculas &&
			!flagNumeros &&
			!flagSimbolos) {
			
			for (int i = 0; i < qtdCaracteres; i++) {
				switch (padrao) {
					case SenhaAction.LETRAS_MINUSCULAS: {
						senha = senha + (char) (VALOR_INICIAL_CARACTERES_MINUSCULOS + (Math.random() * (1+(VALOR_FINAL_CARACTERES_MINUSCULOS - VALOR_INICIAL_CARACTERES_MINUSCULOS))));
						break;
					}
					
					case SenhaAction.LETRAS_MAIUSCULAS: {
						senha = senha + (char) (VALOR_INICIAL_CARACTERES_MAIUSCULOS + (Math.random() * (1+(VALOR_FINAL_CARACTERES_MAIUSCULOS - VALOR_INICIAL_CARACTERES_MAIUSCULOS))));
						break;
					}
					
					case SenhaAction.NUMEROS: {
						senha = senha + (char) (VALOR_INICIAL_NUMEROS + (Math.random() * (1+(VALOR_FINAL_NUMEROS - VALOR_INICIAL_NUMEROS))));
						break;
					}
					
					case SenhaAction.SIMBOLOS: {
						senha = senha + (char) (VALOR_INICIAL_SIMBOLOS + (Math.random() * (1+(VALOR_FINAL_SIMBOLOS - VALOR_INICIAL_SIMBOLOS))));
						break;
					}
					
					default: {
						parametros.put("mensagem", "Padrão não foi selecionado corretamente");
						return false;
					}
				}
			}
		} else {
			int valorTotal;
			
			int isCaracterMinusculo;
			int isCaracterMaiusculo;
			int isNumero;
			int isSimbolo;
			
			for (int i = 1; i <= qtdCaracteres; i++) {
				valorTotal = 0;
				
				isCaracterMinusculo = 0;
				isCaracterMaiusculo = 0;
				isNumero = 0;
				isSimbolo = 0;
				
				if (listaLetrasMinusculas.contains(i)) {
					isCaracterMinusculo = ++valorTotal;
				}
				
				if (listaLetrasMaiusculas.contains(i)) {
					isCaracterMaiusculo = ++valorTotal;
				}
				
				if (listaNumeros.contains(i)) {
					isNumero = ++valorTotal;
				}
				
				if (listaSimbolos.contains(i)) {
					isSimbolo = ++valorTotal;
				}
				
				if (valorTotal == 0) {
					switch (padrao) {
						case SenhaAction.LETRAS_MINUSCULAS: {
							senha = senha + (char) (VALOR_INICIAL_CARACTERES_MINUSCULOS + (Math.random() * (1+(VALOR_FINAL_CARACTERES_MINUSCULOS - VALOR_INICIAL_CARACTERES_MINUSCULOS))));
							break;
						}
							
						case SenhaAction.LETRAS_MAIUSCULAS: {
							senha = senha + (char) (VALOR_INICIAL_CARACTERES_MAIUSCULOS + (Math.random() * (1+(VALOR_FINAL_CARACTERES_MAIUSCULOS - VALOR_INICIAL_CARACTERES_MAIUSCULOS))));
							break;
						}
								
						case SenhaAction.NUMEROS: {
							senha = senha + (char) (VALOR_INICIAL_NUMEROS + (Math.random() * (1+(VALOR_FINAL_NUMEROS - VALOR_INICIAL_NUMEROS))));
							break;
						}
							
						case SenhaAction.SIMBOLOS: {
							senha = senha + (char) (VALOR_INICIAL_SIMBOLOS + (Math.random() * (1+(VALOR_FINAL_SIMBOLOS - VALOR_INICIAL_SIMBOLOS))));
							break;
						}
							
						default: {
							parametros.put("mensagem", "Padrão não foi selecionado corretamente");
							return false;
						}
					}
				} else {
					int verificar = 1 + ((int) (Math.random() * valorTotal));
					
					if (verificar == isCaracterMinusculo) {
						senha = senha + (char) (VALOR_INICIAL_CARACTERES_MINUSCULOS + (Math.random() * (1+(VALOR_FINAL_CARACTERES_MINUSCULOS - VALOR_INICIAL_CARACTERES_MINUSCULOS))));
					} else if (verificar == isCaracterMaiusculo) {
						senha = senha + (char) (VALOR_INICIAL_CARACTERES_MAIUSCULOS + (Math.random() * (1+(VALOR_FINAL_CARACTERES_MAIUSCULOS - VALOR_INICIAL_CARACTERES_MAIUSCULOS))));
					} else if (verificar == isNumero) {
						senha = senha + (char) (VALOR_INICIAL_NUMEROS + (Math.random() * (1+(VALOR_FINAL_NUMEROS - VALOR_INICIAL_NUMEROS))));
					} else if (verificar == isSimbolo) {
						senha = senha + (char) (VALOR_INICIAL_SIMBOLOS + (Math.random() * (1+(VALOR_FINAL_SIMBOLOS - VALOR_INICIAL_SIMBOLOS))));
					} else {
						parametros.put("mensagem", "Padrão não foi selecionado corretamente");
						return false;
					}
				}
			}
		}
		
		parametros.put("senha", senha);
		parametros.put("mensagem", "Senha gerada com sucesso");
		return true;
	}
}
