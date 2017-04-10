package classesAnemicas;

public class Despesas {
	private float aluguel;
	private float agua;
	private float luz;
	private float telefone;
	private float gas;
	private float alimentacao;
	private float medicamentos;
	private float outros;
	//private float despesaTotal;
	private float rendaTotal;
	private float rendaPerCapta;
	public float getAluguel() {
		return aluguel;
	}
	public void setAluguel(float aluguel) {
		this.aluguel = aluguel;
	}
	public float getAgua() {
		return agua;
	}
	public void setAgua(float agua) {
		this.agua = agua;
	}
	public float getLuz() {
		return luz;
	}
	public void setLuz(float luz) {
		this.luz = luz;
	}
	public float getTelefone() {
		return telefone;
	}
	public void setTelefone(float telefone) {
		this.telefone = telefone;
	}
	public float getGas() {
		return gas;
	}
	public void setGas(float gas) {
		this.gas = gas;
	}
	public float getAlimentacao() {
		return alimentacao;
	}
	public void setAlimentacao(float alimentacao) {
		this.alimentacao = alimentacao;
	}
	public float getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(float medicamentos) {
		this.medicamentos = medicamentos;
	}
	public float getOutros() {
		return outros;
	}
	public void setOutros(float outros) {
		this.outros = outros;
	}
	public float getRendaTotal() {
		return rendaTotal;
	}
	public void setRendaTotal(float rendaTotal) {
		this.rendaTotal = rendaTotal;
	}
	public float getRendaPerCapta() {
		return rendaPerCapta;
	}
	public void setRendaPerCapta(float rendaPerCapta) {
		this.rendaPerCapta = rendaPerCapta;
	}
	public float getDespesaTotal() {
		return this.agua + this.alimentacao + this.aluguel + this.gas + this.luz + this.medicamentos + this.telefone + this.outros;
	}
//	public void setDespesaTotal(float despesaTotal) {
	//	this.despesaTotal = despesaTotal;
	//}
	
}
