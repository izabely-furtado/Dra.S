package test.java.onda;

import java.util.ArrayList;

import main.java.cdp.classesAnemicas.*;
import main.java.cgt.backingbean.AcessoServicosBean;
import main.java.cgt.backingbean.AcompanhamentoEscolarBean;
import main.java.cgt.backingbean.AulaBean;
import main.java.cgt.backingbean.ComposicaoFamiliarBean;
import main.java.cgt.backingbean.CondicoesMoradiaBean;
import main.java.cgt.backingbean.DadosAcessoBean;
import main.java.cgt.backingbean.DadosPessoaisBean;
import main.java.cgt.backingbean.DespesasBean;
import main.java.cgt.backingbean.EnderecoBean;
import main.java.cgt.backingbean.FAPBean;
import main.java.cgt.backingbean.InfoMedicasBean;
import main.java.cgt.backingbean.InfoTransporteBean;
import main.java.cgt.backingbean.ProgramasBeneficiosBean;
import main.java.cgt.backingbean.PublicoPrioritarioBean;
import main.java.cgt.backingbean.TermoDesligamentoBean;
import main.java.cgt.backingbean.TurmaBean;

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
	
	public static FAPBean criaFAP(){
		FAPBean fapBean = new FAPBean();
		fapBean.setFormularioAcompanhamentoPsicossocial(ConstrutorParaTeste.criaFAP());
		fapBean.setLista(new ArrayList<FormularioAcompanhamentoPsicossocial>());
		
		return fapBean;
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
