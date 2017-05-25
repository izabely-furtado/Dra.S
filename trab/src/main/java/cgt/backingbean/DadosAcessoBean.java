package cgt.backingbean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.DadosAcesso;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "dadosAcessoBean")
@SessionScoped
public class DadosAcessoBean {

	private List<DadosAcesso> lista;
	private DadosAcesso dadosAcesso = new DadosAcesso();
	DadosAcessoCrudJDBC objDadosAcessoCrudJDBC = new DadosAcessoCrudJDBC();

	public List<DadosAcesso> getLista() {
		return lista;
	}

	public DadosAcesso getDadosAcesso() {
		return dadosAcesso;
	}

	
	public void setDadosAcesso(DadosAcesso dadosAcesso) {
		this.dadosAcesso = dadosAcesso;
	}

	public void setLista(List<DadosAcesso> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.dadosAcesso.setId(-1);
		this.dadosAcesso.setEmail(null);
		this.dadosAcesso.setLembrar(null);
		this.dadosAcesso.setLogin(null);
		this.dadosAcesso.setSenha(null);
		this.dadosAcesso.setEdita(false);
		return "dadosAcesso";
	}

	public String excluirRegistro(DadosAcesso u) {
		DadosAcessoCrudJDBC.excluir(u);
		// salva o usu�rio
		return u.getId()+"";
	}

	public String alterarRegistro(DadosAcesso u) throws IOException {
		u.setEdita(true);
		FacesContext.getCurrentInstance().getExternalContext().redirect("./alterarDadosAcesso.jsf");
		return "alterar";
	}

	public String salvarRegistro() {
		for (DadosAcesso usu : lista) {
			if (usu.isEdita()) {
				DadosAcessoCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		DadosAcessoCrudJDBC.listar();
		return "salvar";
	}

	public String inserir() throws IOException {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.dadosAcesso.getSenha().equalsIgnoreCase(this.dadosAcesso.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		DadosAcessoCrudJDBC.salvar(this.dadosAcesso);
		FacesContext.getCurrentInstance().getExternalContext().redirect("./alterarDadosAcesso.jsf");
		// salva o usu�rio
		return "sucesso";
	}
	
	
	
	public void visualizarDadosAcesso(){
		
	}

	public String verLista() {
		DadosAcessoCrudJDBC.listar();
		return "listagem";
	}

}
