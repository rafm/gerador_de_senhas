package br.rafael.mulock.gerador_de_senhas.controle.action;

import java.util.Map;

public final class SenhaAction {

	public static final int LETRAS_MINUSCULAS = 1;
	public static final int LETRAS_MAIUSCULAS = 2;
	public static final int SIMBOLOS = 3;
	
	public boolean gerarSenha(Map<String, Object> parametros) {
		
		return true;

//		int qtdCaracteres;
//		
//		try {
//			qtdCaracteres = Integer.parseInt(parametros.get("qtdCaracteres"));
//		} catch (Exception e) {
//			parametros.put("mensagem", "Informe somente números no campo \"Quantidade de caracteres\"");
//			return false;
//		}
//
//		parametros.get("letrasMinusculas");
//		parametros.get("letrasMaiusculas");
//		parametros.get("simbolos");
//		parametros.get("ordemLetrasMinusculas");
//		parametros.get("ordemLetrasMaiusculas");
//		parametros.get("ordemSimbolos");
//		return true;
	}
}
