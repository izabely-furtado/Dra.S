package cgt.backingbean;


import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
//import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.Rematricula;
//import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "rematriculaBean")
@SessionScoped
public class RematriculaBean {
	private Rematricula rematricula = new Rematricula();

	public Rematricula getRematricula() {
		return rematricula;
	}

	public void setRematricula(Rematricula rematricula) {
		this.rematricula = rematricula;
	}

	public void gerar() throws IOException {
		if (this.rematricula.getNomeResponsavel() != null &&
			this.rematricula.getNomeTecResponsavel() != null) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("./rematricula.jsf");
		}
		
	}
	public String novo() {
		
		this.rematricula.setId(-1);
		this.rematricula.setNomeResponsavel(null);
		this.rematricula.setNomeTecResponsavel(null);
		this.rematricula.setEdita(false);
		
		return "rematricula";
	}
	public String getDataAtual(){
		Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		return dStr;
	}
	

}
