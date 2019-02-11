package ec.edu.ups.appdis.converter;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import ec.edu.ups.appdis.bussiness.PedidoBussiness;
import ec.edu.ups.appdis.bussiness.ProductoBussiness;
import ec.edu.ups.appdis.model.Pedido;
import ec.edu.ups.appdis.model.Producto;
import ec.edu.ups.appdis.util.JsfUtil;
import ec.edu.ups.appdis.util.ProductosFacade;

@Named("productosBean")
@ManagedBean
public class ProductosBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Producto newProducto;	
	@EJB
	private ProductosFacade ejbFacade;
	
	public Producto getSelected() {
        if (newProducto == null) {
            newProducto = new Producto();
        }
        return newProducto;
    }
	public ProductosBean() {	
	}
	
	public ProductosFacade getEjbFacade() {
		return ejbFacade;
	}
	
	public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Producto getProductos(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    @FacesConverter(forClass = Producto.class)
    public static class ProductosBeanConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductosBean controller = (ProductosBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productosBean");
            System.out.println(controller.getProductos(getKey(value)));
            return controller.getProductos(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            System.out.println(value + " " + Integer.parseInt(value));
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
            if (object == null || (object instanceof String && ((String) object).length() == 0)) {
                return null;
            }
            if (object instanceof Producto) {
                Producto o = (Producto) object;
                return getStringKey(o.getCodigo());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Producto.class.getName());
            }
        }

    }
}

