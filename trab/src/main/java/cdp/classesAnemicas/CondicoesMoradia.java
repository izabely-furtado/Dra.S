package cdp.classesAnemicas;

public class CondicoesMoradia {
	private int id;
	private String condicao;
	private boolean possuiagua;
	private boolean possuiesgoto;
	private boolean possuienergia;
	private boolean possuicoleta;
	private boolean possuirisco;
	private String qrisco;
	private boolean edita;
	public CondicoesMoradia(){
		this.setId(-1);
		this.setCondicao("");
		this.setPossuiagua(false);
		this.setPossuicoleta(false);
		this.setPossuienergia(false);
		this.setPossuiesgoto(false);
		this.setPossuirisco(false);
		this.setQrisco("");
		this.setEdita(false);
	}
	public String getCondicao() {
		return condicao;
	}
	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
	public boolean isPossuiagua() {
		return possuiagua;
	}
	public boolean getPossuiagua() {
		return possuiagua;
	}
	public void setPossuiagua(boolean possuiagua) {
		this.possuiagua = possuiagua;
	}
	public boolean isPossuiesgoto() {
		return possuiesgoto;
	}
	public void setPossuiesgoto(boolean possuiesgoto) {
		this.possuiesgoto = possuiesgoto;
	}
	public boolean isPossuienergia() {
		return possuienergia;
	}
	public void setPossuienergia(boolean possuienergia) {
		this.possuienergia = possuienergia;
	}
	public boolean isPossuicoleta() {
		return possuicoleta;
	}
	public void setPossuicoleta(boolean possuicoleta) {
		this.possuicoleta = possuicoleta;
	}
	public boolean isPossuirisco() {
		return possuirisco;
	}
	public void setPossuirisco(boolean possuirisco) {
		this.possuirisco = possuirisco;
	}
	public String getQrisco() {
		return qrisco;
	}
	public void setQrisco(String qrisco) {
		this.qrisco = qrisco;
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
