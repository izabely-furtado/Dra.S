package classesAnemicasAntiga;

import java.sql.Time;

public class Professor extends Pessoa{
	private Time hrDisponivelInicio;
	private Time hrDisponivelFim;
	
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
