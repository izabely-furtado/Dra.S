package cgt.backingbean;


import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.AcompanhamentoEscolar;
import cgd.crudjdbc.*;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "acompanhamentoEscolarBean")
@SessionScoped
public class AcompanhamentoEscolarBean {
	private List<AcompanhamentoEscolar> lista;
	private AcompanhamentoEscolar acompanhamentoEscolar = new AcompanhamentoEscolar();
	AcompanhamentoEscolarCrudJDBC objAcompanhamentoEscolarCrudJDBC = new AcompanhamentoEscolarCrudJDBC();

	public List<AcompanhamentoEscolar> getLista() {
		return lista;
	}

	public AcompanhamentoEscolar getAcompanhamentoEscolar() {
		return acompanhamentoEscolar;
	}

	
	public void setAcompanhamentoEscolar(AcompanhamentoEscolar acompanhamentoEscolar) {
		this.acompanhamentoEscolar = acompanhamentoEscolar;
	}

	public void setLista(List<AcompanhamentoEscolar> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.acompanhamentoEscolar = new AcompanhamentoEscolar();
		return "acompanhamentoEscolar";
	}

	public String excluirRegistro(AcompanhamentoEscolar u) {
		AcompanhamentoEscolarCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return u.getId()+"";
	}

	public String alterarRegistro(AcompanhamentoEscolar u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (AcompanhamentoEscolar usu : lista) {
			if (usu.isEdita()) {
				AcompanhamentoEscolarCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		AcompanhamentoEscolarCrudJDBC.listar();
		return null;
	}
	public String gerar(FacesContext context) {
		int erro = 0;
		if (this.acompanhamentoEscolar.getAno1() < 2000 && this.acompanhamentoEscolar.getSerie1() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a série em que estava durante o 1º ano do projeto", ""));
			erro++;
		}
		if (this.acompanhamentoEscolar.getAno2() < 2000 && this.acompanhamentoEscolar.getSerie2() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a série em que estava durante o 2º ano do projeto", ""));
			erro++;
		}
		if (this.acompanhamentoEscolar.getAno3() < 2000 && this.acompanhamentoEscolar.getSerie3() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a série em que estava durante o 3º ano do projeto", ""));
			erro++;
		}
		if (this.acompanhamentoEscolar.getAno4() > 2000 && this.acompanhamentoEscolar.getSerie4() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a série em que estava durante o 4º ano do projeto", ""));
			erro++;
		}
		if (this.acompanhamentoEscolar.getAno5() > 2000 && this.acompanhamentoEscolar.getSerie5() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a série em que estava durante o 5º ano do projeto", ""));
			erro++;
		}
		if (this.acompanhamentoEscolar.getAno6() > 2000 && this.acompanhamentoEscolar.getSerie6() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a série em que estava durante o 6º ano do projeto", ""));
			erro++;
		}
		
		if (erro == 0) {
			return "passou";
		}
		else {
			return "deubosta";
		}
	}
	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.acompanhamentoEscolar.getSenha().equalsIgnoreCase(this.acompanhamentoEscolar.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
		AcompanhamentoEscolarCrudJDBC ac = new AcompanhamentoEscolarCrudJDBC();
		int ace = ac.salvar(this.acompanhamentoEscolar);
		
		
		// salva o usuï¿½rio
		return "sucesso";
	}

	public String verLista() {
		AcompanhamentoEscolarCrudJDBC.listar();
		return "listagem";
	}

}
