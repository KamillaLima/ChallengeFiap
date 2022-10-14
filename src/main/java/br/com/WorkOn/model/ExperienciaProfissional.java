package br.com.WorkOn.model;

import java.time.LocalDate;

public class ExperienciaProfissional {
	private String nomeEmpresa;
	private String cargo;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	public ExperienciaProfissional(String nomeEmpresa, String cargo, LocalDate dataInicio, LocalDate dataTermino) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.cargo = cargo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}
	public ExperienciaProfissional(String nomeEmpresa, String cargo, LocalDate dataInicio) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.cargo = cargo;
		this.dataInicio = dataInicio;
	}
	public ExperienciaProfissional() {
		super();
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDate getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}
	@Override
	public String toString() {
		return "ExperienciaProfissional [nomeEmpresa=" + nomeEmpresa + ", cargo=" + cargo + ", dataInicio=" + dataInicio
				+ ", dataTermino=" + dataTermino + "]";
	}
	
	

	

}