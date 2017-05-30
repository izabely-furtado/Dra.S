package cdp.classesAnemicas;

import java.util.ArrayList;
import java.util.List;

public class ComposicaoFamiliar {
	private int id;
	private Parente parente1;
	public Parente getParente1() {
		return parente1;
	}
	public void setParente1(Parente parente1) {
		this.parente1 = parente1;
	}
	public Parente getParente2() {
		return parente2;
	}
	public void setParente2(Parente parente2) {
		this.parente2 = parente2;
	}
	public Parente getParente3() {
		return parente3;
	}
	public void setParente3(Parente parente3) {
		this.parente3 = parente3;
	}
	public Parente getParente4() {
		return parente4;
	}
	public void setParente4(Parente parente4) {
		this.parente4 = parente4;
	}
	public Parente getParente5() {
		return parente5;
	}
	public void setParente5(Parente parente5) {
		this.parente5 = parente5;
	}
	public Parente getParente6() {
		return parente6;
	}
	public void setParente6(Parente parente6) {
		this.parente6 = parente6;
	}
	public Parente getParente7() {
		return parente7;
	}
	public void setParente7(Parente parente7) {
		this.parente7 = parente7;
	}
	public Parente getParente8() {
		return parente8;
	}
	public void setParente8(Parente parente8) {
		this.parente8 = parente8;
	}
	public Parente getParente9() {
		return parente9;
	}
	public void setParente9(Parente parente9) {
		this.parente9 = parente9;
	}
	public Parente getParente10() {
		return parente10;
	}
	public void setParente10(Parente parente10) {
		this.parente10 = parente10;
	}
	public Parente getParente11() {
		return parente11;
	}
	public void setParente11(Parente parente11) {
		this.parente11 = parente11;
	}
	public Parente getParente12() {
		return parente12;
	}
	public void setParente12(Parente parente12) {
		this.parente12 = parente12;
	}
	public Parente getParente13() {
		return parente13;
	}
	public void setParente13(Parente parente13) {
		this.parente13 = parente13;
	}
	private Parente parente2;
	private Parente parente3;
	private Parente parente4;
	private Parente parente5;
	private Parente parente6;
	private Parente parente7;
	private Parente parente8;
	private Parente parente9;
	private Parente parente10;
	private Parente parente11;
	private Parente parente12;
	private Parente parente13;
		
	private boolean edita;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Parente> getParentes() {
		List<Parente> parentes = new ArrayList<Parente>();
		parentes.add(parente1);
		parentes.add(parente2);
		parentes.add(parente3);
		parentes.add(parente4);
		parentes.add(parente5);
		parentes.add(parente6);
		parentes.add(parente7);
		parentes.add(parente8);
		parentes.add(parente9);
		parentes.add(parente10);
		parentes.add(parente11);
		parentes.add(parente12);
		parentes.add(parente13);
		
		return parentes;
	}
	
	public void setParentes(List<Parente> parentes) {
		for (int i = 1; i <=parentes.size() ; i++){
			switch (i) {
				case 1: this.parente1 = parentes.get(i);
				case 2: this.parente2 = parentes.get(i);
				case 3: this.parente3 = parentes.get(i);
				case 4: this.parente4 = parentes.get(i);
				case 5: this.parente5 = parentes.get(i);
				case 6: this.parente6 = parentes.get(i);
				case 7: this.parente7 = parentes.get(i);
				case 8: this.parente8 = parentes.get(i);
				case 9: this.parente9 = parentes.get(i);
				case 10: this.parente10 = parentes.get(i);
				case 11: this.parente11 = parentes.get(i);
				case 12: this.parente12 = parentes.get(i);
				case 13: this.parente13 = parentes.get(i);
			}
		}
		//this.parentes = parentes;
	}
	public boolean isEdita() {
		return edita;
	}
	public void setEdita(boolean edita) {
		this.edita = edita;
	}
	
}
