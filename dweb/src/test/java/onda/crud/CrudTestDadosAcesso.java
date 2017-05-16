package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;

import main.java.cdp.classesAnemicas.DadosAcesso;
import main.java.cgd.crudjdbc.DadosAcessoCrudJDBC;
import test.java.onda.ConstrutorParaTeste;

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
        assertEquals(dadosAcesso,DadosAcessoCrudJDBC.getDadosAcesso(0));
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
