package main.test.java.onda;

import java.util.ArrayList;

import main.java.cdp.classesAnemicas.*;
import main.java.cgt.backingbean.AcessoServicosBean;
import main.java.cgt.backingbean.AcompanhamentoEscolarBean;
import main.java.cgt.backingbean.AulaBean;
import main.java.cgt.backingbean.ComposicaoFamiliarBean;
import main.java.cgt.backingbean.CondicoesMoradiaBean;
import main.java.cgt.backingbean.DadosAcessoBean;
import main.java.cgt.backingbean.DadosPessoaisBean;
import main.java.cgt.backingbean.DespesasBean;
import main.java.cgt.backingbean.EnderecoBean;
import main.java.cgt.backingbean.FAPBean;
import main.java.cgt.backingbean.InfoMedicasBean;
import main.java.cgt.backingbean.InfoTransporteBean;
import main.java.cgt.backingbean.ProgramasBeneficiosBean;
import main.java.cgt.backingbean.PublicoPrioritarioBean;
import main.java.cgt.backingbean.TermoDesligamentoBean;
import main.java.cgt.backingbean.TurmaBean;

public class ConstrutorParaTesteBean {
	
	
	public static TermoDesligamentoBean criaTermoDesligamento(){
		TermoDesligamentoBean termoDesligamentoBean = new TermoDesligamentoBean();
		termoDesligamentoBean.setTermoDesligamento(ConstrutorParaTeste.criaTermoDesligamento());
		//termoDesligamentoBean.setLista(new ArrayList<TermoDesligamento>());
		
		return termoDesligamentoBean;
	}
	
}
