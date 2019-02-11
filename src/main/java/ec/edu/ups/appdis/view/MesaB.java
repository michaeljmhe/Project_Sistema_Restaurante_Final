package ec.edu.ups.appdis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussiness.MesaBussiness;
import ec.edu.ups.appdis.model.Mesa;

@ManagedBean
public class MesaB {

	@Inject
	private MesaBussiness mBussiness;

	@Inject
	private FacesContext facesContext;

	private Mesa newMesa;
	private List<Mesa> mesas;

	private boolean edit = false;

	@PostConstruct
	public void init() {
		newMesa = new Mesa();
		mesas = mBussiness.getMesas();
	}

	public Mesa getNewMesa() {
		return newMesa;
	}

	public void setNewMesa(Mesa newMesa) {
		this.newMesa = newMesa;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
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
				mBussiness.update(newMesa);
			else
				mBussiness.save(newMesa);
			System.out.println("registro guardado");
			return "list-mesas?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String borrar(int id) {
		try {
			mBussiness.delete(id);
			System.out.println("registro eliminado");
			return "list-mesas?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String editar(Mesa mes) {
		newMesa = mes;
		edit = true;
		return "create-mesa";
	}

	public int getMesasCount() {
		return mesas.size();
	}
}