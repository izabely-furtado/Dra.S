package cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cdp.classesAnemicas.FormularioAcompanhamentoPsicossocial;
import cgd.crudjdbc.*;

@ManagedBean(name = "fapIBean")
@SessionScoped
public class FAPBean {
	private List<FormularioAcompanhamentoPsicossocial> lista;
	private FormularioAcompanhamentoPsicossocial fap = new FormularioAcompanhamentoPsicossocial();
	FAPCrudJDBC objFAPCrudJDBC = new FAPCrudJDBC();

	public List<FormularioAcompanhamentoPsicossocial> getLista() {
		return lista;
	}

	public FormularioAcompanhamentoPsicossocial getAluno() {
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
		FAPCrudJDBC objFAPCrudJDBC = new FAPCrudJDBC();
		objFAPCrudJDBC.excluir(u);
		// salva o usuário
		return u.getDadosPessoais().getNome();
	}

	public String alterarRegistro(FormularioAcompanhamentoPsicossocial u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (FormularioAcompanhamentoPsicossocial usu : lista) {
			if (usu.isEdita()) {
				FAPCrudJDBC objFAPCrudJDBC = new FAPCrudJDBC();
				objFAPCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objFAPCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.fap.getSenha().equalsIgnoreCase(this.fap.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
		FAPCrudJDBC objFAPCrudJDBC = new FAPCrudJDBC();
		objFAPCrudJDBC.salvar(this.fap);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		FAPCrudJDBC objFAPCrudJDBC = new FAPCrudJDBC();
		this.lista = objFAPCrudJDBC.listar();
		return "listagem";
	}
}
