package classesAnemicas;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Aula {
	private Date dataAula;
	private Time horaAula;
	private List<Aluno> presentes;
	private String ensinado;
	
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
