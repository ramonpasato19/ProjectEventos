package ups.edu.ec.service;


import java.util.Date;

import javax.ws.rs.Path;

@Path("pedidos")
public class pedidosService {

	
	
	
	//funciones del metodos
	//funcion para devolver la fecha
	
	@Path("optenerfecha")
		public String getFecha() {
			return ""+new Date();
		}
	
		/*
		//fumncion para devolver suma
	@Path("sumar")	
	public int suma(int a, int b) {
			return a+b;
		}
		*/
}

