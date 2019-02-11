package ec.edu.ups.appdis.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussiness.CategoriaBussiness;
import ec.edu.ups.appdis.bussiness.PedidoBussiness;
import ec.edu.ups.appdis.model.Categoria;
import ec.edu.ups.appdis.model.Pedido;
import ec.edu.ups.appdis.model.Producto;
import ec.edu.ups.appdis.util.JsfUtil;
import ec.edu.ups.appdis.util.PedidoFacade;
import ec.edu.ups.appdis.util.ProductosFacade;

@ManagedBean
public class PedidoBean {
	
	@Inject
	private PedidoBussiness pBussiness;
	
	@Inject
	private FacesContext facesContext;
	
	private Pedido newPedido;
	private List<Pedido> pedidos;
	
	private boolean edit = false;
	
	Date fechA;

	@EJB
	private PedidoFacade ejbFacade;
	
	public Pedido getSelected() {
        if (newPedido == null) {
        	newPedido = new Pedido();
        }
        return newPedido;
    }

	@PostConstruct
	public void init() {
		newPedido = new Pedido();
		getFechaActual();
		newPedido.setFecha(fechA);
		pedidos = pBussiness.getPedidos();
	}

	public Pedido getNewPedido() {
		return newPedido;
	}

	public void setNewPedido(Pedido newPedido) {
		this.newPedido = newPedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	public PedidoFacade getEjbFacade() {
		return ejbFacade;
	}

	public String guardar() {
		
		System.out.println(edit);
		System.out.println(newPedido.getFecha() + " nombre: " + newPedido.getCliId());
		
		try {
			if(edit==true)
				pBussiness.update(newPedido);
			else
				pBussiness.save(newPedido);
			System.out.println(newPedido.getCliId() + " nombre: " + newPedido.getEstado());
			System.out.println("registro guardado");
			return "list-pedido?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(
            		FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
            
            
			e.printStackTrace();
		}
		
		return null;
	}

	public String borrar(int id) {
	try {
		System.out.println("registro ID "+ id);
		pBussiness.delete(id);
		System.out.println("registro eliminado");
		return "list-pedido?faces-redirect=true";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FacesMessage m = new FacesMessage(
        		FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
        facesContext.addMessage(null, m);
        
        
		e.printStackTrace();
	}
	
	return null;
}


	public String editar(Pedido ped) {
		newPedido = ped;
		edit = true;
		return "create-pedido";
	}
	
	public PedidoFacade getFacade() {
		return ejbFacade;
	}
	
	public Date getFechaActual() {
	    Date ahora = new Date();
	    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
	    System.out.println("FFFFF "+ formateador.format(ahora));
	    String data = formateador.format(ahora);
	    try {
			fechA = formateador.parse(data);
			 System.out.println("aaaaaaaaaaaaa "+fechA);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return fechA;
	}
	
}
