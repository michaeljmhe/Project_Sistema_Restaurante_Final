package ec.edu.ups.appdis.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.ups.appdis.dao.MesaDAO;
import ec.edu.ups.appdis.model.Cliente;
import ec.edu.ups.appdis.model.Mesa;
import ec.edu.ups.appdis.model.Producto;

@Stateless
public class MesaBussiness {
	
	@Inject
	private MesaDAO dao;
	
	public void save(Mesa mesa) throws Exception {
		Mesa aux = dao.read(mesa.getCodigo());
		if(aux!=null)
			throw new Exception("Mesa ya registrada");
		else
			dao.insert(mesa);
	}
	
	public List<Mesa> getMesas(){
		System.out.println("mesasss.!! "+ dao.getMesas());
		return dao.getMesas();
	}
	
	public void delete(int id) throws Exception {
		Mesa aux = dao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.remove(id);
	}
	
	public void update(Mesa mesa) throws Exception {
		Mesa aux = dao.read(mesa.getCodigo());
		System.out.println("AUXXXXX "+ aux);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.update(mesa);
	}
}
