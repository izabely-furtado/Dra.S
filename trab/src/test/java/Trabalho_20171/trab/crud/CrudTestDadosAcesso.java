package Trabalho_20171.trab.crud;

import static org.junit.Assert.*;

import org.junit.Test;

import Trabalho_20171.trab.ConstrutorParaTeste;
import cdp.classesAnemicas.*;
import cgd.crudjdbc.*;

public class CrudTestDadosAcesso {
	
	private DadosAcesso dadosAcesso = ConstrutorParaTeste.criaDadosAcesso();
     
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

    @Test
    public void getDados(){
        assertEquals(dadosAcesso.getEmail(),DadosAcessoCrudJDBC.getDadosAcesso("Teste2", "Teste2"));
    }
    
    @Test
    public void alterarDados(){
        assertEquals(true,DadosAcessoCrudJDBC.alterar(dadosAcesso));
    }
    
    @Test
    public void excluirDados(){
        assertEquals(true,DadosAcessoCrudJDBC.excluir(dadosAcesso));
    }
    
    @Test
    public void salvarDados(){
        assertEquals(true,DadosAcessoCrudJDBC.salvar(dadosAcesso));
    }
    

}
