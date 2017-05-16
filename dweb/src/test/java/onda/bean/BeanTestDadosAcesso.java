package test.java.onda.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.cdp.classesAnemicas.DadosAcesso;
import main.java.cgt.backingbean.DadosAcessoBean;
import test.java.onda.ConstrutorParaTeste;

public class BeanTestDadosAcesso {

	private DadosAcesso dadosAcesso;
	private DadosAcessoBean dadosAcessoBean;

	public BeanTestDadosAcesso(){
		dadosAcesso = ConstrutorParaTeste.criaDadosAcesso();
		
		dadosAcessoBean = new DadosAcessoBean();
		dadosAcessoBean.setDadosAcesso(dadosAcesso);
		dadosAcessoBean.setLista(new ArrayList<DadosAcesso>());
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	@Test
    public void alterarDadosAcesso(){
        assertEquals("alterar",dadosAcessoBean.alterarRegistro(dadosAcesso));
    }
	
	@Test
    public void excluirDadosAcesso(){
        assertEquals("excluir",dadosAcessoBean.excluirRegistro(dadosAcesso));
    }
	
	@Test
    public void getDadosAcesso(){
        assertEquals(dadosAcesso,dadosAcessoBean.getDadosAcesso());
    }
	
	@Test
    public void getListaDadosAcesso(){
        assertEquals(new ArrayList<DadosAcesso>(),dadosAcessoBean.getLista());
    }
	
	@Test
    public void inserirDadosAcesso(){
        assertEquals("sucesso",dadosAcessoBean.inserir());
    }
	
	@Test
    public void novaDadosAcesso(){
        assertEquals("dadosAcesso",dadosAcessoBean.novo());
    }
	
	@Test
    public void salvarDadosAcesso(){
        assertEquals("salvar",dadosAcessoBean.salvarRegistro());
    }
	
	@Test
    public void verListaDadosAcesso(){
        assertEquals("listagem",dadosAcessoBean.verLista());
    }
	
}
