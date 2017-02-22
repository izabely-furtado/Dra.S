package classesAnemicas;

public class AlunoInstituição {
	private String nomeResponsavel;
	private int nivelEscolaridade;
	private String matriculaEscola;
	private String telefoneEscola;
	
	public String getTelefoneEscola() {
		return telefoneEscola;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public int getNivelEscolaridade() {
		return nivelEscolaridade;
	}
	public void setNivelEscolaridade(int nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}
	public String getMatriculaEscola() {
		return matriculaEscola;
	}
	public void setMatriculaEscola(String matriculaEscola) {
		this.matriculaEscola = matriculaEscola;
	}
	public void setTelefoneEscola(String telefoneEscola) {
		this.telefoneEscola = telefoneEscola;
	}

}
