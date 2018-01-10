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

import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.modelo.Asistente;

@Path("/evento")
public class Servicios {
	
	@Inject
	private AsistenteDAO asidao;

	
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
	@Path("/listar")
	@Produces("application/json")
	public List<Asistente> getPersonas(){
		return asidao.listadoAsistentes();
	}

	
	@GET
	@Path("/findasistenteid")
	@Produces("application/json")
	public Asistente getAsistenteId(@QueryParam("id") int id){
		Asistente asi=asidao.leer(id);
		System.out.println(asi);
		return asi;
	}
	
	
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
