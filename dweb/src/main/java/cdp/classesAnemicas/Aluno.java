package main.java.cdp.classesAnemicas;

public class Aluno {
	private int id;
	private String foto;
	private int nivel;
	private FormularioAcompanhamentoPsicossocial form;
	private Turma turma;
	private boolean edita;
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public FormularioAcompanhamentoPsicossocial getForm() {
		return form;
	}
	public void setForm(FormularioAcompanhamentoPsicossocial form) {
		this.form = form;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
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
	
}
