package cdp.classesAnemicas;


public class DadosPessoais {
	private int id;
	private String nome;
	private String datNasc;
	private int sexo;
	private String responsavel;
	private String parentesco;
	private String contato;
	private String nis;
	private boolean edita;
	public DadosPessoais(){
		this.setId(-1);
		this.setContato("");
		this.setDatNasc("");
		this.setNis("");
		this.setNome("");
		this.setParentesco("");
		this.setResponsavel("");
		this.setSexo(-1);
		this.setEdita(false);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDatNasc() {
		return datNasc;
	}
	public void setDatNasc(String datNasc) {
		this.datNasc = datNasc;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getNis() {
		return nis;
	}
	public void setNis(String nis) {
		this.nis = nis;
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
