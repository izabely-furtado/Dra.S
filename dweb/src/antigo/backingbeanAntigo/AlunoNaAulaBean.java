package backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import classesAnemicasAntiga.Aluno;
import classesAnemicasAntiga.AlunoNaAula;
import classesAnemicasAntiga.Aula;
import crudjdbc.*;

@ManagedBean(name = "alunoNaAulaBean")
@SessionScoped
public class AlunoNaAulaBean {
	private List<AlunoNaAula> lista;
	private AlunoNaAula alunoNaAula = new AlunoNaAula();
	AlunoNaAulaCrudJDBC objAlunoNaAulaCrudJDBC = new AlunoNaAulaCrudJDBC();

	public List<AlunoNaAula> getLista() {
		return lista;
	}

	public AlunoNaAula getAlunoNaAula() {
		return alunoNaAula;
	}

	public void setAlunoNaAula(AlunoNaAula alunoNaAula) {
		this.alunoNaAula = alunoNaAula;
	}

	public void setLista(List<AlunoNaAula> lista) {
		this.lista = lista;
	}

	public String novo() {
		alunoNaAula.setAula(null);
		alunoNaAula.setAlunos(null);
		alunoNaAula.setEdita(false);
		return "alunoNaAula";
	}

	public String excluirRegistroDeAula(Aula aula) {
		AlunoNaAulaCrudJDBC objUsuarioCrudJDBC = new AlunoNaAulaCrudJDBC();
		objUsuarioCrudJDBC.excluir(aula);
		// salva o usuário
		return aula.getId()+"";
	}
	
	public String excluirRegistroDaAluno(Aula aula, Aluno aluno) {
		AlunoNaAulaCrudJDBC objUsuarioCrudJDBC = new AlunoNaAulaCrudJDBC();
		objUsuarioCrudJDBC.excluir(aula, aluno);
		// salva o usuário
		return aula.getId() + " - " + aluno.getId();
	}

	public String alterarRegistro(AlunoNaAula u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (AlunoNaAula usu : lista) {
			if (usu.isEdita()) {
				AlunoNaAulaCrudJDBC objAlunoNaAulaCrudJDBC = new AlunoNaAulaCrudJDBC();
				objAlunoNaAulaCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.alunoNaAula.getSenha().equalsIgnoreCase(this.alunoNaAula.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
		AlunoNaAulaCrudJDBC objUsuarioCrudJDBC = new AlunoNaAulaCrudJDBC();
		objUsuarioCrudJDBC.salvar(this.alunoNaAula);
		// salva o usuário
		return "sucesso";
	}

	public String verLista(Aula aula) {
		AlunoNaAulaCrudJDBC objUsuarioCrudJDBC = new AlunoNaAulaCrudJDBC();
		lista = objUsuarioCrudJDBC.listar(aula);
		return "listagem";
	}
}
