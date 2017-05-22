package cgt.backingbean;


import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
		acompanhamentoEscolar.setId(-1);
	//	acompanhamentoEscolar.setAnos(null);
		acompanhamentoEscolar.setEscola(null);
	//	acompanhamentoEscolar.setSeries(null);
		acompanhamentoEscolar.setEdita(false);
		return "acompanhamentoEscolar";
	}

	public String excluirRegistro(AcompanhamentoEscolar u) {
		AcompanhamentoEscolarCrudJDBC.excluir(u);
		// salva o usu�rio
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

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.acompanhamentoEscolar.getSenha().equalsIgnoreCase(this.acompanhamentoEscolar.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		AcompanhamentoEscolarCrudJDBC.salvar(this.acompanhamentoEscolar);
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		AcompanhamentoEscolarCrudJDBC.listar();
		return "listagem";
	}

}
