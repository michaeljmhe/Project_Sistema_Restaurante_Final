package ec.edu.ups.appdis.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import ec.edu.ups.appdis.bussiness.LoginBussiness;
import ec.edu.ups.appdis.model.Login;

@Path("/login")
public class LoginServiceRest {

	@Inject
	private LoginBussiness lBussiness;
	
	@GET
	@Path("/usuario")
	@Produces("application/json")
	public List<Login> login(@QueryParam("user") String user, @QueryParam("clave") String clave) {
		return lBussiness.getUsuariosLogin(user, clave);
	}
}
