package main.java.cdp.classesAnemicas;

import java.util.List;

public class ComposicaoFamiliar {
	private int id;
	private List<Parente> parentes;
	private boolean edita;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Parente> getParentes() {
		return parentes;
	}
	public void setParentes(List<Parente> parentes) {
		this.parentes = parentes;
	}
	public boolean isEdita() {
		return edita;
	}
	public void setEdita(boolean edita) {
		this.edita = edita;
	}
	
}
