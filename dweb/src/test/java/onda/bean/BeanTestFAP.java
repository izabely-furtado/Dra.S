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
import test.java.onda.ConstrutorParaTeste;

public class BeanTestFAP {

	private FormularioAcompanhamentoPsicossocial fap;
	private SituacaoAcolhimento situacaoAcolhimento;
	private FAPBean fapBean;
	
	

	public BeanTestFAP(){
		/* Criando das partes do formulário de Acompanhamento Psicossocial para testar*/
		situacaoAcolhimento = ConstrutorParaTeste.criaSituacaoAcolhimento();
        
        /* criação do fap*/
        fap = ConstrutorParaTeste.criaFAP();
		
		fapBean = new FAPBean();
		fapBean.setFormularioAcompanhamentoPsicossocial(fap);
		fapBean.setLista(new ArrayList<FormularioAcompanhamentoPsicossocial>());
	}
	/* Testes do Bean do Fomulário de Acompanhamento Psicossocial */
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
	/* Testes do Bean de Acesso a Serviços */
	@Test
    public void alterarAcesso(){
        assertEquals("alterar",fapBean.alterarRegistro(fap));
    }
	
	@Test
    public void excluirAcesso(){
        assertEquals("excluir",fapBean.excluirRegistro(fap));
    }
	
	@Test
    public void getAcesso(){
        assertEquals(fap,fapBean.getFap());
    }
	
	@Test
    public void getListaAcesso(){
        assertEquals(new ArrayList<FormularioAcompanhamentoPsicossocial>(),fapBean.getLista());
    }
	
	@Test
    public void inserirAcesso(){
        assertEquals("sucesso",fapBean.inserir());
    }
	
	@Test
    public void novaAcesso(){
        assertEquals("fap",fapBean.novo());
    }
	
	@Test
    public void salvarAcesso(){
        assertEquals("salvar",fapBean.salvarRegistro());
    }
	
	@Test
    public void verListaAcesso(){
        assertEquals("listagem",fapBean.verLista());
    }

}
