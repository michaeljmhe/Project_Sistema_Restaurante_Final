package ec.edu.ups.appdis.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import ec.edu.ups.appdis.bussiness.ProductoBussiness;
import ec.edu.ups.appdis.model.MostrarProductos;
import ec.edu.ups.appdis.model.Producto;

@Path("/productos")
public class ProdctosServiceRest {

	@Inject
	private ProductoBussiness pBussiness;
	
	@GET
	@Path("/buscar")
	@Produces("application/json")
	public List<MostrarProductos> buscar(@QueryParam("codigo") int codigo) {
		return pBussiness.listadoProductoPorCategoria(codigo);
	}
	
	@GET
	@Path("/list")
	@Produces("application/json")
	public List<Producto> listproductos() {
		return pBussiness.getProductos();
	}
}
