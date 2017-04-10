package classesAnemicas;

public class TermoDesligamento {
	private int id;
	private String nomeUsuario;
	private String nomeResponsavel;
	private String nomeTecResponsavel;
	private String motivo;
	private String cpf;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public String getNomeTecResponsavel() {
		return nomeTecResponsavel;
	}
	public void setNomeTecResponsavel(String nomeTecResponsavel) {
		this.nomeTecResponsavel = nomeTecResponsavel;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
