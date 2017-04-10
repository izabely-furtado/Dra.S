package classesAnemicas;

import java.util.List;

public class ComposicaoFamiliar {
	private int id;
	private List<Parente> parentes;
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
	
}
