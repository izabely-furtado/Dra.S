package backingbean;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import classesAnemicas.Endereco;
import crudjdbc.*;;

@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean {
	private List<Endereco> lista;
	private Endereco endereco = new Endereco();
	EnderecoCrudJDBC objEnderecoCrudJDBC = new EnderecoCrudJDBC();

	public List<Endereco> getLista() {
		return lista;
	}

	public Endereco getEndereco() {
		return endereco;
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

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setLista(List<Endereco> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.endereco.setId(-1);
		this.endereco.setBairro(null);
		this.endereco.setCep(null);
		this.endereco.setCidade(null);
		this.endereco.setEstado(null);
		this.endereco.setNumero(-1);
		this.endereco.setReferencia(null);
		this.endereco.setRua(null);
		this.endereco.setEdita(false);
		return "endereco";
	}

	public String excluirRegistro(Endereco u) {
		EnderecoCrudJDBC objUsuarioCrudJDBC = new EnderecoCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		// salva o usuário
		return u.getId()+"";
	}

	public String alterarRegistro(Endereco u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Endereco usu : lista) {
			if (usu.isEdita()) {
				EnderecoCrudJDBC objEnderecoCrudJDBC = new EnderecoCrudJDBC();
				objEnderecoCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = EnderecoCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.endereco.getSenha().equalsIgnoreCase(this.endereco.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		EnderecoCrudJDBC.salvar(this.endereco);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		EnderecoCrudJDBC.listar();
		return "listagem";
	}

}
