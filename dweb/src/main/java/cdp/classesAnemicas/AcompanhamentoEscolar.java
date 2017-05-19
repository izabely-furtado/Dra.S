package main.java.cdp.classesAnemicas;

import java.util.List;

public class AcompanhamentoEscolar {
	private int id;
	private String escola;
	private int ano1;
	private int ano2;
	private int ano3;
	private int ano4;
	private int ano5;
	private int ano6;
	private int ano7;
	private String serie1;
	private String serie2;
	private String serie3;
	private String serie4;
	private String serie5;
	private String serie6;
	private String serie7;
	
	public int getAno1() {
		return ano1;
	}
	public void setAno1(int ano1) {
		this.ano1 = ano1;
	}
	public int getAno2() {
		return ano2;
	}
	public void setAno2(int ano2) {
		this.ano2 = ano2;
	}
	public int getAno3() {
		return ano3;
	}
	public void setAno3(int ano3) {
		this.ano3 = ano3;
	}
	public int getAno4() {
		return ano4;
	}
	public void setAno4(int ano4) {
		this.ano4 = ano4;
	}
	public int getAno5() {
		return ano5;
	}
	public void setAno5(int ano5) {
		this.ano5 = ano5;
	}
	public int getAno6() {
		return ano6;
	}
	public void setAno6(int ano6) {
		this.ano6 = ano6;
	}
	public int getAno7() {
		return ano7;
	}
	public void setAno7(int ano7) {
		this.ano7 = ano7;
	}
	public String getSerie1() {
		return serie1;
	}
	public void setSerie1(String serie1) {
		this.serie1 = serie1;
	}
	public String getSerie2() {
		return serie2;
	}
	public void setSerie2(String serie2) {
		this.serie2 = serie2;
	}
	public String getSerie3() {
		return serie3;
	}
	public void setSerie3(String serie3) {
		this.serie3 = serie3;
	}
	public String getSerie4() {
		return serie4;
	}
	public void setSerie4(String serie4) {
		this.serie4 = serie4;
	}
	public String getSerie5() {
		return serie5;
	}
	public void setSerie5(String serie5) {
		this.serie5 = serie5;
	}
	public String getSerie6() {
		return serie6;
	}
	public void setSerie6(String serie6) {
		this.serie6 = serie6;
	}
	public String getSerie7() {
		return serie7;
	}
	public void setSerie7(String serie7) {
		this.serie7 = serie7;
	}

	//private List<Integer> anos;
	//private List<Integer> series;
	private boolean edita;
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	/*
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
	*/
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
	/*
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
    */
}
