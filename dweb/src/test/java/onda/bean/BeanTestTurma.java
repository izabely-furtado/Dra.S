package test.java.onda.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.cdp.classesAnemicas.Turma;
import main.java.cgt.backingbean.TurmaBean;

public class BeanTestTurma {
	
	private Turma turma;
	private TurmaBean turmaBean;

	public BeanTestTurma(){
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
		
		turmaBean = new TurmaBean();
		turmaBean.setTurma(turma);
		turmaBean.setLista(new ArrayList<Turma>());
	}
/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	@Test
    public void alterarTurma(){
        assertEquals("alterar",turmaBean.alterarRegistro(turma));
    }
	
	@Test
    public void excluirTurma(){
        assertEquals("excluir",turmaBean.excluirRegistro(turma));
    }
	
	@Test
    public void getTurma(){
        assertEquals(turma,turmaBean.getTurma());
    }
	
	@Test
    public void getListaTurma(){
        assertEquals(new ArrayList<Turma>(),turmaBean.getLista());
    }
	
	@Test
    public void inserirTurma(){
        assertEquals("sucesso",turmaBean.inserir());
    }
	
	@Test
    public void novaTurma(){
        assertEquals("turma",turmaBean.novo());
    }
	
	@Test
    public void salvarTurma(){
        assertEquals("salvar",turmaBean.salvarRegistro());
    }
	
	@Test
    public void verListaTurma(){
        assertEquals("listagem",turmaBean.verLista());
    }

}
