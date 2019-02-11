package ec.edu.ups.appdis.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.dao.LoginDAO;
import ec.edu.ups.appdis.model.Cliente;
import ec.edu.ups.appdis.model.Login;
import ec.edu.ups.appdis.model.Usuario;
@Stateless
public class LoginBussiness {

	
	@Inject
	private LoginDAO dao;
	
	public void save(Login login) throws Exception {
		Login aux = dao.read(login.getUsuario());
		if(aux!=null)
			throw new Exception("Cliente ya registrada");
		else
			dao.insert(login);
	}
	
	public boolean getUser(String user, String pass) {
		
		boolean aux = dao.login(user, pass);
		
		System.out.println("LLEEEEEEEEEEEEE000000! "+ aux);
		
		return aux;
	}
	
	public List<Login> getUsuariosLogin(String user, String clavee){
		return dao.getUsuariosLogin(user, clavee);
	}

}
