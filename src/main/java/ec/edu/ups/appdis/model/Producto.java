package ec.edu.ups.appdis.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="TBL_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodigo", query = "SELECT p FROM Producto p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByCantidad", query = "SELECT p FROM Producto p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")})
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pro_codigo")
	private Integer codigo;
	
	@NotNull
	@Size(min = 4, max = 20)
	@Column(name = "pro_nombre")
	private String nombre;

    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "pro_descripcion")
	private String descripcion;
    
    @NotNull
    @Column(name = "pro_cantidad")
	private int cantidad;
    
    @NotNull
    @Column(name = "pro_precio")
	private double precio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prodId", fetch=FetchType.EAGER)
    private Collection<Pedido> pedidosCollection;
    
    @JoinColumn(name="categoria", referencedColumnName="cat_codigo")
    @ManyToOne(optional = false)
    private Categoria catId;

    public Producto () {
    	
    }

	public Integer getCodigo() {
		return codigo;
	}



	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@XmlTransient
	public Collection<Pedido> getPedidosCollection() {
		return pedidosCollection;
	}

	public void setPedidosCollection(Collection<Pedido> pedidosCollection) {
		this.pedidosCollection = pedidosCollection;
	}

	public Categoria getCatId() {
		return catId;
	}

	public void setCatId(Categoria catId) {
		this.catId = catId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO Auto-generated method stub
		if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
	}
	
	
	@Override
	public String toString() {
		return nombre;
	}	
    
}
