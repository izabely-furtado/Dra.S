package Trabalho_20171.trab.crud;

import static org.junit.Assert.*;

import org.junit.Test;

import Trabalho_20171.trab.ConstrutorParaTeste;
import cdp.classesAnemicas.*;
import cgd.crudjdbc.*;

public class CrudTestAluno {
	private Aluno aluno = ConstrutorParaTeste.criaAluno();
	private SituacaoAcolhimento situacaoAcolhimento = ConstrutorParaTeste.criaSituacaoAcolhimento();
	/*
	private AcessoServicos acesso = ConstrutorParaTeste.criaAcesso();
	private AcompanhamentoEscolar acompanhamento = ConstrutorParaTeste.criaAcompanhamento();
	private ComposicaoFamiliar composicao = ConstrutorParaTeste.criaComposicao();
	private CondicoesMoradia condicoes = ConstrutorParaTeste.criaCondicoes();
	private DadosPessoais dadosPessoais = ConstrutorParaTeste.criaDadosPessoais();
	private Despesas despesas = ConstrutorParaTeste.criaDespesas();
	private Endereco endereco = ConstrutorParaTeste.criaEndereco();
	private InfoMedicas infoMedicas = ConstrutorParaTeste.criaInfoMedicas();
	private InfoTransporte infoTransporte = ConstrutorParaTeste.criaInfoTransporte();
	private ProgramasBeneficios programasBeneficios = ConstrutorParaTeste.criaProgramasBeneficios();
	private PublicoPrioritario publicoPrioritario = ConstrutorParaTeste.criaPublicoPrioritario();
	private SituacaoAcolhimento situacaoAcolhimento = ConstrutorParaTeste.criaSituacaoAcolhimento();
	*/
	/* Testes para Acesso a Servi�os */
    @Test
    public void getAcessos(){
    	assertEquals(aluno.getAcessoServicos(),AcessoServicosCrudJDBC.getAcessoServicos(0));
    }
    
