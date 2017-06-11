package cgt.backingbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.Despesas;
import cgd.crudjdbc.*;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "despesasBean")
@SessionScoped
public class DespesasBean {
	private List<Despesas> lista;
	private Despesas despesas = new Despesas();
	DespesasCrudJDBC objDespesasCrudJDBC = new DespesasCrudJDBC();

	public List<Despesas> getLista() {
		return lista;
	}

	public Despesas getDespesas() {
		return despesas;
	}

	public void setDespesas(Despesas despesas) {
		this.despesas = despesas;
	}

	public void setLista(List<Despesas> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.despesas = new Despesas();
		return "despesas";
	}

	public String excluirRegistro(Despesas u) {
		DespesasCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return u.getId()+"";
	}

	public String alterarRegistro(Despesas u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Despesas usu : lista) {
			if (usu.isEdita()) {
				DespesasCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		DespesasCrudJDBC.listar();
		return null;
	}

	public String gerar(FacesContext context) {
		int erro = 0;
		if (this.despesas.getAgua() <= 0 || 
				this.despesas.getAlimentacao() <= 0 || 
				this.despesas.getAluguel() <= 0 || 
				this.despesas.getGas() <=  0 ||
				this.despesas.getLuz() <= 0 ||
				this.despesas.getMedicamentos() <= 0 ||
				this.despesas.getOutros() <= 0 || 
				this.despesas.getTelefone() <= 0) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não existe despesa negativa", ""));
			erro++;
		}
		if (this.despesas.getRendaPerCapta() <= 0 && 
				this.despesas.getRendaTotal() <= 0) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não existe renda negativa", ""));
			erro++;
		}
		
		if (erro == 0) {
			return "passou";
		}
		else {
			return "deubosta";
		}
	}
	
	public Float getDespesaTotal() {
		return this.despesas.getAgua() + 
			   this.despesas.getAlimentacao() + 
			   this.despesas.getAluguel() + 
			   this.despesas.getGas() + 
			   this.despesas.getLuz() + 
			   this.despesas.getMedicamentos() + 
			   this.despesas.getOutros() + 
			   this.despesas.getTelefone();
	}
	
	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.despesas.getSenha().equalsIgnoreCase(this.despesas.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		//DespesasCrudJDBC.salvar(this.despesas);
		// salva o usuï¿½rio
		return "sucesso";
	}

	public String verLista() {
		DespesasCrudJDBC.listar();
		return "listagem";
	}
}
