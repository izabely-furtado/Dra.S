package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;

import main.java.cdp.classesAnemicas.AcessoServicos;
import main.java.cdp.classesAnemicas.AcompanhamentoEscolar;
import main.java.cdp.classesAnemicas.ComposicaoFamiliar;
import main.java.cdp.classesAnemicas.CondicoesMoradia;
import main.java.cdp.classesAnemicas.DadosPessoais;
import main.java.cdp.classesAnemicas.Despesas;
import main.java.cdp.classesAnemicas.Endereco;
import main.java.cdp.classesAnemicas.FormularioAcompanhamentoPsicossocial;
import main.java.cdp.classesAnemicas.InfoMedicas;
import main.java.cdp.classesAnemicas.InfoTransporte;
import main.java.cdp.classesAnemicas.ProgramasBeneficios;
import main.java.cdp.classesAnemicas.PublicoPrioritario;
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

public class CrudTestFAP {
	private FormularioAcompanhamentoPsicossocial fap;
	private AcessoServicos acesso;
	private AcompanhamentoEscolar acompanhamento;
	private ComposicaoFamiliar composicao;
	private CondicoesMoradia condicoes;
	private DadosPessoais dadosPessoais;
	private Despesas despesas;
	private Endereco endereco;
	private InfoMedicas infoMedicas;
	private InfoTransporte infoTransporte;
	private ProgramasBeneficios programasBeneficios;
	private PublicoPrioritario publicoPrioritario;
	private SituacaoAcolhimento situacaoAcolhimento;
	
	public CrudTestFAP(){
		/* Criando das partes do formulário de Acompanhamento Psicossocial para testar*/
		acesso = new AcessoServicos();
		acesso.setId(0);
		acesso.setPossuiacolhimento(true);
		acesso.setPossuicei(true);
		acesso.setPossuicras(true);
		acesso.setPossuicreas(true);
		acesso.setPossuiescola(true);
		acesso.setPossuiesf(true);
		acesso.setPossuisus(true);
		
		acompanhamento = new AcompanhamentoEscolar();
		acompanhamento.setId(0);
		acompanhamento.setAnos(null);
        acompanhamento.setEscola("Teste");
        acompanhamento.setSeries(null);
        
        composicao = new ComposicaoFamiliar();
        composicao.setId(0);
        composicao.setParentes(null);
        
        condicoes = new CondicoesMoradia();
        condicoes.setId(0);
        condicoes.setCondicao("Teste");
        condicoes.setPossuiagua(true);
        condicoes.setPossuicoleta(true);
        condicoes.setPossuienergia(true);
        condicoes.setPossuiesgoto(true);
        condicoes.setPossuirisco(true);
        condicoes.setQrisco("Teste");
        
        dadosPessoais = new DadosPessoais();
        dadosPessoais.setId(0);
        dadosPessoais.setContato("0000000000");
        dadosPessoais.setDatNasc(null);
        dadosPessoais.setNis("Teste");
        dadosPessoais.setNome("Teste");
        dadosPessoais.setParentesco("Teste");
        dadosPessoais.setResponsavel("Teste");
        dadosPessoais.setSexo(0);
        
        despesas = new Despesas();
        despesas.setId(0);
        despesas.setAgua(13);
        despesas.setAlimentacao(13);
        despesas.setAluguel(13);
        despesas.setGas(13);
        despesas.setLuz(13);
        despesas.setMedicamentos(13);
        despesas.setOutros(13);
        despesas.setRendaTotal(13);
        despesas.setTelefone(13);
        
        endereco = new Endereco();
        endereco.setId(0);
        endereco.setBairro("Teste");
        endereco.setCep("Teste");
        endereco.setCidade("Teste");
        endereco.setEstado("Teste");
        endereco.setNumero(13);
        endereco.setReferencia("Teste");
        endereco.setRua("Teste");
        
        infoMedicas = new InfoMedicas();
        infoMedicas.setId(0);
        infoMedicas.setAlergia(true);
        infoMedicas.setContatoSOS("0000000000");
        infoMedicas.setMedicacao(true);
        infoMedicas.setQalergia("Teste");
        infoMedicas.setQmedicacao("Teste");
        infoMedicas.setTipoSangue("Teste");
        
        infoTransporte = new InfoTransporte();
        infoTransporte.setId(0);
        infoTransporte.setCartão("Teste");
        infoTransporte.setQtransporte("Teste");
        infoTransporte.setTransporte(true);
        
        programasBeneficios = new ProgramasBeneficios();
        programasBeneficios.setBeneficioHabitacional("Teste");
        programasBeneficios.setId(0);
        programasBeneficios.setOutro("Teste");
        programasBeneficios.setPossuiar(true);
        programasBeneficios.setPossuibp(true);
        programasBeneficios.setPossuipbc(true);
        programasBeneficios.setPossuipbf(true);
        programasBeneficios.setPossuipibc(true);
        
        publicoPrioritario = new PublicoPrioritario();
        publicoPrioritario.setAbuso(true);
        publicoPrioritario.setAcolimento(true);
        publicoPrioritario.setDefasagem(true);
        publicoPrioritario.setEca(true);
        publicoPrioritario.setEgressos(true);
        publicoPrioritario.setId(0);
        publicoPrioritario.setIsolamento(true);
        publicoPrioritario.setMse(true);
        publicoPrioritario.setRua(true);
        publicoPrioritario.setTrabInfantil(true);
        publicoPrioritario.setVivencia(true);
        publicoPrioritario.setVulnerabilidade(true);
        
        situacaoAcolhimento = new SituacaoAcolhimento();
        situacaoAcolhimento.setContato("0000000000");
        situacaoAcolhimento.setId(0);
        situacaoAcolhimento.setMotivo("Teste");
        situacaoAcolhimento.setNomeAcolhido("Teste");
        situacaoAcolhimento.setNomeInstituicao("Teste");
        situacaoAcolhimento.setResponsavelInstituicao("Teste");
        
        
        /* criação do fap*/
        fap = new FormularioAcompanhamentoPsicossocial();
        fap.setAcessoServicos(acesso);
        fap.setAcompanhamentoEscolar(acompanhamento);
        fap.setAno(0);
        fap.setComposicaoFamiliar(composicao);
        fap.setCondicoesMoradia(condicoes);
        fap.setDadosPessoais(dadosPessoais);
        fap.setDespesas(despesas);
        fap.setEndereco(endereco);
        fap.setFormaAcesso(0);
        fap.setId(0);
        fap.setInfoMedicas(infoMedicas);
        fap.setInfoTransporte(infoTransporte);
        fap.setProgramasBeneficios(programasBeneficios);
        fap.setPublicoPrioritario(publicoPrioritario);
        fap.setRematricula(null);
        fap.setTipo(0);
        
	}
	
