package classesAnemicas;

import java.util.List;

public class Turma {
	private List<Aluno> alunos;
	private List<Professor> professores;
	private int n�vel;
	private List<Presen�a> presentes;
	
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
	public int getN�vel() {
		return n�vel;
	}
	public void setN�vel(int n�vel) {
		this.n�vel = n�vel;
	}
	public List<Presen�a> getPresentes() {
		return presentes;
	}
	public void setPresentes(List<Presen�a> presentes) {
		this.presentes = presentes;
	}
	
}
