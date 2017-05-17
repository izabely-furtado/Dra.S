package test.java.onda.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.cdp.classesAnemicas.*;
import main.java.cgt.backingbean.*;
import test.java.onda.ConstrutorParaTeste;
import test.java.onda.ConstrutorParaTesteBean;

public class BeanTestFAP {

	private FAPBean fapBean = ConstrutorParaTesteBean.criaFAP();
	private AcessoServicosBean acessoBean = ConstrutorParaTesteBean.criaAcesso();
	private AcompanhamentoEscolarBean acompanhamentoBean = ConstrutorParaTesteBean.criaAcompanhamento();
	private ComposicaoFamiliarBean composicaoBean = ConstrutorParaTesteBean.criaComposicao();
	private CondicoesMoradiaBean condicoesBean = ConstrutorParaTesteBean.criaCondicoes();
	private DadosPessoaisBean dadosPessoaisBean = ConstrutorParaTesteBean.criaDadosPessoais();
	private DespesasBean despesasBean = ConstrutorParaTesteBean.criaDespesas();
	private EnderecoBean enderecoBean = ConstrutorParaTesteBean.criaEndereco();
	private InfoMedicasBean infoMedicasBean = ConstrutorParaTesteBean.criaInfoMedicas();
	private InfoTransporteBean infoTransporteBean = ConstrutorParaTesteBean.criaInfoTransporte();
	private ProgramasBeneficiosBean programasBeneficiosBean = ConstrutorParaTesteBean.criaProgramasBeneficios();
	private PublicoPrioritarioBean publicoPrioritarioBean = ConstrutorParaTesteBean.criaPublicoPrioritario();
	
	
	/* Testes do Bean do Fomulário de Acompanhamento Psicossocial */
	@Test
    public void alterarFAP(){
        assertEquals("alterar",fapBean.alterarRegistro(ConstrutorParaTeste.criaFAP()));
    }
	
	@Test
    public void excluirFAP(){
        assertEquals("excluir",fapBean.excluirRegistro(ConstrutorParaTeste.criaFAP()));
    }
	
	@Test
    public void getFAP(){
        assertEquals(ConstrutorParaTeste.criaFAP(),fapBean.getFap());
    }
	
