package cgt.backingbean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cdp.classesAnemicas.InfoTransporte;
import cgd.crudjdbc.*;;

@SuppressWarnings("deprecation")
@ManagedBean(name = "infoTransporteBean")
@SessionScoped
public class InfoTransporteBean {
	private List<InfoTransporte> lista;
	private InfoTransporte infoTransporte = new InfoTransporte();
	InfoTransporteCrudJDBC objInfoTransporteCrudJDBC = new InfoTransporteCrudJDBC();

	public List<InfoTransporte> getLista() {
		return lista;
	}

	public InfoTransporte getInfoTransporte() {
		return infoTransporte;
	}

	public void setInfoTransporte(InfoTransporte infoTransporte) {
		this.infoTransporte = infoTransporte;
	}

	public void setLista(List<InfoTransporte> lista) {
		this.lista = lista;
	}

	public String novo() {
		this.infoTransporte.setId(-1);
		this.infoTransporte.setCartao(null);
		this.infoTransporte.setQtransporte(null);
		this.infoTransporte.setTransporte(false);
		this.infoTransporte.setEdita(false);
		return "infoTransporte";
	}

	public String excluirRegistro(InfoTransporte u) {
		InfoTransporteCrudJDBC.excluir(u);
		// salva o usu�rio
		return u.getId()+"";
	}

	public String alterarRegistro(InfoTransporte u) {
		u.setEdita(true);
		return null;
	}

	public String salvarRegistro() {
		for (InfoTransporte usu : lista) {
			if (usu.isEdita()) {
				InfoTransporteCrudJDBC.alterar(usu);
			}
			usu.setEdita(false);
		}
		InfoTransporteCrudJDBC.listar();
		return null;
	}

	public String inserir() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance(); if
		 * (!this.infoTransporte.getSenha().equalsIgnoreCase(this.infoTransporte.
		 * getConfirmaSenha())) { context.addMessage(null, new
		 * FacesMessage(FacesMessage.SEVERITY_ERROR,
		 * "Senha confirmada incorretamente", "")); return "usuario"; }
		 */
	
		InfoTransporteCrudJDBC.salvar(this.infoTransporte);
		// salva o usu�rio
		return "sucesso";
	}

	public String verLista() {
		InfoTransporteCrudJDBC.listar();
		return "listagem";
	}

}
