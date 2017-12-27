package ups.edu.ec.service;



import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/ejemplos")
public class ejemplos {

	
	//get pu post set recuperar datos// consumidospoor navegador web
	@GET
	@Path("/saludo")
	//fomarto devolver el saludo o resutlado
	@Produces("application/json")
	public String saludo(@QueryParam ("n") String nombre){
			return "hola"+nombre;
	}
	
	//pedios-jpa/srv/ejemplos
	
	@GET
	@Path("/saludo/{nombre}/{edad}")
	//fomarto devolver el saludo o resutlado
	@Produces("application/json")
	public String saludo2(@PathParam ("nombre") String nombre, @PathParam ("edad") int edad){
			return "hola"+nombre + "edad" +edad + "anios";
	}
	//saludo/juan/19
	
	@GET
	@Path("/suma")
	@Produces("application/json")
	public int suma(@QueryParam ("a") int a, @QueryParam ("b") int b) {
		return a+b;
	}
	
	
	
	
}
