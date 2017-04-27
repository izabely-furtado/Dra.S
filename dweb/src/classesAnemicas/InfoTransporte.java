package classesAnemicas;

public class InfoTransporte {
	private int id;
	private boolean transporte;
	private String qtransporte;
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
	public String getCartão() {
		return cartão;
	}
	public void setCartão(String cartão) {
		this.cartão = cartão;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String cartão;
	
}
