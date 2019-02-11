package ec.edu.ups.appdis.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.dao.CategoriaDAO;
import ec.edu.ups.appdis.dao.PedidoDAO;
import ec.edu.ups.appdis.model.Categoria;
import ec.edu.ups.appdis.model.Pedido;

@Stateless
public class PedidoBussiness {
	
	@Inject
	private PedidoDAO dao;
	
	public void save(Pedido pedido) throws Exception {
		Pedido aux = dao.read(pedido.getCodigo());
		if(aux!=null)
			throw new Exception("Pedido ya registrada");
		else
			dao.insert(pedido);
	}
	
	public List<Pedido> getPedidos(){
		return dao.getPedidos();
	}
	
	public void delete(int id) throws Exception {
		Pedido aux = dao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.remove(id);
	}
	
	public void update(Pedido pedido) throws Exception {
		Pedido aux = dao.read(pedido.getCodigo());
		System.out.println("AUXXXXX "+ aux);
		if(aux==null)
			throw new Exception("Registro no existeeeee");
		else
			dao.update(pedido);
	}
}
