package classesAnemicasAntiga;

public class AlunoInstituicao extends Aluno{
	private String nomeEscola;
	
	private String nomeResponsavel;
	private int nivelEscolaridade;
	private String matriculaEscola;
	private String telefoneEscola;
	public String getNomeEscola() {
		return nomeEscola;
	}
	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
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
