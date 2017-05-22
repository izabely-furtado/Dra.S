package test.java.onda.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.cdp.classesAnemicas.Aula;
import main.java.cgt.backingbean.AulaBean;
import test.java.onda.ConstrutorParaTeste;
public class BeanTestAula {
	private Aula aula;
	private AulaBean aulaBean;

	public BeanTestAula(){
		aula = ConstrutorParaTeste.criaAula();
		
		aulaBean = new AulaBean();
		aulaBean.setAula(aula);
		aulaBean.setLista(new ArrayList<Aula>());
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	*/
	@Test
    public void alterarAula(){
        assertEquals("alterar",aulaBean.alterarRegistro(aula));
    }
	
	@Test
    public void excluirAula(){
        assertEquals("excluir",aulaBean.excluirRegistro(aula));
    }
	
	@Test
    public void getAula(){
        assertEquals(aula,aulaBean.getAula());
    }
	
	@Test
    public void getListaAula(){
        assertEquals(new ArrayList<Aula>(),aulaBean.getLista());
    }
	
	@Test
    public void inserirAula(){
        assertEquals("sucesso",aulaBean.inserir());
    }
	
	@Test
    public void novaAula(){
        assertEquals("aula",aulaBean.novo());
    }
	
	@Test
    public void salvarAula(){
        assertEquals("salvar",aulaBean.salvarRegistro());
    }
	
	@Test
    public void verListaAula(){
        assertEquals("listagem",aulaBean.verLista());
    }
	
}
