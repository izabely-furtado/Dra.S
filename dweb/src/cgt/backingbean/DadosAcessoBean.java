package cgt.backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cdp.classesAnemicas.DadosAcesso;
import cgd.crudjdbc.*;

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
		// salva o usuário
		return u.getId()+"";
	}

	public String alterarRegistro(DadosAcesso u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (DadosAcesso usu : lista) {
			if (usu.isEdita()) {
				DadosAcessoCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		DadosAcessoCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.dadosAcesso.getSenha().equalsIgnoreCase(this.dadosAcesso.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		DadosAcessoCrudJDBC.salvar(this.dadosAcesso);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		DadosAcessoCrudJDBC.listar();
		return "listagem";
	}

}
