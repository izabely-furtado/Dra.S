package cgt.backingbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.Endereco;
import cgd.crudjdbc.*;;

@SuppressWarnings("deprecation")
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

		public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setLista(List<Endereco> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.endereco = new Endereco();
		return "endereco";
	}

	public String excluirRegistro(Endereco u) {
		EnderecoCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return u.getId()+"";
	}

	public String alterarRegistro(Endereco u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (Endereco usu : lista) {
			if (usu.isEdita()) {
				EnderecoCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = EnderecoCrudJDBC.listar();
		return null;
	}

	public String gerar(FacesContext context) {
		int erro = 0;
		if (this.endereco.getCep() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o CEP", ""));
			erro++;
		}
		if (this.endereco.getNumero() <= 0){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o número da casa", ""));
			erro++;
		}
		if (this.endereco.getReferencia() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe uma referência", ""));
			erro++;
		}
		
		if (erro == 0) {
			return "passou";
		}
		else {
			return "deubosta";
		}
	}
	
	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.endereco.getSenha().equalsIgnoreCase(this.endereco.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		//EnderecoCrudJDBC.salvar(this.endereco);
		// salva o usuï¿½rio
		return "sucesso";
	}

	public String verLista() {
		EnderecoCrudJDBC.listar();
		return "listagem";
	}

}
