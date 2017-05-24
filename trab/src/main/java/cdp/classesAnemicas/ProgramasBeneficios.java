package cdp.classesAnemicas;

public class ProgramasBeneficios {
	private int id;
	private boolean possuipbf;
	private boolean possuipibc;
	private boolean possuipbc;
	private boolean possuibpc;
	private boolean possuibp;
	private boolean possuiar;
	private String beneficioHabitacional;
	private String outro;
	private boolean edita;
	public ProgramasBeneficios(){
		this.setId(-1);
		this.setBeneficioHabitacional("");
		this.setOutro("");
		this.setPossuiar(false);
		this.setPossuibp(false);
		this.setPossuipbc(false);
		this.setPossuipbf(false);
		this.setPossuipibc(false);
	}
	public boolean isPossuipbf() {
		return possuipbf;
	}
	public void setPossuipbf(boolean possuipbf) {
		this.possuipbf = possuipbf;
	}
	public boolean isPossuipibc() {
		return possuipibc;
	}
	public void setPossuipibc(boolean possuipibc) {
		this.possuipibc = possuipibc;
	}
	public boolean isPossuipbc() {
		return possuipbc;
	}
	public void setPossuipbc(boolean possuipbc) {
		this.possuipbc = possuipbc;
	}
	public boolean isPossuibp() {
		return possuibp;
	}
	public void setPossuibp(boolean possuibp) {
		this.possuibp = possuibp;
	}
	public boolean isPossuiar() {
		return possuiar;
	}
	public void setPossuiar(boolean possuiar) {
		this.possuiar = possuiar;
	}
	public String getBeneficioHabitacional() {
		return beneficioHabitacional;
	}
	public void setBeneficioHabitacional(String beneficioHabitacional) {
		this.beneficioHabitacional = beneficioHabitacional;
	}
	public String getOutro() {
		return outro;
	}
	public void setOutro(String outro) {
		this.outro = outro;
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
	public boolean isPossuibpc() {
		return possuibpc;
	}
	public void setPossuibpc(boolean possuibpc) {
		this.possuibpc = possuibpc;
	}
}
