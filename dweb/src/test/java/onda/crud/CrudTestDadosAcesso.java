package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;

import main.java.cdp.classesAnemicas.DadosAcesso;
import main.java.cgd.crudjdbc.DadosAcessoCrudJDBC;

public class CrudTestDadosAcesso {
	
	private DadosAcesso dadosAcesso;

	public CrudTestDadosAcesso() {
		dadosAcesso = new DadosAcesso();
		dadosAcesso.setId(0);
		dadosAcesso.setEmail("teste@teste.com");
		dadosAcesso.setLembrar("Teste");
		dadosAcesso.setLogin("Teste");
		dadosAcesso.setSenha("teste");
        
	}
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	

    @Test
    public void getDados(){
        assertEquals((new CrudTestDadosAcesso()).dadosAcesso,DadosAcessoCrudJDBC.getDadosAcesso(0));
    }
    
    @Test
    public void alterarDados(){
        assertEquals(true,DadosAcessoCrudJDBC.alterar((new CrudTestDadosAcesso()).dadosAcesso));
    }
    
    @Test
    public void excluirDados(){
        assertEquals(true,DadosAcessoCrudJDBC.excluir((new CrudTestDadosAcesso()).dadosAcesso));
    }
    
    @Test
    public void salvarDados(){
        assertEquals(true,DadosAcessoCrudJDBC.salvar((new CrudTestDadosAcesso()).dadosAcesso));
    }
    

}
