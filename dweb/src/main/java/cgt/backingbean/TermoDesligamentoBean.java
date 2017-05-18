package main.java.cgt.backingbean;


import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
//import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import main.java.cdp.classesAnemicas.TermoDesligamento;
//import main.java.cgd.crudjdbc.*;

@ManagedBean(name = "termoDesligamentoBean")
@SessionScoped
public class TermoDesligamentoBean {
	private TermoDesligamento termoDesligamento = new TermoDesligamento();

	public TermoDesligamento getTermoDesligamento() {
		return termoDesligamento;
	}

	public void setTermoDesligamento(TermoDesligamento termoDesligamento) {
		this.termoDesligamento = termoDesligamento;
	}

	public void gerar() throws IOException {
		if (this.termoDesligamento.getCpf() != null && 
			this.termoDesligamento.getMotivo() != null && 
			this.termoDesligamento.getNomeResponsavel() != null &&
			this.termoDesligamento.getNomeTecResponsavel() != null &&
			this.termoDesligamento.getNomeUsuario() != null) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("./termo.jsf");
		}
		
	}
	public String novo() {
		
		this.termoDesligamento.setId(-1);
		this.termoDesligamento.setNomeUsuario(null);
		this.termoDesligamento.setNomeResponsavel(null);
		this.termoDesligamento.setNomeTecResponsavel(null);
		this.termoDesligamento.setMotivo(null);
		this.termoDesligamento.setCpf(null);
		this.termoDesligamento.setEdita(false);
		
		return "termoDesligamento";
	}
	public String getDataAtual(){
		Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		return dStr;
	}
	

}
