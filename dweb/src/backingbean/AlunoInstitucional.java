package backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import crudjdbc.*;
import classesAnemicas.AlunoInstituicao;

@ManagedBean(name = "alunoIBean")
@SessionScoped
public class AlunoInstitucional {
	private List<AlunoInstituicao> lista;
	private AlunoInstituicao aluno = new AlunoInstituicao();
	AlunoCrudJDBC objAlunoCrudJDBC = new AlunoCrudJDBC();

	public List<AlunoInstituicao> getLista() {
		return lista;
	}

	public AlunoInstituicao getAluno() {
		return aluno;
	}

	public void setAlunoInstituicao(AlunoInstituicao aluno) {
		this.aluno = aluno;
	}

	public void setLista(List<AlunoInstituicao> lista) {
		this.lista = lista;
	}

	public String novo() {
		aluno.setId(-1);
		aluno.setDataNasc(null);
		aluno.setDescConvenio(null);
		aluno.setEndereco(null);
		aluno.setNivelAluno(0);
		aluno.setNome(null);
		aluno.setObs(null);
		aluno.setPossuiConvenio(false);
		aluno.setTelefone(null);
		aluno.setTipoAluno(Tipo.AlunoInstitucional);
		aluno.setTipoSangue(null);
		aluno.setMatriculaEscola(null);
		aluno.setNivelAluno(0);
		aluno.setNivelEscolaridade(0);
		aluno.setNomeResponsavel(null);
		aluno.setTelefoneEscola(null);
		aluno.setEdita(false);
		return "aluno";
	}

	public String excluirRegistro(AlunoInstituicao u) {
		AlunoCrudJDBC objUsuarioCrudJDBC = new AlunoCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		// salva o usuário
		return u.getNome();
	}

	public String alterarRegistro(AlunoInstituicao u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (AlunoInstituicao usu : lista) {
			if (usu.isEdita()) {
				AlunoCrudJDBC objAlunoCrudJDBC = new AlunoCrudJDBC();
				objAlunoCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objAlunoCrudJDBC.listarInstituicao();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.aluno.getSenha().equalsIgnoreCase(this.aluno.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
		AlunoCrudJDBC objUsuarioCrudJDBC = new AlunoCrudJDBC();
		objUsuarioCrudJDBC.salvar(this.aluno);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		AlunoCrudJDBC objUsuarioCrudJDBC = new AlunoCrudJDBC();
		lista = objUsuarioCrudJDBC.listarInstituicao();
		return "listagem";
	}
}
