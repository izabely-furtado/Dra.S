package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;


import main.java.cdp.classesAnemicas.FormularioAcompanhamentoPsicossocial;
import main.java.cdp.classesAnemicas.SituacaoAcolhimento;
import main.java.cgd.crudjdbc.AcessoServicosCrudJDBC;
import main.java.cgd.crudjdbc.AcompanhamentoEscolarCrudJDBC;
import main.java.cgd.crudjdbc.ComposicaoFamiliarCrudJDBC;
import main.java.cgd.crudjdbc.CondicoesMoradiaCrudJDBC;
import main.java.cgd.crudjdbc.DadosPessoaisCrudJDBC;
import main.java.cgd.crudjdbc.DespesasCrudJDBC;
import main.java.cgd.crudjdbc.EnderecoCrudJDBC;
import main.java.cgd.crudjdbc.FAPCrudJDBC;
import main.java.cgd.crudjdbc.InfoMedicasCrudJDBC;
import main.java.cgd.crudjdbc.InfoTransporteCrudJDBC;
import main.java.cgd.crudjdbc.ProgramasBeneficiosCrudJDBC;
import main.java.cgd.crudjdbc.PublicoPrioritarioCrudJDBC;
import main.java.cgd.crudjdbc.SituacaoAcolhimentoCrudJDBC;
import test.java.onda.ConstrutorParaTeste;

public class CrudTestFAP {
	private FormularioAcompanhamentoPsicossocial fap = ConstrutorParaTeste.criaFAP();
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
	/* Testes para Acesso a Serviços */
    @Test
    public void getAcessos(){
    	assertEquals(fap.getAcessoServicos(),AcessoServicosCrudJDBC.getAcessoServicos(0));
    }
    
