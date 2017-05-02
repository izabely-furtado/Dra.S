package backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import classesAnemicas.InfoMedicas;
import crudjdbc.*;;

@ManagedBean(name = "infoMedicasBean")
@SessionScoped
public class InfoMedicasBean {
	private List<InfoMedicas> lista;
	private InfoMedicas infoMedicas = new InfoMedicas();
	InfoMedicasCrudJDBC objInfoMedicasCrudJDBC = new InfoMedicasCrudJDBC();

	public List<InfoMedicas> getLista() {
		return lista;
	}

	public InfoMedicas getInfoMedicas() {
		return infoMedicas;
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

	public void setInfoMedicas(InfoMedicas infoMedicas) {
		this.infoMedicas = infoMedicas;
	}

	public void setLista(List<InfoMedicas> lista) {
		this.lista = lista;
	}

	public String novo() {
		infoMedicas.setId(-1);
		infoMedicas.setAlergia(false);
		infoMedicas.setContatoSOS(null);
		infoMedicas.setMedicacao(false);
		infoMedicas.setQalergia(null);
		infoMedicas.setQmedicacao(null);
		infoMedicas.setTipoSangue(null);
		infoMedicas.setEdita(false);
		return "infoMedicas";
	}

	public String excluirRegistro(InfoMedicas u) {
		InfoMedicasCrudJDBC.excluir(u);
		// salva o usu�rio
		return u.getId()+"";
	}

	public String alterarRegistro(InfoMedicas u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (InfoMedicas usu : lista) {
			if (usu.isEdita()) {
				InfoMedicasCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		InfoMedicasCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.infoMedicas.getSenha().equalsIgnoreCase(this.infoMedicas.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		InfoMedicasCrudJDBC.salvar(this.infoMedicas);
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		InfoMedicasCrudJDBC.listar();
		return "listagem";
	}

}