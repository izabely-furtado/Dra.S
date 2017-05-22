package Trabalho_20171.trab.bean;

import static org.junit.Assert.*;


import org.junit.Test;

import Trabalho_20171.trab.ConstrutorParaTeste;
import cdp.classesAnemicas.*;
import cgt.backingbean.*;

public class BeanTestRematricula {
	private Rematricula rematricula;
	private RematriculaBean rematriculaBean;

	public BeanTestRematricula(){
		rematricula = ConstrutorParaTeste.criaRematricula();
		
		rematriculaBean = new RematriculaBean();
		rematriculaBean.setRematricula(rematricula);
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	
	
	@Test
    public void getRematricula(){
        assertEquals(rematricula,rematriculaBean.getRematricula());
    }
	
	
	@Test
    public void novoRematricula(){
        assertEquals("rematricula",rematriculaBean.novo());
    }
	/*
	@Test
    public void excluirRematricula(){
        assertEquals("excluir",rematriculaBean.excluirRegistro(rematricula));
    }
	
	@Test
    public void alterarRematricula(){
        assertEquals("alterar",rematriculaBean.alterarRegistro(rematricula));
    }
	
	@Test
    public void getListaRematricula(){
        assertEquals(new ArrayList<Rematricula>(),rematriculaBean.getLista());
    }
	
	@Test
    public void inserirRematricula(){
        assertEquals("sucesso",rematriculaBean.inserir());
    }
	
	@Test
    public void salvarRematricula(){
        assertEquals("salvar",rematriculaBean.salvarRegistro());
    }
	
	@Test
    public void verListaRematricula(){
        assertEquals("listagem",rematriculaBean.verLista());
    }
    */
}
