package classesAnemicas;

import java.util.Date;
import java.util.List;

public class Presen�a {
	private Date dataAula;
	private List<Aluno> presentes;
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
