package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.appdis.model.Cliente;

public class ClienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Cliente cliente) {
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) {
		em.merge(cliente);
	}
	
	public void remove(String id) {
		em.remove(read(id));
	}
	
	public Cliente read(String cedula) {
		Cliente aux = em.find(Cliente.class, cedula);
		return aux;
	}

	public List<Cliente> getClientes(){
		String jpql = "SELECT c FROM Cliente c";		
		Query query = em.createQuery(jpql, Cliente.class);
		
		List<Cliente> lista = query.getResultList();
		return lista;
	}

}
