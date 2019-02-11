package ec.edu.ups.appdis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import ec.edu.ups.appdis.bussiness.CalificacionBussiness;
import ec.edu.ups.appdis.bussiness.CategoriaBussiness;
import ec.edu.ups.appdis.model.Calificacion;
import ec.edu.ups.appdis.model.Categoria;

@ManagedBean
public class CalificacionB {

	@Inject
	private CalificacionBussiness pBussiness;

	@Inject
	private FacesContext facesContext;

	private Calificacion newCalificacion;
	private List<Calificacion> calificaciones;

	private boolean edit = false;

	@PostConstruct
	public void init() {
		newCalificacion = new Calificacion();
		calificaciones = pBussiness.getCalificaciones();
	}

	public Calificacion getNewCalificacion() {
		return newCalificacion;
	}

	public void setNewCalificacion(Calificacion newCalificacion) {
		this.newCalificacion = newCalificacion;
	}

	public List<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
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
				pBussiness.update(newCalificacion);
			else
				pBussiness.save(newCalificacion);
			System.out.println("registro guardado");
			return "list-categorias-usuario?faces-redirect=true";
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
			return "list-calificaciones?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String editar(Calificacion cal) {
		newCalificacion = cal;
		edit = true;
		return "create-calificacion";
	}
	
	public String listCategorias() {
		try {
			calificaciones = pBussiness.getCalificaciones();
			return "list-calificaciones?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}
	
	public String volverHome() {
		return "Home";
		
	}

}