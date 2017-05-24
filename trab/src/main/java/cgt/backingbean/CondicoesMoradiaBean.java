package cgt.backingbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.CondicoesMoradia;
import cgd.crudjdbc.*;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "condicoesMoradiaBean")
@SessionScoped
public class CondicoesMoradiaBean {
	private List<CondicoesMoradia> lista;
	private CondicoesMoradia condicoesMoradia = new CondicoesMoradia();
	CondicoesMoradiaCrudJDBC objCondicoesMoradiaCrudJDBC = new CondicoesMoradiaCrudJDBC();

	public List<CondicoesMoradia> getLista() {
		return lista;
	}

	public CondicoesMoradia getCondicoesMoradia() {
		return condicoesMoradia;
	}

	public void setCondicoesMoradia(CondicoesMoradia condicoesMoradia) {
		this.condicoesMoradia = condicoesMoradia;
	}

	public void setLista(List<CondicoesMoradia> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.condicoesMoradia = new CondicoesMoradia();
		return "condicoesMoradia";
	}

	public String excluirRegistro(CondicoesMoradia u) {
		CondicoesMoradiaCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return u.getId()+"";
	}

	public String alterarRegistro(CondicoesMoradia u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (CondicoesMoradia usu : lista) {
			if (usu.isEdita()) {
				CondicoesMoradiaCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		CondicoesMoradiaCrudJDBC.listar();
		return null;
	}
	public String gerar(FacesContext context) {
		int erro = 0;
		if (this.condicoesMoradia.isPossuirisco() == false && this.condicoesMoradia.getQrisco() != ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não risco?", ""));
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
		 * (!this.condicoesMoradia.getSenha().equalsIgnoreCase(this.condicoesMoradia.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		CondicoesMoradiaCrudJDBC.salvar(this.condicoesMoradia);
		// salva o usuï¿½rio
		return "sucesso";
	}

	public String verLista() {
		CondicoesMoradiaCrudJDBC.listar();
		return "listagem";
	}

}
