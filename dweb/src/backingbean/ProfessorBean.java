package backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import crudjdbc.*;
import classesAnemicas.Professor;

@ManagedBean(name = "professorBean")
@SessionScoped
public class ProfessorBean {
	private List<Professor> lista;
	private Professor professor = new Professor();
	ProfessorCrudJDBC objProfessorCrudJDBC = new ProfessorCrudJDBC();

	public List<Professor> getLista() {
		return lista;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public void setLista(List<Professor> lista) {
		this.lista = lista;
	}

	public String novo() {
		professor.setId(-1);
		professor.setDataNasc(null);
		professor.setDescConvenio(null);
		professor.setEndereco(null);
		professor.setNome(null);
		professor.setPossuiConvenio(false);
		professor.setTelefone(null);
		professor.setTipoSangue(null);
		professor.setHrDisponivelFim(null);
		professor.setHrDisponivelInicio(null);
		professor.setTurmas(null);
		professor.setEdita(false);
		return "professor";
	}

	public String excluirRegistro(Professor u) {
		ProfessorCrudJDBC objUsuarioCrudJDBC = new ProfessorCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		// salva o usuário
		return u.getNome();
	}

	public String alterarRegistro(Professor u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Professor usu : lista) {
			if (usu.isEdita()) {
				ProfessorCrudJDBC objProfessorCrudJDBC = new ProfessorCrudJDBC();
				objProfessorCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objProfessorCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.professor.getSenha().equalsIgnoreCase(this.professor.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
		ProfessorCrudJDBC objUsuarioCrudJDBC = new ProfessorCrudJDBC();
		objUsuarioCrudJDBC.salvar(this.professor);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		ProfessorCrudJDBC objUsuarioCrudJDBC = new ProfessorCrudJDBC();
		lista = objUsuarioCrudJDBC.listar();
		return "listagem";
	}
}
