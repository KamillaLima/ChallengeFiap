package br.com.WorkOn.model;

import jakarta.validation.constraints.NotBlank;

public class LoginRecrutador extends Login {

	@NotBlank(message = "Informe o código de verificação")
	private int codigo;

	
	public LoginRecrutador(@NotBlank(message = "Informe a senha") String senha,
			@NotBlank(message = "Informe o código de verificação") int codigo) {
		super(senha);
		this.codigo = codigo;
	}

	public LoginRecrutador() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}