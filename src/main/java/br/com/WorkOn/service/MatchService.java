package br.com.WorkOn.service;

import java.util.List;

public class MatchService {
	
	public int calcularMatch(List<Integer> listaVaga , List<Integer> listaCand) {
		int match = 0;
		for (int i = 0; i < listaVaga.size(); i++) {
			
			 int valor = listaVaga.get(i);
			 if(listaCand.contains(valor) == true) {
				 match+=20;
			 }else {
				 int d = valor+1;
				 int dd = valor +2;
				 if(listaCand.contains(d)==true) {
					 match+=20;
				 }else if(listaCand.contains(dd)==true) {
					 match+=20;
				 }
				 
			 }
		}
		return match;
		 
	}
}
