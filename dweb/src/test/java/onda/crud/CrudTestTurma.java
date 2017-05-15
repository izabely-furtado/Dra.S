package test.java.onda.crud;

import static org.junit.Assert.*;


import org.junit.Test;

import main.java.cdp.classesAnemicas.Turma;
import main.java.cgd.crudjdbc.TurmaCrudJDBC;

public class CrudTestTurma {
	private Turma turma;

	public CrudTestTurma(){
		turma = new Turma();
		turma.setAlunos(null);
		turma.setAulas(null);
		turma.setCodigo("Teste");
		turma.setId(0);
		turma.setMaximo(13);
		turma.setNivel(0);
		turma.setSegunda(true);
		turma.setTerca(true);
		turma.setQuarta(true);
		turma.setQuinta(true);
		turma.setSexta(true);
		turma.setTurno("Teste");
		
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/

    @Test
    public void getTurma(){
        assertEquals((new CrudTestTurma()).turma,TurmaCrudJDBC.getTurma(0));
    }
    
    @Test
    public void alterarTurma(){
        assertEquals(true,TurmaCrudJDBC.alterar((new CrudTestTurma()).turma));
    }
    
    @Test
    public void excluirTurma(){
        assertEquals(true,TurmaCrudJDBC.excluir((new CrudTestTurma()).turma));
    }
    
    @Test
    public void salvarTurma(){
        assertEquals(true,TurmaCrudJDBC.salvar((new CrudTestTurma()).turma));
    }
    

}
