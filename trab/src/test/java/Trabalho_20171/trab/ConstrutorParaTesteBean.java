package Trabalho_20171.trab;

import java.util.ArrayList;

import cdp.classesAnemicas.*;
import cgt.backingbean.AcessoServicosBean;
import cgt.backingbean.AcompanhamentoEscolarBean;
import cgt.backingbean.AlunoBean;
import cgt.backingbean.AulaBean;
import cgt.backingbean.ComposicaoFamiliarBean;
import cgt.backingbean.CondicoesMoradiaBean;
import cgt.backingbean.DadosAcessoBean;
import cgt.backingbean.DadosPessoaisBean;
import cgt.backingbean.DespesasBean;
import cgt.backingbean.EnderecoBean;
import cgt.backingbean.InfoMedicasBean;
import cgt.backingbean.InfoTransporteBean;
import cgt.backingbean.ProgramasBeneficiosBean;
import cgt.backingbean.PublicoPrioritarioBean;
import cgt.backingbean.TermoDesligamentoBean;
import cgt.backingbean.TurmaBean;

public class ConstrutorParaTesteBean {
	public static AcessoServicosBean criaAcesso(){
		AcessoServicosBean acessoBean = new AcessoServicosBean();
		acessoBean.setAcessoServicos(ConstrutorParaTeste.criaAcesso());
		acessoBean.setLista(new ArrayList<AcessoServicos>());
		
		return acessoBean;
	}
	public static AcompanhamentoEscolarBean criaAcompanhamento(){
		AcompanhamentoEscolarBean acompanhamentoEscolarBean = new AcompanhamentoEscolarBean();
		acompanhamentoEscolarBean.setAcompanhamentoEscolar(ConstrutorParaTeste.criaAcompanhamento());
		acompanhamentoEscolarBean.setLista(new ArrayList<AcompanhamentoEscolar>());
		
		return acompanhamentoEscolarBean;
	}
	public static AulaBean criaAula(){
		AulaBean aulaBean = new AulaBean();
		aulaBean.setAula(ConstrutorParaTeste.criaAula());
		aulaBean.setLista(new ArrayList<Aula>());
		
		return aulaBean;
	}
	public static ComposicaoFamiliarBean criaComposicao(){
		ComposicaoFamiliarBean composicaoBean = new ComposicaoFamiliarBean();
		composicaoBean.setComposicaoFamiliar(ConstrutorParaTeste.criaComposicao());
		composicaoBean.setLista(new ArrayList<ComposicaoFamiliar>());
		
		return composicaoBean;
	}
	public static CondicoesMoradiaBean criaCondicoes(){
		CondicoesMoradiaBean condicoesBean = new CondicoesMoradiaBean();
		condicoesBean.setCondicoesMoradia(ConstrutorParaTeste.criaCondicoes());
		condicoesBean.setLista(new ArrayList<CondicoesMoradia>());
		
		return condicoesBean;
	}
	public static DadosAcessoBean criaDadosAcesso(){
		DadosAcessoBean dadosAcessoBean = new DadosAcessoBean();
		dadosAcessoBean.setDadosAcesso(ConstrutorParaTeste.criaDadosAcesso());
		dadosAcessoBean.setLista(new ArrayList<DadosAcesso>());
		
		return dadosAcessoBean;
	}
	public static DadosPessoaisBean criaDadosPessoais(){
		DadosPessoaisBean dadosPessoaisBean = new DadosPessoaisBean();
		dadosPessoaisBean.setDadosPessoais(ConstrutorParaTeste.criaDadosPessoais());
		dadosPessoaisBean.setLista(new ArrayList<DadosPessoais>());
		
		return dadosPessoaisBean;
	}
	public static DespesasBean criaDespesas(){
		DespesasBean despesasBean = new DespesasBean();
		despesasBean.setDespesas(ConstrutorParaTeste.criaDespesas());
		despesasBean.setLista(new ArrayList<Despesas>());
		
		return despesasBean;
	}
	public static EnderecoBean criaEndereco(){
		EnderecoBean enderecoBean = new EnderecoBean();
		enderecoBean.setEndereco(ConstrutorParaTeste.criaEndereco());
		enderecoBean.setLista(new ArrayList<Endereco>());
		
		return enderecoBean;
	}
	
	public static AlunoBean criaAluno(){
		AlunoBean aluno = new AlunoBean();
		aluno.setAluno(ConstrutorParaTeste.criaAluno());
		aluno.setLista(new ArrayList<Aluno>());
		
		return aluno;
	}
	public static InfoMedicasBean criaInfoMedicas(){
		InfoMedicasBean infoMedicasBean = new InfoMedicasBean();
		infoMedicasBean.setInfoMedicas(ConstrutorParaTeste.criaInfoMedicas());
		infoMedicasBean.setLista(new ArrayList<InfoMedicas>());
		
		return infoMedicasBean;
	}
	public static InfoTransporteBean criaInfoTransporte(){
		InfoTransporteBean infoTransporteBean = new InfoTransporteBean();
		infoTransporteBean.setInfoTransporte(ConstrutorParaTeste.criaInfoTransporte());
		infoTransporteBean.setLista(new ArrayList<InfoTransporte>());
		
		return infoTransporteBean;
	}
	public static ProgramasBeneficiosBean criaProgramasBeneficios(){
		ProgramasBeneficiosBean programasBeneficiosBean = new ProgramasBeneficiosBean();
		programasBeneficiosBean.setProgramasBeneficios(ConstrutorParaTeste.criaProgramasBeneficios());
		programasBeneficiosBean.setLista(new ArrayList<ProgramasBeneficios>());
		
		return programasBeneficiosBean;
	}
	public static PublicoPrioritarioBean criaPublicoPrioritario(){
		PublicoPrioritarioBean publicoPrioritarioBean = new PublicoPrioritarioBean();
		publicoPrioritarioBean.setPublicoPrioritario(ConstrutorParaTeste.criaPublicoPrioritario());
		publicoPrioritarioBean.setLista(new ArrayList<PublicoPrioritario>());
		
		return publicoPrioritarioBean;
	}
	
	public static TurmaBean criaTurma(){
		TurmaBean turmaBean = new TurmaBean();
		turmaBean.setTurma(ConstrutorParaTeste.criaTurma());
		turmaBean.setLista(new ArrayList<Turma>());
		
		return turmaBean;
	}
	
	public static TermoDesligamentoBean criaTermoDesligamento(){
		TermoDesligamentoBean termoDesligamentoBean = new TermoDesligamentoBean();
		termoDesligamentoBean.setTermoDesligamento(ConstrutorParaTeste.criaTermoDesligamento());
		//termoDesligamentoBean.setLista(new ArrayList<TermoDesligamento>());
		
		return termoDesligamentoBean;
	}
	
}
