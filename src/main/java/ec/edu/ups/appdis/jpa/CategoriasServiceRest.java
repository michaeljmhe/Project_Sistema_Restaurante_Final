package ec.edu.ups.appdis.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import ec.edu.ups.appdis.bussiness.CategoriaBussiness;
import ec.edu.ups.appdis.model.Categoria;

@Path("/categorias")
public class CategoriasServiceRest {
	
	@Inject
	private CategoriaBussiness pBussiness;
	
	@GET
	@Path("/list")
	@Produces("application/json")
		public List<Categoria> getCategorias(){
			return pBussiness.getCategorias();
		}
	
}
