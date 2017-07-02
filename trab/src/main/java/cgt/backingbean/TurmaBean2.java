package cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cdp.classesAnemicas.Turma;
import cgd.crudjdbc.*;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "teste")
@SessionScoped
public class TurmaBean2 {
	private List<Turma> lista;
	private Turma turma = new Turma();
	TurmaCrudJDBC objTurmaCrudJDBC = new TurmaCrudJDBC();

	public List<Turma> getLista() {
		return lista;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setLista(List<Turma> lista) {
		this.lista = lista;
	}

	public String novo() {
		turma = new Turma();
		return "turma";
	}

	public String excluirRegistro(Turma u) {
		TurmaCrudJDBC.excluir(u);
		// salva o usu�rio
		return u.getId()+"";
	}

	public String alterarRegistro(Turma u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Turma usu : lista) {
			if (usu.isEdita()) {
				TurmaCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = TurmaCrudJDBC.listar();
		return null;
	}

	
	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.turma.getSenha().equalsIgnoreCase(this.turma.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		//TurmaCrudJDBC.salvar(this.turma);
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		TurmaCrudJDBC.listar();
		return "listagem";
	}

}
