package ec.edu.ups.appdis.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import ec.edu.ups.appdis.model.Cliente;
import ec.edu.ups.appdis.util.ClientesFacade;
import ec.edu.ups.appdis.util.JsfUtil;

@Named("clientesBean")
@ManagedBean
public class ClientesBean {
	
	
	private Cliente current;
	@EJB
	private ClientesFacade ejbFacade;
	@SuppressWarnings("unused")
	private int selectedItemIndex;
	
	public Cliente getSelected() {
        if (current == null) {
            current = new Cliente();
            selectedItemIndex = -1;
        }
        return current;
    }
	
	public ClientesBean() {
		
	}
	
	public ClientesFacade getEjbFacade() {
		return ejbFacade;
	}
	
	public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }
    
    public Cliente getClientes(String id) {
        return ejbFacade.find(id);
    }
    
    @FacesConverter(forClass = Cliente.class)
    public static class ProductosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ClientesBean controller = (ClientesBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "clientesBean");
            return controller.getClientes(value);
        }

        String getStringKey(String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Cliente) {
                Cliente o = (Cliente) object;
                return getStringKey(o.getCedula());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Cliente.class.getName());
            }
        }

    }

}
