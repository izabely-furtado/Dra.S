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
	
}
