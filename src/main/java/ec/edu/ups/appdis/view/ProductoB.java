package ec.edu.ups.appdis.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussiness.ProductoBussiness;
import ec.edu.ups.appdis.model.MostrarProductos;
import ec.edu.ups.appdis.model.Producto;

@ManagedBean
@SessionScoped
public class ProductoB {

	@Inject
	private ProductoBussiness pBussiness;

	@Inject
	private FacesContext facesContext;

	private List<Producto> productos;
	private List<MostrarProductos> productosCategoria;

	private boolean edit = false;

	private Producto newProducto;
	
	private double precio = 0.0;
	
	double precioPro;

	@PostConstruct
	public void init() {
		newProducto = new Producto();
		//productos = pBussiness.getProductos();
		//productosCategoria = pBussiness.listadoProductoPorCategoria(codigo);
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public Producto getNewProducto() {
		return newProducto;
	}

	public void setNewProducto(Producto newProducto) {
		this.newProducto = newProducto;
	}

	public List<MostrarProductos> getProductosCategoria() {
		return productosCategoria;
	}

	public void setProductosCategoria(List<MostrarProductos> productosCategoria) {
		this.productosCategoria = productosCategoria;
	}

	public String guardar() {

		System.out.println(edit);
		//System.out.println(newProducto.getCatId() + " nombre Productos: " + newProducto.getNombre());

		try {
			if (edit == true)
				pBussiness.update(newProducto);
			else
			pBussiness.save(newProducto);
			listProductos();
			System.out.println("registro guardado");
			return "list-productos?faces-redirect=true";
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
			listProductos();
			System.out.println("registro eliminado");
			return "list-productos?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String editar(Producto pro) {
		newProducto = pro;
		edit = true;
		return "create-producto";
	}
	
	public String productosCat(int codigo) {
		try {

			//productosCategoria = pBussiness.listadoProductoPorCategoria(codigo);
			System.out.println("Hola mundooooo");
			productos = pBussiness.getProductosXcategoria(codigo);
			//System.out.println("LISTOOOOOO!!"+ productosCategoria.toString());
			return "list-productosxcategoria?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}
	
	public String listProductosPrecioPedido(int codigo) {
		try {

			//productosCategoria = pBussiness.listadoProductoPorCategoria(codigo);
			System.out.println("Hola preciooo");
			productos = pBussiness.getListadoPrecioProductoPedido(codigo);
			for (Producto producto : productos) {
				precioPro += producto.getPrecio();
				System.out.println("PRECIO PRODUCTO.. "+precioPro);
				newProducto.setPrecio(precioPro);
			}
			
			return "list-productosxcategoria?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}
	
	public String listProductos() {
		try {
			productos = pBussiness.getProductos();
			return "list-productos?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}
	
	public String volverListcategorias() {
		return "list-categorias-usuario";
	}
	
	public String createCalificacionProducto() {
		return "Calificacion";
	}

	public String home() {
		newProducto.setPrecio(precio);
		return "Home?faces-redirect=true";
	}
}
