package ec.edu.ups.appdis.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="TBL_CLIENTE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByCedula", query = "SELECT c FROM Cliente c WHERE c.cedula = :cedula")
    , @NamedQuery(name = "Cliente.findByNombre", query = "SELECT c FROM Cliente c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cliente.findByApellido", query = "SELECT c FROM Cliente c WHERE c.apellido = :apellido")
    , @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Cliente.findByCiudad", query = "SELECT c FROM Cliente c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "Cliente.findByEmil", query = "SELECT c FROM Cliente c WHERE c.emil = :emil")
    , @NamedQuery(name = "Cliente.findByFechaNacimeinto", query = "SELECT c FROM Cliente c WHERE c.fechaNacimeinto = :fechaNacimeinto")})
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cli_cedula", length=10)
	private String cedula;
	
	@NotNull
	@Size(min = 4, max = 20)
	@Column(name = "cli_nombre")
	private String nombre;

    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "cli_apellido")
	private String apellido;
	
    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "cli_direccion")
	private String direccion;
	
    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "cli_ciudad")
	private String ciudad;
	
    @NotNull
    @Size(min = 10, max = 12)
    @Digits(fraction = 0, integer = 12)
    @Column(name = "cli_telefono")
	private String telefono;
	
    @NotNull
    @Email
    @Column(name = "cli_email")
	private String emil;
	
    @Temporal(TemporalType.DATE)
    @Column(name = "cli_fecha_nac")
	private Date fechaNacimeinto;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliId", fetch=FetchType.EAGER)
    private Collection<Pedido> pedidosCollection;
    
    @JoinColumn(name="mesa", referencedColumnName="mes_codigo")
    @ManyToOne(optional = false)
    private Mesa mesId;
    
    public Cliente() {
    	
    }
    

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmil() {
		return emil;
	}

	public void setEmil(String emil) {
		this.emil = emil;
	}

	public Date getFechaNacimeinto() {
		return fechaNacimeinto;
	}

	public void setFechaNacimeinto(Date fechaNacimeinto) {
		this.fechaNacimeinto = fechaNacimeinto;
	}
	
	public Mesa getMesId() {
		return mesId;
	}
	public void setMesId(Mesa mesId) {
		this.mesId = mesId;
	}

	@XmlTransient
	public Collection<Pedido> getPedidosCollection() {
		return pedidosCollection;
	}

	public void setPedidosCollection(Collection<Pedido> pedidosCollection) {
		this.pedidosCollection = pedidosCollection;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
	}


	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
	}


	@Override
	public String toString() {
		return nombre;
	}

	
}


