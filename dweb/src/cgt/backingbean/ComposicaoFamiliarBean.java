package cgt.backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cdp.classesAnemicas.ComposicaoFamiliar;
import cgd.crudjdbc.*;;

@ManagedBean(name = "composicaoFamiliarBean")
@SessionScoped
public class ComposicaoFamiliarBean {
	private List<ComposicaoFamiliar> lista;
	private ComposicaoFamiliar composicaoFamiliar = new ComposicaoFamiliar();
	ComposicaoFamiliarCrudJDBC objComposicaoFamiliarCrudJDBC = new ComposicaoFamiliarCrudJDBC();

	public List<ComposicaoFamiliar> getLista() {
		return lista;
	}

	public ComposicaoFamiliar getComposicaoFamiliar() {
		return composicaoFamiliar;
	}

	public List<Integer> getDias() {
		List<Integer> lstDia = new ArrayList<>();
		for (int i = 1; i <= 31; i++) {
			lstDia.add(i);
		}
		return lstDia;
	}

	public List<Integer> getMeses() {
		List<Integer> lstMes = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			lstMes.add(i);
		}
		return lstMes;
	}

	public List<Integer> getAnos() {
		List<Integer> lstAno = new ArrayList<>();
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = anoAtual - 120; i <= anoAtual; i++) {
			lstAno.add(i);
		}
		return lstAno;
	}

	public void setComposicaoFamiliar(ComposicaoFamiliar composicaoFamiliar) {
		this.composicaoFamiliar = composicaoFamiliar;
	}

	public void setLista(List<ComposicaoFamiliar> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.composicaoFamiliar.setId(-1);
		this.composicaoFamiliar.setParentes(null);
		this.composicaoFamiliar.setEdita(false);
		return "composicaoFamiliar";
	}

	public String excluirRegistro(ComposicaoFamiliar u) {
		ComposicaoFamiliarCrudJDBC.excluir(u);
		// salva o usuário
		return u.getId()+"";
	}

	public String alterarRegistro(ComposicaoFamiliar u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (ComposicaoFamiliar usu : lista) {
			if (usu.isEdita()) {
				ComposicaoFamiliarCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		ComposicaoFamiliarCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.composicaoFamiliar.getSenha().equalsIgnoreCase(this.composicaoFamiliar.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		ComposicaoFamiliarCrudJDBC.salvar(this.composicaoFamiliar);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		ComposicaoFamiliarCrudJDBC.listar();
		return "listagem";
	}

}
