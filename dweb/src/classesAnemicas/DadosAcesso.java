package classesAnemicas;

public class DadosAcesso {
	private int id;
	private String login;
	private String senha;
	private String email;
	private String lembrar;
	private boolean edita;
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLembrar() {
		return lembrar;
	}
	public void setLembrar(String lembrar) {
		this.lembrar = lembrar;
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
