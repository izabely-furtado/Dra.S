package classesAnemicas;

import java.sql.Time;
import java.util.List;

public class Professor extends Pessoa{
	private List<Turma> turmas;
	private Time hrDisponivelInicio;
	private Time hrDisponivelFim;
	public List<Turma> getTurmas() {
		return turmas;
	}
	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	public Time getHrDisponivelInicio() {
		return hrDisponivelInicio;
	}
	public void setHrDisponivelInicio(Time hrDisponivelInicio) {
		this.hrDisponivelInicio = hrDisponivelInicio;
	}
	public Time getHrDisponivelFim() {
		return hrDisponivelFim;
	}
	public void setHrDisponivelFim(Time hrDisponivelFim) {
		this.hrDisponivelFim = hrDisponivelFim;
	}
	
}
