package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.appdis.model.Pedido;

@Stateless
public class PedidoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Pedido pedido) {
		em.persist(pedido);
	}
	
	public void update(Pedido pedido) {
		em.merge(pedido);
	}
	
	public void remove(int id) {
		em.remove(read(id));
	}
	
	public Pedido read(int codigo) {
		Pedido aux = em.find(Pedido.class, codigo);
		return aux;
	}

	public List<Pedido> getPedidos(){
		String jpql = "SELECT p FROM Pedido p";		
		Query query = em.createQuery(jpql, Pedido.class);
		
		List<Pedido> lista = query.getResultList();
		return lista;
	}
}
