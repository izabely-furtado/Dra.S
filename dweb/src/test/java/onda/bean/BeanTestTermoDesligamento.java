package test.java.onda.bean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.cdp.classesAnemicas.TermoDesligamento;
import main.java.cgt.backingbean.TermoDesligamentoBean;
import test.java.onda.ConstrutorParaTeste;

public class BeanTestTermoDesligamento {
	private TermoDesligamento termo;
	private TermoDesligamentoBean termoBean;

	public BeanTestTermoDesligamento(){
		termo = ConstrutorParaTeste.criaTermoDesligamento();
		
		termoBean = new TermoDesligamentoBean();
		termoBean.setTermoDesligamento(termo);
		termoBean.setLista(new ArrayList<TermoDesligamento>());
	}
	/*
	@Test
	public void test() {
		fail("Not yet implemented");
	}
*/
	@Test
    public void alterarTermoDesligamento(){
        assertEquals("alterar",termoBean.alterarRegistro(termo));
    }
	
	@Test
    public void excluirTermoDesligamento(){
        assertEquals("excluir",termoBean.excluirRegistro(termo));
    }
	
	@Test
    public void getTermoDesligamento(){
        assertEquals(termo,termoBean.getTermoDesligamento());
    }
	
	@Test
    public void getListaTermoDesligamento(){
        assertEquals(new ArrayList<TermoDesligamento>(),termoBean.getLista());
    }
	
	@Test
    public void inserirTermoDesligamento(){
        assertEquals("sucesso",termoBean.inserir());
    }
	
	@Test
    public void novaTermoDesligamento(){
        assertEquals("termoDesligamento",termoBean.novo());
    }
	
	@Test
    public void salvarTermoDesligamento(){
        assertEquals("salvar",termoBean.salvarRegistro());
    }
	
	@Test
    public void verListaTermoDesligamento(){
        assertEquals("listagem",termoBean.verLista());
    }
    
}
