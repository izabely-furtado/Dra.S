package test.java.onda.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
import main.java.cgt.backingbean.FAPBean;

public class BeanTestFAP {

	private FormularioAcompanhamentoPsicossocial fap;
	private FAPBean fapBean;
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

	public BeanTestFAP(){
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
		
		fapBean = new FAPBean();
		fapBean.setFormularioAcompanhamentoPsicossocial(fap);
		fapBean.setLista(new ArrayList<FormularioAcompanhamentoPsicossocial>());
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	@Test
    public void alterarFAP(){
        assertEquals("alterar",fapBean.alterarRegistro(fap));
    }
	
	@Test
    public void excluirFAP(){
        assertEquals("excluir",fapBean.excluirRegistro(fap));
    }
	
	@Test
    public void getFAP(){
        assertEquals(fap,fapBean.getFap());
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

}
