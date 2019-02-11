package ec.edu.ups.appdis.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.appdis.model.Categoria;


@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {
	
    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public  CategoriaFacade() {
        super(Categoria.class);
    }

}