    @Test
    public void alterarAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.alterar(aluno.getAcessoServicos()));
    }
    
    @Test
    public void excluirAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.excluir(aluno.getAcessoServicos()));
    }
    
    @Test
    public void salvarAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.salvar(aluno.getAcessoServicos()));
    }
    
    /*Testes para Acompanhamento Escolar */
    @Test
    public void getAcompanhamento(){
        assertEquals(aluno.getAcompanhamentoEscolar(),AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(0));
    }
    
    @Test
    public void alterarAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.alterar(aluno.getAcompanhamentoEscolar()));
    }
    
	@Test
    public void excluirAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.excluir(aluno.getAcompanhamentoEscolar()));
    }
    
    @Test
    public void salvarAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.salvar(aluno.getAcompanhamentoEscolar()));
    }
    
    /* Testes para Composi��o Familiar */
    @Test
    public void getComposicao(){
        assertEquals(aluno.getComposicaoFamiliar(),ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(0));
    }
    
    @Test
    public void alterarComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.alterar(aluno.getComposicaoFamiliar()));
    }
    
    @Test
    public void excluirComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.excluir(aluno.getComposicaoFamiliar()));
    }
    
    @Test
    public void salvarComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.salvar(aluno.getComposicaoFamiliar()));
    }
    
    /* Testes para Condicoes de Moradia */
    @Test
    public void getCondicoes(){
        assertEquals(aluno.getCondicoesMoradia(),CondicoesMoradiaCrudJDBC.getCondicoesMoradia(0));
    }
    
    @Test
    public void alterarCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.alterar(aluno.getCondicoesMoradia()));
    }
    
    @Test
    public void excluirCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.excluir(aluno.getCondicoesMoradia()));
    }
    
    @Test
    public void salvarCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.salvar(aluno.getCondicoesMoradia()));
    }
    
    /*Testes para Dados Pessoais */
    @Test
    public void getDadosPessoais(){
        assertEquals(aluno.getDadosPessoais(),DadosPessoaisCrudJDBC.getDadosPessoais(0));
    }
    
    @Test
    public void alterarDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.alterar(aluno.getDadosPessoais()));
    }
    
    @Test
    public void excluirDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.excluir(aluno.getDadosPessoais()));
    }
    
    @Test
    public void salvarDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.salvar(aluno.getDadosPessoais()));
    }

    /*Testes para Despesas */
    @Test
    public void getDespesas(){
        assertEquals(aluno.getDespesas(),DespesasCrudJDBC.getDespesas(0));
    }
    
    @Test
    public void alterarDespesas(){
        assertEquals(true,DespesasCrudJDBC.alterar(aluno.getDespesas()));
    }
    
    @Test
    public void excluirDespesas(){
        assertEquals(true,DespesasCrudJDBC.excluir(aluno.getDespesas()));
    }
    /*
    @Test
    public static void salvarDespesas(){
        assertEquals(true,DespesasCrudJDBC.salvar(aluno.getDespesas()));
    }
    */
    /* Testes para Informa��es Medicas */
    @Test
    public void getInfoMedicas(){
        assertEquals(aluno.getInfoMedicas(),EnderecoCrudJDBC.getEndereco(0));
    }
    
    @Test
    public void alterarInfoMedicas(){
        assertEquals(true,InfoMedicasCrudJDBC.alterar(aluno.getInfoMedicas()));
    }
    
    @Test
    public void excluirInfoMedicas(){
    	assertEquals(true,InfoMedicasCrudJDBC.excluir(aluno.getInfoMedicas()));
    }
    
    @Test
    public void salvarInfoMedicas(){
    	assertEquals(true,InfoMedicasCrudJDBC.salvar(aluno.getInfoMedicas()));
    }
    
    /* Testes para Informa��es de Transporte */
    @Test
    public void getInfoTransporte(){
        assertEquals(aluno.getInfoTransporte(),InfoTransporteCrudJDBC.getInfoTransporte(0));
    }
    
    @Test
    public void alterarInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.alterar(aluno.getInfoTransporte()));
    }
    
    @Test
    public void excluirInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.excluir(aluno.getInfoTransporte()));
    }
    
    @Test
    public void salvarInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.salvar(aluno.getInfoTransporte()));
    }
    
    /* Testes para endere�o */
    @Test
    public void getProgramasBeneficios(){
        assertEquals(aluno.getProgramasBeneficios(),ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(0));
    }
    
    @Test
    public void alterarProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.alterar(aluno.getProgramasBeneficios()));
    }
    
    @Test
    public void excluirProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.excluir(aluno.getProgramasBeneficios()));
    }
    
    @Test
    public void salvarProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.salvar(aluno.getProgramasBeneficios()));
    }
    
    /* Testes para p�blico priorit�rio */
    @Test
    public void getPublicoPrioritario(){
        assertEquals(aluno.getPublicoPrioritario(),PublicoPrioritarioCrudJDBC.getPublicoPrioritario(0));
    }
    
    @Test
    public void alterarPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.alterar(aluno.getPublicoPrioritario()));
    }
    
    @Test
    public void excluirPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.excluir(aluno.getPublicoPrioritario()));
    }
    
    @Test
    public void salvarPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.salvar(aluno.getPublicoPrioritario()));
    }
    /* Testes para endereco */
    @Test
    public void getEndereco(){
        assertEquals(aluno.getEndereco(),EnderecoCrudJDBC.getEndereco(0));
    }
    
    @Test
    public void alterarEndereco(){
        assertEquals(true,EnderecoCrudJDBC.alterar(aluno.getEndereco()));
    }
    
    @Test
    public void excluirEndereco(){
        assertEquals(true,EnderecoCrudJDBC.excluir(aluno.getEndereco()));
    }
    
    @Test
    public void salvarEndereco(){
        assertEquals(true,EnderecoCrudJDBC.salvar(aluno.getEndereco()));
    }
    /*Testes para Formul�rio de Acompnhamento Psicossocial*/
    @Test
    public void getAluno(){
        assertEquals(aluno,AlunoCrudJDBC.getAluno(0));
    }
    /*
    @Test
    public void alterarAluno(){
        assertEquals(true,AlunoCrudJDBC.alterar(aluno));
    }
    */
    @Test
    public void excluirAluno(){
        assertEquals(true,AlunoCrudJDBC.excluir(aluno));
    }
    
    @Test
    public void salvarAluno(){
        assertEquals(true,AlunoCrudJDBC.salvar(aluno));
    }
    /*Testes para solicita��o de acolhimento*/
    @Test
    public void getSituacaoAcolhimento(){
        assertEquals(situacaoAcolhimento,SituacaoAcolhimentoCrudJDBC.getSituacaoAcolhimento(0));
    }
    
    @Test
    public void alterarSituacaoAcolhimento(){
        assertEquals(true,SituacaoAcolhimentoCrudJDBC.alterar(situacaoAcolhimento));
    }
    
    @Test
    public void excluirSituacaoAcolhimento(){
        assertEquals(true,SituacaoAcolhimentoCrudJDBC.excluir(situacaoAcolhimento));
    }
    
    @Test
    public void salvarSituacaoAcolhimento(){
        assertEquals(true,SituacaoAcolhimentoCrudJDBC.salvar(situacaoAcolhimento));
    }
}
