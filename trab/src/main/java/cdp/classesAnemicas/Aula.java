package cdp.classesAnemicas;

import java.util.List;

public class Aula {
	private int id;
	private String tipo;
	private String horario;
	private String data;
	private String conteudo;
	private List<Aluno> presentes;
	private boolean edita;
	private Turma turma;
	public Aula(){
		this.id = -1;
		this.conteudo = "";
		this.data = "";
		this.edita = false;
		this.horario = "";
		this.tipo = "";
		this.turma = new Turma();
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public List<Aluno> getPresentes() {
		return presentes;
	}
	public void setPresentes(List<Aluno> presentes) {
		this.presentes = presentes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEdita() {
		return edita;
	}
	public void setEdita(boolean edita) {
		this.edita = edita;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
