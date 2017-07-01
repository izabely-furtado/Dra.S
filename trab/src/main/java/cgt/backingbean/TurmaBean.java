package cgt.backingbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import cdp.classesAnemicas.Aluno;
import cdp.classesAnemicas.Turma;
import cgd.crudjdbc.AlunoCrudJDBC;
import cgd.crudjdbc.TurmaCrudJDBC;


@ManagedBean(name = "TurmaBean")
@SessionScoped
public class TurmaBean implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Turma> lista = new ArrayList<Turma>();
	private Turma turma = new Turma();
	TurmaCrudJDBC objTurmaCrudJDBC = new TurmaCrudJDBC();
	private List<SelectItem> alunosSelect;
	private Aluno alunoSelecionado;
	
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
	
	

	public Aluno getAlunoSelecionado() {
		return alunoSelecionado;
	}



	public void setAlunoSelecionado(Aluno alunoSelecionado) {
		this.alunoSelecionado = alunoSelecionado;
	}



	public void setAlunosSelect(List<SelectItem> alunosSelect) {
		this.alunosSelect = alunosSelect;
	}

	public TurmaBean(){
		lista = TurmaCrudJDBC.listar();
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

	public String novo() {
		
		//this.turma.setId(-1);
		this.turma.setCodigo("0");
		this.turma.setMaximo(-1);
		this.turma.setTurno(null);
		this.turma.setNivel(-1);
		this.turma.setSegunda(false);
		this.turma.setTerca(false);
		this.turma.setQuarta(false);
		this.turma.setQuinta(false);
		this.turma.setSexta(false);
		/*this.turma.setAlunos(null);
		this.turma.setAulas(null);
		this.turma.setEdita(false);*/
		
		
		return "turma";
	}

	public String excluirRegistro(Turma t) {
		TurmaCrudJDBC.excluir(t);
		// salva a turma
		return t.getId()+"";
	}

	public String alterarRegistro(Turma t) {
		//t.setEdita(true);
		return "alterar";
	}

	public String salvarRegistro() {
		for (Turma turma : lista) {
			TurmaCrudJDBC.alterar(turma);
			/*if (turma.isEdita()) {
				TurmaCrudJDBC.alterar(turma);
			}
			turma.setEdita(false);*/
		}
		//lista = TurmaCrudJDBC.listar();
		return "salvar";
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.endereco.getSenha().equalsIgnoreCase(this.endereco.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		TurmaCrudJDBC.salvar(this.turma);
		//lista = TurmaCrudJDBC.listar();
		// salva a turma
		return "sucesso";
	}

	public String verLista() {
		TurmaCrudJDBC.listar();
		return "listagem";
	}

}