	/* Testes para Acesso a Serviços */
    @Test
    public void getAcessos(){
    	assertEquals((new CrudTestFAP()).acesso,AcessoServicosCrudJDBC.getAcessoServicos(0));
    }
    
    @Test
    public void alterarAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.alterar((new CrudTestFAP()).acesso));
    }
    
    @Test
    public void excluirAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.excluir((new CrudTestFAP()).acesso));
    }
    
    @Test
    public void salvarAcessos(){
        assertEquals(true,AcessoServicosCrudJDBC.salvar((new CrudTestFAP()).acesso));
    }
    
    /*Testes para Acompanhamento Escolar */
    @Test
    public void getAcompanhamento(){
        assertEquals((new CrudTestFAP()).acompanhamento,AcompanhamentoEscolarCrudJDBC.getAcompanhamentoEscolar(0));
    }
    
    @Test
    public void alterarAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.alterar((new CrudTestFAP()).acompanhamento));
    }
    
	@Test
    public void excluirAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.excluir((new CrudTestFAP()).acompanhamento));
    }
    
    @Test
    public void salvarAcompanhamento(){
        assertEquals(true,AcompanhamentoEscolarCrudJDBC.salvar((new CrudTestFAP()).acompanhamento));
    }
    
    /* Testes para Composição Familiar */
    @Test
    public void getComposicao(){
        assertEquals((new CrudTestFAP()).composicao,ComposicaoFamiliarCrudJDBC.getComposicaoFamiliar(0));
    }
    
    @Test
    public void alterarComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.alterar((new CrudTestFAP()).composicao));
    }
    
    @Test
    public void excluirComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.excluir((new CrudTestFAP()).composicao));
    }
    
    @Test
    public void salvarComposicao(){
        assertEquals(true,ComposicaoFamiliarCrudJDBC.salvar((new CrudTestFAP()).composicao));
    }
    
    /* Testes para Condicoes de Moradia */
    @Test
    public void getCondicoes(){
        assertEquals((new CrudTestFAP()).condicoes,CondicoesMoradiaCrudJDBC.getCondicoesMoradia(0));
    }
    
    @Test
    public void alterarCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.alterar((new CrudTestFAP()).condicoes));
    }
    
    @Test
    public void excluirCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.excluir((new CrudTestFAP()).condicoes));
    }
    
    @Test
    public void salvarCondicoes(){
        assertEquals(true,CondicoesMoradiaCrudJDBC.salvar((new CrudTestFAP()).condicoes));
    }
    
    /*Testes para Dados Pessoais */
    @Test
    public void getDadosPessoais(){
        assertEquals((new CrudTestFAP()).dadosPessoais,DadosPessoaisCrudJDBC.getDadosPessoais(0));
    }
    
    @Test
    public void alterarDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.alterar((new CrudTestFAP()).dadosPessoais));
    }
    
    @Test
    public void excluirDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.excluir((new CrudTestFAP()).dadosPessoais));
    }
    
    @Test
    public void salvarDadosPessoais(){
        assertEquals(true,DadosPessoaisCrudJDBC.salvar((new CrudTestFAP()).dadosPessoais));
    }

    /*Testes para Despesas */
    @Test
    public void getDespesas(){
        assertEquals((new CrudTestFAP()).despesas,DespesasCrudJDBC.getDespesas(0));
    }
    
    @Test
    public void alterarDespesas(){
        assertEquals(true,DespesasCrudJDBC.alterar((new CrudTestFAP()).despesas));
    }
    
    @Test
    public void excluirDespesas(){
        assertEquals(true,DespesasCrudJDBC.excluir((new CrudTestFAP()).despesas));
    }
    
    @Test
    public void salvarDespesas(){
        assertEquals(true,DespesasCrudJDBC.salvar((new CrudTestFAP()).despesas));
    }
    
    /* Testes para Informações Medicas */
    @Test
    public void getInfoMedicas(){
        assertEquals((new CrudTestFAP()).infoMedicas,EnderecoCrudJDBC.getEndereco(0));
    }
    
    @Test
    public void alterarInfoMedicas(){
        assertEquals(true,InfoMedicasCrudJDBC.alterar((new CrudTestFAP()).infoMedicas));
    }
    
    @Test
    public void excluirInfoMedicas(){
    	assertEquals(true,InfoMedicasCrudJDBC.excluir((new CrudTestFAP()).infoMedicas));
    }
    
    @Test
    public void salvarInfoMedicas(){
    	assertEquals(true,InfoMedicasCrudJDBC.salvar((new CrudTestFAP()).infoMedicas));
    }
    
    /* Testes para Informações de Transporte */
    @Test
    public void getInfoTransporte(){
        assertEquals((new CrudTestFAP()).infoTransporte,InfoTransporteCrudJDBC.getInfoTransporte(0));
    }
    
    @Test
    public void alterarInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.alterar((new CrudTestFAP()).infoTransporte));
    }
    
    @Test
    public void excluirInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.excluir((new CrudTestFAP()).infoTransporte));
    }
    
    @Test
    public void salvarInfoTransporte(){
        assertEquals(true,InfoTransporteCrudJDBC.salvar((new CrudTestFAP()).infoTransporte));
    }
    
    /* Testes para endereço */
    @Test
    public void getProgramasBeneficios(){
        assertEquals((new CrudTestFAP()).programasBeneficios,ProgramasBeneficiosCrudJDBC.getProgramasBeneficios(0));
    }
    
    @Test
    public void alterarProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.alterar((new CrudTestFAP()).programasBeneficios));
    }
    
    @Test
    public void excluirProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.excluir((new CrudTestFAP()).programasBeneficios));
    }
    
    @Test
    public void salvarProgramasBeneficios(){
        assertEquals(true,ProgramasBeneficiosCrudJDBC.salvar((new CrudTestFAP()).programasBeneficios));
    }
    
    /* Testes para público prioritário */
    @Test
    public void getPublicoPrioritario(){
        assertEquals((new CrudTestFAP()).publicoPrioritario,PublicoPrioritarioCrudJDBC.getPublicoPrioritario(0));
    }
    
    @Test
    public void alterarPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.alterar((new CrudTestFAP()).publicoPrioritario));
    }
    
    @Test
    public void excluirPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.excluir((new CrudTestFAP()).publicoPrioritario));
    }
    
    @Test
    public void salvarPublicoPrioritario(){
        assertEquals(true,PublicoPrioritarioCrudJDBC.salvar((new CrudTestFAP()).publicoPrioritario));
    }
    
    /* Testes para Situação de Acolhimento */
    @Test
    public void getSituacaoAcolhimento(){
        assertEquals((new CrudTestFAP()).situacaoAcolhimento,SituacaoAcolhimentoCrudJDBC.getSituacaoAcolhimento(0));
    }
    
    @Test
    public void alterarSituacaoAcolhimento(){
        assertEquals(true,SituacaoAcolhimentoCrudJDBC.alterar((new CrudTestFAP()).situacaoAcolhimento));
    }
    
    @Test
    public void excluirSituacaoAcolhimento(){
        assertEquals(true,SituacaoAcolhimentoCrudJDBC.excluir((new CrudTestFAP()).situacaoAcolhimento));
    }
    
    @Test
    public void salvarSituacaoAcolhimento(){
        assertEquals(true,SituacaoAcolhimentoCrudJDBC.salvar((new CrudTestFAP()).situacaoAcolhimento));
    }
    /*Testes para Formulário de Acompnhamento Psicossocial*/
    @Test
    public void getFAP(){
        assertEquals((new CrudTestFAP()).fap,FAPCrudJDBC.getFormularioAcompanhamentoPsicossocial(0));
    }
    
    @Test
    public void alterarFAP(){
        assertEquals(true,FAPCrudJDBC.alterar((new CrudTestFAP()).fap));
    }
    
    @Test
    public void excluirFAP(){
        assertEquals(true,FAPCrudJDBC.excluir((new CrudTestFAP()).fap));
    }
    
    @Test
    public void salvarFAP(){
        assertEquals(true,FAPCrudJDBC.salvar((new CrudTestFAP()).fap));
    }
    
}
