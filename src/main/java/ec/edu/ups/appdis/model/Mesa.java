package ec.edu.ups.appdis.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.NamedQueries;

@Entity
@Table(name="TBL_MESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesa.findAll", query = "SELECT m FROM Mesa m")
    , @NamedQuery(name = "Mesa.findByCodigo", query = "SELECT m FROM Mesa m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Mesa.findByNombre", query = "SELECT m FROM Mesa m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Mesa.findByEstado", query = "SELECT m FROM Mesa m WHERE m.estado = :estado")})
public class Mesa implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "mes_codigo")
	private Integer codigo;
	
    @NotNull
    @Column(name = "mes_nombre")
	private String nombre;
	
    @NotNull
    @Column(name = "mes_estado")
	private String estado;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesId")
    private Collection<Cliente> ClientesCollection;
    
    public Mesa() {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@XmlTransient
	public Collection<Cliente> getClientesCollection() {
		return ClientesCollection;
	}

	public void setClientesCollection(Collection<Cliente> clientesCollection) {
		ClientesCollection = clientesCollection;
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
				if (!(object instanceof Mesa)) {
		            return false;
		        }
		        Mesa other = (Mesa) object;
		        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
		            return false;
		        }
		        return true;
	}

	@Override
	public String toString() {
		//return "Mesa [codigo=" + nombre + "]";
		return nombre;
	}

}



