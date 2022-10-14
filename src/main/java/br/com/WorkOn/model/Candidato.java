package br.com.WorkOn.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public class Candidato {

	@NotBlank(message = "É necessário informar um nome completo ")
	private String nome;
	@PastOrPresent(message = "A data de nascimento deve ser menor ou igual a hoje")
	private LocalDate dataNasc;
	@NotBlank(message = "É necessário informar um telefone")
	private String telefone;
	@NotBlank(message = "É necessário informar seu gênero")
	private String genero;
	private String email;

	public Candidato(@NotBlank(message = "É necessário informar um nome completo ") String nome,
			@PastOrPresent(message = "A data de nascimento deve ser menor ou igual a hoje") LocalDate dataNasc,
			@NotBlank(message = "É necessário informar um telefone") String telefone,
			@NotBlank(message = "É necessário informar seu gênero") String genero, String email) {
		super();
		this.nome = nome;
		this.dataNasc = dataNasc;
		this.telefone = telefone;
		this.genero = genero;
		this.email = email;
	}

	public Candidato() {
		super();
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Candidato [nome=" + nome + ", dataNasc=" + dataNasc + ", telefone=" + telefone + ", genero=" + genero
				+ "]";
	}
	
	

}