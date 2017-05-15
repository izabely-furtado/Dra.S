package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;

import main.java.cdp.classesAnemicas.TermoDesligamento;
import main.java.cgd.crudjdbc.TermoDesligamentoCrudJDBC;

public class CrudTestTermoDesligamento {

	private TermoDesligamento termo;

	public CrudTestTermoDesligamento() {
		termo = new TermoDesligamento();
		termo.setCpf("00000000000");
		termo.setId(0);
		termo.setMotivo("Teste");
		termo.setNomeResponsavel("Teste");
		termo.setNomeTecResponsavel("Teste");
		termo.setNomeUsuario("Teste");
		
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

    @Test
    public void getTermoDesligamento(){
        assertEquals((new CrudTestTermoDesligamento()).termo,TermoDesligamentoCrudJDBC.getTermoDesligamento(0));
    }
    
    @Test
    public void alterarTermoDesligamento(){
        assertEquals(true,TermoDesligamentoCrudJDBC.alterar((new CrudTestTermoDesligamento()).termo));
    }
    
    @Test
    public void excluirTermoDesligamento(){
        assertEquals(true,TermoDesligamentoCrudJDBC.excluir((new CrudTestTermoDesligamento()).termo));
    }
    
    @Test
    public void salvarTermoDesligamento(){
        assertEquals(true,TermoDesligamentoCrudJDBC.salvar((new CrudTestTermoDesligamento()).termo));
    }
    

}
