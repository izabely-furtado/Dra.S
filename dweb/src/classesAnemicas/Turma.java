package classesAnemicas;

import java.util.List;

public class Turma {
	private List<Aluno> alunos;
	private List<Professor> professores;
	private int n�vel;
	private List<Aula> aulas;
	
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
	public List<Aula> getPresentes() {
		return aulas;
	}
	public void setPresentes(List<Aula> aulas) {
		this.aulas = aulas;
	}
	
}
