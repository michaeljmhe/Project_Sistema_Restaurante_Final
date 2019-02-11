package ec.edu.ups.appdis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="TBL_REGISTROUSER")
public class Login {
	
	@Id
	@Column(name = "log_user")
	private String usuario;
	
	@NotNull
	@Size(min = 6, max = 20)
	@Column(name = "log_password")
	private String password;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		

}
