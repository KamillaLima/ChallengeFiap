package br.com.WorkOn.model;

import jakarta.validation.constraints.NotBlank;

public abstract class Login {
	@NotBlank(message= "Informe a senha")
	private String senha;

	
	public Login(@NotBlank(message = "Informe a senha") String senha) {
		super();
		this.senha = senha;
	}

	public Login() {
		super();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
