package backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import classesAnemicas.CondicoesMoradia;
import crudjdbc.*;;

@ManagedBean(name = "condicoesMoradiaBean")
@SessionScoped
public class CondicoesMoradiaBean {
	private List<CondicoesMoradia> lista;
	private CondicoesMoradia condicoesMoradia = new CondicoesMoradia();
	CondicoesMoradiaCrudJDBC objCondicoesMoradiaCrudJDBC = new CondicoesMoradiaCrudJDBC();

	public List<CondicoesMoradia> getLista() {
		return lista;
	}

	public CondicoesMoradia getCondicoesMoradia() {
		return condicoesMoradia;
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

	public void setCondicoesMoradia(CondicoesMoradia condicoesMoradia) {
		this.condicoesMoradia = condicoesMoradia;
	}

	public void setLista(List<CondicoesMoradia> lista) {
		this.lista = lista;
	}

	public String novo() {
		condicoesMoradia.setId(-1);
		condicoesMoradia.setCondicao(null);
		condicoesMoradia.setPossuiagua(false);
		condicoesMoradia.setPossuicoleta(false);
		condicoesMoradia.setPossuienergia(false);
		condicoesMoradia.setPossuiesgoto(false);
		condicoesMoradia.setPossuirisco(false);
		condicoesMoradia.setQrisco(null);
		condicoesMoradia.setEdita(false);
		return "condicoesMoradia";
	}

	public String excluirRegistro(CondicoesMoradia u) {
		CondicoesMoradiaCrudJDBC.excluir(u);
		// salva o usuário
		return u.getId()+"";
	}

	public String alterarRegistro(CondicoesMoradia u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (CondicoesMoradia usu : lista) {
			if (usu.isEdita()) {
				CondicoesMoradiaCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		CondicoesMoradiaCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.condicoesMoradia.getSenha().equalsIgnoreCase(this.condicoesMoradia.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		CondicoesMoradiaCrudJDBC.salvar(this.condicoesMoradia);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		CondicoesMoradiaCrudJDBC.listar();
		return "listagem";
	}

}
