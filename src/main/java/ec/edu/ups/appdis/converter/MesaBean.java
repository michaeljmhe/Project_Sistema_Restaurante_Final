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
import ec.edu.ups.appdis.model.Mesa;
import ec.edu.ups.appdis.util.JsfUtil;
import ec.edu.ups.appdis.util.MesaFacade;

@Named("mesaBean")
@ManagedBean
public class MesaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Mesa newMesa;
	@EJB
	private MesaFacade ejbFacade;
	
	public Mesa getSelected() {
        if (newMesa == null) {
        	newMesa = new Mesa();
        }
        return newMesa;
    }
	
	public MesaBean() {
		
	}


	public MesaFacade getEjbFacade() {
		return ejbFacade;
	}

	public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Mesa getMesas(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    @FacesConverter(forClass = Mesa.class)
    public static class MesasBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MesaBean controller = (MesaBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mesaBean");
            return controller.getMesas(getKey(value));
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
            if (object instanceof Mesa) {
                Mesa o = (Mesa) object;
                return getStringKey(o.getCodigo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Mesa.class.getName());
            }
        }

    }
}

