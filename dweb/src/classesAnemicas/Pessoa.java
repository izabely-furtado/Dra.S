package classesAnemicas;

import java.util.Date;

public abstract class Pessoa {
	private int id;
	private boolean edita;
	private String nome;
	private Date dataNasc;
	private Integer telefone;
	private String tipoSangue;
	private boolean possuiConvenio;
	private String descConvenio;
	private Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public boolean isEdita() {
		return edita;
	}
	public void setEdita(boolean edita) {
		this.edita = edita;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public String getTipoSangue() {
		return tipoSangue;
	}
	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}
	public boolean isPossuiConvenio() {
		return possuiConvenio;
	}
	public void setPossuiConvenio(boolean possuiConvenio) {
		this.possuiConvenio = possuiConvenio;
	}
	public String getDescConvenio() {
		return descConvenio;
	}
	public void setDescConvenio(String descConvenio) {
		this.descConvenio = descConvenio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
