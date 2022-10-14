package br.com.WorkOn.model.dto;

import br.com.WorkOn.model.Vaga;

public class VagaDTO {
	
	int cadastrador;
	Vaga vaga;
	
	public VagaDTO(int cadastrador, Vaga vaga) {
		super();
		this.cadastrador = cadastrador;
		this.vaga = vaga;
	}
	public VagaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCadastrador() {
		return cadastrador;
	}
	public void setCadastrador(int cadastrador) {
		this.cadastrador = cadastrador;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	@Override
	public String toString() {
		return "VagaDTO [cadastrador=" + cadastrador + ", vaga=" + vaga + "]";
	}
	
	
}
