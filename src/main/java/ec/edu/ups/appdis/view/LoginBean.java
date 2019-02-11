package ec.edu.ups.appdis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussiness.LoginBussiness;
import ec.edu.ups.appdis.model.Login;
import ec.edu.ups.appdis.model.Producto;

@ManagedBean
public class LoginBean {
	
	String user;
	String pass;

	@Inject
	private LoginBussiness lBussiness;
	
	@Inject
	private FacesContext facesContext;
	
	private Login newLogin;
	
	private List<Login> listadoLogin;
	
	@PostConstruct
	public void init() {
		newLogin = new Login();
	}
	
	public Login getNewLogin() {
		return newLogin;
	}

	public void setNewLogin(Login newLogin) {
		this.newLogin = newLogin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String guardar() {
		
		try {
			lBussiness.save(newLogin);
			System.out.println("registro guardado");
			return "login?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(
            		FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
            
            
			e.printStackTrace();
		}
		
		return null;
	}

	public String guardar22() {
	
		try {
			System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBB");
			boolean aux = lBussiness.getUser(user, pass);
			System.out.println("auxxx.....!! "+ aux);
			if (aux == true) {
				System.out.println("LOGIN CORRECTO");
				return "list-categorias?faces-redirect=true";
				
			}else {
				System.out.println("LOGIN Incorrecto");	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(
            		FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
            
            
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String paginaSiguiente() {
		return "create-cliente";
		
	}
	
	@SuppressWarnings({"rawtypes" })
	public String listar(){
		
		listadoLogin = lBussiness.getUsuariosLogin(user, pass);	
		System.out.println("liatado : "+ listadoLogin.size());
		int listVALOR = listadoLogin.size();
			
			//facesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", listadoLogin);
		
		for(int i=0;i<listadoLogin.size();i++){
			System.out.println(listadoLogin.get(i).getUsuario() + " usuario");
			System.out.println(listadoLogin.get(i).getPassword() + " pasword");
			if(listadoLogin.get(i).getUsuario().equalsIgnoreCase("Administrador") && listadoLogin.get(i).getPassword().equals("Matapayazos31")) {
				return "principal-administrador?faces-redirect=true";
			}else if(listadoLogin.get(i).getUsuario().equalsIgnoreCase(user) && listadoLogin.get(i).getPassword().equals(pass)){
				System.out.println("administrador");
				facesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", listadoLogin);
				return "list-categorias-usuario?faces-redirect=true";
			}
		//}
				
		}if(listVALOR == 0) {
			System.out.println("CADENA VACIAAAA..!!");
			facesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso..!",
                                "Credenciales Incorrectas!"));
		}
		
		return null;
		
	}
	
	
}
