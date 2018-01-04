package ups.edu.ec.modelo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class Sesion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Asistente usuario;

	public Asistente getUsuario() {
		return usuario;
	}

	public void setUsuario(Asistente usuario) {
		this.usuario = usuario;
	}
//	
//	public String close(){
//		 System.out.println("cerrando");
//		 
//		 
//	}
	
}