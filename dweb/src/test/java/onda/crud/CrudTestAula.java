package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;

import main.java.cdp.classesAnemicas.Aula;
import main.java.cgd.crudjdbc.AulaCrudJDBC;

public class CrudTestAula {
	private Aula aula;

	public CrudTestAula() {
		aula = new Aula();
		aula.setId(0);
		aula.setConteudo("Teste");
		aula.setData(null);
		aula.setId(0);
		aula.setHorario(null);
		aula.setPresentes(null);
		aula.setTipo("Teste");
        
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

    @Test
    public void getAula(){
        assertEquals((new CrudTestAula()).aula,AulaCrudJDBC.getAula(0));
    }
    
    @Test
    public void alterarAula(){
        assertEquals(true,AulaCrudJDBC.alterar((new CrudTestAula()).aula));
    }
    
    @Test
    public void excluirAula(){
        assertEquals(true,AulaCrudJDBC.excluir((new CrudTestAula()).aula));
    }
    
    @Test
    public void salvarAula(){
        assertEquals(true,AulaCrudJDBC.salvar((new CrudTestAula()).aula));
    }
    

}
