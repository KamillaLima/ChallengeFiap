package br.com.WorkOn.model;

import jakarta.validation.constraints.NotBlank;

public class LoginCandidato extends Login {
	@NotBlank(message="Informe o e-mail")
	private String email;

	

	public LoginCandidato(@NotBlank(message = "Informe a senha") String senha,
			@NotBlank(message = "Informe o e-mail") String email) {
		super(senha);
		this.email = email;
	}

	public LoginCandidato() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}