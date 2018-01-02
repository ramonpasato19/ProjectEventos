package ups.edu.ec.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.modelo.Asistente;

@Path("/event")
public class Servicios {
	
	@Inject
	private AsistenteDAO daoasi;
	//cuatro formas de ser consumido
	
	/*
	 * (bien)
	 */
	
	@GET
	@Path("/saludo")
	@Produces("application/json")
	public String saludo(@QueryParam ("s") String nombre) {
		return "hola "+ nombre;
	}
	
	/*
	 * (bien)
	 */
	
	@GET
	@Path("/suma")
	@Produces("application/json")
	public int suma(@QueryParam ("a") int a, @QueryParam ("b")int b) {
		return a+b;
	}
	
	
	//Datos datos = new Datos();
	
	@POST
	@Path("/guardar")
	@Produces("application/json")
	//@Consumes("application/json")
	public Respuesta guardar( Asistente usuario){
		//System.out.println(httpHeaders.toString()+" LAS "+httpHeaders.getHeaderString("Authorization"));
	//	String auth = httpHeaders.getHeaderString("Authorization");
	//	System.out.println("Las credenciales son: {"+ auth+"}" );
	//	System.out.println(httpHeaders.toString()+" LAS "+httpHeaders.getHeaderString("Authorization"));
		Respuesta res=new Respuesta();
		try{
			daoasi.guardar(usuario);
			res.setCodigo(1);
			res.setMensaje("Lo has Logrado");
		}catch (Exception e) {
			res.setCodigo(99);
			res.setMensaje("Error");
		}
		return res;
	}
	/*
	 * este web servicios lista a todos los asistentes (bien)
	 */
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Asistente> getPersonas(){
		return daoasi.listadoAsistentes();
	}
	
	/*
	 * este web servicio lista por id del asistente (bien)
	 */
	
	@GET
	@Path("/asistenteid")
	@Produces("application/json")
	public Asistente getAsistenteId(@QueryParam("id") int id){
		Asistente asi=daoasi.leer(id);
		System.out.println(asi);
		return asi;
	}
	
	
//	@GET
//	@Path("/asistentes")
//	@Produces("application/json")
//	public List<Asistente> getAsistente(){
//		List<Asistente> asi=daoasi.listadoCredenciales();
//		System.out.println(asi);
//		return asi;
//	}
//	
	/*
	@GET
	@Path("perfil")
	@Produces("application/json")
	public List<Asistente> correo(@QueryParam("correo") String correo,@QueryParam("clave") String clave){
		return dao.getUsuariosLogin(correo, clave);
	}
	
	@GET
	@Path("perfilEditar")
	@Produces("application/json")
	public Asistente perfil(@QueryParam("correo") int correo){
		return dao.leer(correo);
	}
	
	*/
	
	
}
