package cgt.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cdp.classesAnemicas.AlunosTurma;
import cdp.classesAnemicas.Turma;
import cgd.crudjdbc.AlunoTurmaCrudJDBC;
import cgd.crudjdbc.TurmaCrudJDBC;



@ManagedBean(name = "AlunosTurmaBean")
@SessionScoped
public class AlunosTurmaBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<AlunosTurma> lista = new ArrayList<AlunosTurma>();
	private AlunosTurma alunosturma = new AlunosTurma();
	AlunoTurmaCrudJDBC objAlunosTurmaCrudJDBC = new AlunoTurmaCrudJDBC();
	
	/*
	public AlunosTurmaBean(){
		lista = AlunoTurmaCrudJDBC.listar();
	}

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
*/
	public String novo() {
		
		this.alunosturma.setAluno_id(-1);
		this.alunosturma.setTurma_id(-1);
		
		return "turma";
	}



	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.endereco.getSenha().equalsIgnoreCase(this.endereco.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		//AlunoTurmaCrudJDBC.salvar(this.alunosturma);
		//lista = TurmaCrudJDBC.listar();
		// salva a turma
		return "sucesso";
	}

	public String verLista() {
		TurmaCrudJDBC.listar();
		return "listagem";
	}

}
