package br.com.WorkOn.model;


import java.util.Date;

public class FormacaoAcademica {
	private Date dataInicio;
	private Date dataTermino;
	private String nomeCurso;
	private String nomeInstituicao;
	public FormacaoAcademica(Date dataIForm, Date dataTForm, String nomeCurso, String nomeInstituicao) {
		super();
		this.dataInicio = dataIForm;
		this.dataTermino = dataTForm;
		this.nomeCurso = nomeCurso;
		this.nomeInstituicao = nomeInstituicao;
	}
	
	
	public FormacaoAcademica() {
		super();
	}


	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}


	@Override
	public String toString() {
		return "FormacaoAcademica [dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", nomeCurso="
				+ nomeCurso + ", nomeInstituicao=" + nomeInstituicao + "]";
	}
	

	
}