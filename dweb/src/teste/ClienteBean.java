package teste;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import teste.Cliente;
import teste.ClienteCrudJDBC;

@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean {
	private List<Cliente> lista;
	private Cliente cliente = new Cliente();
	ClienteCrudJDBC objClienteCrudJDBC = new ClienteCrudJDBC();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getLista() {
		return lista;
	}

	public void setLista(List<Cliente> lista) {
		this.lista = lista;
	}

	public String novo() {
		cliente.setIdCliente(433);
		cliente.setBairro("");
		cliente.setCep("");
		cliente.setCidade("");
		cliente.setEndereco("");
		cliente.setEstado("");
		cliente.setIdCliente(0);
		cliente.setEdita(false);
		
		return "cliente";
	}

	public String excluirRegistro(Cliente u){
		ClienteCrudJDBC objClienteCrudJDBC = new ClienteCrudJDBC();
		objClienteCrudJDBC.excluir(u);
		//salva o usuário
		return u.getNome();
	}
	
	public String alterarRegistro(Cliente u){
		u.setEdita(true);
		return null;
	}
	
	public String salvarRegistro(){
		for (Cliente usu : lista){
			if(usu.getEdita()){
				ClienteCrudJDBC objClienteCrudJDBC = new ClienteCrudJDBC();
				objClienteCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		lista = objClienteCrudJDBC.listar();
		return null;
	}
	
	public String inserir() {
		/*
		FacesContext context = FacesContext.getCurrentInstance();
		
		if (!this.cliente.getSenha().equalsIgnoreCase(this.cliente.getConfirmaSenha())) {
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha confirmada incorretamente", ""));
			return "usuario";
		}
		*/
		ClienteCrudJDBC objClienteCrudJDBC = new ClienteCrudJDBC();
		objClienteCrudJDBC.salvar(this.cliente);
		// salva o usuário
		return "sucesso";
	}

	public String verLista() {
		ClienteCrudJDBC objClienteCrudJDBC = new ClienteCrudJDBC();
		lista = objClienteCrudJDBC.listar();
		return "listagem";
	}

}
