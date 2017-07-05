package cgt.backingbean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;

import org.primefaces.context.RequestContext;

import cdp.classesAnemicas.Aluno;
import cdp.classesAnemicas.AlunosTurma;
import cdp.classesAnemicas.Turma;
import cgd.crudjdbc.AlunoCrudJDBC;
import cgd.crudjdbc.AlunoTurmaCrudJDBC;
import cgd.crudjdbc.TurmaCrudJDBC;



@SuppressWarnings("deprecation")
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
	private Aluno alunoselecionado = new Aluno();
	
	public AlunosTurma getAlunosturma() {
		return alunosturma;
	}

	public void setAlunosturma(AlunosTurma alunosturma) {
		this.alunosturma = alunosturma;
	}
	
	

	public Aluno getAlunoselecionado() {
		return alunoselecionado;
	}

	public void setAlunoselecionado(Aluno alunoselecionado) {
		this.alunoselecionado = alunoselecionado;
	}

	//ALUNO SELECIONADO
	private List<SelectItem> alunosSelect;

	//TURMA SELECIONADA
	private List<SelectItem> turmaSelect;

	private Aluno alunoSelecionado = new Aluno();

	private Turma turmaSelecionada = new Turma();

	public List<SelectItem> getAlunosSelect() {

		if(this.alunosSelect == null)
		{
			this.alunosSelect = new ArrayList<SelectItem>();
			AlunoCrudJDBC alunosBD = new AlunoCrudJDBC();
			List<Aluno> listaAlunos = alunosBD.listar();

			if(listaAlunos != null && !(listaAlunos.isEmpty())){
				SelectItem item;
				for (Aluno alunoLista : listaAlunos){
					item = new SelectItem(alunoLista, alunoLista.getDadosPessoais().getNome());
					this.alunosSelect.add(item);
				}
			}

		}
		return alunosSelect;
	}

	public List<SelectItem> getTurmaSelect() {

		if(this.turmaSelect == null)
		{
			this.turmaSelect = new ArrayList<SelectItem>();
			TurmaCrudJDBC turmasBD = new TurmaCrudJDBC();
			List<Turma> listaTurmas = turmasBD.listar();

			if(listaTurmas != null && !(listaTurmas.isEmpty())){
				SelectItem item;
				for (Turma turmaLista : listaTurmas){
					item = new SelectItem(turmaLista, turmaLista.getCodigo());
					this.turmaSelect.add(item);
				}
			}

		}
		return turmaSelect;
	}


	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;

	}

	public Turma getTurmaSelecionada() {
		return this.turmaSelecionada;

	}


	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}


	public void setTurmaSelecionada(Turma turmaSelecionada) {
		this.turmaSelecionada = turmaSelecionada;
	}

	public void setAlunosSelect(List<SelectItem> alunosSelect) {
		this.alunosSelect = alunosSelect;
	}

	public void setTurmasSelect(List<SelectItem> turmasSelect) {
		this.turmaSelect = turmasSelect;
	}



	public List<AlunosTurma> getLista() {
		return lista;
	}

	public AlunosTurma getParente() {
		return this.alunosturma;
	}

	public void setAlunosTurma(AlunosTurma alunosTurma) {
		this.alunosturma = alunosTurma;
	}

	public void setLista(List<AlunosTurma> lista) {
		this.lista = lista;
	}
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

	public String addAlunoTurma() {

		this.lista.add(this.alunosturma);
		return "passou";
	}



	public String verLista() {
		//TurmaCrudJDBC.listar();
		return "listagem";
	}

	
	public void matricularAlunoTurma() {

		AlunoTurmaCrudJDBC at = new AlunoTurmaCrudJDBC();
		AlunoCrudJDBC alunoBD = new AlunoCrudJDBC();
		TurmaCrudJDBC turmaBD = new TurmaCrudJDBC();
		
		Aluno aluno = new Aluno();
		Turma turma = new Turma();
		
		
		aluno = alunoBD.getAlunoPorNome2(this.alunosturma.getNomeAluno());
		turma = turmaBD.getByCodigo(this.alunosturma.getCodigoTurma());
		
	
			at.salvar(turma.getId(), aluno.getId());
		
	}
	

}
	
	
