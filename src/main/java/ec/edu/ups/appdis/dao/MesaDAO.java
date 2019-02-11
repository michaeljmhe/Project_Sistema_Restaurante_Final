package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.model.Cliente;
import ec.edu.ups.appdis.model.Mesa;
import ec.edu.ups.appdis.model.Producto;

@Stateless
public class MesaDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Mesa mesa) {
		em.persist(mesa);
	}
	
	public void update(Mesa mesa) {
		em.merge(mesa);
	}
	
	public void remove(int id) {
		em.remove(read(id));
	}
	
	public Mesa read(int codigo) {
		Mesa aux = em.find(Mesa.class, codigo);
		return aux;
	}

	public List<Mesa> getMesas(){
		String jpql = "SELECT m FROM Mesa m";		
		Query query = em.createQuery(jpql, Mesa.class);
		
		List<Mesa> lista = query.getResultList();
		return lista;
	}
	
}
