package cdp.classesAnemicas;

import java.io.Serializable;

public class AlunosTurma implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int turma_id;
	private int aluno_id;
	
	private String nomeAluno;
	private String codigoTurma;
	
	private Aluno alunoSelecionado = new Aluno();

	private Turma turmaSelecionada = new Turma();

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}
	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}
	public Turma getTurmaSelecionada() {
		return turmaSelecionada;
	}
	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTurma_id() {
		return turma_id;
	}
	public void setTurma_id(int turma_id) {
		this.turma_id = turma_id;
	}
	public int getAluno_id() {
		return aluno_id;
	}
	public void setAluno_id(int aluno_id) {
		this.aluno_id = aluno_id;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getCodigoTurma() {
		return codigoTurma;
	}
	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}


}
