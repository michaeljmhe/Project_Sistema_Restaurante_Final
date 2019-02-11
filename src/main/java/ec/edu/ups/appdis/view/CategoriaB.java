package ec.edu.ups.appdis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussiness.CategoriaBussiness;
import ec.edu.ups.appdis.model.Categoria;

@ManagedBean
public class CategoriaB {

	@Inject
	private CategoriaBussiness pBussiness;

	@Inject
	private FacesContext facesContext;

	private Categoria newCategoria;
	private List<Categoria> categorias;

	private boolean edit = false;

	@PostConstruct
	public void init() {
		newCategoria = new Categoria();
		categorias = pBussiness.getCategorias();
	}

	public Categoria getNewCategoria() {
		return newCategoria;
	}

	public void setNewCategoria(Categoria newPersona) {
		this.newCategoria = newPersona;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> personas) {
		this.categorias = personas;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String guardar() {

		System.out.println(edit);

		try {
			if (edit == true)
				pBussiness.update(newCategoria);
			else
				pBussiness.save(newCategoria);
			System.out.println("registro guardado");
			return "list-categorias?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String borrar(int id) {
		try {
			pBussiness.delete(id);
			System.out.println("registro eliminado");
			return "list-categorias?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String editar(Categoria per) {
		newCategoria = per;
		edit = true;
		return "create-categoria";
	}
	
	public String listCategorias() {
		try {
			categorias = pBussiness.getCategorias();
			return "list-categorias?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

}