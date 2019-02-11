package ec.edu.ups.appdis.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TBL_PEDIDO")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue
	@Column(name = "ped_codigo")
	private Integer codigo;
	
	@NotNull
    @Column(name = "ped_numero")
	private int numero;
	
    @Temporal(TemporalType.DATE)
    @Column(name = "ped_fecha")
	private Date fecha;
	
    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "ped_estado")
	private String estado;

   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "")
    
    @JoinColumn(name="producto", referencedColumnName="pro_codigo")
    @ManyToOne(optional = false)
    private Producto prodId;
	
    
    @JoinColumn(name="cliente", referencedColumnName="cli_cedula")
    @ManyToOne(optional = false)
    private Cliente cliId;
    
    public Pedido () {
    	
    }
    
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Producto getProdId() {
		return prodId;
	}

	public void setProdId(Producto prodId) {
		this.prodId = prodId;
	}

	public Cliente getCliId() {
		return cliId;
	}

	public void setCliId(Cliente cliId) {
		this.cliId = cliId;
	}

}
