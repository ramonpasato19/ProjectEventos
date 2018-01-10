package ups.edu.ec.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import ups.edu.ec.datos.UsuarioDAO;
import ups.edu.ec.modelo.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioControlador implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7158501497498000006L;
	
	@EJB
	private UsuarioDAO usuariodao;
	
	private Usuario usuario;
	
	public List<Usuario> getUsuarios(){
		return usuariodao.listarTodos();
	}

	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		
	}

	public void salvar() {
		try {
			usuariodao.salvar(usuario);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Exitoso", "Usuario Guardado con Exito"));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario no de a guardado"));
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
