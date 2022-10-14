package br.com.WorkOn.model;

public class RedesSociais {
	
	private String linkLinkedin;
	private String linkGithub;

	
	public RedesSociais(String linkLinkedin, String linkGithub) {
		super();
		this.linkLinkedin = linkLinkedin;
		this.linkGithub = linkGithub;
	}

	public RedesSociais() {
		super();
	}
	
	
	public String getLinkLinkedin() {
		return linkLinkedin;
	}

	public void setLinkLinkedin(String linkLinkedin) {
		this.linkLinkedin = linkLinkedin;
	}

	public String getLinkGithub() {
		return linkGithub;
	}

	public void setLinkGithub(String linkGithub) {
		this.linkGithub = linkGithub;
	}

	@Override
	public String toString() {
		return "RedesSociais [linkLinkedin=" + linkLinkedin + ", linkGithub=" + linkGithub + "]";
	}


	


}
