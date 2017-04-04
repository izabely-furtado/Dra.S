package backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import crudjdbc.*;
import classesAnemicas.Turma;;

@ManagedBean(name = "turmaBean")
@SessionScoped
public class TurmaBean {/*
	private List<Turma> lista;
	private Turma turma = new Turma();
	TurmaCrudJDBC objTurmaCrudJDBC = new TurmaCrudJDBC();

	public List<Turma> getLista() {
		return lista;
	}

	public Turma getTurma() {
		return turma;
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

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setLista(List<Turma> lista) {
		this.lista = lista;
	}

	public String novo() {
		turma.setId(-1);
		turma.setAlunos(null);
		turma.setProfessores(null);
		turma.setAulas(null);
		turma.setNível(0);
		turma.setEdita(false);
		return "turma";
	}

	public String excluirRegistro(Turma u) {
		TurmaCrudJDBC objUsuarioCrudJDBC = new TurmaCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		// salva o usuário
		return u.getNível()+"";
	}

	public String alterarRegistro(Turma u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Turma usu : lista) {
			if (usu.isEdita()) {
				TurmaCrudJDBC objTurmaCrudJDBC = new TurmaCrudJDBC();
				objTurmaCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objTurmaCrudJDBC.listar();
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
	/*
		TurmaCrudJDBC objUsuarioCrudJDBC = new TurmaCrudJDBC();
		objUsuarioCrudJDBC.salvar(this.turma);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		TurmaCrudJDBC objUsuarioCrudJDBC = new TurmaCrudJDBC();
		lista = objUsuarioCrudJDBC.listar();
		return "listagem";
	}
*/
}
