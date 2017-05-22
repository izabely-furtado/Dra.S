package main.java.cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import main.java.cdp.classesAnemicas.Aula;
import main.java.cgd.crudjdbc.*;

@ManagedBean(name = "aulaBean")
@SessionScoped
public class AulaBean {
	private List<Aula> lista;
	private Aula aula = new Aula();
	AulaCrudJDBC objAulaCrudJDBC = new AulaCrudJDBC();

	public List<Aula> getLista() {
		return lista;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public void setLista(List<Aula> lista) {
		this.lista = lista;
	}

	public String novo() {
		
		this.aula.setId(-1);
		this.aula.setTipo(null);
		this.aula.setHorario(null);
		this.aula.setData(null);
		this.aula.setConteudo(null);
		this.aula.setPresentes(null);
		this.aula.setEdita(false);
		
		return "aula";
	}

	public String excluirRegistro(Aula a) {
		AulaCrudJDBC.excluir(a);
		// salva a aula
		return a.getId()+"";
	}

	public String alterarRegistro(Aula a) {
		a.setEdita(true);
		return "alterar";
	}

	public String salvarRegistro() {
		for (Aula aula : lista) {
			if (aula.isEdita()) {
				AulaCrudJDBC.alterar(aula);
			}
			aula.setEdita(false);
		}
		lista = AulaCrudJDBC.listar();
		return "salvar";
	}

	public String inserir() {
		
	
		AulaCrudJDBC.salvar(this.aula);
		// salva a aula
		return "sucesso";
	}

	public String verLista() {
		AulaCrudJDBC.listar();
		return "listagem";
	}

}
