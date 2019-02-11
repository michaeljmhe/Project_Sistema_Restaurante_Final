package ec.edu.ups.appdis.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import ec.edu.ups.appdis.bussiness.ClienteBussiness;
import ec.edu.ups.appdis.model.Cliente;

@ManagedBean
public class ClienteB {

	@Inject
	private ClienteBussiness mBussiness;

	@Inject
	private FacesContext facesContext;

	private Cliente newCliente;
	private List<Cliente> clientes;

	private boolean edit = false;

	@PostConstruct
	public void init() {
		newCliente = new Cliente();
		clientes = mBussiness.getClientes();
	}

	public Cliente getNewCliente() {
		return newCliente;
	}

	public void setNewCliente(Cliente newCliente) {
		this.newCliente = newCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public String guardar() {

		System.out.println(edit);

		try {
			if (edit == true)
				mBussiness.update(newCliente);
			else
				mBussiness.save(newCliente);
			System.out.println("registro guardado");
			return "list-clientes?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String borrar(String id) {
		try {
			mBussiness.delete(id);
			System.out.println("registro eliminado");
			return "list-clientes?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String editar(Cliente cli) {
		newCliente = cli;
		edit = true;
		return "create-cliente";
	}

	public int getMesasCount() {
		return clientes.size();
	}
}