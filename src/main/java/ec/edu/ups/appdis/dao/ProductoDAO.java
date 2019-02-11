package ec.edu.ups.appdis.dao;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import ec.edu.ups.appdis.model.MostrarProductos;
import ec.edu.ups.appdis.model.Producto;

@Stateless
public class ProductoDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Producto producto) {
		em.persist(producto);
	}
	
	public void update(Producto producto) {
		em.merge(producto);
	}
	
	public void remove(int id) {
		em.remove(read(id));
	}
	
	public Producto read(int codigo) {
		Producto aux = em.find(Producto.class, codigo);
		return aux;
	}

	public List<Producto> getProductos(){
		String jpql = "SELECT p FROM Producto p";		
		Query query = em.createQuery(jpql, Producto.class);
		List<Producto> lista = query.getResultList();
		return lista;
	}
	
	public List<MostrarProductos> listadoProductoPorCategoria(int codigo) {
		String nombrePro, descripcionPro;
		double precioPro;
		String jpql = "SELECT p FROM Producto p WHERE p.catId.codigo = ?1";
		Query query = em.createQuery(jpql, Producto.class);
		query.setParameter(1, codigo);
		List<Producto> productos = query.getResultList();
		List<MostrarProductos> mostrar = new ArrayList<>();
		for (Producto producto : productos) {
			MostrarProductos mp = new MostrarProductos();
			nombrePro = producto.getNombre();
			System.out.println("nombre "+ nombrePro);
			descripcionPro = producto.getDescripcion();
			System.out.println("desp "+ descripcionPro);
			precioPro = producto.getPrecio();
			//System.out.println("Total "+ totalSaldo);
			mp.setNombre(nombrePro);
			//mf.setSaldo(factura.getSaldo());
			mp.setDescripcion(descripcionPro);
			mp.setPrecio(precioPro);
			//mf.setNombrecli(factura.getCliente().getNombre());
			mostrar.add(mp);
			
			System.out.println(mostrar.size());
		}
		return mostrar;
	}
	
	public List<Producto> listadoProdPorCat(int codigo) {
		String jpql = "SELECT p FROM Producto p WHERE p.catId.codigo = ?1";
		Query query = em.createQuery(jpql, Producto.class);
		query.setParameter(1, codigo);
		List<Producto> productos = query.getResultList();
		return productos;
	}
	
	public List<Producto> listadoPrecioProductoPedido(int codigo) {
		String jpql = "SELECT p FROM Producto p WHERE p.codigo = ?1";
		Query query = em.createQuery(jpql, Producto.class);
		query.setParameter(1, codigo);
		List<Producto> productos = query.getResultList();
		return productos;
	}
}

