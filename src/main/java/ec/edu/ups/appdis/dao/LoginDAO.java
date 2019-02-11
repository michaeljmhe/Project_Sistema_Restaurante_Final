package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ec.edu.ups.appdis.model.Cliente;
import ec.edu.ups.appdis.model.Login;
import ec.edu.ups.appdis.model.Usuario;

@Stateless
public class LoginDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Login login) {
		em.persist(login);
	}
	
	public Login read(String usuario) {
		Login aux = em.find(Login.class, usuario);
		return aux;
	}
	
	public boolean login(String user, String pass) {
		Query query = em.createQuery("SELECT l FROM Login l WHERE l.usuario = :user AND l.password = :pass", Login.class);
	    query.setParameter("user", user);
	    query.setParameter("pass", pass); 
	    System.out.println("cholaaaaaaaaa "+query);
	    Login c = (Login) query.getSingleResult();
	    
	    if(user.equals(c.getUsuario()) && pass.equals(c.getPassword())) {
	    	return true;
	    	
	    }else if (user != c.getUsuario() && pass  != c.getPassword()) {
	    	return false;
	    	
	    }
		return false;
	   
	}
	
	@SuppressWarnings("unchecked")
	public List<Login> getUsuariosLogin(String user,String clave)
	{
		
		String sql = "SELECT u FROM Login u "
				+ "WHERE usuario = ?1 "
				+" AND password = ?2 ";
	
		Query q = em.createQuery(sql,Login.class);
		q.setParameter(1, user);
		q.setParameter(2, clave);
		List<Login> usuario = q.getResultList();
		return usuario;
	}	
	

	
}
