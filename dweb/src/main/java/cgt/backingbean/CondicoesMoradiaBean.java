package main.java.cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.cdp.classesAnemicas.CondicoesMoradia;
import main.java.cgd.crudjdbc.*;;

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
		condicoesMoradia.setId(-1);
		condicoesMoradia.setCondicao(null);
		condicoesMoradia.setPossuiagua(false);
		condicoesMoradia.setPossuicoleta(false);
		condicoesMoradia.setPossuienergia(false);
		condicoesMoradia.setPossuiesgoto(false);
		condicoesMoradia.setPossuirisco(false);
		condicoesMoradia.setQrisco(null);
		condicoesMoradia.setEdita(false);
		return "condicoesMoradia";
	}

	public String excluirRegistro(CondicoesMoradia u) {
		CondicoesMoradiaCrudJDBC.excluir(u);
		// salva o usuário
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

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.condicoesMoradia.getSenha().equalsIgnoreCase(this.condicoesMoradia.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		CondicoesMoradiaCrudJDBC.salvar(this.condicoesMoradia);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		CondicoesMoradiaCrudJDBC.listar();
		return "listagem";
	}

}
