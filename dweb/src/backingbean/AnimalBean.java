package backingbean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import crudjdbc.*;
import teste.Animal;
import teste.AnimalCrudJDBC;

@ManagedBean(name = "animalBean")
@SessionScoped
public class AnimalBean {
	
	private List<Animal> lista;
	private Animal animal = new Animal();
	AnimalCrudJDBC objAnimalCrudJDBC = new AnimalCrudJDBC();

	public List<Animal> getLista() {
		return lista;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void setLista(List<Animal> lista) {
		this.lista = lista;
	}

	public String novo() {
		animal.setIdAnimal(0);
		animal.setIdade(0);
		animal.setEdita(false);
		animal.setCliente(null);
		animal.setEspecie(null);
		return "animal";
	}

	public String excluirRegistro(Animal u){
		AnimalCrudJDBC objUsuarioCrudJDBC = new AnimalCrudJDBC();
		objUsuarioCrudJDBC.excluir(u);
		//salva o usuário
		return u.getNome();
	}
	
	public String alterarRegistro(Animal u){
		u.setEdita(true);
		return null;
	}
	
	public String salvarRegistro(){
		for (Animal usu : lista){
			if(usu.getEdita()){
				AnimalCrudJDBC objAnimalCrudJDBC = new AnimalCrudJDBC();
				objAnimalCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objAnimalCrudJDBC.listar();
		return null;
	}
	
	public String inserir() {
		/*
		FacesContext context = FacesContext.getCurrentInstance();
		if (!this.animal.getSenha().equalsIgnoreCase(this.animal.getConfirmaSenha())) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha confirmada incorretamente", ""));
			return "usuario";
		}
		*/
		AnimalCrudJDBC objUsuarioCrudJDBC = new AnimalCrudJDBC();
		objUsuarioCrudJDBC.salvar(this.animal);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		AnimalCrudJDBC objUsuarioCrudJDBC = new AnimalCrudJDBC();
		lista = objUsuarioCrudJDBC.listar();
		return "listagem";
	}

}
