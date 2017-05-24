package cgt.backingbean;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import cdp.classesAnemicas.AcessoServicos;
import cdp.classesAnemicas.AcompanhamentoEscolar; 
import cdp.classesAnemicas.Aluno;
import cdp.classesAnemicas.DadosPessoais;
import cdp.classesAnemicas.Endereco;
import cdp.classesAnemicas.InfoMedicas;
import cdp.classesAnemicas.InfoTransporte;
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

	public String novo() {
		
		this.aluno.setId(-1);
		//this.aluno.setFap(null);
		this.aluno.setFoto(null);
		this.aluno.setNivel(0);
		this.aluno.setTurma(null);
		this.aluno.setAcessoServicos(new AcessoServicos());
		this.aluno.setAcompanhamentoEscolar(new AcompanhamentoEscolar());
		this.aluno.setEndereco(new Endereco());
		this.aluno.setComposicaoFamiliar(null);
		this.aluno.setCondicoesMoradia(null);
		this.aluno.setDadosPessoais(new DadosPessoais());
		this.aluno.setDespesas(null);
		this.aluno.setInfoMedicas(new InfoMedicas());
		this.aluno.setInfoTransporte(new InfoTransporte());
		this.aluno.setProgramasBeneficios(null);
		this.aluno.setPublicoPrioritario(null);
		this.aluno.setEdita(false);
		
		return "aluno";
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

	public String salvarRegistro() {
		for (Aluno aluno : lista) {
			if (aluno.isEdita()) {
				AlunoCrudJDBC.alterar(aluno);
			}
			aluno.setEdita(false);
		}
		lista = AlunoCrudJDBC.listar();
		return "salvar";
	}

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
			FacesContext.getCurrentInstance().getExternalContext().redirect("./formularioAcompanhamentoPsico2.jsf");
		}
		
	}
	
	public String inserir() {
		
	
		AlunoCrudJDBC.salvar(this.aluno);
		// salva a aluno
		return "sucesso";
	}

	public String verLista() {
		AlunoCrudJDBC.listar();
		return "listagem";
	}

}
