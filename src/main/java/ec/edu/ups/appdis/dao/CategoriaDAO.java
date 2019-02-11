package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.model.Categoria;

@Stateless
public class CategoriaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Categoria categoria) {
		em.persist(categoria);
	}
	
	public void update(Categoria categoria) {
		em.merge(categoria);
	}
	
	public void remove(int id) {
		em.remove(read(id));
	}
	
	public Categoria read(int codigo) {
		Categoria aux = em.find(Categoria.class, codigo);
		return aux;
	}

	public List<Categoria> getCategorias(){
		String jpql = "SELECT c FROM Categoria c";		
		Query query = em.createQuery(jpql, Categoria.class);
		
		List<Categoria> lista = query.getResultList();
		return lista;
	}
}
