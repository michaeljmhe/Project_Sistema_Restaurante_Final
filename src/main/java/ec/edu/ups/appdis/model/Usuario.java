package ec.edu.ups.appdis.model;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Usuario {
	
	private String usuario;
	
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
