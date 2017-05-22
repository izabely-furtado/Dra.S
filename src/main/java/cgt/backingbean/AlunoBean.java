package main.java.cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.cdp.classesAnemicas.Aluno;
import main.java.cgd.crudjdbc.*;

@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean {
	private List<Aluno> lista;
	private Aluno aluno = new Aluno();
	AlunoCrudJDBC objAlunoCrudJDBC = new AlunoCrudJDBC();

	public List<Aluno> getLista() {
		return lista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}

	public String novo() {
		
		this.aluno.setId(-1);
		this.aluno.setFap(null);
		this.aluno.setFoto(null);
		this.aluno.setNivel(0);
		this.aluno.setTurma(null);
		this.aluno.setEdita(false);
		
		return "aluno";
	}

	public String excluirRegistro(Aluno a) {
		AlunoCrudJDBC.excluir(a);
		// salva a aluno
		return a.getId()+"";
	}

	public String alterarRegistro(Aluno a) {
		a.setEdita(true);
		return "alterar";
	}

	public String salvarRegistro() {
		for (Aluno aluno : lista) {
			if (aluno.isEdita()) {
				AlunoCrudJDBC.alterar(aluno);
			}
			aluno.setEdita(false);
		}
		lista = AlunoCrudJDBC.listar();
		return "salvar";
	}

	public String inserir() {
		
	
		AlunoCrudJDBC.salvar(this.aluno);
		// salva a aluno
		return "sucesso";
	}

	public String verLista() {
		AlunoCrudJDBC.listar();
		return "listagem";
	}

}
