package backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import classesAnemicasAntiga.Aula;
import crudjdbc.*;;

@ManagedBean(name = "aulaBean")
@SessionScoped
public class AulaBean {
	private List<Aula> lista;
	private Aula aula = new Aula();
	AulaCrudJDBC objAulaCrudJDBC = new AulaCrudJDBC();

	public List<Aula> getLista() {
		return lista;
	}

	public Aula getAula() {
		return aula;
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

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public void setLista(List<Aula> lista) {
		this.lista = lista;
	}

	public String novo() {
		aula.setId(-1);
		aula.setDataAula(null);
		aula.setEnsinado(null);
		aula.setHoraAula(null);
		aula.setPresentes(null);
		aula.setEdita(false);
		return "aula";
	}

	public String excluirRegistro(Aula u) {
		AulaCrudJDBC objUsuarioCrudJDBC = new AulaCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		// salva o usuário
		return u.getDataAula() + "";
	}

	public String alterarRegistro(Aula u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Aula usu : lista) {
			if (usu.isEdita()) {
				AulaCrudJDBC objAulaCrudJDBC = new AulaCrudJDBC();
				objAulaCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objAulaCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.aula.getSenha().equalsIgnoreCase(this.aula.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
		AulaCrudJDBC objUsuarioCrudJDBC = new AulaCrudJDBC();
		objUsuarioCrudJDBC.salvar(this.aula);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		AulaCrudJDBC objUsuarioCrudJDBC = new AulaCrudJDBC();
		lista = objUsuarioCrudJDBC.listar();
		return "listagem";
	}

}
