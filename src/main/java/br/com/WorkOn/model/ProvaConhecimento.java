package br.com.WorkOn.model;

import jakarta.validation.constraints.NotBlank;

public class ProvaConhecimento {
	@NotBlank(message = "Para a publicação de uma vaga é obrigatório inserir o tema da prova de conhecimento! ")
	private String assuntoTeste;
	private String textoQuestao;
	private String alternativaA;
	private String alternativaB;
	private String alternativaC;
	private String alternativaD;
	private String alternativaCorreta;

	public ProvaConhecimento(
			@NotBlank(message = "Para a publicação de uma vaga é obrigatório inserir o tema da prova de conhecimento! ") String assuntoTeste) {
		super();
		this.assuntoTeste = assuntoTeste;
	}

	public ProvaConhecimento(String assuntoTeste, String textoQuestao, String alternativaA, String alternativaB,
			String alternativaC, String alternativaD, String alternativaCorreta) {
		super();
		this.assuntoTeste = assuntoTeste;
		this.textoQuestao = textoQuestao;
		this.alternativaA = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.alternativaCorreta = alternativaCorreta;
	}

	public ProvaConhecimento() {
		super();
	}

	public ProvaConhecimento(String textoQuestao, String alternativaA, String alternativaB, String alternativaC,
			String alternativaD, String alternativaCorreta) {
		super();
		this.textoQuestao = textoQuestao;
		this.alternativaA = alternativaA;
		this.alternativaB = alternativaB;
		this.alternativaC = alternativaC;
		this.alternativaD = alternativaD;
		this.alternativaCorreta = alternativaCorreta;
	}

	public String getAssuntoTeste() {
		return assuntoTeste;
	}

	public void setAssuntoTeste(String assuntoTeste) {
		this.assuntoTeste = assuntoTeste;
	}

	public String getTextoQuestao() {
		return textoQuestao;
	}

	public void setTextoQuestao(String textoQuestao) {
		this.textoQuestao = textoQuestao;
	}

	public String getAlternativaA() {
		return alternativaA;
	}

	public void setAlternativaA(String alternativaA) {
		this.alternativaA = alternativaA;
	}

	public String getAlternativaB() {
		return alternativaB;
	}

	public void setAlternativaB(String alternativaB) {
		this.alternativaB = alternativaB;
	}

	public String getAlternativaC() {
		return alternativaC;
	}

	public void setAlternativaC(String alternativaC) {
		this.alternativaC = alternativaC;
	}

	public String getAlternativaD() {
		return alternativaD;
	}

	public void setAlternativaD(String alternativaD) {
		this.alternativaD = alternativaD;
	}

	public String getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(String alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

}