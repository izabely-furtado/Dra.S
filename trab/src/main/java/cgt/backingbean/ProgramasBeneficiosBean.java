package cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.ProgramasBeneficios;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "programasBeneficiosBean")
@SessionScoped
public class ProgramasBeneficiosBean {
	private List<ProgramasBeneficios> lista;
	private ProgramasBeneficios programasBeneficios = new ProgramasBeneficios();
	ProgramasBeneficiosCrudJDBC objProgramasBeneficiosCrudJDBC = new ProgramasBeneficiosCrudJDBC();

	public List<ProgramasBeneficios> getLista() {
		return lista;
	}

	public ProgramasBeneficios getProgramasBeneficios() {
		return programasBeneficios;
	}



	public void setProgramasBeneficios(ProgramasBeneficios programasBeneficios) {
		this.programasBeneficios = programasBeneficios;
	}

	public void setLista(List<ProgramasBeneficios> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.programasBeneficios.setId(-1);
		this.programasBeneficios.setBeneficioHabitacional(null);
		this.programasBeneficios.setOutro(null);
		this.programasBeneficios.setPossuiar(false);
		this.programasBeneficios.setPossuibp(false);
		this.programasBeneficios.setPossuipbc(false);
		this.programasBeneficios.setPossuipbf(false);
		this.programasBeneficios.setPossuipibc(false);
		return "programasBeneficios";
	}

	public String excluirRegistro(ProgramasBeneficios u) {
		ProgramasBeneficiosCrudJDBC.excluir(u);
		// salva o usu�rio
		return u.getId()+"";
	}

	public String alterarRegistro(ProgramasBeneficios u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (ProgramasBeneficios usu : lista) {
			if (usu.isEdita()) {
				ProgramasBeneficiosCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		ProgramasBeneficiosCrudJDBC.listar();
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
		 * (!this.programasBeneficios.getSenha().equalsIgnoreCase(this.programasBeneficios.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		ProgramasBeneficiosCrudJDBC.salvar(this.programasBeneficios);
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		ProgramasBeneficiosCrudJDBC.listar();
		return "listagem";
	}

}
