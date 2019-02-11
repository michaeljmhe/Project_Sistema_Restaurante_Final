package ec.edu.ups.appdis.view;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.edu.ups.appdis.model.Usuario;

@Named
@ViewScoped
public class PlantillaController implements Serializable{

	private static final long serialVersionUID = 1L;

	public void verificarSesion() {
		
		try {
			
			Usuario us= (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
			
			if(us == null) {
				FacesContext.getCurrentInstance().getExternalContext().redirect("errorsesion.xhtml");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}