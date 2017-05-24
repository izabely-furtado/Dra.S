package cdp.classesAnemicas;

public class InfoTransporte {
	private int id;
	private boolean transporte;
	private String qtransporte;
	private boolean edita;
	public InfoTransporte(){
		this.setId(-1);
		this.setCartao("");
		this.setQtransporte("");
		this.setTransporte(false);
		this.setEdita(false);
	}
	public boolean isTransporte() {
		return transporte;
	}
	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}
	public String getQtransporte() {
		return qtransporte;
	}
	public void setQtransporte(String qtransporte) {
		this.qtransporte = qtransporte;
	}
	public String getCartao() {
		return cartao;
	}
	public void setCartao(String cartao) {
		this.cartao = cartao;
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
	private String cartao;
	
}
