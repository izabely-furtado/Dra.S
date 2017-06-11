package cgt.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.Parente;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "parenteBean")
@SessionScoped
public class ParenteBean {
	private List<Parente> lista = new ArrayList<>();
	private Parente parente = new Parente();
	ParenteCrudJDBC objParenteCrudJDBC = new ParenteCrudJDBC();

	public List<Parente> getLista() {
		return lista;
	}

	public Parente getParente() {
		return parente;
	}

	public void setParente(Parente parente) {
		this.parente = parente;
	}

	public void setLista(List<Parente> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.parente = new Parente();
		return "condicoesMoradia";
	}
	/*RESOLVER ISSO DEPOIS
	public String excluirRegistro(Parente u) {
		CondicoesMoradiaCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return u.getId()+"";
	}

	public String alterarRegistro(Parente u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Parente usu : lista) {
			if (usu.isEdita()) {
				CondicoesMoradiaCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		CondicoesMoradiaCrudJDBC.listar();
		return null;
	}
	*/
	public String gerar(FacesContext context) {
		int erro = 0;
		if (this.parente.getDataNasc() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a data de nascimento do parente", ""));
			erro++;
		}
		if (this.parente.getEscolaridade() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a escolaridade do parente", ""));
			erro++;
		}
		if (this.parente.getIdade() <= 0){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a idade do parente", ""));
			erro++;
		}
		if (this.parente.getNome() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o nome do parente", ""));
			erro++;
		}
		if (this.parente.getParentesco() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o parentesco entre a criança e o parente", ""));
			erro++;
		}
		if (this.parente.getRenda() <= 0){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe a renda do parente", ""));
			erro++;
		}
		if (this.parente.getSituacaoOcupacional() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o situação ocupacional do parente", ""));
			erro++;
		}
		if (erro == 0) {
			return "passou";
		}
		else {
			return "deubosta";
		}
	}
	public String addParente() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.gerar(context) == "passou") {
			this.lista.add(this.parente);
			return "passou";
		}
		else {
			return "deubosta";
		}
	}
	public String inserir() {
		
		/* FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.condicoesMoradia.getSenha().equalsIgnoreCase(this.condicoesMoradia.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		//ParenteCrudJDBC.salvar(this.parente);
		// salva o usuï¿½rio
		return "sucesso";
	}

	public String verLista() {
		CondicoesMoradiaCrudJDBC.listar();
		return "listagem";
	}

}
