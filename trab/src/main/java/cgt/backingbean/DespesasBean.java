package cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
		this.despesas.setId(-1);
		this.despesas.setAgua(0);
		this.despesas.setAlimentacao(0);
		this.despesas.setAluguel(0);
		this.despesas.setGas(0);
		this.despesas.setLuz(0);
		this.despesas.setMedicamentos(0);
		this.despesas.setOutros(0);
		this.despesas.setRendaPerCapta(0);
		this.despesas.setRendaTotal(0);
		this.despesas.setTelefone(0);
		this.despesas.setEdita(false);
		return "despesas";
	}

	public String excluirRegistro(Despesas u) {
		DespesasCrudJDBC.excluir(u);
		// salva o usu�rio
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

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.despesas.getSenha().equalsIgnoreCase(this.despesas.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		DespesasCrudJDBC.salvar(this.despesas);
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		DespesasCrudJDBC.listar();
		return "listagem";
	}
}
