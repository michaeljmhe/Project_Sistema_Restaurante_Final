package ec.edu.ups.appdis.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.appdis.model.Cliente;

@Stateless
public class ClientesFacade extends AbstractFacade<Cliente> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public  ClientesFacade() {
        super(Cliente.class);
    }
    
}

