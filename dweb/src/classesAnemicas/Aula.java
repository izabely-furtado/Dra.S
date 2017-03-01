package classesAnemicas;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Aula {
	private int id;
	private Date dataAula;
	private Time horaAula;
	private List<Aluno> presentes;
	private String ensinado;
	private boolean edita;
	
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
	public String getEnsinado() {
		return ensinado;
	}
	public void setEnsinado(String ensinado) {
		this.ensinado = ensinado;
	}
	public Time getHoraAula() {
		return horaAula;
	}
	public void setHoraAula(Time horaAula) {
		this.horaAula = horaAula;
	}
	public Date getDataAula() {
		return dataAula;
	}
	public void setDataAula(Date dataAula) {
		this.dataAula = dataAula;
	}
	public List<Aluno> getPresentes() {
		return presentes;
	}
	public void setPresentes(List<Aluno> presentes) {
		this.presentes = presentes;
	}
}
