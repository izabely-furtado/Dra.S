package cgt.backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.AcessoServicos;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "acessoServicosBean")
@SessionScoped
public class AcessoServicosBean {

	private List<AcessoServicos> lista;
	private AcessoServicos acessoServicos = new AcessoServicos();
	AcessoServicosCrudJDBC objAcessoServicosCrudJDBC = new AcessoServicosCrudJDBC();

	public List<AcessoServicos> getLista() {
		return lista;
	}

	public AcessoServicos getAcessoServicos() {
		return acessoServicos;
	}

	public String gerar(FacesContext context) {
		int erro = 0;
		if (this.acessoServicos.isPossuiacolhimento() == false && this.acessoServicos.getQacolhimento() != ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não Acolhimento?", ""));
			erro++;
		}
		if (this.acessoServicos.isPossuicei() == false && this.acessoServicos.getQcei() != "") {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não CEI?", ""));
			erro++;
		}
		if (this.acessoServicos.isPossuicras() == false && this.acessoServicos.getQcras() != "") {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não CRAS?", ""));
			erro++;
		}
		if (this.acessoServicos.isPossuicreas() == false && this.acessoServicos.getQcreas() != "") {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não CREAS?", ""));
			erro++;
		}
		if (this.acessoServicos.isPossuiescola() == false && this.acessoServicos.getQescola() != "") {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não auxilio escolar?", ""));
			erro++;
		}
		if (this.acessoServicos.isPossuiesf() == false && this.acessoServicos.getQesf() != "") {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não ESF?", ""));
			erro++;
		}
		if (this.acessoServicos.isPossuisus() == false && this.acessoServicos.getQsus() != "") {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Decida, possui ou não SUS?", ""));
			erro++;
		}

		if (erro == 0) {
			return "passou";
		}
		else {
			return "deubosta";
		}
	}
	
	public List<Integer> getDias() {
		List<Integer> lstDia = new ArrayList<Integer>();
		for (int i = 1; i <= 31; i++) {
			lstDia.add(i);
		}
		return lstDia;
	}

	public List<Integer> getMeses() {
		List<Integer> lstMes = new ArrayList<Integer>();
		for (int i = 1; i <= 12; i++) {
			lstMes.add(i);
		}
		return lstMes;
	}

	public List<Integer> getAnos() {
		List<Integer> lstAno = new ArrayList<Integer>();
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = anoAtual - 120; i <= anoAtual; i++) {
			lstAno.add(i);
		}
		return lstAno;
	}

	public void setAcessoServicos(AcessoServicos acessoServicos) {
		this.acessoServicos = acessoServicos;
	}

	public void setLista(List<AcessoServicos> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.acessoServicos = new AcessoServicos();
		return "acessoServicos";
	}

	public String excluirRegistro(AcessoServicos u) {
		AcessoServicosCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return u.getId()+"";
	}

	public String alterarRegistro(AcessoServicos u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (AcessoServicos usu : lista) {
			if (usu.isEdita()) {
				AcessoServicosCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		AcessoServicosCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.acessoServicos.getSenha().equalsIgnoreCase(this.acessoServicos.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		AcessoServicosCrudJDBC.salvar(this.acessoServicos);
		// salva o usuï¿½rio
		return "sucesso";
	}

	public String verLista() {
		AcessoServicosCrudJDBC.listar();
		return "listagem";
	}

}
