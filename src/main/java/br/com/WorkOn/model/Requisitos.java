package br.com.WorkOn.model;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;

public class Requisitos {
	@NotBlank(message = "A lista de requisitos é obrigatória ser preenchida")
	private Set<Integer> requisitos;

	public Requisitos(
			@NotBlank(message = "A lista de requisitos é obrigatória ser preenchida") Set<Integer> requisitos) {
		super();
		this.requisitos = requisitos;
	}

	public Requisitos() {
		super();
	}

	public Set<Integer> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(Set<Integer> requisitos) {
		this.requisitos = requisitos;
	}

	@Override
	public String toString() {
		return "Requisitos [requisitos=" + requisitos + "]";
	}

}