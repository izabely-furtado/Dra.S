package backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import crudjdbc.*;
import classesAnemicas.AlunoPago;;

@ManagedBean(name = "alunoPBean")
@SessionScoped
public class AlunoPagoBean {
	private List<AlunoPago> lista;
	private AlunoPago aluno = new AlunoPago();
	AlunoCrudJDBC objAlunoCrudJDBC = new AlunoCrudJDBC();

	public List<AlunoPago> getLista() {
		return lista;
	}

	public AlunoPago getAluno() {
		return aluno;
	}

	public void setAlunoPago(AlunoPago aluno) {
		this.aluno = aluno;
	}

	public void setLista(List<AlunoPago> lista) {
		this.lista = lista;
	}

	public String novo() {
		aluno.setId(-1);
		aluno.setDataNasc(null);
		aluno.setDescConvenio(null);
		aluno.setDiaDePagamento(0);
		aluno.setEndereco(null);
		aluno.setNivelAluno(0);
		aluno.setNome(null);
		aluno.setObs(null);
		aluno.setPacote(0);
		aluno.setPossuiConvenio(false);
		aluno.setTelefone(null);
		aluno.setTipoAluno(Tipo.AlunoPago);
		aluno.setTipoSangue(null);
		aluno.setEdita(false);
		return "aluno";
	}

	public String excluirRegistro(AlunoPago u) {
		AlunoCrudJDBC objUsuarioCrudJDBC = new AlunoCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		// salva o usuário
		return u.getNome();
	}

	public String alterarRegistro(AlunoPago u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (AlunoPago usu : lista) {
			if (usu.isEdita()) {
				AlunoCrudJDBC objAlunoCrudJDBC = new AlunoCrudJDBC();
				objAlunoCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objAlunoCrudJDBC.listarPago();
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
		lista = objUsuarioCrudJDBC.listarPago();
		return "listagem";
	}
}
