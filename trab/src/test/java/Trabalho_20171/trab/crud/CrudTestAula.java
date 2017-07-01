package Trabalho_20171.trab.crud;

import static org.junit.Assert.*;

import org.junit.Test;

import Trabalho_20171.trab.ConstrutorParaTeste;
import cdp.classesAnemicas.*;
import cgd.crudjdbc.*;

public class CrudTestAula {
	private Aula aula = ConstrutorParaTeste.criaAula();

	
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

    @Test
    public void getAula(){
        assertEquals(aula,AulaCrudJDBC.getAula(0));
    }
    
    @Test
    public void alterarAula(){
        assertEquals(true,AulaCrudJDBC.alterar(aula));
    }
    
    @Test
    public void excluirAula(){
        assertEquals(true,AulaCrudJDBC.excluir(aula));
    }
    
    @Test
    public void salvarAula(){
        assertEquals(true,AulaCrudJDBC.salvar(aula));
    }
    

}
