package br.com.WorkOn.model;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class Vaga {

	@NotNull(message = "É obrigatório inserir um salário")
	@PositiveOrZero(message = "O salário deve ser maior do que R$0,00")
	private double salario;
	
	@NotBlank(message = "É obrigatório inserir um nome na vaga")
	private String nome;
	
	@NotBlank(message = "É obrigatório inserir um nome o cargo da vaga")
	private String cargo;
	
	@NotBlank(message = "É obrigatório inserir um descrição acerca da vaga")
	private String descricao;
	
	@NotNull(message = "É obrigatório inserir um valor de match mínimo")
	private int matchMinimo;
	
	@NotBlank(message = "É necessário informar o tipo da vaga")
	private String tipoVaga;

	
	

	public Vaga(
			@NotNull(message = "É obrigatório inserir um salário") @PositiveOrZero(message = "O salário deve ser maior do que R$0,00") double salario,
			@NotBlank(message = "É obrigatório inserir um nome na vaga") String nome,
			@NotBlank(message = "É obrigatório inserir um nome o cargo da vaga") String cargo,
			@NotBlank(message = "É obrigatório inserir um descrição acerca da vaga") String descricao,
			@NotNull(message = "É obrigatório inserir um valor de match mínimo") int matchMinimo,
			@NotBlank(message = "É necessário informar o tipo da vaga") String tipoVaga) {
		super();
		this.salario = salario;
		this.nome = nome;
		this.cargo = cargo;
		this.descricao = descricao;
		this.matchMinimo = matchMinimo;
		this.tipoVaga = tipoVaga;
	}

	public Vaga() {
		super();
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getMatchMinimo() {
		return matchMinimo;
	}

	public void setMatchMinimo(int matchMinimo) {
		this.matchMinimo = matchMinimo;
	}

	public String getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

	@Override
	public String toString() {
		return "Vaga [salario=" + salario + ", nome=" + nome + ", cargo=" + cargo + ", descricao=" + descricao
				+ ", matchMinimo=" + matchMinimo + ", tipoVaga=" + tipoVaga + "]";
	}

	
	

	
}