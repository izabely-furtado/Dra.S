package main.java.cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.cdp.classesAnemicas.FormularioAcompanhamentoPsicossocial;
import main.java.cgd.crudjdbc.*;

@ManagedBean(name = "fapBean")
@SessionScoped
public class FAPBean {
	private List<FormularioAcompanhamentoPsicossocial> lista;
	private FormularioAcompanhamentoPsicossocial fap = new FormularioAcompanhamentoPsicossocial();
	FAPCrudJDBC objFAPCrudJDBC = new FAPCrudJDBC();

	public List<FormularioAcompanhamentoPsicossocial> getLista() {
		return lista;
	}

	public FormularioAcompanhamentoPsicossocial getFap() {
		return fap;
	}

	public void setFormularioAcompanhamentoPsicossocial(FormularioAcompanhamentoPsicossocial fap) {
		this.fap = fap;
	}

	public void setLista(List<FormularioAcompanhamentoPsicossocial> lista) {
		this.lista = lista;
	}

	public String novo() {
		fap.setId(-1);
		fap.setAcessoServicos(null);
		fap.setAcompanhamentoEscolar(null);
		fap.setEndereco(null);
		fap.setAno(-1);
		fap.setComposicaoFamiliar(null);
		fap.setCondicoesMoradia(null);
		fap.setDadosPessoais(null);
		fap.setDespesas(null);
		fap.setFormaAcesso(-1);
		fap.setInfoMedicas(null);
		fap.setInfoTransporte(null);
		fap.setProgramasBeneficios(null);
		fap.setPublicoPrioritario(null);
		fap.setRematricula(null);
		fap.setTipo(-1);
		fap.setEdita(false);
		return "fap";
	}

	public String excluirRegistro(FormularioAcompanhamentoPsicossocial u) {
		FAPCrudJDBC.excluir(u);
		// salva o usuário
		return "excluir";
	}

	public String alterarRegistro(FormularioAcompanhamentoPsicossocial u) {
		u.setEdita(true);
		return "alterar";
	}

	public String salvarRegistro() {
		for (FormularioAcompanhamentoPsicossocial usu : lista) {
			if (usu.isEdita()) {
				FAPCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = FAPCrudJDBC.listar();
		return "salvar";
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.fap.getSenha().equalsIgnoreCase(this.fap.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
		FAPCrudJDBC.salvar(this.fap);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		this.lista = FAPCrudJDBC.listar();
		return "listagem";
	}
}
