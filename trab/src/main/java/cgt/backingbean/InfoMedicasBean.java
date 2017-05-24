package cgt.backingbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.InfoMedicas;
import cgd.crudjdbc.*;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "infoMedicasBean")
@SessionScoped
public class InfoMedicasBean {
	private List<InfoMedicas> lista;
	private InfoMedicas infoMedicas = new InfoMedicas();
	InfoMedicasCrudJDBC objInfoMedicasCrudJDBC = new InfoMedicasCrudJDBC();

	public List<InfoMedicas> getLista() {
		return lista;
	}

	public InfoMedicas getInfoMedicas() {
		return infoMedicas;
	}

	public void setInfoMedicas(InfoMedicas infoMedicas) {
		this.infoMedicas = infoMedicas;
	}

	public void setLista(List<InfoMedicas> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.infoMedicas = new InfoMedicas();
		return "infoMedicas";
	}

	public String excluirRegistro(InfoMedicas u) {
		InfoMedicasCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return u.getId()+"";
	}

	public String alterarRegistro(InfoMedicas u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (InfoMedicas usu : lista) {
			if (usu.isEdita()) {
				InfoMedicasCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		InfoMedicasCrudJDBC.listar();
		return null;
	}

	public String gerar(FacesContext context) {
		int erro = 0;
		if (this.infoMedicas.isAlergia() == true && this.infoMedicas.getQalergia() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decide, possui ou não alergia? Se sim, informe", ""));
			erro++;
		}
		if (this.infoMedicas.isMedicacao() == true && this.infoMedicas.getQmedicacao() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decide, precisa ou não de medicação? Se sim, informe", ""));
			erro++;
		}
		if (this.infoMedicas.getContatoSOS() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um telefone para contato emergencial", ""));
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
		 * (!this.infoMedicas.getSenha().equalsIgnoreCase(this.infoMedicas.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		InfoMedicasCrudJDBC.salvar(this.infoMedicas);
		// salva o usuï¿½rio
		return "sucesso";
	}

	public String verLista() {
		InfoMedicasCrudJDBC.listar();
		return "listagem";
	}

}
