package main.java.cdp.classesAnemicas;

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
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof AcompanhamentoEscolar)) {
            return false;
        }

        AcompanhamentoEscolar acompanhamento = (AcompanhamentoEscolar) o;
        
        return acompanhamento.anos == this.anos &&
        	   acompanhamento.escola == this.escola &&
        	   acompanhamento.series == this.series &&
        	   acompanhamento.id == this.id;
    }
}
