package cgt.backingbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.Aluno;
import cdp.classesAnemicas.Aula;
import cdp.classesAnemicas.Turma;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
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

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public void setLista(List<Aula> lista) {
		this.lista = lista;
	}

	public String novo() {
		
		this.aula.setId(-1);
		this.aula.setTipo("");
		this.aula.setHorario("");
		this.aula.setData("");
		this.aula.setConteudo("");
		this.aula.setPresentes(new ArrayList<Aluno>());
		this.aula.setEdita(false);
		this.aula.setTurma(new Turma());
		
		return "aula";
	}

	public String excluirRegistro(Aula a) {
		AulaCrudJDBC.excluir(a);
		// salva a aula
		return a.getId()+"";
	}

	public String alterarRegistro(Aula a) {
		a.setEdita(true);
		return "alterar";
	}

	public String salvarRegistro() {
		for (Aula aula : lista) {
			if (aula.isEdita()) {
				AulaCrudJDBC.alterar(aula);
			}
			aula.setEdita(false);
		}
		lista = AulaCrudJDBC.listar();
		return "salvar";
	}

	public String inserir() throws IOException {
		System.out.println("treco da aulaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		AulaCrudJDBC.salvar(this.aula);
		// salva a aula
		FacesContext.getCurrentInstance().getExternalContext().redirect("./inicio.jsf");
		return "sucesso";
	}

	public String verLista() {
		AulaCrudJDBC.listar();
		return "listagem";
	}

}
