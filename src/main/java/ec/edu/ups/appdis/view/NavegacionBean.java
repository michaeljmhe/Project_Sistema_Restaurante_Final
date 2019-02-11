package ec.edu.ups.appdis.view;

import javax.faces.bean.ManagedBean;

import ec.edu.ups.appdis.model.Pedido;

@ManagedBean
public class NavegacionBean {
	
	
	public String pedioGuardar() {
		return "create-pedido";
	}
	
	public String pedioList() {
		return "lis-pedido";
	}
	
	public String home() {
		return "Home?faces-redirect=true";
	}
	
	public String listProductosXcategoria() {
		return "list-categorias-usuario?faces-redirect=true";
	}
	
	public String listCategoriaPorCategoria() {
		return "list-productosxcategoria?faces-redirect=true";
	}
	
	public String agregarMesa() {
		return "create-mesa?faces-redirect=true";
		
	}
	
	public String listMesa() {
		return "list-mesas?faces-redirect=true";
		
	}
	
	public String agregarCliente() {
		return "create-cliente?faces-redirect=true";
		
	}
	
	public String listClientes() {
		return "list-clientes?faces-redirect=true";
		
	}
	
	public String agregarCategoria() {
		return "create-categoria?faces-redirect=true";
		
	}
	
	public String listCategoria() {
		return "list-categorias?faces-redirect=true";
		
	}
	
	public String agregarProducto() {
		return "create-producto?faces-redirect=true";
		
	}
	
	public String listProducto() {
		return "list-productos?faces-redirect=true";
		
	}	
	
	public String agregarPedido() {
		return "create-pedido?faces-redirect=true";
		
	}
	
	public String listPedido() {
		return "list-pedido?faces-redirect=true";
		
	}	
	
	public String principalAdministrador() {
		return "principal-administrador?faces-redirect=true";
		
	}
}
