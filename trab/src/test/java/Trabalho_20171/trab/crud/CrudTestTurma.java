package Trabalho_20171.trab.crud;

import static org.junit.Assert.*;

import org.junit.Test;

import Trabalho_20171.trab.ConstrutorParaTeste;
import cdp.classesAnemicas.*;
import cgd.crudjdbc.*;


public class CrudTestTurma {
	private Turma turma = ConstrutorParaTeste.criaTurma();
	
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

    @Test
    public void getTurma(){
        assertEquals(turma,TurmaCrudJDBC.getTurma(0));
    }
    
    @Test
    public void alterarTurma(){
        assertEquals(true,TurmaCrudJDBC.alterar(turma));
    }
    
    @Test
    public void excluirTurma(){
        assertEquals(true,TurmaCrudJDBC.excluir(turma));
    }
    
    @Test
    public void salvarTurma(){
        assertEquals(true,TurmaCrudJDBC.salvar(turma));
    }
    

}
