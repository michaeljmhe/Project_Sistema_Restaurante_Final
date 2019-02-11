package ec.edu.ups.appdis.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.appdis.model.Producto;

@Stateless
public class ProductosFacade extends AbstractFacade<Producto> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Producto.class);
    }
    
}
