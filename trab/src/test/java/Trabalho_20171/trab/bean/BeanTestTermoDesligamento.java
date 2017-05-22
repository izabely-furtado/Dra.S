package Trabalho_20171.trab.bean;

import static org.junit.Assert.*;

import org.junit.Test;

import Trabalho_20171.trab.ConstrutorParaTeste;
import cdp.classesAnemicas.*;
import cgt.backingbean.*;


public class BeanTestTermoDesligamento {
	private TermoDesligamento termo;
	private TermoDesligamentoBean termoBean;

	public BeanTestTermoDesligamento(){
		termo = ConstrutorParaTeste.criaTermoDesligamento();
		
		termoBean = new TermoDesligamentoBean();
		termoBean.setTermoDesligamento(termo);
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	
	
	@Test
    public void getTermoDesligamento(){
        assertEquals(termo,termoBean.getTermoDesligamento());
    }
	
	
	
	/*
	@Test
    public void novoTermoDesligamento(){
        assertEquals("termoDesligamento",termoBean.novo());
    }
	@Test
    public void excluirTermoDesligamento(){
        assertEquals("excluir",termoBean.excluirRegistro(termo));
    }
	
	@Test
    public void alterarTermoDesligamento(){
        assertEquals("alterar",termoBean.alterarRegistro(termo));
    }
	
	@Test
    public void getListaTermoDesligamento(){
        assertEquals(new ArrayList<TermoDesligamento>(),termoBean.getLista());
    }
	
	@Test
    public void inserirTermoDesligamento(){
        assertEquals("sucesso",termoBean.inserir());
    }
	
	@Test
    public void salvarTermoDesligamento(){
        assertEquals("salvar",termoBean.salvarRegistro());
    }
	
	@Test
    public void verListaTermoDesligamento(){
        assertEquals("listagem",termoBean.verLista());
    }
    */
}
