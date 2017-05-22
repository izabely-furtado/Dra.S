package cgt.backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
		this.acessoServicos.setId(-1);
		this.acessoServicos.setPossuiacolhimento(false);
		this.acessoServicos.setPossuicei(false);
		this.acessoServicos.setPossuicras(false);
		this.acessoServicos.setPossuicreas(false);
		this.acessoServicos.setPossuiescola(false);
		this.acessoServicos.setPossuiesf(false);
		this.acessoServicos.setPossuisus(false);
		this.acessoServicos.setEdita(false);
		return "acessoServicos";
	}

	public String excluirRegistro(AcessoServicos u) {
		AcessoServicosCrudJDBC.excluir(u);
		// salva o usu�rio
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
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		AcessoServicosCrudJDBC.listar();
		return "listagem";
	}

}
