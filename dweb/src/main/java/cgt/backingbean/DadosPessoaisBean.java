package main.java.cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.cdp.classesAnemicas.DadosPessoais;
import main.java.cgd.crudjdbc.*;;

@ManagedBean(name = "dadosPessoaisBean")
@SessionScoped
public class DadosPessoaisBean {
	private List<DadosPessoais> lista;
	private DadosPessoais dadosPessoais = new DadosPessoais();
	DadosPessoaisCrudJDBC objDadosPessoaisCrudJDBC = new DadosPessoaisCrudJDBC();

	public List<DadosPessoais> getLista() {
		return lista;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public void setLista(List<DadosPessoais> lista) {
		this.lista = lista;
	}

	public String novo() {
		dadosPessoais.setId(-1);
		dadosPessoais.setContato(null);
		dadosPessoais.setDatNasc(null);
		dadosPessoais.setNis(null);
		dadosPessoais.setNome(null);
		dadosPessoais.setParentesco(null);
		dadosPessoais.setResponsavel(null);
		dadosPessoais.setSexo(-1);
		dadosPessoais.setEdita(false);
		return "dadosPessoais";
	}

	public String excluirRegistro(DadosPessoais u) {
		DadosPessoaisCrudJDBC.excluir(u);
		// salva o usuário
		return u.getId()+"";
	}

	public String alterarRegistro(DadosPessoais u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (DadosPessoais usu : lista) {
			if (usu.isEdita()) {
				DadosPessoaisCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = DadosPessoaisCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.dadosPessoais.getSenha().equalsIgnoreCase(this.dadosPessoais.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		DadosPessoaisCrudJDBC.salvar(this.dadosPessoais);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		DadosPessoaisCrudJDBC.listar();
		return "listagem";
	}

}
