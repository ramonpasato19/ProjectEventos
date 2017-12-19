package ups.edu.ec.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.modelo.Asistente;

@ManagedBean 
@ViewScoped 
public class LoginManagedBean { 
	private AsistenteDAO userDAO = new AsistenteDAO(); 
	private Asistente user = new Asistente(); 
	public String send() 
	{ 
		user = userDAO.getUser(user.getEmail(), user.getPassword()); 
		if (user == null) 
		{ 
			user = new Asistente(); 
					FacesContext.getCurrentInstance().addMessage( 
							null, 
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "User not found!", " Login Error!")); 
			return null; 
			} 
		else { 
			return "index"; 
			} 
		} 
	
		public Asistente getUser()
		{ 
		return user; 
		} 
	
		public void setUser(Asistente user) {
			this.user = user; 
			} 
		
}

