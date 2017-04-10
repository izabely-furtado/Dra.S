package classesAnemicas;

import java.util.Date;
import java.util.List;

public class Rematricula {
	private List<Integer> anos;
	private List<String> responsaveis;
	private List<Date> datas;
	private String tecnicoResponsavel;
	private String familiarResponsavel;
	public List<Integer> getAnos() {
		return anos;
	}
	public void setAnos(List<Integer> anos) {
		this.anos = anos;
	}
	public List<String> getResponsaveis() {
		return responsaveis;
	}
	public void setResponsaveis(List<String> responsaveis) {
		this.responsaveis = responsaveis;
	}
	public List<Date> getDatas() {
		return datas;
	}
	public void setDatas(List<Date> datas) {
		this.datas = datas;
	}
	public String getTecnicoResponsavel() {
		return tecnicoResponsavel;
	}
	public void setTecnicoResponsavel(String tecnicoResponsavel) {
		this.tecnicoResponsavel = tecnicoResponsavel;
	}
	public String getFamiliarResponsavel() {
		return familiarResponsavel;
	}
	public void setFamiliarResponsavel(String familiarResponsavel) {
		this.familiarResponsavel = familiarResponsavel;
	}
}
