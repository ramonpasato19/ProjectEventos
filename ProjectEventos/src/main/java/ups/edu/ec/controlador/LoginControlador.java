package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;


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
		
		//System.out.println(getCorreoIngresado()+"dddddddddddddddddd");
		listadoLogin = dao.getUsuariosLogin(correoIngresado,claveIngresado);
		for(int i=0;i<listadoLogin.size();i++){
			System.out.println(listadoLogin.get(i).getEmail());
			System.out.println(listadoLogin.get(i).getRol());
			if(listadoLogin.get(i).getRol()==1){
				
				System.out.println("administrador");
				return "index";
			}else
				if(listadoLogin.get(i).getRol()==2){
					
					return "index";
				}
		}
		return null;
	}
	
	
	
	public String login(){
		Asistente usuario = (Asistente) dao.getUsuariosLogin(correoIngresado, claveIngresado);
		if(usuario!=null){
			sesion.setUsuario(usuario);
			listadoLogin = dao.getUsuariosLogin(correoIngresado,claveIngresado);
			for(int i=0;i<listadoLogin.size();i++){
				System.out.println(listadoLogin.get(i).getEmail());
				System.out.println(listadoLogin.get(i).getRol());
				if(listadoLogin.get(i).getRol()==1){
					
					System.out.println("administrador");
					return "principal_administrador";
				}else
					if(listadoLogin.get(i).getRol()==2){
						
						return "principal_huecas";
					}
			}
		}
		return null;
	}
	
	
	
	
	
	

}
