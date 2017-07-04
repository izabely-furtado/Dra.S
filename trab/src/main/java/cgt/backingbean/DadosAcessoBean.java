package cgt.backingbean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.DadosAcesso;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "dadosAcessoBean")
@SessionScoped
public class DadosAcessoBean {

	private List<DadosAcesso> lista;
	private DadosAcesso dadosAcesso = new DadosAcesso();
	private String repita;
	private String antiga;
	private String nova;
	DadosAcessoCrudJDBC objDadosAcessoCrudJDBC = new DadosAcessoCrudJDBC();

	public List<DadosAcesso> getLista() {
		return lista;
	}

	public DadosAcesso getDadosAcesso() {
		return dadosAcesso;
	}

	public void setDadosAcesso(DadosAcesso dadosAcesso) {
		this.dadosAcesso = dadosAcesso;
	}

	public void setLista(List<DadosAcesso> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.dadosAcesso.setId(-1);
		this.dadosAcesso.setEmail(null);
		this.dadosAcesso.setLembrar(null);
		this.dadosAcesso.setLogin(null);
		this.dadosAcesso.setSenha(null);
		this.dadosAcesso.setEdita(false);
		return "dadosAcesso";
	}

	public String excluirRegistro(DadosAcesso u) {
		DadosAcessoCrudJDBC.excluir(u);
		// salva o usuï¿½rio
		return "excluir";
	}

	public String alterarRegistro() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("./alterarDadosAcesso.jsf");
		return "alterar";
	}

	public void gerar() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		int erro = 0;
		if (this.dadosAcesso.getEmail() == "") {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email inválido", ""));
			erro++;
		}
		if (this.antiga == this.dadosAcesso.getSenha() || this.antiga == "admin") {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe sua antiga senha", ""));
			erro++;
		}
		if (this.dadosAcesso.getSenha() == "") {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe uma senha", ""));
			erro++;
		}
		if (!this.nova.equals(repita)) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas diferentes, repita o procedimento", ""));
			erro++;
		}
		if (this.dadosAcesso.getLogin() == "") {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe um login", ""));
			erro++;
		}
		if (this.dadosAcesso.getLembrar() == "") {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Tens memória de elefante é?", ""));
		}

		if (erro == 0) {
			this.dadosAcesso.setSenha(nova);
			DadosAcessoCrudJDBC.alterar(dadosAcesso);
			FacesContext.getCurrentInstance().getExternalContext().redirect("./dadosAcesso.jsf");
		}

	}

	public void login() throws IOException, RuntimeException {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			this.dadosAcesso = DadosAcessoCrudJDBC.getDadosAcesso(this.dadosAcesso.getLogin(),
					this.dadosAcesso.getSenha());
			if (this.dadosAcesso.getEmail() == "" || this.dadosAcesso.getSenha() == ""){
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail e/ou senha incorretos", ""));
			}
			else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("./inicio.jsf");
			}

		} catch (RuntimeException e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "" + e, ""));
		}
	}

	public String salvarRegistro() {
		for (DadosAcesso usu : lista) {
			if (usu.isEdita()) {
				DadosAcessoCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		DadosAcessoCrudJDBC.listar();
		return "salvar";
	}

	public String inserir() throws IOException {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.dadosAcesso.getSenha().equalsIgnoreCase(this.dadosAcesso.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */

		DadosAcessoCrudJDBC.salvar(this.dadosAcesso);
		FacesContext.getCurrentInstance().getExternalContext().redirect("./alterarDadosAcesso.jsf");
		// salva o usuï¿½rio
		return "sucesso";
	}

	public void visualizarDadosAcesso() {

	}

	public String verLista() {
		DadosAcessoCrudJDBC.listar();
		return "listagem";
	}

	public String getRepita() {
		return repita;
	}

	public void setRepita(String repita) {
		this.repita = repita;
	}

	public String getAntiga() {
		return antiga;
	}

	public void setAntiga(String antiga) {
		this.antiga = antiga;
	}

	public String getNova() {
		return nova;
	}

	public void setNova(String nova) {
		this.nova = nova;
	}

}
