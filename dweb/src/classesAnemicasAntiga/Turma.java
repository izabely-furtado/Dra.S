package classesAnemicasAntiga;

import java.util.List;

public class Turma {
	private int id;
	private List<Aluno> alunos;
	private List<Professor> professores;
	private int n�vel;
	private List<Aula> aulas;
	private boolean edita;
	
	public List<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}
	public boolean isEdita() {
		return edita;
	}
	public void setEdita(boolean edita) {
		this.edita = edita;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
}
