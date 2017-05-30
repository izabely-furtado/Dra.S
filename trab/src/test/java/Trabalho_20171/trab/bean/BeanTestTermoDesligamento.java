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
	*/
}
