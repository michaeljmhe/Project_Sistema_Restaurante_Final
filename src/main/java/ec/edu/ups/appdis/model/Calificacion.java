package ec.edu.ups.appdis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tbl_calificacion")
public class Calificacion implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column (name="cal_codigo")
	private Integer codigo;
	
	@NotNull
	@Column (name="cal_voto")
	private int voto;
	
	@NotNull
	@Column (name="cal_comentario")
	private String comentario;

	//bi-directional many-to-one association to Producto
    @JoinColumn(name="producto", referencedColumnName="pro_codigo")
    @ManyToOne(optional = false)
    private Producto prodCalId;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Producto getProdCalId() {
		return prodCalId;
	}

	public void setProdCalId(Producto prodCalId) {
		this.prodCalId = prodCalId;
	}
	
 }