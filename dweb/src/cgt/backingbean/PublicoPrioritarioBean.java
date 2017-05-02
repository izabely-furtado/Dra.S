package backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import classesAnemicas.PublicoPrioritario;
import crudjdbc.*;

@ManagedBean(name = "publicoPrioritarioBean")
@SessionScoped
public class PublicoPrioritarioBean {
	private List<PublicoPrioritario> lista;
	private PublicoPrioritario publicoPrioritario = new PublicoPrioritario();
	PublicoPrioritarioCrudJDBC objPublicoPrioritarioCrudJDBC = new PublicoPrioritarioCrudJDBC();

	public List<PublicoPrioritario> getLista() {
		return lista;
	}

	public PublicoPrioritario getPublicoPrioritario() {
		return publicoPrioritario;
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

	public void setPublicoPrioritario(PublicoPrioritario publicoPrioritario) {
		this.publicoPrioritario = publicoPrioritario;
	}

	public void setLista(List<PublicoPrioritario> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.publicoPrioritario.setId(-1);
		this.publicoPrioritario.setAbuso(false);
		this.publicoPrioritario.setAcolimento(false);
		this.publicoPrioritario.setDefasagem(false);
		this.publicoPrioritario.setEca(false);
		this.publicoPrioritario.setEdita(false);
		this.publicoPrioritario.setEgressos(false);
		this.publicoPrioritario.setIsolamento(false);
		this.publicoPrioritario.setMse(false);
		this.publicoPrioritario.setRua(false);
		this.publicoPrioritario.setTrabInfantil(false);
		this.publicoPrioritario.setVivencia(false);
		this.publicoPrioritario.setVulnerabilidade(false);
		return "publicoPrioritario";
	}

	public String excluirRegistro(PublicoPrioritario u) {
		PublicoPrioritarioCrudJDBC.excluir(u);
		// salva o usuário
		return u.getId()+"";
	}

	public String alterarRegistro(PublicoPrioritario u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (PublicoPrioritario usu : lista) {
			if (usu.isEdita()) {
				PublicoPrioritarioCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		PublicoPrioritarioCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.publicoPrioritario.getSenha().equalsIgnoreCase(this.publicoPrioritario.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		PublicoPrioritarioCrudJDBC.salvar(this.publicoPrioritario);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		PublicoPrioritarioCrudJDBC.listar();
		return "listagem";
	}

}
