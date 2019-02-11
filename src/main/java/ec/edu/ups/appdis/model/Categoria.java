package ec.edu.ups.appdis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import ec.edu.ups.appdis.dao.CategoriaDAO;

@Entity
@Table(name="TBL_CATEGORIA")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c")
	, @NamedQuery(name = "Categoria.findByCodigo", query = "SELECT c FROM Categoria c WHERE c.codigo = :codigo")
	, @NamedQuery(name = "Categoria.findByNombre", query = "SELECT c FROM Categoria c WHERE c.nombre = :nombre")
	, @NamedQuery(name = "Categoria.findByDescripcion", query = "SELECT c FROM Categoria c WHERE c.descripcion = :descripcion")})
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@Column(name = "cat_codigo")
	private Integer codigo;
	
	@NotNull
	@Size(min = 4, max = 20)
	@Column(name = "cat_nombre")
	private String nombre;

    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "cat_descripcion")
	private String descripcion;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private Collection<Producto> ProductosCollection;
    
    public Categoria() {
    	
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

	@XmlTransient
	public Collection<Producto> getProductosCollection() {
		return ProductosCollection;
	}

	public void setProductosCollection(Collection<Producto> productosCollection) {
		ProductosCollection = productosCollection;
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
		if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
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
