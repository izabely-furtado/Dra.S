package cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.PublicoPrioritario;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "publicoPrioritarioBean")
@SessionScoped
public class PublicoPrioritarioBean {
	private List<PublicoPrioritario> lista;
	private PublicoPrioritario publicoPrioritario = new PublicoPrioritario();
	PublicoPrioritarioCrudJDBC objPublicoPrioritarioCrudJDBC = new PublicoPrioritarioCrudJDBC();

	public List<PublicoPrioritario> getLista() {
		return lista;
	}

	public PublicoPrioritario getPublicoPrioritario() {
		return publicoPrioritario;
	}


	public void setPublicoPrioritario(PublicoPrioritario publicoPrioritario) {
		this.publicoPrioritario = publicoPrioritario;
	}

	public void setLista(List<PublicoPrioritario> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.publicoPrioritario = new PublicoPrioritario();
		return "publicoPrioritario";
	}

	public String excluirRegistro(PublicoPrioritario u) {
		PublicoPrioritarioCrudJDBC.excluir(u);
		// salva o usu�rio
		return u.getId()+"";
	}

	public String alterarRegistro(PublicoPrioritario u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (PublicoPrioritario usu : lista) {
			if (usu.isEdita()) {
				PublicoPrioritarioCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		PublicoPrioritarioCrudJDBC.listar();
		return null;
	}
	public String gerar(FacesContext context) {
		int erro = 0;
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
		 * (!this.publicoPrioritario.getSenha().equalsIgnoreCase(this.publicoPrioritario.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		//PublicoPrioritarioCrudJDBC.salvar(this.publicoPrioritario);
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		PublicoPrioritarioCrudJDBC.listar();
		return "listagem";
	}

}
