package classesAnemicasAntiga;

import crudjdbc.Tipo;

public abstract class Aluno extends Pessoa{
	private Tipo tipoAluno;
	private int nivelAluno;
	public Tipo getTipoAluno() {
		return tipoAluno;
	}
	public void setTipoAluno(Tipo tipoAluno) {
		this.tipoAluno = tipoAluno;
	}
	private String obs;
	public int getNivelAluno() {
		return nivelAluno;
	}
	public void setNivelAluno(int nivelAluno) {
		this.nivelAluno = nivelAluno;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	
}
