package backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import classesAnemicas.DadosPessoais;
import crudjdbc.*;;

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

	public List<Integer> getDias() {
		List<Integer> lstDia = new ArrayList<>();
		for (int i = 1; i <= 31; i++) {
			lstDia.add(i);
		}
		return lstDia;
	}

	public List<Integer> getMeses() {
		List<Integer> lstMes = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			lstMes.add(i);
		}
		return lstMes;
	}

	public List<Integer> getAnos() {
		List<Integer> lstAno = new ArrayList<>();
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = anoAtual - 120; i <= anoAtual; i++) {
			lstAno.add(i);
		}
		return lstAno;
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
