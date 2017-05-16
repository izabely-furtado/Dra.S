package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;

import main.java.cdp.classesAnemicas.TermoDesligamento;
import main.java.cgd.crudjdbc.TermoDesligamentoCrudJDBC;
import test.java.onda.ConstrutorParaTeste;

public class CrudTestTermoDesligamento {

	private TermoDesligamento termo = ConstrutorParaTeste.criaTermoDesligamento();
		
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

    @Test
    public void getTermoDesligamento(){
        assertEquals(termo,TermoDesligamentoCrudJDBC.getTermoDesligamento(0));
    }
    
    @Test
    public void alterarTermoDesligamento(){
        assertEquals(true,TermoDesligamentoCrudJDBC.alterar(termo));
    }
    
    @Test
    public void excluirTermoDesligamento(){
        assertEquals(true,TermoDesligamentoCrudJDBC.excluir(termo));
    }
    
    @Test
    public void salvarTermoDesligamento(){
        assertEquals(true,TermoDesligamentoCrudJDBC.salvar(termo));
    }
    

}
