package ec.edu.ups.appdis.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.appdis.model.Calificacion;

@Stateless
public class CalificacionDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Calificacion calificacion) {
		em.persist(calificacion);
	}
	
	public void update(Calificacion calificacion) {
		em.merge(calificacion);
	}
	
	public void remove(int id) {
		em.remove(read(id));
	}
	
	public Calificacion read(int codigo) {
		Calificacion aux = em.find(Calificacion.class, codigo);
		return aux;
	}

	public List<Calificacion> getCalificaciones(){
		String jpql = "SELECT c FROM Calificacion c";		
		Query query = em.createQuery(jpql, Calificacion.class);
		
		List<Calificacion> lista = query.getResultList();
		return lista;
	}
}