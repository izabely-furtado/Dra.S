package teste;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import teste.Especie;
import teste.EspecieCrudJDBC;

@ManagedBean(name = "especieBean")
@SessionScoped
public class EspecieBean {
	private List<Especie> lista;
	private Especie especie = new Especie();
	EspecieCrudJDBC objUsuarioCrudJDBC = new EspecieCrudJDBC();

	public List<Especie> getLista() {
		return lista;
	}

	public Especie getEspecie() {
		return especie;
	}

	public void setEspecie(Especie especie) {
		this.especie = especie;
	}

	public void setLista(List<Especie> lista) {
		this.lista = lista;
	}

	public String novo() {
		especie.setIdEspecie(433);
		especie.setDescricao("");
		especie.setEdita(false);
		return "especie";
	}

	public String excluirRegistro(Especie u){
		EspecieCrudJDBC objUsuarioCrudJDBC = new EspecieCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		//salva o usuário
		return u.getDescricao();
	}
	
	public String alterarRegistro(Especie u){
		u.setEdita(true);
		return null;
	}
	
	public String salvarRegistro(){
		for (Especie usu : lista){
			if(usu.getEdita()){
				EspecieCrudJDBC objUsuarioCrudJDBC = new EspecieCrudJDBC();
				objUsuarioCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objUsuarioCrudJDBC.listar();
		return null;
	}
	
	public String inserir() {
		/*
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.especie.getSenha().equalsIgnoreCase(this.especie.getConfirmaSenha())) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha confirmada incorretamente", ""));
			return "usuario";
		}
		*/
		EspecieCrudJDBC objUsuarioCrudJDBC = new EspecieCrudJDBC();
		objUsuarioCrudJDBC.salvar(this.especie);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		EspecieCrudJDBC objUsuarioCrudJDBC = new EspecieCrudJDBC();
		lista = objUsuarioCrudJDBC.listar();
		return "listagem";
	}

}
