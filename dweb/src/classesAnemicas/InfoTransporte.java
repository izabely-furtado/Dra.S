package classesAnemicas;

public class InfoTransporte {
	private int id;
	private boolean transporte;
	private boolean qtransporte;
	public boolean isTransporte() {
		return transporte;
	}
	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}
	public boolean isQtransporte() {
		return qtransporte;
	}
	public void setQtransporte(boolean qtransporte) {
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
