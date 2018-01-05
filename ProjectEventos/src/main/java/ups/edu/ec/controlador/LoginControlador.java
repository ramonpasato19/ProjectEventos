package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.hibernate.validator.internal.util.logging.LoggerFactory;

import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.modelo.Asistente;
import ups.edu.ec.modelo.Sesion;


@ManagedBean
@SessionScoped
public class LoginControlador {
	
	
	private Asistente asistente;
	private String correoIngresado;
	private String claveIngresado;
	
	private List<Asistente> listadoLogin;
	
	@Inject
	private AsistenteDAO dao;
	
	@Inject
	private Sesion sesion;
	
	
	public Asistente getAsistente() {
		return asistente;
	}

	public void setAsistente(Asistente asistente) {
		this.asistente = asistente;
	}

	public String getCorreoIngresado() {
		return correoIngresado;
	}

	public void setCorreoIngresado(String correoIngresado) {
		this.correoIngresado = correoIngresado;
	}

	public String getClaveIngresado() {
		return claveIngresado;
	}

	public void setClaveIngresado(String claveIngresado) {
		this.claveIngresado = claveIngresado;
	}

	public List<Asistente> getListadoLogin() {
		return listadoLogin;
	}

	public void setListadoLogin(List<Asistente> listadoLogin) {
		this.listadoLogin = listadoLogin;
	}

	public AsistenteDAO getDao() {
		return dao;
	}

	public void setDao(AsistenteDAO dao) {
		this.dao = dao;
	}

	@PostConstruct
	public void init(){
		asistente = new Asistente();
	
	}
	
	public String listar(){
		
		listadoLogin = dao.getUsuariosLogin(correoIngresado,claveIngresado);
		
		for(int i=0;i<listadoLogin.size();i++){
			if(listadoLogin.get(i).getRol()==1){
				
//				FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuario logeado", "Usuario logeado"));
				
				return "index.jsf";
				
			}else if(listadoLogin.get(i).getRol()==2){
					
					return "index-3";
				}
			
		}
//		FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario ó Contraseña Invalidos!", "Usuario ó Contraseña Invalidos!"));
		return "";
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}	
	
	

}
