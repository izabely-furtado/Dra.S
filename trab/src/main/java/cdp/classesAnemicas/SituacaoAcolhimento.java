package cdp.classesAnemicas;

public class SituacaoAcolhimento {
	private int id;
	private String nomeAcolhido;
	private String nomeInstituicao;
	private String responsavelInstituicao;
	private String contato;
	private String motivo;
	private boolean edita;
	
	public SituacaoAcolhimento(){
		this.setContato("");
		this.setMotivo("");
		this.setNomeAcolhido("");
		this.setNomeInstituicao("");
		this.setResponsavelInstituicao("");
	}
	public String getNomeAcolhido() {
		return nomeAcolhido;
	}
	public void setNomeAcolhido(String nomeAcolhido) {
		this.nomeAcolhido = nomeAcolhido;
	}
	public String getNomeInstituicao() {
		return nomeInstituicao;
	}
	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}
	public String getResponsavelInstituicao() {
		return responsavelInstituicao;
	}
	public void setResponsavelInstituicao(String responsavelInstituicao) {
		this.responsavelInstituicao = responsavelInstituicao;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
