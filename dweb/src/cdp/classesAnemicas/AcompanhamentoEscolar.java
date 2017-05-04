package cdp.classesAnemicas;

import java.util.List;

public class AcompanhamentoEscolar {
	private int id;
	private String escola;
	private List<Integer> anos;
	private List<Integer> series;
	private boolean edita;
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public List<Integer> getAnos() {
		return anos;
	}
	public void setAnos(List<Integer> anos) {
		this.anos = anos;
	}
	public List<Integer> getSeries() {
		return series;
	}
	public void setSeries(List<Integer> series) {
		this.series = series;
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
