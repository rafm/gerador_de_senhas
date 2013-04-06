package br.rafael.mulock.gerador_de_senhas.controle.action;

import java.util.Map;

public class SenhaAction {

	public String gerarSenha(Map<String, String> parametros) throws Exception {

		int qtdCaracteres;
		
		try {
			qtdCaracteres = Integer.parseInt(parametros.get("qtdCaracteres"));
		} catch (Exception e) {
			parametros.put("mensagem", "Informe somente números no campo \"Quantidade de caracteres\"");
			return null;
		}

		parametros.get("letrasMinusculas");
		parametros.get("letrasMaiusculas");
		parametros.get("simbolos");
		parametros.get("ordemLetrasMinusculas");
		parametros.get("ordemLetrasMaiusculas");
		parametros.get("ordemSimbolos");
		return null;
	}
}
