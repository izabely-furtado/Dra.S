package classesAnemicas;

import java.util.List;

public class Turma {
	private List<Aluno> alunos;
	private List<Professor> professores;
	private int nível;
	private List<Presença> presentes;
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}
	public int getNível() {
		return nível;
	}
	public void setNível(int nível) {
		this.nível = nível;
	}
	public List<Presença> getPresentes() {
		return presentes;
	}
	public void setPresentes(List<Presença> presentes) {
		this.presentes = presentes;
	}
	
}
