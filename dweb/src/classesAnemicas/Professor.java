package classesAnemicas;

import java.util.Date;
import java.util.List;

public class Professor {
	private List<Turma> turmas;
	private Date hrDisponivelInicio;
	private Date hrDisponivelFim;
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	public Date getHrDisponivelInicio() {
		return hrDisponivelInicio;
	}
	public void setHrDisponivelInicio(Date hrDisponivelInicio) {
		this.hrDisponivelInicio = hrDisponivelInicio;
	}
	public Date getHrDisponivelFim() {
		return hrDisponivelFim;
	}
	public void setHrDisponivelFim(Date hrDisponivelFim) {
		this.hrDisponivelFim = hrDisponivelFim;
	}
	
}
