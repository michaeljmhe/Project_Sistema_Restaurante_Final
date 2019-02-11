package ec.edu.ups.appdis.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.appdis.model.Pedido;

@Stateless
public class PedidoFacade extends AbstractFacade<Pedido> {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public  PedidoFacade() {
        super(Pedido.class);
    }
    
}
