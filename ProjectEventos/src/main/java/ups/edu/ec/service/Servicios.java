package ups.edu.ec.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import ups.edu.ec.controlador.Login;
import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.datos.EventoDAO;
import ups.edu.ec.modelo.Asistente;
import ups.edu.ec.modelo.Evento;

@Path("/evento")
public class Servicios {
	
	@Inject
	private AsistenteDAO asidao;
	@Inject
	private EventoDAO evedao;

	
	@GET
	@Path("/saludo")
	@Produces("application/json")
	public String saludo(@QueryParam ("s") String nombre) {
		return "hola "+ nombre;
	}

	@GET
	@Path("/suma")
	@Produces("application/json")
	public int suma(@QueryParam ("a") int a, @QueryParam ("b")int b) {
		return a+b;
	}
	

	
	@GET
	@Path("/findasistenteid")
	@Produces("application/json")
	public Asistente getAsistenteId(@QueryParam("id") int id){
		Asistente asi=asidao.leer(id);
		System.out.println(asi);
		return asi;
	}
	
	/*
	 * este web service guardar asistente ok *********************************
	 */
	@POST
	@Path("/saveAsistente")
    @Consumes("application/json")
    @Produces("application/json")
	public Response crearAsistente(Asistente asistente) {
		Response.ResponseBuilder builder =null;
		try {
			asidao.guardar(asistente);
			builder = Response.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.build();
		
	}
	
	
	@POST
	@Path("/saveEvento")
    @Consumes("application/json")
    @Produces("application/json")
	public Response crearEvento(Evento evento) {
		Response.ResponseBuilder builder =null;
		try {
			evedao.guardar(evento);
			builder = Response.ok();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return builder.build();
		
	}
	
	
	@POST
	@Path("/guardar")
    @Consumes("application/json")
    @Produces("application/json")
	public Respuesta guardar(Asistente asistente) {
		Respuesta res=new Respuesta();
		try {
			asidao.guardar(asistente);
			res.setCodigo(1);
			res.setMensaje("ok");
			return res;
		} catch (Exception e) {
			res.setCodigo(99);
			res.setMensaje("error general");
			return res;
		}
		
		
	}
	
	
	@GET
	@Path("/listado")
	@Produces("application/json")
	public List<Asistente> listar(){
		return asidao.listadoAsistentes();
	}
	
	/*
	 * este esta funcionando ok *********************************
	 */
	@POST
	@Path("/login")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Asistente> Login(Asistente a){
		//return asidao.login(a.getEmail(), a.getPassword());
		return asidao.login(a.getEmail(), a.getPassword());
	}
	
	
	
	@GET
	@Path("/perfil")
	@Produces("application/json")
	public List<Asistente> correo(@QueryParam("correo") String correo,@QueryParam("clave") String clave){
		return asidao.getUsuariosLogin(correo, clave);
	}
	
	@GET
	@Path("/listareventos")
	@Produces("application/json")
	public List<Evento> getEventos(){
		return evedao.listadoEventos();
	}
	
	
	@GET
	@Path("/listar")
	@Produces("application/json")
	public List<Asistente> getPersonas(){
		return asidao.listadoAsistentes();
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
