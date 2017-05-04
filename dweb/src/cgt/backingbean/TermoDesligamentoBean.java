package cgt.backingbean;


import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cdp.classesAnemicas.TermoDesligamento;
import cgd.crudjdbc.*;

@ManagedBean(name = "termoDesligamentoBean")
@SessionScoped
public class TermoDesligamentoBean {
	private List<TermoDesligamento> lista;
	private TermoDesligamento termoDesligamento = new TermoDesligamento();
	TermoDesligamentoCrudJDBC objTermoCrudJDBC = new TermoDesligamentoCrudJDBC();

	public List<TermoDesligamento> getLista() {
		return lista;
	}

	public TermoDesligamento getTermoDesligamento() {
		return termoDesligamento;
	}

	public void setTermoDesligamento(TermoDesligamento termoDesligamento) {
		this.termoDesligamento = termoDesligamento;
	}

	public void setLista(List<TermoDesligamento> lista) {
		this.lista = lista;
	}

	public String novo() {
		
		this.termoDesligamento.setId(-1);
		this.termoDesligamento.setNomeUsuario(null);
		this.termoDesligamento.setNomeResponsavel(null);
		this.termoDesligamento.setNomeTecResponsavel(null);
		this.termoDesligamento.setMotivo(null);
		this.termoDesligamento.setCpf(null);
		this.termoDesligamento.setEdita(false);
		
		return "termoDesligamento";
	}

	public String excluirRegistro(TermoDesligamento td) {
		TermoDesligamentoCrudJDBC.excluir(td);
		// salva o termo de desligamento
		return td.getId()+"";
	}

	public String alterarRegistro(TermoDesligamento td) {
		td.setEdita(true);
		return null;
	}
	
	public String salvarRegistro() {
		for (TermoDesligamento termoDesligamento : lista) {
			if (termoDesligamento.isEdita()) {
				TermoDesligamentoCrudJDBC.alterar(termoDesligamento);
			}
			termoDesligamento.setEdita(false);
		}
		lista = TermoDesligamentoCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		
		TermoDesligamentoCrudJDBC.salvar(this.termoDesligamento);
		// salva o termo de desligamento
		return "sucesso";
	}

	public String verLista() {
		TermoDesligamentoCrudJDBC.listar();
		return "listagem";
	}
	
	public String getDataAtual(){
		Date d = new Date();
		String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
		return dStr;
	}

}
