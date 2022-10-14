package br.com.WorkOn.service;

import java.util.List;

public class CalcularResultados {
	
	public int resultadoProva(List<String>alternativas,List<String>alternativaCandidato) {
		int acertos = 0;
		for (int i = 0; i < alternativas.size(); i++) {
			if(alternativas.get(i).equals(alternativaCandidato.get(i))) {
				acertos+=1;
			}
		}
		
		return acertos;
	}
}