    @Test
    public void alterarAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.alterar(fap.getAcessoServicos()));
    }
    
    @Test
    public void excluirAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.excluir(fap.getAcessoServicos()));
    }
    
    @Test
    public void salvarAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.salvar(fap.getAcessoServicos()));
    }
    
    /*Testes para Acompanhamento Escolar */
    @Test
    public void getAcompanhamento(){
        assertEquals(fap.getAcompanhamentoEscolar(),AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(0));
    }
    
    @Test
    public void alterarAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.alterar(fap.getAcompanhamentoEscolar()));
    }
    
	@Test
    public void excluirAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.excluir(fap.getAcompanhamentoEscolar()));
    }
    
    @Test
    public void salvarAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.salvar(fap.getAcompanhamentoEscolar()));
    }
    
    /* Testes para Composição Familiar */
    @Test
    public void getComposicao(){
        assertEquals(fap.getComposicaoFamiliar(),ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(0));
    }
    
    @Test
    public void alterarComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.alterar(fap.getComposicaoFamiliar()));
    }
    
    @Test
    public void excluirComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.excluir(fap.getComposicaoFamiliar()));
    }
    
    @Test
    public void salvarComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.salvar(fap.getComposicaoFamiliar()));
    }
    
    /* Testes para Condicoes de Moradia */
    @Test
    public void getCondicoes(){
        assertEquals(fap.getCondicoesMoradia(),CondicoesMoradiaCrudJDBC.getCondicoesMoradia(0));
    }
    
    @Test
    public void alterarCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.alterar(fap.getCondicoesMoradia()));
    }
    
    @Test
    public void excluirCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.excluir(fap.getCondicoesMoradia()));
    }
    
    @Test
    public void salvarCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.salvar(fap.getCondicoesMoradia()));
    }
    
    /*Testes para Dados Pessoais */
    @Test
    public void getDadosPessoais(){
        assertEquals(fap.getDadosPessoais(),DadosPessoaisCrudJDBC.getDadosPessoais(0));
    }
    
    @Test
    public void alterarDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.alterar(fap.getDadosPessoais()));
    }
    
    @Test
    public void excluirDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.excluir(fap.getDadosPessoais()));
    }
    
    @Test
    public void salvarDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.salvar(fap.getDadosPessoais()));
    }

    /*Testes para Despesas */
    @Test
    public void getDespesas(){
        assertEquals(fap.getDespesas(),DespesasCrudJDBC.getDespesas(0));
    }
    
    @Test
    public void alterarDespesas(){
        assertEquals(true,DespesasCrudJDBC.alterar(fap.getDespesas()));
    }
    
    @Test
    public void excluirDespesas(){
        assertEquals(true,DespesasCrudJDBC.excluir(fap.getDespesas()));
    }
    
    @Test
    public void salvarDespesas(){
        assertEquals(true,DespesasCrudJDBC.salvar(fap.getDespesas()));
    }
    
    /* Testes para Informações Medicas */
    @Test
    public void getInfoMedicas(){
        assertEquals(fap.getInfoMedicas(),EnderecoCrudJDBC.getEndereco(0));
    }
    
    @Test
    public void alterarInfoMedicas(){
        assertEquals(true,InfoMedicasCrudJDBC.alterar(fap.getInfoMedicas()));
    }
    
    @Test
    public void excluirInfoMedicas(){
    	assertEquals(true,InfoMedicasCrudJDBC.excluir(fap.getInfoMedicas()));
    }
    
    @Test
    public void salvarInfoMedicas(){
    	assertEquals(true,InfoMedicasCrudJDBC.salvar(fap.getInfoMedicas()));
    }
    
    /* Testes para Informações de Transporte */
    @Test
    public void getInfoTransporte(){
        assertEquals(fap.getInfoTransporte(),InfoTransporteCrudJDBC.getInfoTransporte(0));
    }
    
    @Test
    public void alterarInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.alterar(fap.getInfoTransporte()));
    }
    
    @Test
    public void excluirInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.excluir(fap.getInfoTransporte()));
    }
    
    @Test
    public void salvarInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.salvar(fap.getInfoTransporte()));
    }
    
    /* Testes para endereço */
    @Test
    public void getProgramasBeneficios(){
        assertEquals(fap.getProgramasBeneficios(),ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(0));
    }
    
    @Test
    public void alterarProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.alterar(fap.getProgramasBeneficios()));
    }
    
    @Test
    public void excluirProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.excluir(fap.getProgramasBeneficios()));
    }
    
    @Test
    public void salvarProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.salvar(fap.getProgramasBeneficios()));
    }
    
    /* Testes para público prioritário */
    @Test
    public void getPublicoPrioritario(){
        assertEquals(fap.getPublicoPrioritario(),PublicoPrioritarioCrudJDBC.getPublicoPrioritario(0));
    }
    
    @Test
    public void alterarPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.alterar(fap.getPublicoPrioritario()));
    }
    
    @Test
    public void excluirPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.excluir(fap.getPublicoPrioritario()));
    }
    
    @Test
    public void salvarPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.salvar(fap.getPublicoPrioritario()));
    }
    /* Testes para endereco */
    @Test
    public void getEndereco(){
        assertEquals(fap.getEndereco(),EnderecoCrudJDBC.getEndereco(0));
    }
    
    @Test
    public void alterarEndereco(){
        assertEquals(true,EnderecoCrudJDBC.alterar(fap.getEndereco()));
    }
    
    @Test
    public void excluirEndereco(){
        assertEquals(true,EnderecoCrudJDBC.excluir(fap.getEndereco()));
    }
    
    @Test
    public void salvarEndereco(){
        assertEquals(true,EnderecoCrudJDBC.salvar(fap.getEndereco()));
    }
    /*Testes para Formulário de Acompnhamento Psicossocial*/
    @Test
    public void getFAP(){
        assertEquals(fap,FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(0));
    }
    
    @Test
    public void alterarFAP(){
        assertEquals(true,FAPCrudJDBC.alterar(fap));
    }
    
    @Test
    public void excluirFAP(){
        assertEquals(true,FAPCrudJDBC.excluir(fap));
    }
    
    @Test
    public void salvarFAP(){
        assertEquals(true,FAPCrudJDBC.salvar(fap));
    }
    /*Testes para solicitação de acolhimento*/
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
