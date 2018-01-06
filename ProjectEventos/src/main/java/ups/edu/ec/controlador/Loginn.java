package ups.edu.ec.controlador;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.modelo.Asistente;
import ups.edu.ec.modelo.Sesion;

@ManagedBean
public class Loginn {

	@Inject
	private AsistenteDAO dao;
	
	@Inject
	private Sesion sesion;
	
	private String usuario;
	private String password;
	
	
	public AsistenteDAO getDao() {
		return dao;
	}
	public void setDao(AsistenteDAO dao) {
		this.dao = dao;
	}
	public Sesion getSesion() {
		return sesion;
	}
	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}
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
