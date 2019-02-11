package ec.edu.ups.appdis.bussiness;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.ups.appdis.dao.ClienteDAO;
import ec.edu.ups.appdis.model.Cliente;

@Stateless
public class ClienteBussiness {
	
	@Inject
	private ClienteDAO dao;
	
	public void save(Cliente cliente) throws Exception {
		Cliente aux = dao.read(cliente.getCedula());
		if(aux!=null)
			throw new Exception("Producto ya registrada");
		else
			dao.insert(cliente);
	}
	
	public List<Cliente> getClientes(){
		return dao.getClientes();
	}
	
	public void delete(String id) throws Exception {
		Cliente aux = dao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.remove(id);
	}
	
	public void update(Cliente cliente) throws Exception {
		Cliente aux = dao.read(cliente.getCedula());
		System.out.println("AUXXXXX "+ aux);
		if(aux==null)
			throw new Exception("Registro no existeeeee");
		else
			dao.update(cliente);
	}
}