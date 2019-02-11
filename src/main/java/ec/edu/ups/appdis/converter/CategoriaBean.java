package ec.edu.ups.appdis.converter;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import ec.edu.ups.appdis.model.Categoria;
import ec.edu.ups.appdis.util.CategoriaFacade;
import ec.edu.ups.appdis.util.JsfUtil;

@Named("categoriaBean")
@ManagedBean
public class CategoriaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Categoria newCategoria;
	@EJB
	private CategoriaFacade ejbFacade;
	
	public Categoria getSelected() {
        if (newCategoria == null) {
        	newCategoria = new Categoria();
        }
        return newCategoria;
    }
	
	public CategoriaBean() {
		
	}


	public CategoriaFacade getEjbFacade() {
		return ejbFacade;
	}

	public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Categoria getCategorias(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    @FacesConverter(forClass = Categoria.class)
    public static class CategoriasBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CategoriaBean controller = (CategoriaBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "categoriaBean");
            return controller.getCategorias(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null || (object instanceof String && ((String) object).length() == 0)){
                return null;
            }
            if (object instanceof Categoria) {
                Categoria o = (Categoria) object;
                return getStringKey(o.getCodigo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Categoria.class.getName());
            }
        }

    }
}

