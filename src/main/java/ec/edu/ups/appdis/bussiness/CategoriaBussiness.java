package ec.edu.ups.appdis.bussiness;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.dao.CategoriaDAO;
import ec.edu.ups.appdis.model.Categoria;

@Stateless
public class CategoriaBussiness {
	
	@Inject
	private CategoriaDAO dao;
	
	public void save(Categoria categoria) throws Exception {
		Categoria aux = dao.read(categoria.getCodigo());
		if(aux!=null)
			throw new Exception("Categoria ya registrada");
		else
			dao.insert(categoria);
	}
	
	public List<Categoria> getCategorias(){
		return dao.getCategorias();
	}
	
	public void delete(int id) throws Exception {
		Categoria aux = dao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.remove(id);
	}
	
	public void update(Categoria categoria) throws Exception {
		Categoria aux = dao.read(categoria.getCodigo());
		System.out.println("AUXXXXX "+ aux);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.update(categoria);
	}
}

