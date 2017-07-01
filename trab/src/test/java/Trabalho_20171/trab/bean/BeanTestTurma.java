package Trabalho_20171.trab.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Trabalho_20171.trab.ConstrutorParaTeste;
import cdp.classesAnemicas.*;
import cgt.backingbean.*;

public class BeanTestTurma {
	
	private Turma turma;
	private TurmaBean turmaBean;

	public BeanTestTurma(){
		turma = ConstrutorParaTeste.criaTurma();
		
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