	@Test
    public void getListaFAP(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),fapBean.getLista());
    }
	
	@Test
    public void inserirFAP(){
        assertEquals("sucesso",fapBean.inserir());
    }
	
	@Test
    public void novaFAP(){
        assertEquals("fap",fapBean.novo());
    }
	
	@Test
    public void salvarFAP(){
        assertEquals("salvar",fapBean.salvarRegistro());
    }
	
	@Test
    public void verListaFAP(){
        assertEquals("listagem",fapBean.verLista());
    }
	
	/* Testes do Acesso a serviços*/
	@Test
    public void alterarAcesso(){
        assertEquals("alterar",acessoBean.alterarRegistro(ConstrutorParaTeste.criaAcesso()));
    }
	
	@Test
    public void excluirAcesso(){
        assertEquals("excluir",acessoBean.excluirRegistro(ConstrutorParaTeste.criaAcesso()));
    }
	
	@Test
    public void getAcesso(){
        assertEquals(ConstrutorParaTeste.criaAcesso(),acessoBean.getAcessoServicos());
    }
	
	@Test
    public void getListaAcesso(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),acessoBean.getLista());
    }
	
	@Test
    public void inserirAcesso(){
        assertEquals("sucesso",acessoBean.inserir());
    }
	
	@Test
    public void novaAcesso(){
        assertEquals("fap",acessoBean.novo());
    }
	
	@Test
    public void salvarAcesso(){
        assertEquals("salvar",acessoBean.salvarRegistro());
    }
	
	@Test
    public void verListaAcesso(){
        assertEquals("listagem",acessoBean.verLista());
    }
	/* Testes do Acompanhamento Escolar */
	@Test
    public void alterarAcompanhamento(){
        assertEquals("alterar",acompanhamentoBean.alterarRegistro(ConstrutorParaTeste.criaAcompanhamento()));
    }
	
	@Test
    public void excluirAcompanhamento(){
        assertEquals("excluir",acompanhamentoBean.excluirRegistro(ConstrutorParaTeste.criaAcompanhamento()));
    }
	
	@Test
    public void getAcompanhamento(){
        assertEquals(ConstrutorParaTeste.criaAcompanhamento(),acompanhamentoBean.getAcompanhamentoEscolar());
    }
	
	@Test
    public void getListaAcompanhamento(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),acompanhamentoBean.getLista());
    }
	
	@Test
    public void inserirAcompanhamento(){
        assertEquals("sucesso",acompanhamentoBean.inserir());
    }
	
	@Test
    public void novaAcompanhamento(){
        assertEquals("acompanhamento",acompanhamentoBean.novo());
    }
	
	@Test
    public void salvarAcompanhamento(){
        assertEquals("salvar",acompanhamentoBean.salvarRegistro());
    }
	
	@Test
    public void verListaAcompanhamento(){
        assertEquals("listagem",acompanhamentoBean.verLista());
    }
	/* Testes do Bean do Composição Familiar */
	@Test
    public void alterarComposicao(){
        assertEquals("alterar",composicaoBean.alterarRegistro(ConstrutorParaTeste.criaComposicao()));
    }
	
	@Test
    public void excluirComposicao(){
        assertEquals("excluir",composicaoBean.excluirRegistro(ConstrutorParaTeste.criaComposicao()));
    }
	
	@Test
    public void getComposicao(){
        assertEquals(ConstrutorParaTeste.criaComposicao(),composicaoBean.getComposicaoFamiliar());
    }
	
	@Test
    public void getListaComposicao(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),composicaoBean.getLista());
    }
	
	@Test
    public void inserirComposicao(){
        assertEquals("sucesso",composicaoBean.inserir());
    }
	
	@Test
    public void novaComposicao(){
        assertEquals("composicao",composicaoBean.novo());
    }
	
	@Test
    public void salvarComposicao(){
        assertEquals("salvar",composicaoBean.salvarRegistro());
    }
	
	@Test
    public void verListaComposicao(){
        assertEquals("listagem",composicaoBean.verLista());
    }
	/* Testes do Bean do Condições de Moradia */
	@Test
    public void alterarCondicoes(){
        assertEquals("alterar",condicoesBean.alterarRegistro(ConstrutorParaTeste.criaCondicoes()));
    }
	
	@Test
    public void excluirCondicoes(){
        assertEquals("excluir",condicoesBean.excluirRegistro(ConstrutorParaTeste.criaCondicoes()));
    }
	
	@Test
    public void getCondicoes(){
        assertEquals(ConstrutorParaTeste.criaCondicoes(),condicoesBean.getCondicoesMoradia());
    }
	
	@Test
    public void getListaCondicoes(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),condicoesBean.getLista());
    }
	
	@Test
    public void inserirCondicoes(){
        assertEquals("sucesso",condicoesBean.inserir());
    }
	
	@Test
    public void novaCondicoes(){
        assertEquals("condicoes",condicoesBean.novo());
    }
	
	@Test
    public void salvarCondicoes(){
        assertEquals("salvar",condicoesBean.salvarRegistro());
    }
	
	@Test
    public void verListaCondicoes(){
        assertEquals("listagem",condicoesBean.verLista());
    }
	/* Testes do Bean Dados Pessoais */
	@Test
    public void alterarDadosPessoais(){
        assertEquals("alterar",dadosPessoaisBean.alterarRegistro(ConstrutorParaTeste.criaDadosPessoais()));
    }
	
	@Test
    public void excluirDadosPessoais(){
        assertEquals("excluir",dadosPessoaisBean.excluirRegistro(ConstrutorParaTeste.criaDadosPessoais()));
    }
	
	@Test
    public void getDadosPessoais(){
        assertEquals(ConstrutorParaTeste.criaDadosPessoais(),dadosPessoaisBean.getDadosPessoais());
    }
	
	@Test
    public void getListaDadosPessoais(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),dadosPessoaisBean.getLista());
    }
	
	@Test
    public void inserirDadosPessoais(){
        assertEquals("sucesso",dadosPessoaisBean.inserir());
    }
	
	@Test
    public void novaDadosPessoais(){
        assertEquals("dadosPessoais",dadosPessoaisBean.novo());
    }
	
	@Test
    public void salvarDadosPessoais(){
        assertEquals("salvar",dadosPessoaisBean.salvarRegistro());
    }
	
	@Test
    public void verListaDadosPessoais(){
        assertEquals("listagem",dadosPessoaisBean.verLista());
    }
	/* Testes do Bean de Despesas */
	@Test
    public void alterarDespesas(){
        assertEquals("alterar",despesasBean.alterarRegistro(ConstrutorParaTeste.criaDespesas()));
    }
	
	@Test
    public void excluirDespesas(){
        assertEquals("excluir",despesasBean.excluirRegistro(ConstrutorParaTeste.criaDespesas()));
    }
	
	@Test
    public void getDespesas(){
        assertEquals(ConstrutorParaTeste.criaDespesas(),despesasBean.getDespesas());
    }
	
	@Test
    public void getListaDespesas(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),despesasBean.getLista());
    }
	
	@Test
    public void inserirDespesas(){
        assertEquals("sucesso",despesasBean.inserir());
    }
	
	@Test
    public void novaDespesas(){
        assertEquals("despesas",despesasBean.novo());
    }
	
	@Test
    public void salvarDespesas(){
        assertEquals("salvar",despesasBean.salvarRegistro());
    }
	
	@Test
    public void verListaDespesas(){
        assertEquals("listagem",despesasBean.verLista());
    }
	/* Testes do Bean do Endereço */
	@Test
    public void alterarEndereco(){
        assertEquals("alterar",enderecoBean.alterarRegistro(ConstrutorParaTeste.criaEndereco()));
    }
	
	@Test
    public void excluirEndereco(){
        assertEquals("excluir",enderecoBean.excluirRegistro(ConstrutorParaTeste.criaEndereco()));
    }
	
	@Test
    public void getEndereco(){
        assertEquals(ConstrutorParaTeste.criaEndereco(),enderecoBean.getEndereco());
    }
	
	@Test
    public void getListaEndereco(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),enderecoBean.getLista());
    }
	
	@Test
    public void inserirEndereco(){
        assertEquals("sucesso",enderecoBean.inserir());
    }
	
	@Test
    public void novaEndereco(){
        assertEquals("endereco",enderecoBean.novo());
    }
	
	@Test
    public void salvarEndereco(){
        assertEquals("salvar",enderecoBean.salvarRegistro());
    }
	
	@Test
    public void verListaEndereco(){
        assertEquals("listagem",enderecoBean.verLista());
    }
	/* Testes do Bean do InfoMedicas */
	@Test
    public void alterarInfoMedicas(){
        assertEquals("alterar",infoMedicasBean.alterarRegistro(ConstrutorParaTeste.criaInfoMedicas()));
    }
	
	@Test
    public void excluirInfoMedicas(){
        assertEquals("excluir",infoMedicasBean.excluirRegistro(ConstrutorParaTeste.criaInfoMedicas()));
    }
	
	@Test
    public void getInfoMedicas(){
        assertEquals(ConstrutorParaTeste.criaInfoMedicas(),infoMedicasBean.getInfoMedicas());
    }
	
	@Test
    public void getListaInfoMedicas(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),infoMedicasBean.getLista());
    }
	
	@Test
    public void inserirInfoMedicas(){
        assertEquals("sucesso",infoMedicasBean.inserir());
    }
	
	@Test
    public void novaInfoMedicas(){
        assertEquals("infoMedicas",infoMedicasBean.novo());
    }
	
	@Test
    public void salvarInfoMedicas(){
        assertEquals("salvar",infoMedicasBean.salvarRegistro());
    }
	
	@Test
    public void verListaInfoMedicas(){
        assertEquals("listagem",infoMedicasBean.verLista());
    }
	/* Testes do Bean do InfoTransporte */
	@Test
    public void alterarInfoTransporte(){
        assertEquals("alterar",infoTransporteBean.alterarRegistro(ConstrutorParaTeste.criaInfoTransporte()));
    }
	
	@Test
    public void excluirInfoTransporte(){
        assertEquals("excluir",infoTransporteBean.excluirRegistro(ConstrutorParaTeste.criaInfoTransporte()));
    }
	
	@Test
    public void getInfoTransporte(){
        assertEquals(ConstrutorParaTeste.criaInfoTransporte(),infoTransporteBean.getInfoTransporte());
    }
	
	@Test
    public void getListaInfoTransporte(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),infoTransporteBean.getLista());
    }
	
	@Test
    public void inserirInfoTransporte(){
        assertEquals("sucesso",infoTransporteBean.inserir());
    }
	
	@Test
    public void novaInfoTransporte(){
        assertEquals("infoTransporte",infoTransporteBean.novo());
    }
	
	@Test
    public void salvarInfoTransporte(){
        assertEquals("salvar",infoTransporteBean.salvarRegistro());
    }
	
	@Test
    public void verListaInfoTransporte(){
        assertEquals("listagem",infoTransporteBean.verLista());
    }
	/* Testes do Bean do ProgramasBeneficios */
	@Test
    public void alterarProgramasBeneficios(){
        assertEquals("alterar",programasBeneficiosBean.alterarRegistro(ConstrutorParaTeste.criaProgramasBeneficios()));
    }
	
	@Test
    public void excluirProgramasBeneficios(){
        assertEquals("excluir",programasBeneficiosBean.excluirRegistro(ConstrutorParaTeste.criaProgramasBeneficios()));
    }
	
	@Test
    public void getProgramasBeneficios(){
        assertEquals(ConstrutorParaTeste.criaProgramasBeneficios(),programasBeneficiosBean.getProgramasBeneficios());
    }
	
	@Test
    public void getListaProgramasBeneficios(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),programasBeneficiosBean.getLista());
    }
	
	@Test
    public void inserirProgramasBeneficios(){
        assertEquals("sucesso",programasBeneficiosBean.inserir());
    }
	
	@Test
    public void novaProgramasBeneficios(){
        assertEquals("programasBeneficios",programasBeneficiosBean.novo());
    }
	
	@Test
    public void salvarProgramasBeneficios(){
        assertEquals("salvar",programasBeneficiosBean.salvarRegistro());
    }
	
	@Test
    public void verListaProgramasBeneficios(){
        assertEquals("listagem",programasBeneficiosBean.verLista());
    }
	/* Testes do Bean do PublicoPrioritario */
	@Test
    public void alterarPublicoPrioritario(){
        assertEquals("alterar",publicoPrioritarioBean.alterarRegistro(ConstrutorParaTeste.criaPublicoPrioritario()));
    }
	
	@Test
    public void excluirPublicoPrioritario(){
        assertEquals("excluir",publicoPrioritarioBean.excluirRegistro(ConstrutorParaTeste.criaPublicoPrioritario()));
    }
	
	@Test
    public void getPublicoPrioritario(){
        assertEquals(ConstrutorParaTeste.criaPublicoPrioritario(),publicoPrioritarioBean.getPublicoPrioritario());
    }
	
	@Test
    public void getListaPublicoPrioritario(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),publicoPrioritarioBean.getLista());
    }
	
	@Test
    public void inserirPublicoPrioritario(){
        assertEquals("sucesso",publicoPrioritarioBean.inserir());
    }
	
	@Test
    public void novaPublicoPrioritario(){
        assertEquals("publicoPrioritario",publicoPrioritarioBean.novo());
    }
	
	@Test
    public void salvarPublicoPrioritario(){
        assertEquals("salvar",publicoPrioritarioBean.salvarRegistro());
    }
	
	@Test
    public void verListaPublicoPrioritario(){
        assertEquals("listagem",publicoPrioritarioBean.verLista());
    }

}
