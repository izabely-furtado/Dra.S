package cgt.backingbean;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
//import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.TermoDesligamento;
//import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
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
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.termoDesligamento.getCpf() == null){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "CPF Inv�lido", ""));
		}
		if (this.termoDesligamento.getMotivo() != null) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insira um motivo para o desligamento", ""));
		}
		if (this.termoDesligamento.getNomeResponsavel() != null) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insira um Respons�vel", ""));
		}
		if (this.termoDesligamento.getNomeTecResponsavel() != null) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insira um T�cnico Respons�vel", ""));
		}
		if (this.termoDesligamento.getNomeTecResponsavel() != null) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Insira o usu�rio que ser� desligado do projeto", ""));
		}

		if (this.termoDesligamento.getCpf() != null 
				&& this.termoDesligamento.getMotivo() != null
				&& this.termoDesligamento.getNomeResponsavel() != null
				&& this.termoDesligamento.getNomeTecResponsavel() != null
				&& this.termoDesligamento.getNomeUsuario() != null) {

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

	public String getDataAtual() {
		Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		return dStr;
	}

}
