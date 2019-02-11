package ec.edu.ups.appdis.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.appdis.model.Mesa;

@Stateless
public class MesaFacade extends AbstractFacade<Mesa> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public  MesaFacade() {
        super(Mesa.class);
    }
    
}
