package cdp.classesAnemicas;

import java.util.List;

public class Turma implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String codigo;
	private int maximo;
	private String turno;
	private int nivel;
	private boolean segunda;
	private boolean terca;
	private boolean quarta;
	private boolean quinta;
	private boolean sexta;
	/*private List<Aluno> alunos;
	private List<Aula> aulas;
	private boolean edita;*/
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getMaximo() {
		return maximo;
	}
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public boolean isSegunda() {
		return segunda;
	}
	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}
	public boolean isTerca() {
		return terca;
	}
	public void setTerca(boolean terca) {
		this.terca = terca;
	}
	public boolean isQuarta() {
		return quarta;
	}
	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}
	public boolean isQuinta() {
		return quinta;
	}
	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}
	public boolean isSexta() {
		return sexta;
	}
	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}
	/*public List<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	public List<Aula> getAulas() {
		return aulas;
	}
	public void setAulas(List<Aula> aulas) {
		this.aulas = aulas;
	}*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*
	public boolean isEdita() {
		return edita;
	}
	public void setEdita(boolean edita) {
		this.edita = edita;
	}*/
}
