package cgt.backingbean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.AcessoServicos;
import cdp.classesAnemicas.AcompanhamentoEscolar; 
import cdp.classesAnemicas.Aluno;
import cdp.classesAnemicas.ComposicaoFamiliar;
import cdp.classesAnemicas.CondicoesMoradia;
import cdp.classesAnemicas.DadosPessoais;
import cdp.classesAnemicas.Despesas;
import cdp.classesAnemicas.Endereco;
import cdp.classesAnemicas.InfoMedicas;
import cdp.classesAnemicas.InfoTransporte;
import cdp.classesAnemicas.Parente;
import cdp.classesAnemicas.ProgramasBeneficios;
import cdp.classesAnemicas.PublicoPrioritario;
import cdp.classesAnemicas.Turma;
import cgd.crudjdbc.*;

@SuppressWarnings("deprecation")
@ManagedBean(name = "alunoBean")
@SessionScoped
public class AlunoBean {
	private List<Aluno> lista;
	private Aluno aluno = new Aluno();
	AlunoCrudJDBC objAlunoCrudJDBC = new AlunoCrudJDBC();
	
	public List<Aluno> getLista() {
		return lista;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}

	public String novo() throws IOException {
		/*
		this.aluno.setId(-1);
		//this.aluno.setFap(null);
		this.aluno.setFoto("");
		this.aluno.setNivel(0);
		this.aluno.setTurma(new Turma());
		this.aluno.setAcessoServicos(new AcessoServicos());
		this.aluno.setAcompanhamentoEscolar(new AcompanhamentoEscolar());
		this.aluno.setEndereco(new Endereco());
		this.aluno.setComposicaoFamiliar(new ComposicaoFamiliar());
		this.aluno.setCondicoesMoradia(new CondicoesMoradia());
		this.aluno.setDadosPessoais(new DadosPessoais());
		this.aluno.setDespesas(new Despesas());
		this.aluno.setInfoMedicas(new InfoMedicas());
		this.aluno.setInfoTransporte(new InfoTransporte());
		this.aluno.setProgramasBeneficios(new ProgramasBeneficios());
		this.aluno.setPublicoPrioritario(new PublicoPrioritario());
		this.aluno.setEdita(false);
		
		return "aluno";
		*/
		System.out.println("passou aqui");
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.aluno.getDadosPessoais().getNome() == "") {// && this.aluno.getTurma().getCodigo() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o nome do aluno ou a turma para efetuar a pesquisa", ""));
			System.out.println("passou aqui");
			System.out.println();
			System.out.println();
			System.out.println();
			return "erro";
		}
		else {
			System.out.println(AlunoCrudJDBC.getAlunoPorNome(this.aluno.getDadosPessoais().getNome()).get(0));
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			this.lista.addAll(AlunoCrudJDBC.getAlunoPorNome(this.aluno.getDadosPessoais().getNome()));
			FacesContext.getCurrentInstance().getExternalContext().redirect("./inicio.jsf");
			return "pesquisou";
			//this.lista = AlunoCrudJDBC.getAlunoPorNomeTurma(this.aluno.getDadosPessoais().getNome(), this.aluno.getTurma().getCodigo());
		}
	}

	public String excluirRegistro(Aluno a) {
		AlunoCrudJDBC.excluir(a);
		// salva a aluno
		return a.getId()+"";
	}

	public String alterarRegistro(Aluno a) {
		a.setEdita(true);
		return "alterar";
	}

	/*public String salvarRegistro() {
		for (Aluno aluno : lista) {
			if (aluno.isEdita()) {
				AlunoCrudJDBC.alterar(aluno);
			}
			aluno.setEdita(false);
		}
		lista = AlunoCrudJDBC.listar();
		return "salvar";
	}*/

	public void gerarFAP1() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		DadosPessoaisBean dadosPessoaisBean = new DadosPessoaisBean();
		dadosPessoaisBean.setDadosPessoais(this.aluno.getDadosPessoais());
		String passouDadosPessoais = dadosPessoaisBean.gerar(context);
		
		EnderecoBean enderecoBean = new EnderecoBean();
		enderecoBean.setEndereco(this.aluno.getEndereco());
		String passouEndereco = enderecoBean.gerar(context);
		
		AcompanhamentoEscolarBean acompanhamentoEscolarBean = new AcompanhamentoEscolarBean();
		acompanhamentoEscolarBean.setAcompanhamentoEscolar(this.aluno.getAcompanhamentoEscolar());
		String passouAcompanhamentoEscolar = acompanhamentoEscolarBean.gerar(context);
		
		InfoMedicasBean infoMedicasBean = new InfoMedicasBean();
		infoMedicasBean.setInfoMedicas(this.aluno.getInfoMedicas());
		String passouInfoMedicas = infoMedicasBean.gerar(context);
		
		InfoTransporteBean infoTransporteBean = new InfoTransporteBean();
		infoTransporteBean.setInfoTransporte(this.aluno.getInfoTransporte());
		String passouInfoTransporte = infoTransporteBean.gerar(context);
		
		if (passouInfoTransporte == "passou" && 
			passouDadosPessoais == "passou"&& 
			passouEndereco == "passou" && 
			passouAcompanhamentoEscolar == "passou" && 
			passouInfoMedicas == "passou"){
			FacesContext.getCurrentInstance().getExternalContext().redirect("./formularioAcompanhamentoPsico3.jsf");
		}
		
	}
	
	public void gerarFAP2(List<Parente> parentes) throws IOException {
		this.aluno.getComposicaoFamiliar().setParentes(parentes);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("./formularioAcompanhamentoPsico3.jsf");
		
		
	}
	
	public void gerarFAP3() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		DespesasBean despesasBean = new DespesasBean();
		despesasBean.setDespesas(this.aluno.getDespesas());
		String passouDespesas = despesasBean.gerar(context);
		
		if (passouDespesas == "passou"){
			FacesContext.getCurrentInstance().getExternalContext().redirect("./formularioAcompanhamentoPsico4.jsf");
		}
		
	}
	
	public void gerarFAP4() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		CondicoesMoradiaBean condicoesBean = new CondicoesMoradiaBean();
		condicoesBean.setCondicoesMoradia(this.aluno.getCondicoesMoradia());
		String passoucondicoesBean = condicoesBean.gerar(context);
		
		if (passoucondicoesBean == "passou"){
			FacesContext.getCurrentInstance().getExternalContext().redirect("./formularioAcompanhamentoPsico5.jsf");
		}
		
	}
	
	public void gerarFAP5() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		AcessoServicosBean acessoServicosBean = new AcessoServicosBean();
		acessoServicosBean.setAcessoServicos(this.aluno.getAcessoServicos());
		String passouacessoServicos = acessoServicosBean.gerar(context);
		ProgramasBeneficiosBean programasBeneficiosBeanBean = new ProgramasBeneficiosBean();
		programasBeneficiosBeanBean.setProgramasBeneficios(this.aluno.getProgramasBeneficios());
		String passouprogramasBeneficios = programasBeneficiosBeanBean.gerar(context);
		
		if (passouacessoServicos == "passou" && passouprogramasBeneficios == "passou"){
			FacesContext.getCurrentInstance().getExternalContext().redirect("./formularioAcompanhamentoPsico6.jsf");
		}
		
	}
	
	public void gerarFAP6() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		PublicoPrioritarioBean publicoPrioritarioBean = new PublicoPrioritarioBean();
		publicoPrioritarioBean.setPublicoPrioritario(this.aluno.getPublicoPrioritario());
		String passouPublicoPrioritario = publicoPrioritarioBean.gerar(context);
		
		if (passouPublicoPrioritario == "passou"){
			FacesContext.getCurrentInstance().getExternalContext().redirect("./visualizaAluno.jsf");
		}
		
	}
	
	public String gerarPesquisa() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.aluno.getDadosPessoais().getNome() == "") {// && this.aluno.getTurma().getCodigo() == ""){
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informe o nome do aluno ou a turma para efetuar a pesquisa", ""));
			return "erro";
		}
		else {
			this.lista = AlunoCrudJDBC.getAlunoPorNome(this.aluno.getDadosPessoais().getNome());
			return "pesquisou";
			//this.lista = AlunoCrudJDBC.getAlunoPorNomeTurma(this.aluno.getDadosPessoais().getNome(), this.aluno.getTurma().getCodigo());
		}
	}
	public String inserir() throws IOException {
		AlunoCrudJDBC.salvar(this.aluno);
		//this.lista = AlunoCrudJDBC.listar();
		// salva a aluno
		FacesContext.getCurrentInstance().getExternalContext().redirect("./inicio.jsf");
		return "sucesso";
	}
	
	public Aluno getAlunoPorCodigo(int codigo)
	{
		return AlunoCrudJDBC.getAluno(codigo);
	}

	public String verLista() {
		//AlunoCrudJDBC.listar();
		return "listagem";
	}

}
