package br.com.WorkOn.model;

import jakarta.validation.constraints.NotBlank;

public class Endereco {

	@NotBlank(message = "É necessário informar o logradouro")
	private String logradouro;
	@NotBlank(message = "É necessário informar o número da residência")
	private int numero;
	@NotBlank(message = "É necessário informar o bairro")
	private String bairro;
	@NotBlank(message = "É necessário informar a sigla do estado")
	private String SiglaEstado;
	@NotBlank(message = "É necessário informar a cidade")
	private String cidade;

	public Endereco(@NotBlank(message = "É necessário informar o logradouro") String logradouro,
			@NotBlank(message = "É necessário informar o número da residência") int numero,
			@NotBlank(message = "É necessário informar o bairro") String bairro,
			@NotBlank(message = "É necessário informar a sigla do estado") String siglaEstado,
			@NotBlank(message = "É necessário informar a cidade") String cidade) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		SiglaEstado = siglaEstado;
		this.cidade = cidade;
	}

	public Endereco() {
		super();
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getSiglaEstado() {
		return SiglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		SiglaEstado = siglaEstado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + ", SiglaEstado="
				+ SiglaEstado + ", cidade=" + cidade + "]";
	}
	
	
}