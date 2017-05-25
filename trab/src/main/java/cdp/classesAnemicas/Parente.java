package cdp.classesAnemicas;

public class Parente {
	private int id;
	private String nome;
	private String parentesco;
	private int idade;
	private String dataNasc;
	private String situacaoOcupacional;
	private String escolaridade;
	private Float renda;
	private String scfv;
	private boolean edita;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getSituacaoOcupacional() {
		return situacaoOcupacional;
	}
	public void setSituacaoOcupacional(String situacaoOcupacional) {
		this.situacaoOcupacional = situacaoOcupacional;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public Float getRenda() {
		return renda;
	}
	public void setRenda(Float renda) {
		this.renda = renda;
	}
	public String getScfv() {
		return scfv;
	}
	public void setScfv(String scfv) {
		this.scfv = scfv;
	}
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
}
