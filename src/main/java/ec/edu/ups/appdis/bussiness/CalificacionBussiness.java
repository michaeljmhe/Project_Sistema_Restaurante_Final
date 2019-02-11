package ec.edu.ups.appdis.bussiness;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import ec.edu.ups.appdis.dao.CalificacionDAO;
import ec.edu.ups.appdis.model.Calificacion;

@Stateless
public class CalificacionBussiness {
	
	@Inject
	private CalificacionDAO dao;
	
	public void save(Calificacion calificacion) throws Exception {
		Calificacion aux = dao.read(calificacion.getCodigo());
		if(aux!=null)
			throw new Exception("Calificacion ya registrada");
		else
			dao.insert(calificacion);
	}
	
	public List<Calificacion> getCalificaciones(){
		return dao.getCalificaciones();
	}
	
	public void delete(int id) throws Exception {
		Calificacion aux = dao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.remove(id);
	}
	
	public void update(Calificacion calificacion) throws Exception {
		Calificacion aux = dao.read(calificacion.getCodigo());
		System.out.println("AUXXXXX "+ aux);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			dao.update(calificacion);
	}
}