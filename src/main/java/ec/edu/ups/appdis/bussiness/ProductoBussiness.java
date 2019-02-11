package ec.edu.ups.appdis.bussiness;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.ups.appdis.dao.ProductoDAO;
import ec.edu.ups.appdis.model.MostrarProductos;
import ec.edu.ups.appdis.model.Producto;

@Stateless
public class ProductoBussiness {

	@Inject
	private ProductoDAO dao;
	
	public void save(Producto producto) throws Exception {
		Producto aux = dao.read(producto.getCodigo());
		if(aux!=null)
			throw new Exception("Producto ya registrada");
		else
			dao.insert(producto);
	}
	
	public List<Producto> getProductos(){
		return dao.getProductos();
	}
	
	public List<MostrarProductos> listadoProductoPorCategoria(int codigo) {
		System.out.println("MOSTARproductos "+ dao.listadoProductoPorCategoria(codigo));
		return dao.listadoProductoPorCategoria(codigo);
	}
	public List<Producto> getProductosXcategoria(int codigo){
		System.out.println("getPorductosCategoria... "+dao.listadoProdPorCat(codigo));
		return dao.listadoProdPorCat(codigo);
	}
	
	public List<Producto> getListadoPrecioProductoPedido(int codigo){
		System.out.println("Porductos Preciooo... "+dao.listadoPrecioProductoPedido(codigo));
		return dao.listadoPrecioProductoPedido(codigo);
	}
	
	public void delete(int id) throws Exception {
		Producto aux = dao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.remove(id);
	}
	
	public void update(Producto producto) throws Exception {
		Producto aux = dao.read(producto.getCodigo());
		System.out.println("AUXXXXX "+ aux);
		if(aux==null)
			throw new Exception("Registro no existeeeee");
		else
			dao.update(producto);
	}
}